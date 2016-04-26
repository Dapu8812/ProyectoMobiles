package com.uniquindio.android.electiva.proyectomobiles.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.android.electiva.proyectomobiles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SugerenciasFragment extends Fragment {


    public SugerenciasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sugerencias, container, false);
    }

}
