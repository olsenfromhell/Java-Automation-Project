package in.reqres.models.resource.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class ResourceResponse {
  private List<Data> data;
  private Support support;

  private int page;

  @JsonProperty("per_page")
  private int perPage;

  private int total;

  @JsonProperty("total_pages")
  private int totalPages;

  @lombok.Data
  public static class Data {
    private int id;
    private String name;
    private int year;
    private String color;

    @JsonProperty("pantone_value")
    private String pantoneValue;
  }

  @lombok.Data
  public static class Support {
    private String url;
    private String text;
  }
}
