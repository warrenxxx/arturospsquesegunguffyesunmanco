/**
 * The Persona class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :8/08/2018
 */
package org.unssac.preub1.models;

import lombok.Data;

@Data
public class Persona {
    private String id;
    private String nombre;
    private String direccion;
    private String tipoDocumento;
    private String documento;
    private String telefono;
    private String rol;
    private String email;
    private String ususario;
    private String contraseña;

}
