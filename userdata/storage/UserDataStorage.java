package userdata.storage;

import java.io.FileWriter;
import java.io.IOException;
import userdata.parser.UserDataParser;

public class UserDataStorage {

    public static void save(UserDataParser userData) throws UserDataSaveException {
        try (FileWriter file = getFileBySurname(userData.getFullName()[0])) {
            file.write(userData.toString() + "\n");
        } catch (Exception e) {
            throw new UserDataSaveException(e);
        }
    }

    private static FileWriter getFileBySurname(String surname) throws IOException {
        String fileName = surname + ".txt";
        return new FileWriter(fileName, true);
    }
}
