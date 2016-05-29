package com.uniquindio.android.electiva.proyectomobiles.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.fragments.DetalleDependenciaFragment;
import com.uniquindio.android.electiva.proyectomobiles.vo.Dependencia;
import com.uniquindio.android.electiva.proyectomobiles.vo.Telefono;

import java.util.ArrayList;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 * 28 de Abril de 2016
 */
public class DetalleDependenciaActivity extends AppCompatActivity implements DetalleDependenciaFragment.onNumerosDependenciaSeleccionadaListener{



 	/**
     * Metodo cargar Numeros telefonicos
     * El cual se encarga
     * 
	 */	
    public void cargarTelefonos (ArrayList<Telefono> telefono){
        {

        }
    }
    /**
     * Metodo OnCreate
     * El cual se encarga de llamar a la vista de
     * detalles dependencia
     *  @param savedInstanceState
         */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Establece el contenido de los detalles de las dependencias de una visión explícita
      // getSupportActionBar().setDisplayShowTitleEnabled(false);
        setContentView(R.layout.activity_detalle_dependencia);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DetalleDependenciaFragment detalleDependencia =
                (DetalleDependenciaFragment)

                        //getSupportFragmentManager devuelve el FragmentManager para interactuar
                        // con los fragmentos asociados a esta actividad en este caso el fragmento
                        //de los detalles de las dependecias
                        getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_dependencia);

        Dependencia dependencia = (Dependencia)
                getIntent().getExtras().get("Dependencia");


        //al hacer el  llamado este muestra en la vista el  numero telefonico y el nombre de la persona
        detalleDependencia.mostrarDetalle(dependencia);


    }


    @Override
    public void onNumerosDependenciaSeleccionada(int position) {

    }
}
