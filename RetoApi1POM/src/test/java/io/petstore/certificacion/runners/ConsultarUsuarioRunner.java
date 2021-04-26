package io.petstore.certificacion.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@case2",
        features = "src/test/resources/io.petstore.certificacion.features/gestion_usuario.feature",
        glue = "io.petstore.certificacion.stepsdefinitions",
        snippets = SnippetType.CAMELCASE)
public class ConsultarUsuarioRunner {
}
