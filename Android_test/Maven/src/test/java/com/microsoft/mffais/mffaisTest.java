package com.microsoft.mffais;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;

import org.junit.rules.TestWatcher;
import org.junit.Rule;

public class mffaisTest {
    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    private static EnhancedAndroidDriver<MobileElement> dr;

    public static EnhancedAndroidDriver<MobileElement> startApp() throws MalformedURLException {
    	//File app = new File("D:\\kevin\\mffais-app-release.apk");
    	DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SamsungA6");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
        capabilities.setCapability(MobileCapabilityType.APP, "D:/Kevin/mffais-app-release.apk");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        URL url = new URL("http://localhost:4723/wd/hub");

        return Factory.createAndroidDriver(url, capabilities);
        
        
		 
		
	  
    }
    

    
public void addBill(String addAccountBal, String addBillAmount) throws Exception {
        
    	//dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    dr = startApp();
        Thread.sleep(15000);
        dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Get Started\")").click();
        Thread.sleep(15000); 
        Thread.sleep(15000); 
        dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").click();
        Thread.sleep(5000);
        
        dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").sendKeys("testtest");
        Thread.sleep(5000);
        if(dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").isDisplayed())
        {
      	  dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
      	  Thread.sleep(5000);
        }
        else{
      	  dr.hideKeyboard();
      	  Thread.sleep(5000);
        }
        dr.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\")").sendKeys(addAccountBal);
        Thread.sleep(15000); 
        //dr.hideKeyboard();
        if(dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").isDisplayed())
        {
      	  dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
      	  Thread.sleep(5000);
        }
        else{
      	  dr.hideKeyboard();
      	  Thread.sleep(5000);
        }
        dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
       
        Thread.sleep(15000); 
        dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Add Bill\")").click();
        Thread.sleep(5000);
        Thread.sleep(5000);
        dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter payee name\")").click();
                 //dr.findElementByAndroidUIAutomator("UiSelector().index(3)").sendKeys("aaa");
        Thread.sleep(5000);
        dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter payee name\")").sendKeys("aaa");
        //dr.hideKeyboard();
        dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").click();
        //dr.findElementByAndroidUIAutomator("UiSelector().index(3)").sendKeys("aaa");
        Thread.sleep(5000);
        dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").sendKeys(addBillAmount);

        //dr.findElementByAndroidUIAutomator("UiSelector().index(5)").sendKeys("19.6");
        Thread.sleep(5000);
       // dr.hideKeyboard();
        dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Add\")").click();
        Thread.sleep(5000);
      

        dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
        Thread.sleep(5000);
        float temp1 = Float.parseFloat(addAccountBal);
        float temp2 = Float.parseFloat(addBillAmount);
        float expectedAvlBal= temp1 -temp2;
        Thread.sleep(5000);
        String actualavlBal =  dr.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.support.v4.view.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[2]").getText();
        String newString = actualavlBal.substring(1);
        float actualBalfl = Float.parseFloat(newString);
        
        assertTrue("passed",actualBalfl== expectedAvlBal);
        
        	
	}

