package MathOperator;

import model.Persona;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MathOperator {

    public static void average(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux.fromIterable(personas)
                .collect(Collectors.averagingInt(Persona::getEdad))
                .subscribe( p -> System.out.println(p.toString()));
    }

    public static void count(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux.fromIterable(personas)
                .count()
                .subscribe( x -> System.out.println(x));
    }

    public static void min(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux.fromIterable(personas)
                .collect(Collectors.minBy(Comparator.comparing(Persona::getEdad)))
                .subscribe( x -> System.out.println(x.get().toString()));

    }

    public static void sum(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux.fromIterable(personas)
                .collect(Collectors.summingInt(Persona::getEdad))
                .subscribe( x -> System.out.println(x));
    }

    public static void sumarizing(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux.fromIterable(personas)
                .collect(Collectors.summarizingInt(Persona::getEdad))
                .subscribe( x -> System.out.println("Resumen: " + x));


    }

    public static void main(String[] args) {

        sumarizing();
    }

}
