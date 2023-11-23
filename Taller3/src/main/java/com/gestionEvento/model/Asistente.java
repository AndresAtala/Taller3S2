package com.gestionEvento.model;

public class Asistente {
    private String nombre;
    private String telefono;
    private String preferenciasMusicales;

    public Asistente() {}

    public Asistente(String nombre, String telefono, String preferenciasMusicales) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.preferenciasMusicales = preferenciasMusicales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPreferenciasMusicales() {
        return preferenciasMusicales;
    }

    public void setPreferenciasMusicales(String preferenciasMusicales) {
        this.preferenciasMusicales = preferenciasMusicales;
    }
}