public void addMultipleBill(String addAccountBal, String addBillAmount1, String addBillAmount2,String addBillAmount3) throws Exception {
    
	dr = startApp();
	dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    Thread.sleep(15000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Get Started\")").click();
    Thread.sleep(15000); 
    Thread.sleep(15000); 
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").click();
    Thread.sleep(5000);
    
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").sendKeys("testtest");
    Thread.sleep(5000);
    if(dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").isDisplayed())
    {
  	  dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
  	  Thread.sleep(5000);
    }
    else{
  	  dr.hideKeyboard();
  	  Thread.sleep(5000);
    }
    dr.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\")").sendKeys(addAccountBal);
    Thread.sleep(15000); 
    //dr.hideKeyboard();
    if(dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").isDisplayed())
    {
  	  dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
  	  Thread.sleep(5000);
    }
    else{
  	  dr.hideKeyboard();
  	  Thread.sleep(5000);
    }
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
   
    Thread.sleep(15000); 
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Add Bill\")").click();
    Thread.sleep(5000);
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter payee name\")").click();
             //dr.findElementByAndroidUIAutomator("UiSelector().index(3)").sendKeys("aaa");
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter payee name\")").sendKeys("aaa");
    //dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").click();
    //dr.findElementByAndroidUIAutomator("UiSelector().index(3)").sendKeys("aaa");
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").sendKeys(addBillAmount1);

    //dr.findElementByAndroidUIAutomator("UiSelector().index(5)").sendKeys("19.6");
    Thread.sleep(5000);
   // dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Add\")").click();
    Thread.sleep(5000);
  // Adding another bill
    Thread.sleep(15000); 
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Add Bill\")").click();
    Thread.sleep(5000);
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter payee name\")").click();
             //dr.findElementByAndroidUIAutomator("UiSelector().index(3)").sendKeys("aaa");
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter payee name\")").sendKeys("bbb");
    //dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").click();
    //dr.findElementByAndroidUIAutomator("UiSelector().index(3)").sendKeys("aaa");
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").sendKeys(addBillAmount2);

    //dr.findElementByAndroidUIAutomator("UiSelector().index(5)").sendKeys("19.6");
    Thread.sleep(5000);
   // dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Add\")").click();
    Thread.sleep(5000);
    
    // adding third bill
    Thread.sleep(15000); 
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Add Bill\")").click();
    Thread.sleep(5000);
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter payee name\")").click();
             //dr.findElementByAndroidUIAutomator("UiSelector().index(3)").sendKeys("aaa");
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter payee name\")").sendKeys("ccc");
    //dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").click();
    //dr.findElementByAndroidUIAutomator("UiSelector().index(3)").sendKeys("aaa");
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").sendKeys(addBillAmount3);

    //dr.findElementByAndroidUIAutomator("UiSelector().index(5)").sendKeys("19.6");
    Thread.sleep(5000);
   // dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Add\")").click();
    Thread.sleep(5000);

    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
    
    Thread.sleep(5000);
    float temp1 = Float.parseFloat(addAccountBal);
    float temp2 = Float.parseFloat(addBillAmount1);
    float temp3 = Float.parseFloat(addBillAmount2);
    float temp4 = Float.parseFloat(addBillAmount3);
    float totalBillAmount = temp2 + temp3 + temp4;
    float expectedAvlBal= temp1 -totalBillAmount;
    Thread.sleep(5000);
    String actualavlBal =  dr.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.support.v4.view.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[2]").getText();
    String newString = actualavlBal.substring(1);
    float actualBalfl = Float.parseFloat(newString);
    assertTrue("passed",actualBalfl== expectedAvlBal);
}

public void addABillAndAPay(String addAccountBal, String addBillAmount, String addaPay) throws InterruptedException, MalformedURLException{
	dr = startApp();
	//.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Get Started\")").click();
    Thread.sleep(15000); 
    //Thread.sleep(15000); 
    Thread.sleep(15000); 
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").click();
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").sendKeys("testtest");
    Thread.sleep(5000);
    ////dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
    dr.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\")").sendKeys(addAccountBal);
    Thread.sleep(15000); 
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
    //Thread.sleep(5000);
    Thread.sleep(15000); 
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Add Bill\")").click();
    Thread.sleep(5000);
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter payee name\")").click();              
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter payee name\")").sendKeys("aaa");
    ////dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").click();
    //dr.findElementByAndroidUIAutomator("UiSelector().index(3)").sendKeys("aaa");
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").sendKeys(addBillAmount);
    //dr.hideKeyboard();
    //dr.findElementByAndroidUIAutomator("UiSelector().index(5)").sendKeys("19.6");
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Add\")").click();
    Thread.sleep(5000);
    Thread.sleep(5000);

    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"ADD PAYMENT\")").click();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").click();              
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").sendKeys("Employee");
    //dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").click();
    //dr.findElementByAndroidUIAutomator("UiSelector().index(3)").sendKeys("aaa");
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").sendKeys(addaPay);
    
    //dr.hideKeyboard();
    Thread.sleep(5000);
   
    
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Save\")").click(); 
    float temp1 = Float.parseFloat(addAccountBal);
    float temp2 = Float.parseFloat(addBillAmount);
    float temp3 = Float.parseFloat(addaPay);
    float expectedAvlBal = (temp1+temp3)-temp2;
    Thread.sleep(5000);
    String actualavlBal =  dr.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.support.v4.view.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[2]").getText();
    String newString = actualavlBal.substring(1);
    float actualBalfl = Float.parseFloat(newString);
    assertTrue("passed",actualBalfl== expectedAvlBal);
    
}

