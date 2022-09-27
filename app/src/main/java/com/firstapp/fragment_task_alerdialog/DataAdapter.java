package com.firstapp.fragment_task_alerdialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    Context context;
    List<DataModel>dataModelList;
    RecyclerView recyclerView;


    public DataAdapter(Context context, List<DataModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //using layoutinflater to call the layouts
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_design,parent,false);

        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(dataModelList.get(position).getName());
        holder.mail.setText(dataModelList.get(position).getMail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //using bundel to fragment to fragment
                Bundle bundle=new Bundle();
                bundle.putString("Name",dataModelList.get(position).getName());
                bundle.putString("Mail",dataModelList.get(position).getMail());
                bundle.putString("Address",dataModelList.get(position).getAddress());
                bundle.putString("Mobile",dataModelList.get(position).getMobilenumber());
                bundle.putString("Designation",dataModelList.get(position).getDesgnation());

                //this method use to naviagte to the one fragment to another fragment
                Fragment fragment_two=new Fragment_Two();
                fragment_two.setArguments(bundle);
                FragmentManager fragmentManager= ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,fragment_two);
                fragmentTransaction.attach(fragment_two);
                fragmentTransaction.commit();





            }
        });
    }










    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,mail;
        ImageView nextarrow;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.custom_name);
            mail=itemView.findViewById(R.id.custom_MailId);

            nextarrow=itemView.findViewById(R.id.next_arrow);

        }

    }
}
