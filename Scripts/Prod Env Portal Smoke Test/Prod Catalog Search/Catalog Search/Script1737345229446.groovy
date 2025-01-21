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

WebUI.navigateToUrl('https://customerportal.birdzi.com/en/web/guest/home')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Email Address__58_login'), 'pgupta+coborns@birdzi.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Birdzi/input_Password__58_password'), 'aCfAyMx3l1MdmFBz54hP7A==')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Sign In'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/a_Catalog'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Categories_ng-untouched ng-pristine ng-valid'), 'cheese')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_All Root Categories'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/li_Bread  Bakery'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Search'))

WebUI.mouseOver(findTestObject('Object Repository/Page_Birdzi/h4_Bake Shoppe Fresh Sweet Cinnamon Rolls W_5320c6'))

WebUI.closeBrowser()

