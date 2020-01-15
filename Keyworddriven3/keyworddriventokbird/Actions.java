package keyworddriventokbird;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;import org.openqa.selenium.WebDriver;
public class Actions{
 public static WebDriver driver;
 public static void openBrowser(){System.setProperty("webdriver.chrome.driver", "D:\\chromedriver76\\chromedriver.exe");
 driver=new ChromeDriver();}
 public static void navigate(){
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 driver.get("https://beta-dev.tokbird.com/admin/login");driver.manage().window().maximize();}
 public static void input_Username(){ driver.findElement(By.name("email")).sendKeys("admin@tokbird.com"); }
 public static void input_Password(){driver.findElement(By.name("password")).sendKeys("123456ab");}
 public static void click_Login() throws InterruptedException{driver.findElement(By.cssSelector(".login-btn-width")).click();}
 public static void verify_login(){ String pageTitle = driver.getTitle(); Assert.assertEquals(pageTitle, "Tokbird");}
public static void verify_facilitator(){driver.findElement(By.linkText("Facilitators")).click();System.out.println("Loaded999Facilitator section");}
public static void verify_accounts(){driver.findElement(By.linkText("Accounts")).click();System.out.println("Loaded Accounts section");}
public static void verify_Admins(){driver.findElement(By.linkText("Admins")).click();System.out.println("Loaded Admins section");}
public static void verify_Logs(){driver.findElement(By.linkText("Logs")).click();System.out.println("Loaded Logs section");}
public static void verify_Usersdemo(){driver.findElement(By.linkText("Users Demo")).click();System.out.println("Loaded Users Demo section");}
@Test
 public static void closeBrowser(){driver.quit();}}
