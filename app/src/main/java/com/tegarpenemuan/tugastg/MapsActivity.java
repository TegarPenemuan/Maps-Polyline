package com.tegarpenemuan.tugastg;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

//    private GoogleMap mMap;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        // Marker Lokawisata Baturaden
        LatLng LokawisataBaturraden = new LatLng(-7.313042780418181, 109.228975581486);
        map.addMarker(new MarkerOptions().position(LokawisataBaturraden).title("Lokawisata Baturraden"));

        // Menambahkan Marker
        LatLng AlunAlunPurwokerto = new LatLng(-7.424251847402663, 109.23019029661323);
        map.addMarker(new MarkerOptions().position(AlunAlunPurwokerto).title("Alun-alun Purwokerto"));

        // Movement kamera dengan zoom 15
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LokawisataBaturraden, 15));

        // Zoom in, animasi kamera.
        map.animateCamera(CameraUpdateFactory.zoomIn());

        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);


        // membuat polyline
        Polyline line = map.addPolyline(new PolylineOptions()
                .add(new LatLng(-7.313042780418181, 109.228975581486), new LatLng(-7.424251847402663, 109.23019029661323))
                .width(10)
                .color(Color.BLUE));
    }
}