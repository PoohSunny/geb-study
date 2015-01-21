/*
	Gebの設定ファイル
	https://github.com/geb/geb-example-gradle/blob/master/src/test/resources/GebConfig.groovyをベースに一部改変しています
	設定内容について詳しくは: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver

waiting {
	timeout = 2
}

environments {
	
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { new ChromeDriver() }
	}
	
	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = { new FirefoxDriver() }
	}

  phantomJs {
      driver = { new PhantomJSDriver() }
  }

}