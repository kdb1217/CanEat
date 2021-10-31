package com.example.caneat;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdpaterAllergic extends RecyclerView.Adapter<AdpaterAllergic.MyHolder>{

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
        holder.check_allergic.setOnCheckedChangeListener(null);//체크박스 리스너 null로 초기화

        holder.check_allergic.setChecked(Allergic_info.isInSelected());//모델클래스의 getter로 체크 상태값을 가저온후 setter를 통해 이 값을 아이템 안의 체크박스에 set한다

        holder.check_allergic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Allergic_info.setInSelected(isChecked);

            }
        });



        holder.ingredient_title.setText(arrayList.get(position).getAllergic_name());
        holder.ingredient_content.setText(arrayList.get(position).getAllergic_ingredient());


    }
    public int getItemCount() {
        if (arrayList !=null) {
            return arrayList.size();
        }
        return 0;
    }


    static class MyHolder extends RecyclerView.ViewHolder{
        TextView ingredient_title, ingredient_content;
        CheckBox check_allergic;

        public MyHolder(@NonNull View itemView){

            super(itemView);
            this.check_allergic=itemView.findViewById(R.id.check_allergic);
            this.ingredient_title =itemView.findViewById(R.id.ingredient_title);
            this.ingredient_content=itemView.findViewById(R.id.ingredient_content);

        }
    }





}


