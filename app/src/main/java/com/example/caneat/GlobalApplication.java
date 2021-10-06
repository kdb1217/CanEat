package com.example.caneat;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class GlobalApplication extends Application {
    private static GlobalApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;



        // 네이티브 앱 키로 초기화
        KakaoSdk.init(this, "bec3f6cab9fb0a2ba54b6b866c36ba73");
        }


    }