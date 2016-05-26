package com.uniquindio.android.electiva.proyectomobiles.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.fragments.DetalleDependenciaFragment;
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
public class AdaptadorNumerosDependencia extends RecyclerView.Adapter<AdaptadorNumerosDependencia.TelefonosViewHolder>{

    //Lista de las dependencias
    public ArrayList<Telefono> numeros;

    //Escuchador del fragmentoDependencias
    public static OnClickAdaptadorNumerosDependencia listener;

    /**
     *Metodo Constructor del adaptador de la dependencias
     *
     * @param numeros lista de las telefonos
     * @param detalleDependenciaFragment los fragmentos de los telefonos de las dependencias
     */
    public AdaptadorNumerosDependencia(ArrayList<Telefono> numeros, DetalleDependenciaFragment detalleDependenciaFragment) {
        this.numeros = numeros;
        listener = (OnClickAdaptadorNumerosDependencia) detalleDependenciaFragment;

    }
    public interface OnClickAdaptadorNumerosDependencia {
        public void onClickPosition(int pos);
    }


    /**
     *Este metodo infla la vista del resumen de
     * las dependencias
     * @param parent en la que se añadirá la nueva vista después de que se une a una posición adaptador.
     * @param viewType el tipo de la nueva vista
     * @return la dependencia vieHolder
     */
    @Override
    public TelefonosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_telefonos, parent, false);
        TelefonosViewHolder telefonosVH = new TelefonosViewHolder(itemView);
        return telefonosVH;
    }

    @Override
    public void onBindViewHolder(AdaptadorNumerosDependencia.TelefonosViewHolder holder, int position) {
        Telefono n = numeros.get(position);
        holder.binTelefonos(n);
    }

    @Override
    public int getItemCount() {
        return 0;
    }




    /**
     * Este metodo actualiza el contenido de la vista
     * con el elemento en la posición dada y también establece algunos campos
     * para ser usados ​​por RecyclerView .
     * @param holder adaptador
     * @param position posicion
     */


    /**
     * Metodo donde se cuenta
     * el tamaño de los numeros telefonicos q
     * que se encuentran en la lista de dependencias
     * @return
     */



    /**
     * Clase de De la dependencia viewHolder
     * implementando la subclase ViewHolder
     * el cual añade los datos
     */
    public static class TelefonosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nombre;
        private TextView numero;
        private TextView ext;
        private ImageButton llamada;
        private ImageButton config;


        /**
         *Este metodo va invoca la vista de dependencias
         * con sus repectivos atributos
         * @param itemView
         */
        public TelefonosViewHolder(View itemView) {
            super(itemView);
            //OnclickListener devolución de llamada que se invoca cuando se hace clic en una vista
            // dependencias..
            //el findViewById Encuentra  el atributo id del XML que fue procesada en onCreate
            nombre = (TextView) itemView.findViewById(R.id.nombre_usuario);
            numero= (TextView) itemView.findViewById(R.id.numeros_usuario);
            ext=(TextView) itemView.findViewById(R.id.numeros_ext);
            llamada=(ImageButton) itemView.findViewById(R.id.llamada);
            config=(ImageButton) itemView.findViewById(R.id.confi);
            llamada.setOnClickListener(this);
            config.setOnClickListener(this);


        }

        /**
         *
         * @param telefono
         */
        public void binTelefonos(Telefono telefono) {
            nombre.setText(telefono.getDueño());
            numero.setText(telefono.getNumero());
            ext.setText(telefono.getExtension());
        }

        /**
         *Este metodo hace el llamado
         * cuando el usuario ha hecho  en una vista.
         * @param v
         */
        @Override
        public void onClick(View v) {

            listener.onClickPosition(getAdapterPosition());
           // Log.d("TAG", "Element " + getAdapterPosition() + " clicked. ");
        }
    }

}
