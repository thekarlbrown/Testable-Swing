import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by TheKarlBrown on 5/24/15.
 * Illustration of Basic Swing Layouts and Test Cases
 */
public class TestableSwing extends JFrame {
    private String calculationText = "Volume of Cylinder: ";
    //Swing components used
    private javax.swing.JLabel radiusLabel;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JLabel volumeLabel;
    private javax.swing.JTextField radiusTextField;
    private javax.swing.JTextField heightTextField;
    private javax.swing.JButton calculateButton;

    //Constructor to initialize Visuals
    public TestableSwing (){
        createAndShowGUI();
    }

    //Initializes, arranges, and connects Swing components
    private void createAndShowGUI(){
        //Set title and close situation
        JFrame jFrameTest = new JFrame("Cylinder Volume Calculator");
        jFrameTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Initializes every component, setting static text where relevant
        radiusLabel = new JLabel();
        radiusLabel.setText("Cylinder Radius");
        heightLabel = new JLabel();
        heightLabel.setText("Cylinder Height");
        volumeLabel = new JLabel();
        volumeLabel.setText(calculationText);
        radiusTextField = new JTextField();
        heightTextField = new JTextField();
        calculateButton = new JButton();

        //Set Button text and to perform calculation on click
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertButtonActionPerformed(e);
            }
        });
        calculateButton.setText("Calculate");

        //Create the Group Layout. Both Horizontal and Vertical must be set independently
        Container contentPane = getContentPane();
        GroupLayout groupLayout = new GroupLayout(contentPane);
        contentPane.setLayout(groupLayout);

        //Set the Horizontal Group
        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(radiusTextField)
                                .addComponent(heightTextField)
                                .addComponent(volumeLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(radiusLabel)
                                .addComponent(heightLabel)
                                .addComponent(calculateButton))
                        .addContainerGap(12, Short.MAX_VALUE)
        );

        //Set the Vertical Group
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(radiusTextField)
                                .addComponent(radiusLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(heightTextField)
                                .addComponent(heightLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(volumeLabel)
                                .addComponent(calculateButton))
                        .addContainerGap(12, Short.MAX_VALUE)
        );

        //Finish the Group Layout
        pack();
    }

    /**
     * Performs calculations when button is clicked and sets Swing JFrame accordingly
     * @param click ActionEvent passed from the button when clicked
     */
    private void convertButtonActionPerformed (ActionEvent click){
        double volume = Math.pow(  (Double.parseDouble(radiusTextField.getText())) ,2)
                * Math.PI
                * (Double.parseDouble(heightTextField.getText()));
        volumeLabel.setText(calculationText + volume);
    }

    public static void main (String [] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestableSwing().setVisible(true);
            }
        });
    }
}
