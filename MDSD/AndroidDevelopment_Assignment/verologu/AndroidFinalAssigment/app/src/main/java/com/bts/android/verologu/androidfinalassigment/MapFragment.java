package com.bts.android.verologu.androidfinalassigment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bts.android.verologu.androidfinalassigment.base.BaseFragment;
import com.bts.android.verologu.androidfinalassigment.model.Song;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by verologu on 26/04/16.
 */
public class MapFragment extends BaseFragment {

    final LatLng BRAZIL = new LatLng(-22.9103552, -71.589803);
    private GoogleMap map;
    Song currentSong;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_music_map, container, false);
        readArguments();
        initComponents();
        return rootView;
    }

    @Override
    protected void readArguments() {
        Bundle arguments = getArguments();
        currentSong = (Song) arguments.getParcelable("song");
    }

    @Override
    protected void initComponents() {
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        if (fab != null) {
            fab.setVisibility(View.GONE);
        }

        FragmentManager fm = getChildFragmentManager();
        map = ((SupportMapFragment) fm.findFragmentById(R.id.fragment_music_map_f)).getMap();

        LatLng latLng = currentSong.getLatLng();

        Marker markerColombo = map.addMarker(new MarkerOptions().position(latLng)
                .title(currentSong.getTitle()));

        // Move the camera to Colombo area with the zoom level of 20.
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 6));

        // Animating the camera while zooming.
        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
    }
}
