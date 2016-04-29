package com.uniquindio.android.electiva.proyectomobiles.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.vo.Noticia;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 * 28 de Abril de 2016
 */
public class DetalleNoticiaFragment extends Fragment implements View.OnClickListener{

    //Titulo de la noticia
    private TextView titulo;
    private Noticia noticia;

    public DetalleNoticiaFragment() {
        // Required empty public constructor
    }

    /*
     *  Metodo OnCreate
     * El cual se encarga de hacer funcionar la aplicacion
     * La vista detalle Noticia
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_noticia, container, false);
    }

    /**
     * Metodo que muestra los detalles de la noticia
     * @param n
     */
    public void mostrarDetalle(Noticia n) {
        this.noticia = n;
        titulo = (TextView) getView().findViewById(R.id.titulo_detalle_noticia);
        titulo.setText(n.getTitulo());


    }

    @Override
    public void onClick(View v) {

    }
}
