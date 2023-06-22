package userdata.storage;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import userdata.UserDataException;

public class UserDataSaveException extends UserDataException {

    public UserDataSaveException(Throwable cause) {
        super(getMessage(cause));
    }

    private static String getMessage(Throwable cause) {
        String f = "Не удалось сохранить данные пользователя в файл.\n%s";
        var stackTracing = new ByteArrayOutputStream();
        cause.printStackTrace(new PrintWriter(stackTracing));
        return String.format(f, stackTracing.toString());
    }
}
