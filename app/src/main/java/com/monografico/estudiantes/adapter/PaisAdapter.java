package com.monografico.estudiantes.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.monografico.estudiantes.R;
import com.monografico.estudiantes.modelos.Pais;

import java.util.List;

public class PaisAdapter extends RecyclerView.Adapter<PaisAdapter.PaisViewHolder> {


    List<Pais> paises;
    Context context;


    public PaisAdapter(Context context, List<Pais> paises) {
        this.paises = paises;
        this.context = context;
    }

    @NonNull
    @Override
    public PaisViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.lista,
                viewGroup, false);

        PaisViewHolder paisViewHolder = new PaisViewHolder(view);
        return paisViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull PaisViewHolder paisViewHolder, int i) {
        paisViewHolder.tvNombre.setText(paises.get(i).nombre);
        paisViewHolder.tvCodigo.setText(paises.get(i).codigo);


        Glide.with(context)
                .load(paises.get(i).foto)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(paisViewHolder.ivFoto);

    }

    @Override
    public int getItemCount() {
        return paises.size();
    }

    public class PaisViewHolder extends RecyclerView.ViewHolder{

        ImageView ivFoto;
        TextView tvNombre;
        TextView tvCodigo;

        public PaisViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.ivPhoto);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvNombre = itemView.findViewById(R.id.tvNombre);
        }
    }
}
