package Test;

import base.CaptureScreenshot;
import base.PropertiesFileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ReportingPage;
import sqlite3

def get_user_data(username):
    conn = sqlite3.connect('users.db')
    cursor = conn.cursor()

    # LỖI BẢO MẬT: Dùng chuỗi định dạng trực tiếp với input người dùng
    query = f"SELECT * FROM users WHERE username = '{username}'"
    cursor.execute(query)

    return cursor.fetchall()
public class Edit_reporting {
    //	private ChromeDriver driver;
    WebDriver driver;
    String URL = PropertiesFileUtils.getProperty("base_url");

    String username = PropertiesFileUtils.getProperty("username");
    String password = PropertiesFileUtils.getProperty("password");
    String name_dashboard1 = PropertiesFileUtils.getProperty("name_dashboard1");
    String name_dashboard2 = PropertiesFileUtils.getProperty("name_dashboard2");
    String report_name = PropertiesFileUtils.getProperty("report_name");
    String recipients = PropertiesFileUtils.getProperty("recipients");
    String recipients1 = PropertiesFileUtils.getProperty("recipients1");
    String recipients2 = PropertiesFileUtils.getProperty("recipients2");


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
    public void TC_Edit_selectDashboard_report() throws InterruptedException {
       ReportingPage editSelectDashboard = new ReportingPage(driver);
       editSelectDashboard.clickDetailReport();
       editSelectDashboard.clickIconEditSelect();

       editSelectDashboard.clickSelectDashboard1(name_dashboard2);
       editSelectDashboard.clickAddDashboard();
       editSelectDashboard.clickSelectDashboard2(name_dashboard1);

       editSelectDashboard.clickNext();
       editSelectDashboard.clickNext();
       editSelectDashboard.clickNext();

       editSelectDashboard.clickUpdate();
       editSelectDashboard.clickConfirmUpdate();
       Thread.sleep(2000);
    }


    @Test(priority = 2)
    public void TC_Edit_Schedule_report() throws InterruptedException {
        ReportingPage editSchedule = new ReportingPage(driver);
        editSchedule.clickDetailReport();

        editSchedule.clickIconEditSchedule();
        editSchedule.clickFrequencyHourly();
        editSchedule.clickEndDate();
        editSchedule.chooseDateH();
        editSchedule.clickEndDate();
        editSchedule.chooseHourEndTime();
        editSchedule.chooseMinuteEndTime();

        editSchedule.clickNext();

        editSchedule.clickUpdate();
        editSchedule.clickConfirmUpdate();

    }
    @Test(priority = 3)
    public void TC_Edit_Format_report() throws InterruptedException {
        Thread.sleep(2000);
        ReportingPage editFormat = new ReportingPage(driver);
        editFormat.clickDetailReport();

        editFormat.clickIconEditFormat();

        editFormat.enterReportName(report_name);
        editFormat.enterRecipients(recipients1);
        editFormat.clickOther2();
        editFormat.enterRecipients(recipients2);

        editFormat.clickNext();
        editFormat.clickNext();

        editFormat.clickUpdate();
        editFormat.clickConfirmUpdate();
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
       // driver.close();
        // driver.quit();
    }
}
