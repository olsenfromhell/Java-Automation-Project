package in.reqres.models.registration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuccessfulRegistrationResponse {
  private int id;
  private String token;
}
