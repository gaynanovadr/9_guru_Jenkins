package demoga.testData;

import demoga.utils.Month;
import com.github.javafaker.Faker;
import java.util.Locale;

public class UserInfo {

    private static final Faker faker = new Faker(new Locale("de"));

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = faker.internet().safeEmailAddress();
    public static String number = String.valueOf(faker.phoneNumber().subscriberNumber(10));
    public static String gender = faker.demographic().sex();
    public static String pic = "pic.png";
    public static String hobby = "Sports";
    public static String subject = "English";
    public static String path = "src/test/resources/pic.png";
    public static String address = String.valueOf(faker.address().fullAddress());
    public static String state = "NCR";
    public static String city = "Noida";
    public static String day = String.valueOf(faker.number().numberBetween(1, 31));
    public static String month = String.valueOf(Month.getRandomMonth());
    public static String year = String.valueOf(faker.number().numberBetween(1950, 2010));
    public static String date = day + " " + month + "," + year;

}
