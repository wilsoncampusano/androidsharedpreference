package com.monografico.estudiantes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class AdapterEstudiantes extends BaseAdapter{

    private Context context;
    private List<Estudiante> estudiantes;
    public AdapterEstudiantes(Context context, List<Estudiante> estudiantes) {
        this.context = context;
        this.estudiantes = estudiantes;
    }

    @Override
    public int getCount() {
        return estudiantes.size();
    }

    @Override
    public Object getItem(int position) {
        return estudiantes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return estudiantes.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.lista, parent, false);
        TextView tvNombre = view.findViewById(R.id.tvNombre);
        TextView tvApellido = view.findViewById(R.id.tvCodigo);
        ImageView photo = view.findViewById(R.id.ivPhoto);

        Estudiante estudiante = estudiantes.get(position);



        Glide.with(context)
                .load(estudiante.photo)
                .into(photo);

        tvNombre.setText(estudiante.nombre);
        tvApellido.setText(estudiante.apellido);

        return view;
    }
}
