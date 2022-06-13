import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Admin extends User {



    public Admin(String username, String password, Scanner a,boolean cfile) {
        super(username, password, a,cfile);
        if(cfile){
        File data = new File("User_"+this.getUsername()+".txt");
        updateFile(data, this, "Admin");
        }
    }
    
    /** 
     * returns the type of the user
     * @return String
     */
    public String type(){
        return "Admin";
    }

}
