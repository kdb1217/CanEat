package com.example.caneat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Register_allergic_activity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_allergic);

        Button My_info = (Button) findViewById(R.id.myinfo);
        My_info.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent My_info = new Intent(getApplicationContext(),Myinfo_activity.class);
                startActivity(My_info);
            }
        });
    }
}

