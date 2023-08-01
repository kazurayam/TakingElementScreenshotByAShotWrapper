
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

TestObject makeTestObject(String id, String xpath) {
	TestObject tObj = new TestObject(id)
	tObj.addProperty("xpath", ConditionType.EQUALS, xpath)
	return tObj
}

WebUI.openBrowser('')
WebUI.setViewPortSize(1000,1000)
WebUI.navigateToUrl('https://forum.katalon.com/')

TestObject tObj = makeTestObject("list-area", "//div[@id='list-area']")

WebUI.scrollToElement(tObj, 3)

WebUI.delay(3)

WebUI.takeElementScreenshot(tObj)