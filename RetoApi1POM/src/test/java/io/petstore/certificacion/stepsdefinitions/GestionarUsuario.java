package io.petstore.certificacion.stepsdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.petstore.certificacion.steps.ActualizarUsuarioStep;
import io.petstore.certificacion.steps.ConsultarUsuarioSteps;
import io.petstore.certificacion.steps.CreateUserStep;
import io.petstore.certificacion.steps.EliminarUsuarioStep;
import net.thucydides.core.annotations.Steps;

public class GestionarUsuario {

    @Steps
    CreateUserStep createUserStep;
    @Steps
    ConsultarUsuarioSteps consultarUsuario;
    @Steps
    ActualizarUsuarioStep actualizarUsuario;
    @Steps
    EliminarUsuarioStep eliminarUsuario;

    @Given("^the user verify internet connection$")
    public void theUserVerifyInternetConnection() {
        createUserStep.verificarInternet();
    }


    @When("^the user creates a new client$")
    public void theUserCreatesANewClient() throws Exception{
        createUserStep.postUser();
    }

    @Then("^verify status code (\\d+)$")
    public void verifyStatusCode(String statusCode) {
        createUserStep.vefiricarCreacionUsuario(statusCode);
    }

    /*-------------------------------------------------------------------*/

    @When("^the user by query username$")
    public void theUserByQueryUsername()throws Exception {
        consultarUsuario.getUserByUserName();
    }


    @Then("^verify nombre apellido y email$")
    public void verifyNombreApellidoYEmail() {
        consultarUsuario.validateDataResponseNombre();
        consultarUsuario.validateDataResponseApellido();
        consultarUsuario.validateDataResponseEmail();
    }

    /*-------------------------------------------------------------------*/

    @When("^the user queries by username and submit request with changes in name$")
    public void theUserQueriesByUsernameAndSubmitRequestWithChangesInName() throws Exception{
        actualizarUsuario.UpdateUserByUserName();
    }


    @Then("^verify uptade successfully$")
    public void verifyUptadeSuccessfully()throws Exception {
        actualizarUsuario.validateUpdateResponseNombre();
    }

    /*-------------------------------------------------------------------*/

    @When("^user enter username you want to delete$")
    public void userEnterUsernameYouWantToDelete()throws Exception {
        eliminarUsuario.deleteUserByUserName();
    }


    @Then("^verify delete successfully$")
    public void verifyDeleteSuccessfully() {
        eliminarUsuario.validateNameUserEliminado();
    }

}
