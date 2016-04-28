package com.uniquindio.android.electiva.proyectomobiles.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.fragments.DetalleNoticiaFragment;
import com.uniquindio.android.electiva.proyectomobiles.vo.Noticia;

public class DetalleDeNoticiasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_noticias);
        DetalleNoticiaFragment detalleDePelicula =
                (DetalleNoticiaFragment)
                        getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia);
        Noticia pelicula = (Noticia)
                getIntent().getExtras().get("noticia");
        detalleDePelicula.mostrarDetalle(pelicula);
    }
}
