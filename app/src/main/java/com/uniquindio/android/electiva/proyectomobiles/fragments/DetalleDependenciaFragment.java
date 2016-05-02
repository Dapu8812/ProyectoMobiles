package com.uniquindio.android.electiva.proyectomobiles.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.vo.Dependencia;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 * 28 de Abril de 2016
 */
public class DetalleDependenciaFragment extends Fragment implements View.OnClickListener {

    //Atributos que conforman los detalles de una dependencia
    private TextView numero;
    private Dependencia dependencia;
    private TextView nombre;

    public DetalleDependenciaFragment() {
        // Required empty public constructor
    }

    /**
     *Metodo que hace el Llamado fragmento
     * de los detalles de las dependencias
     * y muestra la  vista de la interfaz de usuario
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_dependencia, container, false);
    }

    /**
     * Metodo que recibe la posicion de la dependencia
     * seleccionada por el usuario
     * y muestra el titulo y la descrpicion de esta noticia
     * @param d
     */
    public void mostrarDetalle(Dependencia d) {
        this.dependencia = d;
        // Log.d("TAG", "Element " + n.equals(null) + " clicked. ");
        //el findViewById Encuentra  el atributo id del XML que fue procesada en onCreate
        numero = (TextView) getView().findViewById(R.id.titulo_detalle_noticia);
        nombre = (TextView) getView().findViewById(R.id.descripcion_de_detalle_noticia);
        //titulo.setText(noticia.getTitulo());
        // descrpcion.setText(n.getDescripcion());

    }

    @Override
    public void onClick(View v) {

    }
}