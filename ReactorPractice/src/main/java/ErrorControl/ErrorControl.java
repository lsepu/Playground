package ErrorControl;

import model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class ErrorControl {

    public static void retry(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .retry(1) //tras la ejecucion del error vuelve a ejecutar el flujo
                .doOnNext(x -> System.out.println(x.toString()))
                .subscribe();
    }

    public static void errorReturn(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .onErrorReturn(new Persona(0, "XYZ", 99)) //tras la aparicion del error devuelve un objeto por defecto
                .subscribe(x -> System.out.println(x.toString()));

    }

    public static void errorResume(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .onErrorResume(e -> Mono.just(new Persona(0, "XYZ", 99))) //devuelvo una instancia por defecto
                .subscribe(x -> System.out.println(x.toString()));
    }


    public static void errorMap() {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .onErrorMap(e -> new InterruptedException(e.getMessage()))
                .subscribe(x -> System.out.println(x.toString()));

    }

    public static void main(String[] args) {
        errorMap();
    }

}
