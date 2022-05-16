package co.com.sofka.example.cuenta.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.example.persona.values.FuncionId;

public class CuentaId extends Identity {

    //genera un id random
    public CuentaId(){

    }

    private CuentaId(String id){
        super(id);
    }

    public static CuentaId of (String id){
        return new CuentaId(id);
    }
}
