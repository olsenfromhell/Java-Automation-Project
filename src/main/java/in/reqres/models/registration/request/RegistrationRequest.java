package in.reqres.models.registration.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RegistrationRequest {
  private String email;
  private String password;
}
