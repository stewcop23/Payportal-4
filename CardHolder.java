import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CardHolder extends User {
    private String name;
    private String email;
    private String phoneNumber;
    private ArrayList<Card> cards = new ArrayList<Card>();

    public CardHolder(String username, String password, String name, String email, String phoneNumber, Scanner a,
            boolean cfile) {
        super(username, password, a, cfile);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        if (cfile) {
            File data = new File("User_" + this.getUsername() + ".txt");
            updateFile(data, this, "CH");
            updateFile(data, this, name + "," + email + "," + phoneNumber);
            updateFile(data, this, "0");
        }
    }

    public String type() {
        return "CH";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void createCard(Card card) {
        try {
            File orig = new File("User_" + this.getUsername() + ".txt");
            File newf = new File("User_" + this.getUsername() + "_temp.txt");
            FileWriter temp = new FileWriter(newf);
            Scanner old = new Scanner(orig);
            while (old.hasNextLine()) {
                temp.write(old.nextLine() + "\n");
            }
            FileWriter update = new FileWriter(orig);
            temp.close();
            Scanner news = new Scanner(newf);
            for (int i = 0; i < 4; i++) {
                update.write(news.nextLine() + "\n");
            }
            int count = news.nextInt() + 1;

            update.write(count + "\n");
            update.write(card.toString() + "\n");
            news.nextLine();
            while (news.hasNextLine()) {
                update.write(news.nextLine() + "\n");
            }
            update.close();
            temp.close();
            // cards.add(card);

            old.close();
            news.close();
            newf.delete();

        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

}
