package com.uniquindio.android.electiva.proyectomobiles.activity;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.fragments.DependenciasFragment;
import com.uniquindio.android.electiva.proyectomobiles.fragments.DetalleDependenciaFragment;
import com.uniquindio.android.electiva.proyectomobiles.fragments.DetalleNoticiaFragment;
import com.uniquindio.android.electiva.proyectomobiles.fragments.NoConexionFragment;
import com.uniquindio.android.electiva.proyectomobiles.fragments.NoticiasFragment;
import com.uniquindio.android.electiva.proyectomobiles.fragments.SugerenciasFragment;
import com.uniquindio.android.electiva.proyectomobiles.util.Utilidades;
import com.uniquindio.android.electiva.proyectomobiles.vo.Dependencia;
import com.uniquindio.android.electiva.proyectomobiles.vo.Noticia;
import com.uniquindio.android.electiva.proyectomobiles.vo.Telefono;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 *         28 de Abril de 2016
 */
public class NavigationActivity extends AppCompatActivity implements NoticiasFragment.OnNoticiaSeleccionadaListener, DependenciasFragment.OnDependenciaSeleccionadaListener, DetalleDependenciaFragment.onNumerosDependenciaSeleccionadaListener {

    //Es un contenedor que permite interactuar entre vistas
    DrawerLayout drawerLayout;

    //Menú de navegacion estandar
    NavigationView navView;

    //Arraylist de todas las noticias
    private ArrayList<Noticia> noticias;

    //Lista de las dependencias de la universidad
    private ArrayList<Dependencia> dependencias;

    //Lista de los numeros telefonicos
    private ArrayList<Telefono> telefonos;
    //  private NoticiasFragment listaNoticias;

    private CallbackManager callbackManager;
    private int posDep;



    /**
     * Remplaza el fragmento, y agrega
     * el fragmento anterior a la pila.
     *
     * @param fragment
     */
    private void remplazarFragmento(Fragment fragment, int t) {


        ////getSupportFragmentManager devuelve el FragmentManager para interactuar
        // con los fragmentos asociados a esta actividad en este caso el fragmento
        //de los la navegacion de la aplicacion
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);

        if (t == 0)
            transaction.addToBackStack(null);

