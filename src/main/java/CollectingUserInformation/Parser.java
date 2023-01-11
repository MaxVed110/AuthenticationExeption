package CollectingUserInformation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class Parser {
    public Parser() {

    }

    public ArrayList<String> parsName(String inputName) {
        try {
            return new ArrayList<>(Arrays.asList(inputName.split(" ")));
        } catch (Exception e) {
            throw new RuntimeException("Введенные ФИО в некорректном формате");
        }
    }

    public LocalDate dateOfBirth(String inputDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
            return LocalDate.parse(inputDate, formatter);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Формат введенной даты рождения некорректен, попробуйте dd mm yyyy");
        }
    }

    public String numberPhone(String inputPhone) {
        try {
            Long lPhone = Long.valueOf(inputPhone);
            return String.valueOf(lPhone).replaceFirst(
                    "(\\+7|8)[\\s(]?(\\d{3})[\\s)]?(\\d{3})[\\s-]?(\\d{2})[\\s-]?(\\d{2})",
                    "8 ($2) $3-$4-$5");
        } catch (Exception e) {
            throw new RuntimeException("Номер телефона введен некорректно");
        }
    }
}
