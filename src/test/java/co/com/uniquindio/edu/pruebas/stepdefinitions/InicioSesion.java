package co.com.uniquindio.edu.pruebas.stepdefinitions;

import co.com.uniquindio.edu.pruebas.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.jupiter.api.extension.ExtendWith;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.StringContains.containsString;

@ExtendWith(SerenityJUnit5Extension.class)
public class InicioSesion {

    public static EnvironmentVariables environmentVariables;
    private Usuario usuario;

    @Before
    public void setStage() {
        setTheStage(Cast.whereEveryoneCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl"))));
    }

    @Dado("que {string} con email {string} y contrasena {string}")
    public void lauraConEmailYContrasenia(String nombre, String email, String contrasena){
        theActorCalled(nombre).entersTheScene();
        usuario = new Usuario(email,contrasena);

    }

    @Cuando("se realiza una solicitud POST a {string} con el email y contrasena validos")
    public void solicitudInicioSesion(String url){
        theActorInTheSpotlight().attemptsTo(Post.to(url).with(request -> request.body(usuario)));
    }

    @Entonces("la respuesta debe tener un codigo de estado 200")
    public void verificarEstadoRespuestaCorrecta(){
        theActorInTheSpotlight().should(seeThatResponse(
                "el estatus es 200", response -> response.statusCode(200)));
    }

    @Y("la respuesta debe incluir el mensaje {string}")
    public void laRespuestaDebeIncluirElMensaje(String mensaje) {
        theActorInTheSpotlight().should(seeThatResponse(
                "Verifica el mensaje en la respuesta",
                response -> response.body(containsString(mensaje))));
        System.out.println(mensaje);
    }
}