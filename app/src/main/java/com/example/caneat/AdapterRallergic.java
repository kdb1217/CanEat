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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Base64;

public class AdapterRallergic extends RecyclerView.Adapter<AdapterRallergic.RHolder>{

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
            DatabaseReference maindb= database.getReference("user").child(uid).child("myallergic_info");

            this.check_allergic=itemView.findViewById(R.id.remove_allergic);
            this.ingredient_content=itemView.findViewById(R.id.allergic_content);
            this.ingredient_title=itemView.findViewById(R.id.allergic_title);

            check_allergic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  int pos =getAdapterPosition();
                  if(pos!=RecyclerView.NO_POSITION){
                      myallergic_info Myallergic_info=arrayList.get(pos);
                        switch (Myallergic_info.getAllergic_ingredient()){
                              case "소고기":

                                  maindb.child("1").removeValue();
                                  break;
                              case "돼지고기":
                                  maindb.child("2").removeValue();
                                  break;
                              case "닭고기":
                                  maindb.child("3").removeValue();
                                  break;
                              case "새우":
                                  maindb.child("4").removeValue();
                                  break;
                              case "게":
                                  maindb.child("5").removeValue();
                                  break;
                              case "오징어":
                                  maindb.child("6").removeValue();
                                  break;
                              case "고등어":
                                  maindb.child("7").removeValue();
                                  break;
                              case "우유":
                                  maindb.child("8").removeValue();
                                  break;
                              case "땅콩":
                                  maindb.child("9").removeValue();
                                  break;
                              case "호두":
                                  maindb.child("10").removeValue();
                                  break;
                              case "잣":
                                  maindb.child("11").removeValue();
                                  break;
                              case "대두":
                                  maindb.child("12").removeValue();
                                  break;
                              case "복숭아":
                                  maindb.child("13").removeValue();
                                  break;
                              case "토마토":
                                  maindb.child("14").removeValue();
                                  break;
                              case "밀":
                                  maindb.child("15").removeValue();
                                  break;
                              case "메밀":
                                  maindb.child("16").removeValue();
                                  break;
                              case "아황산":
                                  maindb.child("17").removeValue();
                                  break;
                              case "조개류(굴,전복,홍합 포함)":
                                  maindb.child("18").removeValue();
                                  break;
                              case "난류(가금류)":
                                  maindb.child("19").removeValue();
                                  break;
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
