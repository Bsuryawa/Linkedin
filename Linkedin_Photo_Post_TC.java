package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Linkedin_Photo_Post_TC {

    public static void main(String[] args) throws InterruptedException{

        //1. Launch the3 driver
        ChromeDriver driver;

//         1.2 Maximize Window :driver.windows().manage().maximize();
WebDriverManager.chromedriver().setup();
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
driver = new ChromeDriver(options);
// 1.5 Handle Sync issue using implicitlyWait() :
   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
// 2. Load URL  
driver.get("https://www.linkedin.com/home");
// 3. Enter the Gmail id Using Locator "ID" session_key/sendKeys
driver.findElement(By.id("session_key")).sendKeys("email id");
// 4.Enter Password Using Locator "ID":session_password'/sendKeys
driver.findElement(By.id("session_password")).sendKeys("password");
// 5.Thread.sleep  
Thread.sleep(3000);
//6.click on sign in
driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
// 7.Thread.sleep  
Thread.sleep(3000);
// 8. Find the option 'Photo' Using Locator "XPath" //button[@aria-label='Add a photo']/click()
driver.findElement(By.xpath("//button[@aria-label='Add a photo']")).click();

// 9.Thread.sleep  Thread.sleep(5000);
Thread.sleep(5000);
// 10.Upload the photo -locate the file path  file path/sendKeys()
WebElement fileInput = driver.findElement(By.id("file-input"));
//String imagePath = "C:\\path\\to\\Bhagyashri image.jpg"; 
String imagePath = "\\C:\Users\BHAGYASHRI\OneDrive\Desktop\Resume\Bhagyashri image.jpg";

fileInput.sendKeys(imagePath);


// 8.Thread.sleep  Thread.sleep(5000);
Thread.sleep(5000);
// 9.click on 'Done' Using Locator "XPath" //span[text()='Done'] /click()
driver.findElement(By.xpath("//span[text()='Done']")).click();
// 10.Thread.Sleep  
Thread.sleep(3000);
// 11. Click 'Post' Using Locator "XPath" //span[text()='Post']/click()
driver.findElement(By.xpath("//span[text()='Post']")).click();

// 12. notification Using Locator "XPath" //span[text()='Post successful.']']
driver.findElement(By.xpath("//span[text()='Post successful.']"));
// 13.Quit the browser  
driver.quit();

    }

}
