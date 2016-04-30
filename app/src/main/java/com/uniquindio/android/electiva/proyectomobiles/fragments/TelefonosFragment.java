package com.uniquindio.android.electiva.proyectomobiles.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
 * 28 de Abril de 2016
 */
public class TelefonosFragment extends Fragment implements AdaptadorDependencia.OnClickAdaptadorDependencia {

    private AdaptadorDependencia adaptador;
    private RecyclerView listadoDeDependencias;
    private ArrayList<Dependencia> dependencias;
    private OnDependenciaSeleccionadaListener listener;

    public TelefonosFragment() {
        // Required empty public constructor
    }


    public void setDependencias(ArrayList<Dependencia> dependencias)
    {
        this.dependencias = dependencias;
    }

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_telefonos, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listadoDeDependencias = (RecyclerView) getView().findViewById(R.id.RecViewdependencias);
        Log.v(NoticiasFragment.class.getSimpleName(), "" + dependencias);
        adaptador = new AdaptadorDependencia(dependencias, this);
        listadoDeDependencias.setAdapter(adaptador);
        listadoDeDependencias.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }



    @Override
    public void onClickPosition(int pos) {
        listener.onDependenciaSeleccionada(pos);
    }

    public   interface OnDependenciaSeleccionadaListener {
        void onDependenciaSeleccionada(int position);
    }


}
