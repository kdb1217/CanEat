package com.example.caneat;

import android.content.Intent;
import android.os.Bundle;
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

public class Register_religion_activity extends AppCompatActivity {
    private RecyclerView religionlistinfo;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<religion_info>arrayList;
    private RecyclerView.Adapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_religion);
        Button button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Succescomplete = new Intent(getApplicationContext(),SelectActivity.class);
                startActivity(Succescomplete);
            }
        });

        religionlistinfo=findViewById(R.id.religionlistinfo);
        religionlistinfo.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        religionlistinfo.setLayoutManager(layoutManager);
        arrayList=new ArrayList<>();

        database=FirebaseDatabase.getInstance();

        databaseReference=database.getReference("religion_info");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    religion_info religion=snapshot.getValue(religion_info.class);
                    arrayList.add(religion);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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

        Button My_info = (Button) findViewById(R.id.myinfo);
        My_info.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent My_info = new Intent(getApplicationContext(),Myinfo_activity.class);
                startActivity(My_info);
            }
        });
        adapter=new AdapterReligion(arrayList,this);
        religionlistinfo.setAdapter(adapter);
    }
}

