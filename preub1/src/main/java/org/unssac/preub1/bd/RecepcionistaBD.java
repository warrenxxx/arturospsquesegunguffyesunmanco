/**
 * The RecepcionistaBD class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :8/08/2018
 */
package org.unssac.preub1.bd;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.unssac.preub1.models.Recepcionista;

public interface RecepcionistaBD extends ReactiveMongoRepository<Recepcionista,String> {
}
