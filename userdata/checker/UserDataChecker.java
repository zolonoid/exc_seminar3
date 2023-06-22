package userdata.checker;

public class UserDataChecker {

    public static void check(String userData) throws UserDataSizeException {
        if (userData == null)
            throw new UserDataSizeException(0, 6);
        int size = userData.split("\\s").length;
        if (size != 6)
            throw new UserDataSizeException(size, 6);
    }
}
