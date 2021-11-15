package com.example.caneat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Change_ingredient_activity extends AppCompatActivity {
    public int i=1;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference maindb= database.getReference("user");
    String ingredient;
    EditText edit_ingredient;
    Button register;
    private Toast toast;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_ingredient);

        edit_ingredient = findViewById(R.id.edit_ingredient);
        register=findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String datanum=Integer.toString(i);
                ingredient=edit_ingredient.getText().toString();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid=user.getUid();
                maindb.child(uid).child("myingredient").child(datanum).setValue(ingredient);
                toast=Toast.makeText(getApplicationContext(),"등록이 완료 되었습니다.",Toast.LENGTH_SHORT);
                toast.show();
                i++;



            }
        });

        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(button);
            }
        });

        Button My_info = (Button) findViewById(R.id.myinfo);
        My_info.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent My_info = new Intent(getApplicationContext(),Myinfo_activity.class);
                startActivity(My_info);
            }
        });
    }
}

