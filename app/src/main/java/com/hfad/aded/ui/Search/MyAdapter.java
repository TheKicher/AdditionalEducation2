package com.hfad.aded.ui.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.aded.R;
import com.hfad.aded.ShowActivity;
import com.hfad.aded.User;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private OnClickListener onClickListener;
    Context context;

    ArrayList<User> list;

    public MyAdapter(Context context, ArrayList<User> list, OnClickListener onClickListener) {
        this.context = context;
        this.list = list;
        this.onClickListener = onClickListener;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v  = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
       return new MyViewHolder(v, onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = list.get(position);
        holder.city.setText(user.getCity());
        holder.name.setText(user.getName());
        holder.prof.setText(user.getProf());
        holder.disc.setText(user.getDisc());
        holder.price.setText(user.getPrice());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView city, name, prof, disc, price;
        OnClickListener onClickListener;


        public MyViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);

            city = itemView.findViewById(R.id.itCity);
            name = itemView.findViewById(R.id.itName);
            prof = itemView.findViewById(R.id.itProf);
            disc = itemView.findViewById(R.id.itDisc);
            price = itemView.findViewById(R.id.itPrice);
            this.onClickListener = onClickListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(getAdapterPosition());
        }
    }

    public interface OnClickListener{
        void onClick(int position);
    }

}
