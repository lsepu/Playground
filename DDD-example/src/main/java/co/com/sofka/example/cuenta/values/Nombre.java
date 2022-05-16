package co.com.sofka.example.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String value;

    public Nombre(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        if(this.value.length() <= 4){
            throw new IllegalArgumentException("Debes tener mayor a 4 caracteres");
        }

        if(this.value.length() >= 100){
            throw new IllegalArgumentException("Debes set menor a 100 caracteres");
        }

    }

    public String value() {
        return value;
    }
}
