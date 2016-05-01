package com.uniquindio.android.electiva.proyectomobiles.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.fragments.DetalleDependenciaFragment;
import com.uniquindio.android.electiva.proyectomobiles.vo.Dependencia;

public class DetalleDependenciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_dependencia);
        DetalleDependenciaFragment detalleDependencia =
                (DetalleDependenciaFragment)
                        getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_dependencia);
        Dependencia dependencia = (Dependencia)
                getIntent().getExtras().get("Dependencia");
        detalleDependencia.mostrarDetalle(dependencia);
    }
}
