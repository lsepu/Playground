package co.com.sofka.example.persona;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.cuenta.values.CuentaId;
import co.com.sofka.example.persona.events.*;
import co.com.sofka.example.persona.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Persona extends AggregateEvent<PersonaId> {

    protected Nombre nombre;
    protected Set<Funcion> funciones;
    protected CuentaId cuentaId;

    //creacion del agregado
    public Persona(PersonaId entityId, Nombre nombre) {
        super(entityId);
        //cuando un caso de uso este usando el agregado, le va a pasar el identificador y el nombre
        //lanza un evento de dominio -> la consec   uencia es que la persona fue creada
        appendChange(new PersonaCreada(nombre)).apply();
        subscribe(new PersonaChange(this));

    }

    //afectar los estados
    private Persona(PersonaId entityId){
        super(entityId);
        // suscriptor que esta al tanto de los eventos para cambiar el estado dentro del agregado
        subscribe(new PersonaChange(this));
    }

    //factoria que permite crear el agregado sin tener que pasar sus argumentos
    // obtiene un agregado que ya fue guardado... obtengo sus eventos.
    public static Persona from (PersonaId personaId, List<DomainEvent> events){
        var persona = new Persona(personaId);
        events.forEach(persona::applyEvent);
        return persona;
    }



    //comportamientos
    public void agregarFuncion(FuncionId entityId, Caracteristica caracteristica, Descripcion descripcion){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(caracteristica);
        Objects.requireNonNull(descripcion);

        appendChange(new FuncionAgregada(entityId, caracteristica, descripcion)).apply();
    }

    public void asociarCuenta(CuentaId cuentaId){
        Objects.requireNonNull(cuentaId);
        appendChange(new CuentaAsociada(cuentaId)).apply();
    }

    public void cambiarNombre(Nombre nombre){
        appendChange(new NombreCambiado(nombre)).apply();
    }

    public void actualizarCaracteristicaDeUnaFuncion(FuncionId entityId, Caracteristica caracteristica){
        appendChange(new CaracteristicaDeFuncionActualizada(entityId, caracteristica)).apply();

    }

    public void actualizarDescripcionDeUnaFuncion(FuncionId entityId, Descripcion descripcion){
        appendChange(new DescripcionDeFuncionActualizada(entityId, descripcion)).apply();

    }

    protected Optional<Funcion> getFuncionPorId(FuncionId entityId){
        return funciones
                .stream()
                .filter(funcion -> funcion.identity().equals(entityId))
                .findFirst();
    }

    public Nombre nombre(){
        return nombre;
    }

    public CuentaId cuentaId(){
        return cuentaId;
    }

    public Set<Funcion> funciones(){
        return funciones;
    }


}
