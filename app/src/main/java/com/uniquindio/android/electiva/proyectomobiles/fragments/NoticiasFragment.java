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
import com.uniquindio.android.electiva.proyectomobiles.util.AdaptadorNoticia;
import com.uniquindio.android.electiva.proyectomobiles.vo.Noticia;

import java.util.ArrayList;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 * 28 de Abril de 2016
 */
public class NoticiasFragment extends Fragment implements AdaptadorNoticia.OnClickAdaptadorNoticia {


    private AdaptadorNoticia adaptador;

    //Responsable de proporcionar vistas
    private RecyclerView listadoDeNoticias;

    //Lista de  Las noticias a mostrar
    private ArrayList<Noticia> noticias;

    private OnNoticiaSeleccionadaListener listener;

    public NoticiasFragment() {
        // Required empty public constructor
    }


    /**
     *  /**
     *onAttach llamada una vez que el
     * fragmento se asocia con su actividad
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;

        if (context instanceof Activity) {
            activity = (Activity) context;

            try {
                listener = (OnNoticiaSeleccionadaListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnNoticiaSeleccionadaListener");
            }
        }

    }

    /**
     * OncCreateView crea y devuelve la jerarquía vista asociada con el fragmento
     * @param inflater
     * @param container
     * @param savedInstanceState guarda los datos sobre el estado de actividad,
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_noticias, container, false);
    }

    /**
     * OnActivityCreated llena la lista del adaptador con las noticias
     * @param savedInstanceState  guarda los datos sobre el estado de actividad,
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listadoDeNoticias = (RecyclerView) getView().findViewById(R.id.RecViewnoticias);
        Log.v(NoticiasFragment.class.getSimpleName(), ""+noticias);
        adaptador = new AdaptadorNoticia(noticias, this);
        listadoDeNoticias.setAdapter(adaptador);
        listadoDeNoticias.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }

    /**
     *El evento click, visualizar un div en coordenadas del ratón
     * @param pos posicion
     */
    @Override
    public void onClickPosition(int pos) {
        Log.v("onclic", pos+" seleccinada ");
        listener.onNoticiaSeleccionada(pos);
    }
    // Metodo get de las noticias.
    public void setNoticias(ArrayList<Noticia> noticia)
    {
        this.noticias = noticia;
    }

    /**
     * Interfaz que mmuestra la noticia selecionada
     */
    public   interface OnNoticiaSeleccionadaListener {
        void onNoticiaSeleccionada(int position);
    }
}

