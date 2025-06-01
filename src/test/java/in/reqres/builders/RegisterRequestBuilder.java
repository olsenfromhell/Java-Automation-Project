package in.reqres.builders;

import in.reqres.models.register.request.RegisterRequest;

public class RegisterRequestBuilder {
  private String email;
  private String password;

  public static RegisterRequestBuilder registrationRequest() {
    return new RegisterRequestBuilder();
  }

  public RegisterRequestBuilder email(String email) {
    this.email = email;
    return this;
  }

  public RegisterRequestBuilder password(String password) {
    this.password = password;
    return this;
  }

  public RegisterRequest build() {
    return new RegisterRequest(email, password);
  }
}
