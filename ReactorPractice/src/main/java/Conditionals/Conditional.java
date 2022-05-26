package Conditionals;

import model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Conditional {

    public static void defaultIfEmpty(){
        //Mono.empty()
        //Flux.empty()
        Mono.just(new Persona(1, "Mito", 29))
                .defaultIfEmpty(new Persona(0, "DEFAULT", 99))
                .subscribe(x -> System.out.println(x.toString()));
    }

    public static void takeUntil() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));


        //el flujo se transmite hasta que suceda la condición establecida
        Flux.fromIterable(personas)
                .takeUntil(p -> p.getEdad() > 27)
                .subscribe(x -> System.out.println(x.toString()));
    }

    public static void timeout() throws InterruptedException {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));


        //espero maximo 2 segundos, si no hay lectura de datos en esos 2 segundos lanzo timeout
        Flux.fromIterable(personas)
                .delayElements(Duration.ofSeconds(1))
                .timeout(Duration.ofSeconds(2))
                .subscribe(x -> System.out.println(x.toString()));

        Thread.sleep(100000);
    }


    public static void main(String[] args) throws InterruptedException {

        timeout();

    }

}
