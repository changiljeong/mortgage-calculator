package mortgagepay.model;

public class UserInfo {

  private String name;
  private String email;
  private String address;
  private int zipCode;

  public UserInfo(String name, String email, String address, int zipCode) {
    this.name = name;
    this.email = email;
    this.address = address;
    this.zipCode = zipCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "UserInfo{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
