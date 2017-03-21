import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

public class GithubGatewayTest {

  GithubGateway githubGateway = new GithubGateway();

  @Rule
  public WireMockRule wireMock = new WireMockRule(8080);

  @Before
  public void setUp() {
    githubGateway = new GithubGateway("http://localhost:8080");
  }

  @Test
  public void shouldReturnPoznanForTmszdmsk() throws IOException {
    //given
    wireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/users/tmszdmsk"))
                         .willReturn(
                             WireMock.aResponse().withBody("{\"location\": \"Poznań, Poland\"}")));

    //when
    String location = githubGateway.getUserLocation("tmszdmsk");

    //then
    Assertions.assertThat(location).contains("Poznań");
  }

  @Test(expected = GithubUnavailableException.class)
  public void shouldThrowGithubUnavailableWhenGithubFails() throws IOException {
    //given
    wireMock.stubFor(
        WireMock
            .get(WireMock.urlPathEqualTo("/users/tmszdmsk"))
            .willReturn(WireMock.aResponse().withStatus(500)));
    //when
    githubGateway.getUserLocation("tmszdmsk");
  }

}