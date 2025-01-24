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

//------------------------------------------------------------------------------------------------------------
WebUI.callTestCase(findTestCase('Dev Env Portal Smoke Test/Dev Login/Login'), [:], FailureHandling.STOP_ON_FAILURE)

// Step 4: Set the sessionKey cookie in the browser with correct parameters
String sessionKey = 'MDEzODIxNjg5MzY3OTQwMjM3NTEwMDAwMDE3MTcyMDIyMjEyMjE0MzEyNDAzNDEyMTc0NjMxMiswMA=='

String setCookieForSecondTab = "
    document.cookie = "sessionKey=" + '$sessionKey' + 
                      "; domain=.birdzi.com; path=/; expires=Session";
"

// Correct the variable name to use 'setCookieForSecondTab'
WebUI.executeJavaScript(setCookieForSecondTab, null)

//-----------------------------------------------------------------------------------------------------
//WebUI.navigateToUrl('https://customerportal2.birdzi.com/dev/v1.56-2ba14d9840ffb207f68fc1b2ce508dfb0802e92c/support/search-customer?portalUserCompanyID=3604&portalUserContactID=110')
// Get the value of the SUPPORT_DEV_URL from the profile
String supportUrl = GlobalVariable.SUPPORT_DEV_URL

// Navigate to the dynamically stored URL
WebUI.navigateToUrl(supportUrl)

//-----------------------------------------------------------------------------------------------------
WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Search for a customer_ng-untouched ng_41970f'), 'vhauf@birdzi.com')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Search'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_First Name_ng-untouched ng-pristine ng-valid'), 'Volker')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Last Name_ng-untouched ng-pristine ng-valid'), 'Hauf')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Birth Date_ng-untouched ng-pristine ng-valid'), '12/12/1990')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_First Name_ng-untouched ng-pristine ng-valid'), 'Volker')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Male'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_Male'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_E-mail Address_ng-untouched ng-dirty _f3cdcd'), 'vhauf@birdzi.com')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Primary Phone Number_ng-untouched ng-_1d3cb4'), '234-342-4243')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/input_Primary Phone Number_ng-untouched ng-_1d3cb4'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Home Address_ng-untouched ng-valid ng-dirty'), 'home edit edit')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_City_ng-untouched ng-pristine ng-valid'), 'city')

//WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Arizona'))
//WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_Alaska'))
//WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Alaska'))
WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Zip Code_ng-untouched ng-dirty ng-invalid'), '30303')

//WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_MORE ID_reward ng-untouched ng-pristine'), '40000006349')
//WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_645 Lake Street S, Long Prairie, MN 56347'))
WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Save Changes'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Offer Wallet'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_0 Redeemed (0.00)'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_4 Rewards'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Issue Credit'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Volker Hauf_ng-untouched ng-dirty ng-valid'), '0.1')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/textarea_Volker Hauf_ng-untouched ng-dirty _34c260'), '0.1')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Issue Credit_1'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Purchases'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Expand All'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Collapse All'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Receipts'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Clubs'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Audiences'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Notes'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Add Note'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/input_Date  Time_note-date'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Contact type_select select-menu-toggle'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_Phone'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Reason_select select-menu-toggle'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_Customer Account'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_Outcome_select select-menu-toggle'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_Reset Password'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/textarea_Comments_ng-untouched ng-dirty ng-valid'), 'Reset Password')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Save'))

WebUI.closeBrowser()

