package Reader;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

    static ExtentReports report;

    public static ExtentReports report(){
        ExtentSparkReporter spark=new ExtentSparkReporter("ExtentReport.html");

        spark.config().setDocumentTitle("Test Script");
        spark.config().setReportName("HerdX App");

        report=new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("","");
        return report;
    }
}
