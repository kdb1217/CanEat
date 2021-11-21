package com.example.caneat;

import android.content.Context;
import android.util.Log;
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
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterRallergic extends RecyclerView.Adapter<AdapterRallergic.RHolder>{
    List<User> mUser;
    public String ing;
    public String ingvalue;
    public String ning;

    Map<String, Object> updateData = new HashMap<>();

    public Map<String, Object> getUpdateData() {
        updateData.put("ingredient",ingvalue);
        return updateData;
    }

    final ArrayList<myallergic_info> arrayList;
    final Context context;

    public AdapterRallergic(ArrayList<myallergic_info>arrayList,Context context){
        this.arrayList=arrayList;
        this.context=context;
    }


    @NonNull
    public RHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.remove_allergic,parent,false);
        RHolder holder= new RHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RHolder holder,int position){
        final myallergic_info Myallergic_info=arrayList.get(position);

        holder.ingredient_title.setText(arrayList.get(position).getAllergic_name());
        holder.ingredient_content.setText(arrayList.get(position).getAllergic_ingredient());
    }

    public int getItemCount(){
        if(arrayList!=null){
            return arrayList.size();
        }
        return 0;
    }

    public class RHolder extends RecyclerView.ViewHolder{
        TextView ingredient_title,ingredient_content;
        Button check_allergic;


        public RHolder( View itemView){
            super(itemView);
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid=user.getUid();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference maindb= database.getReference("user").child(uid);

            this.check_allergic=itemView.findViewById(R.id.remove_allergic);
            this.ingredient_content=itemView.findViewById(R.id.allergic_content);
            this.ingredient_title=itemView.findViewById(R.id.allergic_title);

            mUser = new ArrayList<>();
            maindb.addValueEventListener(new ValueEventListener() {
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
                  int pos =getAdapterPosition();
                  if(pos!=RecyclerView.NO_POSITION) {
                      myallergic_info Myallergic_info = arrayList.get(pos);

                      switch (Myallergic_info.getAllergic_ingredient()) {
                          case "소고기":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("1").removeValue();
                              break;
                          case "돼지고기":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("2").removeValue();
                              break;
                          case "닭고기":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("3").removeValue();
                              break;
                          case "새우":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("4").removeValue();
                              break;
                          case "게":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("5").removeValue();
                              break;
                          case "오징어":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("6").removeValue();
                              break;
                          case "고등어":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("7").removeValue();
                              break;
                          case "우유":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("8").removeValue();
                              break;
                          case "땅콩":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("9").removeValue();
                              break;
                          case "호두":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("10").removeValue();
                              break;
                          case "잣":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("11").removeValue();
                              break;
                          case "대두":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("12").removeValue();
                              break;
                          case "복숭아":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("13").removeValue();
                              break;
                          case "토마토":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("14").removeValue();
                              break;
                          case "밀":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("15").removeValue();
                              break;
                          case "메밀":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("16").removeValue();
                              break;
                          case "아황산":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("17").removeValue();
                              break;
                          case "조개류(굴,전복,홍합 포함)":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("18").removeValue();
                              break;
                          case "난류(가금류)":
                              ning = ing.replace(("@" + Myallergic_info.getAllergic_ingredient()), "");
                              updateData.put("ingredient", ning);
                              maindb.updateChildren(updateData);
                              maindb.child("myallergic_info").child("19").removeValue();
                              break;
                      }
                      if(ning.equals("")) {
                          updateData.put("ingredient", "없음");
                          maindb.updateChildren(updateData);
                      }
                  }

                }
            });

        }
    }
    public ArrayList<myallergic_info>getArrayList(){
        return arrayList;
    }
}
