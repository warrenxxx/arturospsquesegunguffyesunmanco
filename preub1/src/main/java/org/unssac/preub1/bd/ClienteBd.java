package org.unssac.preub1.bd;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.unssac.preub1.models.Cliente;
import reactor.core.publisher.Mono;

public interface ClienteBd extends ReactiveMongoRepository<Cliente,String> {
    Mono<Cliente> findByUsusario(String usuario);
}
