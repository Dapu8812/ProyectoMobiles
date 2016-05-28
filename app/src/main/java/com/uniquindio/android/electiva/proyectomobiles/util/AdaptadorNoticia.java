package com.uniquindio.android.electiva.proyectomobiles.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.fragments.NoticiasFragment;
import com.uniquindio.android.electiva.proyectomobiles.vo.Noticia;

import java.util.ArrayList;

/**
 * Proyecto final Moviles Uniquindio
 *
 * @author Daniel Alvarado Arias
 * @author Leydi Giraldo Franco
 * @author Juan Diego Buitrago
 * 28 de Abril de 2016
 */
public class AdaptadorNoticia extends RecyclerView.Adapter<AdaptadorNoticia.NoticiaViewHolder> {

    //Lista de las noticias.
   public ArrayList<Noticia> noticias;


    //private static OnClickAdaptadorNoticia listener;
    private static OnClickAdaptadorNoticia listener;



    /**
     * Metodo es el encargado de enviar la Noticia al  la lista
     * utilizando el evento OnClick
     * @param noticias Lista de las noticias
     * @param noticiasFragment
     */
    public AdaptadorNoticia(ArrayList<Noticia> noticias, NoticiasFragment noticiasFragment) {
        this.noticias = noticias;
        notifyDataSetChanged();
        listener = (OnClickAdaptadorNoticia) noticiasFragment;
    }

    /**
     *en este metodo el onCreateViewHolder se utilizará para mostrar los
     *  elementos de la snotiicas
     * @param parent
     * @param viewType
     * @return
     */

    /**
     *El evento click, visualizar un div en coordenadas del ratón
     */
    public interface OnClickAdaptadorNoticia {
        public void onClickPosition(int pos);
    }


    /**
     * Este metodo infla la vista del resumen de
     * las de la noticia
     * @param parent en la que se añadirá la nueva vista después de que se une a una posición adaptador.
     * @param viewType el tipo de la nueva vista
     *
     * @return la notivia viewHolder
     */
    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_noticia, parent, false);
        NoticiaViewHolder NoticiaVH = new NoticiaViewHolder(itemView);
        return NoticiaVH;
    }

    public void intercambiar(ArrayList<Noticia> noticia) {
        this.noticias.clear();
        this.noticias.addAll(noticia);
        notifyDataSetChanged();

    }

    /**
     * Este metodo se utilizara para visualizar las notiicas en
     * la posición especificada
     * @param holder representa el contenido de la noticia en la posición dada en el conjunto
     * @param position La posición de la noticia dentro del conjunto de datos del adaptador.
     */
    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position) {

        Noticia n = noticias.get(position);
        holder.binNoticia(n);
    }

    /**
     *Este metodo devuelve el número total de noticias
     * en el conjunto de datos de retención por el adaptador.
     * @return
     */
    @Override
    public int getItemCount() {
        return noticias.size();
    }



    /**
     *
     *Clase de De la dependencia viewHolder
     * implementando la subclase ViewHolder
     * el cual añade los datos
     */
    public static class NoticiaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        //Atributos de la noticia
        private TextView titulo;
        private TextView descripcion;

        /**
         *Este metodo va invoca la vista de dependencias
         * con sus repectivos atributos
         * @param itemView
         */
        public NoticiaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titulo = (TextView) itemView.findViewById(R.id.titulo_noticia);

           // Log.d("TAG", "constructor " + getAdapterPosition() + " clicked. ");
        }

        /**
         *
         * @param noticia
         */
        public void binNoticia(Noticia noticia) {
            titulo.setText(noticia.getTitulo());
           // descripcion.setText(noticia.getDescripcion());
        }

        /**
         *
         * @param v
         */
    /*    @Override
        public void onClick(View v) {
           // Log.d("TAG", "Element " + getAdapterPosition() + " clicked. ");
        }
*/

        /**
         * *Este metodo hace el llamado
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
