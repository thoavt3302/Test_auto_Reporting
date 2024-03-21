package pages;

import base.CaptureScreenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ReportingPage {
	private WebDriver driver;
	WebDriverWait wait;

	public ReportingPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub

	}

	public void enterusername(String username) throws InterruptedException {

		try{
		WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		inputEmail.sendKeys(username);
		Thread.sleep(2000);

		}catch (Exception e){
			System.out.println("------Exception--------");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDatafailed");
			Assert.fail();
		}
	}

	public void enterPassword(String password) throws InterruptedException {
		try {
		WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		inputPassword.sendKeys(password);
		Thread.sleep(2000);
		}catch (Exception e){
			System.out.println("------Exception--------");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDatafailed");
			Assert.fail();
		}
	}

	public void clickSignIn() throws InterruptedException {
		try {

		WebElement clickSingIn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
		clickSingIn.click();
		//Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		}catch (Exception e){
			System.out.println("------Exception--------");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDatafailed");
			Assert.fail();
		}
	}

	public void clickCreateNew() throws InterruptedException {
		WebElement clickcreateNew = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='css-td06pi-button']")));
		clickcreateNew.click();
		Thread.sleep(2000);
	}


	public void clickSelectDashboard1(String name_dashboard) throws InterruptedException {
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("(//div[@class=' css-1exnbn8'])[1]"))).perform();
		// nhấn enter
		act.sendKeys(name_dashboard).perform();
		act.sendKeys(Keys.ENTER).perform();
	}

	public void clickSelectDashboard2(String name_dashboard) throws InterruptedException {
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("(//div[contains(@class,'css-1exnbn8')])[2]"))).perform();
		// nhấn enter
		act.sendKeys(name_dashboard).perform();
		act.sendKeys(Keys.ENTER).perform();
	}

	public void enterReportName(String reportName) throws InterruptedException {

		WebElement nameReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Please enter the report name']")));
		nameReport.clear();
		Thread.sleep(2000);
		nameReport.sendKeys(reportName);
		Thread.sleep(2000);
	}

	public void enterRecipients(String recipients) throws InterruptedException {
		WebElement Recipients = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Please enter email address']")));
		Recipients.sendKeys(recipients);

		Thread.sleep(2000);
	}

	public void clickNext() throws InterruptedException {
		WebElement ClickNext2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		ClickNext2.click();
		Thread.sleep(2000);
	}

	public void clickBack() throws InterruptedException {
		WebElement ClickNext3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Back']")));
		ClickNext3.click();
		Thread.sleep(2000);
	}

	public void clickCreate() throws InterruptedException {
		WebElement ClickCreate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Create']")));
		ClickCreate.click();
		Thread.sleep(2000);
	}

	public void clickConfirmCreate() throws InterruptedException {
		WebElement ClickCreate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='css-ttl745-button']//span[@class='css-1riaxdn'][normalize-space()='Create']")));
		ClickCreate.click();
		Thread.sleep(2000);
	}

	public void clickDiscard() throws InterruptedException {
		WebElement ClickDiscard = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Discard']")));
		ClickDiscard.click();
		Thread.sleep(2000);
	}

	public void clickConfirmDiscard() throws InterruptedException {
		WebElement ClickDiscardChange = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Discard unsaved changes']")));
		ClickDiscardChange.click();
		Thread.sleep(2000);
	}

	public void clickScheduleStatus() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='switch-1']")));
		element.click();
		Thread.sleep(2000);
	}

	public void clickConfirmStatus() throws InterruptedException {
		WebElement ClickConfirmStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Confirm']")));
		ClickConfirmStatus.click();
		Thread.sleep(2000);
	}

	public void clickIconDelete() throws InterruptedException {
		WebElement ClickIconDelete = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[name()='svg'][@class='css-kfbn56'])[2]")));
		ClickIconDelete.click();
		Thread.sleep(2000);
	}
    public void confirmDelete() throws InterruptedException {
        WebElement confirmDelete = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Delete']")));
        confirmDelete.click();
        Thread.sleep(2000);
    }
	public void clickAdvance() throws InterruptedException {
		WebElement clickAdvance = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Advance']")));
		clickAdvance.click();
		Thread.sleep(2000);

	}

	public void clickFrequencyOnce() throws InterruptedException {

		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("(//div[@class=' css-1exnbn8'])[3]"))).perform();
		//nhấn enter
		act.sendKeys("Once").perform();
		act.sendKeys(Keys.ENTER).perform();
	}

	public void clickFrequencyHourly() throws InterruptedException {

		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("(//div[@class=' css-1exnbn8'])[3]"))).perform();
		//nhấn enter
		act.sendKeys("Hour").perform();
		act.sendKeys(Keys.ENTER).perform();
		// cuộn chuột xuống
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(500);
	}

	public void clickFrequencyMonthly() throws InterruptedException {

		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("(//div[@class=' css-1exnbn8'])[3]"))).perform();
		//nhấn enter
		act.sendKeys("mon").perform();
		act.sendKeys(Keys.ENTER).perform();
		// cuộn chuột xuống
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(500);
	}
	public void clickFrequencyWeekly() throws InterruptedException {

		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("(//div[@class=' css-1exnbn8'])[3]"))).perform();
		//nhấn enter
		act.sendKeys("week").perform();
		act.sendKeys(Keys.ENTER).perform();
		// cuộn chuột xuống
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(500);
	}
	public void clickFrequencyDaily() throws InterruptedException {

		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("(//div[@class=' css-1exnbn8'])[3]"))).perform();
		//nhấn enter
		act.sendKeys("dai").perform();
		act.sendKeys(Keys.ENTER).perform();
		// cuộn chuột xuống
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(500);
	}
	public void clickAddDashboard() throws InterruptedException {
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("(//button[@type='submit'])[1]"))).perform();
		Thread.sleep(500);
	}

	public void checkSenRight() throws InterruptedException {
		WebElement checkSenRight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='css-11ty15i'])[2]")));
		checkSenRight.click();
		Thread.sleep(2000);
	}

	public void clickOther2() throws InterruptedException {
		WebElement clickOther2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='css-1n623kj'])[1]")));
		clickOther2.click();
		Thread.sleep(2000);
	}

	public void clickOther3() throws InterruptedException {
		WebElement clickOther3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='css-ox25sa'])[1]")));
		clickOther3.click();
		Thread.sleep(2000);
	}

	public void clickEndDate() throws InterruptedException {
		WebElement clickEndDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='endDate']")));
		clickEndDate.click();
		Thread.sleep(3000);
	}

	public void clickNextMonth() throws InterruptedException {
//		Actions act = new Actions(driver);
//		//cuộn chuột
//		int n = 0;
//		while(n<3) {
//			act.sendKeys(Keys.PAGE_DOWN).perform();
//		}
		WebElement clickNextMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[name()='svg'][@class='css-18ikbw6'])[17]")));
		clickNextMonth.click();
		//act.click(driver.findElement(By.xpath("(//*[name()='svg'][@class='css-18ikbw6'])[17]"))).perform();
		Thread.sleep(2000);
	}

	public void chooseDateH() throws InterruptedException {
		WebElement chooseDateH = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//abbr[@aria-label='March 30, 2024']")));
		chooseDateH.click();
		Thread.sleep(3000);
	}
	public void chooseRepeatEvery() throws InterruptedException {
		WebElement chooseRepeat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='radiogroup-list-40-1'])[1]")));
		chooseRepeat.click();
		Thread.sleep(3000);
	}
	public void clickEndTime() throws InterruptedException {
		WebElement clickEndDate = driver.findElement(By.xpath("(//input[@value='15:54'])[2]"));
		clickEndDate.click();
		Thread.sleep(2000);
	}

	public void chooseHourEndTime() throws InterruptedException {
		WebElement chooseDateH = driver.findElement(By.xpath("(//li[@role='button'][normalize-space()='17'])[1]"));
		chooseDateH.click();
		Thread.sleep(2000);
	}

	public void chooseMinuteEndTime() throws InterruptedException {
		WebElement chooseDateH = driver.findElement(By.xpath("(//li[normalize-space()='39'])[1]"));
		chooseDateH.click();
		Thread.sleep(2000);
	}


	public void clickSendTest() throws InterruptedException {
		WebElement clickSendTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Send test email']")));
		clickSendTest.click();
		Thread.sleep(2000);
	}

	public void enterEmail(String Email1) throws InterruptedException {
		WebElement enterEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Please enter email address'])[1]")));
		enterEmail.sendKeys(Email1);
		Thread.sleep(2000);
	}

	public void clickSendEmail() throws InterruptedException {
		WebElement clickSend = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Send']")));
		clickSend.click();
		Thread.sleep(2000);
	}

	public void clickOther4() throws InterruptedException {
		WebElement clickOther4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='mt-12 css-160qn9s'])[1]")));
		clickOther4.click();
		Thread.sleep(2000);
	}

	public void radioOnTheFirst() throws InterruptedException {

		Actions act = new Actions(driver);
		act.click(driver.findElement(By.name("repeatCycle"))).perform();
		Thread.sleep(2000);
	}
	public void radioMonday() throws InterruptedException {
		WebElement radioMonday = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='css-11ty15i'])[2]")));
		radioMonday.click();
		Thread.sleep(2000);
	}
	public void choosedayinweek() throws InterruptedException {
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("(//div[@class='css-zyjsuv-input-suffix'])[4]"))).perform();
		Thread.sleep(2000);
		act.sendKeys("tues").perform();
		act.sendKeys(Keys.ENTER).perform();

	}

	// edit report
	public void clickUpdate() throws InterruptedException{
		WebElement update = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Update']")));
		update.click();
		Thread.sleep(2000);
	}
	public void clickConfirmUpdate() throws InterruptedException{
		WebElement confirmUpdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='css-1riaxdn'][normalize-space()='Update'])[2]")));
		confirmUpdate.click();
		Thread.sleep(2000);
	}
	public void clickDetailReport() throws InterruptedException{
		WebElement Detail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='edit dashboard auto']")));
		Detail.click();
		Thread.sleep(2000);
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public void clickIconEditSelect() throws InterruptedException{
		WebElement iconSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[name()='svg'][@class='css-kfbn56'])[3]")));
		iconSelect.click();
		Thread.sleep(2000);
	}
	public void clickIconEditSchedule() throws InterruptedException{
		WebElement editSchedule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[name()='svg'][@class='css-kfbn56'])[4]")));
		editSchedule.click();
		Thread.sleep(2000);
	}
	public void clickIconEditFormat() throws InterruptedException{
		// Tìm phần tử cần cuộn đến
		WebElement editFormat = driver.findElement(By.xpath("(//button[@aria-label='Edit'])[3]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editFormat);
		// Click
		editFormat.click();
		Thread.sleep(2000);

	}

	public void ClickStarTime() throws InterruptedException{
		WebElement ClickStart = driver.findElement(By.xpath("//input[@value='15:54']"));
		ClickStart.click();
		Thread.sleep(2000);
	}
	public void ChooseStarHour() throws InterruptedException{
		WebElement ClickStart = driver.findElement(By.xpath("//div[@class='rc-time-picker-panel-inner']//div[1]//ul[1]//li[21]"));
		ClickStart.click();
		Thread.sleep(2000);
	}
	public void ChooseStartMinute() throws InterruptedException{
		WebElement ClickStart = driver.findElement(By.xpath("//li[normalize-space()='36']"));
		ClickStart.click();
		Thread.sleep(2000);
	}
}
