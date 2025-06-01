package in.reqres.models.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserInfoResponse {
  private Data data;
  private Support support;

  @lombok.Data
  public static class Data {
    private int id;
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String avatar;
  }

  @lombok.Data
  public static class Support {
    private String url;
    private String text;
  }
}
