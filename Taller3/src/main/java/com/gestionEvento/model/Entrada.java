package com.gestionEvento.model;

class Entrada {
    private double precioEntrada;
    private String tipoEntrada;
    private int disponibilidad;

    public Entrada() {}

    public Entrada(double precioEntrada, String tipoEntrada, int disponibilidad) {
        this.precioEntrada = precioEntrada;
        this.tipoEntrada = tipoEntrada;
        this.disponibilidad = disponibilidad;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}

