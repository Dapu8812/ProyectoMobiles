package com.uniquindio.android.electiva.proyectomobiles.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    ArrayList<Noticia> noticias;

    //private static OnClickAdaptadorNoticia listener;
    private OnClickAdaptadorNoticia listener;

    public AdaptadorNoticia(ArrayList<Noticia> noticias, NoticiasFragment noticiasFragment) {
        this.noticias = noticias;
        listener = (OnClickAdaptadorNoticia) noticiasFragment;
    }


    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_noticia, parent, false);
        NoticiaViewHolder NoticiaVH = new NoticiaViewHolder(itemView);
        return NoticiaVH;
    }

    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position) {

        Noticia n = noticias.get(position);
        holder.binNoticia(n);
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public interface OnClickAdaptadorNoticia {
        public void onClickPosition(int pos);
    }


    public static class NoticiaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView titulo;
// TextView descripcion;

        public NoticiaViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.titulo_noticia);
            Log.d("TAG", "constructor " + getAdapterPosition() + " clicked. ");
        }

        public void binNoticia(Noticia noticia) {
            titulo.setText(noticia.getTitulo());
           // descripcion.setText(noticia.getDescripcion());
        }

        @Override
        public void onClick(View v) {
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. ");
        }

/*        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. ");
        }*/
    }
}
