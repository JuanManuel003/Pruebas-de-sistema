package co.com.uniquindio.edu.pruebas.stepdefinitions;
import co.com.uniquindio.edu.pruebas.model.Usuario2;
import com.github.javafaker.Faker;
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

import java.util.UUID;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.StringContains.containsString;

@ExtendWith(SerenityJUnit5Extension.class)
public class AgregarUsuario {

    public static EnvironmentVariables environmentVariables;
    private Usuario2 usuario2;

    private String nombre, contrasenia, correo;

    @Before
    public void setStage() {
        setTheStage(Cast.whereEveryoneCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl"))));
    }


    @Dado("que se tiene un nuevo usuario con nombre aleatorio, contrasena aleatoria y correo electronico aleatorio")
    public void queSeTieneUnNuevoUsuarioConNombreAleatorioContrasenaAleatoriaYCorreoElectronicoAleatorio() {
        Faker faker = new Faker();
        nombre = faker.internet().domainName();
        contrasenia = faker.internet().password();
        correo = nombre+"@example.com";
        theActorCalled(nombre).entersTheScene();
        usuario2 = new Usuario2(nombre, contrasenia, correo);
    }

    @Cuando("se realiza una solicitud POST a {string} con los datos del nuevo usuario")
    public void seRealizaUnaSolicitudPOSTAConLosDatosDelNuevoUsuario(String url) {
        theActorInTheSpotlight().attemptsTo(Post.to(url).with(request -> request.body(usuario2)));
    }

    @Entonces("la respuesta debe tener un codigo de estado 200 de salida")
    public void laRespuestaDebeTenerUnCodigoDeEstadoDeSalida() {
        theActorInTheSpotlight().should(seeThatResponse(
                "el estatus es 200", response -> response.statusCode(200)));
    }

    @Y("la respuesta debe incluir un mensaje de exito {string} de la prueba")
    public void laRespuestaDebeIncluirUnMensajeDeExito(String mensaje) {
        theActorInTheSpotlight().should(seeThatResponse(
                "Verifica el mensaje en la respuesta",
                response -> response.body(containsString(mensaje))));
        System.out.println(mensaje);
    }

}

