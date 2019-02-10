package com.example.tartaneatsv20;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import android.provider.Settings.Secure;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

//firebase
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        /*BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.navigation_sell:
                        Intent sell = new Intent(MapsActivity.this, Sell.class);
                        startActivity(sell);
                        break;
                    case R.id.navigation_map:
                        break;
                    case R.id.navigation_request:
                        Intent request = new Intent(MapsActivity.this, Request.class);
                        startActivity(request);
                        break;
                }
                return false;
            }
        });*/
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    //@Override

    public Marker makeMarker(GoogleMap mMap, float lat, float lng, String name) {
        return mMap.addMarker(new MarkerOptions()
                .position(new LatLng(lat, lng))
                .title(name)
                .snippet("Users: ") //add later
        );
    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Marker abp = makeMarker(mMap,(float)40.4441, (float)-79.9422, "Au Bon Pain");

        LatLng gallo = new LatLng(40.4432, -79.9420);
        mMap.addMarker(new MarkerOptions().position(gallo).title("El Gallo de Oro"));

        LatLng entropy = new LatLng(40.4429, -79.9420);
        mMap.addMarker(new MarkerOptions().position(entropy).title("Entropy+"));

        LatLng bbg = new LatLng(40.4444, -79.9435);
        mMap.addMarker(new MarkerOptions().position(bbg).title("Black Bar Grill"));
        LatLng bibim = new LatLng(40.4444, -79.94351);
        mMap.addMarker(new MarkerOptions().position(bibim).title("Bibimbap"));
        LatLng bowlife = new LatLng(40.4444, -79.94349);
        mMap.addMarker(new MarkerOptions().position(bowlife).title("Bowl Life"));
        LatLng rwich = new LatLng(40.44441, -79.9435);
        mMap.addMarker(new MarkerOptions().position(rwich).title("Real Wich"));
        LatLng create = new LatLng(40.44439, -79.9435);
        mMap.addMarker(new MarkerOptions().position(create).title("Create"));
        LatLng rooted = new LatLng(40.44441, -79.94351);
        mMap.addMarker(new MarkerOptions().position(rooted).title("Rooted"));

        LatLng resnik = new LatLng(40.442515, -79.940035);
        mMap.addMarker(new MarkerOptions().position(resnik).title("Taste of India"));
        mMap.addMarker(new MarkerOptions().position(resnik).title("Innovation Kitchen"));
        mMap.addMarker(new MarkerOptions().position(resnik).title("BYOB"));
        mMap.addMarker(new MarkerOptions().position(resnik).title("Fresh52"));
        mMap.addMarker(new MarkerOptions().position(resnik).title("Nakama"));

        LatLng pavillion = new LatLng(40.4427, -79.9401);
        mMap.addMarker(new MarkerOptions().position(pavillion).title("Cucina"));
        mMap.addMarker(new MarkerOptions().position(pavillion).title("The Pomegranate"));

        LatLng cmucafe = new LatLng(40.4424, -79.9397);
        mMap.addMarker(new MarkerOptions().position(cmucafe).title("Carnegie Mellon Cafe"));

        LatLng exchange = new LatLng(40.4379, -79.9205);
        mMap.addMarker(new MarkerOptions().position(exchange).title("The Exchange"));

        // Add a marker in iNoodle and move the camera
        LatLng inoodle = new LatLng(40.4434, -79.9456); //lat, long
        mMap.addMarker(new MarkerOptions().position(inoodle).title("iNoodle: The only place that sells good rice"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(inoodle));
    }
}
