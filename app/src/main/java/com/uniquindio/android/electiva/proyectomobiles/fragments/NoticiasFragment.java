package com.uniquindio.android.electiva.proyectomobiles.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.util.AdaptadorNoticia;
import com.uniquindio.android.electiva.proyectomobiles.vo.Noticia;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticiasFragment extends Fragment implements AdaptadorNoticia.OnClickAdaptadorNoticia {


    private AdaptadorNoticia adaptador;
    private RecyclerView listadoDeNoticias;
    private ArrayList<Noticia> Noticias;
    private OnNoticiaSeleccionadaListener listener;

    public NoticiasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_noticias, container, false);
    }

    @Override
    public void onClickPosition(int pos) {
        listener.onNoticiaSeleccionada(pos);
    }

    public void setPeliculas (ArrayList < Noticia > noticia) {
            this.Noticias = noticia;
        }
    }

    public interface OnNoticiaSeleccionadaListener {
        void onNoticiaSeleccionada(int position);
    }
}
