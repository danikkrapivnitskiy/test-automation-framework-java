package stepDefinition;

import api.SearchBookApi;
import api.Specification;
import configuration.ConfigProperties;
import gui.BookPage;
import gui.OpenLibraryCommon;
import gui.SearchPage;
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
    private static OpenLibraryCommon openLibraryCommon;
    private SearchPage searchPage;
    private BookPage bookPage;
    private SearchBookApi searchBookApi;
    private String author;
    private String searchBook;
    private int publishedYear;

    @Before
    public void setup() {
        driver = new WebDriverFactory().setUpDriver();
        Specification.installSpecification(Specification.requestSpec(ConfigProperties.getOpenLibraryUrl()),
                Specification.responseSpecOK200());
        openLibraryCommon = new OpenLibraryCommon(driver);
        searchPage = new SearchPage(driver);
        bookPage = new BookPage(driver);
        searchBookApi = new SearchBookApi();
    }
    @AfterAll
    public static void tearDown() {
        openLibraryCommon.closeBrowser();
    }

    @Given("User goes to the OpenLibrary page {string}")
    public void user_goes_to_the_open_library_page(String url) {
        openLibraryCommon.navigateToMainPage(url);
    }

    @And("User sets website in {string}")
    public void user_sets_website_in(String language) {
        openLibraryCommon.setWebsiteToSpecificLanguage(language);
    }

    @When("User searches using Title option for book {string}")
    public void user_search_book(String book){
        searchBook = book;
        openLibraryCommon.searchTheBook(book);
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
        Assert.assertEquals(author, bookPage.getAuthorOfBook(), "Authors are not equals");
    }
}
