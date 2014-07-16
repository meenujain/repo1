package com.qtpselenium.test;
import static com.qtpselenium.test.DriverScript.APP_LOGS;
import static com.qtpselenium.test.DriverScript.CONFIG;
import static com.qtpselenium.test.DriverScript.OR;
//import static com.qtpselenium.test.DriverScript.currentTestSuiteXLS;
//import static com.qtpselenium.test.DriverScript.currentTestCaseName;
//import static com.qtpselenium.test.DriverScript.currentTestDataSetID;


//import java.awt.Robot;
//import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Select;
//import com.qtpselenium.xls.read.Xls_Reader;
public class Keywords {
	
	public WebDriver driver;
	
	//To open a particular Web browser defined in Config file 
	public String openBrowser(String object,String data){		
		APP_LOGS.debug("Opening browser");
		//if(data.equals("Mozilla"))
		if(CONFIG.getProperty(data).equalsIgnoreCase("Mozilla"))
			driver=new FirefoxDriver();
	    else if(CONFIG.getProperty(data).equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", "C:\\Users\\meenu\\workspace\\OptTest\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			}
		else if(CONFIG.getProperty(data).equalsIgnoreCase("Chrome"))
		    {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\meenu\\workspace\\OptTest\\chromedriver.exe");
			driver=new ChromeDriver();
		    }
		
		long implicitWaitTime=Long.parseLong(CONFIG.getProperty("implicitwait"));
		driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		return Constants.KEYWORD_PASS;

	}
	
	//To navigate back to previous page
	 public String navigateBack(String object,String data){  
	  APP_LOGS.debug("Navigating to previous page");
	  try{
	  driver.navigate().back();
	  
	  }catch(Exception e){
	   return Constants.KEYWORD_FAIL+" -- Not able to navigate back";
	  }
	  return Constants.KEYWORD_PASS;
	 }
	
	//To hover mouse over an webElement 
		public String mouseHover(String object,String data){		
			APP_LOGS.debug("Mouse Hover");
			try{
				Actions action = new Actions(driver);
				WebElement we = driver.findElement(By.xpath(object));
				action.moveToElement(we).build().perform();
											
				}catch(Exception e){
					return Constants.KEYWORD_FAIL+" -- Not able to hover mouse";
				}
				return Constants.KEYWORD_PASS;

		}
		
		//To implicit wait 
				public String implicitWait(String object,String data){		
					APP_LOGS.debug("Implicit Wait");
					try{
						driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
													
						}catch(Exception e){
							return Constants.KEYWORD_FAIL+" -- Not able to implicit wait";
						}
						return Constants.KEYWORD_PASS;

				}
	//To navigate the browser on a particular Website defined in Config file
	public String navigate(String object,String data){		
		APP_LOGS.debug("Navigating to URL");
		try{
		driver.navigate().to(CONFIG.getProperty(data));
		
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" -- Not able to navigate";
		}
		return Constants.KEYWORD_PASS;
	}
	
	
	//To click a link
	public String clickLink(String object,String data){
        APP_LOGS.debug("Clicking a link ");
        try{
        	//System.out.println("in clicklink");
        driver.findElement(By.xpath(object)).click();
        }catch(Exception e){
			return Constants.KEYWORD_FAIL+" -- Not able to click on link"+e.getMessage();
        }
     
		return Constants.KEYWORD_PASS;
	}
	
	//To Click an element on a page by its text 
	
	public String clickByText(String object,String data){
        APP_LOGS.debug("Clicking on link by its text ");
        try{
        driver.findElement(By.linkText(data)).click();
        }catch(Exception e){
			return Constants.KEYWORD_FAIL+" -- Not able to click on link by text"+e.getMessage();
        }
     
		return Constants.KEYWORD_PASS;
	}
	
	//To click a button
	public  String clickButton(String object,String data){
        APP_LOGS.debug("Clicking on Button");
        try{
            driver.findElement(By.xpath(object)).click();
            }catch(Exception e){
    			return Constants.KEYWORD_FAIL+" -- Not able to click on Button"+e.getMessage();
            }        
        
		return Constants.KEYWORD_PASS;
	}


	//To click a button or element when clickButton is not working, it works like pressing enter on a link
	public  String clickByEnter(String object,String data){
	       APP_LOGS.debug("Clicking on button");
	       try{
	    	   driver.findElement(By.xpath(object)).sendKeys(Keys.ENTER);
			   }catch(Exception e){
					return Constants.KEYWORD_FAIL+" Not able to click";
			  }
			return Constants.KEYWORD_PASS;
	}
	

	// To click on an element by its id
	
