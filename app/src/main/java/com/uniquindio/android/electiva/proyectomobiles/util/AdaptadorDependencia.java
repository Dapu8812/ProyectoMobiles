package com.uniquindio.android.electiva.proyectomobiles.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uniquindio.android.electiva.proyectomobiles.R;
import com.uniquindio.android.electiva.proyectomobiles.fragments.TelefonosFragment;
import com.uniquindio.android.electiva.proyectomobiles.vo.Dependencia;

import java.util.ArrayList;

/**
 * Created by DAA on 29/04/2016.
 */
public class AdaptadorDependencia extends RecyclerView.Adapter<AdaptadorDependencia.DependenciaViewHolder>{

    public ArrayList<Dependencia> dependencias;
    public static OnClickAdaptadorDependencia listener;

    public AdaptadorDependencia(ArrayList<Dependencia> dependencias, TelefonosFragment telefonosFragment) {
        this.dependencias = dependencias;
        listener = (OnClickAdaptadorDependencia) telefonosFragment;

    }

    public interface OnClickAdaptadorDependencia {
        public void onClickPosition(int pos);
    }

    @Override
    public DependenciaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_dependencia, parent, false);
        DependenciaViewHolder DependenciaVH = new DependenciaViewHolder(itemView);
        return DependenciaVH;
    }

    @Override
    public void onBindViewHolder(AdaptadorDependencia.DependenciaViewHolder holder, int position) {

        Dependencia n = dependencias.get(position);
        int i= dependencias.get(position).getTelefonos().size();

        holder.binDependencia(n,i);
    }

    @Override
    public int getItemCount() {
        return dependencias.size();
    }



    public static class DependenciaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nombreDependencia;
        private TextView numeroContactos;


        public DependenciaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nombreDependencia = (TextView) itemView.findViewById(R.id.nombre_dependencia);
            numeroContactos= (TextView) itemView.findViewById(R.id.Cantidad_numeros);
          //  Log.d("TAG", "constructor " + getAdapterPosition() + " clicked. ");
        }

        public void binDependencia(Dependencia dependencia,int numero) {
            nombreDependencia.setText(dependencia.getNombre());
            numeroContactos.setText("" + numero);

        }
/*
        @Override
        public void onClick(View v) {
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. ");
        }
*/
        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. ");
        }
    }
}
