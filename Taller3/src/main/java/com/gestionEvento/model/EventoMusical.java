package com.gestionEvento.model;

class EventoMusical {
    private String nombreEvento;
    private String fecha;
    private String lugar;
    private String artistas; // Representación como cadena de artistas

    public EventoMusical() {}

    public EventoMusical(String nombreEvento, String fecha, String lugar, String artistas) {
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.lugar = lugar;
        this.artistas = artistas;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getArtistas() {
        return artistas;
    }

    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }
}