	public  String clickByID(String object,String data){
	       APP_LOGS.debug("Clicking on any element");
	       try{
	    	   driver.findElement(By.id(object)).click();
			   }catch(Exception e){

					return Constants.KEYWORD_FAIL+" Not able to click";
			  }
			return Constants.KEYWORD_PASS;
	}
	
	
	
	
	//To do a simple click on an element 
	public  String click(String object,String data){
	       APP_LOGS.debug("Clicking on any element");
	       try{
	    	   driver.findElement(By.xpath(object)).click();
			   }catch(Exception e){
					return Constants.KEYWORD_FAIL+" Not able to click";
			  }
			return Constants.KEYWORD_PASS;
	}
	
	
	
	
	//To select randomly data from a list as well as data, but prefer using slectListNew keyword
	public  String selectList(String object, String data){
		APP_LOGS.debug("Selecting from list");
		try{
			if(data.equals(Constants.RANDOM_VALUE)){
				// logic to find a random value in list
				WebElement droplist= driver.findElement(By.xpath(OR.getProperty(object))); 
				List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
				Random num = new Random();
				int index=num.nextInt(droplist_cotents.size());
				String selectedVal=droplist_cotents.get(index).getText();
				
			  driver.findElement(By.xpath(object)).sendKeys(selectedVal);
			 
			}else{
				 driver.findElement(By.xpath(object)).sendKeys(data);
			}
		}catch(Exception e){
			return Constants.KEYWORD_FAIL +" - Could not select from list. "+ e.getMessage();	

		}
		
		return Constants.KEYWORD_PASS;	
	}
	
//To select an element from a list when List contains integer values,please suffix "k" after each value in sheet
	public  String selectIntList(String object, String data){
		APP_LOGS.debug("Selecting from list");
		try{
			Select dropDown = new Select(driver.findElement(By.xpath(object)));
			dropDown.selectByVisibleText(data.split("k")[0]);
			 //driver.findElement(By.xpath(object).);
			
		}catch(Exception e){
			return Constants.KEYWORD_FAIL +" - Could not select from list. "+ e.getMessage();	

		}
		
		return Constants.KEYWORD_PASS;	
	}
	
  //To Select an element from a list	
	public  String selectListNew(String object, String data){
		APP_LOGS.debug("Selecting from list");
		try{
		    Select droplist = new Select(driver.findElement(By.xpath(object)));   
	        droplist.selectByVisibleText(data);
	        
		}catch(Exception e){
			return Constants.KEYWORD_FAIL +" - Could not select from list. "+ e.getMessage();	

		}
		
		return Constants.KEYWORD_PASS;	
	}
	
	//to verify that element is selected from a list or not
	public  String verifyListNew(String object, String data){
		APP_LOGS.debug("verifying the list");
		
		try{
			String actual=data;
		    Select droplist = new Select(driver.findElement(By.xpath(object))); 
		    String expected=droplist.getFirstSelectedOption().getText();
		   // System.out.println(expected);
	          if(expected.equals(actual))
	          {
	           return Constants.KEYWORD_PASS;
	          }
	          else
	          {
	    	  return Constants.KEYWORD_FAIL+  "list not selected";
	          }
	        
		}catch(Exception e){
			return Constants.KEYWORD_FAIL +" - Could not select from list. "+ e.getMessage();	

		}
	}
	
		
	
	//To select a Radio Button with some pattern of string values,store the pattern value in test data and put a "|" in place of pattern in Xpath.
	public  String selectRadio(String object, String data){
		APP_LOGS.debug("Selecting a radio button");
		//String temp[]=object.split(Constants.DATA_SPLIT);
		try{
			String temp[]=object.split(Constants.DATA_SPLIT);
			//System.out.println(temp[0]+data.split(".")[0]+temp[1]);
			driver.findElement(By.xpath(temp[0]+data+temp[1])).click();
		}catch(Exception e){
			return Constants.KEYWORD_FAIL +"- Not able to find radio button" ;	

		}
		
		return Constants.KEYWORD_PASS ;	
		
		}
	
	//To select a radio button with pattern of integer value, Do the same as in above keyword
	public  String selectRadioUsingInt(String object, String data){
		APP_LOGS.debug("Selecting a radio button");
		String temp[]=object.split(Constants.DATA_SPLIT);
		try{
	
			driver.findElement(By.xpath(temp[0]+data.split("k")[0]+temp[1])).click();
		}catch(Exception e){
			return Constants.KEYWORD_FAIL +"- Not able to find radio button" + temp[0]+data.split(".")[0]+temp[1];	

		}
		
		return Constants.KEYWORD_PASS ;	
		
		}
	
	
	//To select a radio button with no pattern 
	public  String selectNewRadio(String object, String data){
		APP_LOGS.debug("Selecting a radio button having no pattern");
		try{
			driver.findElement(By.xpath(object)).click();
		}catch(Exception e){
			return Constants.KEYWORD_FAIL +"- Not able to find radio button";	

		}
		
		return Constants.KEYWORD_PASS;	
		
		}

