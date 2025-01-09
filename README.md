### Automation Project in Java

This project is dedicated to practicing writing UI and API tests using the Arrange-Act-Assert pattern and Page Object model.
The technologies and frameworks used in this project include:

- Selenide: for browser automation and UI testing.
- Rest Assured: for API testing (yet to be written).
- JUnit 5: for writing and running tests.
- Jenkins w/ Allure Reports: for CI and generating test reports.
- Java Collections Framework: for handling data structures.
- Stream API: for processing collections of objects.
- DataFaker: for generating data in tests.
- Gradle: for project build and dependency management.

The project is in development and I update it from time to time.

All tests are run with ```./gradlew test``` from root.

<hr>

**UI tests contain:**

[Verify account test](https://github.com/olsenfromhell/Java-Automation-Project/blob/main/src/test/java/dev/qaplayground/VerifyAccountTest.java):
- <i>Enter a valid code by pressing the key-up button or typing a number and assert success message.</i>

[Tags input box tests](https://github.com/olsenfromhell/Java-Automation-Project/blob/main/src/test/java/dev/qaplayground/TagsInputBoxTest.java):
- <i>Add a tag and verify its presence.</i>
- <i>Remove a tag and verify it is removed.</i>

[Upload image test](https://github.com/olsenfromhell/Java-Automation-Project/blob/main/src/test/java/dev/qaplayground/UploadFileTest.java):
- <i>Upload an image file and assert the file's name.</i>

[Download file test](https://github.com/olsenfromhell/Java-Automation-Project/blob/main/src/test/java/dev/qaplayground/DownloadFileTest.java):
- <i>Download a file and assert the file's name and size.</i>

<hr>

**API tests contain:**

[Get user by ID test](https://github.com/olsenfromhell/Java-Automation-Project/blob/main/src/test/java/in/reqres/GetUserByIdTest.java):
- <i>Send a GET request to retrieve user information by user ID and assert the user's details and support information.</i>
