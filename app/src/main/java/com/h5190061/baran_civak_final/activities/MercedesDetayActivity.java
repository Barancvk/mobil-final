package com.h5190061.baran_civak_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190061.baran_civak_final.utils.Constants;
import com.h5190061.baran_civak_final.utils.GlideUtil;
import com.h5190061.baran_civak_final.models.MercedesModel;
import com.h5190061.baran_civak_final.utils.ObjectUtil;
import com.h5190061.baran_civak_final.R;

public class MercedesDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtModelAdi, txtBeygir, txtVitesTipi,txtYakitTipi,txtYil,txtAciklama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercedes_detay);
        init();



    }
    private void init(){

        String tasinanMercedesString=getIntent().getStringExtra(Constants.TIKLANAN_MERCEDES_TASINANIN_BASLIGI);
        MercedesModel mercedesModel= ObjectUtil.jsonStringToMercedes(tasinanMercedesString);

        imgKapak=findViewById(R.id.imgKapak);
        txtModelAdi=findViewById(R.id.txtModelAdi);
        txtBeygir=findViewById(R.id.txtBeygir);
        txtVitesTipi=findViewById(R.id.txtVitesTipi);
        txtYakitTipi=findViewById(R.id.txtYakitTipi);
        txtYil=findViewById(R.id.txtYil);
        txtAciklama=findViewById(R.id.txtAciklama);
        String mercedesAciklama=mercedesModel.getAciklama();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            txtAciklama.setText(Html.fromHtml(mercedesAciklama, Html.FROM_HTML_MODE_LEGACY));
        } else{
            txtAciklama.setText(Html.fromHtml(mercedesAciklama));
        }

        txtModelAdi.setText((mercedesModel.getModel()));
        txtBeygir.setText((mercedesModel.getBeygir()));
        txtVitesTipi.setText(mercedesModel.getVitesTipi());
        txtYakitTipi.setText(mercedesModel.getYakitTipi());
        txtYil.setText(mercedesModel.getYil());



        GlideUtil.resmiIndiripGoster(getApplicationContext(),mercedesModel.getIkinciFotoUrl(),imgKapak);

    }
}