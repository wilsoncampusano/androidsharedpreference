package com.monografico.estudiantes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.monografico.estudiantes.adapter.PaisAdapter;
import com.monografico.estudiantes.modelos.Pais;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       llenarEstudiantes();
       // paises();
    }

    private void paises(){
       // RecyclerView rv = findViewById(R.id.lvEstudiantes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
       // rv.setLayoutManager(linearLayoutManager);

        List<Pais> paises = new PaisManager().paises();
        PaisAdapter paisAdapter = new PaisAdapter(this, paises);

       // rv.setAdapter(paisAdapter);
    }

    private void llenarEstudiantes(){
        ListView lv = findViewById(R.id.lvEstudiantes);

        final List<Estudiante> estudiantes = EstudiantesManager.e.estudiantesList();
        EstudiantesManager estudiantesManager = new EstudiantesManager(getApplicationContext());

        AdapterEstudiantes adapterEstudiantes = new AdapterEstudiantes(this, estudiantesManager.todos());

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), EditarEstudiante.class);
                intent.putExtra("estudiante", new Gson().toJson(estudiantes.get(position)));

                startActivity(intent);
            }
        });

        lv.setAdapter(adapterEstudiantes);

    }
}
