package com.example.tulio.proyectoinformatico.Fragmentos.Inicio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tulio.proyectoinformatico.Adaptadores.NoticiaAdapter;
import com.example.tulio.proyectoinformatico.IO.PruebaApiAdapter;
import com.example.tulio.proyectoinformatico.Model.Noticia;
import com.example.tulio.proyectoinformatico.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tab_Noticias extends Fragment implements Callback<ArrayList<Noticia>> {

    private NoticiaAdapter mAdapter;
    private RecyclerView prueba;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
        View rootView= inflater.inflate(R.layout.noticias, container, false);
        prueba = (RecyclerView) rootView.findViewById(R.id.noticiabd);


        prueba.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new NoticiaAdapter();
        prueba.setAdapter(mAdapter);

        Call<ArrayList<Noticia>> call = PruebaApiAdapter.getApiService().getNoticia();
        call.enqueue( this);



        return rootView;
    }

    @Override
    public void onResponse(Call<ArrayList<Noticia>> call, Response<ArrayList<Noticia>> response) {
        if(response.isSuccessful()){

            ArrayList<Noticia> respuesta = response.body();
            Log.d("Respuesta de bd", "tamaño del arreglo =>" + respuesta.size());
            mAdapter.setmDataSet(respuesta);

        }
    }

    @Override
    public void onFailure(Call<ArrayList<Noticia>> call, Throwable t) {
        Log.i("ERRRORRRRR!!!",t.getMessage());

    }

}