public void addGoal(String addAccountBal, String addGoalAmount,String payGoal) throws InterruptedException, MalformedURLException{
	dr = startApp();
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Get Started\")").click();
    Thread.sleep(15000); 
   // Thread.sleep(15000); 
    Thread.sleep(15000); 
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").click();
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").sendKeys("testtest");
    Thread.sleep(5000);
    //dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
    dr.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\")").sendKeys(addAccountBal);
    Thread.sleep(15000); 
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
    //Thread.sleep(5000);
    Thread.sleep(15000); 
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Skip\")").click();
    Thread.sleep(5000);
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"GOALS\")").click();
             //dr.findElementByAndroidUIAutomator("UiSelector().index(3)").sendKeys("aaa");
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Add Goal\")").click();
    Thread.sleep(5000);
    //dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter payee name\")").click();
    //dr.findElementByAndroidUIAutomator("UiSelector().index(3)").sendKeys("aaa");
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter payee name\")").sendKeys("testgoal");

    //dr.findElementByAndroidUIAutomator("UiSelector().index(5)").sendKeys("19.6");
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").click();
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").sendKeys(addGoalAmount);
    
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Add\")").click();
    
    
     
    //String targetbal = dr.findElement(By.xpath("//*[@class='android.widget.TextView' and @index='2']")).getText();
    //System.out.println(remainbal);
   
    //String expectedtargetbal="$500.00";
    //System.out.println(exprtargetbal);
    String xpathPlus = "//android.widget.Button[@content-desc=\"Add Goal Payment\"])[2]/android.widget.ImageView";
    dr.findElementByXPath(xpathPlus).click();

    //dr.findElementByXPath("//android.widget.Button[@content-desc="Add Goal Payment"])[2]/android.widget.ImageView").click();
  //  List<AndroidElement> ae= dr.findElements(By.xpath("//*[@class='android.widget.ImageView']"));
    Thread.sleep(5000);
    //ae.get(2).click();
    //Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").click();
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").sendKeys(payGoal);
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Save\")").click();
    
    String remainbal1 = dr.findElement(By.xpath("//*[@class='android.widget.TextView' and @index='4']")).getText();
    float temp1 = Float.parseFloat(addAccountBal);
    float temp2 = Float.parseFloat(addGoalAmount);
    float temp3 = Float.parseFloat(payGoal);
    
    float expRemainingGoal = temp2-temp3;
   
    String newString = remainbal1.substring(1);
    float actualRemainingBal = Float.parseFloat(newString);
    assertTrue("passed",actualRemainingBal== expRemainingGoal);
    
    //target
     
    
      }

public void addPayRecurrent(String addAccountBal, String addPay) throws InterruptedException, MalformedURLException{
	dr = startApp();
	Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Get Started\")").click();
    Thread.sleep(15000); 
    //Thread.sleep(15000); 
    Thread.sleep(15000); 
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").click();
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").sendKeys("testtest");
    Thread.sleep(5000);
    //dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
    dr.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\")").sendKeys(addAccountBal);
    Thread.sleep(15000); 
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
    //Thread.sleep(5000);
    Thread.sleep(15000); 
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Next\")").click();
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Skip\")").click();
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"ADD PAYMENT\")").click();
    Thread.sleep(5000);
    dr.findElement(By.xpath("//*[@class='android.widget.ImageView' and @index='1']")).click();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").click();              
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Name\")").sendKeys("Employee");
    ////dr.hideKeyboard();
    //dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").click();
    //dr.findElementByAndroidUIAutomator("UiSelector().index(3)").sendKeys("aaa");
    //dr.hideKeyboard();
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Enter Amount\")").sendKeys(addPay);
    Thread.sleep(5000);
    //dr.hideKeyboard();
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"Save\")").click(); 
    
    float temp1 = Float.parseFloat(addAccountBal);
    float temp2 = Float.parseFloat(addPay);
    float expectedAvlBal= temp1 + temp2;
    Thread.sleep(5000);
    String actualavlBal =  dr.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.support.v4.view.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[2]").getText();
    String newString = actualavlBal.substring(1);
    float actualBalfl = Float.parseFloat(newString);
    assertTrue("passed",actualBalfl== expectedAvlBal);
   // softAssertion.assertEquals((int)actualBalfl, (int)expectedAvlBal);
    Thread.sleep(5000);
    dr.findElementByAndroidUIAutomator("UiSelector().textMatches(\"FORECAST\")").click(); 
    Thread.sleep(5000);
    Boolean entry = dr.findElementByAndroidUIAutomator("UiSelector().text(\"Employee\")").isDisplayed();
    assertTrue("There are entires for recurring pay",entry);
    // softAssertion.assertTrue(entry,"There is no entry for recurring pay");
    //System.out.println("There are entries for recurring pay");
    //softAssertion.assertAll();
}

@Test
public void addGoal() throws Exception {
	        
	 
	addGoal("200","500","300");
     
}

@Test
public void addMultipleBill() throws Exception
{
	addMultipleBill("200","19.8","7.8","12.3");
	Thread.sleep(5000);	
}

@Test
public void addARecurrentPay() throws Exception {
	        
	addPayRecurrent("200","40.7");

}
     
@Test
public void AddBill() throws Exception
    {
    	addBill("200","19.7");
    	Thread.sleep(5000);	
    }

@Test
public void addaBillAndAPayment() throws Exception
{
	addABillAndAPay("200","19.7","32.9"); //Provide account bal, bill amount and pay	   
	Thread.sleep(5000);	
}
    
    

    @After
    public void after() throws Exception {
        if (dr != null) {
            dr.label("Stopping App");
            dr.quit();
        }
    }
}
