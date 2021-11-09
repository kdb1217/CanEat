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

public class AdapterVegan extends RecyclerView.Adapter<AdapterVegan.VHolder> {
    final ArrayList<vegan_info> arrayList;
    final Context context;

    public AdapterVegan(ArrayList<vegan_info> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    public VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_allergic,parent,false);
        VHolder holder=new VHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull VHolder holder,int position){
        final vegan_info Vegan_info=arrayList.get(position);
        holder.check_allergic.setOnCheckedChangeListener(null);

        holder.check_allergic.setChecked(Vegan_info.isInSelected());

        holder.check_allergic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Vegan_info.setInSelected(isChecked);
            }
        });

        holder.ingredient_title.setText(arrayList.get(position).getVegan_name());
        holder.ingredient_context.setText(arrayList.get(position).getVegan_ingredient());
    }
    public int getItemCount(){
        if(arrayList!=null){
            return arrayList.size();
        }
        return 0;
    }

    static class VHolder extends RecyclerView.ViewHolder{
        TextView ingredient_title,ingredient_context;
        CheckBox check_allergic;

        public VHolder(@NonNull View itemView){
            super(itemView);
            this.check_allergic=itemView.findViewById(R.id.check_allergic);
            this.ingredient_title=itemView.findViewById(R.id.ingredient_title);
            this.ingredient_context=itemView.findViewById(R.id.ingredient_content);
        }
    }
    public ArrayList<vegan_info>getArrayList(){
        return arrayList;
    }
}
