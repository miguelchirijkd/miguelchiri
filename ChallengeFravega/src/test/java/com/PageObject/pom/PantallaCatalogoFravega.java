package com.PageObject.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Funciones.Elementos;

public class PantallaCatalogoFravega extends Elementos{
		
	WebDriver driver;
	
	//Localizador que indica que estoy en la segunda pantalla
    By locaSegundaPantalla = By.xpath("//h1[@name=\'categoryTitle\']");
	
    //Localizador que hace clic en la izquierda Heladeras(79)
    By locaClickHeladeras = By.xpath("//ul/li[1]//h4[contains(text(),'Heladeras')]");
    
    //Declaro el constructor
    public PantallaCatalogoFravega(WebDriver driver) {
		super(driver);
    }
        
    //Metodo que valida que entró a la segunda pantalla	
	public void PageCatalogoAbierta() throws Exception {
		if (getText(locaSegundaPantalla).equals("Heladera")) {
			System.out.println("Se ingreso a la página Heladeras correctamente");
			click(locaClickHeladeras);			
		} else {
			System.out.println("No se pudo ingresar a la pagina Heladeras");
		}
	}
}
