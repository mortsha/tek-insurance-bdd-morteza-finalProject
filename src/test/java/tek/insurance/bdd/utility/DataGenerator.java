package tek.insurance.bdd.utility;

public class DataGenerator {

    public static void main(String[] args) {
        String actualErrorMessage = "ERROR\nAccount with email Steve7274@happy.ca is exist";
        String change = actualErrorMessage.replace("ERROR", "").trim();
        System.out.println(change);


        String email = "Mori675ds@gmail.com";
        String username = email.substring(0 ,email.indexOf("@"));
        System.out.println("___________" + username);

    }

    public static String getRandomEmail(String name) {
        int randomNumber = (int) (Math.random() * 10000);
        return name + +randomNumber + "@happy.ca";
    }
}
