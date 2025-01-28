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
def randomName = "Offer Title: " + generateRandomString(10)

// Set the random name as the Offer Title
WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Offer Title_ng-untouched ng-pristine _f71de3'), randomName)

println("Generated Offer Title: " + randomName)




