package com.gestionEvento.model.data.DAO;

import com.gestionEvento.model.Asistente;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

public class AsistenteDAO {

    public void agregarAsistente(DSLContext query, Asistente asistente) {
        try {
            query.insertInto(table("Asistente"),
                            field("nombre"),
                            field("telefono"),
                            field("preferenciasMusicales"))
                    .values(asistente.getNombre(), asistente.getTelefono(), asistente.getPreferenciasMusicales())
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }
    }

    public List<Asistente> obtenerTodosLosAsistentes(DSLContext query) {
        List<Asistente> asistentes = new ArrayList<>();
        Result<Record> result = query.select().from(table("Asistente")).fetch();
        for (Record record : result) {
            Asistente asistente = construirAsistenteDesdeRecord(record);
            asistentes.add(asistente);
        }
        return asistentes;
    }

    // Agrega cualquier método adicional necesario para la manipulación de asistentes

    private Asistente construirAsistenteDesdeRecord(Record record) {
        return new Asistente(
                record.get(field("nombre", String.class)),
                record.get(field("telefono", String.class)),
                record.get(field("preferenciasMusicales", String.class))
        );
    }
}

