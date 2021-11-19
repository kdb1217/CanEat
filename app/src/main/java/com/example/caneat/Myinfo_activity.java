package com.example.caneat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
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

        InfoWindow infoWindow = new InfoWindow();
        Context context=null;

        Marker marker1 = new Marker();
        marker1.setPosition(new LatLng(37.473420157548645, 127.05098427904939));
        marker1.setMap(naverMap);
        marker1.setCaptionText("러빙헛 스마일 (채식, 샐러드 뷔페)");
        marker1.setCaptionRequestedWidth(250);
        marker1.setCaptionAligns(Align.Top);
        marker1.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/20570102?c=14143252.3464774,4505319.1575277,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker2 = new Marker();
        marker2.setPosition(new LatLng(37.47684907128816, 127.04938171417933));
        marker2.setMap(naverMap);
        marker2.setCaptionText("러빙헛 카페");
        marker2.setCaptionRequestedWidth(250);
        marker2.setCaptionAligns(Align.Top);
        marker2.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/18595315?c=14142461.2211203,4505702.9448652,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker3 = new Marker();
        marker3.setPosition(new LatLng(37.476936229217394, 127.04734180058551));
        marker3.setMap(naverMap);
        marker3.setCaptionText("베지그린 (채식, 샐러드뷔페)");
        marker3.setCaptionRequestedWidth(250);
        marker3.setCaptionAligns(Align.Top);
        marker3.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B2%A0%EC%A7%80%EA%B7%B8%EB%A6%B0/place/94880009?c=14142461.2211203,4505702.9448652,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker4 = new Marker();
        marker4.setPosition(new LatLng(37.48859638890162, 127.06778152993685));
        marker4.setMap(naverMap);
        marker4.setCaptionText("로슈 베이커리 (베이커리)");
        marker4.setCaptionRequestedWidth(250);
        marker4.setCaptionAligns(Align.Top);
        marker4.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%A1%9C%EC%8A%88%EB%B2%A0%EC%9D%B4%EC%BB%A4%EB%A6%AC/place/1124408133?placePath=%3Fentry=pll%26from=nx%26fromNxList=true&c=14144190.9256321,4507439.4843169,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker5 = new Marker();
        marker5.setPosition(new LatLng(37.4903415059686, 127.0854663190983));
        marker5.setMap(naverMap);
        marker5.setCaptionText("비건 분식 (종합분식)");
        marker5.setCaptionRequestedWidth(250);
        marker5.setCaptionAligns(Align.Top);
        marker5.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B9%84%EA%B1%B4%20%EB%B6%84%EC%8B%9D/place/1791033777?c=14146318.1186497,4507522.7069486,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
            startActivity(intent);
            return true;
        });

        Marker marker6 = new Marker();
        marker6.setPosition(new LatLng(37.49397890906966, 127.03905284464119));
        marker6.setMap(naverMap);
        marker6.setCaptionText("비건 베이커리 보물 (베이커리)");
        marker6.setCaptionRequestedWidth(250);
        marker6.setCaptionAligns(Align.Top);
        marker6.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B9%84%EA%B1%B4%20%EB%B2%A0%EC%9D%B4%EC%BB%A4%EB%A6%AC%20%EB%B3%B4%EB%AC%BC/place/1671562845?c=14141462.2511418,4508191.6125119,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker7 = new Marker();
        marker7.setPosition(new LatLng(37.50294348494545, 127.04919159206352));
        marker7.setMap(naverMap);
        marker7.setCaptionText("비건 비기닝 (카페, 디저트)");
        marker7.setCaptionRequestedWidth(250);
        marker7.setCaptionAligns(Align.Top);
        marker7.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/1975678801?c=14142702.1164983,4509286.9381393,15,0,0,0,dh&placePath=%2Fhome%3Fentry=plt"));
            startActivity(intent);
            return true;
        });

        Marker marker8 = new Marker();
        marker8.setPosition(new LatLng(37.514087796678425, 127.04884646263017));
        marker8.setMap(naverMap);
        marker8.setCaptionText("비건 이삼 (베이커리)");
        marker8.setCaptionRequestedWidth(250);
        marker8.setCaptionAligns(Align.Top);
        marker8.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B9%84%EA%B1%B4%20%EC%9D%B4%EC%82%BC/place/1468151379?c=14142546.5363780,4511008.4376336,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker9 = new Marker();
        marker9.setPosition(new LatLng(37.51072642724844, 127.02294509640697));
        marker9.setMap(naverMap);
        marker9.setCaptionText("해피돌핀 비건분식 (종합분식)");
        marker9.setCaptionRequestedWidth(250);
        marker9.setCaptionAligns(Align.Top);
        marker9.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%95%B4%ED%94%BC%EB%8F%8C%ED%95%80%20%EB%B9%84%EA%B1%B4%EB%B6%84%EC%8B%9D/place/1166639923?c=14139656.4931539,4510538.3879209,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker10 = new Marker();
        marker10.setPosition(new LatLng(37.51842480721301, 127.03800798437624));
        marker10.setMap(naverMap);
        marker10.setCaptionText("비건씨의 헬스농장 (카페, 디저트)");
        marker10.setCaptionRequestedWidth(250);
        marker10.setCaptionAligns(Align.Top);
        marker10.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B9%84%EA%B1%B4%EC%94%A8%EC%9D%98%20%ED%97%AC%EC%8A%A4%EB%86%8D%EC%9E%A5/place/1692833282?c=14141041.0961123,4511673.0886205,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
            startActivity(intent);
            return true;
        });

        Marker marker11 = new Marker();
        marker11.setPosition(new LatLng(37.518880384046845, 127.0210987488525));
        marker11.setMap(naverMap);
        marker11.setCaptionText("콜리플라워 (베이커리)");
        marker11.setCaptionRequestedWidth(250);
        marker11.setCaptionAligns(Align.Top);
        marker11.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%BD%9C%EB%A6%AC%ED%94%8C%EB%9D%BC%EC%9B%8C/place/1567642734?c=14138994.2089754,4511688.5271910,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
            startActivity(intent);
            return true;
        });

        Marker marker12 = new Marker();
        marker12.setPosition(new LatLng(37.523621920603006, 127.02303004505998));
        marker12.setMap(naverMap);
        marker12.setCaptionText("마히나 비건 테이블 (이탈리아음식)");
        marker12.setCaptionRequestedWidth(250);
        marker12.setCaptionAligns(Align.Top);
        marker12.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%A7%88%ED%9E%88%EB%82%98%20%EB%B9%84%EA%B1%B4%20%ED%85%8C%EC%9D%B4%EB%B8%94/place/1836210120?c=14139677.1206555,4512345.0804857,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker13 = new Marker();
        marker13.setPosition(new LatLng(37.52747340803543, 127.13037342231827));
        marker13.setMap(naverMap);
        marker13.setCaptionText("비건헤븐 (양식)");
        marker13.setCaptionRequestedWidth(250);
        marker13.setCaptionAligns(Align.Top);
        marker13.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B9%84%EA%B1%B4%ED%97%A4%EB%B8%90/place/1861149212?c=14151629.7615488,4512892.1601369,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker14 = new Marker();
        marker14.setPosition(new LatLng(37.482534898875414, 126.95094804143423));
        marker14.setMap(naverMap);
        marker14.setCaptionText("비건마마 (카페, 디저트)");
        marker14.setCaptionRequestedWidth(250);
        marker14.setCaptionAligns(Align.Top);
        marker14.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B9%84%EA%B1%B4%EB%A7%88%EB%A7%88/place/1867166179?c=14131185.2914116,4506588.5105091,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
            startActivity(intent);
            return true;
        });

        Marker marker15 = new Marker();
        marker15.setPosition(new LatLng(37.38689600139497, 127.11541739403977));
        marker15.setMap(naverMap);
        marker15.setCaptionText("천안발효 비건 나정빵집 (베이커리)");
        marker15.setCaptionRequestedWidth(250);
        marker15.setCaptionAligns(Align.Top);
        marker15.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B9%84%EA%B1%B4%20%EB%82%98%EC%A0%95%EB%B9%B5%EC%A7%91/place/1243988801?c=14149966.3477937,4493184.3240102,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker16 = new Marker();
        marker16.setPosition(new LatLng(37.36484929420455, 127.11009110638929));
        marker16.setMap(naverMap);
        marker16.setCaptionText("아꼬떼 비건 베이커리 (베이커리)");
        marker16.setCaptionRequestedWidth(250);
        marker16.setCaptionAligns(Align.Top);
        marker16.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%95%84%EA%BC%AC%EB%96%BC%20%EB%B9%84%EA%B1%B4%20%EB%B2%A0%EC%9D%B4%EC%BB%A4%EB%A6%AC/place/1630593595?c=14149367.3932735,4490088.2300248,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker17 = new Marker();
        marker17.setPosition(new LatLng(37.291196505587756, 127.14204045602155));
        marker17.setMap(naverMap);
        marker17.setCaptionText("비건베이커리 리틀브라운 (베이커리)");
        marker17.setCaptionRequestedWidth(250);
        marker17.setCaptionAligns(Align.Top);
        marker17.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B9%84%EA%B1%B4%EB%B2%A0%EC%9D%B4%EC%BB%A4%EB%A6%AC%20%EB%A6%AC%ED%8B%80%EB%B8%8C%EB%9D%BC%EC%9A%B4/place/1846083405?c=14152926.7338041,4479778.3305454,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker18 = new Marker();
        marker18.setPosition(new LatLng(37.29027754349677, 127.05807149859858));
        marker18.setMap(naverMap);
        marker18.setCaptionText("비건 비긴즈 (베이커리)");
        marker18.setCaptionRequestedWidth(250);
        marker18.setCaptionAligns(Align.Top);
        marker18.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B9%84%EA%B1%B4%20%EB%B9%84%EA%B8%B4%EC%A6%88/place/1459736032?c=14142693.2220710,4479986.6387358,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker19 = new Marker();
        marker19.setPosition(new LatLng(37.20873898570087, 127.1108857014915));
        marker19.setMap(naverMap);
        marker19.setCaptionText("샹떼콩콩 비건 베이커리 (베이커리)");
        marker19.setCaptionRequestedWidth(250);
        marker19.setCaptionAligns(Align.Top);
        marker19.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%83%B9%EB%96%BC%EC%BD%A9%EC%BD%A9%20%EB%B9%84%EA%B1%B4%20%EB%B2%A0%EC%9D%B4%EC%BB%A4%EB%A6%AC/place/1708129305?c=14149443.9588193,4468226.8037023,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker20 = new Marker();
        marker20.setPosition(new LatLng(37.320520714262344, 126.9568476639151));
        marker20.setMap(naverMap);
        marker20.setCaptionText("모니모니해도비건 (베이커리)");
        marker20.setCaptionRequestedWidth(250);
        marker20.setCaptionAligns(Align.Top);
        marker20.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%AA%A8%EB%8B%88%EB%AA%A8%EB%8B%88%ED%95%B4%EB%8F%84%EB%B9%84%EA%B1%B4/place/1849357606?c=14132333.4072438,4483890.9377000,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker21 = new Marker();
        marker21.setPosition(new LatLng(37.304968773951515, 126.86413386849927));
        marker21.setMap(naverMap);
        marker21.setCaptionText("비건숲(베이커리)");
        marker21.setCaptionRequestedWidth(250);
        marker21.setCaptionAligns(Align.Top);
        marker21.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B9%84%EA%B1%B4%EC%88%B2/place/1747948837?c=14121518.0953240,4481709.1067858,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
            startActivity(intent);
            return true;
        });

        Marker marker22 = new Marker();
        marker22.setPosition(new LatLng(37.333478732134, 126.85528461977948));
        marker22.setMap(naverMap);
        marker22.setCaptionText("비건카페 씽푸커피 (채식, 샐러드뷔페)");
        marker22.setCaptionRequestedWidth(250);
        marker22.setCaptionAligns(Align.Top);
        marker22.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B9%84%EA%B1%B4%EC%B9%B4%ED%8E%98%20%EC%94%BD%ED%91%B8%EC%BB%A4%ED%94%BC/place/1935475931?c=14120998.2444340,4485701.5889694,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

        Marker marker23 = new Marker();
        marker23.setPosition(new LatLng(37.55133102562283, 127.1883437078046));
        marker23.setMap(naverMap);
        marker23.setCaptionText("연당 비건베이커리(베이커리)");
        marker23.setCaptionRequestedWidth(250);
        marker23.setCaptionAligns(Align.Top);
        marker23.setOnClickListener(overlay -> {
            // 마커를 클릭할 때 검색창으로 연결
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%97%B0%EB%8B%B9%20%EB%B9%84%EA%B1%B4%EB%B2%A0%EC%9D%B4%EC%BB%A4%EB%A6%AC/place/1636539051?c=14158050.2356317,4516258.3621250,15,0,0,0,dh"));
            startActivity(intent);
            return true;
        });

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
