package co.com.sofka.example.persona.values;

import co.com.sofka.domain.generic.Identity;

public class PersonaId extends Identity {

    //genera un id random
    public PersonaId(){

    }

    private PersonaId(String id){
        super(id);
    }

    public static PersonaId of (String id){
        return new PersonaId(id);
    }


}
