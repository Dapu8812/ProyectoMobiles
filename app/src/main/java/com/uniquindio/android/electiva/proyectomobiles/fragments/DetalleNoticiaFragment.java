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


    //Noticia
    private Noticia noticia;

    /**
     * Constructor de clase
     */
    public DetalleNoticiaFragment() {
        // Required empty public constructor
    }

    /*
     *  Metodo OnCreate
     * El cual se encarga de hacer funcionar la aplicacion
     * La vista detalle Noticia
     * @param inflater
     * @param container vista
     * @param savedInstanceState
     * @return El fragmento del detalle de la noticia
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //El inflate() es un método que se utiliza para construir y añadir las Views de los fragmentos d
        //detalles de la noticia.
        return inflater.inflate(R.layout.fragment_detalle_noticia, container, false);
    }

    /**
     * Metodo que muestra los detalles de la noticia
     * @param noticia que se sellecciono para ser mostrarda
     */
    public void mostrarDetalle(Noticia noticia) {
        this.noticia = noticia;

        ((TextView) getView().findViewById(R.id.titulo_detalle_noticia)).setText(noticia.getTitulo());

        ((TextView) getView().findViewById(R.id.descripcion_de_detalle_noticia)).setText(noticia.getDescripcion());

    }
    @Override
    public void onClick(View v) {

    }
}
