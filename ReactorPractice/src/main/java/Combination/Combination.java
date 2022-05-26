package Combination;

import model.Persona;
import model.Venta;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void merge(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        List<Persona> personasTwo = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx = Flux.fromIterable(personas);
        Flux<Persona> fx2 = Flux.fromIterable(personasTwo);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        Flux.merge(fx, fx2, fx3).subscribe(p -> System.out.println(p.toString()));
    }

    public static void zip(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        List<Persona> personasTwo = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx = Flux.fromIterable(personas);
        Flux<Persona> fx2 = Flux.fromIterable(personasTwo);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        //Flux.zip(fx, fx2, (p1, p2 ) -> String.format("Flux1: %s, Flux2: %s", p1,p2)).subscribe(x -> System.out.println(x));

        Flux.zip(fx,fx2,fx3).subscribe(x -> System.out.println(x.toString()));
    }

    public static void zipWith(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        List<Persona> personasTwo = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx = Flux.fromIterable(personas);
        Flux<Persona> fx2 = Flux.fromIterable(personasTwo);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        fx.zipWith(fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1,p2)).subscribe(x -> System.out.println(x));
    }


    public static void main(String[] args) {
        zipWith();
    }

}
