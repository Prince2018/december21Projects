package testngsample;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;import org.testng.annotations.AfterTest;import org.testng.annotations.BeforeTest;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class TestEmployeeDetails {
	
   EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
   EmployeeDetails employee = new EmployeeDetails();
   
   ExtentReports extent;
	ExtentTest logger;
	private WebDriver driver;
	
	@BeforeTest
	public void startReport(){
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/TestEmployeeeeeeeeeeeeeeeeeee.html", true);
		extent.addSystemInfo("Host Name", "Enfin Technologies	")//extent.addSystemInfo("Environment","Environment Name")              
               .addSystemInfo("Environment", "Automation Testing")
               .addSystemInfo("User Name", "Prince.J");
               extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-configssssssssssss.xml"));
	}
	@Test
	public void passTest(){
		logger = extent.startTest("PASS TEST");//extent.startTest("TestCaseName", "Description")
		Assert.assertTrue(true);		
		logger.log(LogStatus.PASS, "Test Case passed");//To generate the log when the test case is passed
	}	
	@Test
	public void failTest(){
		logger = extent.startTest("FAIL TEST");
		Assert.assertTrue(false);
		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	}
	
	@Test
	public void skipTest(){
		logger = extent.startTest("SKIP TEST");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
   @Test
   public void testCalculateAppriasal() {
      employee.setName("Rajeev"); employee.setAge(25);employee.setMonthlySalary(8000);
      double appraisal = empBusinessLogic.calculateAppraisal(employee);
      Assert.assertEquals(500, appraisal, 0.0, "500"); 
   }  
   @Test // Test to check yearly salary
   public void testCalculateYearlySalary() {
      employee.setName("Rajeev"); employee.setAge(25); employee.setMonthlySalary(8000);
      double salary = empBusinessLogic.calculateYearlySalary(employee);
      Assert.assertEquals(96000, salary, 0.0, "8000");
   }	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test	
		extent.endTest(logger);//endTest(logger) : It ends the current test and prepares to create HTML report
	}
	@AfterTest
	public void endReport(){
               extent.flush();// writing everything to document flush() - to write or update test information to your report. 
               extent.close(); //Call close() at the very end of your session to clear all resources. 
               System.out.println("TESTING FINISHED");
   }
}