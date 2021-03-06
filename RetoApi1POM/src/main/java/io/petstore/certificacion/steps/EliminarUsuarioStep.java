package io.petstore.certificacion.steps;

import io.petstore.certificacion.modelos.ModeloUsuario;
import io.petstore.certificacion.utils.LeerFichero;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;

import static io.petstore.certificacion.utils.ConfirguracionAPI.PATH_USER;
import static io.petstore.certificacion.utils.ConfirguracionAPI.URI_PETSTORE;

public class EliminarUsuarioStep {

    private ModeloUsuario modeloUsuario;
    private Response response;
    private LeerFichero leerFichero = new LeerFichero();

    @Step
    public void deleteUserByUserName() throws Exception {

        List<String> data = new LinkedList<>();
        data = leerFichero.extraerDatosCrear();
        modeloUsuario = new ModeloUsuario(data);

        response = SerenityRest.given()
                .contentType("application/json")
                .baseUri(URI_PETSTORE)
                .basePath(PATH_USER + modeloUsuario.llenatJson().get("username"))
                .log().all().delete();
    }

    @Step
    public void validateNameUserEliminado() {
        String message = response.body().jsonPath().get("message");
        Assert.assertThat(modeloUsuario.llenatJson().get("username"), Matchers.is(message));
    }

}
