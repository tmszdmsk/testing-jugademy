import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public class GithubGateway {

  private final WikipediaAPI api;

  public GithubGateway() {
    this("https://api.github.com");
  }

  public GithubGateway(String baseUrl) {
    this.api = new Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(JacksonConverterFactory.create())
        .build().create(WikipediaAPI.class);
  }

  public String getUserLocation(String username) throws IOException {
    Response<QueryResult> response = api.search(username).execute();
    if (response.isSuccessful()) {
      return response.body().location;
    } else {
      if(response.code()==500){
        throw new GithubUnavailableException();
      } else {
        throw new RuntimeException();
      }
    }
  }

  private interface WikipediaAPI {

    @GET("/users/{user}")
    Call<QueryResult> search(@Path("user") String user);

  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  private static class QueryResult {

    @JsonProperty
    String location;
  }

}
