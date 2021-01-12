package com.h5190061.baran_civak_final.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.h5190061.baran_civak_final.utils.AlertDialogUtil;
import com.h5190061.baran_civak_final.utils.Constants;
import com.h5190061.baran_civak_final.adaptor.MercedesAdaptor;
import com.h5190061.baran_civak_final.models.MercedesModel;
import com.h5190061.baran_civak_final.utils.ObjectUtil;
import com.h5190061.baran_civak_final.R;
import com.h5190061.baran_civak_final.network.Service;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        init();
        progressDialog = new ProgressDialog(ListeActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.bekle_komutu));
        progressDialog.show();


    }
    private  void  init()
    {
        mercedesGetir();
    }

    void  mercedesGetir()
    {

        new Service().getServiceApi().mercedesleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<MercedesModel>>()
                {

                    List<MercedesModel> mercedesaraclar=new ArrayList<>();


                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<MercedesModel> mercedeslist) {
                        Log.e("RETROFIT","onNext : ");
                        mercedesaraclar=mercedeslist;
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();
                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");
                        progressDialog.dismiss();

                        if(mercedesaraclar.size()>0) {




                            initRecycleView(mercedesaraclar);

                        }
                    }
                });
    }
    @Override
    public void onBackPressed() {

        AlertDialogUtil.alertDialoguGoster(ListeActivity.this,getResources().getString(R.string.uygulama_uyari),
                getResources().getString(R.string.uygulama_cikma),
                getResources().getString(R.string.uygulama_evet),getResources().getString(R.string.uygulama_hayir),
                getResources().getString(R.string.listeactivityekrani)); }



    private  void  initRecycleView(List<MercedesModel> mercedesList)
    {
        recyclerView =findViewById(R.id.rcvMercedesler);
        MercedesAdaptor MercedesAdaptor =new MercedesAdaptor(mercedesList, getApplicationContext(), new MercedesAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {

                MercedesModel tiklananMercedes =mercedesList.get(position);
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.tiklanan_adi) + tiklananMercedes.getModel(), Toast.LENGTH_SHORT).show();
                opennextActivity(tiklananMercedes);



            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(MercedesAdaptor);
    }

    private void opennextActivity(MercedesModel tiklananMercedes){
        Intent secondActivityIntent=new Intent(getApplicationContext(), MercedesDetayActivity.class);
        String tiklananMercedesString= ObjectUtil.mercedesToJsonString(tiklananMercedes);
        secondActivityIntent.putExtra(Constants.TIKLANAN_MERCEDES_TASINANIN_BASLIGI,tiklananMercedesString);
        startActivity(secondActivityIntent);
    }

}