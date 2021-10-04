package com.example.caneat;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.nfc.Tag;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MainActivity extends AppCompatActivity {
    private static final String TAG="사용자";
    private ImageButton kakao_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        Log.d("Get_KEYHASH",getKeyHash());

        kakao_login=findViewById(R.id.kakao_login);

        kakao_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserApiClient.getInstance().loginWithKakaoTalk(MainActivity.this, (oAuthToken, error) -> {
                    if (error != null) {
                        Log.e(TAG, "로그인 실패", error);
                    } else if (oAuthToken != null) {
                        Log.i(TAG, "로그인 성공(토큰) : " + oAuthToken.getAccessToken());

                    }
                    }
                    }


            public String getKeyHash() {
                try {
                    PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
                    if (packageInfo == null) return null;
                    for (Signature signature : packageInfo.signatures) {
                        try {
                            MessageDigest md = MessageDigest.getInstance("SHA");
                            md.update(signature.toByteArray());
                            return android.util.Base64.encodeToString(md.digest(), Base64.NO_WRAP);
                        } catch (NoSuchAlgorithmException e) {
                            Log.w("getKeyHash", "Unable to get MEssageDigest. signature=" + signature, e);
                        }
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.w("getPackageInfo", "Unable to getPackageInfo");
                }
                return null;
            }
        }
