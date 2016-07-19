package com.bts.android.verologu.androidfinalassigment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bts.android.verologu.androidfinalassigment.R;
import com.bts.android.verologu.androidfinalassigment.model.Song;

import java.util.List;

/**
 * Created by verologu on 23/04/16.
 */
public class MusicListAdapter extends BaseAdapter {

    private Context context;
    private List<Song> songs;

    public MusicListAdapter(Context context, List<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int position) {
        return songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view;
        if (convertView == null) {
            view = inflater.inflate(R.layout.view_music_list_item, null);
        } else {
            view = convertView;
        }

        TextView title = (TextView) view.findViewById(R.id.view_music_list_item_title_tv);
        TextView country = (TextView) view.findViewById(R.id.view_music_list_item_country_tv);
        TextView duration = (TextView) view.findViewById(R.id.view_music_list_item_duration_tv);

        Song song = songs.get(position);

        if (title != null) {
            title.setText(song.getTitle());
        }

        if (country != null) {
            country.setText(song.getCountry());
        }

        if (duration != null) {
            duration.setText(song.getDuration());
        }

        return view;
    }
}
