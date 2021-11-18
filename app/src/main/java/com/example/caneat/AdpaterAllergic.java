package com.example.caneat;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AdpaterAllergic extends RecyclerView.Adapter<AdpaterAllergic.MyHolder>{

    public String ingvalue;
    List<User> mUser;
    public String ing;
    public String ning;


    Map<String, Object> updateData = new HashMap<>();

    public Map<String, Object> getUpdateData() {
        updateData.put("ingredient",ingvalue);
        return updateData;
    }

    int i;
    ArrayList<com.example.caneat.allergic_info> arrayList;
    Context context;


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

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid=user.getUid();
            DatabaseReference mydb = database.getReference("user");
            mUser = new ArrayList<>();
            mydb.child(uid).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    mUser.clear();
                    User user = dataSnapshot.getValue(User.class);
                    mUser.add(user);
                    ing = mUser.get(0).getIngredient();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
                }
            });

            check_allergic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String datanum;

                    int pos= getAdapterPosition();
                    if (pos!=RecyclerView.NO_POSITION) {
                        allergic_info allergicInfo = arrayList.get(pos);
                        if(!(ing.contains(allergicInfo.getAllergic_ingredient()))) {
                            switch (allergicInfo.getAllergic_ingredient()) {
                                case "소고기":
                                    i = 1;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "돼지고기":
                                    i = 2;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "닭고기":
                                    i = 3;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "새우":
                                    i = 4;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "게":
                                    i = 5;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "오징어":
                                    i = 6;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "고등어":
                                    i = 7;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "우유":
                                    i = 8;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "땅콩":
                                    i = 9;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "호두":
                                    i = 10;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "잣":
                                    i = 11;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "대두":
                                    i = 12;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "복숭아":
                                    i = 13;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "토마토":
                                    i = 14;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "밀":
                                    i = 15;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "메밀":
                                    i = 16;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "아황산":
                                    i = 17;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "조개류(굴,전복,홍합 포함)":
                                    i = 18;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                                case "난류(가금류)":
                                    i = 19;
                                    datanum = Integer.toString(i);
                                    maindb.child(uid).child("myallergic_info").child(datanum).setValue(allergicInfo);
                                    ning = ing + ('@' + (allergicInfo.getAllergic_ingredient()));
                                    updateData.put("ingredient", ning);
                                    maindb.child(uid).updateChildren(updateData);
                                    break;
                            }
                        }


                    }




               }
            });


        }
    }

    public ArrayList<allergic_info> getArrayList() {
        return arrayList;
    }
}


