package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testNonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().gotoContactsPage();
    
    ContactData group = new ContactData();
    group.contact_name = "Contact name 1";
    group.lastname = "Last name 1";
    group.address = "Saint-Petersburg";
    group.home_number = "111";
    group.mobile_number = "222";
    group.work_number = "333";
    group.email1 = "example@yandex.ru";
    group.email2 = "example2@yandex.ru";
    group.days = "1";
    group.months = "January";
    group.years = "1987";
    
    app.getContactHelper().fillContactForm(group);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToMainPage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	    app.getNavigationHelper().openMainPage();
	    app.getContactHelper().gotoContactsPage();
	    app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", ""));
	    app.getContactHelper().submitContactCreation();
	    app.getContactHelper().returnToMainPage();
	  }
}
