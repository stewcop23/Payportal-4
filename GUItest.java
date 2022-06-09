import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUItest {

    public GUItest() {
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("GUI");

        // set up components

        JLabel label = new JLabel();
        label.setBounds(200, 200, 100, 100);

        ArrayList<JButton> accounts = new ArrayList<JButton>();

        for (int i = 0; i < 10; i++) {
            final int j = i;
            accounts.add(new JButton(Integer.toString(i)));
            accounts.get(i).setBounds(0, i * 50, 100, 50);
            accounts.get(i).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label.setText(Integer.toString(j));
                }
            });
            frame.add(accounts.get(i));

        }

        // JButton button = new JButton("Send");

        // button.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // label.setText(text.getText());
        // }
        // });
        // button.setBounds(100, 5, 100, 100);

        // Add elemonts:

        // frame.add(button);
        frame.add(label);

        // FINAL
        frame.setSize(1500, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }


}
