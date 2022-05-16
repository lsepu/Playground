package co.com.sofka.example.persona;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.example.persona.events.*;

import java.util.HashSet;

public class PersonaChange extends EventChange {
    public PersonaChange(Persona persona) {

        //cuando la persona es creada, que estados voy a cambiar
        apply((PersonaCreada event) -> {
            persona.nombre = event.getNombre();
            persona.funciones = new HashSet<>();
        });

        apply((CuentaAsociada event) -> {
            persona.cuentaId = event.getCuentaId();
        });

        apply((DescripcionDeFuncionActualizada event) -> {
            var funcion = persona.getFuncionPorId(event.getFuncionId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la función de la persona"));
            funcion.actualizarDescripcion(event.getDescripcion());
        });

        apply((CaracteristicaDeFuncionActualizada event) -> {
            var funcion = persona.getFuncionPorId(event.getFuncionId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la función de la persona"));
            funcion.actualizarCaracteristica(event.getCaracteristica());
        });

        //se agregan reglas o condiciones del dominio, ex:
        apply((FuncionAgregada event) -> {
            var numFunciones = persona.funciones.size();
            if (numFunciones == 6) {
                throw new IllegalArgumentException("No puedes agregar mas funciones, solo puedes tener maximo 6 de ellas");
            }

            persona.funciones.add(new Funcion(
                            event.getFuncionId(),
                            event.getCaracteristica(),
                            event.getDescripcion()
                    ));
        });

        apply((NombreCambiado event) -> {
            persona.nombre = event.getNombre();
        });

    }

}
