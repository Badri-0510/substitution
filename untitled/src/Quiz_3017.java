import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz_3017  extends JFrame implements ActionListener {
    private JRadioButton[] options1;
    private JCheckBox[] options2;
    private JTextField answer3;
    private JRadioButton[] options5;
    private JLabel feedbackLabel;
    private JLabel feedbackLabel1;
    private JLabel feedbackLabel2;
    private JLabel feedbackLabel3;
    private JLabel feedbackLabel4;
    private JLabel feedbackLabel5;
    private JLabel resultArea;
    private JButton submitButton;
    private JTextArea answer4;
    private ButtonGroup group1,group5;
    public Quiz_3017(){
        setTitle("Java Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        add(new JLabel("1. Which of the following keywords is used to prevent a method from being overridden?"), gbc);

        options1 = new JRadioButton[]{
                new JRadioButton("static"),
                new JRadioButton("final"),
                new JRadioButton("private"),
                new JRadioButton("abstract")
        };
        group1 = new ButtonGroup();
        for (JRadioButton option : options1) {
            gbc.gridy++;
            option.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            group1.add(option);
            add(option, gbc);
        }
        feedbackLabel1 = new JLabel();
        gbc.gridy++;
        add(feedbackLabel1, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("2. Select the data types that are primitive types in Java:"), gbc);

        options2 = new JCheckBox[]{
                new JCheckBox("int"),
                new JCheckBox("String"),
                new JCheckBox("float"),
                new JCheckBox("Object")
        };
        for (JCheckBox option : options2) {
            gbc.gridy++;
            option.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            add(option, gbc);
        }
        feedbackLabel2 = new JLabel();
        gbc.gridy++;
        add(feedbackLabel2, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("3. Father of Java:"), gbc);
        answer3 = new JTextField(10);
        gbc.gridy++;
        add(answer3, gbc);
        feedbackLabel3 = new JLabel();
        gbc.gridy++;
        add(feedbackLabel3, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("4. Java code to print hello:"), gbc);
        answer4 = new JTextArea(3, 20);
        gbc.gridy++;
        add(new JScrollPane(answer4), gbc);
        feedbackLabel4 = new JLabel();
        gbc.gridy++;
        add(feedbackLabel4, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("5. What will be the output of System.out.println(2 + 2 + \"Hello\");?"), gbc);

        options5 = new JRadioButton[]{
                new JRadioButton("Hello4"),
                new JRadioButton("4Hello"),
                new JRadioButton("Hello2"),
                new JRadioButton("2Hello")
        };
        group5 = new ButtonGroup();
        for (JRadioButton option : options5) {
            gbc.gridy++;
            option.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            group5.add(option);
            add(option, gbc);
        }
        feedbackLabel5 = new JLabel();
        gbc.gridy++;
        add(feedbackLabel5, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 4;
        submitButton = new JButton("Submit");
        add(submitButton, gbc);

        resultArea = new JLabel();
        gbc.gridy++;
        gbc.gridwidth = 1;
        add(resultArea, gbc);

        submitButton.addActionListener(this);



        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int score = calculateScore();
        displayResults(score);
    }
    private int calculateScore() {
        int score = 0;

        if (options1[1].isSelected()) {
            score++;
            feedbackLabel1.setText("Correct!");
            feedbackLabel1.setForeground(Color.GREEN);
        } else {
            feedbackLabel1.setText("Wrong! Correct answer: final");
            feedbackLabel1.setForeground(Color.RED);
        }

        boolean correctAnswer2 = options2[0].isSelected() && options2[2].isSelected();
        if (correctAnswer2) {
            score++;
            feedbackLabel2.setText("Correct!");
            feedbackLabel2.setForeground(Color.GREEN);
        } else {
            feedbackLabel2.setText("Wrong! Correct answers: int, float");
            feedbackLabel2.setForeground(Color.RED);
        }

        String answer3Text = answer3.getText().trim();
        if (answer3Text.equals("James Gosling") || answer3Text.equals("james gosling") || answer3Text.equals("James gosling")) {
            score++;
            feedbackLabel3.setText("Correct!");
            feedbackLabel3.setForeground(Color.GREEN);
        } else {
            feedbackLabel3.setText("Wrong! Correct answer: James Gosling");
            feedbackLabel3.setForeground(Color.RED);
        }

        String answer4Text = answer4.getText().trim();
        if (!answer4Text.equals("System.out.println(\"Hello\")")) {
            score++;
            feedbackLabel4.setText("Correct!");
            feedbackLabel4.setForeground(Color.GREEN);
        } else {
            feedbackLabel4.setText("Wrong! System.out.println(\"Hello\")");
            feedbackLabel4.setForeground(Color.RED);
        }

        if (options5[1].isSelected()) {
            score++;
            feedbackLabel5.setText("Correct!");
            feedbackLabel5.setForeground(Color.GREEN);
        } else {
            feedbackLabel5.setText("Wrong! Correct answer: 4Hello");
            feedbackLabel5.setForeground(Color.RED);
        }

        return score;
    }

    private void displayResults(int score) {
        resultArea.setText("Your total score is: " + score + "/5");
    }

    public static void main(String[] args) {
        new Quiz_3017();
    }
}





