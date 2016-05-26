package com.uniquindio.android.electiva.proyectomobiles.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.util.AdaptadorNumerosDependencia;
import com.uniquindio.android.electiva.proyectomobiles.vo.Dependencia;
import com.uniquindio.android.electiva.proyectomobiles.vo.Telefono;

import java.util.ArrayList;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 *         28 de Abril de 2016
 */
public class DetalleDependenciaFragment extends Fragment implements View.OnClickListener, AdaptadorNumerosDependencia.OnClickAdaptadorNumerosDependencia {

    //Atributos que conforman los detalles de una dependencia
    private TextView nombreDependencia;
    private Dependencia dependencia;
    private ImageButton llamada;
    private ArrayList<Telefono> numeros;
    private RecyclerView listadoNumeros;
    private AdaptadorNumerosDependencia adaptador;
    private onNumerosDependenciaSeleccionadaListener listener;


    /**
     * Constructor de clase
     */
    public DetalleDependenciaFragment() {
        // Required empty public constructor
    }

    public void setNumeros(ArrayList<Telefono> numeros) {
        this.numeros = numeros;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;

        if (context instanceof Activity) {
            activity = (Activity) context;

            try {
                listener = (onNumerosDependenciaSeleccionadaListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnNoticiaSeleccionadaListener");
            }
        }

    }


    /**
     * Metodo que hace el Llamado fragmento
     * de los detalles de las dependencias
     * y muestra la  vista de la interfaz de usuario
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //El inflate() es un método que se utiliza para construir y añadir las Views
        //El detalle de las dependencias.
        return inflater.inflate(R.layout.fragment_detalle_dependencia, container, false);
    }

    /**
     * Metodo que recibe la posicion de la dependencia
     * seleccionada por el usuario
     * y muestra el titulo y la descrpicion de esta noticia
     *
     * @param d Ingresa la dependencia que se selecciono
     */
    public void mostrarDetalle(Dependencia d) {
        this.dependencia = d;
        this.numeros=d.getTelefonos();
        ((TextView) getView().findViewById(R.id.nombre_dependencia_detalle)).setText(d.getNombre());
      //  Log.v("DepA", "" + dependencia.getTelefonos().size());

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listadoNumeros = (RecyclerView) getView().findViewById(R.id.RecViewNumeros);
        //Log.v(NoticiasFragment.class.getSimpleName(), "" + dependencias);
        adaptador = new AdaptadorNumerosDependencia(numeros, this);
        listadoNumeros.setAdapter(adaptador);
        listadoNumeros.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void onClick(View v) {


        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+numeros));
     //   Intent i = new Intent(android.content.Intent.ACTION_DIAL,
            //    Uri.parse("tel:+0573017836771")); //
        startActivity(intent);
    }

    @Override
    public void onClickPosition(int pos) {
        listener.onNumerosDependenciaSeleccionada(pos);
    }

    /**
     * interface que se usa para enviar la posición seleccionada
     * a la actividad que maneja la lista de dependencias
     */
    public interface onNumerosDependenciaSeleccionadaListener {
        void onNumerosDependenciaSeleccionada(int position);
    }




}