    //To verify that a radio with no pattern is selected	
	public  String verifyRadioSelected(String object, String data){
		APP_LOGS.debug("Verify Radio Selected");
		try{
			String temp[]=object.split(Constants.DATA_SPLIT);
			String checked=driver.findElement(By.xpath(temp[0]+data+temp[1])).getAttribute("checked");
			//System.out.println(checked);
			if(checked.equals("true"))
				return Constants.KEYWORD_PASS;	

				
		}catch(Exception e){
			return Constants.KEYWORD_FAIL +"- Not able to find radio button";	

		}
		return Constants.KEYWORD_FAIL+"- Radio not selected";	
		

	}
	
	
	//To verify a Radio with pattern of integer value is selected
	public  String verifyIntRadioSelected(String object, String data){
		APP_LOGS.debug("Verifying Radio having int patern is Selected");
		String checked=null;
		try{
			String temp[]=object.split(Constants.DATA_SPLIT);
			 //checked=driver.findElement(By.xpath(temp[0]+data.split("k")[0]+temp[1])).getAttribute("checked");
			checked=driver.findElement(By.xpath(temp[0]+data.split("k")[0]+temp[1])).getAttribute("checked");
			if(!checked.equals(null))
				return Constants.KEYWORD_PASS;	

				
		}catch(Exception e){
			return Constants.KEYWORD_FAIL +"- Not able to find radio button" + e.getMessage();	

		}
		return Constants.KEYWORD_FAIL+"- Radio not selected" +checked;	
		

	}
	
	//To varify that a radio with no pattern is selected 
	public  String verifyNewRadioSelected(String object, String data){
		APP_LOGS.debug("Verify Radio Selected");
		try{
			
			String checked=driver.findElement(By.xpath(object)).getAttribute("checked");
			if(checked==null)
				return Constants.KEYWORD_FAIL+"- Radio not selected";	

				
		}catch(Exception e){
			return Constants.KEYWORD_FAIL +"- Not able to find radio button";	

		}
		
		return Constants.KEYWORD_PASS;	

	}


	//To click the button by which an alert is generated and then cancel the alert
	public  String dismissAlertButton(String object,String data){
	       APP_LOGS.debug("Clicking on button and dismissing the alert");
	       try{
	    	   driver.findElement(By.xpath(object)).click();
	    	   Alert alert = driver.switchTo().alert();
	    	  // System.out.println(alert.getText());
	    	   alert.dismiss();
			   }catch(Exception e){
					return Constants.KEYWORD_FAIL+" Not able to dismiss alert";
			  }
			return Constants.KEYWORD_PASS;
	}
	
	
	public  String dismissAlertButtonByID(String object,String data){
	       APP_LOGS.debug("Clicking on button and dismissing the alert");
	       try{
	    	   driver.findElement(By.id(object)).click();
	    	   Alert alert = driver.switchTo().alert();
	    	  // System.out.println(alert.getText());
	    	   alert.dismiss();
			   }catch(Exception e){
					return Constants.KEYWORD_FAIL+" Not able to dismiss alert";
			  }
			return Constants.KEYWORD_PASS;
	}
	
	
	
	//click the button by which an alert is generated and then accept the alert
	public  String acceptAlertButton(String object,String data){
	       APP_LOGS.debug("Clicking on button and acccepting the alert");
	       try{
	    	   driver.findElement(By.xpath(object)).click();
	    	   Alert alert = driver.switchTo().alert();
	    	   //System.out.println(alert.getText());
	    	   alert.accept();
			   }catch(Exception e){
					return Constants.KEYWORD_FAIL+" Not able to accept alert";
			  }
			return Constants.KEYWORD_PASS;
	}
	
	public  String acceptAlertButtonByID(String object,String data){
	       APP_LOGS.debug("Clicking on button and acccepting the alert by id");
	       try{
	    	   driver.findElement(By.id(object)).click();
	    	   Alert alert = driver.switchTo().alert();
	    	   //System.out.println(alert.getText());
	    	   alert.accept();
			   }catch(Exception e){
					return Constants.KEYWORD_FAIL+" Not able to accept alert";
			  }
			return Constants.KEYWORD_PASS;
	}
	
	
	
	
	
