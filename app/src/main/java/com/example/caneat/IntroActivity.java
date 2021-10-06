package com.example.caneat;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.Account;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class IntroActivity  extends AppCompatActivity {
    private ImageButton social_login;
    private static final String TAG="사용자";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro); // xml파일과 자바파일 연결

       // getHashKey(); //hash값 구하는 함수 호출

        social_login = findViewById(R.id.kakao_login);


        social_login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                    if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(IntroActivity.this))
                    {
                    UserApiClient.getInstance().loginWithKakaoTalk(IntroActivity.this, (oAuthtoken, error) ->
                    {
                        if (error != null) {
                            Log.e(TAG, "로그인 실패", error);
                        } else if (oAuthtoken != null) {
                            Log.i(TAG, "로그인 성공(토큰) : " + oAuthtoken.getAccessToken());
                        }

                        UserApiClient.getInstance().me((user, meError) -> {
                            if (meError != null) {
                                Log.e(TAG, "사용자 정보 요청 실패", meError);
                            } else {
                                System.out.println("로그인 완료");
                                Log.i(TAG, user.toString());
                                {
                                    Log.i(TAG, "사용자 정보 요청 성공" +
                                            "\n회원번호: " + user.getId() +
                                            "\n이메일: " + user.getKakaoAccount().getEmail());
                                }
                                Account user1 = user.getKakaoAccount();
                                System.out.println("사용자 계정" + user1);
                            }
                            return null;
                        });

                        return null;
                    });

                }
                    else {
                        UserApiClient.getInstance().loginWithKakaoAccount(IntroActivity.this, (oAuthtoken, error) ->
                        {
                            if (error != null) {
                                Log.e(TAG, "로그인 실패", error);
                            } else if (oAuthtoken != null) {
                                Log.i(TAG, "로그인 성공(토큰) : " + oAuthtoken.getAccessToken());
                            }

                            UserApiClient.getInstance().me((user, meError) -> {
                                if (meError != null) {
                                    Log.e(TAG, "사용자 정보 요청 실패", meError);
                                } else {
                                    System.out.println("로그인 완료");
                                    Log.i(TAG, user.toString());
                                    {
                                        Log.i(TAG, "사용자 정보 요청 성공" +
                                                "\n회원번호: " + user.getId() +
                                                "\n이메일: " + user.getKakaoAccount().getEmail());
                                    }
                                    Account user1 = user.getKakaoAccount();
                                    System.out.println("사용자 계정" + user1);
                                }
                                return null;
                            });

                            return null;
                        });

                    }
                    }
            });

    }




    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }
}
