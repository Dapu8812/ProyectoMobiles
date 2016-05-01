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
 * A simple {@link Fragment} subclass.
 */
public class DetalleDependenciaFragment extends Fragment implements View.OnClickListener {

    private TextView numero;
    private Dependencia dependencia;
    private TextView nombre;

    public DetalleDependenciaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_dependencia, container, false);
    }

    public void mostrarDetalle(Dependencia d) {
        this.dependencia = d;
        // Log.d("TAG", "Element " + n.equals(null) + " clicked. ");
        numero = (TextView) getView().findViewById(R.id.titulo_detalle_noticia);
        nombre = (TextView) getView().findViewById(R.id.descripcion_de_detalle_noticia);
        //titulo.setText(noticia.getTitulo());
        // descrpcion.setText(n.getDescripcion());

    }

    @Override
    public void onClick(View v) {

    }
}