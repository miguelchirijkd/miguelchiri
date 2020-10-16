package Funciones;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elementos {
	
	//Localizador que hace clic en "Ver todas"
    By localinkVerTodas = By.linkText("Ver todas");
    
    //Localizador que hace clic en el botón "Aplicar"
    By localBtnAplicar = By.xpath("//div[@class='ant-modal-body']//button[@id='apply']");

    //Localizador que hace clic en el check de Samsung
    By localcheckSamsung = By.xpath("//div[@class=\"ant-modal-body\"]//label[@for='filterItemsamsung']");
    
    //Localizador que hace clic en la izquierda Heladeras(79)
    By locaClickHeladeras = By.xpath("//ul/li[1]//h4[contains(text(),'Heladeras')]");
    
    //Localizador que hace click en la lupita(se usa un xpath porque no tiene id probar con un searchbox)
   	By locaBtnBusqueda = By.xpath("//button[@class='InputBar__SearchButton-t6v2m1-2 jRChuZ']");
   	
   	//Localizador que ingresa la palabra "Heladera" en el input (se usa un cssSelector porque tiene un combo)
    By locaIngresoPalabra = By.cssSelector("input[class='InputBar__SearchInput-t6v2m1-1 iJaFAt']");
    
    //Creo mi objeto WebDriver
    private WebDriver driv;
	
    //Constructor de la clase
	public Elementos(WebDriver driver) {
		this.driv = driver;
	}
		
	//Método que hace click en acciones(botones,otras opciones clicleables)
	public void click(By elemento) {
		driv.findElement(elemento).click();
	}
		
	//Metodo que sirve para el envio de keywords
	public void enviopalabraheladera(String producto,By elemento){		
	     driv.findElement(elemento).sendKeys(producto);	    
	}
	
	//Método que valida textos
	public String getText(By elemento) {
		return driv.findElement(elemento).getText();
	}
	
	//Método que sirve paraa recorrer la lista
	public List<WebElement> listadeheladeras(By elemento){
		return driv.findElements(elemento);
	}

}//Fin class
