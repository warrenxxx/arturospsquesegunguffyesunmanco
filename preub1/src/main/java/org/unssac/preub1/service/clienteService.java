/**
 * The clienteService class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :8/08/2018
 */
package org.unssac.preub1.service;

import lombok.Data;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.unssac.preub1.bd.ClienteBd;
import org.unssac.preub1.models.Cliente;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Service
public class clienteService {

    @Autowired
    ClienteBd clienteBd;


    public Mono<ServerResponse> insertar(ServerRequest request) {
        return request.bodyToMono(Cliente.class)
                .map(e->{
                    Cliente aux=e;
                    aux.setContraseña(BCrypt.hashpw(e.getContraseña(), BCrypt.gensalt()));
                    return aux;
                })
                .flatMap(e -> this.clienteBd.insert(e))
                .flatMap(e -> ok().build());
    }
    public Mono<ServerResponse> login(ServerRequest request) {
        return request.bodyToMono(Login.class)
                .flatMap(login -> this.clienteBd.findByUsusario(login.getUserName()).flatMap(
                        cliente -> {
                            if(BCrypt.checkpw(login.getPassword(),cliente.getContraseña())){
                                return ok().body(fromObject("si"));
                            }else{
                                return ok().body(fromObject("no"));
                            }
                        }
                ));
    }

    public static void main(String... args){
        String hashed = BCrypt.hashpw("123", BCrypt.gensalt());


//        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

        if (BCrypt.checkpw("456", hashed))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
        if (BCrypt.checkpw("123", hashed))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
    }
}
@Data
class Login{
    private String userName;
    private String password;
}