
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        /*
         * Admin stew = new Admin("a","b",scan);
         * CardHolder jim = new CardHolder("c","d",scan);
         */
        ArrayList<User> users = getUsers();

        GUI.main(args);
        //GUI.mainGUI(users.get(1));
        // System.out.println(((CardHolder)users.get(1)).getCards().get(1).getCardNumber());
    }

    public static ArrayList<User> getUsers() {
        try {
            FileReader read = new FileReader("users.txt");
            Scanner readScan = new Scanner(read);
            ArrayList<String> names = new ArrayList<String>();

            while (readScan.hasNextLine()) {
                names.add(readScan.nextLine());
            }
            read.close();
            readScan.close();
            for (String uname : names) {
                FileReader read2 = new FileReader("User_" + uname + ".txt");
                Scanner readScan2 = new Scanner(read2);
                readScan2.nextLine();
                String pass = readScan2.nextLine();
                String mode = readScan2.nextLine();
                if (mode.equals("Admin")) {
                    User.addtoArray(new Admin(uname, pass, new Scanner(System.in), false));
                    readScan2.close();
                    read2.close();
                } else {
                    String extra = readScan2.nextLine();
                    int index = Integer.parseInt(readScan2.nextLine());

                    User.addtoArray(new CardHolder(uname, pass, extra.split(",")[0], extra.split(",")[1],
                            extra.split(",")[2], new Scanner(System.in), false));
                    for (int i = 0; i < index; i++) {
                        String ctext = readScan2.nextLine();
                        String type = ctext.split(",")[0];
                        String number = ctext.split(",")[1];
                        int expmoth = Integer.parseInt(ctext.split(",")[2]);
                        int expyear = Integer.parseInt(ctext.split(",")[3]);
                        int cvv = Integer.parseInt(ctext.split(",")[4]);
                        int ballance = Integer.parseInt(ctext.split(",")[5]);
                        if (type.equals("V")) {
                            ((CardHolder) User.getUserArray().get(User.getUserIndex(uname)))
                                    .addCard(new Visa(number, expmoth, expyear, cvv, ballance));
                        } else if (type.equals("D")) {
                            ((CardHolder) User.getUserArray().get(User.getUserIndex(uname)))
                                    .addCard(new Debit(number, expmoth, expyear, cvv, ballance));
                        }

                    }
                    readScan2.close();
                    read2.close();
                }

            }

            // System.out.println(User.getUserArray().get(1).getPassword());
            // for(User a : User.getUserArray()){
            // System.out.println(a.getUsername());
            // }

            return User.getUserArray();
        } catch (Exception e) {
            System.out.println("something went wrong");
            return null;
        }

    }
}