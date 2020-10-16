package com.PageObject.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Funciones.Elementos;

//Heredo de la clase Elementos para llamar a los metodos necesarios
public class PantallaHomeFravega extends Elementos {	
	
	WebDriver driver;
	
	//Localizador que ingresa la palabra "Heladera" en el input (se usa un cssSelector porque tiene un combo)
    By locaIngresoPalabra = By.cssSelector("input[class='InputBar__SearchInput-t6v2m1-1 iJaFAt']");
    
    //Localizador que hace click en la lupita(se usa un xpath porque no tiene id probar con un searchbox)
	By locaBtnBusqueda = By.xpath("//button[@class='InputBar__SearchButton-t6v2m1-2 jRChuZ']");
	
	//Declaro constructor de la clase
	public PantallaHomeFravega(WebDriver driver) {
		super(driver);
	}
	
	//metodo que realiza la busqueda, llamo de mi clase heredada "Elementos"  
	//al metodo de Sendkeys y el que hace clic en la busqueda
	public void ingresarProductoABuscar() throws Exception {
		enviopalabraheladera("Heladera",locaIngresoPalabra);
		click(locaBtnBusqueda);		
	}
	
	
}
