package com.example.caneat;

import android.content.ClipData;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.awt.font.NumericShaper;
import java.sql.BatchUpdateException;
import java.util.ArrayList;


public class AdpaterAllergic extends RecyclerView.Adapter<AdpaterAllergic.MyHolder>{


     public int i=1;
     final ArrayList<com.example.caneat.allergic_info> arrayList;
     final Context context;


    public AdpaterAllergic(ArrayList<allergic_info> arrayList,Context context) {
        this.arrayList=arrayList;
        this.context=context;
    }



    @NonNull
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_allergic,parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder (@NonNull MyHolder holder, int position){
        final allergic_info Allergic_info=arrayList.get(position);

        holder.ingredient_title.setText(arrayList.get(position).getAllergic_name());
        holder.ingredient_content.setText(arrayList.get(position).getAllergic_ingredient());

    }
    public int getItemCount() {
        if (arrayList !=null) {
            return arrayList.size();
        }
        return 0;
    }


    class MyHolder extends RecyclerView.ViewHolder{
        TextView ingredient_title;
        TextView ingredient_content;
        Button check_allergic;



        public MyHolder(@NonNull View itemView){
            super(itemView);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference maindb= database.getReference("user");




            this.check_allergic=itemView.findViewById(R.id.check_allergic);
            this.ingredient_title =itemView.findViewById(R.id.ingredient_title);
            this.ingredient_content=itemView.findViewById(R.id.ingredient_content);

            check_allergic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String datanum=Integer.toString(i);
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String uid=user.getUid();
                    int pos= getAdapterPosition();
                    if (pos!=RecyclerView.NO_POSITION){
                        allergic_info allergicInfo =arrayList.get(pos);
                        maindb.child(uid).child("myallergic_info").child(allergicInfo.getAllergic_name()).setValue(allergicInfo.getAllergic_ingredient());
                        i++;

                    }


               }
            });


        }
    }

    public ArrayList<allergic_info> getArrayList() {
        return arrayList;
    }
}


