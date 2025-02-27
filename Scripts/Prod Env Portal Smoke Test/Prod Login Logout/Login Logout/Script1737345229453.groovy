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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.PROD_Customer_Portal_URL)

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Email Address__58_login'), email)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Birdzi/input_Password__58_password'), passwd)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/Page_Birdzi/button_Sign In'))

WebUI.click(findTestObject('Object Repository/LoginLogout/Page_Birdzi/div_Priyanka GuptaMy AccountSign OutCoborns_3b406f'))

WebUI.waitForElementPresent(findTestObject('Object Repository/LoginLogout/Page_Birdzi/div_Priyanka GuptaMy AccountSign OutCoborns_3b406f'), 
    0)

WebUI.click(findTestObject('Object Repository/LoginLogout/Page_Birdzi/a_Priyanka Gupta'))

WebUI.click(findTestObject('Object Repository/LoginLogout/Page_Birdzi/a_Sign Out'))

WebUI.closeBrowser()

