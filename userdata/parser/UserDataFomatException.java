package userdata.parser;

import userdata.UserDataException;

public class UserDataFomatException extends UserDataException {

    public UserDataFomatException(String message) {
        super("Неверный формат данных. " + message);
    }

}
