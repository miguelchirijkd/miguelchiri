package com.PageObject.pom;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Funciones.Elementos;

public class PantallaFiltro extends Elementos {
	
	WebDriver driver;
	
	//Localizador que hace clic en "Ver todas"
    By localinkVerTodas = By.linkText("Ver todas");
    
	//Localizador que hace clic en el check de Samsung
    By localcheckSamsung = By.xpath("//div[@class=\"ant-modal-body\"]//label[@for='filterItemsamsung']");
    
    //Localizador de cantidad de heladeras
    By localCantHeladeras = By.xpath("//ul[@name='itemsGrid']//li//h4");
    
    //Localizador que hace clic en el botón "Aplicar"
    By localBtnAplicar = By.xpath("//div[@class='ant-modal-body']//button[@id='apply']");
    
    //Xpath creado para despues ser validado en el Assert
    By locaContFront = By.xpath("//li[1]/span[text()]");
     
    //Xpath que va servir para verificar el breadcrumb de la pagina
    By locaBreadcrumb = By.xpath("//li/a[@name='breadcrumbItem']");
 
    
    //Constructor de la pagina
    public PantallaFiltro (WebDriver driver) {
		super(driver);
	}
    
  	//Metodo que valida que en la grilla de Checkbox exista el checkbox Samsung.
  	public void ValidarSamsungEngrilla() {	
  		click(localinkVerTodas);
  		try{
  			click(localcheckSamsung);
  			System.out.println(" ");
  			System.out.println("******************Hay Stock de heladeras para la marca Samsung(Check existente)**************************");
  			System.out.println(" ");  
  			click(localBtnAplicar);
  		}catch (Exception e){
    			System.out.println("No se encontró Stock para la marca Samsung");
  			System.exit(0);
  		}
  	}  	
  	
	//Metodo que retorna una lista para que despues pueda recorrerla en el metodo cantidadHeladerasSamsung
  	// y asi sacar el valor total de los elementos.
  	public List<WebElement> verificarcantidaddeheladeras(){
  		List<WebElement> heladeras = listadeheladeras(localCantHeladeras);
   	    return heladeras;
  	}
  	
  //Metodo que verifica que dentro de la lista exista las heladeras con la marca Samsung
  //Metodo más que nada sirve para verificar que correctamente haya devuelto la lista heladeras con la palabra Samsung
  	public int ValidarPalabraSamsunglist(int conthela) {
  		System.out.println(" ");
  		System.out.println("******************Validación de la palabra Samsung**************************");
  		System.out.println(" ");
  		//Recorro de nuevo la lista para que despues en el if se fije si los elementos coinciden con el texto "Samsung"
  		//verifico que desde la lista obtenida anterior las heladeras devueltas el titulo Samsung
  		for(WebElement palabra : verificarcantidaddeheladeras())
    			try{
    				conthela++;
    				if (palabra.getText().contains("Samsung")) {
    					System.out.println("La heladera"+" " +conthela+ " "+ "posee la marca Samsung");
    				} else {
    					System.out.println("No se encontró la marca Samsung en la heladera:"+" "+conthela);
    				}
    			}catch (Exception e){
    				break;
    			}
  	 	System.out.println(" ");
  		return conthela;		
    	}	 
  	
  	
  	//Metodo que devuelve los elementos y la cantidad de elementos que contiene la lista
  	//Recorro un for la lista de elementos y voy sumando cada vez que entra con un contador
  	public int CantidadHeladerasSamsung(int contador) {
  	//Recorro la lista de elementos para que cuente la cantidad de elementos que recorre el for	  		
  		for(WebElement elemento : verificarcantidaddeheladeras())
  			try{
  				contador ++; 
  				System.out.println(elemento.getText());
  			}catch (Exception e){
  				break;
  			}
  		//realizo un parseo del contador entero a String para despues guardarlo en una variable y aplicarlo en el Assert
  		String cantLista = Integer.toString(contador);
  		String cantResulFront = getText(locaContFront);
  		System.out.println(" ");
  		System.out.println("********Cantidad de heladeras que hay en front y cantidad devuelto por la lista*************");
  		System.out.println(" ");
  		System.out.println("Cantidad devuelto por la lista:"+" " +cantLista);
  		System.out.println("Cantidad que se visualiza en front:"+" " +cantResulFront);
  		//Comparo la cantidad de heladeras que hay en front con lo que devuelve la lista
  		assertEquals(cantLista,cantResulFront);  		  		
  	 	return contador;
  	} 
  	
  	  	 
	//Metodo que compara si existe el breadcrumb de la página
	public void ValidarBreadcrumb () throws Exception{
		String breadcrumbHelaFrezeer = getText(locaBreadcrumb);
		assertEquals(breadcrumbHelaFrezeer,"Heladeras, Freezers y Cavas");
		//Se asume que el breadcrumb de la pagina es "Heladeras, Freezers y Cavas" para que continue la validación
		//Aca se encuentra la validación delpunto 6 c)
		//assertEquals(breadcrumbHelaFrezeer,"Heladeras con Frezzer");
	}	 	
	
}//Fin de la clase