	//To verify the text of some link
	public  String verifyLinkText(String object,String data){
        APP_LOGS.debug("Verifying link Text");
        try{
        	String actual=driver.findElement(By.xpath(object)).getText();
        	String expected=data;
        	
        	if(actual.equals(expected))
        		return Constants.KEYWORD_PASS;
        	else
        		return Constants.KEYWORD_FAIL+" -- Link text not verified";
        	
        }catch(Exception e){
			return Constants.KEYWORD_FAIL+" -- Link text not verified"+e.getMessage();

        }
        
	}

//To verify the text of a button	
	public  String verifyButtonText(String object,String data){
		APP_LOGS.debug("Verifying the button text");
		try{
		String actual=driver.findElement(By.xpath(object)).getText();
    	String expected=data;

    	if(actual.equals(expected))
    		return Constants.KEYWORD_PASS;
    	else
    		return Constants.KEYWORD_FAIL+" -- Button text not verified "+actual+" -- "+expected;
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" Object not found "+e.getMessage();
		}
		
	}
	
	//To verify that a list has all element define in sheet
	public String verifyAllListElements(String object, String data){
		APP_LOGS.debug("Verifying the selection of the list");
	try{	
		WebElement droplist= driver.findElement(By.xpath(object)); 
		List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
		
		//define all expected value in OR separated by "," each and extract the expected values from OR. properties
		String temp=data;
		String allElements[]=temp.split(",");
		// check if size of array == size if list
		if(allElements.length != droplist_cotents.size())
			return Constants.KEYWORD_FAIL +"- size of lists do not match";	
		
		for(int i=0;i<droplist_cotents.size();i++){
			if(!allElements[i].equals(droplist_cotents.get(i).getText())){
					return Constants.KEYWORD_FAIL +"- Element not found - "+allElements[i];
			}
		}
	}catch(Exception e){
		return Constants.KEYWORD_FAIL +" - Could not select from list. "+ e.getMessage();	

	}
		
		
		return Constants.KEYWORD_PASS;	
	}
	
	//To verify that a right value is selected from a list
	public  String verifyListSelection1(String object,String data){
		APP_LOGS.debug("Verifying all the list elements");
		try{
			String expectedVal=data;
			//System.out.println(driver.findElement(By.xpath(object)).getText());
			WebElement droplist= driver.findElement(By.xpath(object)); 
			List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
			String actualVal=null;
			for(int i=0;i<droplist_cotents.size();i++){
				String selected_status=droplist_cotents.get(i).getAttribute("selected");
				System.out.println(selected_status);
				if(selected_status.equals("true"))
					actualVal = droplist_cotents.get(i).getText();		
				System.out.println(actualVal);
				}
			
			if(actualVal!=expectedVal)
				return Constants.KEYWORD_FAIL + "Value not in list - "+actualVal+"--"+expectedVal;

		}catch(Exception e){
			return Constants.KEYWORD_FAIL +" - Could not find list. "+ e.getMessage();	

		}
		return Constants.KEYWORD_PASS;	

	}
	
	public  String verifyListSelection(String object,String data){
		  APP_LOGS.debug("Verifying all the list elements");
		  try{
		   String expectedVal=data;
		   //System.out.println(driver.findElement(By.xpath(OR.getProperty(object))).getText());
		   WebElement droplist= driver.findElement(By.xpath(object)); 
		   List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
		   String actualVal=null;
		   for(int i=0;i<droplist_cotents.size();i++){
		    String selected_status=droplist_cotents.get(i).getAttribute("selected");
		    if(selected_status!=null)
		     actualVal = droplist_cotents.get(i).getText();   
		    }
		   
		   if(!actualVal.equals(expectedVal))
		    return Constants.KEYWORD_FAIL + "Value not in list - "+expectedVal;

		  }catch(Exception e){
		   return Constants.KEYWORD_FAIL +" - Could not find list. "+ e.getMessage(); 

		  }
		  return Constants.KEYWORD_PASS; 

		 }
	
	public  String waitTillListLoaded(String object,String data){
		APP_LOGS.debug("Verifying all the list elements");
		try{
		//	String expectedVal=data;
			//System.out.println(driver.findElement(By.xpath(object)).getText());
			WebElement droplist= driver.findElement(By.xpath(object)); 
			List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
			//String actualVal=null;
		   String selected_status=droplist_cotents.get(0).getText();
		    System.out.println(selected_status);
		    WebDriverWait wait = new WebDriverWait(driver, 30);
            //if(data.equalsIgnoreCase("id"))
                wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(object), data));
           // else if(data.equalsIgnoreCase("css"))
               // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(object)));
           // else if(data.equalsIgnoreCase("xpath"))
               // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(object)));
				
