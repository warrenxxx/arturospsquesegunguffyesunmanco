/**
 * The Cliente class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :8/08/2018
 */
package org.unssac.preub1.models;

import lombok.Data;
import org.unssac.preub1.models.Persona;

@Data
public class Cliente   extends Persona {
    private String nacionalidad;

    public Cliente(String nacionalidad) {
        this.setRol("cliente");
        this.nacionalidad = nacionalidad;
    }

    public Cliente() {
    }
}
