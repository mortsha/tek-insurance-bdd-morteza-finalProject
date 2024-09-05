package tek.insurance.bdd.utility;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class JavaUtility {


    public static String getFirstCharacterCapital(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }

    public static DateTimeFormatter dateTimeFormatter() {
        return new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMMM d, yyyy").toFormatter(Locale.ENGLISH);
    }

    public static ZoneId getESTZoneId() {
        return ZoneId.of("America/New_York");
    }



}
