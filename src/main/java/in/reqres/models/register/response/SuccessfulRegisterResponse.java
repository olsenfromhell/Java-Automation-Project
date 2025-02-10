package in.reqres.models.register.response;

import lombok.Data;

@Data
public class SuccessfulRegisterResponse {
    private int id;
    private String token;
}
