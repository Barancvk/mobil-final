package com.h5190061.baran_civak_final.network;

import com.h5190061.baran_civak_final.models.MercedesModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("MercedesBenz.json")
    Observable<List<MercedesModel>> mercedesleriGetir();
}
