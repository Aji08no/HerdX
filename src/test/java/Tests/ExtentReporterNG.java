package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    static ExtentReports extent;
    public static ExtentReports getReport(){
        String path = System.getProperty("user.dir")+"//Reports.html";
        ExtentSparkReporter report=new ExtentSparkReporter(path);
        report.config().setDocumentTitle("Test Script");
        report.config().setReportName("HerdX App Automation Testing");

        extent=new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("QA","Aji");

        return extent;

    }
}
