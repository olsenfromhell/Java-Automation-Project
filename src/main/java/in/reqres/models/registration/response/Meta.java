package in.reqres.models.registration.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Meta {

  @JsonProperty("powered_by")
  private String poweredBy;

  @JsonProperty("docs_url")
  private String docsUrl;

  @JsonProperty("upgrade_url")
  private String upgradeUrl;

  @JsonProperty("example_url")
  private String exampleUrl;

  private String variant;
  private String message;
  private Cta cta;
  private String context;
}
