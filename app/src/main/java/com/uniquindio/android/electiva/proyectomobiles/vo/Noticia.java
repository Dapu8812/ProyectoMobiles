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
public class Noticia implements Parcelable{

    //ATributos de la noticia
    private String titulo;
    private String descripcion;

    /**
     * Metodo constructor de las noticias
     * @param titulo noticia
     */
    public Noticia(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Contructor de clase
     * @param titulo tiulo noticia, titulo =! null
     * @param descripcion Descripción de la noticia, descrpcion != null
     */
    public Noticia(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    /**
     * Leer y devolver una nueva ArrayList que contiene un tipo de objeto particular de la
     *  parcel que fue seleccionado
     * @param in
     */
    protected Noticia(Parcel in){
    titulo = in.readString();
    descripcion=in.readString();
    //imagen

}

    /**
     * Metodo get del titulo de la noticia
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo modificador del titulo de la noticia
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *Metodo get de la descripcion de la noticia
     * @return descripcion de la noticia
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo modificador de la descripcion de la noticia
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *CREADOR pública que genera instancias de la clase parcelable de una parcel
     * en la cual se crea un arraylist de Noticia
     */
    public static final Creator<Noticia> CREATOR = new Creator<Noticia>() {
        /**
         * Crear una nueva instancia de la clase parcelable de noticia
         * instanciándola de la parcela determinada cuyos datos habían sido previamente escrito
         * @param in
         * @return
         */
        @Override
        public Noticia createFromParcel(Parcel in) {
            return new Noticia(in);
        }

        /**
         * Crear una nueva matriz de la clase dependencia parcelable
         * @param size tamaño de la matriz
         * @return matriz de notica
         */
        @Override
        public Noticia[] newArray(int size) {
            return new Noticia[size];
        }
    };


    /**
     *  Describir los tipos de objetos especiales contenidas
     * en la representación de este  parcelable
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     *Acoplar este objeto en un paquete.
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(descripcion);
    }
}
