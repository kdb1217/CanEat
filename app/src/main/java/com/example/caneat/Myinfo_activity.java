package com.example.caneat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.type.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.util.FusedLocationSource;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Myinfo_activity extends AppCompatActivity implements View.OnClickListener,OnMapReadyCallback {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private FusedLocationSource locationSource;
    private NaverMap naverMap;



    private FirebaseAuth auth;
    Button google_signout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo);

        NaverMapSdk.getInstance(this).setClient(
               new NaverMapSdk.NaverCloudPlatformClient("fq6m1c8f92"));

        FragmentManager fm=getSupportFragmentManager();
        MapFragment mapFragment=(MapFragment)fm.findFragmentById(R.id.map);
        if(mapFragment == null){
            fm.beginTransaction().add(R.id.map,mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
        locationSource=
                new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);


        google_signout=findViewById(R.id.google_logout);
        auth=FirebaseAuth.getInstance();
        google_signout.setOnClickListener(this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,  @NonNull int[] grantResults) {
        if (locationSource.onRequestPermissionsResult(
                requestCode, permissions, grantResults)) {
            if (!locationSource.isActivated()) { // 권한 거부됨
                naverMap.setLocationTrackingMode(LocationTrackingMode.None);
            }
            return;
        }
        super.onRequestPermissionsResult(
                requestCode, permissions, grantResults);
    }


    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        naverMap.setLocationSource(locationSource);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
        this.naverMap = naverMap;
        naverMap.setLocationSource(locationSource);
    }



    @Override
    public void onClick(View view){
        setGoogle_signout();
        Intent google_signout =new Intent(getApplicationContext(),IntroActivity.class);
        startActivity(google_signout);


    }




    private  void setGoogle_signout(){
        FirebaseAuth.getInstance().signOut();

    }


}
