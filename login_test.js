var assert = require("assert");
const webdriver = require("selenium-webdriver"),
  By = webdriver.By,
  until = webdriver.until;

const URL = "http://localhost:3000";

async function givenAClient_whenEnteringLoginCredentials_thenHomePageIsDisplayed() {
  const driver = await new webdriver.Builder().forBrowser("chrome").build();
  await driver.get(URL);
  const username = "test";
  const password = "password";

  await driver
    .findElement(
      webdriver.By.className("MuiInputBase-input MuiOutlinedInput-input")
    )
    .sendKeys(username);

  await driver
    .findElement(
      webdriver.By.className(
        "MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd"
      )
    )
    .sendKeys(password);

  await driver
    .findElement(
      webdriver.By.className(
        "MuiButtonBase-root MuiButton-root MuiButton-text login-btn"
      )
    )
    .click();

  await driver.sleep(5000).then(function () {
    driver
      .findElement(webdriver.By.className("ReviewPreview"))
      .catch(function (err) {
        console.log("Test Passed!");
      });
  });

  await driver.quit();
}

async function givenAClient_whenEnteringWrongCredentials_thenHomePageIsDisplayed() {
  const driver = await new webdriver.Builder().forBrowser("chrome").build();
  await driver.get(URL);
  const username = "testo";
  const password = "password";

  await driver
    .findElement(
      webdriver.By.className("MuiInputBase-input MuiOutlinedInput-input")
    )
    .sendKeys(username);

  await driver
    .findElement(
      webdriver.By.className(
        "MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd"
      )
    )
    .sendKeys(password);

  await driver
    .findElement(
      webdriver.By.className(
        "MuiButtonBase-root MuiButton-root MuiButton-text login-btn Mui-disabled Mui-disabled"
      )
    )
    .catch(function () {
      console.log("Test Passed!");
    });

  await driver.quit();
}

givenAClient_whenEnteringLoginCredentials_thenHomePageIsDisplayed();
givenAClient_whenEnteringWrongCredentials_thenHomePageIsDisplayed();
