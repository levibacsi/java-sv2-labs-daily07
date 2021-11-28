package day01;

import java.time.LocalDate;

public class Human {
    private String name;
    private int yearOfBirth;

    public Human(String name, int yearOfBirth) {
        if (isNameValid(name) && isYearOfBirthValid(yearOfBirth)) {
            this.name = name;
            this.yearOfBirth = yearOfBirth;
        }
    }

    public boolean isNameValid (String name){
        if (name.indexOf(" ") > 0 && name.indexOf(" ") < (name.length() - 1)) {
            return true;
        } else {
            throw new IllegalArgumentException("Name must contain first name and surname.");
        }
    }

    public boolean isYearOfBirthValid (int yearOfBirth){
        if (LocalDate.now().getYear() - yearOfBirth > 0 && LocalDate.now().getYear() - yearOfBirth <= 120) {
            return true;
        } else {
            throw new IllegalArgumentException("Age must be between 0 and 120 years.");
        }
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
