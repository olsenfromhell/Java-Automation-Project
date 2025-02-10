package in.reqres.models.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserRequest {
    private String name;
    private String job;
}
