
package pkg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;




public class ReusableMethod{
	//	static WebDriver driver;
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	@Test
	public void test() throws Exception {

		startReport("Decending order sort","C:/Fredrick/Se_Training/Report/");

		
				
		bw.close();


	}
	
	/*Name of the Method: writeExcel
	 * Brief Description: Write contents to XL sheet
	 * Arguments: dataTablePath --> path of the XL sheet, sheetName --> Name of the sheet,
	 * iRow --> Row number, icol --> Column number, xlData --> TExt value to be entered
	 * Created by: Tech Pirates
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 */
	
	public static void writeExcel(String dataTablePath, String sheetName, int iRow, int iCol, String xlData ) throws IOException{
		File xlFile = new File(dataTablePath);
		FileInputStream xlDoc = new FileInputStream(xlFile);
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
		HSSFSheet sheet = wb.getSheet(sheetName);
		HSSFRow  row = sheet.getRow(iRow);
		HSSFCell  cell = row.getCell(iCol);
		cell.setCellValue(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(xlData);
		

		if(exeEngine.resultFlag == 1){
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.RED().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
			
		}else{
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.GREEN().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
		}
		
		

		
		FileOutputStream fout = new FileOutputStream(dataTablePath);
		wb.write(fout);
		fout.flush();
		fout.close();

	}

	
	/*Name of the Method: mouseCheckList
	 * Brief Description: Write contents to XL sheet
	 * Arguments: WebDriver --> driver, WebElement object, textVal --> text to be entered,  objName --> Object name
	 * Created by: Tech Pirates
	 * Creation Date: July 16 2016
	 * Last Modified: July 16 2016
	 */

	public static void mouseCheckList(WebDriver driver, WebElement obj, String textvalue, String objName) throws IOException, InterruptedException{	
		List<WebElement> els = obj.findElements(By.tagName("img"));
		for ( WebElement el : els ) {
		    if ( !el.isSelected() ) {
		        Actions action = new Actions(driver);
		        action.moveToElement(el).build().perform();
		        Thread.sleep(1000);
		    
		    Update_Report("Pass", "mouseCheckList",  "Mouse Hover is moved to "+ objName+ " . ");
		    }else{
			Update_Report("Fail", "mouseCheckList", objName+ " field is not displayed please check your application");
		}
		
}
}
	
	
	
	/* Name of the method: mouseOver
	 * Brief description: move over to given object
	 * Arguments: WebDriver --> driver, WebElement object, textVal --> text to be entered,  objName --> Object name
	 * Created By: TechPirates
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 **/

	public static void mouseOver(WebDriver driver, WebElement obj, String textvalue, String objName) throws IOException{
		if(obj.isEnabled()){
			
			Actions action = new Actions(driver);
			action.moveToElement(obj).build().perform();
			Update_Report("Pass", "mouseOver",  "Mouse Hover is moved to "+ objName+ " . ");
		}else{
			Update_Report("Fail", "mouseOver", objName+ " field is not displayed please check your application");
		}
	}

	
	/*Name of the Method: readExcel
	 * Brief Description: Read contents from XL sheet
	 * Arguments: dataTablePath --> path of the XL sheet, sheetName --> Name of the sheet
	 * Created by: Tech Pirates
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 */
	
public static String[][] readExcel(String dtTablePath, String sheetName ) throws IOException{
		
		File xlFile = new File(dtTablePath);
		FileInputStream xlDoc = new FileInputStream(xlFile);
		HSSFWorkbook  wb = new HSSFWorkbook(xlDoc);
	    HSSFSheet sheet = wb.getSheet(sheetName);
		int iRowCount= sheet.getLastRowNum()+1;
		int iColumnCount= sheet.getRow(0).getLastCellNum();
		
		String[][] xlData = new String[iRowCount][iColumnCount];		
		for(int i=0; i<iRowCount; i++){
			for(int j=0; j<iColumnCount; j++){
		
				xlData[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
				
			}
			
		}
			return xlData;
		
	}

	
	/* Name of the method: dropDownListSelect
	 * Brief description: Select value from dropdown list
	 * Arguments: WebElement object, textVal --> text to be entered,  objName --> Object name
	 * Created By: TechPirates
	 * Creation Date: July 4 2016
	 * Last Modified: July 4 2016
	 **/

	public static void dropDownListSelect(WebElement obj, String textvalue, String objName) throws IOException{
		if(obj.isEnabled()){
			Select select = new Select(obj);
			select.selectByVisibleText(textvalue);
			Update_Report("Pass", "dropDownListSelect",  "In "+ objName+ " "+ textvalue +" value is selected");
		}else{
			Update_Report("Fail", "dropDownListSelect", objName+ " field is not displayed please check your application");
		}
	}

	
	

	/* Name of the method: userMenuList
	 * Brief description: Display text from menu
	 * Arguments: obj --> List<WebElement> object, objName --> Object name
	 * Created By: TechPirates
	 * Creation Date: July 4 2016
	 * Last Modified: July 4 2016
	 **/

	public static void userMenuList(List<WebElement> obj, String objName) throws IOException{
		if(obj.isEmpty()){
			Update_Report("Fail", "userMenuList", objName + " field is not displayed please check your application");

		}else{
			for(int i=0; i<obj.size(); i++){
				Update_Report("Pass", "userMenuList",objName+ " with " + obj.get(i).getText()+ " options  displayed in user menu" );
			}

		}
	}



	/* Name of method: selectUserMenuList
	 * Brief description: WebElement object, objName --> Object name
	 * Created By: TechPirates
	 * Creation Date: July 6 2016
	 * Last Modified: July 6 2016
	 */
	public static void selectUserMenuList(WebElement obj, String objName) throws IOException{
		if(obj.isDisplayed()){
			Select select = new Select(obj);
			List<WebElement> list = select.getOptions();
			for(WebElement ele: list)
			
			Update_Report("Pass", "selectUserMenuList",objName+ " with " + ele.getText()+" options  displayed in user menu" );

		}else{
			Update_Report("Fail", "selectUserMenuList", objName + " field is not displayed please check your application");

		}
		
	}

	
	
	
	/* Name of the method: compareUrl
	 * Brief description: Compares two URL's
	 * Arguments: url1 --> except first url, url2 --> except second url
	 * Created By: TechPirates
	 * Creation Date: July 1 2016
	 * Last Modified: July 1 2016
	 **/
		
	public static void compareUrl(String url1, String url2) throws IOException{
		if(url1.equals(url2)){
			Update_Report("Pass", "compareUrl",url2+ " actual url ");
		}else{
			Update_Report("Fail", "compareUrl", url1+ " excepted url did not match with actual url " + url2);
		}	
		
		
		}

	
	
	/* Name of the method: enterText
	 * Brief description: Enter value into text boxes
	 * Arguments: obj --> WebElement object, textVal --> text to be entered,  objName --> Object name
	 * Created By: TechPirates
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 **/
	
	public static void enterText(WebElement obj, String textVal, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.clear();
			obj.sendKeys(textVal);
			Update_Report("Pass", "enterText", textVal+ " is entered in "+objName+" field");
		}else{
			Update_Report("Fail", "enterText", objName+ " field is not displayed please check your application");
		}
	}
	
	
	
	/* Name of the method: clickElement
	 * Brief description: Click on WebElement
	 * Arguments: obj --> WebElement object, objName --> Object name
	 * Created By: TechPirates
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 **/
	public static void clickElement(WebElement obj, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.click();
			Update_Report("Pass", "clickElement", objName+" is clicked");	
		}else{
		Update_Report("Fail", "clickElement", objName + " field is not displayed please check your application");
		
		}
	}
	
