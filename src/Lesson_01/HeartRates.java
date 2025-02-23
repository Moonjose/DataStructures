package Lesson_01;
import java.time.LocalDate;

public class HeartRates {
    private String name;
    private String lastName;
    private int birthDay;
    private int birthMonth;
    private int birthYear;

    public HeartRates(String name, String lastName, int birthDay, int birthMonth, int birthYear) {
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int calculateAge() {
        int currentYear = LocalDate.now().getYear();
        return currentYear - this.birthYear;
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }

    public float[] calculateTargetHeartRate() {
        float[] targets = new float[2];
        float firstTarget = (float) (0.5 * calculateMaxHeartRate());
        float secondTarget = (float) (0.85 * calculateMaxHeartRate());
        targets[0] = firstTarget;
        targets[1] = secondTarget;
        return targets;
    }
}