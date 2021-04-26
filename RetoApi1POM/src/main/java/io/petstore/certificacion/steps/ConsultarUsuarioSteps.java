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

public class ConsultarUsuarioSteps {

    private ModeloUsuario modeloUsuario;
    private Response response;
    private LeerFichero leerFichero=new LeerFichero();

    @Step
    public void getUserByUserName()throws Exception {

        List<String> data=new LinkedList<>();
        data= leerFichero.extraerDatosCrear();
        modeloUsuario =new ModeloUsuario(data);

        response = SerenityRest.given()
                .contentType("application/json")
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/user/"+modeloUsuario.llenatJson().get("username")).log()
                .all().get();
    }


    @Step
    public void validateDataResponseNombre(){
        String firstName=response.body().jsonPath().get("firstName");
        Assert.assertThat(modeloUsuario.llenatJson().get("firstName"), Matchers.is(firstName));

    }

    @Step
    public void validateDataResponseApellido(){
        String lastName=response.body().jsonPath().get("lastName");
        Assert.assertThat(modeloUsuario.llenatJson().get("lastName"), Matchers.is(lastName));

    }

    @Step
    public void validateDataResponseEmail(){
        String email=response.body().jsonPath().get("email");
        Assert.assertThat(modeloUsuario.llenatJson().get("email"), Matchers.is(email));
    }



}