			//if(!actualVal.equals(expectedVal))
            	return Constants.KEYWORD_PASS;	

		}catch(Exception e){
			return Constants.KEYWORD_FAIL +" - Could not find list. "+ e.getMessage();	

		}
	

	}
	
	//Verify that a right int value is selected from list
	public  String verifyIntListSelection(String object,String data){
		APP_LOGS.debug("Verifying all the list elements");
		try{
			String expectedVal=data;
			//System.out.println(driver.findElement(By.xpath(object)).getText());
			WebElement droplist= driver.findElement(By.xpath(object)); 
			List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
			String actualVal=null;
			for(int i=0;i<droplist_cotents.size();i++){
				String selected_status=droplist_cotents.get(i).getAttribute("selected");
				if(selected_status!=null)
					actualVal = droplist_cotents.get(i).getText();			
				}
			
			if(!expectedVal.contains(actualVal))
				return Constants.KEYWORD_FAIL + actualVal + "Value not in list - "+expectedVal;

		}catch(Exception e){
			return Constants.KEYWORD_FAIL +" - Could not find list. "+ e.getMessage();	

		}
		return Constants.KEYWORD_PASS;	

	}
	
		
	//To check a check box
	public  String checkCheckBox(String object,String data){
		APP_LOGS.debug("Checking checkbox");
		try{
			// true or null
			String checked=driver.findElement(By.xpath(object)).getAttribute("checked");
			if(checked==null)// checkbox is unchecked
				driver.findElement(By.xpath(object)).click();
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" - Could not find checkbo";
		}
		return Constants.KEYWORD_PASS;
		
	}
	
	//To uncheck a check box
	public String unCheckCheckBox(String object,String data){
		APP_LOGS.debug("Unchecking checkBox");
		try{
			String checked=driver.findElement(By.xpath(object)).getAttribute("checked");
			if(checked!=null)
				driver.findElement(By.xpath(object)).click();
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" - Could not find checkbox";
		}
		return Constants.KEYWORD_PASS;
		
	}
	
	//To verify that a check box is checked
	public  String verifyCheckBoxSelected(String object,String data){
		APP_LOGS.debug("Verifying checkbox selected");
		try{
			String checked=driver.findElement(By.xpath(object)).getAttribute("checked");
			//System.out.println(checked);
			if(checked!=null)
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " - Not selected";
			
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" - Could not find checkbox";

		}
		
		
	}
	
