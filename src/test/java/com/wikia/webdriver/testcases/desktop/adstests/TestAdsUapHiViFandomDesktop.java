package com.wikia.webdriver.testcases.desktop.adstests;

import com.wikia.webdriver.common.dataprovider.ads.FandomAdsDataProvider;
import com.wikia.webdriver.common.templates.fandom.AdsFandomTestTemplate;

import org.testng.annotations.Test;

@Test(groups = "AdsUapHiViFandomDesktop")
public class TestAdsUapHiViFandomDesktop extends AdsFandomTestTemplate {

  private static final double IMPACT_STATE_ASPECT_RATIO = 4.0;
  private static final double RESOLVED_STATE_ASPECT_RATIO = 10.0;
  private static final String TLB_SLOT_ID = "top_leaderboard";
  private static final String
      AD_REDIRECT
      = "http://fandom.wikia.com/articles/legacy-luke-skywalker";

  private TestAdsUapHiVi test() {
    return test(FandomAdsDataProvider.PAGE_HIVI_UAP_ARTICLE);
  }

  private TestAdsUapHiVi test(String page) {
    return new TestAdsUapHiVi(driver, loadArticle(page), TLB_SLOT_ID);
  }

  @Test
  public void shouldHaveCorrectAspectRatioForImpactState() {
    test().shouldHaveCorrectAspectRatioForImpactState(IMPACT_STATE_ASPECT_RATIO);
  }

  @Test
  public void shouldHaveCorrectAspectRatioForResolvedState() {
    test().shouldHaveCorrectAspectRatioForResolvedState(RESOLVED_STATE_ASPECT_RATIO);
  }

  @Test
  public void shouldHaveResolvedStateAfterScroll() throws InterruptedException {
    test().shouldHaveResolvedStateAfterScroll(IMPACT_STATE_ASPECT_RATIO,
                                              RESOLVED_STATE_ASPECT_RATIO
    );
  }

  @Test
  public void shouldKeepResolvedStateAspectRatioAfterScroll() throws InterruptedException {
    test().shouldKeepResolvedStateAspectRatioAfterScroll(RESOLVED_STATE_ASPECT_RATIO);
  }

  @Test
  public void shouldAutoplayVideoForImpactState() {
    test().shouldAutoplayVideoForImpactState();
  }

  @Test
  public void shouldProgressTimeWhilePlaying() throws InterruptedException {
    test().shouldProgressTimeWhilePlaying();
  }

  @Test
  public void shouldMuteVideoForAutoplayedImpactState() throws InterruptedException {
    test().shouldMuteVideoForAutoplayedImpactState();
  }

  @Test
  public void shouldUnmuteVideoAfterClickOnIcon() throws InterruptedException {
    test().shouldUnmuteVideoAfterClickOnIcon();
  }

  @Test
  public void shouldPlayUnmutedVideoForReplayedAd() throws InterruptedException {
    test().shouldPlayUnmutedVideoForReplayedAd();
  }

  @Test
  public void shouldRedirectToPageAfterClickOnAd() {
    test().shouldRedirectToPageAfterClickOnAd(AD_REDIRECT);
  }

  @Test
  public void shouldPauseOnVideoAfterClickOnPauseIcon() throws InterruptedException {
    test().shouldPauseOnVideoAfterClickOnPauseIcon();
  }

  @Test
  public void shouldBeResolvedStateAfterVideoEnds() {
    test().shouldBeResolvedStateAfterVideoEnds(RESOLVED_STATE_ASPECT_RATIO);
  }

  @Test
  public void shouldDisplayResolvedStateOnNextPageView() {
    test().shouldDisplayResolvedStateOnNextPageView(IMPACT_STATE_ASPECT_RATIO,
                                                    RESOLVED_STATE_ASPECT_RATIO
    );
  }

  @Test
  public void shouldBeFullscreenAfterClickOnIcon() {
    test().shouldBeFullscreenAfterClickOnIcon();
  }

  @Test
  public void shouldAutoplayVideoForResolvedState() {
    test().shouldAutoplayVideoForResolvedState();
  }

  @Test
  public void shouldMuteAutoplayedVideoOnResolvedState() throws InterruptedException {
    test().shouldMuteAutoplayedVideoOnResolvedState();
  }

  @Test
  public void shouldNotAutoplayVideoForClickToPlay() {
    test(FandomAdsDataProvider.PAGE_HIVI_UAP_CTP).shouldNotAutoplayVideoForClickToPlay();
  }

  @Test
  public void shouldPlayVideoWithSoundForClickToPlay() throws InterruptedException {
    test(FandomAdsDataProvider.PAGE_HIVI_UAP_CTP).shouldPlayVideoWithSoundForClickToPlay();
  }
}
