package pkg;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class exeEngine extends ReusableMethod {

	public static String xlData;
	public static int resultFlag;
	
	public static void main(String[] args) throws IOException, InterruptedException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub

		//TestCase.launchTheAmazonApplication();
		//TestCase.verifyDropDownOptionafterIphoneisTypedinSearch();
		//TestCase.clickonSearchButtonafterIphoneIsEntered();
		// TestCase.verifyShowresultsForColumnontheleftCellPhonesAndAccessoriesHeader();
		//TestCase.computersAndAccessoriesHeader();
		//TestCase.electronicsHeader();
		//TestCase.checkMainTab();
		//TestCase.validateDepartmentDropDownList();
		//TestCase.validateAccountsDropDownList();
		//TestCase.validateListsDropDownList();
		//TestCase.CheckList();
		
		
  String[][] recData = TestCase.readExcel("C:/Fredrick/Se_Training/q3.xls", "Sheet1");
		
		String automationScript;
		String runNorun;
		for(int i=1; i<recData.length; i++){
			
			runNorun =recData[i][1];
			resultFlag = 0;
			if(runNorun.equalsIgnoreCase("y")){
			
				automationScript =recData[i][2];
				
				Method ts = TestCase.class.getMethod(automationScript);
				ts.invoke(ts);

			
			if(resultFlag == 0){
				xlData = "Pass";
				
			}else{
				xlData ="Fail";
			}
			TestCase.writeExcel("C:/Fredrick/Se_Training/q3.xls", "Sheet1", i, 3, xlData);
		
			}else{
				System.out.println("In Row number " + i + " script name " + recData[i][2] + " did not execute");
			}
		}
		
	}
}