import java.io.IOException;

public class GithubApplication {

  public static void main(String[] args) throws IOException {
    GithubGateway githubGateway = new GithubGateway();

    System.out.println(githubGateway.getUserLocation("tmszdmsk"));
  }

}
