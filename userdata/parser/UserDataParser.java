package userdata.parser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDataParser {
    private String userData;
    private ArrayList<String> name;
    private String birthDate;
    private String phone;
    private String sex;

    public UserDataParser(String userData)
            throws NameFomatException, BirthDateFomatException, PhoneFomatException, SexFomatException,
            UserDataFomatException {
        try {
            name = new ArrayList<String>();
            this.userData = userData;
            parseName();
            parseBirthDate();
            parsePhone();
            parseSex();
        } catch (UserDataFomatException e) {
            throw e;
        } catch (Exception e) {
            throw new UserDataFomatException(e.getMessage());
        }
    }

    private void parseName() throws NameFomatException {
        Matcher matcher = getMatcher("[A-ZА-Я][a-zа-я]+");
        while (matcher.find()) {
            name.add(matcher.group());
        }
        if (name.size() != 3)
            throw new NameFomatException();
    }

    private void parseBirthDate() throws BirthDateFomatException {
        Matcher matcher = getMatcher("\\d{2}\\.\\d{2}\\.\\d{4}");
        if (!matcher.find())
            throw new BirthDateFomatException();
        birthDate = matcher.group();
    }

    private void parsePhone() throws PhoneFomatException {
        Matcher matcher = getMatcher("\\d{11}");
        if (!matcher.find())
            throw new PhoneFomatException();
        phone = matcher.group();
    }

    private void parseSex() throws SexFomatException {
        Matcher matcher = getMatcher("(?:^([mf]))|(?:\\s([mf]))");
        if (!matcher.find())
            throw new SexFomatException();
        sex = matcher.group(1) != null ? matcher.group(1) : matcher.group(2);
    }

    private Matcher getMatcher(String pattern) {
        Pattern ptrn = Pattern.compile(pattern);
        Matcher matcher = ptrn.matcher(userData);
        return matcher;
    }

    @Override
    public String toString() {
        String f = "<%s><%s><%s><%s><%s><%s>";
        return String.format(f, name.get(0), name.get(1), name.get(2), birthDate, phone, sex);
    }

    public String[] getFullName() {
        return name.toArray(new String[0]);
    }
}
