package pkg;

import java.io.IOException;

public class HomePageModule extends TestCase {

	public static  void home() throws IOException{
		
		Update_Report("Pass", "Launch the App","Amazon.com is Launched" );
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();

	}
}