//To verify that a checkBox is unchecked
	public  String verifyCheckBoxUnChecked(String object,String data){
		APP_LOGS.debug("Verifying checkbox unchecked");
		try{
			String checked=driver.findElement(By.xpath(object)).getAttribute("checked");
			if(checked==null)
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " - Not selected";
			
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" - Could not find checkbox";

		}
		
		
	}
	
	//To verify that all Check box with some pattern are checked
	/*public  String verifyAllCheckBoxSelected(String object,String data){
		APP_LOGS.debug("Verifying All checkbox selected");
		String checked=null;
			String temp[]=object.split(Constants.DATA_SPLIT);
			
			for(int i=2;i<=Integer.parseInt(data);)
			{
			checked=driver.findElement(By.xpath(temp[0]+i+temp[1])).getAttribute("checked");
			if(checked!=null)
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL +i+ " - Not selected";
			
			
		}
		
		
	}
	*/
	
	public String verifyUrl(String object, String data){
		APP_LOGS.debug("Verifying the text");
		try{
			//System.out.println(driver.findElement(By.xpath(object)).getText());
			String actual=driver.getCurrentUrl();
			//System.out.println(actual);
	    	String expected=data;

	    	if(actual.equals(expected))
	    		return Constants.KEYWORD_PASS;
	    	else
	    		return Constants.KEYWORD_FAIL+" -- URl not verified "+actual+" -- "+expected;
			}catch(Exception e){
				return Constants.KEYWORD_FAIL+" Object not found "+e.getMessage();
			}
		
	}
	//to verify that certain text contains some specific text
	public String verifyContainText(String object, String data){
		APP_LOGS.debug("Verifying that labels contains text");
		try{
			//System.out.println(driver.findElement(By.xpath(object)).getText());
			String actual=driver.findElement(By.xpath(object)).getText();
			//System.out.println(actual);
	    	String expected=data;
	    	

	    	if(actual.contains(expected))
	    		return Constants.KEYWORD_PASS;
	    	else
	    		return Constants.KEYWORD_FAIL+" --not contain text "+actual+" -- "+expected;
			}catch(Exception e){
				return Constants.KEYWORD_FAIL+" Object not found "+e.getMessage();
			}
		
	}
	
	//to verify the src of an image
	public String verifyImageSrc(String object, String data){
		APP_LOGS.debug("Verifying the src of image");
		try{
			//System.out.println(driver.findElement(By.xpath(object)).getText());
			String actual=driver.findElement(By.xpath(object)).getAttribute("src");
			//System.out.println(actual);
	    	String expected=data;

	    	if(actual.contains(expected))
	    		return Constants.KEYWORD_PASS;
	    	else
	    		return Constants.KEYWORD_FAIL+" -- src not match--"+actual+" -- "+expected;
			}catch(Exception e){
				return Constants.KEYWORD_FAIL+" Object not found "+e.getMessage();
			}
		
	}
	
	
	//To verify the text of an element by xpath
	public String verifyText(String object, String data){
		APP_LOGS.debug("Verifying the text");
		try{
			//System.out.println(driver.findElement(By.xpath(object)).getText());
			String actual=driver.findElement(By.xpath(object)).getText();
			//System.out.println(actual);
	    	String expected=data;

	    	if(actual.equals(expected))
	    		return Constants.KEYWORD_PASS;
	    	else
	    		return Constants.KEYWORD_FAIL+" -- text not verified-- "+actual+" -- "+expected;
			}catch(Exception e){
				return Constants.KEYWORD_FAIL+" Object not found "+e.getMessage();
			}
		
	}
	
	
	//To verify that text is not matched
	public String verifyTextNotMatch(String object, String data){
		APP_LOGS.debug("Verifying the text");
		try{
			String actual=driver.findElement(By.xpath(object)).getText();
	    	String expected=data;

	    	if(!actual.equals(expected))
	    		return Constants.KEYWORD_PASS;
	    	else
	    		return Constants.KEYWORD_FAIL+" -- text matched"+actual+" -- "+expected;
			}catch(Exception e){
				return Constants.KEYWORD_FAIL+" Object not found "+e.getMessage();
			}
		
	}
	
	// to write if id of element is given
	public  String writeInputByID(String object,String data){
		APP_LOGS.debug("Writing in text box");
		
		try{
			driver.findElement(By.id(object)).click();
			driver.findElement(By.id(object)).clear();
			driver.findElement(By.id(object)).sendKeys(data);
			
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" Unable to write "+e.getMessage();

		}
		return Constants.KEYWORD_PASS;
		
	}
	
	
	//To write Some string in a text box
	public  String writeInInput(String object,String data){
		APP_LOGS.debug("Writing in text box");
		
		try{
			driver.findElement(By.xpath(object)).click();
			driver.findElement(By.xpath(object)).clear();
			driver.findElement(By.xpath(object)).sendKeys(data);
			
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" Unable to write "+e.getMessage();

		}
		return Constants.KEYWORD_PASS;
		
	}
	
	
	
	
	//To write some integer in text box
	public  String writeInteger(String object,String data){
		APP_LOGS.debug("Writing in text box");
		
		try{
			
			driver.findElement(By.xpath(object)).clear();
			driver.findElement(By.xpath(object)).sendKeys(data.split("k")[0]);
			
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" Unable to write "+e.getMessage();

		}
		return Constants.KEYWORD_PASS;
		
	}
	
	public  String writeIntegerByID(String object,String data){
		APP_LOGS.debug("Writing in text box");
		
		try{
			driver.findElement(By.id(object)).click();
			driver.findElement(By.id(object)).clear();
			driver.findElement(By.id(object)).sendKeys(data.split("k")[0]);
			
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" Unable to write "+e.getMessage();

		}
		return Constants.KEYWORD_PASS;
		
	}
	
	
	
	
	//method to wait till an element is present and clickable
    public String waitTillElementIsClickable(String object, String data){
        APP_LOGS.debug("Waiting till the presence of element" + object);
        try{
            WebDriverWait wait = new WebDriverWait(driver, 30);
            if(data.equalsIgnoreCase("id"))
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(object)));
            else if(data.equalsIgnoreCase("css"))
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(object)));
            else if(data.equalsIgnoreCase("xpath"))
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(object)));
            }catch(Exception e){
            return Constants.KEYWORD_FAIL+" Object not found "+e.getMessage();
        }
        return Constants.KEYWORD_PASS;
    }
        
	
	//to verify the text of a text box
	
	public  String verifyTextinInputByID(String object,String data){
       APP_LOGS.debug("Verifying the text in input box");
       try{
			String actual = driver.findElement(By.id(object)).getAttribute("value");
			String expected=data;

			if(actual.equals(expected)){
				return Constants.KEYWORD_PASS;
			}else{
				return Constants.KEYWORD_FAIL+" Not matching ";
			}
			
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" Unable to find input box "+e.getMessage();

		}
	}
	//These keywords are made but not implemented till now
	public  String clickImage(String object, String data){
	       APP_LOGS.debug("Clicking the image");
	       try{
	    	  // String src=driver.findElement(By.xpath(object)).getAttribute("src");
	    	   driver.findElement(By.xpath("//img[@src='"+data +"']")).click();
	    	   return Constants.KEYWORD_PASS;
	    	   
	    	   
	       }
	       catch(Exception e){
	    	   return Constants.KEYWORD_FAIL+"object not found"+e.getMessage();
	    	   
	       }
	
	}
	
	public  String verifyFileName(){
	       APP_LOGS.debug("Verifying inage filename");
			
			return Constants.KEYWORD_PASS;
	}
	
	
	
	//to verify the title of web page
	public  String verifyTitle(String object, String data){
	       APP_LOGS.debug("Verifying title");
	       try{
	    	   String actualTitle= driver.getTitle();
	    	   String expectedTitle=data;
	    	   if(actualTitle.equals(expectedTitle))
		    		return Constants.KEYWORD_PASS;
		    	else
		    		return Constants.KEYWORD_FAIL+" -- Title not verified "+expectedTitle+" -- "+actualTitle;
			   }catch(Exception e){
					return Constants.KEYWORD_FAIL+" Error in retrieving title";
			   }		
	}
	
	//To check whether an element is exist on a web page
	public String exist(String object,String data){
	       APP_LOGS.debug("Checking existance of element");
	       try{
	    	   driver.findElement(By.xpath(object));
			   }catch(Exception e){
					return Constants.KEYWORD_FAIL+" Object doest not exist";
			  }
	        
	       
			return Constants.KEYWORD_PASS;
	}
	
	
