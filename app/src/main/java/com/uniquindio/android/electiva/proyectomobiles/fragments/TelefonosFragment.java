package com.uniquindio.android.electiva.proyectomobiles.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.util.AdaptadorDependencia;
import com.uniquindio.android.electiva.proyectomobiles.vo.Dependencia;

import java.util.ArrayList;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 *         28 de Abril de 2016
 */
public class TelefonosFragment extends Fragment implements AdaptadorDependencia.OnClickAdaptadorDependencia {

    //Atributos de la clase de los numeros telefonicos
    private AdaptadorDependencia adaptador;

    //Atributo para crear la lista de las dependenicas
    private RecyclerView listadoDeDependencias;

    //Lista de las dependencias
    private ArrayList<Dependencia> dependencias;

    private OnDependenciaSeleccionadaListener listener;

    /**
     *Constructor de clase
     */
    public TelefonosFragment() {
        // Required empty public constructor
    }

    /**
     * Metodos modificadores de las dependencias
     *
     * @param dependencias Lista de las dependencias
     */
    public void setDependencias(ArrayList<Dependencia> dependencias) {
        this.dependencias = dependencias;
    }

    /**
     * onAttach llamada una vez que el
     * fragmento se asocia con su actividad
     *
     * @param context Esta es una clase abstracta
     *                cuya clase muestra la información global
     *                sobre un entorno de aplicación
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;

        if (context instanceof Activity) {
            activity = (Activity) context;

            try {
                listener = (OnDependenciaSeleccionadaListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnNoticiaSeleccionadaListener");
            }
        }

    }

    /**
     * OncCreateView crea y devuelve la jerarquía vista asociada con el fragmento de los
     * numeros telefonicos
     *
     * @param inflater inflador de contenido
     * @param container contexto
     * @param savedInstanceState guarda los datos sobre el estado de actividad,
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //El inflate() es un método que se utiliza para construir y añadir las Views
        //los fragmentos de los numeros telefonicos.
        return inflater.inflate(R.layout.fragment_telefonos, container, false);
    }


    /**
     * Metodo llamado al mostrar el fragmento
     * @param savedInstanceState información de entrada
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listadoDeDependencias = (RecyclerView) getView().findViewById(R.id.RecViewdependencias);
        //Log.v(NoticiasFragment.class.getSimpleName(), "" + dependencias);
        adaptador = new AdaptadorDependencia(dependencias, this);
        listadoDeDependencias.setAdapter(adaptador);
        listadoDeDependencias.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }


    /**
     * Metodo que hace el llamado a
     * la dependencia seleccionada
     *
     * @param pos posicion
     */
    @Override
    public void onClickPosition(int pos) {
        listener.onDependenciaSeleccionada(pos);
    }

    /**
     * interface que se usa para enviar la posición seleccionada
     * a la actividad que maneja la lista de dependencias
     */
    public interface OnDependenciaSeleccionadaListener {
        void onDependenciaSeleccionada(int position);
    }


}
