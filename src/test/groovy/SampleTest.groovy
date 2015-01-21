import geb.junit4.GebReportingTest
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.openqa.selenium.Keys

/**
 * http://docs.seleniumhq.org/docs/03_webdriver.jsp#introducing-the-selenium-webdriver-api-by-example
 * をベースに一部改変
 */
@RunWith(JUnit4)
public class SampleTest extends GebReportingTest {

    @Test
    public void googleSuggestTest() {
        // Googleのページへ遷移
        go "http://www.google.com"

        // nameからtext inputのエレメントを探す
        def element = $("input", name: "q")

        // 検索するために何か入力
        element << "Cheese!"

        // ページのタイトルをチェック
        assert title == "Google"

        // フォームをサブミット。(ここではエンターキーの入力で代替）
        element << Keys.ENTER

        // Google検索はJavaScriptで動的に表示されます
        // ページがロードされるのを待ちます。タイムアウトは10秒(GebConfigで変更可能)
        waitFor { title.toLowerCase().startsWith("cheese!") }

        // "Cheese!"から始まる文字が表示されているべき
        assert title.startsWith("Cheese!")
    }
}