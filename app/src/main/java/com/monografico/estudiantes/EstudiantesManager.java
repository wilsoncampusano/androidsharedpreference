package com.monografico.estudiantes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EstudiantesManager {

    public final static EstudiantesManager e = new EstudiantesManager();

    private SharedPreferences estudiantesPreference;
    private Context context;

    public EstudiantesManager() {
    }

    public EstudiantesManager(Context context) {
        this.estudiantesPreference = context.getSharedPreferences("estudiantes", 0);
        this.context = context;

    }

    public static EstudiantesManager build(Context context) {
        return new EstudiantesManager(context);
    }


    public void GuardarEstudiante(Estudiante estudiante){
        Gson gson = new Gson();
        SharedPreferences.Editor editor = estudiantesPreference.edit();
        int nextId = estudiantesPreference.getInt("cantidadEstudiantes", 0) + 1;
        estudiante.id = new Long(nextId);
        String json = gson.toJson(estudiante);
        editor.putInt("cantidadEstudiantes", nextId);
        editor.putString(String.valueOf(nextId), json);
        editor.apply();
        editor.commit();

    }

    public  void actualizar(Estudiante estudiante){
        Gson gson = new Gson();
        SharedPreferences.Editor editor = estudiantesPreference.edit();
        String json = gson.toJson(estudiante);

        editor.putString(String.valueOf(estudiante.id), json);
        editor.apply();
        editor.commit();
    }

    public List<Estudiante> todos(){
        List<Estudiante> estudiantes = new ArrayList<>();

        int cantidadEstudiantes = estudiantesPreference.getInt("cantidadEstudiantes", 0);
        Gson gson = new Gson();

        for (int i=0; i<= cantidadEstudiantes; i++){
            String numeroRegistro = estudiantesPreference.getString(String.valueOf(i),null);
            if(numeroRegistro == null)
                continue;
            System.out.println(numeroRegistro);
            Estudiante e = gson.fromJson( numeroRegistro, Estudiante.class);
            System.out.println(e);

            estudiantes.add(e);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            estudiantes.sort(new Comparator<Estudiante>() {
               @Override
               public int compare(Estudiante o1, Estudiante o2) {
                   return o2.id.compareTo(o1.id);
               }
           });
        }

        return estudiantes;
    }

}
