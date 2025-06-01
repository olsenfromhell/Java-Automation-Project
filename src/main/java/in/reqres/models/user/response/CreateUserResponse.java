package in.reqres.models.user.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
  private String name;
  private String job;
  private String id;
  private String createdAt;
}
