package com.uniquindio.android.electiva.proyectomobiles.fragments;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.vo.Noticia;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 *         28 de Abril de 2016
 */
public class DetalleNoticiaFragment extends Fragment implements View.OnClickListener {


    //Noticia
    private Noticia noticia;
    // imagen facebook
    private ImageButton btn_fb;
    //imagen Twitter
    private ImageButton btn_tw;
    private ShareDialog shareDialog;

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
        //El inflate() es un m?todo que se utiliza para construir y a?adir las Views de los fragmentos d
        //detalles de la noticia.
        return inflater.inflate(R.layout.fragment_detalle_noticia, container, false);
    }


/*
     *  Metodo onActivityCreated
     * Se llama cuando se ha creado la actividad del fragmento y la jerarqu?a de vistas de este fragmento instancia 
     */

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        shareDialog = new ShareDialog(getActivity());
    }

    /**
     * Metodo que muestra los detalles de la noticia
     *
     * @param noticia que se sellecciono para ser mostrarda
     */
    public void mostrarDetalle(Noticia noticia) {
        this.noticia = noticia;

        btn_fb = (ImageButton) getView().findViewById(R.id.fb);
        btn_fb.setOnClickListener(this);

        btn_tw = (ImageButton) getView().findViewById(R.id.twitter);
        btn_tw.setOnClickListener(this);

        ((TextView) getView().findViewById(R.id.titulo_detalle_noticia)).setText(noticia.getTitulo());

        // ((TextView) getView().findViewById(R.id.descripcion_de_detalle_noticia)).setText(noticia.getDescripcion());

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.fb) {


            // LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends"));
                      if (ShareDialog.canShow(ShareLinkContent.class)) {
                ShareLinkContent content = new ShareLinkContent.Builder()
                        .setContentTitle(noticia.getTitulo())
                        .setContentUrl(Uri.parse("https://www.uniquindio.edu.co"))
                        .setContentDescription(noticia.getDescripcion()).build();
                shareDialog.show(content);
            }


        }
        if (v.getId() == R.id.twitter) {
            //code
        }


    }
}
