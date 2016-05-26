package com.uniquindio.android.electiva.proyectomobiles.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.fragments.DependenciasFragment;
import com.uniquindio.android.electiva.proyectomobiles.vo.Dependencia;

import java.util.ArrayList;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 * 28 de Abril de 2016
 */
public class AdaptadorDependencia extends RecyclerView.Adapter<AdaptadorDependencia.DependenciaViewHolder>{

    //Lista de las dependencias
    public ArrayList<Dependencia> dependencias;

    //Escuchador del fragmentoDependencias
    public static OnClickAdaptadorDependencia listener;

    /**
     *Metodo Constructor del adaptador de la dependencias
     *
     * @param dependencias lista de las dependencias
     * @param dependenciasFragment los fragmentos de los telefonos de las dependencias
     */
    public AdaptadorDependencia(ArrayList<Dependencia> dependencias, DependenciasFragment dependenciasFragment) {
        this.dependencias = dependencias;
        listener = (OnClickAdaptadorDependencia) dependenciasFragment;

    }

    /**
     *Metodo que hace el llamado a
     * la dependencia seleccionada
     */
    public interface OnClickAdaptadorDependencia {
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
    public DependenciaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_dependencia, parent, false);
        DependenciaViewHolder DependenciaVH = new DependenciaViewHolder(itemView);
        return DependenciaVH;
    }

    /**
     * Este metodo actualiza el contenido de la vista
     * con el elemento en la posición dada y también establece algunos campos
     * para ser usados ​​por RecyclerView .
     * @param holder adaptador
     * @param position posicion
     */
    @Override
    public void onBindViewHolder(AdaptadorDependencia.DependenciaViewHolder holder, int position) {

        Dependencia n = dependencias.get(position);
        int i= dependencias.get(position).getTelefonos().size();
       // Log.d("TAG", "Element " + dependencias.get(position).getTelefonos().get(0).getNumero() + " clicked. ");
        holder.binDependencia(n, i);
    }

    /**
     * Metodo donde se cuenta
     * el tamaño de los numeros telefonicos q
     * que se encuentran en la lista de dependencias
     * @return
     */
    @Override
    public int getItemCount() {
        return dependencias.size();
    }


    /**
     * Clase de De la dependencia viewHolder
     * implementando la subclase ViewHolder
     * el cual añade los datos
     */
    public static class DependenciaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nombreDependencia;
        private TextView numeroContactos;


        /**
         *Este metodo va invoca la vista de dependencias
         * con sus repectivos atributos
         * @param itemView
         */
        public DependenciaViewHolder(View itemView) {
            super(itemView);
            //OnclickListener devolución de llamada que se invoca cuando se hace clic en una vista
            // dependencias..
            itemView.setOnClickListener(this);
            //el findViewById Encuentra  el atributo id del XML que fue procesada en onCreate
            nombreDependencia = (TextView) itemView.findViewById(R.id.nombre_dependencia);
            numeroContactos= (TextView) itemView.findViewById(R.id.Cantidad_numeros);
        }

        /**
         *
         * @param dependencia
         * @param numero
         */
        public void binDependencia(Dependencia dependencia,int numero) {
            nombreDependencia.setText(dependencia.getNombre());
            numeroContactos.setText("" + numero);

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
