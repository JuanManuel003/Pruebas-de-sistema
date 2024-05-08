package co.com.uniquindio.edu.pruebas.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/agregarUsuario.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "co.com.uniquindio.edu.pruebas.stepdefinitions")
public class AgregarUsuario {
}