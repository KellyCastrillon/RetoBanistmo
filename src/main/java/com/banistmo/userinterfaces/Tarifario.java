package com.banistmo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.banistmo.com/wps/portal/banistmo/personas/")
public class Tarifario extends PageObject {

    public static final Target TARIFARIO = Target.the("IngresoAlTarifario").locatedBy("//a[text()='Tarifario']");
    public static final Target PDF = Target.the("PDF").locatedBy("//*[contains(text(),'{0}')]//following::td[@data-th='Tipo']");
    public static final Target VISUALIZACION_DE_PDF = Target.the("PDF").locatedBy("//img[@src='/wps/wcm/connect/b5812573-aa98-42f4-8ee1-f2a4bd15e467/pdf-icon.png?MOD=AJPERES&CACHEID=ROOTWORKSPACE-b5812573-aa98-42f4-8ee1-f2a4bd15e467-m1cIl8g']");
}
