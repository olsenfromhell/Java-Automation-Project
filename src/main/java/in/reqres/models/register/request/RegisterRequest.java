package in.reqres.models.register.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterRequest {
  private String email;
  private String password;
}
