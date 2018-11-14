import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class QAToolsForm {
    private WebDriver driver;

    private String qaToolsFormUrl = "http://toolsqa.com/automation-practice-form/";
    private By continentDropDownListID = By.id("continents");
    private By continentDropDownListOptionsCssSelector = By.cssSelector("#continents option");
    private By yearsOfExperienceListCssSelector = By.cssSelector(".control-label input");
    private By firstNameID = By.name("firstname");
    private By lastNameID = By.name("lastname");



    public QAToolsForm(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void goToQAFormPage(){
        driver.navigate().to(qaToolsFormUrl);
    }

    public void inputFirstName(String name){

    }
    public void selectContinent(String continent){
        List<String> continents = getContinentStringList();

            if(continents.contains(continent)) {
                Select continentSelect = new Select(driver.findElement(continentDropDownListID));
                continentSelect.selectByVisibleText(continent);
            } else if (!continents.contains(continent)) {
                System.out.println("Please select one of the below options");
                for (String continentName : continents) {
                    System.out.println(continentName);
                }
            }
        }
    private List<String> getContinentStringList(){
        List<WebElement> continentOptions = driver.findElements(continentDropDownListOptionsCssSelector);
        List<String> continentStringList = new ArrayList<>();
        for(WebElement continent : continentOptions){
            continentStringList.add(continent.getText());
        } return continentStringList;
    }

    // Method validators

    public boolean checkSelectedContinent(String continent){
        boolean selected = false;

        Select continentSelect = new Select(driver.findElement(continentDropDownListID));
        selected = continentSelect.getFirstSelectedOption().getText().equals(continent);
        return selected;
    }

    public void selectYearsOfExperience(String num){
        int newNum = Integer.parseInt(num) - 1;
        String newNumString = Integer.toString(newNum);
        By yearsOfExperienceListID = By.id(("exp-"+newNumString));
        if(newNum <= 7) {
            driver.findElement(yearsOfExperienceListID).click();
        } else {
            System.out.println("please select a number from 1-7");
        }
    }

    public void setFirstName(String name){
        driver.findElement(firstNameID).sendKeys(name);
    }
    public void setLastName(String name){
        driver.findElement(lastNameID).sendKeys(name);
    }
    public boolean checkFirstName(String name){
        String inputField = driver.findElement(firstNameID).getAttribute("value").trim();
        if(name.equals(inputField)){
            return true;
        } else {
            return false;
        }
    }
    public boolean checkLastName(String name){
        String inputField = driver.findElement(lastNameID).getAttribute("value").trim();
        if(name.equals(inputField)){
            return true;
        } else {
            return false;
        }
    }
    public boolean checkYearOfExperience(String num){
        int newNum = Integer.parseInt(num) - 1;
        String newNumString = Integer.toString(newNum);
        By yearsOfExperienceListID = By.id(("exp-"+newNumString));
        String selectedValue = driver.findElement(yearsOfExperienceListID).getAttribute("value");
        if(num.equals(selectedValue)){
            return true;
        }
        else {
            return false;
        }
    }
}


//name and validator
//radio button and validator
