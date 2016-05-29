package com.uniquindio.android.electiva.proyectomobiles.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 *         28 de Abril de 2016
 */
public class Telefono implements Parcelable {
    //Atributos de los numeros telefonicos con extension y propietario
    String numero;
    String extension;
    String Dueño;

    /**
     * Metodo constructor de los numeros telefonicos
     *
     * @param numero    telefonico
     * @param extension extencion
     * @param dueño     propietario
     */
    public Telefono(String numero, String extension, String dueño) {

        this.numero = numero;
        this.extension = extension;
        this.Dueño = dueño;
    }

    public Telefono() {
    }

    /**
     * Leer y devolver una nueva ArrayList que contiene un tipo de objeto particular de la
     * parcel que fue seleccionado
     *
     * @param in
     */
    protected Telefono(Parcel in) {
        numero = in.readString();
        extension = in.readString();
        Dueño = in.readString();
    }

    /**
     * *CREADOR pública que genera instancias de la clase parcelable de una parcel
     * en la cual se crea un arraylist de Noticia
     */
    public static final Creator<Telefono> CREATOR = new Creator<Telefono>() {

        /**
         *  Crear una nueva instancia de la clase parcelable de noticia
         * instanciándola de la parcela determinada cuyos datos habían sido previamente escrito
         *
         * @param in
         * @return
         */
        @Override
        public Telefono createFromParcel(Parcel in) {
            return new Telefono(in);
        }

        /**
         * * Crear una nueva matriz de la clase telefono parcelable
         * @param size tamaño de la matriz
         * @return matriz de telefono
         *
         */
        @Override
        public Telefono[] newArray(int size) {
            return new Telefono[size];
        }
    };

    /**
     * Metodo get del numero telefonico
     *
     * @return numero telefonico
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Metodo get de la extension del numero telefonico
     *
     * @return extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Metodo modificador de la extension
     *
     * @param extension
     */

    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Metodo get del propietario de la linea telefonica
     *
     * @return
     */
    public String getDueño() {
        return Dueño;
    }

    /**
     * Metodo modificador de la linea telefonica
     *
     * @param dueño
     */
    public void setDueño(String dueño) {
        Dueño = dueño;
    }

    /**
     * Metodo modificador del nuemro telefonico
     *
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Describir los tipos de objetos especiales contenidas
     * en la representación de este  parcelable
     *
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Acoplar este objeto en un paquete.
     *
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numero);
        dest.writeString(extension);
        dest.writeString(Dueño);

    }
}
