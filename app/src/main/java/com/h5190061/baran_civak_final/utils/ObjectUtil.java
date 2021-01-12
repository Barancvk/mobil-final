package com.h5190061.baran_civak_final.utils;

import com.google.gson.Gson;
import com.h5190061.baran_civak_final.models.MercedesModel;


public class ObjectUtil {
    public  static String mercedesToJsonString(MercedesModel mercedesModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(mercedesModel);
    }
    public  static MercedesModel jsonStringToMercedes(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,MercedesModel.class);
    }
}