public class User {

    private String name;
    private String surname;
    private int age;
    private List<User> knows;

    public User(String name, String surname, int age, List<User> knows) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.knows = knows;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<User> getKnows() {
        return this.knows;
    }

    public void setKnows(List<User> knows) {
        this.knows = knows;
    }

}