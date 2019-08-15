package com.ariabdulmajid.ariapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ariabdulmajid.ariapps.R;
import com.ariabdulmajid.ariapps.activity.DetailTemanActivity;
import com.ariabdulmajid.ariapps.data.model.TemanModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */


public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.ViewHolder>  {

    private ArrayList<TemanModel> temanModel;
    private Context context;

    public TemanAdapter(ArrayList<TemanModel> temanModel, Context context) {
        this.temanModel = temanModel;
        this.context = context;
    }

    public void setData(ArrayList<TemanModel> items) {
        this.temanModel = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_teman, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        int[] ava = {R.drawable.ava1, R.drawable.ava2, R.drawable.ava3, R.drawable.ava4, R.drawable.ava5};
        Random ran = new Random();
        int j = ran.nextInt(ava.length);

        viewHolder.imgAva.setImageResource(ava[j]);
        viewHolder.tvNama.setText(temanModel.get(i).getNama());
        viewHolder.tvNIM.setText(temanModel.get(i).getNim());

        final TemanModel item = temanModel.get(i);
        final int pos = i;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailTemanActivity.class);
                i.putExtra("friend", item);
                i.putExtra("position", pos);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return temanModel.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAva;
        TextView tvNama, tvNIM;

        ViewHolder(View itemView) {
            super(itemView);
            imgAva = itemView.findViewById(R.id.imgAva);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNIM = itemView.findViewById(R.id.tvNim);
        }
    }

}
