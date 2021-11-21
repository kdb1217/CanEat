package com.example.caneat;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.korean.KoreanTextRecognizerOptions;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    Button picture_button;
    FirebaseDatabase database;
    List<User> mUser;

    TextView vegan;
    TextView religion;
    TextView allergic;
    TextView ingredient;

    public String veg;
    public String rel;
    public String ing;
    public String adding;
    public String[] ingarray;

    static final int REQUEST_IMAGE_CAPTURE = 1; //카메라 변수
    Bitmap bitmap;
    InputImage image;
    TextView textview1;
    public String OCRTEXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        database = FirebaseDatabase.getInstance();

        picture_button = findViewById(R.id.picture_button);

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

        vegan=findViewById(R.id.vegan_content);
        religion=findViewById(R.id.religion_content);
        allergic=findViewById(R.id.allergic_content);
        ingredient=findViewById(R.id.ingredient_content);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference mydb = database.getReference("user").child(uid);
        mUser = new ArrayList<>();

        mydb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUser.clear();
                User user = dataSnapshot.getValue(User.class);
                mUser.add(user);
                veg = mUser.get(0).getVegan();
                rel = mUser.get(0).getReligion();
                ing = mUser.get(0).getIngredient();
                adding = mUser.get(0).getAddingredient();
                /*
                ingarray=ing.split("@");

                String str="감자, 돼지고기, 당근, 양파, 새우";
                for(String s : ingarray){
                    if(str.contains(s)){
                        Log.d("성분검출",s);
                    }
                }
                *
                */
                String viewing="";
                ingarray=ing.split("@");
                for(String s : ingarray){
                    viewing=(viewing+s+" ");
                }
                vegan.setText("내 비건: "+veg);
                religion.setText("내 종교: "+rel);
                allergic.setText("내 알레르기:"+viewing);
                ingredient.setText("내 성분: "+adding);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });


    }

    public void showCameraBtn(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            bitmap = (Bitmap) extras.get("data");
            getTextFromImage();
        }
    }

    private void getTextFromImage(){
        OCRTEXT = "";
        image = InputImage.fromBitmap(bitmap, 0);
        TextRecognizer recognizer = TextRecognition.getClient(new KoreanTextRecognizerOptions.Builder().build());
        Task<Text> result = recognizer.process(image).addOnSuccessListener(new OnSuccessListener<Text>() {
            @Override
            public void onSuccess(@NonNull Text Text) {
                StringBuilder stringBuilder = new StringBuilder();
                for(Text.TextBlock block: Text.getTextBlocks()){
                    String blockText = block.getText();
                    Point[] blockCornerPoint = block.getCornerPoints();
                    Rect blockFrame = block.getBoundingBox();
                    for(Text.Line line : block.getLines()){
                        String lineText = line.getText();
                        Point[] lineCornerPoint = line.getCornerPoints();
                        Rect linRect = line.getBoundingBox();
                        for(Text.Element element: line.getElements()){
                            String elementText = element.getText();
                            stringBuilder.append(elementText);
                        }
                    }
                    OCRTEXT = OCRTEXT + blockText;
                }
                Log.d("OCR확인", OCRTEXT);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "fail",Toast.LENGTH_SHORT).show();
            }
        });

    }
}