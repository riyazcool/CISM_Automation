package com.automationcism.ticketassign;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


import com.google.common.base.Function;

public class App 
{
    public static void main(String[] args)
    {
        WebDriver driver = null;
        Set<String> windowHandles = null;
        try
        {
        	//Path to open IE explorer 
	            System.setProperty("webdriver.ie.driver",
	            		"C:\\Users\\RAHMEDS\\Downloads\\IEDriverServer_x64_3.150.0\\IEDriverServer.exe");
	            DesiredCapabilities cap = new DesiredCapabilities();
	            cap.setCapability("ignoreProtectedModeSettings", 1);
	            cap.setCapability("IntroduceInstabilityByIgnoringProtectedModeSettings", true);
	            cap.setCapability("nativeEvents", true);
	            cap.setCapability("browserFocus", true);
	            cap.setCapability("ignoreZoomSetting", true);
	            cap.setCapability("requireWindowFocus", "true");
	            cap.setCapability("INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS", true);
	            driver = new InternetExplorerDriver(cap);
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            Actions action = new Actions(driver);
	            driver.manage().window().maximize();
	            //CISM ticket link for navigation
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            driver.navigate().to("https://cism-web.es.corpintra.net/cism/");
	            String parentWindow = driver.getWindowHandle();
	            TimeUnit.SECONDS.sleep(15);	           
	            new WebDriverWait(driver,10).until(ExpectedConditions.numberOfWindowsToBe(2));
	            windowHandles = driver.getWindowHandles();
	            for (String winHandle : windowHandles)
	            {
	                try
	                {
	                		driver.switchTo().window(winHandle);
	
	                } 
	                catch (Exception e) 
	                {
	                    e.printStackTrace();
	                }
	            }
	             
	            //Option to select between mbrdi and Big Data
	            //TimeUnit.SECONDS.sleep(15);
	            WebElement table = driver.findElement(By.id("T806800002"));
	            //TimeUnit.SECONDS.sleep(5);
	            WebElement mbrdi = table.findElements(By.tagName("span")).get(1);
	            js.executeScript("arguments[0].click();", mbrdi);
	            //ID to click the search button
	            
	            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	            WebElement button = driver.findElement(By.id("WIN_0_806800000"));
	            js.executeScript("arguments[0].click();", button);       
	            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	            driver.switchTo().window(parentWindow);
	            TimeUnit.SECONDS.sleep(5);
	            //Id to click the search tickets
	            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
	            WebElement searchTickets = driver.findElement(By.id("WIN_0_801800482"));
	            js.executeScript("arguments[0].click();", searchTickets);      
	            new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(2));
	            driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
	            windowHandles = driver.getWindowHandles();
	            for (String winHandle : windowHandles)
	            {
	            	try 
	            	{
	            		driver.switchTo().window(winHandle);

	            	} 
	            	catch (Exception e)
	            	{
	            		e.printStackTrace();
	            	}
	            }
	            //Double click on user you created
	            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            WebElement table1 = driver.findElement(By.id("T801600031"));
	            WebElement user1 =table1.findElement(By.className("BaseTableStaticText"));
	            WebElement user = user1.findElement(By.tagName("span"));
	            js.executeScript("var evt = document.createEvent('MouseEvents');"+ 
	            "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"+ 
	            "arguments[0].dispatchEvent(evt);", user);
	            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            js.executeScript("arguments[0].click();", user);
	            action.doubleClick(user).perform();
	            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	            Thread.sleep(2000);
	            WebElement searchTickets1 = driver.findElement(By.id("WIN_0_801600020"));
            	
	            js.executeScript("arguments[0].click();", searchTickets1);           
	            TimeUnit.SECONDS.sleep(4);         
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            //For right click
	            action.contextClick(searchTickets1).perform();       
	            WebElement searchTickets2 = driver.findElement(By.id("WIN_0_801600043"));
	            WebElement text1 = searchTickets2.findElement(By.className("TableHdrL"));
	            String ss = text1.getAttribute("textContent");
	            String[] ss1 = ss.split(" ");
	            int a = Integer.valueOf(ss1[ss1.length-1]);
	            for(int i=0;i<(a/100)+1;i++)
	            {
	            	//ID to Click on the search ticket button
	            
		         /*   WebElement searchTickets11 = driver.findElement(By.id("WIN_0_801600020"));
	            	
		            js.executeScript("arguments[0].click();", searchTickets11);           
		            TimeUnit.SECONDS.sleep(4);         
		            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
		            //For right click
		          // action.contextClick(searchTickets1).perform();       
		            Thread.sleep(3000);
		          
		            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		            //To choose select All option 
		            pressKeyByRobot();
		
		            TimeUnit.SECONDS.sleep(10);           		
		            
		            //for right click
		            WebElement tt = driver.findElement(By.id("WIN_0_801600043"));
		            WebElement table4 = tt.findElement(By.className("BaseTableInner"));
		            js.executeScript("var evt = document.createEvent('MouseEvents');"+ 
		            "evt.initMouseEvent('contextmenu',true, true, window, 650, 650, 650, 650, 650, false, false, false, false, 0,null);"+ 
		            "arguments[0].dispatchEvent(evt);", table4);
		            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		            TimeUnit.SECONDS.sleep(5);
		            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		           //to select report option
		            pressKeyByRobot1();
		            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			           
		            Thread.sleep(5000);
		            windowHandles = driver.getWindowHandles();
		            for (String winHandle : windowHandles)
		            {
		            	try 
		            	{
		            		driver.switchTo().window(winHandle);

		            	} 
		            	catch (Exception e)
		            	{
		            		e.printStackTrace();
		            	}
		            }
		            //for moving to the CISM ticket you created through tabs(Created by me)
		             WebElement createdByme = driver.findElement(By.id("arid_WIN_0_93210"));
		             js.executeScript("arguments[0].click();", createdByme);
		           // pressKeyByRobot2();
		            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		           //To selct the user
		            pressKeyByRobot21();
		            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		           //To select the file option from Destination
		            pressKeyByRobot3();
		            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		           //To select the CSV option from Format
		            pressKeyByRobot4();
		            Thread.sleep(2000);
		           //To select the run button
		            pressKeyByRobot5();
		            Thread.sleep(2000);
		            //To select the save button
		            pressKeyByRobot6();	
		            Thread.sleep(2000);	        											
		           	//To close the current window
		            pressKeyByRobot7();
		            Thread.sleep(2000);
		            //To select the next users who are assigned for ticket
		            WebElement tt1 = driver.findElement(By.id("WIN_0_801600043"));
		            WebElement table33 = tt1.findElement(By.className("chunkright"));
		            js.executeScript("arguments[0].click();",table33);           
	            }	  
	        }
        	catch (Exception e)
        	{
	            e.printStackTrace();
        	} 
        	finally
    	    { 
        		// driver.quit();
    	    }

    	}

  
    public static void pressKeyByRobot() throws Exception{
        Robot r = new Robot();
        for(int i=0;i<3;i++)
        {
	        r.keyPress(KeyEvent.VK_DOWN);
	        Thread.sleep(2000);
        }			
        r.keyPress(KeyEvent.VK_ENTER);
       
    }
  

    public static void pressKeyByRobot1() throws Exception{
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_DOWN);
        TimeUnit.SECONDS.sleep(2);
        r.keyPress(KeyEvent.VK_DOWN);
        TimeUnit.SECONDS.sleep(2);
        r.keyPress(KeyEvent.VK_ENTER);
       
    }

    public static void pressKeyByRobot2() throws Exception{
        Robot r =new Robot();       
       
        r.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(5000);
        r.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(4000);
        r.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(10000);
        r.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(3000);
       
    }
    public static void pressKeyByRobot21() throws Exception{
    	 Robot r = new Robot();
    	 for(int i=1;i<=5;i++)
         {
 	        r.keyPress(KeyEvent.VK_TAB);
 	        Thread.sleep(2000);
         }			
         r.keyPress(KeyEvent.VK_TAB);
         Thread.sleep(5000);
         r.keyPress(KeyEvent.VK_DOWN);
         Thread.sleep(3000);
    	
    }

    public static void pressKeyByRobot3() throws Exception{
        Robot r = new Robot();
        for(int i=0;i<5;i++)
        {
	        r.keyPress(KeyEvent.VK_TAB);
	        Thread.sleep(3000);
        }			
        r.keyPress(KeyEvent.VK_TAB);		
        Thread.sleep(5000);		
        r.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(5000);
    }	

    public static void pressKeyByRobot4() throws Exception{
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(3000);
        r.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(5000);	
        r.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(5000);
    }

    public static void pressKeyByRobot5() throws Exception{
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(3000);
        for(int i=0;i<4;i++)
        {
	        r.keyPress(KeyEvent.VK_TAB);
	        Thread.sleep(3000);
        }
        r.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        r.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(3000);
       
    }		
    public static void pressKeyByRobot6() throws Exception{
        Robot r = new Robot();
        for(int i=0;i<13;i++)
        {
	        r.keyPress(KeyEvent.VK_TAB);
	        Thread.sleep(2000);
        }
        r.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
       
    }				
    public static void pressKeyByRobot7() throws Exception{
    	Robot robot = new Robot();
    	robot.keyPress(KeyEvent.VK_ALT);
    	robot.keyPress(KeyEvent.VK_F4);
    	robot.keyRelease(KeyEvent.VK_ALT);
    }
    
    public static void waitForAjax(WebDriver commonUtilsDriver) throws InterruptedException {
        try {
            while (true) {
                Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor) commonUtilsDriver)
                        .executeScript("return jQuery.active == 0");
                if (ajaxIsComplete) {
                    break;
                }
                Thread.sleep(150);
            }
            ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver commonUtilsDriver) {
                    return ((JavascriptExecutor) commonUtilsDriver).executeScript("return document.readyState")
                            .toString().equals("complete");
                }
            };
            try {
                Thread.sleep(1000);
                WebDriverWait wait = new WebDriverWait(commonUtilsDriver, 30);
                wait.until(expectation);
            } catch (Throwable error) {

            }
        } catch (Exception e) {

        }
    }

}


