package Creation;

import model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creation {

    public static void justFrom(){
        Mono.just(new Persona(1, "Mito", 29));
    }

    public static void empty(){
        Mono.empty();
    }

    public static void range(){
        Flux.range(0, 3)
                .doOnNext(i -> System.out.println(i))
                .subscribe();
    }

    public static void repeat(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        //lo mismo con mono
        Flux.fromIterable(personas).repeat(3).subscribe(p -> System.out.println(p.toString()));
    }

    public static void main(String[] args) {
        repeat();
    }
}
