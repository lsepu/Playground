package co.com.sofka.example.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {

    private final String value;

    public Email(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El email no puede estar vacio");
        }

        if(this.value.length() <= 4){
            throw new IllegalArgumentException("Debes tener mayor a 4 caracteres");
        }

        /**
         * Validación regex de email
        if(this.value.length() >= 100){
            throw new IllegalArgumentException("El email no es valido");
        }
         */

    }

    public String value() {
        return value;
    }
}
