
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class VulnerableApp {

    // Hardcoded credentials (Gitleaks sẽ báo)
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "123456"; // ❌ Hardcoded password

    // Hardcoded API Key (Gitleaks sẽ báo)
    private static final String STRIPE_API_KEY = "sk_test_51MuQ0yExampleKey123456789";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String user = scanner.nextLine();

        System.out.print("Enter password: ");
        String pass = scanner.nextLine();

        login(user, pass);

        String secret = "aws_secret_access_key = wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY"; // ❌ AWS secret key

        String jsonInput = "{\"user\":\"" + user + "\", \"pass\":\"" + pass + "\"}"; // ❌ Unsafe JSON building
        System.out.println("Payload: " + jsonInput);

        dangerousFunction("rm -rf /"); // ❌ Command injection risk
    }

    public static void login(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();

            // ❌ SQL Injection
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            stmt.executeQuery(query);

            System.out.println("User authenticated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dangerousFunction(String input) {
        try {
            Runtime.getRuntime().exec("sh -c " + input); // ❌ Dangerous use of exec()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ❌ Insecure random usage
    public static String getToken() {
        double token = Math.random() * 1000000;
        return String.valueOf(token);
    }

    // ❌ Hardcoded SSH key
    private static final String SSH_PRIVATE_KEY = "-----BEGIN RSA PRIVATE KEY-----\nMIICXQIBAAKBgQC...END RSA PRIVATE KEY-----";

}
