package com.example.caneat;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button picture_button;
    FirebaseDatabase database;
    List<User> mUser;
    public String ing;
    public String[] ning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        database = FirebaseDatabase.getInstance();

        picture_button = findViewById(R.id.picture_button);
        picture_button.setOnClickListener(this);

        Button change_allergic=findViewById(R.id.change_allergic);
        change_allergic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change_allergic=new Intent(getApplicationContext(),Change_allergic_activity.class);
                startActivity(change_allergic);
            }
        });
        Button change_religion=(Button) findViewById(R.id.change_religion);
        change_religion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change_religion=new Intent(getApplicationContext(),Change_religion_activity.class);
                startActivity(change_religion);
            }
        });

        Button vegan_change=findViewById(R.id.vegan_change);
        vegan_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vegan_change=new Intent(getApplicationContext(),Change_vegan_activity.class);
                startActivity(vegan_change);
            }
        });

        Button My_info = (Button) findViewById(R.id.myinfo);
        My_info.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent My_info = new Intent(getApplicationContext(),Myinfo_activity.class);
                startActivity(My_info);
            }
        });

        Button change_ingredient=findViewById(R.id.change_ingredient);
        change_ingredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change_ingredient =new Intent(getApplicationContext(),Change_ingredient_activity.class);
                startActivity(change_ingredient);
            }
        });

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        Log.d("로그확인",uid);
        DatabaseReference mydb = database.getReference("user").child(uid);
        mUser = new ArrayList<>();

        mydb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUser.clear();
                User user = dataSnapshot.getValue(User.class);
                mUser.add(user);
                ing = mUser.get(0).getIngredient();
                ning =ing.split("@");
                String str="감자, 돼지고기, 당근, 양파, 새우";
                for(String s : ning){
                    if(str.contains(s)){
                        Log.d("성분검출",s);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });



    }

    @Override
    public void onClick(View view) {
        scanCode();
    }

    private void scanCode() {

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(Capture.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scanning Code");
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() != null){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(result.getContents());
                builder.setTitle("Scanning Result");
                builder.setPositiveButton("Scan Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        scanCode();
                    }
                }).setNegativeButton("finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }

            else{
                Toast.makeText(this,"No Results", Toast.LENGTH_LONG).show();
            }
        }else {
            super.onActivityResult(requestCode, resultCode,data);
        }
    }


}