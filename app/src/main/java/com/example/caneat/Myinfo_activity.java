package com.example.caneat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Myinfo_activity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth auth;
    Button google_signout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo);



        google_signout=findViewById(R.id.google_logout);
        auth=FirebaseAuth.getInstance();
        google_signout.setOnClickListener(this);






    }
    @Override
    public void onClick(View view){
        setGoogle_signout();
        Intent google_signout =new Intent(getApplicationContext(),IntroActivity.class);
        startActivity(google_signout);


    }



    private  void setGoogle_signout(){
        FirebaseAuth.getInstance().signOut();

    }
}