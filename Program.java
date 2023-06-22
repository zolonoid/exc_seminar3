import java.util.Scanner;
import userdata.UserDataException;
import userdata.checker.UserDataChecker;
import userdata.parser.UserDataParser;
import userdata.storage.UserDataStorage;

/**
 * Напишите приложение, которое будет запрашивать у пользователя следующие
 * данные в произвольном порядке, разделенные пробелом: ФИО, дата рождения,
 * номер телефона, пол.
 */
public class Program {

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            System.out.print(
                    "Укажите Фамилию, Имя, Отчество, дату рождения (dd.mm.yyyy) телефон (11 цифр), пол (f или m)."
                            + "\nДанные вводятся через пробел в произвольном порядке.\n");
            sc = new Scanner(System.in, System.console().charset());
            String userData = sc.nextLine();
            UserDataChecker.check(userData);
            var parser = new UserDataParser(userData);
            UserDataStorage.save(parser);
        } catch (UserDataException e) {
            System.out.print(e.getMessage());
        } catch (Exception e) {
            System.out.print("Что-то пошло не так...");
        } finally {
            if (sc != null)
                sc.close();
        }
    }
}
