import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class WindowPractice1 {
    public WindowPractice1(){
        
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");

        JTextField text = new JTextField();
        text.setBounds(300, 100, 200, 50);


        frame.add(text);

        frame.setSize(1500, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    
}
}
