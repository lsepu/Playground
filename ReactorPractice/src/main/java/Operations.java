import model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Operations {

    //suscribe -> recolección de datos
    public static void reactor(){
        Mono.just(new Persona(1, "Mito", 29)).subscribe( p -> System.out.println(p.toString()));
    }

    //do on next -> se usa para depuración
    public static void reactorDoOnNext(){
        Mono.just(new Persona(1, "Mito", 29))
                .doOnNext( p -> {
                    //logica adicional
                    System.out.println(p.toString());
                })
                .subscribe( p -> System.out.println(p.toString()));
    }


    public static void flux(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux.fromIterable(personas).subscribe(p -> System.out.println(p.toString()));
    }

    //en vez de recorrer elemento x elemento muestra toda la lista como un solo bloque
    public static void fluxMono(){
        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona(1, "Mito", 27));
        personas.add(new Persona(2, "Mito", 28));
        personas.add(new Persona(3, "Mito", 29));

        Flux<Persona> fx = Flux.fromIterable(personas);
        fx.collectList().subscribe(list -> System.out.println(list.toString()));
    }

    public static void main(String[] args) {
        fluxMono();
    }

}
