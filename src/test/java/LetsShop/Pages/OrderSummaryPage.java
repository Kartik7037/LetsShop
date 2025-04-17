package LetsShop.Pages;

import org.openqa.selenium.By;

import Utilities.Components;

public class OrderSummaryPage extends Components{
     protected By orderId = By.xpath("//small[text()='Order Id']/following-sibling::div");
     
     public String getOrderID() {
    	 return getElement(orderId).getText();
     }
}
