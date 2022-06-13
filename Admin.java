import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Admin extends User {



    public Admin(String username, String password, Scanner a,boolean cfile) {
        super(username, password, a,cfile);
        if(cfile){
        updateFile(this, "Admin");
        }
    }
    
    /** 
     * returns the type of the user
     * @return "the type of the object (in this case, Admin)"
     */
    public String type(){
        return "Admin";
    }

}
