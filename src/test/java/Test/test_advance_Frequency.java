package Test;

import base.CaptureScreenshot;
import base.PropertiesFileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.ReportingPage;

public class test_advance_Frequency {
    //	private ChromeDriver driver;
    WebDriver driver;
    String URL = PropertiesFileUtils.getProperty("base_url");

    String username = PropertiesFileUtils.getProperty("username");
    String password = PropertiesFileUtils.getProperty("password");
    String name_dashboard1 = PropertiesFileUtils.getProperty("name_dashboard1");
    String name_dashboard2 = PropertiesFileUtils.getProperty("name_dashboard2");
    String report_name = PropertiesFileUtils.getProperty("report_name");
    String report_name1 = PropertiesFileUtils.getProperty("report_name1");
    String report_name2 = PropertiesFileUtils.getProperty("report_name2");
    String report_name3 = PropertiesFileUtils.getProperty("report_name3");
    String report_name4 = PropertiesFileUtils.getProperty("report_name4");
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
@Ignore
    @Test(priority = 1)
    public void TC_Advance_once() throws InterruptedException {
        ReportingPage Once = new ReportingPage(driver);
        Once.clickCreateNew();

        Once.clickSelectDashboard1(name_dashboard1);
        Once.clickNext();
        Once.enterReportName(report_name);
        Once.enterRecipients(recipients);

        Once.clickNext();
        Once.clickAdvance();
        Once.clickFrequencyOnce();

        Once.clickNext();
        Once.clickCreate();
        Once.clickConfirmCreate();

    Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void TC_Advance_hourly() throws InterruptedException {
        Thread.sleep(2000);
        ReportingPage Hourly = new ReportingPage(driver);
        Hourly.clickCreateNew();
        Hourly.clickSelectDashboard1(name_dashboard1);

        Hourly.clickNext();
        Hourly.enterReportName(report_name1);
       Hourly.enterRecipients(recipients2);

        Hourly.clickNext();
        Hourly.clickAdvance();
        Hourly.clickFrequencyHourly();
        Hourly.clickEndDate();
        Thread.sleep(2000);
        Hourly.chooseDateH();

        Hourly.ClickStarTime();
        Hourly.ChooseStarHour();
        Hourly.ChooseStartMinute();

        Hourly.clickEndTime();
        Hourly.chooseHourEndTime();
        Hourly.chooseMinuteEndTime();
        Hourly.clickOther3();
        Thread.sleep(2000);
//
//        Hourly.clickNext();
//        Hourly.clickCreate();
//        Hourly.clickConfirmCreate();
//       Thread.sleep(2000);
    }

@Ignore
@Test(priority = 3)
public void TC_Advance_monthly() throws InterruptedException {
    Thread.sleep(2000);
    ReportingPage monthly = new ReportingPage(driver);

    monthly.clickCreateNew();
    monthly.clickSelectDashboard1(name_dashboard1);

    monthly.clickNext();
    monthly.enterReportName(report_name2);
    monthly.enterRecipients(recipients);

    monthly.clickNext();
    monthly.clickAdvance();
    monthly.clickFrequencyMonthly();
    monthly.clickEndDate();
   // monthly.clickNextMonth();
    monthly.chooseDateH();
    monthly.clickOther3();
    Thread.sleep(3000);
    monthly.radioOnTheFirst();
    monthly.choosedayinweek();
    Thread.sleep(2000);
    monthly.clickNext();
    monthly.clickCreate();
    monthly.clickConfirmCreate();

    Thread.sleep(2000);
}
@Ignore
    @Test(priority = 4)
    public void TC_Advance_weekly() throws InterruptedException {
        ReportingPage weekly = new ReportingPage(driver);
       Thread.sleep(2000);
        weekly.clickCreateNew();

        //   monthly.clickSelectDashboard1(name_dashboard1);

        weekly.clickNext();
        weekly.enterReportName(report_name3);
        weekly.enterRecipients(recipients2);

        weekly.clickNext();
        weekly.clickAdvance();
        weekly.clickFrequencyWeekly();
        weekly.clickEndDate();
        //weekly.clickNextMonth();
        weekly.chooseDateH();
        weekly.clickOther3();
        Thread.sleep(3000);
        weekly.radioMonday();
        weekly.clickNext();
        weekly.clickCreate();
        weekly.clickConfirmCreate();
        Thread.sleep(2000);
    }
@Ignore
    @Test(priority = 4)
    public void TC_Advance_Daily() throws InterruptedException {
        ReportingPage daily = new ReportingPage(driver);
        Thread.sleep(2000);
        daily.clickCreateNew();

        daily.clickSelectDashboard1(name_dashboard1);

        daily.clickNext();
        daily.enterReportName(report_name4);
        daily.enterRecipients(recipients2);

        daily.clickNext();
        daily.clickAdvance();
        daily.clickFrequencyDaily();
        daily.clickEndDate();
        daily.chooseRepeatEvery();
        daily.chooseDateH();
        daily.clickOther3();
        Thread.sleep(3000);
        daily.radioMonday();
        daily.clickCreate();
        daily.clickConfirmCreate();
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
