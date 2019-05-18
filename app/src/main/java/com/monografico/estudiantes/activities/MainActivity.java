package com.monografico.estudiantes.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.monografico.estudiantes.adapter.AdapterEstudiantes;
import com.monografico.estudiantes.modelos.Estudiante;
import com.monografico.estudiantes.managers.EstudiantesManager;
import com.monografico.estudiantes.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Estudiante> todos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onResume() {
        super.onResume();
        llenarEstudiantes();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        llenarEstudiantes();
    }

    @Override
    protected void onStart() {
        super.onStart();
        llenarEstudiantes();

    }

    private void llenarEstudiantes(){
        ListView lv = findViewById(R.id.lvEstudiantes);

        EstudiantesManager estudiantesManager = new EstudiantesManager(getApplicationContext());

        todos = (ArrayList<Estudiante>) estudiantesManager.todos();
        AdapterEstudiantes adapterEstudiantes = new AdapterEstudiantes(this, todos);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Estudiante estudiante = todos.get(position);
                IrASegundoActivity(estudiante);
            }
        });

        lv.setAdapter(adapterEstudiantes);

    }

    private void IrASegundoActivity(Estudiante estudiante) {
        Intent intent = new Intent(getApplicationContext(), EditarEstudiante.class);
        intent.putExtra("estudiante", new Gson().toJson(estudiante));

        startActivity(intent);
    }

    public void clickCrearNuevo(View view) {
        Estudiante estudiante = new Estudiante();
        IrASegundoActivity(estudiante);
    }
}
