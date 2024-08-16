package StepDef;

import base.config;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class signUp extends config {
    WebDriver driver;

    Faker faker = new Faker();


    @Given("student at talentTEK SignUp page")
    public void studentAtTalentTEKSignUpPage() {

        driver=new ChromeDriver();
        driver.get("https://qa.taltektc.com/signup.html");
        driver.manage().window().maximize();

    }
    @And("student enter their valid firstname")

    public void studentEnterTheirValidFirstname() {
        String randomFirstName = faker.name().firstName();

        driver.findElement(By.name("firstName")).sendKeys(randomFirstName);
    }

    @And("student enter their valid lastname")
    public void studentEnterTheirValidLastname() {
        driver.findElement(By.name("lastName")).sendKeys("Jannatul");

    }
    @And("student enter their valid email address for sign up")
    public void studentEnterTheirValidEmailaddress() {
        String randomEmail=faker.internet().emailAddress();
        driver.findElement(By.name("email")).sendKeys(randomEmail);
    }

    @And("student enter their valid password for singUp")
    public void studentEnterTheirValidPasswordForSingUp() {
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Test12345");
    }

    @And("student click on Confirm password")
    public void studentClickOnConfirmPassword() {
        driver.findElement(By.name("confirmPassword")).sendKeys("Test12345");

    }

    @And("student select month from birth date combo box")
    public void studentSelectMonthFromBirthDateComboBox() {
        WebElement list=driver.findElement(By.name("month"));
        Select se=new Select(list);
        se.selectByVisibleText("Aug");
    }

    @And("student select day from birth date combo box")
    public void studentSelectDayFromBirthDateComboBox() {
        WebElement list=driver.findElement(By.name("day"));
        Select se=new Select(list);
        se.selectByVisibleText("8");
    }


    @And("student select year from birth date combo box")
    public void studentSelectYearFromBirthDateComboBox() {
        WebElement list=driver.findElement(By.name("year"));
        Select se=new Select(list);
        se.selectByVisibleText("1999");
    }

    @And("student click on female radio button from gender text box")
    public void studentClickOnFemaleRadioButtonFromGenderTextBox() {
        driver.findElement(By.cssSelector("input[value='female']")).click();

    }

    @And("student agree to the agree box")
    public void studentAgreeToTheAgreeBox() {
        driver.findElement(By.name("agree")).click();
    }

    @When("they click on create an account button")
    public void theyClickOnCreateAnAccountButton() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("student should be able to successfully sign up")
    public void studentShouldBeAbleToSuccessfullySignUp() {
        String expected = "Success!";
        String actualValue = driver.findElement(By.xpath("//div[@class='swal-title']")).getText();
        Assert.assertEquals(actualValue, expected);

        String fullTextOfStudentId = driver.findElement(By.xpath("//div[@class='swal-text']")).getText();
        System.out.println("FULL TEXT is === " + fullTextOfStudentId);
        // Your student id is: TTC0022222

        STUDENT_RANDOM_ID = fullTextOfStudentId.substring(fullTextOfStudentId.indexOf(":") + 2);
        System.out.println("ONLY PRINT ==> Student Random Id  ===> " + STUDENT_RANDOM_ID);
        // TTC0022222

        // click on OK button from the popup
        driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();


    }

    @And("student enter existing email address for sign up")
    public void studentEnterExistingEmailAddressForSignUp() {
        driver.findElement(By.name("email")).sendKeys("jmawya305@gmail.com");
    }

    @Then("student should not be able to successfully sign up with existing email")
    public void studentShouldNotBeAbleToSuccessfullySignUpwithexistingemail() {
        String exp = "Email already exists";
        String act = driver.findElement(By.xpath("//*[@id='error-msg']")).getText();
        Assert.assertEquals(act, exp);
    }
}
