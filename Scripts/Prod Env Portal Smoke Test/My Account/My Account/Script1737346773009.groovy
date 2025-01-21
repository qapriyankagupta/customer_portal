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

WebUI.navigateToUrl('https://customerportal.birdzi.com/en/web/guest/home')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Email Address__58_login'), 'pgupta+coborns@birdzi.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Birdzi/input_Password__58_password'), 'aCfAyMx3l1MdmFBz54hP7A==')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/button_Sign In'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/a_Priyanka Gupta'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/a_My Account'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/form_First NameLast NameGenderSelect Gender_4ca2b6'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input__fname'), 'Priyanka')

WebUI.doubleClick(findTestObject('Object Repository/Page_Birdzi/input_Last Name_lname'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Last Name_lname'), 'Gupta')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Birdzi/select_Select Gender MaleFemale'), 'female', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Birdzi/select_Select CountryUSASwitzerlandGermanyU_e26332'), 
    '2', true)

WebUI.click(findTestObject('Object Repository/Page_Birdzi/input__street1'))

WebUI.click(findTestObject('Object Repository/Page_Birdzi/form_First NameLast NameGenderSelect Gender_ecdf43'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input__street1'), 'Street1')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Street 2_street2'), 'Street2')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/form_First NameLast NameGenderSelect Gender_ecdf43'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Street 2_street2'), 'Street2')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input__city'), '.LA')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/form_First NameLast NameGenderSelect Gender_ecdf43'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input__city'), 'LA')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Postal Code_pcode'), '33304')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/input__city'))

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Postal Code_pcode'), '33304')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Phone Number_pnumber'), '9029677755')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Cell Number_cnumber'), '1234567855')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input__email'), 'pgupta+coborns@birdzi.com')

WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Fax_fax'), '5555')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/form_First NameLast NameGenderSelect Gender_ecdf43'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Birdzi/input_New Password_password'), 'aCfAyMx3l1MdmFBz54hP7A==')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Birdzi/input_Confirm New Password_password1'), 'aCfAyMx3l1MdmFBz54hP7A==')

WebUI.click(findTestObject('Object Repository/Page_Birdzi/input_Confirm New Password_btn'))


WebUI.verifyElementText(findTestObject('Object Repository/Page_Birdzi/div_Saved successfully'), 'Saved successfully.')

