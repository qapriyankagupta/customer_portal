import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import java.util.Date as Date
import java.util.Random

//------------------------------------------------------------------------------------------------------------
WebUI.callTestCase(findTestCase('Dev Env Portal Smoke Test/Dev Login/Login'), [:], FailureHandling.STOP_ON_FAILURE)

// Step 4: Set the sessionKey cookie in the browser with correct parameters
String sessionKey = 'MDEzODIxNjg5MzY3OTQwMjM3NTEwMDAwMDE3MTcyMDIyMjEyMjE0MzEyNDAzNDEyMTc0NjMxMiswMA=='

String setCookieForSecondTab = """
    document.cookie = "sessionKey=" + '$sessionKey' + 
                      "; domain=.birdzi.com; path=/; expires=Session";
"""

// Correct the variable name to use 'setCookieForSecondTab'
WebUI.executeJavaScript(setCookieForSecondTab, null)

//-------------------------------------------------------------------------------------------------------------
// Get the value of the APPROVER_OFFERS_URL from the profile
String approverOffersUrl = GlobalVariable.APPROVER_OFFERS_DEV_URL

// Navigate to the dynamically stored URL
WebUI.navigateToUrl(approverOffersUrl)

WebUI.delay(2 // This delays for 2 seconds
    )

//--------------------------------------------------------------------------------------------------------------
WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Create Offer'))

WebUI.delay(2) // This delays for 2 seconds

// Function to generate a random 10-character string
def generateRandomString(int length) {
	def chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'
	def random = new Random()
	def sb = new StringBuilder()
	
	(1..length).each {
		sb.append(chars[random.nextInt(chars.length())])
	}
	
	return sb.toString()
}

// Generate random 10-character string
def randomName = generateRandomString(10)

// Print the random name to the console
println("Generated Offer Title: " + randomName)

// Set the random name as the Offer Title
WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Offer Title_ng-untouched ng-pristine _f71de3'), "Offer Title: " + randomName)

// Set the Description with "Description: " followed by the generated random name
WebUI.setText(findTestObject('Object Repository/Page_Birdzi/textarea__ng-untouched ng-dirty ng-valid'), "Description: " + randomName)

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Offer Name_ng-untouched ng-pristine ng-valid'), "Offer Name: " + randomName)

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/textarea__ng-untouched ng-dirty ng-valid_1'), "Terms: " + randomName)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Vendor_vendor'))

WebUI.delay(2 // This delays for 2 seconds
	)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_Birdzi'))

WebUI.delay(2 // This delays for 2 seconds
	)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Select'))

WebUI.delay(2 // This delays for 2 seconds
	)

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Offer Code_ng-untouched ng-pristine ng-valid'), 'Offer Code')

WebUI.delay(2 // This delays for 2 seconds
	)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_All Stores'))

WebUI.delay(2 // This delays for 2 seconds
	)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_2002 - Coborns - Foley'))


WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Save'))

WebUI.delay(2 // This delays for 2 seconds
	)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Products'))

WebUI.delay(2 // This delays for 2 seconds
	)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_0001 - GROCERY'))

WebUI.delay(2 // This delays for 2 seconds
	)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Save_1'))

WebUI.delay(2 // This delays for 2 seconds
	)

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Budget_ng-untouched ng-pristine ng-valid'), '5')

WebUI.delay(2 // This delays for 2 seconds
	)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_'))

WebUI.delay(2 // This delays for 2 seconds
	)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_Clips'))

WebUI.delay(2 // This delays for 2 seconds
	)

//=============Today's date, End Date and Redemption Date===============================================================
// ============================== Start Date (Today's Date) ==============================
SimpleDateFormat startDateFormat = new SimpleDateFormat('dd')

String startDate = startDateFormat.format(new Date())

// Output today's date for debugging
println('Start date (Today\'s date) is: ' + startDate)

// Click on the input field to open the datepicker for the start date (today's date)
WebUI.click(findTestObject('Object Repository/Page_Birdzi/input_Start_startDate'))

// Build the dynamic XPath to locate today's date in the calendar
String startDateXPath = ('//div[@id=\'ui-datepicker-div\']/table/tbody//a[text()=\'' + startDate) + '\']'

// Find the date element for today and click on it
TestObject startDateElement = new TestObject().addProperty('xpath', ConditionType.EQUALS, startDateXPath)

