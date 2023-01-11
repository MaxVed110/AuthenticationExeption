package CollectingUserInformation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Core {
    public Core() {

    }

    public void start() {
        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);
        ImportFile importFile = new ImportFile();
        System.out.println("Вам необходимо ввесди требуемые данные в представленном формате.... "
                + "(для выхода в любое время введите exit)");
        while (true) {
            User newUser = new User();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException("Программа была остановлена во время программной задержки", e);
            }
            System.out.print("Введите фамилию, имя и отчество через пробел в латинской раскладке... ");
            newUser.setName(parser.parsName(sc.nextLine()));
            System.out.print("Введите дату рождения (формат - дд мм гггг)... ");
            newUser.setDateOfBirth(parser.dateOfBirth(sc.nextLine()));
            System.out.print("Введите номер телефона (формат - +7 или 8 и 10 цифр)... ");
            newUser.setNumberPhone(parser.numberPhone(sc.nextLine()));
            System.out.print("Введите Ваш гендер (f или m)... ");
            newUser.setGender(sc.nextLine());

            Path path = Paths.get(newUser.getFirstName() + ".xml");
            if (Files.exists(path)) {
                importFile.createXml(newUser, importFile.addInXml(newUser, newUser.getFirstName() + ".xml"));
            } else {
                importFile.createXml(newUser, importFile.xmlWrite(newUser));
            }
        }
    }
}
