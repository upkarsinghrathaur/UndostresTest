package com.Test.listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

private static ExtentReports extent;
	
	public static ExtentReports createInstance(String fileName)
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Web Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Undostres Web Test Report");
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		
		return extent;
	}
}
