package com.gestionEvento.model.data.DAO;

import com.gestionEvento.model.EventoMusical;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

public class EventoDAO {

    public void agregarEvento(DSLContext query, EventoMusical evento) {
        try {
            query.insertInto(table("EventoMusical"),
                            field("nombreEvento"),
                            field("fecha"),
                            field("lugar"),
                            field("artistas"))
                    .values(evento.getNombreEvento(), evento.getFecha(), evento.getLugar(), evento.getArtistas())
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<EventoMusical> obtenerTodosLosEventos(DSLContext query) {
        List<EventoMusical> eventos = new ArrayList<>();
        Result<Record> result = query.select().from(table("EventoMusical")).fetch();
        for (Record record : result) {
            EventoMusical evento = construirEventoDesdeRecord(record);
            eventos.add(evento);
        }
        return eventos;
    }
    private EventoMusical construirEventoDesdeRecord(Record record) {
        return new EventoMusical(
                record.get(field("nombreEvento", String.class)),
                record.get(field("fecha", String.class)),
                record.get(field("lugar", String.class)),
                record.get(field("artistas", String.class))
        );
    }
}

