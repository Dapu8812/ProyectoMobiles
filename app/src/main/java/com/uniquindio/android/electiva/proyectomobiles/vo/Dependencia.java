package com.uniquindio.android.electiva.proyectomobiles.vo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by DAA on 29/04/2016.
 */
public class Dependencia implements Parcelable{
    private String nombre;
    private ArrayList<Telefono> telefonos;


 /**   public Dependencia(String nombre) {
        this.nombre = nombre;
    }*/

    public Dependencia(String nombre, ArrayList<Telefono> telefonos) {
        this.nombre = nombre;
        this.telefonos = telefonos;
    }

    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dependencia(Parcel in) {
        nombre = in.readString();
        telefonos = in.createTypedArrayList(Telefono.CREATOR);
    }

    public static final Creator<Dependencia> CREATOR = new Creator<Dependencia>() {
        @Override
        public Dependencia createFromParcel(Parcel in) {
            return new Dependencia(in);
        }

        @Override
        public Dependencia[] newArray(int size) {
            return new Dependencia[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
    }
}
