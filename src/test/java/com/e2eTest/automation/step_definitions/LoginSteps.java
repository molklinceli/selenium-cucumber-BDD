package com.e2eTest.automation.step_definitions;

import org.junit.jupiter.api.Assertions;

import com.e2eTest.automation.page_objects.LoginPage;
import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	LoginPage loginPage = new LoginPage();
	ConfigFileReader configFileReader = new ConfigFileReader();
	
	@Given("Je me connecte sur le site Web Demo Shop")
	public void jeMeConnecteSurLeSiteWebDemoShop() {	 
		Setup.getDriver().get(configFileReader.getProperty("home.url"));
	}
	
	@When("Je clique sur le bouton Log in")
	public void jeCliqueSurLeBoutonLogIn() {	    
		LoginPage.getLoginBarMenu().click();
	}
	
	@When("Je saisis une adresse mail")
	public void jeSaisisUneAdresseMail() {	  
		LoginPage.getEmailField().sendKeys(configFileReader.getProperty("home.email"));
	}
	
	@When("Je saisis un mot de passe")
	public void jeSaisisUnMotDePasse() {	  
		LoginPage.getPasswordField().sendKeys(configFileReader.getProperty("home.password"));
	}
	
	@When("Je clique sur le bouton Login")
	public void jeCliqueSurLeBoutonLogin() {	    
		LoginPage.getLoginButton().click();
	}
	
	@Then("Je me redirige vers la page home {string}")
	public void jeMeRedirigeVersLaPageHome(String email) {	 
		String homePage = LoginPage.getHomePage().getText();
		Assertions.assertEquals(homePage, email);
	}

}
