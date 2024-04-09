package org.pom;

import java.time.Duration;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudBankRepository extends BaseClass {

	public CloudBankRepository() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "uid")
	private WebElement userName;

	public WebElement getUserName() {
		return userName;
	}

	@FindBy(id = "pwd")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath = "//button[@id='login-button'][text()='Sign In']")
	private WebElement login;

	public WebElement getLogin() {
		return login;
	}

	@FindBy(id = "client-dropdown")
	private WebElement clientDropDown;

	public WebElement getClientDropDown() {
		return clientDropDown;
	}

	@FindBy(xpath = "//a[@id='client-dropdown']/following-sibling::ul/li")
	private List<WebElement> client;

	public List<WebElement> getClients() {
		return client;
	}

	@FindBy(xpath = "//a[@has-permission='CREATE_CLIENT']")
	private WebElement createClient;

	public WebElement getCreateClient() {
		return createClient;
	}

	@FindBy(id = "legalFormId")
	private WebElement legalForm;

	public WebElement getLegalForm() {
		return legalForm;
	}

	@FindBy(id = "firstname")
	private WebElement firstName;

	public WebElement getFirstName() {
		return firstName;
	}

	@FindBy(id = "mobileNo")
	private WebElement mobileNo;

	public WebElement getMobileNo() {
		return mobileNo;
	}

	@FindBy(xpath = "//select[@id='genderId']")
	private WebElement gender;

	public WebElement getGender() {
		return gender;
	}

	@FindBy(xpath = "//select[@id='genderId']/following-sibling::div//li")
	private List<WebElement> selectGender;

	public List<WebElement> getSelectGender() {
		return selectGender;
	}

	@FindBy(xpath = "//select[@id='clienttypeId']/parent::div")
	private WebElement clientType1;

	public WebElement getClientType1() {
		return clientType1;
	}

	@FindBy(id = "clientTypeId")
	private WebElement clientType;

	public WebElement getClientType() {
		return clientType;
	}

	@FindBy(id = "//select[@id='clienttypeId']/following-sibling::div//li")
	private List<WebElement> selectClientType;

	public List<WebElement> getSelectClientType() {
		return selectClientType;
	}

	@FindBy(id = "clientClassificationId")
	private WebElement clientClassification;

	public WebElement getClientClassification() {
		return clientClassification;
	}

	@FindBy(xpath = "//strong[text()='Family Members']/following-sibling::button")
	private WebElement familyMembersButton;

	public WebElement getFamilyMembersButton() {
		return familyMembersButton;
	}

	@FindBy(xpath = "//div[@class='col-sm-3']//input[@id='firstName']")
	private WebElement familyFirstName;

	public WebElement getFamilyFirstName() {
		return familyFirstName;
	}

	@FindBy(id = "relationshipId")
	private WebElement relationShipDropDown;

	public WebElement getRelationshipDropDown() {
		return relationShipDropDown;
	}

	@FindBy(xpath = "//button[@ng-click='addAddress()']")
	private WebElement addressButton;

	public WebElement getAddressButton() {
		return addressButton;
	}

	@FindBy(xpath = "//select[@name='addressType0']")
	private WebElement addressTypeDropDown;

	public WebElement getAddressTypeDropDown() {
		return addressTypeDropDown;
	}

	@FindBy(xpath = "//span[text()='Select Address Type']/parent::a/following-sibling::div//ul/li")
	private List<WebElement> selectAddressType;

	public List<WebElement> getSelectAddressType() {
		return selectAddressType;
	}

	@FindBy(xpath = "//input[@name='street0']")
	private WebElement street;

	public WebElement getStreet() {
		return street;
	}

	@FindBy(xpath = "//div[@class='footer-btn']//button[@type='submit']")
	private WebElement submit;

	public WebElement getSubmit() {
		return submit;
	}

	@FindBy(xpath = "//small[@class='ng-binding']")
	private WebElement clientId;

	public WebElement getClientID() {
		return clientId;
	}

	@FindBy(xpath = "//a[@has-permission='ACTIVATE_CLIENT']")
	private WebElement activateClient;

	public WebElement getActivateClient() {
		return activateClient;
	}

	@FindBy(xpath = "//div[@class='form-group']//input[@datepicker-pop='dd MMMM yyyy']")
	private WebElement activationDate;

	public WebElement getActivationDate() {
		return activationDate;
	}

	@FindBy(xpath = "//div[@class='form-group']//td[@ng-repeat='dt in row']//span")
	private List<WebElement> selectActivationDate;

	public List<WebElement> getSelectActivationDate() {
		return selectActivationDate;
	}

	@FindBy(xpath = "//button[@has-permission='ACTIVATE_CLIENT']")
	private WebElement activateClientSubmit;

	public WebElement getActivateClientSubmit() {
		return activateClientSubmit;
	}

	@FindBy(xpath = "//a[@has-permission='CREATE_LOAN']")
	private WebElement newLoan;

	public WebElement getNewLoan() {
		return newLoan;
	}

	@FindBy(id = "productId")
	private WebElement product;

	public WebElement getProduct() {
		return product;
	}

	@FindBy(xpath = "//select[@id='accountTypeId']")
	private WebElement newAccountType;

	public WebElement getNewAccountType() {
		return newAccountType;
	}

	@FindBy(id = "expectedDisbursementDate")
	private WebElement disbursementDate;

	public WebElement getDisbursementDate() {
		return disbursementDate;
	}

	@FindBy(xpath = "//label[@title='Expected disbursement on']/parent::td/following-sibling::td//span")
	private List<WebElement> selectDisbursementDate;

	public List<WebElement> getSelectDisbursementDate() {
		return selectDisbursementDate;
	}

	@FindBy(id = "repaymentModeId")
	private WebElement repaymentMode;

	public WebElement getRepaymentMode() {
		return repaymentMode;
	}

	@FindBy(xpath = "//label[text()='Repayment Mode']/parent::td/following-sibling::td//li[text()='Cash/Cheque']")
	private WebElement selectRepaymentMode;

	public WebElement getSelectRepaymentMode() {
		return selectRepaymentMode;
	}

	@FindBy(xpath = "//h3[text()='Savings Linkage']/parent::div/following-sibling::button[contains(text(),'Next')]")
	private WebElement nextDetails;

	public WebElement getNextDetails() {
		return nextDetails;
	}

	@FindBy(xpath = "//input[@id='principal']")
	private WebElement principal;

	public WebElement getPrincipal() {
		return principal;
	}

	@FindBy(id = "loanTermFrequency")
	private WebElement loanTerm;

	public WebElement getLoanTerm() {
		return loanTerm;
	}

	@FindBy(id = "numberOfRepayments")
	private WebElement numberOfRepayments;

	public WebElement getNumberOfRepayments() {
		return numberOfRepayments;
	}

	@FindBy(id = "repaymentEvery")
	private WebElement repaymentEveryMonth;

	public WebElement getRepaymentEveryMonth() {
		return repaymentEveryMonth;
	}

	@FindBy(id = "repaymentFrequencyNthDayType")
	private WebElement repaymentEveryDay1;

	public WebElement getRepaymentEveryDay1() {
		return repaymentEveryDay1;
	}

	@FindBy(id = "repaymentFrequencyDayOfWeekType")
	private WebElement repaymentEveryDay2;

	public WebElement getRepaymentEveryDay2() {
		return repaymentEveryDay2;
	}

	@FindBy(id = "interestRatePerPeriod")
	private WebElement interestRate;

	public WebElement getInterestRate() {
		return interestRate;
	}

	@FindBy(id = "amortizationType")
	private WebElement amortization;

	public WebElement getAmortization() {
		return amortization;
	}

	@FindBy(id = "interestCalculationPeriodType")
	private WebElement interestCalculationPeriod;

	public WebElement getInterestCalculationPeriod() {
		return interestCalculationPeriod;
	}

	@FindBy(id = "brokenPeriodInterestCalculationType")
	private WebElement brokenPeriodInterestCalculation;

	public WebElement getBrokenPeriodInterestCalculation() {
		return brokenPeriodInterestCalculation;
	}

	@FindBy(id = "transactionProcessingStrategyId")
	private WebElement repaymentStrategy;

	public WebElement getRepaymentStrategy() {
		return repaymentStrategy;
	}

	@FindBy(xpath = "//label[text()='Recalculate Interest']/ancestor::table/following-sibling::button[@type='submit']")
	private WebElement nextTerm;

	public WebElement getNextTerm() {
		return nextTerm;
	}

	@FindBy(xpath = "//input[@id='new-lender']")
	private WebElement lendersName;

	public WebElement getLendersName() {
		return lendersName;
	}

	@FindBy(xpath = "//input[@id='new-lender']/ancestor::div[@class='col-md-12']/following-sibling::button[@type='submit']")
	private WebElement nextLenders;

	public WebElement getNextLenders() {
		return nextLenders;
	}

	@FindBy(xpath = "//a[@ng-hide='previewRepayment']/ancestor::div[@ng-show='loanaccountinfo']/following-sibling::button[@type='submit']")
	private WebElement nextCharges;

	public WebElement getNextCharges() {
		return nextCharges;
	}

	@FindBy(xpath = "//strong[text()='Details']/ancestor::table/following-sibling::div//button[@id='save']")
	private WebElement submitReview;

	public WebElement getSubmitReview() {
		return submitReview;
	}

	@FindBy(xpath = "//i[@ng-show='loandetails.inArrears']/parent::strong")
	private WebElement loanNumber;

	public WebElement getLoanNumber() {
		return loanNumber;
	}

	@FindBy(xpath = "//div[@class='loan-status-card']//span[@class='user-status ng-binding']")
	private WebElement loanStatus;

	public WebElement getLoanStatus() {
		return loanStatus;
	}

	@FindBy(xpath = "//span[@has-permission='APPROVE_LOAN']")
	private WebElement approveLoan;

	public WebElement getApproveLoan() {
		return approveLoan;
	}

	@FindBy(xpath = "//button[@id='save']")
	private WebElement submitApproveLoan;

	public WebElement getSubmitApproveLoan() {
		return submitApproveLoan;
	}

	@FindBy(xpath = "//div[@class='user-sub-navbar']//span[@class='user-status ng-binding']")
	private WebElement approvalStatus;

	public WebElement getApprovalStatus() {
		return approvalStatus;
	}

}
