package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().editContact(1);
		ContactData contact = new ContactData();
		contact.address = "London";
		contact.email1 = "new email";
		contact.days = "-";
		contact.months = "-";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToMainPage();
	}
}
