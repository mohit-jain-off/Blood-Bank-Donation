package com.example.batman.blooddonation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Lol> {
    private Context context;
    ArrayList<DonorsDet> donorsDets;

    public RecyclerViewAdapter(Context context, ArrayList<DonorsDet> donorsDets) {
        this.context = context;
        this.donorsDets = donorsDets;
    }

    @NonNull
    @Override
    public Lol onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.card,viewGroup,false);


        return new Lol(view);




    }

    @Override
    public void onBindViewHolder(@NonNull Lol lol, int i) {
                 lol.bind(i);
    }

    @Override
    public int getItemCount() {
        return donorsDets.size();
    }

    public class Lol extends RecyclerView.ViewHolder {
        TextView place,name,contact;
        ImageView imageView,imageView2,imageView3;
        public Lol(@NonNull View itemView) {
            super(itemView);
           place=(TextView) itemView.findViewById(R.id.location);
             name=(TextView)itemView.findViewById(R.id.Name);
             contact=(TextView)itemView.findViewById(R.id.contact);
             imageView=(ImageView)itemView.findViewById(R.id.imageView);
             imageView2=(ImageView)itemView.findViewById(R.id.imageView2);
             imageView3=(ImageView)itemView.findViewById(R.id.imageView3);

        }

        public void bind(int i) {


            place.setText(donorsDets.get(i).getPlace());
            name.setText(donorsDets.get(i).getName());
            contact.setText(donorsDets.get(i).getContact());
            imageView.setBackgroundResource(R.drawable.donoor);



        }
    }
}
