package com.h5190061.baran_civak_final.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MercedesModel {
    @SerializedName("BirinciFotoUrl")
    @Expose
    private String birinciFotoUrl;
    @SerializedName("IkinciFotoUrl")
    @Expose
    private String ikinciFotoUrl;
    @SerializedName("Model")
    @Expose
    private String model;
    @SerializedName("Yil")
    @Expose
    private String yil;
    @SerializedName("Fiyat")
    @Expose
    private String fiyat;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;
    @SerializedName("MotorHacmi")
    @Expose
    private String motorHacmi;
    @SerializedName("VitesTipi")
    @Expose
    private String vitesTipi;
    @SerializedName("YakitTipi")
    @Expose
    private String yakitTipi;
    @SerializedName("Beygir")
    @Expose
    private String beygir;

    public String getBirinciFotoUrl() {
        return birinciFotoUrl;
    }

    public void setBirinciFotoUrl(String birinciFotoUrl) {
        this.birinciFotoUrl = birinciFotoUrl;
    }

    public String getIkinciFotoUrl() {
        return ikinciFotoUrl;
    }

    public void setIkinciFotoUrl(String ikinciFotoUrl) {
        this.ikinciFotoUrl = ikinciFotoUrl;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYil() {
        return yil;
    }

    public void setYil(String yil) {
        this.yil = yil;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getMotorHacmi() {
        return motorHacmi;
    }

    public void setMotorHacmi(String motorHacmi) {
        this.motorHacmi = motorHacmi;
    }

    public String getVitesTipi() {
        return vitesTipi;
    }

    public void setVitesTipi(String vitesTipi) {
        this.vitesTipi = vitesTipi;
    }

    public String getYakitTipi() {
        return yakitTipi;
    }

    public void setYakitTipi(String yakitTipi) {
        this.yakitTipi = yakitTipi;
    }

    public String getBeygir() {
        return beygir;
    }

    public void setBeygir(String beygir) {
        this.beygir = beygir;
    }


}
