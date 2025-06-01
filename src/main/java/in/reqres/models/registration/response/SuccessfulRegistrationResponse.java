package in.reqres.models.registration.response;

import lombok.Data;

@Data
public class SuccessfulRegistrationResponse {
  private int id;
  private String token;
}
