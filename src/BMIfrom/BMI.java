package BMIfrom;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class BMI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea result;

	public BMI() {
		setBorder(new LineBorder(Color.BLUE, 2, true));
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel highlight = new JLabel("BMI Calculator");
		highlight.setHorizontalAlignment(SwingConstants.CENTER);
		highlight.setForeground(SystemColor.textHighlight);
		highlight.setBounds(10, 10, 430, 36);
		highlight.setFont(new Font("Gadugi", Font.PLAIN, 30));
		add(highlight);
		
		JPanel detailsPanel = new JPanel();
		detailsPanel.setBackground(Color.LIGHT_GRAY);
		detailsPanel.setBounds(10, 62, 131, 144);
		add(detailsPanel);
		detailsPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel Detailshighight = new JLabel("Details");
		Detailshighight.setVerticalAlignment(SwingConstants.BOTTOM);
		Detailshighight.setHorizontalAlignment(SwingConstants.CENTER);
		Detailshighight.setForeground(SystemColor.textHighlight);
		Detailshighight.setBackground(Color.LIGHT_GRAY);
		detailsPanel.add(Detailshighight);
		
		JLabel nameLabel = new JLabel("name");
		nameLabel.setBackground(Color.LIGHT_GRAY);
		nameLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		detailsPanel.add(nameLabel);
		
		JTextField nameTextField = new JTextField();
		nameTextField.setFont(new Font("Arial", Font.BOLD, 10));
		detailsPanel.add(nameTextField);
		
		JLabel familyNameLabel = new JLabel("family name");
		familyNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		detailsPanel.add(familyNameLabel);
		
		JTextField familyNameTextField = new JTextField();
		familyNameTextField.setFont(new Font("Arial", Font.BOLD, 10));
		detailsPanel.add(familyNameTextField);
		
		JLabel ageLabel = new JLabel("age *");
		detailsPanel.add(ageLabel);
		
		JTextField ageTextField = new JTextField(10);
		getNumberOnly(ageTextField);
		detailsPanel.add(ageTextField);
		
		JLabel actualWeightLabel = new JLabel("actual weight *");
		detailsPanel.add(actualWeightLabel);
		
		JTextField actualWeightTextField = new JTextField(10);
		getNumberOnly(actualWeightTextField);
		detailsPanel.add(actualWeightTextField);
		
	
		JPanel genderPanel = new JPanel();
		genderPanel.setBackground(Color.LIGHT_GRAY);
		genderPanel.setBounds(10, 216, 131, 61);
		add(genderPanel);
		genderPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		genderLabel.setForeground(SystemColor.textHighlight);
		genderLabel.setBackground(Color.LIGHT_GRAY);
		genderPanel.add(genderLabel);
		
		JRadioButton MaleRB = new JRadioButton("Male");
		MaleRB.setSelected(true);
		MaleRB.setBackground(Color.LIGHT_GRAY);
		genderPanel.add(MaleRB);
		
		JRadioButton FemaleRB = new JRadioButton("Female");
		FemaleRB.setBackground(Color.LIGHT_GRAY);
		genderPanel.add(FemaleRB);
		
		ButtonGroup genderButtonGroup = new ButtonGroup();
		genderButtonGroup.add(MaleRB);
		genderButtonGroup.add(FemaleRB);
		
		JPanel JSliderPanel = new JPanel();
		JSliderPanel.setBackground(Color.LIGHT_GRAY);
		JSliderPanel.setBounds(10, 414, 131, 61);
		add(JSliderPanel);
		JSliderPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel weightLabel = new JLabel("Weight");
		weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weightLabel.setForeground(SystemColor.textHighlight);
		JSliderPanel.add(weightLabel);
		
		JSlider slider = new JSlider();
		slider.setValue(140);
		slider.setBackground(Color.LIGHT_GRAY);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(10);
		slider.setMaximum(190);
		slider.setMinimum(140);
		JSliderPanel.add(slider);
		
		JPanel bodyFramePanel = new JPanel();
		bodyFramePanel.setBackground(Color.LIGHT_GRAY);
		bodyFramePanel.setBounds(10, 287, 131, 117);
		add(bodyFramePanel);
		bodyFramePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel bodyFrameLabel = new JLabel("Body Frame");
		bodyFrameLabel.setForeground(SystemColor.textHighlight);
		bodyFrameLabel.setBackground(Color.LIGHT_GRAY);
		bodyFrameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bodyFramePanel.add(bodyFrameLabel);
		
		JRadioButton smallRB = new JRadioButton("Small");
		smallRB.setSelected(true);
		smallRB.setActionCommand("0.9");
		smallRB.setBackground(Color.LIGHT_GRAY);
		bodyFramePanel.add(smallRB);
		
		JRadioButton MeduimRB = new JRadioButton("Medium");
		MeduimRB.setActionCommand("1");
		MeduimRB.setBackground(Color.LIGHT_GRAY);
		bodyFramePanel.add(MeduimRB);
		
		JRadioButton LargeRB = new JRadioButton("Large");
		LargeRB.setActionCommand("1.1");
		LargeRB.setBackground(Color.LIGHT_GRAY);
		bodyFramePanel.add(LargeRB);
		
		ButtonGroup bodyButtonGroup = new ButtonGroup();
		bodyButtonGroup.add(smallRB);
		bodyButtonGroup.add(MeduimRB);
		bodyButtonGroup.add(LargeRB);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submitButton.setForeground(Color.BLACK);
		submitButton.setBackground(SystemColor.textHighlight);
		submitButton.setBounds(172, 414, 268, 61);
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(ageTextField.getText().length() == 0) {
					JOptionPane.showMessageDialog(submitButton, "You must input an age");
					return;
				}else if (actualWeightTextField.getText().length() == 0) {
					JOptionPane.showMessageDialog(submitButton, "You must input a weight");
					return;
				}
				
				System.out.println();
				
				
				double BMI = (Integer.parseInt(actualWeightTextField.getText()) / (double)Math.pow(slider.getValue(), 2)) * 10000;
				
				String BmiStringResult = "Anorexic";
				if ( 15 < BMI && BMI <= 18.5) BmiStringResult = "Underweight";
				else if( 18.5 < BMI && BMI <= 24.9) BmiStringResult = "Normal";
				else if( 25 <= BMI && BMI <= 29.9) BmiStringResult = "Overweight";
				else if( 30 <= BMI && BMI <= 35) BmiStringResult = "Obese";
				else BmiStringResult = "Extreme Obese";
				
				double idealWeight = (double) ((slider.getValue() - 100 + Integer.parseInt(ageTextField.getText()) / 10) * 0.9 * Double.parseDouble(bodyButtonGroup.getSelection().getActionCommand().toString()));
				
				result.setText(
						"\nHello " + nameTextField.getText() + " " + familyNameTextField.getText() + "!\n\n"
						+ "The BMI test result is : \n" + new DecimalFormat("##.##").format(BMI) + "\nIt means you are " + BmiStringResult + "\n\n"
						+ "Your currnet weight is :\n" + actualWeightTextField.getText()
						+ "\nThe ideal weight should be : " + new DecimalFormat("##.##").format(idealWeight));
			}
		});
		
		add(submitButton);
		
		result = new JTextArea();
		result.setBackground(SystemColor.info);
		result.setWrapStyleWord(true);
		result.setLineWrap(true);
		result.setEditable(false);
		result.setBorder(BorderFactory.createTitledBorder(new BorderUIResource(getBorder()), "- Results -", TitledBorder.CENTER, TitledBorder.ABOVE_TOP));
		result.setFont(new Font("Arial", Font.PLAIN, 18));
		result.setBounds(172, 62, 268, 339);
		add(result);
	}
	
	
	public void getNumberOnly(JTextField jTextField) {
	

		((AbstractDocument)jTextField.getDocument()).setDocumentFilter(new DocumentFilter(){

        Pattern regEx = Pattern.compile("\\d*");

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            Matcher matcher = regEx.matcher(text);

            if(!matcher.matches()) return;

            super.replace(fb, offset, length, text, attrs);
            jTextField.setFont(new Font("Arial", Font.BOLD, 10));
        }
    });
		
	}
}
