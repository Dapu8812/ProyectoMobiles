package com.uniquindio.android.electiva.proyectomobiles.activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.fragments.NoticiasFragment;
import com.uniquindio.android.electiva.proyectomobiles.fragments.SugerenciasFragment;
import com.uniquindio.android.electiva.proyectomobiles.fragments.TelefonosFragment;

public class NavigationActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navView;


    private void remplazarFragmento(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack(null).commit();
    }
    public void URLiniciar(){
        Intent Urlini=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uniquindio.edu.co/"));
        startActivity(Urlini);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.navview);
        navView.setItemIconTintList(null);
        remplazarFragmento(new NoticiasFragment());
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.noticias:
                        remplazarFragmento(new NoticiasFragment());
                        break;
                    case R.id.telefonos:
                        remplazarFragmento(new TelefonosFragment());
                        break;
                    case R.id.sugerencias:
                        remplazarFragmento(new SugerenciasFragment());
                        break;
                    case R.id.pagina:
                       URLiniciar();
                        break;
                    case R.id.idioma:

                        break;
                }
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
