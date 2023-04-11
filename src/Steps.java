import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class Steps {
	
	static String username="jobiscyriac@gmail.com";
	static String password="password123";
	static WebDriver driver;
	
	@BeforeTest
	public void basemethod(){
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromedriver","F:/Jobis/Selenium/chromedriver_win32.zip/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/nimis/Downloads/QE-index.html#");	
	}
	
	//Navigate to Home Page
	public static void navigateToHomepage() {
		driver.findElement(By.xpath("//a[text()='Home ']")).click();
	}
	
	//Test1
	//Verify email field
	public static void verifyEmailFeild() {
		boolean emailadr = driver.findElement(By.xpath("//input[@id='inputEmail']")).isDisplayed();
		Assert.assertTrue(emailadr, "Field value is wrong/not displayed");
		System.out.println("Test 1,Step 2: Emailaddress field is displayed: "+emailadr);
	}
	//Verify password field
	public static void verifyPasswordFeild() {
		boolean passwd = driver.findElement(By.xpath("//input[@id='inputPassword']")).isDisplayed();
		Assert.assertTrue(passwd, "Field value is wrong/not displayed");
		System.out.println("Password field is displayed: "+passwd);
	}
	//Verify Sign in field
	public static void verifySignIn() {
	boolean Signin = driver.findElement(By.xpath("//button[text()='Sign in']")).isDisplayed();
	Assert.assertTrue(Signin, "Field value is wrong/not displayed");
	System.out.println("Sign in field is displayed: "+Signin);
	
    }
	
	//Enter in an email address and password combination into the respective fields
	public static void EnterUserNamePassword() {
	driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(password);
	System.out.println("Username and password has been entered");
	
    }
	
	
	
	//Test2
	//In the test 2 div, assert that there are three values in the listgroup
	public static void ListSize() { 
		List<WebElement> allElements  = driver.findElements(By.xpath("//li[@class='list-group-item justify-content-between']"));
		int TotalItem=allElements.size();
		Assert.assertEquals(TotalItem,3);
		System.out.println("Test 2,Step 2: Total elements displayed are "+TotalItem);
	}

	//Assert that the second list item's value is set to "List Item 2"
	public static void SecondItemValue()
	{
		List<WebElement> allElements  = driver.findElements(By.xpath("//li[@class='list-group-item justify-content-between']"));

		WebElement seconditem=allElements.get(1);
		String item=seconditem.getText();
		String str = item.substring(0, item.length() - 1);
		//StringBuffer sb= new StringBuffer(item); 
		//sb.deleteCharAt(sb.length()-1);  
		//String expectedvalue="List Item 2 ";
		Assert.assertEquals(str,"List Item 2 ");
		System.out.println("Test 2,Step 3:Second items value is"+ str);
	}
	
	//Assert that the second list item's badge value is 6"
	public static void SecondItemBadge()
	{
		List<WebElement> allElements  = driver.findElements(By.xpath("//li[@class='list-group-item justify-content-between']"));
		WebElement seconditem=allElements.get(1);
		String item=seconditem.getText();
		String Str2 = item.substring((item.length()-1));
		//StringBuffer sb= new StringBuffer(item); 
		//sb.deleteCharAt(sb.length()-1);  
		//String expectedvalue="List Item 2 
		//Assert.assertEquals(Str2,"List Item 2 ");
		System.out.println("Test 2,Step 4:Second items value is"+Str2);
	}
	
	//Test3
	//In the test 3 div, assert that "Option 1" is the default selected value
	public static void OptionSelectdefault()
	{
	String option=driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).getText();
	Assert.assertEquals(option,"Option 1");
	System.out.println("Test 3,Step 2: Default selected value is "+ option);
	}
	
	//Select "Option 3" from the select list
	public static void OptionSelect()
	{
	driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Option 3']")));
	//driver.findElement(By.xpath("//a[text()='Option 3']")).click();
	driver.findElement(By.xpath("//a[text()='Option 3']")).click();
	String s=driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).getText();
	System.out.println("Test 3,Step 3:Selected value is "+s);
	}
	
	//Test4
	//In the test 4 div, assert that the first button is enabled and that the second button is disabled
	public static void Button4()
	{
		boolean firstbutton=driver.findElement(By.xpath("//button[text()='Button' and @class='btn btn-lg btn-primary']")).isEnabled();
		Assert.assertTrue(firstbutton, "First Button is not enabled");
		System.out.println("Test 4,Step 2:First Button is enabled:"+firstbutton);
		boolean secondbutton=driver.findElement(By.xpath("//button[text()='Button' and @class='btn btn-lg btn-secondary']")).isEnabled();
		//Assert.assertTrue(secondbutton, "First Button is disabled");
		Assert.assertFalse(secondbutton, "Second Button is not disabled");
		System.out.println("Second Button is enabled:"+secondbutton);
	
	}
	
	//Test5
	//In the test 5 div, wait for a button to be displayed (note: the delay is random) and then click it
	//Once you've clicked the button, assert that a success message is displayed
	//Assert that the button is now disabled
	public static void Buttonenabledisable()
	{
		//String buton="//button[@id='test5-button']";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='test5-button']"))).click();
		
		String alert=driver.findElement(By.xpath("//div[@id='test5-alert']")).getText();
		Assert.assertEquals(alert,"You clicked a button!");
		System.out.println("Test 5,Step3: Button click success mesaage is displayed as: "+alert);
		boolean butondisabled=driver.findElement(By.xpath("//button[@id='test5-button']")).isEnabled();
		//Assert.assertTrue(secondbutton, "First Button is disabled");
		Assert.assertFalse(butondisabled, "Second Button is disabled");

	}
	
	//Test6
	//Write a method that allows you to find the value of any cell on the grid
	//Use the method to find the value of the cell at coordinates 2, 2 (staring at 0 in the top left corner)
	public static String Tablevalues(int i,int j)
	{
		 // identify table
        WebElement t = driver.findElement(By.xpath("//tbody//tr["+i+"]//td["+j+"]"));
        String cellvalue= t.getText();
        return cellvalue;     
	
	}
	
	//Assert that the value of the cell is "Ventosanzap"
	public static void TablevalueAssert(String cellvalue)
	{
      Assert.assertEquals(cellvalue, "Ventosanzap");
      System.out.println("Test 6,Step3: value of the cell at coordinates 2,2 is displayed as: "+cellvalue);
	
	}
	
	 
	}





