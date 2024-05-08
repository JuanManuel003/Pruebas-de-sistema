package co.com.uniquindio.edu.pruebas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usuario2 {
    @JsonProperty("email")
    private String correo;

    @JsonProperty("contrasena")
    private String contrasena;

    @JsonProperty("nombre")
    private String nombre;


    public Usuario2(String nombre, String contrasenia, String correo){
        this.nombre = nombre;
        this.contrasena = contrasenia;
        this.correo = correo;
    }

    @JsonProperty("correo")
    public String getCorreo() {
        return correo;
    }

    @JsonProperty("correo")
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @JsonProperty("contrasena")
    public String getContrasena() {
        return contrasena;
    }

    @JsonProperty("contrasena")
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
