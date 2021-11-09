package com.example.caneat;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SelectActivity extends AppCompatActivity {
    public DatabaseReference CanEatdatabase;
    private  long backKeyPressedTime=0;
    Button option_save;
    private Toast toast;
    FirebaseDatabase database;
    List<User> mUser;
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
        database = FirebaseDatabase.getInstance();
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


        Button My_info = (Button) findViewById(R.id.myinfo);
        My_info.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent My_info = new Intent(getApplicationContext(),Myinfo_activity.class);
                startActivity(My_info);
            }
        });








        option_save=findViewById(R.id.option_save);
        option_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent option_save=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(option_save);

            }
        });
    }








}

