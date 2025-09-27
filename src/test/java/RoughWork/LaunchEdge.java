package RoughWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchEdge {
    public static void main(String[] args) {
        // Launch Edge
        System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");

        System.out.println("Page title: " + driver.getTitle());
        driver.quit();
    }
}
