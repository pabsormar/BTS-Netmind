package com.bts.android.verologu.androidfinalassigment;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bts.android.verologu.androidfinalassigment.base.BaseFragment;
import com.bts.android.verologu.androidfinalassigment.model.Song;
import com.bts.android.verologu.androidfinalassigment.model.SongList;

import java.util.ArrayList;

/**
 * Created by verologu on 17/04/16.
 */
public class MusicPlayerFragment extends BaseFragment {

    private Song currentSong;
    private SongList songs;
    private int currentSongPositionOnPause = -1;

    private TextView title;
    private TextView songTitle;
    private TextView country;
    private TextView songCountry;
    private TextView details;
    private TextView songDetails;
    private ImageView play;
    private ImageView pause;
    private ImageView next;
    private ImageView previous;
    private LinearLayout container;
    private ScrollView containerScroll;

    private MediaPlayer mediaPlayer;
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_music_player, container, false);
        readArguments();
        initComponents();
        initMediaPlayer();
        initListeners();
        loadData();
        return rootView;
    }

    @Override
    protected void readArguments() {
        Bundle arguments = getArguments();
        currentSong = (Song) arguments.getParcelable("song");
        songs = (SongList) arguments.getParcelable("song_list");
    }

    @Override
    protected void initComponents() {
        containerScroll = (ScrollView) rootView.findViewById(R.id.fragment_music_player_container_sv);
        container = (LinearLayout) rootView.findViewById(R.id.fragment_music_player_container_ll);

        title = (TextView) rootView.findViewById(R.id.fragment_music_player_title_tv);
        songTitle = (TextView) rootView.findViewById(R.id.fragment_music_player_song_title_tv);
        country = (TextView) rootView.findViewById(R.id.fragment_music_player_country_tv);
        songCountry = (TextView) rootView.findViewById(R.id.fragment_music_player_song_country_tv);
        details = (TextView) rootView.findViewById(R.id.fragment_music_player_details_tv);
        songDetails = (TextView) rootView.findViewById(R.id.fragment_music_player_song_details_tv);
        play = (ImageView) rootView.findViewById(R.id.content_music_player_play_iv);
        pause = (ImageView) rootView.findViewById(R.id.content_music_player_pause_iv);
        next = (ImageView) rootView.findViewById(R.id.content_music_player_next_iv);
        previous = (ImageView) rootView.findViewById(R.id.content_music_player_previous_iv);

        fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        if (fab != null) {
            fab.setVisibility(View.VISIBLE);
        }

        title.setText("Title:");
        country.setText("Country:");
        details.setText("Details:");
    }

    @Override
    protected void initMediaPlayer() {
        int songIdentifier = getActivity().getResources().getIdentifier(currentSong.getTitle(),
                "raw", getActivity().getPackageName());
        mediaPlayer = MediaPlayer.create(getActivity(), songIdentifier);
    }

    @Override
    protected void initListeners() {
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSong();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseSong();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextSong();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousSong();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                currentSongPositionOnPause = -1;
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate();
            }
        });
    }

    private void navigate() {
        Bundle args = new Bundle();
        args.putParcelable("song", currentSong);

        Fragment fragment = new MapFragment();
        fragment.setArguments(args);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_content, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack("music_player");
        transaction.commit();
    }

    private void playSong() {
        if (mediaPlayer != null) {
            if (currentSongPositionOnPause != -1) {
                mediaPlayer.start();
            } else {
                int songIdentifier = getActivity().getResources().getIdentifier(currentSong.getTitle(),
                        "raw", getActivity().getPackageName());

                PlayOnBackground playOnBackground = new PlayOnBackground();
                playOnBackground.execute(songIdentifier);

                showNotification();
            }
        }
    }

    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity())
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setContentTitle(currentSong.getTitle())
                .setContentText(currentSong.getDuration());

        NotificationCompat.BigTextStyle bigTextStyle =
                new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(currentSong.getDetails());
        // Moves the expanded layout object into the notification object.
        builder.setStyle(bigTextStyle);


        Intent resultIntent = new Intent(getActivity(), MusicPlayerActivity.class);
        resultIntent.putExtra("notification_song_title", currentSong.getTitle());
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager =
                (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = builder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(1, notification);
    }

    private void pauseSong() {
        if (mediaPlayer != null) {
            currentSongPositionOnPause = mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
        }
    }

    private void nextSong() {
        pauseSong();
        currentSongPositionOnPause = -1;
        mediaPlayer = null;

        currentSong = getNextSong();
        initMediaPlayer();
        loadData();
        playSong();
    }

    private void previousSong() {
        pauseSong();
        currentSongPositionOnPause = -1;
        mediaPlayer = null;

        currentSong = getPreviousSong();
        initMediaPlayer();
        loadData();
        playSong();
    }

    private void loadData() {
        songTitle.setText(currentSong.getTitle());
        songCountry.setText(currentSong.getCountry());
        songDetails.setText(currentSong.getDetails());
        container.setBackgroundColor(Color.parseColor(currentSong.getColor()));
        containerScroll.setBackgroundColor(Color.parseColor(currentSong.getColor()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null) {
            mediaPlayer.pause();
            mediaPlayer = null;
        }
    }

    private Song getNextSong() {
        Song song;
        int nextPosition = 0;
        ArrayList<Song> songsArray = songs.getSongs();
        for (int i = 0; i < songsArray.size(); i++) {
            song = songsArray.get(i);
            if (currentSong.getTitle().equals(song.getTitle())) {
                nextPosition = i + 1;
                break;
            }
        }

        if (nextPosition >= songsArray.size()) {
            nextPosition = songsArray.size() - 1;
        }

        return songsArray.get(nextPosition);
    }

    private Song getPreviousSong() {
        Song song;
        int previousPosition = 0;
        ArrayList<Song> songsArray = songs.getSongs();
        for (int i = 0; i < songsArray.size(); i++) {
            song = songsArray.get(i);
            if (currentSong.getTitle().equals(song.getTitle())) {
                previousPosition = i - 1;
                break;
            }
        }

        if (previousPosition < 1) {
            previousPosition = 0;
        }

        return songsArray.get(previousPosition);
    }

    public class PlayOnBackground extends AsyncTask<Integer, Void, Void> {

        @Override
        protected Void doInBackground(Integer... params) {
            int songToPlayIdentifier = params[0];
            mediaPlayer = MediaPlayer.create(getActivity(), songToPlayIdentifier);
            mediaPlayer.start();
            return null;
        }
    }
}
