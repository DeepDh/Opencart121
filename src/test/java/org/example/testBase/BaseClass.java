package org.example.testBase;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;


public class BaseClass {

    public WebDriver driver;
    public Logger logger;
    public Properties prop;

    @BeforeClass(groups = {"Sanity", "Regression", "Master"})
    @Parameters({"os", "browser"})
    public void setUp(String os, String br) throws IOException {

        FileInputStream file = new FileInputStream("src/test/resources/config.properties");
        prop = new Properties();
        prop.load(file);

        logger = LogManager.getLogger(this.getClass());

        if (prop.getProperty("execution_env").equalsIgnoreCase("remote")) {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            //OS
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("No matching OS");
                return;
            }

            //Browser
            switch (br.toLowerCase()) {

                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;

                case "edge":
                    System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;

                default:
                    System.out.println("Invalid browser name: " + br);
                    return;
            }

            driver=new RemoteWebDriver(new URL("https://localhost:4444/Wd/Hub"), capabilities);
        }

        if (prop.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (br.toLowerCase()) {

                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "edge":
                    System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;

                default:
                    System.out.println("Invalid browser name: " + br);
                    return;
            }

            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get(prop.getProperty("appURL"));
            driver.manage().window().maximize();
        }
    }
    @AfterClass(groups = {"Sanity", "Regression", "Master"})
    public void tearDown() {
        driver.quit();
    }

    public String randomeString()
    {
        String generatedstring;
        generatedstring = RandomStringUtils.randomAlphabetic(5);
        return generatedstring;
    }

    public String randomeNumber()
    {
        String generatedNumber;
        generatedNumber = RandomStringUtils.randomNumeric(10);
        return generatedNumber;
    }

    public String randomePassword()
    {
        String generatedPassword;
        generatedPassword = RandomStringUtils.randomAlphanumeric(10);
        return generatedPassword;
    }
}