// Verify if the element exists and click it
if (WebUI.verifyElementPresent(startDateElement, 5, FailureHandling.OPTIONAL)) {
	WebUI.click(startDateElement)
} else {
	println('Start date element is not available in the calendar popup.')
}

// ============================== End Date (10 Days After Today's Date) ==============================
SimpleDateFormat endDateFormat = new SimpleDateFormat('dd/MM/yyyy' // Format for the end date
)

Calendar calendarForEndDate = Calendar.getInstance()

calendarForEndDate.setTime(new Date() // Set today's date
	)

calendarForEndDate.add(Calendar.DAY_OF_MONTH, 10 // Add 10 days to today
	)

// Get the end date in dd/MM/yyyy format
String endDate = endDateFormat.format(calendarForEndDate.getTime())

// Output the calculated end date for debugging
println('End date (10 days after today) is: ' + endDate)

// Click on the input field to open the datepicker for the end date
WebUI.click(findTestObject('Object Repository/Page_Birdzi/input_End_endDate'))

// Extract the day (dd) from the end date (e.g., "30" from "30/01/2015")
SimpleDateFormat endDayFormat = new SimpleDateFormat('dd')

String endDay = endDayFormat.format(calendarForEndDate.getTime() // Get the day part from end date
	)

// Output the extracted day for debugging
println('End day extracted is: ' + endDay)

// Build the XPath dynamically to find the correct end date in the calendar
String endDateXPath = ('//div[@id=\'ui-datepicker-div\']/table/tbody//a[text()=\'' + endDay) + '\']'

// Find the end date element and click on it
TestObject endDateElement = new TestObject().addProperty('xpath', ConditionType.EQUALS, endDateXPath)

// Verify if the end date element exists and click it
if (WebUI.verifyElementPresent(endDateElement, 5, FailureHandling.OPTIONAL)) {
	WebUI.click(endDateElement)
} else {
	println('End date element is not available in the calendar popup.')
}

// ============================== Redemption Date (1 Day After End Date) ==============================
calendarForEndDate.add(Calendar.DAY_OF_MONTH, 1 // Add 1 day to the end date to get redemption date
	)

// Get the redemption date (1 day after the end date) in dd/MM/yyyy format
String redemptionDate = endDateFormat.format(calendarForEndDate.getTime())

// Output the calculated redemption date for debugging
println('Redemption date (1 day after the end date) is: ' + redemptionDate)

// Click on the input field to open the datepicker for the redemption date
WebUI.click(findTestObject('Object Repository/Page_Birdzi/input_Redeemable Through_redemptionEndDate'))

// Extract the day (dd) from the redemption date (e.g., "31" from "31/01/2015")
String redemptionDay = new SimpleDateFormat('dd').format(calendarForEndDate.getTime() // Get the day part of redemption date
	)

// Output the extracted redemption day for debugging
println('Redemption day extracted is: ' + redemptionDay)

// Build the XPath dynamically to find the correct redemption date in the calendar
String redemptionDateXPath = ('//div[@id=\'ui-datepicker-div\']/table/tbody//a[text()=\'' + redemptionDay) + '\']'

// Find the redemption date element and click on it
TestObject redemptionDateElement = new TestObject().addProperty('xpath', ConditionType.EQUALS, redemptionDateXPath)

// Verify if the redemption date element exists and click it
if (WebUI.verifyElementPresent(redemptionDateElement, 5, FailureHandling.OPTIONAL)) {
	WebUI.click(redemptionDateElement)
} else {
	println('Redemption date element is not available in the calendar popup.')
}

// Optional: Add a delay (e.g., 2 seconds) to simulate the user interaction
WebUI.delay(2)

//=====================================================================================================
//WebUI.click(findTestObject('Object Repository/Page_Birdzi/input_Redeemable Through_redemptionEndDate'))
//WebUI.click(findTestObject('Object Repository/Page_Birdzi/a_31'))
WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Discount_ng-untouched ng-pristine ng-invalid'), '5')

WebUI.delay(2 // This delays for 2 seconds
	)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Save Changes'))

WebUI.delay(2 // This delays for 2 seconds
	)

WebUI.rightClick(findTestObject('Object Repository/Page_Birdzi/div_Offer created successfully'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Birdzi/div_Send Request_float-alert float-alert-success'),
	'Offer created successfully.')

WebUI.delay(2 // This delays for 2 seconds
	)







