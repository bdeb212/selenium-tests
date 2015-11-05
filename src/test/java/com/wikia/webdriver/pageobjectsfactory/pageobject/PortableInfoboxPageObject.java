package com.wikia.webdriver.pageobjectsfactory.pageobject;

import com.wikia.webdriver.common.contentpatterns.URLsContent;
import com.wikia.webdriver.common.core.Assertion;
import com.wikia.webdriver.common.core.configuration.Configuration;
import com.wikia.webdriver.pageobjectsfactory.componentobject.modalwindows.CreateArticleModalComponentObject;
import com.wikia.webdriver.pageobjectsfactory.pageobject.category.CategoryPageObject;
import com.wikia.webdriver.pageobjectsfactory.pageobject.template.editmode.PortableInfoboxSourceEditModeObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @ownership Content West Wing
 */
public class PortableInfoboxPageObject extends WikiBasePageObject {

  @FindBy(css = ".pi-image")
  private WebElement image;
  @FindBy(css = ".pi-title")
  private WebElement title;
  @FindBy(css = ".pi-image img")
  private WebElement imageTag;
  @FindBy(css = ".WikiaLightbox")
  private WebElement lightbox;
  @FindBy(css = ".portable-infobox")
  private WebElement layout;
  @FindBy(css = ".tabberlive")
  private WebElement tabber;
  @FindBy(css = ".tabbertab .image")
  private WebElement tabberImage;
  @FindBy(css = ".pi-image")
  private WebElement imageWrapper;
  @FindBy(css = ".pi-title")
  private WebElement titleWrapper;
  @FindBy(css = "body")
  private WebElement bodyElement;
  @FindBy(css = ".header-title")
  private WebElement headerTitle;
  @FindBy(css = ".reference")
  private WebElement referenceElements;
  @FindBy(css = ".pi-data-label")
  private WebElement h3Elements;
  @FindBy(css = ".pi-data-value .newcategory")
  private WebElement categoryLinkInInfobox;
  @FindBy(css = ".pi-data-label")
  private WebElement itemLabel;
  @FindBy(css = ".pi-data-value")
  private WebElement itemValue;
  @FindBy(css = "h3.pi-data-label.pi-secondary-font")
  private WebElement horizontalItemLabel;
  @FindBy(css = "div.pi-data-value")
  private WebElement horizontalItemValue;
  @FindBy(css = ".pi-navigation")
  private List<WebElement> navigationElements;
  @FindBy(css = ".pi-header")
  private List<WebElement> groupHeadersWrappers;
  @FindBy(css = "#articleCategories .category a")
  private List<WebElement> categories;
  @FindBy(css = ".pi-navigation a[href*='redlink']")
  private List<WebElement> redlLink;
  @FindBy(css = ".pi-item .external")
  private List<WebElement> externalLink;
  @FindBy(css = "b")
  private List<WebElement> boldElements;
  @FindBy(css = "i")
  private List<WebElement> italicElements;
  @FindBy(css = ".portable-infobox a[href*='/wiki/']")
  private List<WebElement> internalLink;
  @FindBy(css = ".pi-data-value ul li")
  private List<WebElement> unorderedElement;
  @FindBy(css = ".pi-data-value ol li")
  private List<WebElement> orderedElement;
  @FindBy(css = ".pi-header")
  private List<WebElement> titleH3;

  public PortableInfoboxPageObject(WebDriver driver) {
    super(driver);
  }

  public String getBackgroundColor() {
    return layout.getCssValue("background-color");
  }

  public String getExternalLinkRedirectTitleWithIndex(int index) {
    wait.forElementVisible(externalLink.get(index));
    scrollToElement(externalLink.get(index));
    return externalLink.get(index).getAttribute("href");
  }

  public String getInternalLinkRedirectTitleWithIndex(int index) {
    wait.forElementVisible(internalLink.get(index));
    scrollToElement(internalLink.get(index));
    return internalLink.get(index).getAttribute("href");
  }

  public WebElement getNavigationElements(int index) {
    return navigationElements.get(index);
  }

  public WebElement getGroupHeader(int index) {
    return groupHeadersWrappers.get(index);
  }

  public String getUrlAfterPageIsLoaded() {
    wait.forElementVisible(bodyElement);
    return driver.getCurrentUrl();
  }

  public String getCategoryLinkName() {
    wait.forElementVisible(categoryLinkInInfobox);
    return categoryLinkInInfobox.getText();
  }

  public String getDataImageName() {
    wait.forElementVisible(imageTag);
    return imageTag.getAttribute("data-image-name");
  }

  public PortableInfoboxPageObject clickExternalLinkWithIndex(int index) {
    wait.forElementVisible(externalLink.get(index));
    scrollToElement(externalLink.get(index));
    externalLink.get(index).click();
    return this;
  }

  public PortableInfoboxPageObject clickInternalLinkWithIndex(int index) {
    wait.forElementVisible(internalLink.get(index));
    scrollToElement(internalLink.get(index));
    internalLink.get(index).click();
    return this;
  }

  public PortableInfoboxPageObject clickImage() {
    wait.forElementVisible(image);
    image.click();
    return this;
  }

  public CategoryPageObject clickCategoryLink() {
    wait.forElementVisible(categoryLinkInInfobox);
    scrollAndClick(categoryLinkInInfobox);
    return new CategoryPageObject(driver);
  }

  public CategoryPageObject clickCategory(int index) {
    wait.forElementVisible(categories.get(index));
    scrollAndClick(categories.get(index));
    return new CategoryPageObject(driver);
  }

