package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */

     public static void enterText(WebElement input, String text){
        try {
            input.clear();
            input.sendKeys(text);
        } catch (Exception e) {
            // TODO: handle exception
            e.getStackTrace();
        }
     }

     public static String radioTextFun(String radioText){
        try {
            return radioText;
        } catch (Exception e) {
            // TODO: handle exception
            e.getStackTrace();
        }
        return radioText;
     }

     public static void checkBoxClick(List<WebElement> inputs, String text){
        try {
            for(WebElement value : inputs){
            if(value.getText().equalsIgnoreCase(text)){  
            value.click();
            //Thread.sleep(3000);
            }
            
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.getStackTrace();
        }
     }

     public static void dropdownClick(List<WebElement> inputs, String text){
        try {
            for(WebElement value : inputs){
            if(value.getText().equalsIgnoreCase(text)){  
            value.click();
            //Thread.sleep(3000);
            }
            
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.getStackTrace();
        }
     }

     public static String getLocalDate(){
        LocalDate currentDate = LocalDate.now();
        // Subtract 7 days
        LocalDate minus7days = currentDate.minusDays(7);
        
        DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = minus7days.format(dtformat);
        System.out.println(formattedDate);
        return formattedDate;  
        
     }

     public static String getLocalTime() {
    // Get current time
    LocalTime currentTime = LocalTime.now();
    
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    
    String formattedTime = currentTime.format(timeFormatter);
    return formattedTime;
}


     
     


}
