import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys

/**
 * http://docs.seleniumhq.org/docs/03_webdriver.jsp#introducing-the-selenium-webdriver-api-by-example
 * をベースに一部改変
 */
class SampleSpec extends GebReportingSpec {

    def "GoogleSuggestのテスト"() {
        when: 'Googleのページへ遷移'
        go "http://www.google.com"

        and: '検索欄を探し、入力'
        def element = $("input", name: "q")
        element << "Cheese!"

        then: 'ページのタイトルをチェック'
        assert title == "Google"

        when: 'フォームをサブミット。(ここではエンターキーの入力で代替）'
        element << Keys.ENTER

        // Google検索はJavaScriptで動的に表示されます
        // ページがロードされるのを待ちます。タイムアウトは10秒(GebConfigで変更可能)
        waitFor { title.toLowerCase().startsWith("cheese!") }

        then: '"Cheese!"から始まる文字が表示されているべき'
        assert title.startsWith("Cheese!")
    }
}