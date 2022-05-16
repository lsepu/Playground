package co.com.sofka.example.persona.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.example.persona.values.Descripcion;
import co.com.sofka.example.persona.values.FuncionId;
import co.com.sofka.example.persona.values.PersonaId;

public class ActualizarDescripcionDeUnaFuncion extends Command {

    private final PersonaId personaId;
    private final FuncionId entityId;
    private final Descripcion descripcion;

    public ActualizarDescripcionDeUnaFuncion(PersonaId personaId, FuncionId entityId, Descripcion descripcion) {
        this.personaId = personaId;
        this.entityId = entityId;
        this.descripcion = descripcion;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public FuncionId getEntityId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
