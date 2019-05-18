package com.monografico.estudiantes.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.monografico.estudiantes.modelos.Estudiante;
import com.monografico.estudiantes.managers.EstudiantesManager;
import com.monografico.estudiantes.R;

public class EditarEstudiante extends AppCompatActivity {

    ImageView foto;
    EditText nombre;
    EditText apellido;
    EditText urlFoto;
    Button guardar;
    Estudiante estudiante = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_estudiante);

        foto = findViewById(R.id.avatar);
        nombre = findViewById(R.id.etNombre);
        apellido = findViewById(R.id.etApellido);
        urlFoto = findViewById(R.id.etFoto);
        guardar = findViewById(R.id.btnGuardar);

        String e = getIntent().getStringExtra("estudiante");

        if (e != null && !e.isEmpty() && !e.equals("{}")){
            guardar.setText("Editar");
            Gson gson = new Gson();
            estudiante = gson.fromJson(e, Estudiante.class);

            nombre.setText(estudiante.getNombre());
            apellido.setText(estudiante.getApellido());;
            urlFoto.setText(estudiante.getPhoto());

            Glide.with(getApplicationContext())
                    .load(estudiante.getPhoto())
                    .into(this.foto);
        }else {
            guardar.setText("Guardar Nuevo");
            estudiante = new Estudiante();

        }
    }

    public void clickGuardar(View view) {
        if(datosValidos()){

            if ((estudiante != null && null == estudiante.id) || new Long(0L).equals(estudiante.id)){
                crearEstudiante();
            }else {
                actualizarEstudiante();
            }
        }else {
            Toast.makeText(this, "Debe completar los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean datosValidos() {
        String n = nombre.getText().toString().trim();
        String a = apellido.getText().toString().trim();
        return !n.isEmpty() && !a.isEmpty();
    }

    private void actualizarEstudiante() {
        estudiante.nombre = nombre.getText().toString();
        estudiante.apellido = apellido.getText().toString();
        estudiante.photo = urlFoto.getText().toString();
        EstudiantesManager.build(this).actualizar(estudiante);
        onBackPressed();
    }

    private void crearEstudiante() {
        String n = nombre.getText().toString().trim();
        String a = apellido.getText().toString().trim();
        String f = urlFoto.getText().toString().trim();

        Estudiante e = new Estudiante(0l,n,a,f);
        EstudiantesManager.build(this).GuardarEstudiante(e);
        onBackPressed();
    }
}
