import com.thoughtworks.selenium.webdriven.ElementFinder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Test {

    enum Currencies {
        EUR(5),
        AUD(2),
        CAD(3),
        DKK(4);

        private final int row;

        Currencies (final int newRow){
            row = newRow;
        }

        public int getRow(){
            return row;
        }
    }

    public static void main(String[] args) {
        Currencies currency = Currencies.EUR;

        System.setProperty("webdriver.chrome.driver", "D:\\Google disk\\Java\\chromedriver.exe");
        // Je potřeba si nastavit svou cestu k chromedriveru.exe

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.sberbank.cz");
        webDriver.findElement(By.xpath("//a[@href ='/cs-cz/poplatky-a-sazby/kurzy']")).click();

        System.out.println(webDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[3]/table/tbody/tr[" + currency.getRow() + "]/td[1]/span")).getText());
    }
}
