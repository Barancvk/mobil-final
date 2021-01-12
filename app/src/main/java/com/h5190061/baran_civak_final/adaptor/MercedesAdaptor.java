package com.h5190061.baran_civak_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.h5190061.baran_civak_final.utils.GlideUtil;
import com.h5190061.baran_civak_final.models.MercedesModel;
import com.h5190061.baran_civak_final.R;

import java.util.List;

public class MercedesAdaptor extends RecyclerView.Adapter<MercedesViewHolder> {

    List<MercedesModel> mercedesler;
    Context context;
    OnItemClickListener listener;
    public interface OnItemClickListener {
        void onClik(int position);
    }
    public MercedesAdaptor(List<MercedesModel> mercedesler, Context context, OnItemClickListener listener) {
        this.mercedesler = mercedesler;
        this.context = context;
        this.listener =listener;
    }

    @NonNull
    @Override
    public MercedesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mercedes,parent,false);
        return new MercedesViewHolder(itemView,listener);
    }
    private void init(){

    }
    @Override
    public void onBindViewHolder(@NonNull MercedesViewHolder viewHolder, int position) {
        viewHolder.txtFiyat.setText(mercedesler.get(position).getFiyat());
        viewHolder.txtMercedesAdi.setText(mercedesler.get(position).getModel());
        viewHolder.txtBeygirCardView.setText(mercedesler.get(position).getBeygir());
        viewHolder.txtYilCardView.setText(mercedesler.get(position).getYil());

        GlideUtil.resmiIndiripGoster(context,mercedesler.get(position).getBirinciFotoUrl(),viewHolder.imgMercedesKapak);
    }
    @Override
    public int getItemCount() {
        return mercedesler.size();
    }
}