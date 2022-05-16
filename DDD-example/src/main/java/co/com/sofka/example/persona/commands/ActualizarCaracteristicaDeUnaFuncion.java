package co.com.sofka.example.persona.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.example.persona.values.Caracteristica;
import co.com.sofka.example.persona.values.FuncionId;
import co.com.sofka.example.persona.values.PersonaId;

//cuando un comando viene de un usuario tiene consecuencias que puede ser por ejemplo en este caso caracteristicaDeUnaFuctionActualizada

public class ActualizarCaracteristicaDeUnaFuncion extends Command {

    private final PersonaId personaId;
    private final FuncionId entityId;
    private final Caracteristica caracteristica;

    public ActualizarCaracteristicaDeUnaFuncion(PersonaId personaId, FuncionId entityId, Caracteristica caracteristica) {
        this.personaId = personaId;
        this.entityId = entityId;
        this.caracteristica = caracteristica;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public FuncionId getEntityId() {
        return entityId;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }
}
