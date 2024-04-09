package org.stepdefinition;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.base.BaseClass;
import org.configuration.PropertiesReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pom.CloudBankRepository;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {
	public static CloudBankRepository pom;

	@Given("user logged in to the website")
	public void Tc01() {
		try {
			pom = new CloudBankRepository();
			WebElement userName = pom.getUserName();
			String user = PropertiesReader.getProperty("username");
			userName.sendKeys(user);
			WebElement password = pom.getPassword();
			String pass = PropertiesReader.getProperty("password");
			password.sendKeys(pass);
			WebElement login = pom.getLogin();
			login.click();
			System.out.println("User Successfully logged into the application");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("user navigate to the Clients menu and select {string}")
	public void Tc03(String clients) {

		try {
			pom = new CloudBankRepository();
			Thread.sleep(2000);
			WebElement clientDropDown = pom.getClientDropDown();
			actionMoveTo(clientDropDown);
			List<WebElement> client = pom.getClients();
			for (int i = 0; i < client.size(); i++) {
				WebElement webElement = client.get(i);
				String text = webElement.getText();
				if (text.contains(clients)) {
					webElement.click();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("user open the create client and fills the details {string} , {string},{string},{string},{string},{string},{string},{string},{string}")
	public void Tc04(String legal, String first, String mobile, String gender, String clientType, String familyName,
			String relation, String addressType, String street) {
		try {
			pom = new CloudBankRepository();
			WebElement createClient = pom.getCreateClient();
			createClient.click();
			WebElement legalForm = pom.getLegalForm();
			elementVisible(legalForm);
			selectByVisibleText(legalForm, legal);
			WebElement firstName = pom.getFirstName();
			firstName.sendKeys(first);
			WebElement mobileNo = pom.getMobileNo();
			mobileNo.sendKeys(mobile);
			Thread.sleep(2000);
			WebElement gender2 = pom.getGender();
			elementVisible(gender2);
			Thread.sleep(2000);
			actionMoveTo(gender2);
			Thread.sleep(2000);
			selectByValue(gender2, gender);
			Thread.sleep(2000);
			
			WebElement familyMembersButton = pom.getFamilyMembersButton();
			Thread.sleep(2000);
			actionMoveTo(familyMembersButton);
			familyMembersButton.click();
			WebElement familyFirstName = pom.getFamilyFirstName();
			Thread.sleep(2000);
			actionMoveTo(familyFirstName);
			familyFirstName.sendKeys(familyName);
			WebElement relationshipDropDown = pom.getRelationshipDropDown();
			elementVisible(relationshipDropDown);
			Thread.sleep(2000);
			actionMoveTo(relationshipDropDown);
			selectByVisibleText(relationshipDropDown, relation);

			WebElement addressButton = pom.getAddressButton();
			Thread.sleep(2000);
			actionMoveTo(addressButton);
			addressButton.click();
			WebElement addressTypeDropDown = pom.getAddressTypeDropDown();
			elementVisible(addressTypeDropDown);
			Thread.sleep(2000);
			actionMoveTo(addressTypeDropDown);
			selectByVisibleText(addressTypeDropDown, addressType);
			pom.getStreet().sendKeys(street);
			pom.getSubmit().click();
			System.out.println("user create the client and fill the form");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("user activates the client")
	public void Tc05() {
		try {
			pom = new CloudBankRepository();
			WebElement clientID = pom.getClientID();
			System.out.println("Client id: "+clientID.getText());
			pom.getActivateClient().click();
			pom.getActivationDate().click();
			LocalDate currentDate = LocalDate.now();
	        int dayOfMonth = currentDate.getDayOfMonth();
	        String formattedDayOfMonth = (dayOfMonth < 10 ? "0" + dayOfMonth : String.valueOf(dayOfMonth));
			List<WebElement> selectActivationDate = pom.getSelectActivationDate();
			for (int i = 0; i < selectActivationDate.size(); i++) {
				WebElement webElement = selectActivationDate.get(i);
				String text = webElement.getText();
				if (text.equals(formattedDayOfMonth)) {
					webElement.click();
				}
			}
			pom.getActivateClientSubmit().click();
			System.out.println("User successfully activates the client");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("user creates new client and fills the form {string} , {string} ,{string}")
	public void Tc06(String productType, String accountType, String repaymentMode) {
		try {
			pom = new CloudBankRepository();
			pom.getNewLoan().click();
			WebElement product = pom.getProduct();
			elementVisible(product);
			selectByVisibleText(product, productType);
			Thread.sleep(3000);
			WebElement newAccountType = pom.getNewAccountType();
			elementVisible(newAccountType);
			Thread.sleep(2000);
			Select select = new Select(newAccountType);
			jsSelect(newAccountType, accountType);
			pom.getDisbursementDate().click();
			LocalDate currentDate = LocalDate.now();
	        int dayOfMonth = currentDate.getDayOfMonth();
	        String formattedDayOfMonth = (dayOfMonth < 10 ? "0" + dayOfMonth : String.valueOf(dayOfMonth));
			List<WebElement> selectDisbursementDate = pom.getSelectDisbursementDate();
			for (int i = 0; i < selectDisbursementDate.size(); i++) {
				WebElement webElement = selectDisbursementDate.get(i);
				String text = webElement.getText();
				if (text.equals(formattedDayOfMonth)) {
					webElement.click();
				}
			}
			WebElement repaymentMode1 = pom.getRepaymentMode();
			elementVisible(repaymentMode1);
			selectByVisibleText(repaymentMode1, repaymentMode);
			pom.getNextDetails().click();
			System.out.println("User fills the new client form");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("user fill in mandatory values on the {string} page:")
	public void Tc07(String string, io.cucumber.datatable.DataTable dataTable) {
		try {
			pom = new CloudBankRepository();
			Map<String, String> data = dataTable.asMap(String.class, String.class);
			String principal = data.get("Principal");
			String loanTerm = data.get("Loan Term");
			String numberOfRepayments = data.get("Number of repayments");
			String repaidEveryMonth = data.get("Repaid every Month");
			String repaidEveryDay1 = data.get("Repaid every day 1");
			String repaidEveryDay2 = data.get("Repaid every day 2");
			String interestRate = data.get("Nominal interest rate");
			String amortization = data.get("Amortization");
			String calculationPeriod = data.get("Interest calculation period");
			String brokenPeriod = data.get("Broken Period Interest");
			String repaymentStrategy = data.get("Repayment strategy");

			WebElement principal2 = pom.getPrincipal();
			principal2.clear();
			principal2.sendKeys(principal);
			WebElement loanTerm2 = pom.getLoanTerm();
			loanTerm2.clear();
			loanTerm2.sendKeys(loanTerm);
			WebElement numberOfRepayments2 = pom.getNumberOfRepayments();
			numberOfRepayments2.clear();
			numberOfRepayments2.sendKeys(numberOfRepayments);
			WebElement repaymentEveryMonth = pom.getRepaymentEveryMonth();
			repaymentEveryMonth.clear();
			repaymentEveryMonth.sendKeys(repaidEveryMonth);
			WebElement repaymentEveryDay1 = pom.getRepaymentEveryDay1();
			elementVisible(repaymentEveryDay1);
			selectByVisibleText(repaymentEveryDay1, repaidEveryDay1);
			WebElement repaymentEveryDay2 = pom.getRepaymentEveryDay2();
			elementVisible(repaymentEveryDay2);
			selectByVisibleText(repaymentEveryDay2, repaidEveryDay2);
			WebElement interestRate2 = pom.getInterestRate();
			interestRate2.clear();
			interestRate2.sendKeys(interestRate);
			WebElement amortization2 = pom.getAmortization();
			elementVisible(amortization2);
			selectByVisibleText(amortization2, amortization);
			WebElement interestCalculationPeriod = pom.getInterestCalculationPeriod();
			elementVisible(interestCalculationPeriod);
			selectByVisibleText(interestCalculationPeriod, calculationPeriod);
			WebElement brokenPeriodInterestCalculation = pom.getBrokenPeriodInterestCalculation();
			elementVisible(brokenPeriodInterestCalculation);
			selectByVisibleText(brokenPeriodInterestCalculation, brokenPeriod);
			WebElement repaymentStrategy2 = pom.getRepaymentStrategy();
			elementVisible(repaymentStrategy2);
			selectByVisibleText(repaymentStrategy2, repaymentStrategy);
			pom.getNextTerm().click();
			System.out.println("user Succesfully fills the mandatory pages in Terms");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("user navigate through lenders {string} and charges page")
	public void Tc08(String lenName) {
		try {
			pom = new CloudBankRepository();
			pom.getLendersName().sendKeys(lenName);
			pom.getNextLenders().click();
			pom.getNextCharges().click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("user review the loan summary {string}")
	public void Tc10(String status) {
		try {
			pom = new CloudBankRepository();
			screenShot("review1");
			WebElement submitReview = pom.getSubmitReview();
			actionMoveTo(submitReview);
			Thread.sleep(2000);
			screenShot("review2");
			submitReview.click();
			WebElement loanNumber = pom.getLoanNumber();
			System.out.println("Loan Number"+loanNumber.getText());
			WebElement loanStatus = pom.getLoanStatus();
			String text = loanStatus.getText();
			if (text.contains(status)) {
				System.out.println("The loan in approval pending stage");
			}
			pom.getApproveLoan().click();
			pom.getSubmitApproveLoan().click();
			System.out.println("User successfullly review the loan summary");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Then("the loan should be created successfully  {string}")
	public void Tc11(String status) {
		try {
			pom = new CloudBankRepository();
			WebElement loanStatus = pom.getLoanStatus();
			String text = loanStatus.getText();
			if (text.contains(status)) {
				System.out.println("Loan status matched Successfully cleared");
				System.out.println(text);
			}
			Thread.sleep(2000);
			screenShot("Loan Created");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			screenShot("Loan NOt Created");
		}
	}

}
