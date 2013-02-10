import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PrintingOptions extends JFrame {
	public BufferedImage Icon;
	public ImageLoader imageloader = ImageLoader.getInstance();


	private int X = 10, Y = 25;

	public PrintingOptions() {

		initBody();

		try {
			Icon = imageloader.loadImage("Imag/Java glow.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle("Print Options");
		setSize(260, 170);
		setResizable(false);
		setLocationRelativeTo(null);
		// setIcon
		ImageIcon img = new ImageIcon(Icon);
		setIconImage(img.getImage());

	}

	JTextField textFieldGroup;

	JTextField textFieldGroupsPerRow;
	JLabel groupNumber;
	JLabel spaceNumber;
	JLabel enterNumber;
	JButton set;

	JLabel numPerGroup;
	JLabel groupPerRow;

	public void initBody() {

		setLayout(null);
		/** GROUP */
		groupNumber = new JLabel(
				"<html><strong>Amount of #'s in a group</strong></html>");
		groupNumber.setBounds(X, Y - 19, 200, 21);

		add(groupNumber);
		//
		textFieldGroup = new JTextField();
		textFieldGroup.setBounds(X, Y, 50, 27);
		

		add(textFieldGroup);
		/** ENTER */
		enterNumber = new JLabel(
				"<html><strong># of Groups In a Row</strong></html>");
		enterNumber.setBounds(X, Y + 29, 200, 21);

		add(enterNumber);
		//
		textFieldGroupsPerRow = new JTextField();
		textFieldGroupsPerRow.setBounds(X, Y + 48, 50, 27);

		add(textFieldGroupsPerRow);

		/** BUTTON */
		set = new JButton("Set");
		set.setBounds(95, Y + 76, 60, 21);
		set.setForeground(Color.WHITE);
		add(set);

		numPerGroup = new JLabel();
		if (Body.group > 1) {
			numPerGroup.setText(Body.group + " Numbers Per Group");
			numPerGroup.setForeground(Color.RED);
		} else {
			numPerGroup.setText(Body.group + " Number Per Group");
			numPerGroup.setForeground(Color.RED);
		}

		numPerGroup.setBounds(X + 55, Y, 200, 25);
		add(numPerGroup);
		//
		groupPerRow = new JLabel();
		if (Body.numOfGroups > 1) {
			groupPerRow.setText(Body.numOfGroups + " Groups Per Row");
			groupPerRow.setForeground(Color.RED);
		} else {
			groupPerRow.setText(Body.numOfGroups + " Group Per Row");
			groupPerRow.setForeground(Color.RED);
		}

		groupPerRow.setBounds(X + 55, Y + 48, 200, 25);
		add(groupPerRow);

		Events event2 = new Events();
		set.addActionListener(event2);
		textFieldGroupsPerRow.addActionListener(event2);
		textFieldGroup.addActionListener(event2);

	}

	private class Events implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == set) {
				
				
				
				if (!textFieldGroup.getText().equals("")) {
					System.out.println("Good");
				} else if (textFieldGroup.getText().equals("")) {
					System.out.println("Bad");
				}

				if (!textFieldGroupsPerRow.getText().equals("")) {
					String temporary1 = textFieldGroupsPerRow.getText();
					Body.numOfGroups = Long.valueOf(temporary1);

					if (!textFieldGroup.getText().equals("")) {
						String temporary2 = textFieldGroup.getText();
						Body.group = Long.valueOf(temporary2);
					}
				} else if (!textFieldGroup.getText().equals("")) {
					String temporary2 = textFieldGroup.getText();
					Body.group = Long.valueOf(temporary2);
					if (!textFieldGroupsPerRow.getText().equals("")) {
						String temporary1 = textFieldGroupsPerRow.getText();
						Body.numOfGroups = Long.valueOf(temporary1);
					}
				}
				
				if (Body.group > 1) {

					numPerGroup.setText(Body.group + " Numbers Per Group");
				} else {
					numPerGroup.setText(Body.group + " Number Per Group");
				}

				if (Body.numOfGroups > 1) {
					groupPerRow.setText(Body.numOfGroups + " Groups Per Row");
					groupPerRow.setForeground(Color.RED);
				} else {
					groupPerRow.setText(Body.numOfGroups + " Group Per Row");
					groupPerRow.setForeground(Color.RED);
				}

			}
		}

	}

}