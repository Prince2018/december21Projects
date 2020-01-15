package keyworddriventokbird;//https://dzone.com/articles/building-a-data-driven-keyword-driven-and-hybrid-s

import keyworddriven.ExcelApiTest;

public class DriverScript{
 public static void main(String[] args) throws Exception {
 String sPath = "D:\\Automation\\keyworddrivenfiles\\keywordmethodstokbird.xlsx"; //Declaring the path of the Excel file with the name of the Excel file
 ReadExcelData.setExcelFile(sPath, "Sheet1");//Here we are passing the Excel path and SheetName as arguments to connect with Excel file  
 //Hard coded values are used for Excel row & columns for now    
 //In later chapters we will replace these hard coded values with varibales    //This is the loop for reading the values of the column 3 (Action Keyword) row by row
 ExcelApiTest eat = new ExcelApiTest("D:\\Automation\\keyworddrivenfiles\\keywordmethodstokbird.xlsx");
 int colCount = eat.getColumnCount("Sheet1");
 System.out.println("Total Columns in the Excel : "+colCount);
 int rowCount = eat.getRowCount("Sheet1");
 System.out.println("Total Rows in the Excel : "+rowCount);
 for (int iRow=1;iRow<rowCount;iRow++){
 String methodNames = ReadExcelData.getCellData(iRow, 1); 
 if(methodNames.equals("openBrowser"))//Comparing the value of Excel cell with all the keywords in the "Actions" class 
 {Actions.openBrowser();} //This will execute if the excel cell value is 'openBrowser' .Action Keyword is called here to perform action
 else if(methodNames.equals("navigate")){Actions.navigate();}
 else if(methodNames.equals("input_Username")){Actions.input_Username();}
 else if(methodNames.equals("input_Password")){Actions.input_Password();}
 else if(methodNames.equals("click_Login")){ Actions.click_Login();}
 //else if(sActions.equals("verify_Login")){ Actions.verify_login();} 
 else if(methodNames.equals("verify_facilitator")){Actions.verify_facilitator();}
 else if(methodNames.equals("verify_accounts")){Actions.verify_accounts();}
 else if(methodNames.equals("verify_Admins")){Actions.verify_Admins();}
 else if(methodNames.equals("verify_Logs")){Actions.verify_Logs();}
 else if(methodNames.equals("verify_Usersdemo")){Actions.verify_Usersdemo();}
 else if(methodNames.equals("closeBrowser")){ Actions.closeBrowser(); System.out.println("Closed browser");}
 }}}