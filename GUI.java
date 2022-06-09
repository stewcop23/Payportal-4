
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI {
    static boolean loggedin = false;
    static JFrame frame = new JFrame("GUI");


    public static void main(String[] args) {
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        double width = size.getWidth();
        double height = size.getHeight();

        JButton loginButton = new JButton("Click to login");
        int bttnwdth = 1000;
        int bttnhgt = 500;
        loginButton.setBounds((int) width / 2 - (bttnwdth / 2), (int) height / 2 - (bttnhgt / 2), bttnwdth, bttnhgt);
        loginButton.setFont(new Font("Arial", Font.BOLD, 40));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();

            }

        });

        frame.add(loginButton);

        frame.setSize(size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        while (loggedin == false) {
            System.out.println(loggedin);
        }
        System.out.println(loggedin);
        frame.setVisible(false);
        User on = null;
        
        for(User user:User.getUserArray()){
            if (user.islogged()){
                on = user;
            }
        }
        GUI.mainGUI(on);
    }

    private static void login() {
        JFrame loginbox = new JFrame("Login");
        JLabel unameLbl = new JLabel("Username:");
        unameLbl.setBounds(0, 0, 1000, 50);
        JTextField unameField = new JTextField();
        unameField.setBounds(0, 50, 200, 50);
        JLabel passLbl = new JLabel("Password:");

        passLbl.setBounds(0, 100, 1000, 50);
        JTextField passField = new JTextField();
        passField.setBounds(0, 150, 200, 50);
        JButton submit = new JButton("Submit");
        submit.setBounds(0, 200, 150, 75);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {

                if (User.duExist(unameField.getText())) {
                    if (User.findUser(unameField.getText()).login(unameField.getText(), passField.getText())) {
                        loginbox.setVisible(false);
                        loggedin = true;

                    }
                } else {
                    errorMsg("bad Uname");
                }
            }
        });

        loginbox.add(unameField);
        loginbox.add(unameLbl);
        loginbox.add(passField);
        loginbox.add(passLbl);
        loginbox.add(submit);
        loginbox.setSize(1000, 1000);
        loginbox.setLayout(null);
        loginbox.setVisible(true);
    }

    public static void errorMsg(String msg) {
        JFrame err = new JFrame("Error: " + msg);
        int bxh = 700;
        int bxw = 700;
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                err.setVisible(false);

            }
        });

        err.setSize(bxw, bxh);
        err.add(ok);
        err.setLocationRelativeTo(null);
        err.setVisible(true);
        err.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        err.setLayout(null);
        err.setVisible(true);
    }

    public static void mainGUI(User user) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame(user.getUsername());
JLabel label = new JLabel(user.toString());
label.setBounds(10, 0, 1000, 50);
frame.add(label);


        frame.setSize(size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
