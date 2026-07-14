package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() { // mult testcases shuld not collide so
																		// synchronsastion is given
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); // LOCATION OF
																										// THE HTML REP
																										// TO BE
																										// GENERATED,./-directory,extent-reports-folder
		reporter.config().setReportName("7martsupermarket"); // config().setReportName("7RMart Project") 2 methods in
																// ExtentSparkReporter
		extentReports.attachReporter(reporter); // attaching od extend report and extendssparkrep for report generation
		extentReports.setSystemInfo("Organization", "Obsqura"); // org name
		extentReports.setSystemInfo("Name", "Jimna");// team membersname
		return extentReports; // createExtentReports() returns extentReports
	}
}
