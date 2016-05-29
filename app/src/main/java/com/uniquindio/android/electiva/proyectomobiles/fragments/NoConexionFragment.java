package com.uniquindio.android.electiva.proyectomobiles.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.android.electiva.proyectomobiles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoConexionFragment extends Fragment {


    public NoConexionFragment() {
        // Required empty public constructor
    }

    /**
     *    Llamados a tener el fragmento de una instancia su vista de la interfaz de usuario
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_no_conexion, container, false);
    }

}
