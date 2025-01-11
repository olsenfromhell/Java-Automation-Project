package in.reqres.models.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationResponsePOJO {
    private String name;
    private String job;
    private String id;
    private String createdAt;
}