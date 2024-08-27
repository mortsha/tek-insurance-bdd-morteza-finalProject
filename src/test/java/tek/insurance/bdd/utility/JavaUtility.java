package tek.insurance.bdd.utility;

public class JavaUtility {

    public static void main(String[] args) {

    String text = "User WRONG_USERNAME not found";
    String replace = text.replace("WRONG_USERNAME","Mori");
        System.out.println(replace);
    }

    public static String getFirstCharacterCapital(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }
}
