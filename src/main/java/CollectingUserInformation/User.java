package CollectingUserInformation;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;

// Фамилия Имя Отчество датарождения номертелефона пол
// Форматы данных:
// * фамилия, имя, отчество - строки
// * датарождения - класс LocalDate, паттерн - dd.mm.yyyy
// * номертелефона - строка. Не обязательно, попробуйте привести телефон к определенному формату.
// Только российские номера, начинаются с 8, без кода.
// * пол - символ латиницей f или m. Попробуйте enum использовать.
//
// Все данные должны быть заполнены. Если количество не совпадает с требуемым, вернуть код ошибки,
// обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
//
// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать
// встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение
// с информацией, что именно неверно.
//
// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в
// одну строку должны записаться полученные данные, вида
//
// Попробуйте csv, можно просто в txt. Но сделать заголовки.
// <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//
// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
// Смотреть есть ли файл с фамилией. File.isExist();
// Не забудьте закрыть соединение с файлом.
//
// При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь
// должен увидеть стектрейс ошибки.

enum Gender { MALE, FEMALE };

public class User {
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String numberPhone;

    private Gender gender;

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastNameNameName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setName(List<String> name) {
        this.firstName = name.get(0);
        this.lastName = name.get(1);
        this.patronymic = name.get(2);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setGender(String gender) {
        if (gender.equals("f")) {
            this.gender = Gender.FEMALE;
        } else if (gender.equals("m")) {
            this.gender = Gender.MALE;
        } else {
            throw new InputMismatchException("Пол не соответствует объявленному формату");
        }
    }

    public String toString() {
        return firstName + ' ' + lastName + ' ' + patronymic
                + ' ' + dateOfBirth + ' ' + numberPhone + ' ' + gender;
    }
}
