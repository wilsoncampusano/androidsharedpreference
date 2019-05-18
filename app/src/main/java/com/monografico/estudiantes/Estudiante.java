package com.monografico.estudiantes;

public class Estudiante {
    public Long id;
    public String nombre;
    public String apellido;
    public String photo;

    public Estudiante(Long id, String nombre, String apellido, String photo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.photo = photo;
    }

    public Estudiante() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



}
