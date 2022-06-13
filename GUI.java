
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;

public class GUI {
    static boolean loggedin = false;
    static JFrame frame = new JFrame("GUI");

    
    /** 
     * Shows the first screen of the program. and allows the user to login or create an account.
     * @param args
     */
    public static void main(String[] args) {

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        double width = size.getWidth();
        double height = size.getHeight();

        JButton loginButton = new JButton("Click to login");
        JButton registerButton = new JButton("Click to register");

        int bttnwdth = 1000;
        int bttnhgt = 500;
        loginButton.setBounds((int) width / 2 - (bttnwdth / 2), (int) height / 2 - (bttnhgt / 2), bttnwdth / 2,
                bttnhgt);
        loginButton.setFont(new Font("Arial", Font.BOLD, 40));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();

            }

        });
        registerButton.setBounds((int) width / 2, (int) height / 2 - (bttnhgt / 2), bttnwdth / 2,
                bttnhgt);
        registerButton.setFont(new Font("Arial", Font.BOLD, 40));
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame register = new JFrame();
                register.setSize(500, 1000);
                register.setVisible(true);
                register.setLayout(null);
                JLabel username = new JLabel("Username");
                JLabel password = new JLabel("Password");
                JLabel name = new JLabel("Name");
                JLabel email = new JLabel("Email");
                JLabel phoneNumber = new JLabel("Phone Number");
                JTextField usernameField = new JTextField();
                JTextField passwordField = new JTextField();
                JTextField nameField = new JTextField();
                JTextField emailField = new JTextField();
                JTextField phoneNumberField = new JTextField();
                JButton registerButton = new JButton("Register");
                username.setBounds(0, 10, 100, 50);
                usernameField.setBounds(0, 60, 100, 50);
                password.setBounds(0, 110, 100, 50);
                passwordField.setBounds(0, 160, 100, 50);
                name.setBounds(0, 210, 100, 50);
                nameField.setBounds(0, 260, 100, 50);
                email.setBounds(0, 310, 100, 50);
                emailField.setBounds(0, 360, 100, 50);
                phoneNumber.setBounds(0, 410, 100, 50);
                phoneNumberField.setBounds(0, 460, 100, 50);
                registerButton.setBounds(0, 510, 100, 50);
                register.add(username);
                register.add(usernameField);
                register.add(password);
                register.add(passwordField);
                register.add(name);
                register.add(nameField);
                register.add(email);
                register.add(emailField);
                register.add(phoneNumber);
                register.add(phoneNumberField);
                register.add(registerButton);
                registerButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String username = usernameField.getText();
                        String password = passwordField.getText();
                        String name = nameField.getText();
                        String email = emailField.getText();
                        String phoneNumber = phoneNumberField.getText();
                        CardHolder newUser = new CardHolder(username, password, name, email, phoneNumber,
                                new Scanner(System.in), true);
                                newUser.setLogged(true);
                        loggedin = true;

