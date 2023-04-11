import org.testng.annotations.Test;

public class Testcases extends Steps{
	
	@Test
	public void Test1()
	{

		
		//Navigate to the home page
		Steps.navigateToHomepage();
		//Assert that both the email address and password inputs are present as well as the login button
		Steps.verifyEmailFeild();
		Steps.verifyPasswordFeild();
		Steps.verifySignIn();
		Steps.EnterUserNamePassword();
		//Assert that both the email address and password inputs are present as well as the login button
		
	}
	
	@Test
	public void Test2()
	{
		Steps.navigateToHomepage();
		Steps.ListSize();
		Steps.SecondItemValue();
		Steps.SecondItemBadge();
	}
	
	@Test
	public void Test3()
	{
		Steps.navigateToHomepage();
		Steps.OptionSelectdefault();
		Steps.OptionSelect();

	}
	
	@Test
	public void Test4()
	{
		Steps.navigateToHomepage();
		Steps.Button4();
	

	}
	
	@Test
	public void Test5()
	{
		Steps.navigateToHomepage();
		Steps.Buttonenabledisable();

	}
	
	@Test
	public void Test6()
	{
		Steps.navigateToHomepage();
		String cellvalue=Steps.Tablevalues(3,3);
		Steps.TablevalueAssert(cellvalue);


	}
}


