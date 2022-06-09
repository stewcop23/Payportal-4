import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private boolean isLogged = false;
    private Scanner scan;
    private static ArrayList<User> users = new ArrayList<User>();

    
    public User(String username, String password, Scanner a, boolean cfile) {
        this.scan = a;
        this.username = username;
        this.password = password;
        if (cfile) {
            users.add((User) this);

            try (FileWriter usersFile = new FileWriter("users.txt", true)) {
                usersFile.write(username + "\n");
            } catch (Exception e) {
                System.out.println("Error writing to file");
            }

            try (FileWriter write = new FileWriter("User_" + username + ".txt", true)) {

                write.write(this.username + "\n");
                write.write(this.password + "\n");


                System.out.println("New user created");

                // }
                // else{
                // System.out.println("User already exists");
                // }
            } catch (Exception e) {
                System.out.println("Error creating user");
            }

        }
    }

    public boolean login(String username, String password) {

        if (username.equals(this.username) && password.equals(this.password)) {
            for (User user : users) {
                user.setLogged(false);
            }
            System.out.println(this.getUsername());
            isLogged = true;
            return true;
        } else {
            return false;
        }
    }

    public String type() {
        return "User";
    }

    public void setLogged(boolean log) {
        isLogged = log;
    }

    public boolean islogged() {
        return this.isLogged;
    }

    public void changePassword(String newPassword) {
        if (isLogged) {
            this.password = newPassword;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;

    }

    public static ArrayList<User> getUserArray() {
        return users;
    }

    public String getInfo(String what) {
        System.out.print(what + ":");
        String a = "";

        a = scan.nextLine();

        return a;
    }

    public void updateFile(File file, User user, String info) {
        updateFile(file, user, info, true);
    }

    public void updateFile(File file, User user, String info, boolean newline) {
        File data = new File("User_" + user.getUsername() + ".txt");
        try (FileWriter write = new FileWriter(data, true)) {

            write.write(info + (newline ? "\n" : ""));

        } catch (Exception e) {
        }
    }

    public static void addtoArray(User user) {
        users.add(user);
    }

    public static boolean duExist(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return true;
            }
        }
        return false;
    }
public static int getUserIndex(String uname){
    for (int i = 0; i < users.size(); i++) {
        if (users.get(i).getUsername().equals(uname)) {
            return i;
        }
    }
    return -1;
}
    public static User findUser(String uname) {
        for (User user : users) {
            if (user.getUsername().equals(uname)) {
                return user;
            }
        }
        return null;
    }
    public static User getloggedinUser(){
        for (User user : users) {
            if (user.islogged()) {
                return user;
            }
        }
        return null;
    }
    public String toString(){
        return this.username;
    }

}
