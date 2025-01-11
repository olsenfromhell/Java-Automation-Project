package in.reqres.models.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResourcePOJO {

    private List<Data> data;
    private Support support;

    private int page;
    @JsonProperty("per_page")
    private int perPage;
    private int total;
    @JsonProperty("total_pages")
    private int totalPages;

    @Getter
    @Setter
    public static class Data {
        private int id;
        private String name;
        private int year;
        private String color;
        @JsonProperty("pantone_value")
        private String pantoneValue;
    }

    @Getter
    @Setter
    public static class Support {
        private String url;
        private String text;

    }
}
