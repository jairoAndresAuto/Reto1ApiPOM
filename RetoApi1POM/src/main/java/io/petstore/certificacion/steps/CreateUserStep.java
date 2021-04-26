package io.petstore.certificacion.steps;

import io.petstore.certificacion.modelos.ModeloUsuario;
import io.petstore.certificacion.utils.InternetConnection;
import io.petstore.certificacion.utils.LeerFichero;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.*;


public class CreateUserStep {


    private ModeloUsuario modeloUsuario;
    private Response response;
    private LeerFichero leerFichero=new LeerFichero();

    @Step
    public void verificarInternet(){
        InternetConnection internetConnection=new InternetConnection();
        internetConnection.checkInternetConnection();
    }

    @Step
    public void postUser() throws Exception{

        List<String> data=new LinkedList<>();
        data= leerFichero.extraerDatosCrear();
        modeloUsuario =new ModeloUsuario(data);


        response = SerenityRest.given()
                .contentType("application/json")
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/user").content(modeloUsuario.llenatJson()).log().body()
                .when().post();
    }

    @Step
    public void vefiricarCreacionUsuario(String statusCode){
        String validarStatus=response.getBody().jsonPath().getString("code");
        Assert.assertThat(statusCode, Matchers.is(validarStatus));
    }
}
