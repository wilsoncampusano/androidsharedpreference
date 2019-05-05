package com.monografico.estudiantes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

public class EditarEstudiante extends AppCompatActivity {

    ImageView foto;
    EditText nombre;
    EditText apellido;
    EditText urlFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_estudiante);

        foto = findViewById(R.id.avatar);
        nombre = findViewById(R.id.etNombre);
        apellido = findViewById(R.id.etApellido);
        urlFoto = findViewById(R.id.etFoto);

        String e = getIntent().getStringExtra("estudiante");

        if (e != null){
            Gson gson = new Gson();
            Estudiante estudiante = gson.fromJson(e, Estudiante.class);

            nombre.setText(estudiante.getNombre());
            apellido.setText(estudiante.getApellido());;
            urlFoto.setText(estudiante.getPhoto());

            Glide.with(getApplicationContext())
                    .load(estudiante.getPhoto())
                    .into(this.foto);
        }
    }
}
