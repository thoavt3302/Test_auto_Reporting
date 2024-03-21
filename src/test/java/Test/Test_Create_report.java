package Test;

import base.CaptureScreenshot;
import base.PropertiesFileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.ReportingPage;

public class Test_Create_report {
    //	private ChromeDriver driver;
    WebDriver driver;
    String URL = PropertiesFileUtils.getProperty("base_url");

    String username = PropertiesFileUtils.getProperty("username");
    String password = PropertiesFileUtils.getProperty("password");
    String name_dashboard1 = PropertiesFileUtils.getProperty("name_dashboard1");
    String report_name = PropertiesFileUtils.getProperty("report_name");
    String recipients = PropertiesFileUtils.getProperty("recipients");

    @BeforeClass
    public void init() {
//		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");// duong dan tuong doi
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Tải trang
        driver.get(URL);

    }

    @Test(priority = 0)
    public void TC_login_Account() throws InterruptedException {

        ReportingPage loginPage = new ReportingPage(driver);
        loginPage.enterusername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignIn();
        CaptureScreenshot.takeScreenshot(driver,"error");

    }


    @Test(priority = 1)
    public void TC_Create_report() throws InterruptedException {
        ReportingPage Create = new ReportingPage(driver);
        Create.clickCreateNew();
        Create.clickSelectDashboard1(name_dashboard1);
        Create.clickNext();
        Create.enterReportName(report_name);
        Create.enterRecipients(recipients);
        Create.clickNext();
        Create.clickNext();
        Create.clickCreate();
        Create.clickConfirmCreate();

        CaptureScreenshot.takeScreenshot(driver,"error");

    }

    // Nó sẽ thực thi sau mỗi lần thực thi testcase (@Test)
    @AfterMethod

    public void takeScreenshot(ITestResult result) throws InterruptedException {
        Thread.sleep(1000);
        // Nếu kết quả failed thì chụp lại màn hình
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                CaptureScreenshot.takeScreenshot(driver, result.getName());
                System.out.println("Đã chụp màn hình: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
   }

    @AfterClass
    public void closeBrowser() {
        //driver.close();
        // driver.quit();
    }
}
