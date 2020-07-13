package stepdefinitions;

import com.banistmo.tasks.IngresoAlTarifario;
import com.banistmo.userinterfaces.Tarifario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.banistmo.userinterfaces.Tarifario.VISUALIZACION_DE_PDF;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class PortalBanistmo {

    private Tarifario paginaPrincipal;
    private String archivoPDF = "Tarifas de Depósitos";

    @Before
    public void configuracionInicial() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^el usuario ingresa a el portal de Personas Banistmo$")
    public void elUsuarioIngresaAElPortalDePersonasBanistmo() {
        theActorCalled("actor").attemptsTo(
                Open.browserOn(paginaPrincipal));
    }

    @When("^el usuario descarga el archivo PDF de (.*)$")
    public void elUsuarioDescargaElArchivoPDFDeTarifasDeCuentasDeDepsito(String tarifasCuentasDeposito) throws Throwable {
        theActorInTheSpotlight().attemptsTo(
                IngresoAlTarifario.desdeElPortalPersonasBanistmo(tarifasCuentasDeposito),
                Switch.toWindow("S56_ActualizacionTarifarioDepositos_Dic2019"));
    }

    @Then("^visualiza el archivo de las tarifas de Cuentas de Depósito$")
    public void visualizaElArchivoDeLasTarifasDeCuentasDeDepsito() throws Throwable {
        theActorInTheSpotlight().should(seeThat(the(VISUALIZACION_DE_PDF), containsText(archivoPDF)));
    }
}
