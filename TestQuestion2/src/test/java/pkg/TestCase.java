package pkg;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestCase extends ReusableMethod{

	public static WebDriver driver;
	public static void launchTheAmazonApplication() throws IOException {
		// TODO Auto-generated method stub

		startReport("Launch The Amazon Application", "C:/Fredrick/Se_Training/AmazonReport/");
		

		driver = new FirefoxDriver();
		HomePageModule.home();;
		
		bw.close();
		
	}
	
	
	
	public static void verifyDropDownOptionafterIphoneisTypedinSearch() throws IOException {
		

		startReport("Verify Drop Down Option after Iphone  is Typedin Search", "C:/Fredrick/Se_Training/AmazonReport/");
		
		String exceptedTextMsg="iphone 6s case in All Departments";
		String exceptedTextMsg1="iphone 6s case in Electronics";
		String exceptedTextMsg2="iphone 6s case in Cell Phones & Accessories";
		
		
		
		driver = new FirefoxDriver();
		HomePageModule.home();;
		
		WebElement searchBox = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
		enterText(searchBox, "Iphone", "Search text box");
		
		WebElement allDepartments = driver.findElement(By.xpath(".//*[@id='issDiv0']"));
		validateText(allDepartments, exceptedTextMsg, "1st Drop Down Search Engine Display");
		
		WebElement inElectornics = driver.findElement(By.xpath(".//*[@id='issDiv1']"));
		validateText(inElectornics, exceptedTextMsg1, "2nd  Drop Down Search Engine Display");
		
		WebElement accessories = driver.findElement(By.xpath(".//*[@id='issDiv2']"));
		validateText(accessories, exceptedTextMsg2, "3rd Drop DownSearch Engine  Display");
		
		bw.close();
	}
	
	
	public static void clickonSearchButtonafterIphoneIsEntered() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		startReport("Click on Search Button after Iphone  is entered", "C:/Fredrick/Se_Training/AmazonReport/");
		
		String exceptedTextMsg="\"Iphone\"";
				
		
		driver = new FirefoxDriver();
		HomePageModule.home();
		
		WebElement searchBox = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
		enterText(searchBox, "Iphone", "Search text box");
		
		WebElement search = driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input"));
		mouseOver(driver, search, "Mouse Over", "Search button");
		clickElement(search, "Search Button");
		
		Thread.sleep(5000);
		
		WebElement iphoneResultPage = driver.findElement(By.xpath(".//*[@id='bcKwText']/span"));
		validateText(iphoneResultPage, exceptedTextMsg, "Iphone Result page");
		
		bw.close();
	}


	public static void verifyShowresultsForColumnontheleftCellPhonesAndAccessoriesHeader() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		startReport("Verify Show results for Column  on the left Cell Phones & Accessories Header", "C:/Fredrick/Se_Training/AmazonReport/");
		
		String exceptedTextMsg="Cell Phones";
		String exceptedTextMsg1="Unlocked Cell Phones";
		String exceptedTextMsg2="Cell Phones & Accessories";
		String exceptedTextMsg3="Cases, Holsters & Clips";
				
		
		Update_Report("Pass", "Launch the App","Amazon.com is Launched" );
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/s//www.amazon.com/s/ref=sr_ex_n_0?rh=i%3Aaps%2Ck%3Aiphone&keywords=iphone&ie=UTF8&qid=1468617699&ajr=0");
		driver.manage().window().maximize();
		
		WebElement cellPhones =driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li/ul[1]/li[1]/a/span"));	
		mouseOver(driver, cellPhones, "Mouse Over", "Cell phones");
		clickElement(cellPhones, "Cell phones");

		Thread.sleep(3000);
		
		WebElement cellPhonesPage =driver.findElement(By.xpath(".//*[@id='s-result-count']/span/a[2]"));
		validateText(cellPhonesPage, exceptedTextMsg, "Cell phones result page");

		
		WebElement unlockedPhones = driver.findElement(By.xpath(".//*[@id='ref_2335753011']/li[4]/a/span[1]"));
		mouseOver(driver, unlockedPhones, "Mouse Over", "Unlocked phones");
		clickElement(unlockedPhones, "Unlocked phones");
		
		Thread.sleep(5000);
		
		WebElement unlockedPage =driver.findElement(By.xpath(".//*[@id='s-result-count']/span/a[3]"));
		validateText(unlockedPage, exceptedTextMsg1, "Unlocked phone result page");
		
		
		
		WebElement accessories = driver.findElement(By.xpath(".//*[@id='ref_2335753011']/li[2]/a/span[2]"));
		mouseOver(driver, accessories, "Mouse Over", "Accessories");
		clickElement(accessories, "Accessories");
		
		Thread.sleep(5000);
		
		WebElement accessoriesPage =driver.findElement(By.xpath(".//*[@id='s-result-count']/span/a"));
		validateText(accessoriesPage, exceptedTextMsg2, "Accessories Page");
		
		
		WebElement cases =driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[5]/a/span[1]"));
		mouseOver(driver, cases, "Mouse Over", "Cases and Covers");
		clickElement(cases, "Cases and Covers");

		Thread.sleep(5000);
		
		WebElement casesPage = driver.findElement(By.xpath(".//*[@id='s-result-count']/span/a[2]"));
		validateText(casesPage, exceptedTextMsg3, "Cases and Covers result page");
		
		bw.close();
	}


	public static void computersAndAccessoriesHeader() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		startReport("Computers & Accessories Header", "C:/Fredrick/Se_Training/AmazonReport/");
		
		String exceptedTextMsg="Computer Components";
				
		
		Update_Report("Pass", "Launch the App","Amazon.com is Launched" );
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/s//www.amazon.com/s/ref=sr_ex_n_0?rh=i%3Aaps%2Ck%3Aiphone&keywords=iphone&ie=UTF8&qid=1468617699&ajr=0");
		driver.manage().window().maximize();
		
		WebElement allDepts =driver.findElement(By.xpath(".//*[@id='seeAllDepartmentClosed1']/li/span/a/span[2]"));
		clickElement(allDepts, "See All Depatrments");
		
		Thread.sleep(5000);
		
		WebElement components =driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[1]/ul/li/a"));
		mouseOver(driver, components, "Mouse Over", "Computer components");
		validateText(components, exceptedTextMsg, "Computer Components");
		
		
		
		bw.close();
	}


	
	public static void electronicsHeader() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		startReport("Electronics Header", "C:/Fredrick/Se_Training/AmazonReport/");
		
		String exceptedTextMsg="See All 35 Departments";
		String exceptedTextMsg1 ="Electronics";
		String exceptedTextMsg2 ="Smart Watches";
		String exceptedTextMsg3 ="Portable Bluetooth Speakers";
				
		
		Update_Report("Pass", "Launch the App","Amazon.com is Launched" );
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/s//www.amazon.com/s/ref=sr_ex_n_0?rh=i%3Aaps%2Ck%3Aiphone&keywords=iphone&ie=UTF8&qid=1468617699&ajr=0");
		driver.manage().window().maximize();
		
		WebElement allDepts =driver.findElement(By.xpath(".//*[@id='seeAllDepartmentClosed1']/li/span/a/span[2]"));
		mouseOver(driver, allDepts, "Mouse Over", "See All 35 Departments");
		validateText(allDepts, exceptedTextMsg, "See All 35 Departments");
		clickElement(allDepts, "See All 35 Departments");
		
		
		WebElement components =driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[2]/a/span[1]"));
		mouseOver(driver, components, "Mouse Over", "Electronics");
		validateText(components, exceptedTextMsg1, "Electronics");
		
		
		WebElement smartWatches =driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[2]/ul/li[1]/a/span"));
		mouseOver(driver, smartWatches, "Mouse Over","Smart Watches" );
		validateText(smartWatches, exceptedTextMsg2, "Smart Watches");
		
		WebElement speakers =driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[2]/ul/li[2]/a/span"));
		mouseOver(driver, speakers, "Mouse Over","Portable Bluetooth Speakers" );
		validateText(speakers, exceptedTextMsg3, "Portable Bluetooth Speakers");

		
		bw.close();
	}
	
	public static void checkMainTab() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		startReport("Check Main Tab", "C:/Fredrick/Se_Training/AmazonReport/");


		
		driver = new FirefoxDriver();
		HomePageModule.home();
		
		WebElement dept = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
		mouseOver(driver, dept, "Departments", "Departments");
		

		WebElement yourAmazon =driver.findElement(By.xpath(".//*[@id='nav-your-amazon']"));
		mouseOver(driver, yourAmazon, "YourAmazon.com", "YourAmazon.com");
		
		WebElement todaysDeals =driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[2]"));
		mouseOver(driver ,todaysDeals ,"Today's Deals", "Today's Deals");
		
		
		WebElement giftCards = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[3]"));
		mouseOver(driver, giftCards, "Gift Cards & Registry", "Gift Cards & Registry");

		WebElement sell =driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[4]"));
		mouseOver(driver, sell, "Sell", "Sell");
		
		WebElement help = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[5]"));
		mouseOver(driver, help, "Help", "Help");
		
		
		WebElement signIn = driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[1]"));
		mouseOver(driver, signIn, "Hello Sign in", "Hello Sign in");
		

		WebElement  tryPrime = driver.findElement(By.xpath(".//*[@id='nav-link-prime']/span[2]"));
		mouseOver(driver, tryPrime, "Try Prime", "Try Prime");
		
		WebElement lists =driver.findElement(By.xpath(".//*[@id='nav-link-wishlist']/span[2]"));
		mouseOver(driver, lists, "Lists", "Lists");
		
		WebElement cart = driver.findElement(By.xpath(".//*[@id='nav-cart']"));
		mouseOver(driver, cart, "Cart", "Cart");
		
		bw.close();
	}
	
	
	
	public static void validateDepartmentDropDownList() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		startReport("Validate Department DropDown List", "C:/Fredrick/Se_Training/AmazonReport/");

		
		

		
		driver = new FirefoxDriver();
		HomePageModule.home();

		WebElement dept = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
		mouseOver(driver, dept, "Departments", "Departments");
	
		
		List<WebElement> deptList =driver.findElements(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]"));
		userMenuList(deptList, "Departments List");
		
		
		
		bw.close();
	}


	
	public static void validateAccountsDropDownList() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		startReport("Validate Accounts DropDown List", "C:/Fredrick/Se_Training/AmazonReport/");

		
		

		
		driver = new FirefoxDriver();
		HomePageModule.home();
		
		WebElement signIn = driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[1]"));
		mouseOver(driver, signIn, "Hello Sign in", "Hello Sign in");

		
		
		List<WebElement> accList =driver.findElements(By.xpath(".//*[@id='nav-flyout-yourAccount']"));
		userMenuList(accList, "Your Accounts List");
		
		
		
		bw.close();
	}

	
	
	public static void validateListsDropDownList() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		startReport("Validate Lists DropDown List", "C:/Fredrick/Se_Training/AmazonReport/");

		
		

		
		driver = new FirefoxDriver();
		HomePageModule.home();;

		WebElement lists =driver.findElement(By.xpath(".//*[@id='nav-link-wishlist']/span[2]"));
		mouseOver(driver, lists, "Lists", "Lists");

		
		
		List<WebElement> list =driver.findElements(By.xpath(".//*[@id='nav-flyout-wishlist']"));
		userMenuList(list, "Lists");
		
		
		
		bw.close();
	}


	public static void CheckList() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		startReport("CheckList", "C:/Fredrick/Se_Training/AmazonReport/");
		
						
		
		Update_Report("Pass", "Launch the App","Amazon.com is Launched" );
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/s//www.amazon.com/s/ref=sr_ex_n_0?rh=i%3Aaps%2Ck%3Aiphone&keywords=iphone&ie=UTF8&qid=1468617699&ajr=0");
		driver.manage().window().maximize();
		
		
		WebElement free= driver.findElement(By.id("ref_2661623011"));
		mouseCheckList(driver, free, "CheckBox", " Free Shipping CheckBox");

		
		WebElement list1= driver.findElement(By.id("ref_2528832011"));
		mouseCheckList(driver, list1, "CheckBox", " Brand CheckBox");
		
		WebElement list2= driver.findElement(By.id("ref_7805160011"));
		mouseCheckList(driver, list2, "CheckBox", "Cell Phone Internal Memory");
		
		
		WebElement list3= driver.findElement(By.id("ref_6215726011"));
		mouseCheckList(driver,list3, "CheckBox", "Display size");

		
		WebElement list4= driver.findElement(By.className("forExpando"));
		mouseCheckList(driver,list4, "CheckBox", "Accessories Compability");
		
		
		WebElement list5= driver.findElement(By.id("ref_2488708011"));
		mouseCheckList(driver,list5, "CheckBox", "Cell Phone Compability");

				
		
		bw.close();
	}

	
}
