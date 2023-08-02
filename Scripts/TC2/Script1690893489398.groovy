import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

import com.kazurayam.ashotwrapper.AShotWrapper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.setViewPortSize(1000,1000)
WebUI.navigateToUrl('https://forum.katalon.com/')

WebDriver driver = DriverFactory.getWebDriver()
String xpath = "//div[@id='list-area']"
float dpr = AShotWrapper.DevicePixelRatioResolver.resolveDPR(driver)
AShotWrapper.Options options = new AShotWrapper.Options.Builder().devicePixelRatio(dpr).build()
File file = new File("./element_screenshot.png")

BufferedImage image = AShotWrapper.saveElementImage(driver, By.xpath(xpath), options, file)

driver.quit()

assert file.exists()