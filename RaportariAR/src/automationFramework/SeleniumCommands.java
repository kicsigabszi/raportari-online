package automationFramework;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 

public class SeleniumCommands {
	
	private static SeleniumCommands singleton; 
	private String exePath;
	private WebDriver driver;
	private Document document;
	
	public SeleniumCommands()
	{
		//Init ChromeDriver
		exePath = "../chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
	}
	
	public static SeleniumCommands getInstance()
	{
		if(singleton == null){
			singleton = new SeleniumCommands();
        }
        return singleton;
	}
	
	public void login() {
		
		driver.get("https://www.raportarionlinearr.ro/rap_to/login.php");
		//Username
		WebElement userInput = driver.findElement(By.name("user"));
		userInput.sendKeys("gabszi07");
		//Password
		WebElement pwdInput = driver.findElement(By.name("cheie"));
		pwdInput.sendKeys("8903e2dbe1f916676253d1aa204453c3844303e9");
		//Submit
		pwdInput.submit();		
	}
	
	public void openPassengerList()
	{
		//Open adauga pasageri screen
		driver.get("https://www.raportarionlinearr.ro/rap_to/pasageri.php");	
		document = Document.getInstance();
		//WebElement codFiscalInput = driver.findElement(By.name("cod_f"));
		//codFiscalInput.sendKeys(document.getCodFiscal());
		WebElement nrDocCtrInput = driver.findElement(By.name("nr_doc_ctr"));
		nrDocCtrInput.sendKeys(document.getNrDocControl());
		WebElement nrFoaieInput = driver.findElement(By.name("nr_foaie"));
		nrFoaieInput.sendKeys(document.getNrFoaie());
		WebElement nrCircInput = driver.findElement(By.name("nr_circ"));
		nrCircInput.sendKeys(document.getNrCirculatie());
		WebElement cautaDocBtn = driver.findElement(By.cssSelector("input[name='B1'][value='Cauta Document >>']"));
		cautaDocBtn.click();
	}
	
	public boolean incarcaPasager(ArrayList<Person> persons)
	{
		//Open adauga pasageri screen
		driver.get("https://www.raportarionlinearr.ro/rap_to/pasageri.php");	
		document = Document.getInstance();
		//WebElement codFiscalInput = driver.findElement(By.name("cod_f"));
		//codFiscalInput.sendKeys(document.getCodFiscal());
		WebElement nrDocCtrInput = driver.findElement(By.name("nr_doc_ctr"));
		nrDocCtrInput.sendKeys(document.getNrDocControl());
		WebElement nrFoaieInput = driver.findElement(By.name("nr_foaie"));
		nrFoaieInput.sendKeys(document.getNrFoaie());
		WebElement nrCircInput = driver.findElement(By.name("nr_circ"));
		nrCircInput.sendKeys(document.getNrCirculatie());
		WebElement cautaDocBtn = driver.findElement(By.cssSelector("input[name='B1'][value='Cauta Document >>']"));
		cautaDocBtn.click();
		
		String id = driver.findElement(By.name("id_to")).getAttribute("value");
		document.setId(id);
		
		//Init passenger uploader screen
		//Set the necessary input values
		driver.get("https://www.raportarionlinearr.ro/rap_to/pas_edit.php");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementsByName('id_to')[0].setAttribute('type', 'text');");
		driver.findElement(By.xpath("//input[@name='id_to']")).clear();
		driver.findElement(By.xpath("//input[@name='id_to']")).sendKeys(id);
		jse.executeScript("document.getElementsByName('nr_doc_ctr')[0].setAttribute('type', 'text');");
		driver.findElement(By.xpath("//input[@name='nr_doc_ctr']")).clear();
		driver.findElement(By.xpath("//input[@name='nr_doc_ctr']")).sendKeys(document.getNrDocControl());
		jse.executeScript("document.getElementsByName('nr_foaie')[0].setAttribute('type', 'text');");
		driver.findElement(By.xpath("//input[@name='nr_foaie']")).clear();
		driver.findElement(By.xpath("//input[@name='nr_foaie']")).sendKeys(document.getNrFoaie());
		jse.executeScript("document.getElementsByName('data_tran')[0].setAttribute('type', 'text');");
		driver.findElement(By.xpath("//input[@name='data_tran']")).clear();
		driver.findElement(By.xpath("//input[@name='data_tran']")).sendKeys(document.getDataTransport());
		
		//Upload passengers
		for(Person person : persons)
		{
			WebElement numePasagerInput = driver.findElement(By.name("nume_p"));
			numePasagerInput.clear();
			numePasagerInput.sendKeys(person.getName());
			WebElement salvareBtn = driver.findElement(By.cssSelector("input[name='stare'][value='Salveaza']"));
			salvareBtn.click();
		}
		
		return true;
	}
	
