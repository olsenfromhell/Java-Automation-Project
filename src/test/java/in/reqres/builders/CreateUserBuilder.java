package in.reqres.builders;

import in.reqres.models.user.request.CreateUserRequest;

public class CreateUserBuilder {
  String name;
  String job;

  public static CreateUserBuilder createUser() {
    return new CreateUserBuilder();
  }

  public CreateUserBuilder name(String name) {
    this.name = name;
    return this;
  }

  public CreateUserBuilder job(String job) {
    this.job = job;
    return this;
  }

  public CreateUserRequest build() {
    return new CreateUserRequest(name, job);
  }
}
