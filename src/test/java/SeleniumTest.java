import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SeleniumTest {
    private ChromeDriver webDriver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*" /*", --headless"*/);
        this.webDriver = new ChromeDriver(chromeOptions);
        this.webDriver.get("https://chercher.tech/practice/dynamic-table");
        assertEquals("xpath Practice page", webDriver.getTitle());
    }

//    @Test
//    void buscarNoGoogle() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        var chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--remote-allow-origins=*", "--headless");
//        WebDriver webDriver = new ChromeDriver(chromeOptions);
//        webDriver.get("https://google.com");
//        assertEquals("Google", webDriver.getTitle());
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        var elementFound =  webDriver.findElement(By.name("q"));
//        elementFound.sendKeys("Java" + Keys.ENTER);
//        var txtBoxFound =  webDriver.findElement(By.name("q"));
//        assertEquals("Java", txtBoxFound.getText());
//        var pathElement = webDriver.findElement(By.xpath("//a/h3"));
//        var pathElements = webDriver.findElements(By.xpath("//a/h3"));
//        assertEquals("Java | Oracle", pathElement.getText());
//        pathElements.forEach(x -> System.out.println(x.getText()));
////        elementFound.submit();
////        var btnFound = webDriver.findElement(By.name("btnK"));
////        btnFound.click();
////        webDriver.close();
//    }

    @Test
    void deveTestarTituloPagina() {
        assertEquals("xpath Practice page", webDriver.getTitle());
    }

    @Test
    void deveTestarBotoes(){
        var elementFound =  webDriver.findElement(By.id("blue"));
        elementFound.click();
        var outputelement =  webDriver.findElement(By.id("output"));
        assertEquals("Blueberry", outputelement.getText());

        var elementFound2 =  webDriver.findElement(By.name("banana"));
        elementFound2.click();
        var outputelement2 =  webDriver.findElement(By.id("output"));
        assertEquals("Banana", outputelement2.getText());

        var elementFound3 =  webDriver.findElement(By.xpath("//button[contains(text(), 'Strawberry')]"));
        elementFound3.click();
        var outputelement3 =  webDriver.findElement(By.id("output"));
        assertEquals("Strawberry", outputelement3.getText());

        var elementFound4 =  webDriver.findElement(By.xpath("//button[contains(text(), 'Apple')]"));
        elementFound4.click();
        var outputelement4 =  webDriver.findElement(By.id("output"));
        assertEquals("Apple", outputelement4.getText());

        var elementFound5 =  webDriver.findElement(By.xpath("//button[contains(text(), 'Orange')]"));
        elementFound5.click();
        var outputelement5 =  webDriver.findElement(By.id("output"));
        assertEquals("Orange", outputelement5.getText());

        var elementFound6 =  webDriver.findElement(By.xpath("//button[contains(text(), 'Grape')]"));
        elementFound6.click();
        var outputelement6 =  webDriver.findElement(By.id("output"));
        assertEquals("Grape", outputelement6.getText());

        var elementFound7 =  webDriver.findElement(By.xpath("//button[contains(text(), 'Pie')]"));
        elementFound7.click();
        var outputelement7 =  webDriver.findElement(By.id("output"));
        assertEquals("Pie", outputelement7.getText());

        var elementFound8 =  webDriver.findElement(By.xpath("//button[contains(text(), 'Burger')]"));
        elementFound8.click();
        var outputelement8 =  webDriver.findElement(By.id("output"));
        assertEquals("Burger", outputelement8.getText());

        var elementFound9 =  webDriver.findElement(By.xpath("//button[contains(text(), 'Juice')]"));
        elementFound9.click();
        var outputelement9 =  webDriver.findElement(By.id("output"));
        assertEquals("Juice", outputelement9.getText());

        var elementFound10 =  webDriver.findElement(By.xpath("//button[contains(text(), 'banana')]"));
        elementFound10.click();
        var outputelement10 =  webDriver.findElement(By.id("output"));
        assertEquals("banana", outputelement10.getText());

        var elementFound11 =  webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[1]/div[4]/button[2]"));
        elementFound11.click();
        var outputelement11 =  webDriver.findElement(By.id("output"));
        assertEquals("Banana"+"\n" + "Shake", outputelement11.getText());

        var elementFound12 =  webDriver.findElement(By.xpath("//button[contains(text(), 'Banana " + '"' + "Juice')]"));
        elementFound12.click();
        var outputelement12 =  webDriver.findElement(By.id("output"));
        assertEquals("Banana " + '"' + "Juice", outputelement12.getText());

        var elementFound13 =  webDriver.findElement(By.xpath("//input[@value='Zack    Snyder']"));
        elementFound13.click();
        var outputelement13 =  webDriver.findElement(By.id("output"));
        assertEquals("Zack Snyder", outputelement13.getText());
    }

    @Test
    void deveTestarCheckBox(){
        WebElement checkboxGoogle = webDriver.findElement(By.xpath("//td[contains(text(), 'google.com')]/preceding-sibling::td/input[@type='checkboxGoogle']"));
        String locationGoogle = checkboxGoogle.getLocation().toString();

        checkboxGoogle.click();

        webDriver.navigate().refresh();
        checkboxGoogle = webDriver.findElement(By.xpath("//td[contains(text(), 'google.com')]/preceding-sibling::td/input[@type='checkboxGoogle']"));
        assertNotEquals(locationGoogle, checkboxGoogle.getLocation().toString());

    }


}
