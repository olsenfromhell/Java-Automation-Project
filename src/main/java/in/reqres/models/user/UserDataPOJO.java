package in.reqres.models.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDataPOJO {
    private Data data;
    private Support support;

    @Setter
    @Getter
    public static class Data {
        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

    }

    @Setter
    @Getter
    public static class Support {
        private String url;
        private String text;

    }
}
