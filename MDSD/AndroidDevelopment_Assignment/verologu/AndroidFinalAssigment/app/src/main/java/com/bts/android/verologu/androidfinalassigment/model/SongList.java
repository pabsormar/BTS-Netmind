package com.bts.android.verologu.androidfinalassigment.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by verologu on 30/04/16.
 */
public class SongList implements Parcelable {

    private ArrayList<Song> songs;

    public SongList() {
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(songs);
    }

    protected SongList(Parcel in) {
        this.songs = in.createTypedArrayList(Song.CREATOR);
    }

    public static final Creator<SongList> CREATOR = new Creator<SongList>() {
        @Override
        public SongList createFromParcel(Parcel source) {
            return new SongList(source);
        }

        @Override
        public SongList[] newArray(int size) {
            return new SongList[size];
        }
    };
}
