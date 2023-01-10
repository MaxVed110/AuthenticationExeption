package UserAuthentication;

//Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
//Login должен содержать только латинские буквы, цифры и знак подчеркивания.
//Длина login должна быть меньше 20 символов. Если login не соответствует этим требованиям, необходимо
//выбросить WrongLoginException.
//Password должен содержать только латинские буквы, цифры и знак подчеркивания. Длина password должна
//быть меньше 20 символов. Также password и confirmPassword должны быть равны.
//Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
//WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами –
//один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
//Метод возвращает true, если значения верны или false в другом случае.


public class UserRegistration {
    public static void main(String[] args) {
        String log = "afggfz322";
        String pass = "dads_22";
        String conPass = "dads_22";
        System.out.println(isRegistration(log, pass, conPass));
    }

    // Зачем методу возвращать false при невыполнении условий, если будут выкинуты исключения?
    public static boolean isRegistration(String login, String password, String confirmPassword) {

        if (!login.matches("[a-zA-Z0-9_]{1,20}")) {
            throw new WrongLoginException();
        }

        if (!password.matches("[a-zA-Z0-9_]{1,20}")) {
            throw new WrongPasswordException();
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        return true;
    }
}
