package com.h5190061.baran_civak_final.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.h5190061.baran_civak_final.R;

public class AlertDialogUtil {
    public static void alertDialoguGoster(Context context, String baslikYazisi, String mesajYazisi, String evet, String hayir , String ekran)
    {
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setTitle(baslikYazisi);
        builder.setMessage(mesajYazisi);
        builder.setPositiveButton(evet, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(ekran.toString() == context.getResources().getString(R.string.mainactivityekrani)){
                    context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
                }
                if(ekran.toString() == context.getResources().getString(R.string.listeactivityekrani)){
                    ((Activity)context).onBackPressed();
                    ((Activity)context).finish();
                }

            }
        });

        builder.setNegativeButton(hayir, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(ekran.toString() == context.getResources().getString(R.string.mainactivityekrani)){
                    ((Activity)context).finish();
                }
                if(ekran.toString() == context.getResources().getString(R.string.listeactivityekrani)){
                    window.dismiss();
                }

            }
        });
        builder.show();
    }
}
