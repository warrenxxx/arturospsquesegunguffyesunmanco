/**
 * The ClienteController class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :8/08/2018
 */
package org.unssac.preub1.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.unssac.preub1.service.clienteService;
import org.unssac.preub1.service.recepcionistaService;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class AllController {

    @Bean
    public RouterFunction clienteRutas(clienteService service){
        return route(POST("/cliente"),req->service.insertar(req))
                .andRoute(POST("/cliente/login"),req->service.login(req));

    }
    @Bean
    public RouterFunction receptRutas(recepcionistaService service){
        return
                route(POST("/recep"),req->service.insertar(req))
                        .andRoute(GET("/recep"),req->service.buscar(req))
                        .andRoute(GET("/recep/{id}"),req->service.buscarById(req))
                ;
    }
}
