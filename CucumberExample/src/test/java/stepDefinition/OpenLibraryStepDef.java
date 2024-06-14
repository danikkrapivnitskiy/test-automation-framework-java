package stepDefinition;

import api.businessLogic.SearchBookApi;
import api.Specification;
import configuration.ConfigProperties;
import runner.BaseTest;
import ui.businessLogic.BookPageBusinessSteps;
import ui.businessLogic.BasePageBusinessSteps;
import ui.businessLogic.SearchPageBusinessSteps;
import ui.WebDriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OpenLibraryStepDef {
    protected static WebDriver driver;
    private static BasePageBusinessSteps basePage;
    private SearchPageBusinessSteps searchPage;
    private BookPageBusinessSteps bookPage;
    private SearchBookApi searchBookApi;
    private String author;
    private String searchBook;
    private int publishedYear;

    @Before
    public void setup() {
        driver = new WebDriverFactory().setUpDriver();
        Specification.installSpecification(Specification.requestSpec(ConfigProperties.getOpenLibraryUrl()),
                Specification.responseSpecOK200());
        basePage = new BasePageBusinessSteps();
        searchPage = new SearchPageBusinessSteps();
        bookPage = new BookPageBusinessSteps();
        searchBookApi = new SearchBookApi();
    }
    @AfterAll
    public static void tearDown() {
        basePage.closeBrowser();
    }

    @Given("User goes to the OpenLibrary page {string}")
    public void user_goes_to_the_open_library_page(String url) {
        basePage.navigateToMainPage(url);
    }

    @And("User sets website in {string}")
    public void user_sets_website_in(String language) {
        basePage.setWebsiteToSpecificLanguage(language);
    }

    @When("User searches using Title option for book {string}")
    public void user_search_book(String book){
        searchBook = book;
        basePage.findBookByName(book);
    }

    @And("User choose book published in {int}")
    public void user_choose_book_with_specific_year(int year) {
        publishedYear = year;
        searchPage.selectBookBySpecificYear(year);
    }

    @And("Get author from API for book")
    public void get_author_from_api() {
        author = searchBookApi.getAuthorByBookAndYear(searchBook, publishedYear).toString();
    }

    @Then("Author from API matches author on book page")
    public void author_api_corresponds_to_web() {
        Assert.assertEquals(author, bookPage.getBookAuthor(), "Authors are not equals");
    }
}
