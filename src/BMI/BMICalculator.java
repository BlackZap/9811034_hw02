package BMI;

/*BMI.java 直接使用LISTING10.4
 BMICalculator 修改自Listing16.7 */
import BMI.BMI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

	public class BMICalculator extends JFrame {
		  // Create text fields for Name, Age, Weight, Height, BMI, Status
		  private JTextField jtfName = new JTextField();
		  private JTextField jtfAge = new JTextField();
		  private JTextField jtfWeight = new JTextField();
		  private JTextField jtfHeight = new JTextField();
		  private JTextField jtfBMI = new JTextField();
		  private JTextField jtfStatus = new JTextField();
		  // Create a Compute Payment button
		  private JButton jbtComputeBMI = new JButton("Compute BMI");
		  
		  public BMICalculator() {
			    // Panel p1 to hold labels and text fields
			    JPanel p1 = new JPanel(new GridLayout(6, 2));
			    p1.add(new JLabel("Name"));
			    p1.add(jtfName);
			    p1.add(new JLabel("Age"));
			    p1.add(jtfAge);
			    p1.add(new JLabel("Weight"));
			    p1.add(jtfWeight);
			    p1.add(new JLabel("Height"));
			    p1.add(jtfHeight);
			    p1.add(new JLabel("BMI"));
			    p1.add(jtfBMI);
			    p1.add(new JLabel("Status"));
			    p1.add(jtfStatus);
			    p1.setBorder(new TitledBorder("Enter Name, Age, Weight, and Height"));
			    
			    // Panel p2 to hold the button
			    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			    p2.add(jbtComputeBMI);

			    // Add the panels to the frame
			    add(p1, BorderLayout.CENTER);
			    add(p2, BorderLayout.SOUTH);

			    // Register listener
			    jbtComputeBMI.addActionListener(new ButtonListener());
		  }
	
	
	 private class ButtonListener implements ActionListener {
			@Override 
		    public void actionPerformed(ActionEvent e) {
		      // Get values from text fields
		      double Weight =
		        Double.parseDouble(jtfWeight.getText());
		      double Height = Double.parseDouble(jtfHeight.getText());
		      String Name = jtfName.getText();

		      // Create a BMI object
		      BMI BMI = new BMI(Name, Weight, Height);

		      // Display BMI and Status
		      jtfBMI.setText(String.format("%.2f",  BMI.getBMI()));
		      jtfStatus.setText(String.format("%s", BMI.getStatus()));
		    }
		  }

	 
	 	  public static void main(String[] args) {
	 		  BMICalculator frame = new BMICalculator();
	 		    frame.pack();
	 		    frame.setTitle("BMICalculator");
	 		    frame.setLocationRelativeTo(null); // Center the frame
	 		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		    frame.setVisible(true);
	 	  }
	 	}