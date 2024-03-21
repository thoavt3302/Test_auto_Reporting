package base;

import java.io.File;
import java.sql.SQLOutput;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


public class CaptureScreenshot {
	static String filename = null;
	public static void takeScreenshot(WebDriver driver, String testcaseName) {
	    try {
			//cách 1
//	        //Tạo tên ảnh trùng với tên testcase, kiểu ảnh là png
//	        String imageName = testcaseName+ ".png";
//
//	        // Thực hiện chụp ảnh màn hình, lấy ra đối tượng file ảnh source.
//	        TakesScreenshot screenshot = (TakesScreenshot) driver;
//	        File source = screenshot.getScreenshotAs(OutputType.FILE);
//
//	        //Tạo đối tượng file với tên đã đặt bên trên tại thư mục /ScreenShots,
//	        // Sau đó thực viện cope file ảnh nguồn vào file đích đó.
//	        File destiny = new File("./ScreenShot/" + imageName );
//	        FileHandler.copy(source, destiny);

			// cách 2
			Calendar c = Calendar.getInstance();
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			filename = "ScreenShot/"+testcaseName+c.getTime().toString().replace(":","").replace(" ","")+".png";
			File f = screenshot.getScreenshotAs(OutputType.FILE);
			File fd = new File(filename);
			FileUtils.copyFile(f,fd);

	    } catch (Exception ex) {
	        System.out.println("Not able to take screenshot");
	    }
		attachScreenshotToReport();
	}
	public static void attachScreenshotToReport(){
		try {
			// cách 1
//			System.setProperty("org.uncommons.reportng.escape-out","false");
//			File f  = new File(filename);
//			Reporter.log("<a title= \"Snapshot\" href=\"" + f.getAbsolutePath() +"\">" +
//					"<img width=\"418\" height=\"240\" alt=\"alternativeName\" title=\"title\" src=\"../surefire-reports/html/"+filename+"\"></a>");


			// cách 2
			System.setProperty("org.uncommons.reportng.escape-out", "false");
			File f = new File(filename);
			String absolutePath = f.getAbsolutePath();
			String imageSrc = "../surefire-reports/html/" + filename;
			Reporter.log("<a title=\"Snapshot\" href=\"" + absolutePath + "\">" +
					"<img width=\"418\" height=\"240\" alt=\"" + filename + "\" title=\"" + filename + "\" src=\"" + imageSrc + "\"></a>");
		}catch (Exception e){
			System.out.println("Not able to take screenshot");
		}
	}


}
