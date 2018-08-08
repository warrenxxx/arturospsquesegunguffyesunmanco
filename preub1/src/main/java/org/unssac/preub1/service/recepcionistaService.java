/**
 * The recepcionistaService class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :8/08/2018
 */
package org.unssac.preub1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.unssac.preub1.bd.RecepcionistaBD;
import org.unssac.preub1.models.Cliente;
import org.unssac.preub1.models.Recepcionista;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Service
public class recepcionistaService {

    @Autowired
    RecepcionistaBD recepcionistaBD;

    public Mono<ServerResponse> insertar(ServerRequest request){
        return request.bodyToMono(Recepcionista.class)
                .flatMap(e -> this.recepcionistaBD.insert(e))
                .flatMap(e -> ok().build());

    }
    public Mono<ServerResponse> buscar(ServerRequest request){
        return
                ok().body(this.recepcionistaBD.findAll(),Recepcionista.class);

    }
    public Mono<ServerResponse> buscarById(ServerRequest request){
        return
                ok().body(this.recepcionistaBD.findById(request.pathVariable("id")),Recepcionista.class);
    }
}
