import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

class Options extends JFrame implements ActionListener {
    JFrame frame;
    JButton butC, butD;
    JRadioButton buttonA, buttonB, buttonC;
    JLabel label, label1, label2, label3;
    JTextField tf1, tf2;
    ButtonGroup group;
    int a = 1, b = 1, c = 1;
    LinkedHashMap<String, Integer> Data = new LinkedHashMap<>();

    public Options() {
        frame = new JFrame();
        Font font = new Font("Arial", Font.PLAIN, 18);

        label = new JLabel("ONLINE VOTTING SYSTEM");
        label.setFont(new Font("Mr", Font.BOLD, 35));
        label.setBounds(150, 10, 700, 50);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);

        label1 = new JLabel("ENTER NAME");
        label1.setFont(font);
        label1.setBounds(300, 95, 300, 50);
        label1.setHorizontalAlignment(JLabel.LEFT);
        label1.setVerticalAlignment(JLabel.TOP);

        tf1 = new JTextField(50);
        tf1.setFont(font);
        tf1.setBounds(550, 95, 200, 30);
        tf1.setHorizontalAlignment(JTextField.LEFT);

        label2 = new JLabel("ENTER PHONE");
        label2.setFont(font);
        label2.setBounds(300, 150, 300, 50);
        label2.setHorizontalAlignment(JLabel.LEFT);
        label2.setVerticalAlignment(JLabel.TOP);

        tf2 = new JTextField(50);
        tf2.setFont(font);
        tf2.setBounds(550, 150, 200, 30);
        tf2.setHorizontalAlignment(JTextField.LEFT);

        label3 = new JLabel("CAST YOUR VOTE HERE ");
        label3.setFont(font);
        label3.setBounds(300, 220, 300, 50);
        label3.setHorizontalAlignment(JLabel.LEFT);
        label3.setVerticalAlignment(JLabel.TOP);

        buttonA = new JRadioButton(" PARTY A");
        buttonA.setBounds(300, 270, 100, 40);
        buttonA.setFocusable(false);

        buttonB = new JRadioButton(" PARTY B");
        buttonB.setBounds(300, 310, 100, 40);
        buttonB.setFocusable(false);

        buttonC = new JRadioButton(" PARTY C");
        buttonC.setBounds(300, 350, 100, 40);
        buttonC.setFocusable(false);

        butC = new JButton("SUBMIT YOUR VOTE");
        butC.setBounds(550, 290, 200, 30);
        butC.setFocusable(false);

        butD = new JButton("CHECK RESULTS");
        butD.setBounds(550, 330, 200, 30);
        butD.setFocusable(false);

        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setTitle("Votting System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        group = new ButtonGroup();
        group.add(buttonA);
        group.add(buttonB);
        group.add(buttonC);

        frame.add(label);
        frame.add(label1);
        frame.add(tf1);
        frame.add(label2);
        frame.add(tf2);
        frame.add(label3);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(butC);
        frame.add(butD);

        frame.setLayout(null);

        butC.addActionListener(this);
        butD.addActionListener(this);
        buttonA.addActionListener(this);
        buttonB.addActionListener(this);
        buttonC.addActionListener(this);

    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonA) {
            Data.put("PARTY A", a++);
        }
        if (e.getSource() == buttonB) {
            Data.put("PARTY B", b++);
        }
        if (e.getSource() == buttonC) {
            Data.put("PARTY C", c++);
        }
        if (e.getSource() == butC) {
            tf1.setText("");
            tf2.setText("");
            group.clearSelection();
        }
        if (e.getSource() == butD) {
            if (e.getSource() == butD) {
                new NewWindow(this);
            }

        }
    }

}

class NewWindow extends JFrame {
    Options op;

    public NewWindow(Options op) {
        this.op = op;
        LinkedHashMap<String, Integer> data = op.Data;
        int maxVotes = 0;
        String leadingParty = "";

        StringBuilder message = new StringBuilder();

        for (String party : data.keySet()) {
            String result = party + ": " + data.get(party);
            message.append(result).append("\n");

            int votes = data.get(party);
            if (votes > maxVotes) {
                maxVotes = votes;
                leadingParty = party;
            }
        }

        message.append("Leading Party: ").append(leadingParty);

        JOptionPane.showMessageDialog(null, message.toString());
    }
}

public class VotingTask {
    public static void main(String[] args) {
        new Options();
    }
}
