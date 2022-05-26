package Transformation;

import model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformation {

    public static void map(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        //lo mismo con mono
        Flux.fromIterable(personas).map(p -> {
            p.setEdad(p.getEdad() + 10);
            return p;
        })
                .subscribe(p -> System.out.println(p.toString()));
    }

    public static void mapTwo(){
        Flux<Integer> fx = Flux.range(0, 10);
        Flux<Integer> fx2 = fx.map(x -> x + 10);
        fx2.subscribe(x -> System.out.println(x.toString()));
    }

    public static void flatMap(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux.fromIterable(personas).flatMap(p -> {
            p.setEdad(p.getEdad() + 10);
            //retorna otro flujo
            return Mono.just(p);
        }).subscribe(p -> System.out.println(p.toString()));

    }

    public static void groupBy(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(1, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux.fromIterable(personas)
                .groupBy(Persona::getIdPersona)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(x -> System.out.println(x.toString()));

    }


    public static void main(String[] args) {
        groupBy();
    }
}
