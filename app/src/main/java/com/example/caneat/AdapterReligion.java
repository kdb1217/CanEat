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

public class AdapterReligion extends RecyclerView.Adapter<AdapterReligion.AHolder> {

    final ArrayList<religion_info>arrayList;
    final Context context;

    public AdapterReligion(ArrayList<religion_info>arrayList,Context context){
        this.arrayList=arrayList;
        this.context=context;
    }


    @NonNull
    public AHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_allergic,parent,false);
        AHolder holder=new AHolder(view);
        return holder;
    }
   @Override
   public void onBindViewHolder(@NonNull AHolder holder,int position){
        final religion_info Religion_info=arrayList.get(position);
        holder.check_allergic.setOnCheckedChangeListener(null);

        holder.check_allergic.setChecked(Religion_info.isInSelected());

        holder.check_allergic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Religion_info.setInSelected(isChecked);


            }
        });

        holder.ingredient_title.setText(arrayList.get(position).getReligion_name());
        holder.ingredient_content.setText(arrayList.get(position).getReligion_ingredient());
   }




    public int getItemCount(){
        if(arrayList!=null){
            return arrayList.size();
        }
        return 0;
    }


    static class AHolder extends RecyclerView.ViewHolder{
        TextView ingredient_title,ingredient_content;
        CheckBox check_allergic;

        public  AHolder(@NonNull View itemView){
            super(itemView);
            this.check_allergic=itemView.findViewById(R.id.check_allergic);
            this.ingredient_title=itemView.findViewById(R.id.ingredient_title);
            this.ingredient_content=itemView.findViewById(R.id.ingredient_content);
        }
    }
    public ArrayList<religion_info>getArrayList(){
        return arrayList;
    }
}
