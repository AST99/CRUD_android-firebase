package com.astdev.supmti_examapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.Viewholder> {

    private final List<Users> modelList;

    public static String strShowName, strShowPhone, strShowMail, strShowPass;


    public ListViewAdapter(List<Users> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_all_users,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        try{
            String name = modelList.get(position).getUsername();
            String phone = modelList.get(position).getPhone();
            String mail = modelList.get(position).getEmail();
            String pass = modelList.get(position).getPassWrd();
            holder.setData(name, mail/*, phone*/);

            holder.cardView.setOnClickListener(view -> {
                view.getContext().startActivity(new Intent(view.getContext(), UserProfil.class));

                strShowName = name;
                strShowPhone = phone;
                strShowMail = mail;
                strShowPass = pass;
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder{

        private final TextView name, mail;

        final CardView cardView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.Nom);
            mail = itemView.findViewById(R.id.Email);
            cardView = itemView.findViewById(R.id.cardV);
        }

        public void setData(String txtNom, String txtmail){
            name.setText(txtNom);
            mail.setText(txtmail);
        }
    }
}
