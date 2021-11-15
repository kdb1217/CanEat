package com.example.caneat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdapterVegan extends RecyclerView.Adapter<AdapterVegan.VHolder> {
    final ArrayList<vegan_info> arrayList1;
    final Context context;

    public AdapterVegan(ArrayList<vegan_info> arrayList, Context context) {
        this.arrayList1 = arrayList;
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
        final vegan_info Vegan_info=arrayList1.get(position);

        holder.ingredient_title.setText(arrayList1.get(position).getVegan_name());
        holder.ingredient_context.setText(arrayList1.get(position).getVegan_ingredient());
    }
    public int getItemCount(){
        if(arrayList1!=null){
            return arrayList1.size();
        }
        return 0;
    }

    public class VHolder extends RecyclerView.ViewHolder{
        TextView ingredient_title,ingredient_context;
        Button check_allergic;

        public VHolder(@NonNull View itemView){
            super(itemView);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference maindb= database.getReference("user");

            this.check_allergic=itemView.findViewById(R.id.check_allergic);
            this.ingredient_title=itemView.findViewById(R.id.ingredient_title);
            this.ingredient_context=itemView.findViewById(R.id.ingredient_content);

            check_allergic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String uid=user.getUid();
                    int pos= getAdapterPosition();
                    if (pos!=RecyclerView.NO_POSITION){
                        vegan_info Vegan_info= arrayList1.get(pos);
                        maindb.child(uid).child("myvegan_info").setValue(Vegan_info);
                    }
                }
            });
        }
    }
    public ArrayList<vegan_info> getArrayList(){
        return arrayList1;
    }
}
