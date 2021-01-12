package com.h5190061.baran_civak_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190061.baran_civak_final.R;

public class MercedesViewHolder extends RecyclerView.ViewHolder {
    ImageView imgMercedesKapak;
    TextView txtMercedesAdi,txtFiyat,txtBeygirCardView,txtYilCardView;

    public MercedesViewHolder(@NonNull View cardView, MercedesAdaptor.OnItemClickListener listener) {
        super(cardView);
        imgMercedesKapak =cardView.findViewById(R.id.imgMercedesKapak);
        txtMercedesAdi =cardView.findViewById(R.id.txtMercedesAdi);
        txtFiyat =cardView.findViewById(R.id.txtFiyat);
        txtBeygirCardView =cardView.findViewById(R.id.txtBeygirCardView);
        txtYilCardView =cardView.findViewById(R.id.txtYilCardView);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClik(getAdapterPosition());
            }
        });
    }
}