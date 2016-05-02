package com.uniquindio.android.electiva.proyectomobiles.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 * 28 de Abril de 2016
 */
public class Telefono implements Parcelable{
    String numero;
    String extension;
    String Dueño;

    public Telefono(String numero, String extension, String dueño) {

        this.numero = numero;
        this.extension = extension;
        this.Dueño = dueño;
    }

    protected Telefono(Parcel in) {
        numero = in.readString();
        extension = in.readString();
        Dueño = in.readString();
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getDueño() {
        return Dueño;
    }

    public void setDueño(String dueño) {
        Dueño = dueño;
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
        dest.writeString(extension);
        dest.writeString(Dueño);

    }
}