//                        mainGUI(newUser);

                        register.setVisible(false);

                    }

                });
            }
        });
        frame.add(registerButton);

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

        for (User user : User.getUserArray()) {
            if (user.islogged()) {
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

    
    /** 
     * Displays an error message to the user.
     * @param msg
     */
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

    
    /** 
     * Main method for displaying the GUI after a user has been created or logged into
     * @param user
     */
    public static void mainGUI(User user) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame(user.getUsername());
        JButton restart = new JButton("Restart");
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                frame.setVisible(false);
                mainGUI(user);
            }
        });
        restart.setBounds(1000, 0, 100, 50);
        frame.add(restart);
        if (user.type().equals("CH")) {
            JLabel label = new JLabel("<html> Username: " + user.getUsername() + "<br/> Name: "
                    + ((CardHolder) user).getName() + "<br/> Email: " + ((CardHolder) user).getEmail()
                    + "<br/> Phone number: " + ((CardHolder) user).getPhoneNumber() + "</html>");
            label.setBounds(10, 0, 1000, 100);
            frame.add(label);

            JButton adddebit = new JButton("Create new debit card");

            adddebit.setBounds(0, 100, 250, 100);
            adddebit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent a) {
                    Debit newc = new Debit();
                    ((CardHolder) user).createCard(newc);
                    ((CardHolder) user).addCard(newc);
                    frame.setVisible(false);
                    mainGUI(user);
                }
            });
            frame.add(adddebit);
            JButton addvisa = new JButton("Create new visa card");
            addvisa.setBounds(250, 100, 250, 100);
            addvisa.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent a) {
                    ((CardHolder) user).createCard((new Visa()));
                    frame.setVisible(false);
                    mainGUI(user);
                }
            });
            frame.add(addvisa);

            JLabel info = new JLabel("Welcome to your account");

            info.setBounds(600, 20, 300, 200);
            frame.add(info);
            frame.revalidate();
            JButton deposit = new JButton("Deposit");
            deposit.setBounds(600, 220, 250, 100);
            deposit.setVisible(false);
            frame.add(deposit);
            JButton withdraw = new JButton("Withdraw");
            withdraw.setBounds(850, 220, 250, 100);
            withdraw.setVisible(false);
            frame.add(withdraw);

            for (int i = 0; i < ((CardHolder) user).getCards().size(); i++) {
                Card card = ((CardHolder) user).getCards().get(i);
                String type = (card.toString().split(",")[0].equals("V") ? "Visa" : "Debit");
                JButton button = new JButton(type + ", Number: " + card.toString().split(",")[1] + ", "
                        + (card.toString().split(",")[0].equals("V") ? "Debt: $" : "Ballance: $")
                        + card.toString().split(",")[5]);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent a) {
                        info.setText("<html>Type: " + type + "<br/>" + "Number: " + card.toString().split(",")[1]
                                + "<br/>" + "Expiration: " + card.toString().split(",")[2] + "/"
                                + card.toString().split(",")[3] + "<br/>" + "CVV: " + card.toString().split(",")[4]
                                + "<br/>" + (card.toString().split(",")[0].equals("V") ? "Debt: $" : "Ballance: $")
                                + card.toString().split(",")[5] + "</html>");
                        // System.out.println(info.getText());

                        deposit.setVisible(true);
                        deposit.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent a) {
                                JFrame depositbox = new JFrame("Deposit");
                                JLabel amountLbl = new JLabel("Amount:");
                                amountLbl.setBounds(0, 0, 1000, 50);
                                JTextField amountField = new JTextField();
                                amountField.setBounds(0, 50, 200, 50);
                                JButton submit = new JButton("Submit");
                                submit.setBounds(0, 100, 150, 75);
                                submit.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent a) {
                                        if (card.toString().split(",")[0].equals("V")) {
                                            ((Visa) card).paydebt(Double.parseDouble(amountField.getText()));
                                        } else {
                                            ((Debit) card).deposit(Double.parseDouble(amountField.getText()));
                                        }
                                        depositbox.setVisible(false);

                                    }
                                });
                                depositbox.add(amountField);
                                depositbox.add(amountLbl);
                                depositbox.add(submit);
                                depositbox.setSize(1000, 1000);
                                depositbox.setLayout(null);
                                depositbox.setVisible(true);
                            }
                        });
                        withdraw.setVisible(true);
                        withdraw.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent a) {
                                JFrame withdrawbox = new JFrame("Withdraw");
                                JLabel amountLbl = new JLabel("Amount:");
                                amountLbl.setBounds(0, 0, 1000, 50);
                                JTextField amountField = new JTextField();
                                amountField.setBounds(0, 50, 200, 50);
                                JButton submit = new JButton("Submit");
                                submit.setBounds(0, 100, 150, 75);
                                submit.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent a) {
                                        if (card.toString().split(",")[0].equals("V")) {
                                            ((Visa) card).charge(Double.parseDouble(amountField.getText()));
                                        } else {
                                            ((Debit) card).deposit(-Double.parseDouble(amountField.getText()));
                                        }
                                        withdrawbox.setVisible(false);

                                    }

                                });
                                withdrawbox.add(amountField);
                                withdrawbox.add(amountLbl);
                                withdrawbox.add(submit);
                                withdrawbox.setSize(1000, 1000);
                                withdrawbox.setLayout(null);

                                withdrawbox.setVisible(true);
                            }
                        });
                    }
                });
                button.setBounds(0, i * 100 + 200, 500, 100);
                frame.add(button);

            }
            frame.setSize(size);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.setVisible(true);
        }
    }
}
