import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import java.awt.image.BufferedImage;
import java.io.IOException;



class AdvancedOptions extends JFrame {
	
	public static  BufferedImage Icon;
	public ImageLoader imageloader = ImageLoader.getInstance();
	
	private JLabel labelNumOfSpaces;
	private JTextField numOfSpaces;
	
	private JCheckBox uppCase;
	private JCheckBox lowerCase;
	
	private int X = 10, Y = 10;
	
	public AdvancedOptions(){
		initAdvancedOptions();
		
		try {
			Icon = imageloader.loadImage("Imag/Java glow.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle("Costumize Output");
		setSize(300, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		// setIcon
		ImageIcon img = new ImageIcon(Icon);
		setIconImage(img.getImage());
	}
	
	public void initAdvancedOptions(){
		setLayout(null);
		
		labelNumOfSpaces = new JLabel();
		labelNumOfSpaces.setText("<html><strong># of spaces between groups</strong></html>");
		labelNumOfSpaces.setBounds(X, Y, 250, 21);
		add(labelNumOfSpaces);
		
		numOfSpaces = new JTextField();
		numOfSpaces.setBounds(X, Y + 20, 60, 27);
		numOfSpaces.setFocusable(true);
		add(numOfSpaces);
		
		uppCase = new JCheckBox("Hexadecimal To Uppercase");
		uppCase.setSelected(true);
		uppCase.setFocusable(false);
		uppCase.setBounds(X, Y + 55, 200, 21);
		add(uppCase);
		
		lowerCase = new JCheckBox("Hexadecimal To Lowercase");
		lowerCase.setSelected(false);
		lowerCase.setFocusable(false);
		lowerCase.setBounds(X, Y + 85, 200, 21);
		
		add(lowerCase);
		
		
		
	}
}