import geb.junit4.GebReportingTest
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * http://docs.seleniumhq.org/docs/03_webdriver.jsp#introducing-the-selenium-webdriver-api-by-example
 * をベースに一部改変
 */
@RunWith(JUnit4)
public class sampleTest extends GebReportingTest {

    @Test
    public void googleSuggestTest() {
        // Googleのページへ遷移
        driver.get("http://www.google.com");
        // 他のやり方として、以下のように記述することもできます
        // driver.navigate().to("http://www.google.com");

        // nameからtext inputのエレメントを探す
        WebElement element = driver.findElement(By.name("q"));

        // 検索するために何か入力
        element.sendKeys("Cheese!");

        // ページのタイトルをチェック
        assertThat(driver.getTitle(), is("Google"));

        // フォームをサブミット。WebDriverはエレメントからフォームを見つけてくれます。
        element.submit();

        // Google検索はJavaScriptで動的に表示されます
        // ページがロードされるのを待ちます。タイムアウトは10秒
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // "Cheese!"から始まる文字が表示されているべき
        assertThat(driver.getTitle(), startsWith("Cheese!"));
    }
}