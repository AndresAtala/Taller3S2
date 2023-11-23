package com.gestionEvento.controller;

import com.gestionEvento.model.EventoMusical;
import com.gestionEvento.model.data.DBGenerator;
import com.gestionEvento.model.data.DAO.EventoDAO;
import org.jooq.DSLContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistroEventoServlet")
public class RegistroEventoServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("AgendaMusicalBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreEvento = request.getParameter("nombreEvento");
        String fecha = request.getParameter("fecha");
        String lugar = request.getParameter("lugar");
        String artistas = request.getParameter("artistas");

        EventoMusical evento = new EventoMusical(nombreEvento, fecha, lugar, artistas);

        try {
            DSLContext query = DBGenerator.conectarBD("AgendaMusicalBD");

            EventoDAO eventoDAO = new EventoDAO();
            eventoDAO.agregarEvento(query, evento);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }
}

