package co.com.sofka.example.persona.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.persona.values.Nombre;

public class PersonaCreada extends DomainEvent {

    private final Nombre nombre;

    public PersonaCreada(Nombre nombre) {
        super("sofka.persona.personacreada");
        this.nombre = nombre;
    }

    public Nombre getNombre(){
        return nombre;
    }
}
