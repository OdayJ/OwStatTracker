package jona.Selenium;

import jona.Heroes.FactorySettings;
import jona.Heroes.HeroSpecific;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ConnManager {
    WebDriver driver = new ChromeDriver();
    String playerUrl;
    String platform;
    String mode;
    String platformErr;
    String modeErr;
    Select heroesComboBox;

    public ConnManager(String url, String platform, String mode){
        playerUrl = url;
        this.platform = platform;
        this.mode = mode;
        platformErr = "Platform is already set to: " + platform;
        modeErr = "Mode is already set to: " + mode;
    }

    public void standBy(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    void startConnection(){
        driver.get(playerUrl);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div/div[2]/div/button[2]")).click();
        setPlatformAndMode();
    }

    void setPlatformAndMode(){


        if (platform.equals("pc")){
            try {
                driver.findElement(By.xpath("/html/body/div[1]/blz-section/div/div[3]/blz-button[1]")).click();
            } catch (ElementClickInterceptedException e){
                System.out.println(platformErr);
            }

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            if (mode.equals("quick")){
                try {
                    driver.findElement(By.xpath("/html/body/div[1]/div[1]/blz-section[1]/div[1]/blz-button[1]")).click();
                } catch (ElementClickInterceptedException e){
                    System.out.println(modeErr);
                }
            }

            if (mode.equals("competitive")){
                try {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/blz-section[1]/div[1]/blz-button[2]")));
                    button.click();
                    //driver.findElement(By.xpath("/html/body/div[1]/div[1]/blz-section[1]/div[1]/blz-button[2]")).click();
                } catch (ElementClickInterceptedException e){
                    System.out.println(modeErr);
                }
            }
        }

        if (platform.equals("console")){
            try{
                driver.findElement(By.xpath("/html/body/div[1]/blz-section/div/div[3]/blz-button[2]")).click();
            } catch (ElementClickInterceptedException e){
                System.out.println(platformErr);
            }

            if (mode.equals("quick")){
                try {
                    driver.findElement(By.xpath("/html/body/div[1]/div[2]/blz-section[1]/div[1]/blz-button[1]")).click();
                } catch (ElementClickInterceptedException e){
                    System.out.println(modeErr);
                }
            }

            if (mode.equals("competitive")){
                try{
                    driver.findElement(By.xpath("/html/body/div[1]/div[2]/blz-section[1]/div[1]/blz-button[2]")).click();
                } catch (ElementClickInterceptedException e){
                    System.out.println(modeErr);
                }
            }
        }
    }

    boolean validateCompPage(){
        try {
            if (driver.findElement(By.xpath("/html/body/div[1]/div[1]/blz-section[1]/div[3]")).isDisplayed()){
                System.out.println("No data was found.");
                return false;
            }

            return true;
        } catch (NoSuchElementException e){
            return true;
        }
    }

    void getChampions(){
        heroesComboBox = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[1]/blz-section[3]/div[4]/select")));
    }

    ArrayList<String> getListOfChampions(){
        getChampions();
        ArrayList<String> heroes = new ArrayList<>();

        for (int i = 1; i < heroesComboBox.getOptions().size(); i++){
            heroes.add(heroesComboBox.getOptions().get(i).getText());
        }

        return heroes;
    }

    HeroSpecific getHero(String heroName, String className){
        int i = setHero(heroName);
        String parentXPath = "/html/body/div[1]/div[1]/blz-section[3]/span[" + i + "]";
        int averageIndex = findXPath(parentXPath, "average");
        int gameIndex = findXPath(parentXPath, "game");

        if (i == -1 || averageIndex == -1 || gameIndex == -1){
            return null;
        }

        String averageXpath = parentXPath + "/div[" + averageIndex + "]";
        String gameXpath = parentXPath + "/div[" + gameIndex + "]";
        ArrayList<Object> averageHero = getChampionData(averageXpath, "stat-item");
        ArrayList<Object> gameHero = getChampionData(gameXpath, "stat-item");
        try {
            Time.valueOf(gameHero.get(1).toString());
        } catch (IllegalArgumentException e){
            gameHero.set(1, "00:" + gameHero.get(1).toString());
            if (Time.valueOf(gameHero.get(1).toString()).getTime() < Time.valueOf("00:10:00").getTime()){
                return null;
            }
        }
        return FactorySettings.createHero(heroName, className, averageHero, gameHero);
    }

    int setHero(String heroName){
        for (int i = 1; i < heroesComboBox.getOptions().size(); i++){
            if (heroesComboBox.getOptions().get(i).getText().toLowerCase().equals(heroName)){
                heroesComboBox.getOptions().get(i).click();
                return i + 1;
            }
        }
        return -1;
    }

    ArrayList<Object> getChampionData(String parentXpath, String childrenClassName){
        WebElement parentElement = driver.findElement(By.xpath(parentXpath));
        List<WebElement> children = parentElement.findElements(By.className(childrenClassName));
        ArrayList<Object> stats = new ArrayList<>();


        for (int i = 0; i < children.size(); i++){
            stats.add(children.get(i).findElement(By.className("name")).getAttribute("innerText"));
            stats.add(children.get(i).findElement(By.className("value")).getAttribute("innerText"));
        }

        return stats;
    }

    int findXPath(String parentXpath, String seekWord){
        WebElement parentElement = driver.findElement(By.xpath(parentXpath));
        List<WebElement> children = parentElement.findElements(By.className("header"));
        for (int i = 0; i < children.size(); i++){
            if (children.get(i).getText().toLowerCase().equals(seekWord)){
                return i + 1;
            }
        }
        return -1;
    }

    void endConnection(){
        driver.quit();
    }
}
