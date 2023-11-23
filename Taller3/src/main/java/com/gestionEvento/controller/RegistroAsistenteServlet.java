package com.gestionEvento.controller;

import com.gestionEvento.model.Asistente;
import com.gestionEvento.model.data.DBGenerator;
import com.gestionEvento.model.data.DAO.AsistenteDAO;
import org.jooq.DSLContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistroAsistenteServlet")
public class RegistroAsistenteServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("AgendaMusicalBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String preferenciasMusicales = request.getParameter("preferenciasMusicales");

        Asistente asistente = new Asistente(nombre, telefono, preferenciasMusicales);

        try {
            DSLContext query = DBGenerator.conectarBD("AgendaMusicalBD");

            AsistenteDAO asistenteDAO = new AsistenteDAO();
            asistenteDAO.agregarAsistente(query, asistente);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("RegistroAsistenteExitoso.jsp");
    }
}

