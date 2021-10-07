package com.example.caneat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Myinfo_activity extends AppCompatActivity {

    private TextView nameview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo);

        Intent intent =getIntent();
        String nickName= intent.getStringExtra("nickname");

        nameview=findViewById(R.id.nameview);
        nameview.setText(nickName);
    }
}

