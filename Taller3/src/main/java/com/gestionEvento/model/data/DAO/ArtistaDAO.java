package com.gestionEvento.model.data.DAO;

import com.gestionEvento.model.Artista;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

public class ArtistaDAO {

    public void agregarArtista(DSLContext query, Artista artista) {
        if (!existeArtista(query, artista.getNombreArtistico())) {
            try {
                query.insertInto(table("Artista"),
                                field("nombreArtistico"),
                                field("generoMusical"))
                        .values(artista.getNombreArtistico(), artista.getGeneroMusical())
                        .execute();
            } catch (Exception e) {
                e.printStackTrace();
                // Manejar la excepción adecuadamente
            }
        } else {
            // Puedes manejar la lógica para indicar que el artista ya existe
            System.out.println("El artista ya existe.");
        }
    }

    public List<Artista> obtenerTodosLosArtistas(DSLContext query) {
        List<Artista> artistas = new ArrayList<>();
        Result<Record> result = query.select().from(table("Artista")).fetch();
        for (Record record : result) {
            Artista artista = construirArtistaDesdeRecord(record);
            artistas.add(artista);
        }
        return artistas;
    }

    private Artista construirArtistaDesdeRecord(Record record) {
        return new Artista(
                record.get(field("nombreArtistico", String.class)),
                record.get(field("generoMusical", String.class))
        );
    }

    private boolean existeArtista(DSLContext query, String nombreArtistico) {
        Result<Record> result = query.select()
                .from(table("Artista"))
                .where(field("nombreArtistico").eq(nombreArtistico))
                .fetch();

        return !result.isEmpty();
    }
}
