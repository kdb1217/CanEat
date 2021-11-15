package com.example.caneat;

import android.content.ClipData;
import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
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
    public String[] getAr() {
        return ar;
    }

    String[] ar=new String[20];
     IntroActivity f=new IntroActivity();
     int x=f.getI();
     int i;
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
                    String datanum;


                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String uid=user.getUid();
                    int pos= getAdapterPosition();
                    if (pos!=RecyclerView.NO_POSITION){
                        allergic_info allergicInfo =arrayList.get(pos);
                        switch (allergicInfo.getAllergic_ingredient()){
                            case "소고기":
                                i=1;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "돼지고기":
                                i=2;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "닭고기":
                                i=3;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "새우":
                                i=4;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "게":
                                i=5;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "오징어":
                                i=6;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "고등어":
                                i=7;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "우유":
                                i=8;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "땅콩":
                                i=9;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "호두":
                                i=10;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "잣":
                                i=11;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "대두":
                                i=12;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "복숭아":
                                i=13;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "토마토":
                                i=14;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "밀":
                                i=15;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "메밀":
                                i=16;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "아황산":
                                i=17;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "조개류(굴,전복,홍합 포함)":
                                i=18;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                            case "난류(가금류)":
                                i=19;
                                ar[x]=allergicInfo.getAllergic_ingredient();
                                x++;
                                datanum=Integer.toString(i);
                                maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                break;
                        }


                       /* if(allergicInfo.getAllergic_ingredient().equals("소고기")){
                            i=1;
                            ar[y]=allergicInfo.getAllergic_ingredient();
                            y++;
                            String datanum=Integer.toString(i);
                            maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                        }
                        */



                    }


               }
            });


        }
    }

    public ArrayList<allergic_info> getArrayList() {
        return arrayList;
    }
}


