package com.example.caneat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

public class Change_allergic_activity extends AppCompatActivity {
    private RecyclerView ingredientlistinfo,removelistinfo;
    private RecyclerView.LayoutManager layoutManager,layoutManager2;
    private ArrayList<allergic_info> arrayList;
    private ArrayList<myallergic_info>arrayList1;
    private RecyclerView.Adapter adapter,adapter1;
    private FirebaseDatabase database,database1;
    private DatabaseReference databaseReference,databaseReference1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_allergic);
        Button button=findViewById(R.id.button);
        Button removebutton=findViewById(R.id.removebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Succescomplete = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(Succescomplete);
            }
        });

        removebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent remove=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(remove);
            }
        });

        Button My_info = (Button) findViewById(R.id.myinfo);
        My_info.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent My_info = new Intent(getApplicationContext(),Myinfo_activity.class);
                startActivity(My_info);
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




        ingredientlistinfo=findViewById(R.id.allergiclistinfo);
        ingredientlistinfo.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        ingredientlistinfo.setLayoutManager(layoutManager);
        arrayList=new ArrayList<>();

        database =FirebaseDatabase.getInstance();

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


            }
        });
        adapter=new AdpaterAllergic(arrayList,this);
        ingredientlistinfo.setAdapter(adapter);

        removelistinfo=findViewById(R.id.removelistinfo);
        removelistinfo.setHasFixedSize(true);
        layoutManager2=new LinearLayoutManager(this);
        removelistinfo.setLayoutManager(layoutManager2);
        arrayList1=new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid=user.getUid();

        database1=FirebaseDatabase.getInstance();



        databaseReference1=database1.getReference("user").child(uid).child("myallergic_info");

        databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList1.clear();
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    myallergic_info myallergic=snapshot1.getValue(myallergic_info.class);
                    arrayList1.add(myallergic);
                }
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adapter1=new AdapterRallergic(arrayList1,this);
        removelistinfo.setAdapter(adapter1);








    }



}



