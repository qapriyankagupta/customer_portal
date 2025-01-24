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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions as ExpectedConditions

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

// Get the value of the CATALOG_DEV_URL from the profile
String catalogUrl = GlobalVariable.CATALOG_DEV_URL

// Navigate to the dynamically stored URL
WebUI.navigateToUrl(catalogUrl)

//-----------------------------------------------------------------------------------------------------------
'Enter cheese and search'
WebUI.setText(findTestObject('Object Repository/Page_Birdzi/input_Categories_ng-untouched ng-pristine ng-valid'), 'cheese')

WebUI.sendKeys(findTestObject('Object Repository/Page_Birdzi/input_Categories_ng-untouched ng-pristine ng-valid'), Keys.chord(
        Keys.ENTER))

'Click on "With Images" tab\r\n'
WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_With Images (6434)'))

'Click on "All" tab\r\n'
WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_All (11193)'))

'Click on "With Images" again\r\n'
WebUI.click(findTestObject('Object Repository/Page_Birdzi/span_With Images (6434)'))

//----------------------------------------------------------Works until here----------------------------------------------------
// Get the WebDriver instance
//WebDriver driver = DriverFactory.getWebDriver()
// Wait for the element to be visible
WebDriverWait wait = new WebDriverWait(driver, 10)

WebElement firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath('/html/body/app-root/app-site-layout/div/div/app-products/div/section/div[1]/div/div[5]/ul/virtual-scroller/div[2]/li[1]/h4')))

// Wait for the element to be clickable
wait.until(ExpectedConditions.elementToBeClickable(firstItem))

// Click on the first item
firstItem.click()

