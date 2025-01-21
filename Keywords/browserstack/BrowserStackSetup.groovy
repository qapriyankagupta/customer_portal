package browserstack // (Optional) If you created a package, this should match

import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import com.kms.katalon.core.annotation.Keyword
import java.net.URL

/**
 * Custom Keyword for setting up BrowserStack WebDriver
 */
class BrowserStackSetup {

	/**
	 * This method initializes the WebDriver for BrowserStack with the provided capabilities.
	 * 
	 * @param user Your BrowserStack username
	 * @param key Your BrowserStack access key
	 * @param localIdentifier (Optional) The local tunnel identifier for BrowserStack Local
	 * @return WebDriver instance connected to BrowserStack
	 */
	@Keyword
	def static WebDriver setupBrowserStack(String user, String key, String localIdentifier) {
		// Set up the desired capabilities for BrowserStack
		DesiredCapabilities caps = new DesiredCapabilities()

		// Add BrowserStack credentials
		caps.setCapability('browserstack.user', user)
		caps.setCapability('browserstack.key', key)
		caps.setCapability('browserstack.local', 'true')  // Set to true for local testing
		caps.setCapability('browserstack.localIdentifier', localIdentifier)  // Optional: useful for parallel testing
		caps.setCapability('browserstack.debug', 'true')  // Optional: enables debug logs
		caps.setCapability('browserstack.video', 'true')  // Optional: enables video recording of the session

		// Set browser and OS configurations
		caps.setCapability('browser', 'chrome')  // Browser you want to test (chrome, firefox, etc.)
		caps.setCapability('browser_version', 'latest')  // Latest browser version
		caps.setCapability('os', 'Windows')  // Operating system (Windows, macOS)
		caps.setCapability('os_version', '10')  // OS version (Windows 10, etc.)
		caps.setCapability('resolution', '1920x1080')  // Screen resolution for testing

		// Define the URL for BrowserStack remote WebDriver
		URL remoteUrl = new URL('https://hub-cloud.browserstack.com/wd/hub')

		// Initialize RemoteWebDriver with BrowserStack URL and desired capabilities
		WebDriver driver = new RemoteWebDriver(remoteUrl, caps)

		// Return the WebDriver instance to be used in your tests
		return driver
	}
}
