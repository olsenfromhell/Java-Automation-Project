package in.reqres.models.registration.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SuccessfulRegistrationResponse {
  private int id;
  private String token;

  @JsonProperty("_meta")
  private Meta meta;
}
