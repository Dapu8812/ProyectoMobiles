package com.uniquindio.android.electiva.proyectomobiles.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DAA on 29/04/2016.
 */
public class Telefono implements Parcelable{
    String numero;
    String extension;

    public Telefono(String numero, String extension) {
        this.numero = numero;
        this.extension = extension;
    }

    protected Telefono(Parcel in) {
        numero = in.readString();
        extension = in.readString();
    }

    public static final Creator<Telefono> CREATOR = new Creator<Telefono>() {
        @Override
        public Telefono createFromParcel(Parcel in) {
            return new Telefono(in);
        }

        @Override
        public Telefono[] newArray(int size) {
            return new Telefono[size];
        }
    };

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numero);
    }
}