  public CreateArticleModalComponentObject clickRedLink(int index) {
    wait.forElementVisible(redlLink.get(index));
    scrollToElement(redlLink.get(index));
    redlLink.get(index).click();
    return new CreateArticleModalComponentObject(driver);
  }

  public PortableInfoboxPageObject open(String articleTitle) {
    getUrl(urlBuilder.getUrlForWiki(Configuration.getWikiName()) +
           URLsContent.WIKI_DIR + articleTitle);
    return this;
  }

  public PortableInfoboxPageObject compareURLAndExternalLink(String externalLinkName,
                                                             String externalNavigatedURL) {
    Assertion.assertEquals(externalLinkName, externalNavigatedURL);
    return this;
  }

  public void compareURLAndInternalLink(String internalLinkName, String internalNavigatedURL) {
    Assertion.assertEquals(internalLinkName, internalNavigatedURL);
  }

  public PortableInfoboxPageObject compareFontSizes(WebElement firstElement,
                                                    WebElement secondElement) {
    Assertion.assertEquals(
        firstElement.getCssValue("font-size"),
        secondElement.getCssValue("font-size")
    );
    return this;
  }

  public PortableInfoboxPageObject compareFontSizesBetweenHorizontalItemLabelAndItemLabel() {
    compareFontSizes(horizontalItemLabel, itemLabel);
    return this;
  }

  public PortableInfoboxPageObject compareFontSizesBetweenHorizontalItemValueAndItemValue() {
    compareFontSizes(horizontalItemValue, itemValue);
    return this;
  }

  public PortableInfoboxPageObject compareFontSizesBetweenItemValueAndOrderedListItem(int index) {
    compareFontSizes(itemValue, orderedElement.get(index));
    return this;
  }

  public PortableInfoboxPageObject compareFontSizesBetweenItemValueAndUnorderedListItem(int index) {
    compareFontSizes(itemValue, unorderedElement.get(index));
    return this;
  }

  public PortableInfoboxPageObject compareInfoboxAndCategoryPageImages(String imageName, String categoryImageURL) {
    Assertion.assertStringContains(imageName, categoryImageURL);
    return this;
  }

  public PortableInfoboxPageObject isImagePresented() {
    wait.forElementVisible(image);
    Assertion.assertEquals(isElementOnPage(image), true);
    return this;
  }

  public PortableInfoboxPageObject isTabberPresented() {
    wait.forElementVisible(tabber);
    Assertion.assertEquals(isElementOnPage(tabber), true);
    return this;
  }

  public PortableInfoboxPageObject isTabberImagePresented() {
    wait.forElementVisible(tabberImage);
    Assertion.assertEquals(isElementOnPage(tabberImage), true);
    return this;
  }

  public PortableInfoboxPageObject isInfoboxTitlePresented() {
    wait.forElementVisible(title);
    Assertion.assertEquals(isElementOnPage(title), true);
    return this;
  }

  public PortableInfoboxPageObject isLightboxPresented() {
    wait.forElementVisible(lightbox);
    Assertion.assertEquals(isElementOnPage(lightbox), true);
    return this;
  }

  public PortableInfoboxPageObject areQuotationMarksPresented() {
    wait.forElementVisible(h3Elements);
    Assertion.assertStringContains("\"URL\"", h3Elements.getText());
    return this;
  }

  public PortableInfoboxPageObject areBoldElementsMoreThanOne() {
    Assertion.assertFalse(boldElements.isEmpty());
    return this;
  }

  public PortableInfoboxPageObject areItalicElementsMoreThanOne() {
    Assertion.assertFalse(italicElements.isEmpty());
    return this;
  }

  public PortableInfoboxPageObject areHeadersMoreThanOne() {
    Assertion.assertFalse(titleH3.isEmpty());
    return this;
  }

  public void verifyChangedBackground(String oldBackgroundValue, String newBackgroundValue) {
    Assertion.assertEquals(oldBackgroundValue, newBackgroundValue);
  }

  public PortableInfoboxPageObject verifyReferencesPresence() {
    wait.forElementVisible(referenceElements);
    return this;
  }

  public PortableInfoboxPageObject verifyPadding(WebElement element) {
    Assertion.assertEquals(
        element.getCssValue("padding-left"),
        element.getCssValue("padding-right")
    );
    return this;
  }

  public PortableInfoboxPageObject verifyPaddingNavigationElement(int index) {
    verifyPadding(getNavigationElements(index));
    return this;
  }

  public PortableInfoboxPageObject verifyDivsNotAppearingInImage() {
    Assertion.assertNotEquals(imageWrapper.getTagName(), "div");
    return this;
  }

  public PortableInfoboxPageObject verifyDivsNotAppearingInTitle() {
    Assertion.assertNotEquals(titleWrapper.getTagName(), "div");
    return this;
  }

  public PortableInfoboxPageObject verifyDivsNotAppearingInHeader(int index) {
    Assertion.assertNotEquals(groupHeadersWrappers.get(index).getTagName(), "div");
    return this;
  }

  public PortableInfoboxPageObject verifyEmptyTags() {
    Assertion.assertStringContains(layout.getText(), "Default");
    return this;
  }

  public PortableInfoboxPageObject verifyGroupHeaderPadding(int index) {
    verifyPadding(getGroupHeader(index));
    return this;
  }

  public PortableInfoboxSourceEditModeObject editInfoboxTemplateInSourceMode(String wikiURL, String article) {
    getUrl(urlBuilder.appendQueryStringToURL(wikiURL + URLsContent.WIKI_DIR + article,
                                             URLsContent.ACTION_EDIT));
    return new PortableInfoboxSourceEditModeObject(driver);
  }
}
