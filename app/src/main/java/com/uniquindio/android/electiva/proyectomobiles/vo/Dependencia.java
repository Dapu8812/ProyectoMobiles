package com.uniquindio.android.electiva.proyectomobiles.vo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 * 28 de Abril de 2016
 */
public class Dependencia implements Parcelable{
    //nombre de la dependencia
    private String nombre;
    //lista de telefonos de la dependencia
    private ArrayList<Telefono> telefonos;


 /**   public Dependencia(String nombre) {
        this.nombre = nombre;
    }*/

    /**
     * Metodo constructor de la dependencia
     * @param nombre dependencia
     * @param telefonos lista numeros telefonicos de la depenndencia.
     */
    public Dependencia(String nombre, ArrayList<Telefono> telefonos) {
        this.nombre = nombre;
        this.telefonos = telefonos;
    }

    public Dependencia() {
    }

    /**
     * Metodo get del numero tefonico
     * @return telefono
     */
    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }

    /**
     * Metodo modificar de los numeros telefonicos
     * @param telefonos
     */
    public void setTelefonos(ArrayList<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    /**
     * Metodo get del nombre de la dependencia
     * @return nombre de la dependencial
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo modificador del nombre de la dependencia
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Leer y devolver una nueva ArrayList que contiene un tipo de objeto particular de la
     *  parcel que fue escrito
     * @param in
     */
    public Dependencia(Parcel in) {
        nombre = in.readString();
        telefonos = new ArrayList<>();
        in.readTypedList(telefonos, Telefono.CREATOR);
    }

    /**
     *CREADOR pública que genera instancias de la clase parcelable de una parcel
     * en la cual se crea un arraylist de dependencia
     */
    public static final Creator<Dependencia> CREATOR = new Creator<Dependencia>() {

        /**
         * Crear una nueva instancia de la clase parcelable de dependencia
         * instanciándola de la parcela determinada cuyos datos habían sido previamente escrito
         * @param in
         * @return
         */
        @Override
        public Dependencia createFromParcel(Parcel in) {
            return new Dependencia(in);
        }

        /**
         *Crear una nueva matriz de la clase dependencia parcelable
         * @param size tamaño
         * @return la matriz
         */
        @Override
        public Dependencia[] newArray(int size) {
            return new Dependencia[size];
        }
    };

    /**
     * Describir los tipos de objetos especiales contenidas
     * en la representación de este  parcelable.
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Acoplar este objeto en un paquete.
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeTypedList(telefonos);
    }
}
