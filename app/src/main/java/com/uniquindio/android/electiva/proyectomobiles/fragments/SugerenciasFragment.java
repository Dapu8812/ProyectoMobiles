package com.uniquindio.android.electiva.proyectomobiles.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.android.electiva.proyectomobiles.R;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 * 28 de Abril de 2016
 */
public class SugerenciasFragment extends Fragment {


    /**
     * Constructor de clase
     */
    public SugerenciasFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo OnCreate
     * El cual se encarga de hacer funcionar la aplicacion
     * los fragmentos de la sugerencias.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //El inflate() es un método que se utiliza para construir
        // y añadir las Views
        //la vista Sugerencias.
        return inflater.inflate(R.layout.fragment_sugerencias, container, false);
    }

}
