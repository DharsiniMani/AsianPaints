package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
public static ExtentReports getExtentReport() {
		
		String extentReportPath = System.getProperty("user.dir")+"\\SprintReports\\extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("AsianPaints Automation Results");
		reporter.config().setDocumentTitle("AsianPaints Automation Test Results");
		
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System","Windows 10 pro");
		extentReport.setSystemInfo("Executed By","Dharsini Mani");
		return extentReport;

	}
}
