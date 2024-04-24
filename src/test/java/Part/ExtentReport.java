package Part;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

    static ExtentReports report;

    public static ExtentReports report(){
        String path= System.getProperty("user.dir")+"//Extent.html";
        ExtentSparkReporter spark=new ExtentSparkReporter(path);

        spark.config().setDocumentTitle("");
        spark.config().setReportName("");

        report=new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("","");
        return report;
    }
}
