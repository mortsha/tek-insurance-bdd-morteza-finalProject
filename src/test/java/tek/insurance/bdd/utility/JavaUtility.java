package tek.insurance.bdd.utility;

public class JavaUtility {

    public static void main(String[] args) {

    }

    public static String getFirstCharacterCapital(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }
}
