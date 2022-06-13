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

    
    /** 
     * If username and password are correct, log the user in, then return true. otherwise return false.
     * @param username
     * @param password
     * @return boolean
     */
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

    
    /** 
     * return the type of the user, in this case User
     * @return String
     */
    public String type() {
        return "User";
    }

    
    /** 
     * sets the logged in value of this user
     * @param log
     */
    public void setLogged(boolean log) {
        isLogged = log;
    }

    
    /** 
     * @return boolean
     */
    public boolean islogged() {
        return this.isLogged;
    }

    
    /** 
     * @param newPassword
     */
    public void changePassword(String newPassword) {
        if (isLogged) {
            this.password = newPassword;
        }
    }

    
    /** 
     * @return String
     */
    public String getUsername() {
        return username;
    }

    
    /** 
     * @return String
     */
    public String getPassword() {
        return password;

    }

    
    /** 
     * @return ArrayList<User>
     */
    public static ArrayList<User> getUserArray() {
        return users;
    }

    
    /** 
     * usefull method for cllecting info from a user, the passed in string will be asked to the user for input
     * @param what
     * @return String
     */
    public String getInfo(String what) {
        System.out.print(what + ":");
        String a = "";

        a = scan.nextLine();

        return a;
    }

    
    /** 
     * calls the updateFile(File, User, String,boolean) mwith the boolean being set to true
     * @param file
     * @param user
     * @param info
     */
    public void updateFile(File file, User user, String info) {
        updateFile(file, user, info, true);
    }

    
    /** 
     * adds the info to the file, if newline is true, it will add a newline to the end of the info
     * @param file
     * @param user
     * @param info
     * @param newline
     */
    public void updateFile(File file, User user, String info, boolean newline) {
        File data = new File("User_" + user.getUsername() + ".txt");
        try (FileWriter write = new FileWriter(data, true)) {

            write.write(info + (newline ? "\n" : ""));

        } catch (Exception e) {
        }
    }

    
    /** 
     * @param user
     */
    public static void addtoArray(User user) {
        users.add(user);
    }

    
    /** 
     * checks to see if a user with a given username already exists
     * @param name
     * @return boolean
     */
    public static boolean duExist(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return true;
            }
        }
        return false;
    }

/** 
 * checks the users array to find the index of the user with the given username
 * @param uname
 * @return int
 */
public static int getUserIndex(String uname){
    for (int i = 0; i < users.size(); i++) {
        if (users.get(i).getUsername().equals(uname)) {
            return i;
        }
    }
    return -1;
}
    
    /** 
     * returns the user object for the user with the given username
     * @param uname
     * @return User
     */
    public static User findUser(String uname) {
        for (User user : users) {
            if (user.getUsername().equals(uname)) {
                return user;
            }
        }
        return null;
    }
    
    /** 
     * returns the current logged in user
     * @return User
     */
    public static User getloggedinUser(){
        for (User user : users) {
            if (user.islogged()) {
                return user;
            }
        }
        return null;
    }
    
    /** 
     * @return String
     */
    public String toString(){
        return this.username;
    }

}
