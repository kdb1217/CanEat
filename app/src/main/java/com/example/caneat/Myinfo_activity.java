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
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Align;
import com.naver.maps.map.overlay.Marker;
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

        Marker marker1 = new Marker();
        marker1.setPosition(new LatLng(37.473420157548645, 127.05098427904939));
        marker1.setMap(naverMap);
        marker1.setCaptionText("러빙헛 스마일 (채식, 샐러드 뷔페)");
        marker1.setCaptionRequestedWidth(250);
        marker1.setCaptionAligns(Align.Top);


        Marker marker2 = new Marker();
        marker2.setPosition(new LatLng(37.47684907128816, 127.04938171417933));
        marker2.setMap(naverMap);
        marker2.setCaptionText("러빙헛 카페");
        marker2.setCaptionRequestedWidth(250);
        marker2.setCaptionAligns(Align.Top);

        Marker marker3 = new Marker();
        marker3.setPosition(new LatLng(37.476936229217394, 127.04734180058551));
        marker3.setMap(naverMap);
        marker3.setCaptionText("베지그린 (채식, 샐러드뷔페)");
        marker3.setCaptionRequestedWidth(250);
        marker3.setCaptionAligns(Align.Top);

        Marker marker4 = new Marker();
        marker4.setPosition(new LatLng(37.48859638890162, 127.06778152993685));
        marker4.setMap(naverMap);
        marker4.setCaptionText("로슈 베이커리 (베이커리)");
        marker4.setCaptionRequestedWidth(250);
        marker4.setCaptionAligns(Align.Top);

        Marker marker5 = new Marker();
        marker5.setPosition(new LatLng(37.4903415059686, 127.0854663190983));
        marker5.setMap(naverMap);
        marker5.setCaptionText("비건 분식 (종합분식)");
        marker5.setCaptionRequestedWidth(250);
        marker5.setCaptionAligns(Align.Top);

        Marker marker6 = new Marker();
        marker6.setPosition(new LatLng(37.49397890906966, 127.03905284464119));
        marker6.setMap(naverMap);
        marker6.setCaptionText("비건 베이커리 보물 (베이커리)");
        marker6.setCaptionRequestedWidth(250);
        marker6.setCaptionAligns(Align.Top);

        Marker marker7 = new Marker();
        marker7.setPosition(new LatLng(37.50294348494545, 127.04919159206352));
        marker7.setMap(naverMap);
        marker7.setCaptionText("비건 비기닝 (카페, 디저트)");
        marker7.setCaptionRequestedWidth(250);
        marker7.setCaptionAligns(Align.Top);

        Marker marker8 = new Marker();
        marker8.setPosition(new LatLng(37.514087796678425, 127.04884646263017));
        marker8.setMap(naverMap);
        marker8.setCaptionText("비건 이삼 (베이커리)");
        marker8.setCaptionRequestedWidth(250);
        marker8.setCaptionAligns(Align.Top);

        Marker marker9 = new Marker();
        marker9.setPosition(new LatLng(37.51072642724844, 127.02294509640697));
        marker9.setMap(naverMap);
        marker9.setCaptionText("해피돌핀 비건분식 (종합분식)");
        marker9.setCaptionRequestedWidth(250);
        marker9.setCaptionAligns(Align.Top);

        Marker marker10 = new Marker();
        marker10.setPosition(new LatLng(37.51842480721301, 127.03800798437624));
        marker10.setMap(naverMap);
        marker10.setCaptionText("비건씨의 헬스농장 (카페, 디저트)");
        marker10.setCaptionRequestedWidth(250);
        marker10.setCaptionAligns(Align.Top);

        Marker marker11 = new Marker();
        marker11.setPosition(new LatLng(37.518880384046845, 127.0210987488525));
        marker11.setMap(naverMap);
        marker11.setCaptionText("콜리플라워 (베이커리)");
        marker11.setCaptionRequestedWidth(250);
        marker11.setCaptionAligns(Align.Top);

        Marker marker12 = new Marker();
        marker12.setPosition(new LatLng(37.523621920603006, 127.02303004505998));
        marker12.setMap(naverMap);
        marker12.setCaptionText("마히나 비건 테이블 (이탈리아음식)");
        marker12.setCaptionRequestedWidth(250);
        marker12.setCaptionAligns(Align.Top);

        Marker marker13 = new Marker();
        marker13.setPosition(new LatLng(37.52747340803543, 127.13037342231827));
        marker13.setMap(naverMap);
        marker13.setCaptionText("비건헤븐 (양식)");
        marker13.setCaptionRequestedWidth(250);
        marker13.setCaptionAligns(Align.Top);

        Marker marker14 = new Marker();
        marker14.setPosition(new LatLng(37.482534898875414, 126.95094804143423));
        marker14.setMap(naverMap);
        marker14.setCaptionText("비건마마 (카페, 디저트)");
        marker14.setCaptionRequestedWidth(250);
        marker14.setCaptionAligns(Align.Top);

        Marker marker15 = new Marker();
        marker15.setPosition(new LatLng(37.38689600139497, 127.11541739403977));
        marker15.setMap(naverMap);
        marker15.setCaptionText("천안발효 비건 나정빵집 (베이커리)");
        marker15.setCaptionRequestedWidth(250);
        marker15.setCaptionAligns(Align.Top);

        Marker marker16 = new Marker();
        marker16.setPosition(new LatLng(37.36484929420455, 127.11009110638929));
        marker16.setMap(naverMap);
        marker16.setCaptionText("아꼬떼 비건 베이커리 (베이커리)");
        marker16.setCaptionRequestedWidth(250);
        marker16.setCaptionAligns(Align.Top);

        Marker marker17 = new Marker();
        marker17.setPosition(new LatLng(37.291196505587756, 127.14204045602155));
        marker17.setMap(naverMap);
        marker17.setCaptionText("비건베이커리 리틀브라운 (베이커리)");
        marker17.setCaptionRequestedWidth(250);
        marker17.setCaptionAligns(Align.Top);

        Marker marker18 = new Marker();
        marker18.setPosition(new LatLng(37.29027754349677, 127.05807149859858));
        marker18.setMap(naverMap);
        marker18.setCaptionText("비건 비긴즈 (베이커리)");
        marker18.setCaptionRequestedWidth(250);
        marker18.setCaptionAligns(Align.Top);

        Marker marker19 = new Marker();
        marker19.setPosition(new LatLng(37.20873898570087, 127.1108857014915));
        marker19.setMap(naverMap);
        marker19.setCaptionText("샹떼콩콩 비건 베이커리 (베이커리)");
        marker19.setCaptionRequestedWidth(250);
        marker19.setCaptionAligns(Align.Top);

        Marker marker20 = new Marker();
        marker20.setPosition(new LatLng(37.320520714262344, 126.9568476639151));
        marker20.setMap(naverMap);
        marker20.setCaptionText("모니모니해도비건 (베이커리)");
        marker20.setCaptionRequestedWidth(250);
        marker20.setCaptionAligns(Align.Top);

        Marker marker21 = new Marker();
        marker21.setPosition(new LatLng(37.304968773951515, 126.86413386849927));
        marker21.setMap(naverMap);
        marker21.setCaptionText("비건숲(베이커리)");
        marker21.setCaptionRequestedWidth(250);
        marker21.setCaptionAligns(Align.Top);

        Marker marker22 = new Marker();
        marker22.setPosition(new LatLng(37.333478732134, 126.85528461977948));
        marker22.setMap(naverMap);
        marker22.setCaptionText("비건카페 씽푸커피 (채식, 샐러드뷔페)");
        marker22.setCaptionRequestedWidth(250);
        marker22.setCaptionAligns(Align.Top);

        Marker marker23 = new Marker();
        marker23.setPosition(new LatLng(37.55133102562283, 127.1883437078046));
        marker23.setMap(naverMap);
        marker23.setCaptionText("연당 비건베이커리(베이커리)");
        marker23.setCaptionRequestedWidth(250);
        marker23.setCaptionAligns(Align.Top);

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
