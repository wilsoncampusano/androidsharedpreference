package com.monografico.estudiantes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.monografico.estudiantes.adapter.PaisAdapter;
import com.monografico.estudiantes.modelos.Pais;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // llenarEstudiantes();
        paises();
    }

    private void paises(){
        RecyclerView rv = findViewById(R.id.rvPaises);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);

        List<Pais> paises = new PaisManager().paises();
        PaisAdapter paisAdapter = new PaisAdapter(this, paises);

        rv.setAdapter(paisAdapter);
    }

    private void llenarEstudiantes(){
        ListView lv = findViewById(R.id.rvPaises);

        List<Estudiante> estudiantes = EstudiantesManager.e.estudiantesList();
        AdapterEstudiantes adapterEstudiantes = new AdapterEstudiantes(this, estudiantes);

        lv.setAdapter(adapterEstudiantes);

    }
}
