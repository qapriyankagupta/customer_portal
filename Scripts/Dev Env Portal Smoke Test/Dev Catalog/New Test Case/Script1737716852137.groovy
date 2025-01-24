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

String setCookieForSecondTab = """
    document.cookie = "sessionKey=" + '$sessionKey' + 
                      "; domain=.birdzi.com; path=/; expires=Session";
"""

// Correct the variable name to use 'setCookieForSecondTab'
WebUI.executeJavaScript(setCookieForSecondTab, null)

// Get the value of the CATALOG_DEV_URL from the profile
String catalogUrl = GlobalVariable.CATALOG_DEV_URL

// Navigate to the dynamically stored URL
WebUI.navigateToUrl(catalogUrl)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_All Root Categories'))

'click Product\r\n'
WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_Produce'))

'click and focus cursor on search input field'
WebUI.click(findTestObject('Object Repository/Page_Birdzi/input_Non-Categorized_ng-untouched ng-prist_f135bd'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Non-Categorized_ng-untouched ng-prist_f135bd'), 'milk')

WebUI.sendKeys(findTestObject('Object Repository/Page_Birdzi/input_Categories_ng-untouched ng-pristine ng-valid'), Keys.chord(
        Keys.ENTER))

WebUI.click(findTestObject('Parameterized/Products List', [('index') : index]))

//WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_Prairie Farms Buttermilk0072730256057 Tr_6433a0'))

//WebUI.click(findTestObject('Object Repository/Page_Birdzi/h4_Cal Evaporated Milk'))

//WebUI.click(findTestObject('Object Repository/Page_Birdzi/ul_Dianas Bananas Milk Chocolate Real Banan_55c4be'))

//WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_Fannie May Cubbies Milk Chocolate Bar 2o_21b75d'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/a_change image'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/a_Upload Image'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Save'))

WebUI.closeBrowser()

