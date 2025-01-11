package in.reqres.models.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRegistrationRequestPOJO {
    private String name;
    private String job;
}