	public boolean saveDocumentControl(Map<String, String> inpMap)
	{
		driver.get("https://www.raportarionlinearr.ro/rap_to/reg_edit.php");
		//Tip Document Control
		WebElement tipDocInput = driver.findElement(By.name("tip_doc_ctr"));
		tipDocInput.sendKeys(inpMap.get("tip_doc_ctr"));
		//Numar Document Control
		WebElement nrDocInput = driver.findElement(By.name("nr_doc_ctr"));
		nrDocInput.sendKeys(inpMap.get("nr_doc_ctr"));
		//Numar Foaie
		WebElement nrFoaie = driver.findElement(By.name("nr_foaie"));
		nrFoaie.sendKeys(inpMap.get("nr_foaie"));
		//Numar Circ 1
		WebElement nrCirc1 = driver.findElement(By.name("nr_circ1"));
		nrCirc1.sendKeys(inpMap.get("nr_circ1"));
		//Numar Circ 2
		WebElement nrCirc2 = driver.findElement(By.name("nr_circ2"));
		nrCirc2.sendKeys(inpMap.get("nr_circ2"));
		//Numar Circ 3
		WebElement nrCirc3 = driver.findElement(By.name("nr_circ3"));
		nrCirc3.sendKeys(inpMap.get("nr_circ3"));
		//Locuri
		WebElement locuri = driver.findElement(By.name("locuri"));
		locuri.sendKeys(inpMap.get("locuri"));
		//CNP Sofer 1
		WebElement cnp1 = driver.findElement(By.name("cnp1"));
		cnp1.sendKeys(inpMap.get("cnp1"));
		//Nume Sofer 1
		WebElement nume1 = driver.findElement(By.name("nume1"));
		nume1.sendKeys(inpMap.get("nume1"));
		//CNP Sofer 2
		WebElement cnp2 = driver.findElement(By.name("cnp2"));
		cnp2.sendKeys(inpMap.get("cnp2"));
		//Nume Sofer 2
		WebElement nume2 = driver.findElement(By.name("nume2"));
		nume2.sendKeys(inpMap.get("nume2"));
		
		//Data Completarii
		/*WebElement data_c = driver.findElement(By.name("data_c"));
		data_c.sendKeys(inpMap.get("data_c"));*/
		
		//Data Transport
		WebElement dataTransport = driver.findElement(By.name("data_t"));
		dataTransport.clear();
		dataTransport.sendKeys(inpMap.get("data_t"));
		//Data End Transport
		WebElement dataEndTransport = driver.findElement(By.name("data_t2"));
		dataEndTransport.sendKeys(inpMap.get("data_t2"));
		//Loc Plecare
		WebElement locPlecare = driver.findElement(By.name("loc_p"));
		locPlecare.sendKeys(inpMap.get("loc_p"));
		//Loc Sosire
		WebElement locSosire = driver.findElement(By.name("loc_s"));
		locSosire.sendKeys(inpMap.get("loc_s"));
			
		//Save
		WebElement saveBtn = driver.findElement(By.cssSelector("input[name='stare'][value='Salveaza']"));
		saveBtn.click();
		
		WebElement checkIfSaved = driver.findElement(By.cssSelector("font[color='#000080']"));
		if(checkIfSaved.getText().contains("Datele AU FOST SALVATE") || checkIfSaved.getText().contains("Datele AU FOST UPDATATE"))
			return true;
		else
			return false;
		
	}

}
