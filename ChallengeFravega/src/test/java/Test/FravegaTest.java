package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.PageObject.pom.PantallaCatalogoFravega;
import com.PageObject.pom.PantallaFiltro;
import com.PageObject.pom.PantallaHomeFravega;


public class FravegaTest {

	WebDriver driver;
	
	//Esta etiqueta va dar comienzo al llamado del chromedriver
	@BeforeMethod
	public void ingresoaPagina() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.fravega.com/");
	}
	
	//Esta etiqueta realiza el test,osea ejecuta mi caso de prueba
	@Test
	public void FravegaTestChallenge() throws Exception {
		//Da tiempo para abrir el navegador
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//creo objetos para  llamar las pantallas
		PantallaHomeFravega pageHome = new PantallaHomeFravega(driver);
		PantallaCatalogoFravega pageCatalogo = new PantallaCatalogoFravega(driver); 
		PantallaFiltro pagefiltro = new PantallaFiltro (driver);
		
		try {
			//Llamo a los metodos
			
			pageHome.ingresarProductoABuscar();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			pageCatalogo.PageCatalogoAbierta();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			pagefiltro.ValidarSamsungEngrilla();
			pagefiltro.CantidadHeladerasSamsung(0);
			pagefiltro.ValidarPalabraSamsunglist(0);
			pagefiltro.ValidarBreadcrumb();
			
			
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception(e);
		}
	}
	
	//Aca digo que se cierre el navegador
	@AfterMethod
	public void finTest() {
		//driver.close();
	}
}
