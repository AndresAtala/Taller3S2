package com.gestionEvento.model.data;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;



public class DBGenerator {

    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection, SQLDialect.MYSQL);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);
        crearTablas(create);
        DBConnector.closeConnection();
    }

    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre, "root", "");
        DSLContext create = DSL.using(connection, SQLDialect.MYSQL);
        return create;
    }

    private static void crearBaseDato(DSLContext create, String nombreBD) {
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection, String nombreBD) {
        DBConnector.closeConnection();
        connection = DBConnector.connection(nombreBD, "root", "");
        DSLContext create = DSL.using(connection, SQLDialect.MYSQL);
        return create;
    }

    private static void crearTablas(DSLContext create) {
        create.createTableIfNotExists("Artista")
                .column("nombreArtistico", VARCHAR(100))
                .column("generoMusical", VARCHAR(50))
                .constraint(primaryKey("nombreArtistico"))
                .execute();

        create.createTableIfNotExists("Asistente")
                .column("nombre", VARCHAR(100))
                .column("telefono", VARCHAR(15))
                .column("preferenciasMusicales", VARCHAR(100))
                .constraint(primaryKey("nombre"))
                .execute();

        create.createTableIfNotExists("Entrada")
                .column("precioEntrada", DOUBLE)
                .column("tipoEntrada", VARCHAR(50))
                .column("disponibilidad", INTEGER)
                .constraint(primaryKey("tipoEntrada"))
                .execute();

        create.createTableIfNotExists("EventoMusical")
                .column("nombreEvento", VARCHAR(100))
                .column("fecha", DATE)
                .column("lugar", VARCHAR(200))
                .column("artistas", VARCHAR(500))  // Ajusta el tamaño según tus necesidades
                .constraint(primaryKey("nombreEvento"))
                .execute();
    }
}
