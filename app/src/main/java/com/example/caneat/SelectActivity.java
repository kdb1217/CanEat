package com.example.caneat;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelectActivity extends AppCompatActivity {

    private  long backKeyPressedTime=0;

    private Toast toast;
    @Override
        public void onBackPressed(){

        if(System.currentTimeMillis()>backKeyPressedTime+2000){
            backKeyPressedTime=System.currentTimeMillis();
            toast=Toast.makeText(this,"\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if(System.currentTimeMillis()<=backKeyPressedTime+2000){
            finish();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_page);

        Button dissease_Register_button = (Button) findViewById(R.id.disease_button);
        dissease_Register_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Register_disease_activity.class);
                startActivity(intent);
            }
        });


        Button allergic_Register_button = (Button) findViewById(R.id.allegric_button);
        allergic_Register_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent allergic = new Intent(getApplicationContext(),Register_allergic_activity.class);
                startActivity(allergic);
            }
        });


        Button vegan_Register_button = (Button) findViewById(R.id.vegan_button);
        vegan_Register_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent vegan = new Intent(getApplicationContext(),Register_vegan_activity.class);
                startActivity(vegan);
            }
        });

        Button religion_Register_button = (Button) findViewById(R.id.religion_button);
        religion_Register_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent religion = new Intent(getApplicationContext(),Register_religion_activity.class);
                startActivity(religion);
            }
        });

        Button ingredient_Register_button = (Button) findViewById(R.id.ingredient_button);
        ingredient_Register_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent ingredient = new Intent(getApplicationContext(),Register_ingredient_activity.class);
                startActivity(ingredient);
            }
        });
        }





}

