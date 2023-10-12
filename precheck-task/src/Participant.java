import java.util.List;

public class Participant {

    public enum SportType {
        TENNIS, SOCCER, SWIMMING, BASKETBALL, ATHLETICS
    }

    private String name;
    private String surname;
    private int age;
    private SportType sportType;
    private List<String> awards;

    public Participant(String name, String surname, int age, SportType sportType, List<String> awards) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sportType = sportType;
        this.awards = awards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    @Override
    public String toString() {
        return "Participant [name=" + name + ", surname=" + surname + ", age=" + age + ", sportType=" + sportType
                + ", awards=" + awards + "]";
    }

}