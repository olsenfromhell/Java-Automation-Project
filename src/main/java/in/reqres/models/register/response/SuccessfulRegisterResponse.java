package in.reqres.models.register.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessfulRegisterResponse {
    private int id;
    private String token;
}
