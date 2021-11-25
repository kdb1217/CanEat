package com.example.caneat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class ResultActivity extends Activity {
    TextView resulttext;

    @Override
    protected void onCreate(Bundle savedInstandedState){
        super.onCreate(savedInstandedState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.result);

        resulttext=findViewById(R.id.result_text);

       /* Intent intent = getIntent();  텍스트 설정
        String data = intent.getStringExtra("data");
        resulttext.setText(data);
        */


    }
    public  void OnClose(View view){
        Intent intent=new Intent();
        intent.putExtra("result","Close Popup");
        setResult(RESULT_OK,intent);

        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return  false;
        }
        return true;
    }
    @Override
    public void onBackPressed(){//뒤로가기 버튼 막기
        return;
    }
}
