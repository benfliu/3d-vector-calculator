import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static String mode = "Cross Product";

    public static void main(String[] args)
    {
        int[] u = new int[3];
        int[] v = new int[3];

        JFrame frame = new JFrame("3D Vector Calculator - Cross Product");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320, 240);

        JPanel vectorPanel = new JPanel();
        vectorPanel.setLayout(new BorderLayout());
        JPanel uPanel = new JPanel();
        JPanel vPanel = new JPanel();
        JPanel calcPanel = new JPanel();
        JPanel togglePanel = new JPanel();

        JLabel u0Label = new JLabel();
        u0Label.setText("u = <");
        JTextField u0 = new JTextField(3);
        JLabel u1Label = new JLabel();
        u1Label.setText(",");
        JTextField u1 = new JTextField(3);
        JLabel u2Label = new JLabel();
        u2Label.setText(",");
        JTextField u2 = new JTextField(3);
        JLabel uEndLabel = new JLabel();
        uEndLabel.setText(">");
        uPanel.add(u0Label);
        uPanel.add(u0);
        uPanel.add(u1Label);
        uPanel.add(u1);
        uPanel.add(u2Label);
        uPanel.add(u2);
        uPanel.add(uEndLabel);

        JLabel v0Label = new JLabel();
        v0Label.setText("v = <");
        JTextField v0 = new JTextField(3);
        JLabel v1Label = new JLabel();
        v1Label.setText(",");
        JTextField v1 = new JTextField(3);
        JLabel v2Label = new JLabel();
        v2Label.setText(",");
        JTextField v2 = new JTextField(3);
        JLabel vEndLabel = new JLabel();
        vEndLabel.setText(">");
        vPanel.add(v0Label);
        vPanel.add(v0);
        vPanel.add(v1Label);
        vPanel.add(v1);
        vPanel.add(v2Label);
        vPanel.add(v2);
        vPanel.add(vEndLabel);

        JButton calculateButton = new JButton("Calculate cross product!");
        JTextField output = new JTextField(8);
        output.setEditable(false);
        calcPanel.add(calculateButton);
        calcPanel.add(output);

        JButton toggleButton = new JButton("Switch to dot product");
        togglePanel.add(toggleButton);

        Action calculate = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                u[0] = Integer.parseInt(u0.getText());
                u[1] = Integer.parseInt(u1.getText());
                u[2] = Integer.parseInt(u2.getText());
                v[0] = Integer.parseInt(v0.getText());
                v[1] = Integer.parseInt(v1.getText());
                v[2] = Integer.parseInt(v2.getText());
                if (mode == "Cross Product")
                {
                    int i = u[1]*v[2]-u[2]*v[1];
                    int j = -(u[0]*v[2]-u[2]*v[0]);
                    int k = u[0]*v[1]-u[1]*v[0];
                    String crossProduct = "<" + Integer.toString(i) + ", " + Integer.toString(j) + ", " + Integer.toString(k) + ">";
                    output.setText(crossProduct);
                }
                else if (mode == "Dot Product")
                {
                    String dotProduct = Integer.toString(u[0]*v[0]+u[1]*v[1]+u[2]*v[2]);
                    output.setText(dotProduct);
                }
            }

        };

        Action toggleMode = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("");
                if (mode == "Cross Product")
                {
                    mode = "Dot Product";
                    toggleButton.setText("Switch to cross product");
                    calculateButton.setText("Calculate dot product!");
                    frame.setTitle("3D Vector Calculator - Dot Product");
                }
                else if (mode == "Dot Product")
                {
                    mode = "Cross Product";
                    toggleButton.setText("Switch to dot product");
                    calculateButton.setText("Calculate cross product!");
                    frame.setTitle("3D Vector Calculator - Cross Product");
                }
            }

        };


        calculateButton.addActionListener(calculate);
        toggleButton.addActionListener(toggleMode);

        vectorPanel.add(uPanel, BorderLayout.NORTH);
        vectorPanel.add(vPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(BorderLayout.NORTH, vectorPanel);
        frame.getContentPane().add(BorderLayout.CENTER, calcPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, togglePanel);
        frame.setVisible(true);
    }
}