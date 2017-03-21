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


//  @Test
//  public void exampleTest() {
//    stubFor(get(urlEqualTo("/my/resource"))
//                .withHeader("Accept", equalTo("text/xml"))
//                .willReturn(aResponse()
//                                .withStatus(200)
//                                .withHeader("Content-Type", "text/xml")
//                                .withBody("<response>Some content</response>")));
//
//    Result result = myHttpServiceCallingObject.doSomething();
//
//    assertTrue(result.wasSuccessful());
//
//    verify(postRequestedFor(urlMatching("/my/resource/[a-z0-9]+"))
//               .withRequestBody(matching(".*<message>1234</message>.*"))
//               .withHeader("Content-Type", notMatching("application/json")));
//  }

}