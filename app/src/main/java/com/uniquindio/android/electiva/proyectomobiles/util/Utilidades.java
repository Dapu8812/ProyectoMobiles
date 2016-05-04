package com.uniquindio.android.electiva.proyectomobiles.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.Log;

import java.util.Locale;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 * 28 de Abril de 2016
 */
public class Utilidades {
    //Se incializan los string dependiendo el idioma
    //español, ingles o el determinado.
    public final static String MIS_PREFERENCIAS = "MisPreferencias";
    public final static String LENGUAJE_DE_PREFERENCIA = "languaje_preferences";
    public final static String LENGUAJE_ES = "es";
    public final static String LENGUAJE_EN = "en";


    /**
     * Meotodo donde cambia el idio de las vistas
     * dependiendo del que fue seleccionado por el usuario
     * @param context esta es una clase abstracta
     *                cuya clase muestra la información global
     *                sobre un entorno de aplicación
     */
    public static void cambiarIdioma(Context context) {

        //para acceder y modificar los datos de preferencia devueltos por getSharedPreferences
        SharedPreferences prefs = context.getSharedPreferences(MIS_PREFERENCIAS, context.MODE_PRIVATE);
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA, LENGUAJE_ES);

        Log.v(Utilidades.class.getSimpleName(), "idioma "+language);

        if (language.equals(LENGUAJE_ES)) {
            language = LENGUAJE_EN;
        } else if (language.equals(LENGUAJE_EN)) {
            language = LENGUAJE_ES;
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(LENGUAJE_DE_PREFERENCIA, language);
        editor.commit();
        obtenerLenguaje(context);
    }

    /**
     * Metodo donde se obtine el lenguje en el cual
     * se encuentra la aplicacion.
     * @param context contexto
     */
    public static void obtenerLenguaje(Context context) {
       // //para acceder y modificar los datos de preferencia devueltos por getSharedPreferences
        SharedPreferences prefs = context.getSharedPreferences(MIS_PREFERENCIAS, context.MODE_PRIVATE);
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA, LENGUAJE_ES);
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getApplicationContext().getResources().updateConfiguration(config, null);
    }
}
