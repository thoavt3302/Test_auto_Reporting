package Test;

import base.CaptureScreenshot;
import base.PropertiesFileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ReportingPage;

public class Test_send_test {
    //	private ChromeDriver driver;
    WebDriver driver;
    String URL = PropertiesFileUtils.getProperty("base_url");

    String username = PropertiesFileUtils.getProperty("username");
    String password = PropertiesFileUtils.getProperty("password");
    String name_dashboard1 = PropertiesFileUtils.getProperty("name_dashboard1");
    String name_dashboard2 = PropertiesFileUtils.getProperty("name_dashboard2");
    String report_name = PropertiesFileUtils.getProperty("report_name");
    String recipients = PropertiesFileUtils.getProperty("recipients");
    String Email1 = PropertiesFileUtils.getProperty("Email1");
    String Email2 = PropertiesFileUtils.getProperty("Email2");

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

    }

    @Test(priority = 1)
    public void TC_Send_test_more_Email() throws InterruptedException {
        ReportingPage Create = new ReportingPage(driver);
        Create.clickCreateNew();
        Create.clickSelectDashboard1(name_dashboard1);
        Create.clickNext();
        Create.enterReportName(report_name);
        Create.enterRecipients(recipients);
        Create.clickNext();

        Create.clickNext();
        Create.clickSendTest();
        Create.enterEmail(Email1);
        Create.clickOther4();
        Create.enterEmail(Email2);
        Create.clickSendEmail();
        Thread.sleep(2000);

        Create.clickDiscard();
        Create.clickConfirmDiscard();

//        Create.clickCreate();
//        Create.clickConfirmCreate();
    }

    @Test(priority = 2)
    public void TC_Send_test_Email() throws InterruptedException {
        ReportingPage testEmail = new ReportingPage(driver);
        Thread.sleep(2000);
        testEmail.clickCreateNew();
        testEmail.clickSelectDashboard1(name_dashboard2);
        testEmail.clickNext();
//        Create.enterReportName(report_name);
//        Create.enterRecipients(recipients);
        testEmail.clickNext();
        testEmail.clickNext();
        testEmail.clickSendTest();
        testEmail.enterEmail(Email1);
        testEmail.clickSendEmail();
        testEmail.clickBack();

//        Create.clickCreate();
//        Create.clickConfirmCreate();
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
