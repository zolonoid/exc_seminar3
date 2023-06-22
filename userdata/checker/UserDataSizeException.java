package userdata.checker;

import userdata.UserDataException;

public class UserDataSizeException extends UserDataException {

    public UserDataSizeException(int curSize, int reqSize) {
        super(getMessage(curSize, reqSize));
    }

    private static String getMessage(int curSize, int reqSize) {
        return curSize > reqSize
                ? "Количество данных больше, чем требуется."
                : "Количество данных меньше, чем требуется.";
    }
}
