package in.reqres.models.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInfoResponsePOJO {
    private Data data;
    private Support support;

    @Setter
    @Getter
    public static class Data {
        private int id;
        private String email;
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("last_name")
        private String lastName;
        private String avatar;

    }

    @Setter
    @Getter
    public static class Support {
        private String url;
        private String text;

    }
}
