package com.gestionEvento.controller;

import com.gestionEvento.model.Artista;
import com.gestionEvento.model.data.DBGenerator;
import com.gestionEvento.model.data.DAO.ArtistaDAO;
import org.jooq.DSLContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistroArtistaServlet")
public class RegistroArtistaServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("EventoMusicalBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreArtistico = request.getParameter("nombreArtistico");
        String generoMusical = request.getParameter("generoMusical");

        Artista artista = new Artista(nombreArtistico, generoMusical);

        try {
            DSLContext query = DBGenerator.conectarBD("EventoMusicalBD");

            ArtistaDAO artistaDAO = new ArtistaDAO();
            artistaDAO.agregarArtista(query, artista);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }
}
