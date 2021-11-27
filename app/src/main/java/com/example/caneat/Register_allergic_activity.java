package com.example.caneat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Register_allergic_activity extends AppCompatActivity implements OnItemClick{
    private RecyclerView ingredientlistinfo;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<com.example.caneat.allergic_info> arrayList;
    private RecyclerView.Adapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_allergic);

        ingredientlistinfo=findViewById(R.id.ingredientlistinfo);
        ingredientlistinfo.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        ingredientlistinfo.setLayoutManager(layoutManager);
        arrayList=new ArrayList<>();
        Button button=findViewById(R.id.button);
        database =FirebaseDatabase.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Succescomplete = new Intent(getApplicationContext(),SelectActivity.class);
                startActivity(Succescomplete);
            }
        });
        Button My_info = (Button) findViewById(R.id.myinfo);
        My_info.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent My_info = new Intent(getApplicationContext(),Myinfo_activity.class);
                startActivity(My_info);
            }
        });
        databaseReference=database.getReference("allergic_info");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    allergic_info allergic = snapshot.getValue(allergic_info.class);
                    arrayList.add(allergic);

                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("allergic_register",String.valueOf(error.toException()));


            }
        });

        Button mypage=findViewById(R.id.mypage);
        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Mypage=new Intent(getApplicationContext(),Mypage_activity.class);
                startActivity(Mypage);
            }
        });

        adapter=new AdpaterAllergic(arrayList,this);
        ingredientlistinfo.setAdapter(adapter);








    }


    @Override
    public void onClick(String value) {

    }
}

