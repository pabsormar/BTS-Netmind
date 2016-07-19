package com.bts.android.verologu.androidfinalassigment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bts.android.verologu.androidfinalassigment.adapter.MusicListAdapter;
import com.bts.android.verologu.androidfinalassigment.base.BaseFragment;
import com.bts.android.verologu.androidfinalassigment.model.Song;
import com.bts.android.verologu.androidfinalassigment.model.SongList;
import com.google.android.gms.maps.model.LatLng;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by verologu on 23/04/16.
 */
public class MusicListFragment extends BaseFragment {

    private ListView musicList;
    private MusicListAdapter musicListAdapter;
    private SongList songList;
    private AdapterView.OnItemClickListener onSongClickListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_music_player_list, container, false);
        initListeners();
        initComponents();
        readArguments();
        return rootView;
    }

    @Override
    protected void readArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String songTitle = arguments.getString("song_title");
            if (songTitle != null) {
                Song song = getSongByTitle(songTitle);
                showSongDetail(song);
            }
        }
    }

    private Song getSongByTitle(String songTitle) {
        for (Song song : songList.getSongs()) {
            if (songTitle.equals(song.getTitle())) {
                return song;
            }
        }

        return null;
    }

    @Override
    protected void initListeners() {
        onSongClickListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showSongDetail(songList.getSongs().get(position));
            }
        };
    }

    private void showSongDetail(Song song) {
        Bundle args = new Bundle();
        args.putParcelable("song", song);
        args.putParcelable("song_list", songList);

        Fragment fragment = new MusicPlayerFragment();
        fragment.setArguments(args);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_content, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack("music_player");
        transaction.commit();
    }

    @Override
    protected void initComponents() {
        musicList = (ListView) rootView.findViewById(R.id.fragment_music_player_list_lv);

        loadData();
        musicListAdapter = new MusicListAdapter(getActivity(), songList.getSongs());
        musicList.setAdapter(musicListAdapter);
        musicList.setOnItemClickListener(onSongClickListener);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        if (fab != null) {
            fab.setVisibility(View.GONE);
        }
    }

    private void loadData() {
        songList = new SongList();

        ArrayList<Song> songs = new ArrayList<>();

        Field[] rawSongs = R.raw.class.getFields();

        Song song;
        String title;
        for (int i = 0; i < rawSongs.length; i++) {
            song = new Song();

            title = rawSongs[i].getName();
            if (title.startsWith("b")) {
                song.setCountry(getCountry(title));
                song.setTitle(title);
                song.setDuration(getDuration(title));
                song.setDetails(getDetails(title));
                song.setColor(getColor(title));
                song.setLatLng(getLatLng(title));

                songs.add(song);
            }
        }

        songList.setSongs(songs);
    }

    private String getCountry(String songTitle) {
        String country = "";
        switch (songTitle) {
            case "bensoundbrazilsamba": country = "Brazil";
                break;
            case "bensoundcountryboy": country = "USA";
                break;
            case "bensoundindia": country = "India";
                break;
            case "bensoundlittleplanet": country = "Iceland";
                break;
            case "bensoundpsychedelic": country = "South Korea";
                break;
            case "bensoundrelaxing": country = "Indonesia";
                break;
            case "bensoundtheelevatorbossanova": country = "Brazil";
                break;
            default:
                break;
        }

        return country;
    }

    private String getDuration(String songTitle) {
        int songIdentifier = getActivity().getResources().getIdentifier(songTitle, "raw",
                getActivity().getPackageName());
        MediaPlayer mp = MediaPlayer.create(getActivity(), songIdentifier);
        return formatDuration(mp.getDuration());
    }

    private String getDetails(String songTitle) {
        String details = "";

        switch (songTitle) {
            case "bensoundbrazilsamba": details = "Samba is a Brazilian musical genre and dance " +
                    "style, with its roots in Africa via the West African slave trade and African " +
                    "religious traditions, particularly of Angola.";
                break;
            case "bensoundcountryboy": details = "Country music is a genre of American popular music" +
                    " that originated in the Southern United States in the 1920s.";
                break;
            case "bensoundindia": details = "The music of India includes multiple varieties of folk " +
                    "music, pop, and Indian classical music. India's classical music tradition, " +
                    "including Hindustani music and Carnatic, has a history spanning millennia and " +
                    "developed over several eras.";
                break;
            case "bensoundlittleplanet": details = "The music of Iceland includes vibrant folk and " +
                    "pop traditions. Well-known artists from Iceland include medieval music group " +
                    "Voces Thules, alternative rock band The Sugarcubes, singers Björk and Emiliana " +
                    "Torrini, post-rock band Sigur Rós and indie folk/indie pop band Of Monsters and " +
                    "Men.";
                break;
            case "bensoundpsychedelic": details = "The Music of South Korea has evolved over the " +
                    "course of the decades since the end of the Korean War, and has its roots in the " +
                    "music of the Korean people, who have inhabited the Korean peninsula for over a " +
                    "millennium. Contemporary South Korean music can be divided into three different " +
                    "main categories: Traditional Korean folk music, popular music, or K- pop, and " +
                    "Western-influenced non-popular music.";
                break;
            case "bensoundrelaxing": details = "The music of Indonesia demonstrates its cultural " +
                    "diversity, the local musical creativity, as well as subsequent foreign musical " +
                    "influences that shaped contemporary music scenes of Indonesia. Nearly thousands " +
                    "of Indonesian islands having its own cultural and artistic history and " +
                    "character.";
                break;
            case "bensoundtheelevatorbossanova": details = "Samba is a Brazilian musical genre " +
                    "and dance style, with its roots in Africa via the West African slave trade " +
                    "and African religious traditions, particularly of Angola.";
                break;
            default:
                break;
        }

        return details;
    }

    private String getColor(String songTitle) {
        String color = "#fff";

        switch (songTitle) {
            case "bensoundbrazilsamba": color = "#C33C3C";
                break;
            case "bensoundcountryboy": color = "#BAC33C";
                break;
            case "bensoundindia": color = "#3CC3A1";
                break;
            case "bensoundlittleplanet": color = "#3CC33C";
                break;
            case "bensoundpsychedelic": color = "#8D3CC3";
                break;
            case "bensoundrelaxing": color = "#F2CD5C";
                break;
            case "bensoundtheelevatorbossanova": color = "#ECA2D6";
                break;
            default:
                break;
        }

        return color;
    }

    private LatLng getLatLng(String songTitle) {
        LatLng latlng = null;

        switch (songTitle) {
            case "bensoundbrazilsamba":
            case "bensoundtheelevatorbossanova": latlng = new LatLng(-22.9103552,-43.7285339);
                break;
            case "bensoundcountryboy": latlng = new LatLng(31.1006408,-104.5723908);
                break;
            case "bensoundindia": latlng = new LatLng(28.6457559,76.8105571);
                break;
            case "bensoundlittleplanet": latlng = new LatLng(64.1325246,-21.9925244);
                break;
            case "bensoundpsychedelic": latlng = new LatLng(37.5652894,126.8494632);
                break;
            case "bensoundrelaxing": latlng = new LatLng(-6.2293867,106.689429);
                break;
            default:
                break;
        }

        return latlng;
    }

    private String formatDuration(int durationMillis) {
        long millisecondsToMinutes = TimeUnit.MILLISECONDS.toMinutes(durationMillis);

        return String.format("%02d:%02d",
                millisecondsToMinutes,
                TimeUnit.MILLISECONDS.toSeconds(durationMillis) -
                        TimeUnit.MINUTES.toSeconds(millisecondsToMinutes)
        );
    }
}
