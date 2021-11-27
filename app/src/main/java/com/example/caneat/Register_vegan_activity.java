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

public class Register_vegan_activity extends AppCompatActivity {
    private RecyclerView veganlistinfo;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<vegan_info>arrayList;
    private RecyclerView.Adapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_vegan);
        Button button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Succescomplete = new Intent(getApplicationContext(),SelectActivity.class);
                startActivity(Succescomplete);
            }
        });

        veganlistinfo=findViewById(R.id.veganlistinfo);
        veganlistinfo.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        veganlistinfo.setLayoutManager(layoutManager);
        arrayList=new ArrayList<>();

        database=FirebaseDatabase.getInstance();

        databaseReference=database.getReference("vegan_info");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    vegan_info vegan=snapshot.getValue(vegan_info.class);
                    arrayList.add(vegan);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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

        adapter=new AdapterVegan(arrayList,this);
        veganlistinfo.setAdapter(adapter);
    }
}

