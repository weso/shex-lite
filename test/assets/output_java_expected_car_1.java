public class Car {

  private String platenumber;
  private User owner;

  public Car(String platenumber, User owner) {
    this.platenumber = platenumber;
    this.owner = owner;
  }

  public String getPlatenumber() {
    return this.platenumber;
  }

  public void setPlatenumber(String platenumber) {
    this.platenumber = platenumber;
  }

  public User getOwner() {
    return this.owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }
}
