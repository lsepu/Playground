package co.com.sofka.example.cuenta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.example.cuenta.values.CuentaId;
import co.com.sofka.example.cuenta.values.Email;
import co.com.sofka.example.cuenta.values.Nombre;

public class Cuenta extends AggregateEvent<CuentaId> {

    public Cuenta(CuentaId entityId, Email email, Nombre nombre) {
        super(entityId);
    }
}
