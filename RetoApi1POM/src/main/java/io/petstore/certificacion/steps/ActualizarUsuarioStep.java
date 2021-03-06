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

public class ActualizarUsuarioStep {

    private ModeloUsuario modeloUsuario;
    private Response response;
    private LeerFichero leerFichero = new LeerFichero();
    private List<String> data = new LinkedList<>();

    @Step
    public void UpdateUserByUserName() throws Exception {

        data = leerFichero.extraerDatosActualizar();
        modeloUsuario = new ModeloUsuario(data);


        response = SerenityRest.given()
                .contentType("application/json")
                .baseUri(URI_PETSTORE)
                .basePath(PATH_USER + modeloUsuario.llenatJson().get("username")).content(modeloUsuario.llenatJson())
                .when().log().all().put();
    }

    @Step
    public void validateUpdateResponseNombre() throws Exception {

        data = leerFichero.extraerDatosActualizar();
        modeloUsuario = new ModeloUsuario(data);

        response = SerenityRest.given()
                .contentType("application/json")
                .baseUri(URI_PETSTORE)
                .basePath(PATH_USER + modeloUsuario.llenatJson().get("username")).log()
                .all().get();

        String firstName = response.body().jsonPath().get("firstName");
        Assert.assertThat(modeloUsuario.llenatJson().get("firstName"), Matchers.is(firstName));
    }

}
