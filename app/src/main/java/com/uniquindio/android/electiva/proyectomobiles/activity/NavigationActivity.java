package com.uniquindio.android.electiva.proyectomobiles.activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.fragments.DetalleDependenciaFragment;
import com.uniquindio.android.electiva.proyectomobiles.fragments.DetalleNoticiaFragment;
import com.uniquindio.android.electiva.proyectomobiles.fragments.NoticiasFragment;
import com.uniquindio.android.electiva.proyectomobiles.fragments.SugerenciasFragment;
import com.uniquindio.android.electiva.proyectomobiles.fragments.TelefonosFragment;
import com.uniquindio.android.electiva.proyectomobiles.util.Utilidades;
import com.uniquindio.android.electiva.proyectomobiles.vo.Dependencia;
import com.uniquindio.android.electiva.proyectomobiles.vo.Noticia;
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
public class NavigationActivity extends AppCompatActivity implements NoticiasFragment.OnNoticiaSeleccionadaListener, TelefonosFragment.OnDependenciaSeleccionadaListener{

    //Es un contenedor que permite interactuar entre vistas
    DrawerLayout drawerLayout;

    //Menú de navegacion estandar
    NavigationView navView;

    //Arraylist de todas las noticias
    private ArrayList<Noticia> noticias;
    private ArrayList<Dependencia> dependencias;
    private ArrayList<Telefono> telefonos;
  //  private NoticiasFragment listaNoticias;


    /**
     * Remplaza el fragmento, y agrega
     * el fragmento anterior a la pila.
     * @param fragment
     */
    private void remplazarFragmento(Fragment fragment , int t) {


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);

        if(t == 0)
        transaction.addToBackStack(null);

        transaction.commit();
    }

    /**
     * Metodo que redirige a la pagina
     * de la universidad del quindio.
     *
     */
    public void URLiniciar() {
        // intent  es una descripción abstracta de una operación a realizar, y esta accion redirije a la pagina de la Uq.
        Intent Urlini = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uniquindio.edu.co/"));

        //utilizado con startActivity  para poner en marcha la actividad para dirigirse a la pagina
        startActivity(Urlini);
    }

    /**
     * Metodo OnCreate
     * El cual se encarga de hacer funcionar la aplicacion
     * De la vista Navegacion.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         *Vista para cambiar el lenguaje dependiendo de cual
         seleccion el usuario
         */
        Utilidades.obtenerLenguaje(this);

        //Arraylist de las noticias a mostrar en la vista
        noticias = new ArrayList<>();
        noticias.add(new Noticia("noticia 1"));
        noticias.add(new Noticia("noticia 2"));
        noticias.add(new Noticia("noticia 3"));
        noticias.add(new Noticia("noticia 4"));
        dependencias=new ArrayList<>();
        telefonos=new ArrayList<>();
        telefonos.add(new Telefono("7494949","123","leydi giraldo"));
        telefonos.add(new Telefono("7494949","123","juan Diego buitrago"));
        dependencias.add(new Dependencia("dependencia 1",telefonos));
        dependencias.add(new Dependencia("dependencia 2",telefonos));
        dependencias.add(new Dependencia("dependencia 3",telefonos));
        dependencias.add(new Dependencia("dependencia 4",telefonos));
        dependencias.add(new Dependencia("dependencia 5",telefonos));
        dependencias.add(new Dependencia("dependencia 6",telefonos));
        dependencias.add(new Dependencia("dependencia 7",telefonos));
        dependencias.add(new Dependencia("dependencia 8",telefonos));
        dependencias.add(new Dependencia("dependencia 9",telefonos));
        dependencias.add(new Dependencia("dependencia 10",telefonos));
        dependencias.add(new Dependencia("dependencia 11",telefonos));


        //listaNoticias = (NoticiasFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_noticias);
        //listaNoticias.setPeliculas(noticias);

        //SetcontentView hace el llamado a la interfaz de navegacion
        setContentView(R.layout.activity_navigation);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // FindviewById para recuperar los widgets en que la IU que necesita para interactuar
        //igualmente el drawerLayout es un contenedor que permite interactuar entre vistas
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navView = (NavigationView) findViewById(R.id.navview);
        navView.setItemIconTintList(null);

        final NoticiasFragment noticiasFragment = new NoticiasFragment();
        noticiasFragment.setNoticias(noticias);

        final TelefonosFragment telefonosFragment = new TelefonosFragment();
        telefonosFragment.setDependencias(dependencias);

        Log.v(NavigationActivity.class.getSimpleName(), "" + noticias);

        remplazarFragmento(noticiasFragment, 1);

        // SetNavigationItemSelectedListener  es el oyente para el manejo de eventos de elementos de navegación
        //En el cual muestra la vista seleccionada por el usuario
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.noticias:
                        remplazarFragmento(noticiasFragment, 0);
                        break;
                    case R.id.telefonos:
                        remplazarFragmento(telefonosFragment, 0);
                        break;
                    case R.id.sugerencias:
                        remplazarFragmento(new SugerenciasFragment(), 0);
                        break;
                    case R.id.pagina:
                        URLiniciar();
                        break;
                    case R.id.idioma:
                        Utilidades.cambiarIdioma(NavigationActivity.this);
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                        break;
                }
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    /**
     * OnOptionsItemSelected se llama cada vez que se selecciona un elemento en el menú de opciones.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onNoticiaSeleccionada(int position) {
    //    Log.d("TAG", "Element " + noticias.size() + " clicked. ");
    // Log.d("TAG", "Element " + noticias.get(0).getTitulo() + " clicked. ");

        boolean esFragmento =
                getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia) != null;
        if (esFragmento) {
            ((DetalleNoticiaFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia)).mostrarDetalle(noticias.get(position*1));
        } else {
            Intent intent = new Intent(NavigationActivity.this,
                    DetalleDeNoticiasActivity.class);
            intent.putExtra("Noticia", noticias.get(position));
            startActivity(intent);
        }
    }

    @Override
    public void onDependenciaSeleccionada(int position) {
        boolean esFragmento =
                getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_dependencia) != null;
        if (esFragmento) {
            ((DetalleDependenciaFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_dependencia)).mostrarDetalle(dependencias.get(position));
        } else {
            Intent intent = new Intent(NavigationActivity.this,
                    DetalleDependenciaActivity.class);
            intent.putExtra("Noticia", dependencias.get(position));
            startActivity(intent);
        }

    }
}
