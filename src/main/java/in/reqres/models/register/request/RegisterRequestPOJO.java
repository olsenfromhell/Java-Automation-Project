package in.reqres.models.register.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterRequestPOJO {
    private String email;
    private String password;

    public RegisterRequestPOJO(String email) {
        this.email = email;
    }
}
