import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.function.Predicate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class QAFrame extends JFrame implements ActionListener {
    private final ArrayList<JButton> userBtn = new ArrayList<>();
    private final ArrayList<Participant> userList = new ArrayList<>();
    private final JTextArea userTextArea = new JTextArea(10, 125);
    private final JTextArea hostTextArea = new JTextArea(10, 125);
    private final JLabel hostAreaLabel = new JLabel("Host Area");
    private final JButton hostBtn;
    private final JButton clear;

    public QAFrame() {
        super("Q & A Room");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setResizable(false);

        userList.add(new Participant("Heng 1", "Michael Myers", "T01", "kalm"));
        userList.add(new Participant("Heng 2", "Danny Johnson", "T02", "kalm"));
        userList.add(new Participant("Heng 3", "Caleb Quinn", "T03", "kalm"));
        userList.add(new Participant("Heng 4", "Jeffrey Hawk", "T04", "kalm"));

        Icon hostIcon = new ImageIcon(getClass().getResource("professor.png"));
        Icon clearIcon = new ImageIcon(getClass().getResource("dustpan.png"));
        Icon userIcon = new ImageIcon(getClass().getResource("meme.png"));

        userTextArea.setFont(new Font("Consolas", Font.PLAIN, 15));
        userTextArea.setForeground(Color.WHITE);
        userTextArea.setBackground(Color.BLACK);

        hostTextArea.setFont(new Font("Consolas", Font.PLAIN, 15));
        hostTextArea.setForeground(Color.YELLOW);
        hostTextArea.setBackground(Color.BLUE);

        hostBtn = new JButton("Host", hostIcon);
        hostBtn.setBackground(Color.GREEN);
        hostBtn.setForeground(Color.BLUE);
        hostBtn.setFont(new Font("San-Serif", Font.BOLD, 16));
        hostBtn.setRolloverIcon(new ImageIcon(getClass().getResource("tcher.png")));

        clear = new JButton("Clear", clearIcon);
        clear.setFont(new Font("San-Serif", Font.BOLD, 16));

        userList.stream().forEach(x -> userBtn.add(new JButton(x.getNameButton(), userIcon)));

        add(userTextArea);
        add(hostAreaLabel);
        add(hostTextArea);

        userBtn.stream().forEach(x -> {
            x.setBackground(Color.YELLOW);
            x.setForeground(Color.RED);
            x.setFont(new Font("San-Serif", Font.BOLD, 16));
            x.setRolloverIcon(new ImageIcon(getClass().getResource("panik.png")));
            add(x);
        });

        add(hostBtn);
        add(clear);
        
        userBtn.stream().forEach(x -> x.addActionListener(this));
        hostBtn.addActionListener(this);
        clear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Icon> iconDP = new ArrayList<>();
        Icon prog = new ImageIcon(getClass().getResource("programmer.png"));
        Predicate<JButton> predicate = button -> button == e.getSource();
        

        userList.stream().forEach(x -> iconDP.add(new ImageIcon(getClass().getResource("kalm.png"))));
        userBtn.stream().filter(predicate).forEach(x -> JOptionPane.showMessageDialog(null, userList.get(userBtn.indexOf(x)).toString() + userTextArea.getText(), "Welcome to Chat Room",  JOptionPane.PLAIN_MESSAGE, iconDP.get(userBtn.indexOf(x))));

        if (e.getSource() == hostBtn) {
            JOptionPane.showMessageDialog(null, hostTextArea.getText(), "I am the hostTextArea", JOptionPane.PLAIN_MESSAGE, prog);
        }
        
        if (e.getSource() == clear){
            userTextArea.setText(null);
            hostTextArea.setText(null);
        }
    }
}

class Participant {
    private String nameButton;
    private String fullName;
    private String tutorialGp;
    private String imageFile;

    public Participant(String nameButton, String fullName, String tutorialGp, String imageFile) {
        this.nameButton = nameButton;
        this.fullName = fullName;
        this.tutorialGp = tutorialGp;
        this.imageFile = imageFile;
    }

    public String getNameButton() {
        return this.nameButton;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getTutorialGp() {
        return this.tutorialGp;
    }

    public String getImageFile() {
        return this.imageFile;
    }

    @Override
    public String toString() {
        return String.format("Hi! I am participant %s%nMy name is %s%nI am from tutorial group: %s%n", getNameButton(),getFullName(), getTutorialGp());
    }
}

public class MinZhanFoo_A3 {
    public static void main(String[] args) {
        QAFrame frame = new QAFrame();
        frame.setSize(1065, 800);
        frame.setLocationRelativeTo(null);
    }
}
