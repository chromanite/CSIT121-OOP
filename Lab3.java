import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Frame extends JFrame implements ActionListener {
    private final JLabel[] jlArray;
    private final JLabel labelComment;
    private final JLabel labelImage;
    private final JTextField[] textfield;
    private final JTextField[] textfieldEdit;
    private final String[] labelNames = {"Name", "Date of birth", "Email"};
    private final String[] textfieldValues = {"Min Zhan Foo", "12 December 1996", "mzf861@uowmail.edu.au"};
    private final String[] textfieldValuesEdit = {"121 is insane", "More examples if possible"};
    private static final String imgName = "tech.png";

    public Frame() {
        super("Introduction to myself");
        setLayout(new FlowLayout());
        
        jlArray = new JLabel[labelNames.length];
        textfield = new JTextField[textfieldValues.length];
        textfieldEdit = new JTextField[textfieldValuesEdit.length];

        for (int i = 0; i < labelNames.length; i++) {
            jlArray[i] = new JLabel(labelNames[i]);
            textfield[i] = new JTextField(textfieldValues[i], 20);
            textfield[i].setEditable(false);
        }

        for (int i = 0; i < textfieldValuesEdit.length; i++) {
            textfieldEdit[i] = new JTextField(textfieldValuesEdit[i], 20);
        }

        for (int i = 0; i < labelNames.length; i++) {
            add(jlArray[i]);
            add(textfield[i]);
        }

        labelImage = new JLabel();
        Icon tech = new ImageIcon(getClass().getResource(imgName));
        labelImage.setIcon(tech);
        labelImage.setToolTipText("i Am PrOgraMmUr");

        labelComment = new JLabel("My comments to the subject, will update further");

        add(labelImage);
        add(labelComment);

        for (int i = 0; i < textfieldValuesEdit.length; i++) {
            add(textfieldEdit[i]);
        }

        for (JTextField value : textfieldEdit) {
            value.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        String s = "Summary of your changes\n";

        for (int i = 0; i < textfieldEdit.length; i++) {
            s += String.format("%d. %s%n", i + 1, textfieldEdit[i].getText());
        }

        JOptionPane.showMessageDialog(null, s, "My suggestion to the course", JOptionPane.WARNING_MESSAGE);
    }
}

public class Lab3 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(354, 535);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
