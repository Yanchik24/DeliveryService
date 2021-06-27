package eu.exposit.consoleApp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static EmailValidator instance;

    public static EmailValidator getInstance() {
        if (instance == null) {
            instance = new EmailValidator();
        }
        return instance;
    }
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern=Pattern.compile(EMAIL_PATTERN);

    public boolean validate(final String hex) {

        Matcher matcher = pattern.matcher(hex);

        return matcher.matches();
    }
}
