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

WebUI.callTestCase(findTestCase('Dev Env Portal Smoke Test/Dev Login/Login'), [:], FailureHandling.STOP_ON_FAILURE)

// Step 4: Set the sessionKey cookie in the browser with correct parameters
String sessionKey = 'MDEzODIxNjg5MzY3OTQwMjM3NTEwMDAwMDE3MTcyMDIyMjEyMjE0MzEyNDAzNDEyMTc0NjMxMiswMA=='

String setCookieForSecondTab = "
    document.cookie = "sessionKey=" + '$sessionKey' + 
                      "; domain=.birdzi.com; path=/; expires=Session";
"

// Correct the variable name to use 'setCookieForSecondTab'
WebUI.executeJavaScript(setCookieForSecondTab, null)

//--------------------------------------------------------------------------------------------------------
//WebUI.navigateToUrl('https://customerportal2.birdzi.com/dev/v1.64-1659f6c55ca2dd9b34055799a165db3e2eac9887/offer/list?portalUserCompanyID=3604&portalUserContactID=110')
// Get the value of the VISPER_DEV_URL from the profile
String visperUrl = GlobalVariable.VISPER_DEV_URL

// Navigate to the dynamically stored URL
WebUI.navigateToUrl(visperUrl)

//---------------------------------------------------------------------------------------------------------
WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Visper'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Visper'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/a_New Campaign'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/div_Create new campaignwhat kind of campaig_a3a771'))

//------------------------------------------------------------------------------------------------------------------------
WebUI.click(findTestObject('Object Repository/Page_Birdzi/a_one off campaign'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Campaign Name_ng-untouched ng-pristin_479012'), 'dev test 3')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Description_ng-untouched ng-pristine _126b1f'), 'dev test')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Edit'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/label_Welcome_LowCost_1'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/label_Welcome_LowCost_2'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Confirm'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/input_Validation Start Date_startDate'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/a_30'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/input_Validation End Date_endDate'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/a_31'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/label_Digital Coupon'))

//-----------------------------------------------
WebUI.click(findTestObject('Object Repository/Page_Birdzi/label_In-Lane'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Next'))

//--------------------------------------------
WebUI.click(findTestObject('Object Repository/Page_Birdzi/label_Exclude Stretch Offers'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Number of offers per household_ui-slid_bd0e9e'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/div_Number of In-lane Offers Per Household__992f62'))

