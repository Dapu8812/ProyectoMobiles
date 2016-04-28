package com.uniquindio.android.electiva.proyectomobiles.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 * 28 de Abril de 2016
 */
public class Noticia implements Parcelable{

    private String titulo;
    private String descripcion;
    private ImageView imagennoticia;

    public Noticia(String titulo, String descripcion, ImageView imagennoticia) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagennoticia = imagennoticia;
    }
protected Noticia(Parcel in){
    titulo = in.readString();
    descripcion=in.readString();
    //imagen

}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static final Creator<Noticia> CREATOR = new Creator<Noticia>() {
        @Override
        public Noticia createFromParcel(Parcel in) {
            return new Noticia(in);
        }

        @Override
        public Noticia[] newArray(int size) {
            return new Noticia[size];
        }
    };

    public ImageView getImagennoticia() {
        return imagennoticia;
    }

    public void setImagennoticia(ImageView imagennoticia) {
        this.imagennoticia = imagennoticia;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(descripcion);
    }
}