	/* Name of the method: validateText
	 * Brief description: Validate Text Message
	 * Arguments: obj --> WebElement object, exceptTextMsg --> Except text message,  objName --> Object name
	 * Created By: TechPirates
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 **/
	
	public static void validateText(WebElement obj, String exceptedTextMsg, String objName ) throws IOException{
		if(obj.isDisplayed()){
			String actualTestMsg = obj.getText().trim();
			if(exceptedTextMsg.equals(actualTestMsg)){
				Update_Report("Pass", "validateText", "Excepted message matched with actual message "+actualTestMsg);
			}else{
				Update_Report("Fail", "validateText",exceptedTextMsg +" Excepted message did matched with actual message "+actualTestMsg);	
			}
			
			}else{
		Update_Report("Fail", "validateText",objName + " field is not displayed please check your application");
		
		}

	}
	
	/* Name of the method: selectCheckBox
	 * Brief description: check check box
	 * Arguments: obj --> WebElement object, objName --> Object Name
	 * Created By: TechPirates
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 **/
	
	
	public static void selectCheckBox(WebElement obj, String objName) throws IOException{
		if(obj.isDisplayed() && obj.isSelected()){
			Update_Report("Pass", "selectCheckBox", objName + "is already checked");
		}else if(obj.isDisplayed()){
			obj.click();
			Update_Report("Pass", "selectCheckBox",objName + " is checked");
		}else{
			Update_Report("Fail", "selectCheckBox", objName + "is not displayed check your application");
		}
		
	}
	
	
	/* Name of the method: deselectCheckBox
	 * Brief description: unchecked check box
	 * Arguments: obj --> WebElement Object, objName --> Object Name
	 * Created By: TechPirates
	 * Creation Date: June 29 2016
	 * Last Modified: June 20 2016
	 **/
	public static void deselectCheckBox(WebElement obj, String objName) throws IOException{
		 if(obj.isDisplayed() && obj.isSelected()){
			 obj.click();
			 Update_Report("Pass", "deselectCheckBox", objName + "is not checked");
		 }else if(obj.isDisplayed()){
			 Update_Report("Pass", "deselectCheckBox", objName + " is not checked");
		 }else{
			 Update_Report("Fail", "deselectCheckBox", objName + "is not displayed check you applcation");
		 }
	}



	



	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";


 
		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Description</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}
}

