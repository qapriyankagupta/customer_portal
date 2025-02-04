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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import java.util.Random as Random
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType


WebUI.callTestCase(findTestCase('Dev Env Portal Smoke Test/Dev Login/Login'), [:], FailureHandling.STOP_ON_FAILURE)

// Step 4: Set the sessionKey cookie in the browser with correct parameters
String sessionKey = 'MDEzODIxNjg5MzY3OTQwMjM3NTEwMDAwMDE3MTcyMDIyMjEyMjE0MzEyNDAzNDEyMTc0NjMxMiswMA=='

String setCookieForSecondTab = """document.cookie = "sessionKey=" + '$sessionKey' + "; domain=.birdzi.com; path=/; expires=Session";
"""

// Correct the variable name to use 'setCookieForSecondTab'
WebUI.executeJavaScript(setCookieForSecondTab, null)

// Get the value of the CATALOG_DEV_URL from the profile
String catalogUrl = GlobalVariable.CATALOG_DEV_URL

// Navigate to the dynamically stored URL
WebUI.navigateToUrl(catalogUrl)

//---------------------------------------------------------------------------------------------------------------

// Click on the dropdown to open the options
WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_All Root Categories'))

// Wait for the dropdown list to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Birdzi/ul_SelectOptions'), 10)

// Generate a random index (you can adjust this if needed)
Random random = new Random()
int randomIndex = random.nextInt(28) + 2  // Assuming there are 28 options, this will select a random number between 2 and 28 because first value is "A  Root Categories"

// Construct the dynamic XPath based on the random index
String randomXPath = "//ul[@id='select-manu-options']/li[" + randomIndex + "]"

// Create a dynamic TestObject using the random XPath
TestObject randomItem = new TestObject('randomItem')
randomItem.addProperty('xpath', ConditionType.EQUALS, randomXPath)

// Click on the randomly selected item
WebUI.click(randomItem)

// Log the selected option (you can replace this with the actual text of the selected item if needed)
println("Selected random index: " + randomIndex)




