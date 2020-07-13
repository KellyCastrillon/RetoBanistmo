package com.banistmo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.banistmo.userinterfaces.Tarifario.PDF;
import static com.banistmo.userinterfaces.Tarifario.TARIFARIO;

public class IngresoAlTarifario implements Task {

    private String tarifasCuentasDeposito;

    public IngresoAlTarifario(String tarifasCuentasDeposito) {
        this.tarifasCuentasDeposito = tarifasCuentasDeposito;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(TARIFARIO),
                Click.on(TARIFARIO),
                Click.on(PDF.of(tarifasCuentasDeposito))
        );

    }

    public static IngresoAlTarifario desdeElPortalPersonasBanistmo(String tarifasCuentasDeposito) {
        return Tasks.instrumented(IngresoAlTarifario.class, tarifasCuentasDeposito);
    }
}