//it verify that certain element is not exist in a page
	public String elementNotExist(String object,String data){
	       APP_LOGS.debug("Checking non-existance of element");
	       try{
	    	   if(driver.findElements(By.xpath(object)).size()==0);
	    	   return Constants.KEYWORD_PASS;
	    		     
			   }catch(Exception e){
				   return Constants.KEYWORD_FAIL+" Object exist in page"; 
			  }
	       
	     
			
	}
	
	
	
	
	/*public  String synchronize(String object,String data){
		APP_LOGS.debug("Waiting for page to load");
		((JavascriptExecutor) driver).executeScript(
        		"function pageloadingtime()"+
        				"{"+
        				"return 'Page has completely loaded'"+
        				"}"+
        		"return (window.onload=pageloadingtime());");
        
		return Constants.KEYWORD_PASS;
	}*/
	
	public  String waitForElementVisibility(String object,String data){
		APP_LOGS.debug("Waiting for an element to be visible");
		int start=0;
		int time=(int)Double.parseDouble(data);
		try{
		 while(time == start){
			if(driver.findElements(By.xpath(OR.getProperty(object))).size() == 0){
				Thread.sleep(1000L);
				start++;
			}else{
				break;
			}
		 }
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+"Unable to close browser. Check if its open"+e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}
	
	//Method to close the browser
	public  String closeBrowser(String object, String data){
		APP_LOGS.debug("Closing the browser");
		try{
			driver.quit();
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+"Unable to close browser. Check if its open"+e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}
	
	//To pause the execution for sometime
	public String pause(String object, String data) throws NumberFormatException, InterruptedException{
		long time = (long)Double.parseDouble(object);
		Thread.sleep(time*1000L);
		return Constants.KEYWORD_PASS;
	}
	//temporary function to upload but not reliable, its not that optimum to use it has a Script of AutoIT
	public String uploadFile(String object, String data) throws IOException {
		APP_LOGS.debug("Executing AutoIT script");
	
		try{
		Runtime.getRuntime().exec(CONFIG.getProperty(data));
		Thread.sleep(5000L);
		return Constants.KEYWORD_PASS;
		}
		catch(Exception e){
			return Constants.KEYWORD_FAIL +"no script found" +e.getMessage();
		}
		
	}
	//to switch to iframe but its not reliable,ID of frame should be given in object
	public String switchToFrame(String object, String data) throws IOException {
		APP_LOGS.debug("switching in iframe");
	
		try{
			driver.switchTo().frame(driver.findElement(By.id(object)));
		return Constants.KEYWORD_PASS;
		}
		catch(Exception e){
			return Constants.KEYWORD_FAIL +"not able to switch" +e.getMessage();
		}
		
	}
	//use to switch control back to window which was on iframe before
	public String switchBackToWindow(String object, String data) throws IOException {
		APP_LOGS.debug("switching back to window");
	
		try{
			driver.switchTo().defaultContent();
		return Constants.KEYWORD_PASS;
		}
		catch(Exception e){
			return Constants.KEYWORD_FAIL +"not able to switch to window back" +e.getMessage();
		}
		
	}
	
	//necessary in each project to capture screenshots
	public void captureScreenShot(String Filename) throws IOException {
		APP_LOGS.debug("taking screen shot according to config");
	    	  //capture screenshots
	  try{
			File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\"+Filename+".jpg"));
		 }
	  catch(Exception e)
	  {
		  APP_LOGS.debug("not able to take screen shots"+e.getMessage());
	  }
	}
	
	
		
	//Application Specific
	
	public String clickBrowseButton(String object,String data){
        APP_LOGS.debug("Clicking the browse button and typing data ");
        try{
        	
    
       driver.findElement(By.xpath(object)).sendKeys(data);
    
        
        }catch(Exception e){
			return Constants.KEYWORD_FAIL+" -- Not able to click on button"+e.getMessage();
        }
     
		return Constants.KEYWORD_PASS;
	}
	
	
	
	//store first window id then click on a link, switch to new window extract title
	//verify the title then switch to previous window
	public String clickSwitchVerifyTextSwitchBack(String object, String data){
		APP_LOGS.debug("switching to second tab");
	
	
			try{
			String expectedVal=data;
		    //Store the current window handle
	        String winHandleBefore = driver.getWindowHandle();

	        //Perform the click operation that opens new window
	        APP_LOGS.debug("clicking on link which open new window");
             driver.findElement(By.xpath(object)).click();
                Thread.sleep(3000);
             APP_LOGS.debug("clicked successfully");
	        		        
	        //Switch to new window opened
             APP_LOGS.debug("switching control to new window");
	        for(String winHandle : driver.getWindowHandles()){
	            driver.switchTo().window(winHandle);
	        }
	        	        
	        

	        // Perform the actions on new window
           String actualVal=  driver.getTitle();
           APP_LOGS.debug("verifying the title");
	            //Close the new window, if that window no more required
	    driver.close();
	   
	        //Switch back to original browser (first window)

	        driver.switchTo().window(winHandleBefore);
	        
	        if(expectedVal.equals(actualVal))
		    {
	        	APP_LOGS.debug("title verified");
		    }
	        return Constants.KEYWORD_PASS;
			}
	        //continue with original browser (first window)
          
		catch(Exception e)	
		{
			
		return Constants.KEYWORD_FAIL+"some problem"+e.getMessage();
		}
		
			//return Constants.KEYWORD_FAIL +"not able to switch" +e.getMessage();
		}
	
	
	// method to generate unique number and appending generated number with some static value to generate unique value every time
    public  String typeUniqueValue(String object,String data){
        APP_LOGS.debug("Typing a unique value" + object);
        try{

            //generate unique number using Random class
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(100000);

            driver.findElement(By.xpath(object)).click();
            driver.findElement(By.xpath(object)).clear();
            // (data+randomInt) generates unique value using static value of data and unique value of randomInt
            driver.findElement(By.xpath(object)).sendKeys(data+randomInt+"@asd.com");
        }catch(Exception e){
            return Constants.KEYWORD_FAIL+" Unable to Type unique value " + e.getMessage();
        }
        return Constants.KEYWORD_PASS;
    }
    
    public  String typeUniqueValueByID(String object,String data){
        APP_LOGS.debug("Typing a unique value" + object);
        try{

            //generate unique number using Random class
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(100000);

            driver.findElement(By.id(object)).click();
            driver.findElement(By.id(object)).clear();
            // (data+randomInt) generates unique value using static value of data and unique value of randomInt
            driver.findElement(By.id(object)).sendKeys(data+randomInt+"@asd.com");
        }catch(Exception e){
            return Constants.KEYWORD_FAIL+" Unable to Type unique value " + e.getMessage();
        }
        return Constants.KEYWORD_PASS;
    }
    
    
    public  String typeUniqueText(String object,String data){
        APP_LOGS.debug("Typing a unique value" + object);
        try{

            //generate unique number using Random class
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(100000);

            driver.findElement(By.xpath(object)).click();
            driver.findElement(By.xpath(object)).clear();
            // (data+randomInt) generates unique value using static value of data and unique value of randomInt
            driver.findElement(By.xpath(object)).sendKeys(data+randomInt);
        }catch(Exception e){
            return Constants.KEYWORD_FAIL+" Unable to Type unique value " + e.getMessage();
        }
        return Constants.KEYWORD_PASS;
    }
    
    public  String typeUniqueTextByID(String object,String data){
        APP_LOGS.debug("Typing a unique value" + object);
        try{

            //generate unique number using Random class
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(100000);

            driver.findElement(By.id(object)).click();
            driver.findElement(By.id(object)).clear();
            // (data+randomInt) generates unique value using static value of data and unique value of randomInt
            driver.findElement(By.id(object)).sendKeys(data+randomInt);
        }catch(Exception e){
            return Constants.KEYWORD_FAIL+" Unable to Type unique value " + e.getMessage();
        }
        return Constants.KEYWORD_PASS;
    }
}
	
	
	
	

	