        transaction.commit();
    }


    /**
     * Metodo que redirige a la pagina
     * de la universidad del quindio.
     */
    public void URLiniciar() {
        // intent  es una descripción abstracta de una operación a realizar, y esta accion redirije a la pagina de la Uq.
        Intent Urlini = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uniquindio.edu.co/"));

        //utilizado con startActivity  para poner en marcha la actividad para dirigirse a la pagina
        startActivity(Urlini);
    }

    private boolean estaConectado(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context
                .CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info == null || !info.isConnected() || !info.isAvailable()) {
            return false;
        }
        return true;
    }


    /**
     * Metodo OnCreate
     * El cual se encarga de hacer funcionar la aplicacion
     * De la vista Navegacion.
     *
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

        noticias= new ArrayList<Noticia>();
        //Arraylist de las noticias a mostrar en la vista
        noticias.add(new Noticia("noticia 1"));
        noticias.add(new Noticia("noticia 2"));
       // noticias.add(new Noticia("noticia 3"));
       // noticias.add(new Noticia("noticia 4"));
        //Lista de las dependenicas
        dependencias = new ArrayList<>();
        //Lista de los telefonos de cada dependencia
        telefonos = new ArrayList<>();
        telefonos.add(new Telefono("7494949", "123", "leydi giraldo"));
        telefonos.add(new Telefono("7494949", "123", "juan Diego buitrago"));
        dependencias.add(new Dependencia("dependencia 1", telefonos));
        dependencias.add(new Dependencia("dependencia 2", telefonos));
        dependencias.add(new Dependencia("dependencia 3", telefonos));
        dependencias.add(new Dependencia("dependencia 4", telefonos));
        dependencias.add(new Dependencia("dependencia 5", telefonos));
        dependencias.add(new Dependencia("dependencia 6", telefonos));
        dependencias.add(new Dependencia("dependencia 7", telefonos));
        dependencias.add(new Dependencia("dependencia 8", telefonos));
        dependencias.add(new Dependencia("dependencia 9", telefonos));
        dependencias.add(new Dependencia("dependencia 10", telefonos));
        dependencias.add(new Dependencia("dependencia 11", telefonos));


        //listaNoticias = (NoticiasFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_noticias);
        //listaNoticias.setPeliculas(noticias);

        //SetcontentView hace el llamado a la interfaz de navegacion
        Firebase.setAndroidContext(this);
        FacebookSdk.sdkInitialize(getApplicationContext());



        Firebase firebase = new Firebase("https://uniquindio.firebaseio.com/ListaNoticias");
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                noticias.clear();
                for (final DataSnapshot response : dataSnapshot.getChildren()) {
                    Noticia not = response.getValue(Noticia.class);
                    noticias.add(not);
                   // Log.d("tamaño", "" + not.getTitulo());

                }



                // Log.d("tamaño",""+noticias.size());
                Collections.shuffle(noticias);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

                System.out.println("error en bd" + firebaseError.getMessage());

            }
        });

        setContentView(R.layout.activity_navigation);
        Utilidades.getKeyHash(this);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // FindviewById para recuperar los widgets en que la IU que necesita para interactuar
        //igualmente el drawerLayout es un contenedor que permite interactuar entre vistas
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //Encuentra la vista de la navegacion el atributo id del XML que fue procesada en onCreate
        navView = (NavigationView) findViewById(R.id.navview);
        navView.setItemIconTintList(null);

        final NoticiasFragment noticiasFragment = new NoticiasFragment();
        noticiasFragment.setNoticias(noticias);
       // noticiasFragment.adaptador.intercambiar(noticias);


        final DependenciasFragment dependenciasFragment = new DependenciasFragment();
        dependenciasFragment.setDependencias(dependencias);

        final NoConexionFragment ConexionFragment = new NoConexionFragment();


        // Log.v(NavigationActivity.class.getSimpleName(), "" + noticias);

        remplazarFragmento(noticiasFragment, 1);


        // SetNavigationItemSelectedListener  es el oyente para el manejo de eventos de elementos de navegación
        //En el cual muestra la vista seleccionada por el usuario
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                boolean conectado = estaConectado(getBaseContext());

                switch (item.getItemId()) {
                    case R.id.noticias:
                        if (conectado == true) {
                            remplazarFragmento(noticiasFragment, 0);
                            break;
                        } else {
                            remplazarFragmento(ConexionFragment, 0);
                        }
                    case R.id.telefonos:
                        if (conectado == true) {
                            remplazarFragmento(dependenciasFragment, 0);
                            break;
                        } else {
                            remplazarFragmento(ConexionFragment, 0);
                        }
                    case R.id.sugerencias:
                        if (conectado == true) {
                            remplazarFragmento(new SugerenciasFragment(), 0);
                            break;
                        } else {
                            remplazarFragmento(ConexionFragment, 0);
                        }
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

        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
// App code
                    }

                    @Override
                    public void onCancel() {
// App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
// App code
                    }
                });

    }

    /**
     * OnOptionsItemSelected se llama cada vez que se selecciona un elemento en el menú de opciones.
     *
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

    /**
     * Metodo donde se muestra el fragmento
     * de los detalles de una noticia que fue seleccionada
     *
     * @param position
     */
    @Override
    public void onNoticiaSeleccionada(int position) {
        //    Log.d("TAG", "Element " + noticias.size() + " clicked. ");
        // Log.d("TAG", "Element " + noticias.get(0).getTitulo() + " clicked. ");

        //getSupportFragmentManager Devolver el FragmentManager para interactuar
        // con los fragmentos asociados a esta actividad en este caso el fragmento
        //de los detalles de la noticia

        boolean esFragmento =
                getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia) != null;
        //Condiciones donde se muestra y se verifica si existe esa noticia
        //y la muestra su detalle
        if (esFragmento) {
            ((DetalleNoticiaFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia)).mostrarDetalle(noticias.get(position));
        } else {
            Intent intent = new Intent(NavigationActivity.this,
                    DetalleDeNoticiasActivity.class);
            intent.putExtra("Noticia", noticias.get(position));
            startActivity(intent);
        }
    }

    /**
     * Metodo donde se muestra el fragmento
     * de los detalles de la dependencia  que fue seleccionada
     *
     * @param position
     */
    @Override
    public void onDependenciaSeleccionada(int position) {

      /* boolean esFragmento =
                getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_dependencia) != null;
        //Condiciones donde se muestra y se verifica si existe esa noticia
        //y la muestra su detalle
        if (esFragmento) {
            ((DetalleDependenciaFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_dependencia)).mostrarDetalle(dependencias.get(position));
        } else {
            Intent intent = new Intent(NavigationActivity.this,
                    DetalleDependenciaActivity.class);
            intent.putExtra("Dependencia", dependencias.get(position));
            startActivity(intent);

        }*/
        final DetalleDependenciaFragment detalleDependenciaFragment = new DetalleDependenciaFragment();
        detalleDependenciaFragment.setNumeros(dependencias.get(position).getTelefonos());
        detalleDependenciaFragment.setDependencia(dependencias.get(position));
        remplazarFragmento(detalleDependenciaFragment, 0);
        posDep = position;

    }

    @Override
    public void onNumerosDependenciaSeleccionada(int position) {

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + dependencias.get(posDep).getTelefonos().get(position).getExtension() + dependencias.get(posDep).getTelefonos().get(position).getNumero()));
        //   Intent i = new Intent(android.content.Intent.ACTION_DIAL,
        //    Uri.parse("tel:+0573017836771")); //
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);

    }
}
