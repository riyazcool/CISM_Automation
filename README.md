# CISM_Automation

Prequisites to run the code
a) Download the selenium web Driver from the following link https://selenium-release.storage.googleapis.com/index.html?path=3.150/ 
b) The recommended one is IEDriverServer_x64_3.150.0 for 64 bit wondows
c) After downloading in line no: 33 of App.Java main file
    -->Add the downloaded file path in System.setProperty ForExample:
        System.setProperty("webdriver.ie.driver","YourSeleniumWebDriverFilePath\\IEDriverServer.exe");
d)If you are using maven, add the following dependancy in the pom.xml file
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>4.0.0-alpha-2</version>
  	</dependency>

        
