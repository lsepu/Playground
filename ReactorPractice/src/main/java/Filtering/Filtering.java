package Filtering;

import model.Persona;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtering {

    public static void filter(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux.fromIterable(personas)
                .filter(p -> p.getEdad() > 28)
                .subscribe(p -> System.out.println(p.toString()));

    }

    public static void distinct(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(1, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        //we can change the hashcode in the model to make it work in objects
        Flux.fromIterable(personas).distinct().subscribe(p -> System.out.println(p.toString()));
    }

    public static void take(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(1, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        //toma los n primeros elementos del flujo
        Flux.fromIterable(personas).take(2).subscribe(p -> System.out.println(p.toString()));

        //toma los n ultimos elementos del flujo
        //Flux.fromIterable(personas).takeLast(2).subscribe(p -> System.out.println(p.toString()));

        //se evita el n primer elemento del flujo
        //Flux.fromIterable(personas).skip(2).subscribe(p -> System.out.println(p.toString()));

        //se evita el n ultimo elemento del flujo
        //Flux.fromIterable(personas).skipLast(2).subscribe(p -> System.out.println(p.toString()));
    }

    public static void main(String[] args) {
        take();
    }

}
