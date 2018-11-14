import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\TECH-W84.LAPTOP-FCCNLJDE\\Documents\\Engineering18\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        QAToolsForm form = new QAToolsForm(driver);
        form.goToQAFormPage();
        form.selectContinent("Europe");
        System.out.println(form.checkSelectedContinent("Europe"));
        form.setFirstName("Daniel");
        System.out.println(form.checkFirstName("Daniel"));
        form.setLastName("Blake");
        System.out.println(form.checkLastName("Blake"));
        form.selectYearsOfExperience("5");
        System.out.println(form.checkYearOfExperience("5"));
    }
}
