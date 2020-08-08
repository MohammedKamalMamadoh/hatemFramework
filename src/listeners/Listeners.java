package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Listeners implements ITestListener 
{
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}
	@Override
	public void onTestFailure(ITestResult result) {
		
		ITestListener.super.onTestFailure(result);
		System.out.println("faild");
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}
	@Override()
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}
    @DataProvider
    @Test(dataProvider = "data",enabled = false)
    public void tests(String x1,String x2,String x3)
    {
    	System.out.printf(x1,x2,x3);
    }
    public Object[][] mydata()
    {
    Object [][] data = new Object[3][3];
   
   data [0][0] ="1";
   data [0][1] ="2";
   data [0][2] ="3";
   data [1][0] ="4";
   data [1][1] ="5";
   data [1][2] ="6";
   data [2][0] ="7";
   data [2][1] ="8";
   data [2][2] ="9";
     
   return data;
	
}
}
