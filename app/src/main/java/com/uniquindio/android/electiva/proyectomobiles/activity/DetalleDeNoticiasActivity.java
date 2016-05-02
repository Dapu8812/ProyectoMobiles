package com.uniquindio.android.electiva.proyectomobiles.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.fragments.DetalleNoticiaFragment;
import com.uniquindio.android.electiva.proyectomobiles.vo.Noticia;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 * 28 de Abril de 2016
 */
public class DetalleDeNoticiasActivity extends AppCompatActivity {

    /**
     * /**
     * Metodo OnCreate
     * El cual se encarga de llamar a la vista de
     * detalles de detalle de noticias
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //Establece el contenido de los detalles de la noticia de una visión explícita
        setContentView(R.layout.activity_detalle_de_noticias);
        DetalleNoticiaFragment detalleDePelicula =
                (DetalleNoticiaFragment)
                        //getSupportFragmentManager Devolver el FragmentManager para interactuar
                        // con los fragmentos asociados a esta actividad en este caso el fragmento
                        //de los detalles de las noticias
                        getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia);
        Noticia noticia = (Noticia)
                getIntent().getExtras().get("noticia");
        //al hacer el llamado este muestra en la vista el tituto y descripcion de la noticia.
        detalleDePelicula.mostrarDetalle(noticia);
    }
}
