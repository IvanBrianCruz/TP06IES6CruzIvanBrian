package app.models;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {

    public static int calculateAge(LocalDate birthdate) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthdate, currentDate);
        return period.getYears();
    }
}
