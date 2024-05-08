package co.com.uniquindio.edu.pruebas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usuario {
    @JsonProperty("email")
    private String email;

    @JsonProperty("contrasena")
    private String contrasena;

    public Usuario(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("contrasena")
    public String getContrasena() {
        return contrasena;
    }

    @JsonProperty("contrasena")
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}