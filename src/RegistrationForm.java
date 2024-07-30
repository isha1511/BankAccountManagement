import java.util.Scanner;
import java.util.regex.*;

public class RegistrationForm {

    private static final String validName="^[A-Z][a-z]{2,}$";

    private static final String validEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    private static final String InvalidEmail =
            "^([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})*[^a-zA-Z])|"
                    + "^[^@]+@[^@]+$";

    private static final String valid_No="^[0-9]{10}$";
    private static final String valid_No_WithContryCode="^\\+[0-9]{1,3}[0-9]{10}$";

    private static final String validPass="^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\\\/-]).{8,}$";

    private static final Pattern patternobj1=Pattern.compile(validName);

    private static final Pattern patternobj2= Pattern.compile(validEmail);
    private static final Pattern invalidPattern= Pattern.compile(InvalidEmail);

    private static final Pattern patternobj3= Pattern.compile(valid_No);
    private static final Pattern patternobj4= Pattern.compile(valid_No_WithContryCode);

    private static final Pattern patternobj5= Pattern.compile(validPass);


    private static boolean isValidName(String name){

        return patternobj1.matcher(name).matches();
    }

    private static boolean isValidMobNo(String no) {

        return patternobj3.matcher(no).matches() || patternobj4.matcher(no).matches();

    }

    private static boolean isValidEmail(String email) {

        if(patternobj2.matcher(email).matches()){
            return true;
        }
        else if(invalidPattern.matcher(email).matches()){
            return false;
        }
        return false;
    }

    private static boolean isValidPass(String pass){

        return patternobj5.matcher(pass).matches();
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("REGISTRATION FORM");
        System.out.println("Fill all the details carefully");
        System.out.println();

        boolean check = false;
        String firstName;

        while (!check) {
            System.out.println("Enter your first name");

            firstName = sc.next();

            check=isValidName(firstName);

            if (!check) {
                System.out.println("First name must start with an uppercase letter. Please try again.");
                System.out.println("First name must contains more than 3 characters");
            }

        }
        check = false;
        String lastName;

        while (!check) {
            System.out.println("Enter your last name");

            lastName = sc.next();

            check=isValidName(lastName);

            if (!check) {
                System.out.println("Last name must start with an uppercase letter.");
                System.out.println("Last name must contains more than 3 characters.Please try again");
            }

        }
        check=false;

        System.out.println("Enter your email-id");
        while(!check) {

            String email = sc.next();

            check =isValidEmail(email);

            if (!check) {

                System.out.println("Enter valid email-id");
            }
        }

        check=false;

        System.out.println("Enter your Mobile No with or without country code");
        while(!check) {
            String no = sc.next();

            check = isValidMobNo(no);

            if(!check){

                System.out.println("Enter valid mobile no");
            }
        }

        System.out.println("Enter Password");

        check=false;
        while(!check){

            String password=sc.next();

            check=isValidPass(password);

            if(!check){
                System.out.println("Password must contain at least one capital letter and at least one number and exactly one special symbol");
            }
        }
    }
}
