
import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

import com.kazurayam.ashotwrapper.AShotWrapper
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

TestObject makeTestObject(String id, String xpath) {
	TestObject tObj = new TestObject(id)
	tObj.addProperty("xpath", ConditionType.EQUALS, xpath)
	return tObj
}

WebUI.openBrowser('')
WebUI.setViewPortSize(1000,1000)
WebUI.navigateToUrl('https://forum.katalon.com/')
WebDriver driver = DriverFactory.getWebDriver()
String xpath = "//div[@id='list-area']"
//TestObject tObj = makeTestObject("list-area", xpath)

float dpr = AShotWrapper.DevicePixelRatioResolver.resolveDPR(driver)
AShotWrapper.Options options = new AShotWrapper.Options.Builder().devicePixelRatio(dpr).build()

BufferedImage image = AShotWrapper.takeElementImage(driver, By.xpath(xpath), options)
assert image != null

File file = new File("./element_screenshot.png")
ImageIO.write(image, "PNG", file)

