package in.reqres.models.register.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;

    public RegisterRequest(String email) {
        this.email = email;
    }
}
