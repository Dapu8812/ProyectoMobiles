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
 * A simple {@link Fragment} subclass.
 */
public class DetalleNoticiaFragment extends Fragment implements View.OnClickListener{

    private TextView titulo;
    private Noticia noticia;

    public DetalleNoticiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_noticia, container, false);
    }
    public void mostrarDetalle(Noticia n) {
        this.noticia = n;
        titulo = (TextView) getView().findViewById(R.id.titulo_detalle_noticia);
        titulo.setText(n.getTitulo());
    }

    @Override
    public void onClick(View v) {

    }
}
