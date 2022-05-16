package co.com.sofka.example.persona.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.example.persona.values.Caracteristica;
import co.com.sofka.example.persona.values.Descripcion;
import co.com.sofka.example.persona.values.FuncionId;

public class AgregarFuncion extends Command {

    private final FuncionId funcionId;
    private final Caracteristica caracteristica;
    private final Descripcion descripcion;

    public AgregarFuncion(FuncionId funcionId, Caracteristica caracteristica, Descripcion descripcion) {
        this.funcionId = funcionId;
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
