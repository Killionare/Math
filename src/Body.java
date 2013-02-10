import java.awt.AWTException;
import java.awt.Color;

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.KeyStroke;

import javax.swing.UIManager;

import javax.swing.UIManager.*;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;



public class Body extends JFrame {

	public int X = 18, Y = 60;

	public JTextField textField1;
	public JLabel JLabel1;
	public JButton button1;
	public JLabel baseNum;
	public JCheckBox checkbox1;
	public JCheckBox checkbox2;
	
	public String base;
	public static int base2 = 0;
	public boolean diffBase = false;
	
	//For generator
	public double num;
	boolean state = true;
	boolean state2 = false;
	public static  BufferedImage Icon;
	public ImageLoader imageloader = ImageLoader.getInstance();
	public static long group = 5, numOfGroups = 10, enter;
	
	
	//String for finiding base number
	public JButton stop;


 	public Body() {
		//find Image
		try {
			Icon = imageloader.loadImage("Imag/Java glow.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Get look and feel
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}

		UIManager.put("nimbusBlueGrey", new Color(0,0,0));
		
		initMenu();
		initBody();

		setTitle("Random Number Generation");
		setSize(360, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(Icon);
		setFocusable(true);

		setIconImage(img.getImage());
	
		
		JLabel version = new JLabel("v0.7.5");
		version.setBounds(5, 177, 150, 21);
		add(version);
		
		
		
		
	}

	public void initMenu() {

		JMenuBar menubar = new JMenuBar();

		/*
		 * ImageIcon iconNew = new ImageIcon(getClass().getResource("new.png"));
		 * ImageIcon iconOpen = new
		 * ImageIcon(getClass().getResource("open.png")); ImageIcon iconSave =
		 * new ImageIcon(getClass().getResource("save.png")); ImageIcon iconExit
		 * = new ImageIcon(getClass().getResource("exit.png"));
		 */

		// Defining the object for the menu tabs
		JMenu advancedOptions = new JMenu("Advanced Options");
		advancedOptions.setMnemonic(KeyEvent.VK_A);
		advancedOptions.setForeground(Color.WHITE);
		//Options
		JMenu options = new JMenu("Options"/** * This is where you would but the * image */);
		options.setForeground(Color.WHITE);





		// Defines File New Function
		JMenuItem clipBoard = new JMenuItem("Clipboard Options");

		clipBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AdvancedOptions advance = new AdvancedOptions();
				advance.setVisible(true);
				
			}
		});
		clipBoard.setMnemonic(KeyEvent.VK_N);
		// Defines Open Function
		JMenu base = new JMenu("Base System");
		
		
		JMenuItem base2 = new JMenuItem("Base-2(Binary)");
		base2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				diffBase = true;
				baseNumber("2");
				Body.base2 = 2;
				checkbox1.setSelected(false);
				checkbox2.setSelected(false);
			}
		});
		
		JMenuItem base3 = new JMenuItem("Base-3(Ternary)");
		base3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				diffBase = true;
				baseNumber("3");
				Body.base2 = 3;
				checkbox1.setSelected(false);
				checkbox2.setSelected(false);
			}
		});
		
		JMenuItem base4 = new JMenuItem("Base-4(Quintal)");
		base4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				diffBase = true;
				baseNumber("4");
				Body.base2 = 4;
				checkbox1.setSelected(false);
				checkbox2.setSelected(false);
			}
		});
		
		JMenuItem base5 = new JMenuItem("Base-5");
		base5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				diffBase = true;
				baseNumber("5");
				Body.base2 = 5;
				checkbox1.setSelected(false);
				checkbox2.setSelected(false);

			}
		});
		
		JMenuItem base6 = new JMenuItem("Base-6");
		base6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				diffBase = true;
				baseNumber("6");
				Body.base2 = 6;
				checkbox1.setSelected(false);
				checkbox2.setSelected(false);
			}
		});
		
		JMenuItem base7 = new JMenuItem("Base-7");
		base7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				diffBase = true;
				baseNumber("7");
				Body.base2 = 7;
				checkbox1.setSelected(false);
				checkbox2.setSelected(false);
			}
		});
		
		JMenuItem base8 = new JMenuItem("Base-8(Octal)");
		base8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				diffBase = true;
				baseNumber("8");
				Body.base2 = 8;
				checkbox1.setSelected(false);
				checkbox2.setSelected(false);
			}
		});
		
		JMenuItem base9 = new JMenuItem("Base-9");
		base9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				diffBase = true;
				baseNumber("9");
				Body.base2 = 9;
				checkbox1.setSelected(false);
				checkbox2.setSelected(false);
			}
		});
		
		JMenuItem base10 = new JMenuItem("Base-10(Decimal)");
		base10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
			diffBase = false;
			baseNumber("10");
			Body.base2 = 10;
			checkbox1.setSelected(true);
			checkbox2.setSelected(false);
			}
		});
		
		JMenuItem base11 = new JMenuItem("Base-11");
		base11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				diffBase = true;
				baseNumber("11");
				Body.base2 = 11;
				checkbox1.setSelected(false);
				checkbox2.setSelected(false);
			}
		});

		
		JMenuItem base12 = new JMenuItem("Base-12(Duodecimal)");
		
		base12.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				diffBase = true;
				baseNumber("12");
				Body.base2 = 12;
				checkbox1.setSelected(false);
				checkbox2.setSelected(false);
			}
		});

		JMenuItem base13 = new JMenuItem("Base-13");
		
		base13.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
			diffBase = true;
			baseNumber("13");
			Body.base2 = 13;
			checkbox1.setSelected(false);
			checkbox2.setSelected(false);
			}
		});

		JMenuItem base14 = new JMenuItem("Base-14");
		
		base14.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				diffBase = true;
				baseNumber("14");
				Body.base2 = 14;
				checkbox1.setSelected(false);
				checkbox2.setSelected(false);
			}
		});

		JMenuItem base15 = new JMenuItem("Base-15");
		
		base15.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
			 diffBase = true;
			baseNumber("15");
			Body.base2 = 15;
			checkbox1.setSelected(false);
			checkbox2.setSelected(false);
			}
		});

		JMenuItem base16 = new JMenuItem("Base-16(Hexadecimal)");
		base16.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
			diffBase = false;
			baseNumber("16");
			Body.base2 = 16;			
			checkbox1.setSelected(false);
			checkbox2.setSelected(true);
			}
		});
		
		base.add(base2);
		base.add(base3);
		base.add(base4);
		base.add(base5);
		base.add(base6);
		base.add(base7);
		base.add(base8);
		base.add(base9);
		base.add(base10);
		base.add(base11);
		base.add(base12);
		base.add(base13);
		base.add(base14);
		base.add(base15);
		base.add(base16);
		// Defines File Save Function
		JMenuItem statistic = new JMenuItem("Statistic Options");
		
		// Defines Exit Function
		JMenuItem fileExit = new JMenuItem("Exit");
		fileExit.setMnemonic(KeyEvent.VK_C);
		fileExit.setToolTipText("Exit Application");
		fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				ActionEvent.CTRL_MASK));

		fileExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		/** Advanced Options==== */
		JMenu help = new JMenu("Help");

		JMenuItem decimal = new JMenuItem("ClipBoard");
		JMenuItem hexa = new JMenuItem("Base Systems");
		JMenuItem howToUse = new JMenuItem("How to use");
		JMenuItem stats = new JMenuItem("Statistic Options");


		help.add(decimal);
		help.add(hexa);
		help.add(stats);
		help.add(howToUse);
		

		// 
		JMenuItem print = new JMenuItem("Printing Options");
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));

		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				PrintingOptions printingOptions = new PrintingOptions();
				printingOptions.setVisible(true);
			}
		});
		// open.setMnemonic(KeyEvent.VK_O);

		// Defines File Save Function
		/** JMenuItem redo = new JMenuItem("Redo"); */

		// fileSave.setMnemonic(KeyEvent.VK_S);

		// Define Find Color function
		/** JMenuItem findColor = new JMenuItem("Find Color"); */

		options.add(print);
		 // Separator makes horizontal thin blue line.
		options.add(help);
		options.addSeparator();
		options.add(fileExit);
		
		
		advancedOptions.add(clipBoard);
		advancedOptions.add(base);
		advancedOptions.addSeparator();// Separator makes horizontal thin blue line.
		advancedOptions.add(help);
		
		

		
		menubar.add(options);
		menubar.add(advancedOptions);
		setJMenuBar(menubar);

	}

	public void initBody() {
		setLayout(null);

		textField1 = new JTextField();
		textField1.setBounds(20, 30, 100, 27);
		textField1.setFocusable(true);
		add(textField1);

		JLabel1 = new JLabel();
		JLabel1.setText("Number of Generations");
		JLabel1.setBounds(20, 10, 150, 21);
		add(JLabel1);

		button1 = new JButton("Generate");
		button1.setFocusable(false);
		button1.setForeground(Color.WHITE);
		button1.setBounds(127, 28, 100, 28);
		add(button1);
		
		
		baseNum = new JLabel();
		baseNum.setText(base);
		baseNum.setBounds(X, Y, 200, 21);
		baseNum.setVisible(true);
		add(baseNum);
		
		checkbox1 = new JCheckBox("Decimal");
		checkbox1.setSelected(true);
		checkbox1.setFocusable(false);
	
		checkbox1.setBounds(X , Y, 100, 21);
		
		add(checkbox1);

		checkbox2 = new JCheckBox("Hexadecimal");
		checkbox2.setSelected(false);
		checkbox2.setFocusable(false);
		checkbox2.setBounds(X, Y + 30, 100, 21);
		
		add(checkbox2);
		

		Events events = new Events();
		textField1.addActionListener(events);
		button1.addActionListener(events);
		checkbox1.addActionListener(events);
		checkbox2.addActionListener(events);
		

	}
	

	public void initStop(){
		JFrame Stop = new JFrame();
		
		
		
		Stop.setSize(100,50);
		Stop.setResizable(false);
		Stop.setLocationRelativeTo(null);
		
		
		Stop.setFocusable(true);
		Stop.setVisible(true);
		ImageIcon img = new ImageIcon(Icon);
		Stop.setIconImage(img.getImage());
	

		
		stop = new JButton("Stop");
		stop.setToolTipText("Stop Operation");
		stop.setForeground(Color.red);
		
		Stop.add(stop);
		Events events = new Events();
		stop.addActionListener(events);
		
	} 

		public void baseNumber(String getBase){
		 base = "<html><strong>Base-" + getBase + " Numbers</html></strong>";
		
		if (diffBase == true) {
			checkbox1.setBounds(X, Y + 24, 100, 21);
			checkbox2.setBounds(X, Y + 54, 100, 21);
			
			
			baseNum.setText(base);
			baseNum.setBounds(X, Y, 200, 21);
			baseNum.setVisible(true);
			
		} else if (diffBase == false) {
			checkbox1.setBounds(X, Y, 100, 21);
			checkbox2.setBounds(X, Y + 30, 100, 21);
			baseNum.setText("");
			baseNum.setBounds(X, Y, 200, 21);
			baseNum.setVisible(false);
		}


			System.out.println(base);
	}

	private class Events implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			System.out.println(checkbox1.isSelected() +"\t"+ checkbox2.isSelected());
			if (checkbox2.isSelected() == true && event.getSource() == checkbox2) {

				if (checkbox1.isSelected() == true) {
					checkbox1.setSelected(false);
					checkbox2.setSelected(true);
					
				}else if(checkbox1.isSelected() == false && checkbox2.isSelected() == false ){
					
					checkbox1.setSelected(false);
					checkbox2.setSelected(true);
				}
			}
			

			if(checkbox2.isSelected() == true && checkbox1.isSelected() == true){
				if(event.getSource() == checkbox1){	
					checkbox1.setSelected(true);
					checkbox2.setSelected(false);
					
				}
			}
			
			
			if(Body.base2 != 0 && Body.base2 != 10 && Body.base2 != 16){
				checkbox1.setSelected(false);
				checkbox2.setSelected(false);
			}
			System.out.println(Body.base2);
			
			if(checkbox1.isSelected() == true && checkbox2.isSelected() == false){
				Body.base2 = 10;
			}else if(checkbox2.isSelected() == true && checkbox1.isSelected() == false){
				Body.base2 = 16;
			}
			
			/**System.out.println(checkbox1.isSelected() +"\t"+ checkbox2.isSelected());
			if (event.getSource() == checkbox1) {
				if (checkbox2.isSelected() == false && checkbox1.isSelected() == false) {
					checkbox1.setSelected(false);
					checkbox2.setSelected(true);
				}else if(checkbox2.isSelected() == true && checkbox1.isSelected() == false)
					checkbox1.setSelected(true);
					checkbox2.setSelected(false);

			}
			System.out.println(checkbox1.isSelected() +"\t"+ checkbox2.isSelected());*/
			

			if (event.getSource() == textField1 && checkbox1.isSelected() == true
					&& checkbox2.isSelected() == false || event.getSource() == button1
					&& checkbox1.isSelected() == true
					&& checkbox2.isSelected() == false
					|| event.getSource() == textField1 && Body.base2 < 10 
					|| event.getSource() == button1 && Body.base2 < 10) {
				Random rand = new Random();
				enter = group * numOfGroups;
				System.out.println("Group: " + group + "NumofGroup: "
						+ numOfGroups);
				String numGen = textField1.getText();
				num = Double.parseDouble(numGen);
				JOptionPane.showMessageDialog(null, "Initiating " + num
						+ " Generations");
				//Initialize stop
				
				
				System.out.println("Initiating " + num + " Generations" + "\n");

				System.out.println("Value \t Occurrences");

				// Array to store number occurrences
				long numArray[] = new long[Body.base2];

				try {

					Thread.sleep(3000);
					for (int i = 0; i < num; i++) {
	
						int ran = rand.nextInt(Body.base2);
						++numArray[ran];
						try {

							Robot robot = new Robot();

							switch (ran) {
							case 0:
								robot.keyPress(KeyEvent.VK_0);
								break;
							case 1:
								robot.keyPress(KeyEvent.VK_1);
								break;
							case 2:
								robot.keyPress(KeyEvent.VK_2);
								break;
							case 3:
								robot.keyPress(KeyEvent.VK_3);
								break;
							case 4:
								robot.keyPress(KeyEvent.VK_4);
								break;
							case 5:
								robot.keyPress(KeyEvent.VK_5);
								break;
							case 6:
								robot.keyPress(KeyEvent.VK_6);
								break;
							case 7:
								robot.keyPress(KeyEvent.VK_7);
								break;
							case 8:
								robot.keyPress(KeyEvent.VK_8);
								break;
							case 9:
								robot.keyPress(KeyEvent.VK_9);
								break;
							case 10:
								robot.keyPress(KeyEvent.VK_A);
								break;
							case 11:
								robot.keyPress(KeyEvent.VK_B);
								break;
							case 12:
								robot.keyPress(KeyEvent.VK_C);
								break;
							case 13:
								robot.keyPress(KeyEvent.VK_D);
								break;
							case 14:
								robot.keyPress(KeyEvent.VK_E);
								break;
							case 15:
								robot.keyPress(KeyEvent.VK_F);
								break;

							}
							long ii = i + 1;

							if (ii % group == 0) {
								robot.keyPress(KeyEvent.VK_SPACE);

							}
							
							if (ii % enter == 0) {
								robot.keyPress(KeyEvent.VK_ENTER);
							}

						} catch (AWTException e) {
							e.printStackTrace();
						}
						/**if(event.getSource() == stop){
						break;}*/
					}

					for (int i = 0; i < numArray.length; i++) {
						if (i < 10) {
							System.out.println(i + "\t" + numArray[i]);
						} else if (i > 10) {
							switch (i) {
							case 11:
								System.out.println("A" + "\t" + numArray[i]);

								break;
							case 12:
								System.out.println("B" + "\t" + numArray[i]);
								break;
							case 13:
								System.out.println("C" + "\t" + numArray[i]);
								break;
							case 14:
								System.out.println("D" + "\t" + numArray[i]);
								break;
							case 15:
								System.out.println("E" + "\t" + numArray[i]);
								break;
							case 16:
								System.out.println("F" + "\t" + numArray[i]);
								break;
							}

						}

					}

				} catch (InterruptedException ie) {
				}
				System.out.println("\n" + "Satisfied:D yum...");

			} else if (event.getSource() == textField1 && checkbox1.isSelected() == false
					&& checkbox2.isSelected() == true || event.getSource() == button1
					&& checkbox1.isSelected() == false
					&& checkbox2.isSelected() == true
					|| event.getSource() == textField1 && Body.base2 > 10 
					|| event.getSource() == button1 && Body.base2 > 10) {
				Random rand = new Random();

				String numGen = textField1.getText();
				num = Double.parseDouble(numGen);
				JOptionPane.showMessageDialog(null, "Initiating " + num
						+ " Generations");
				enter = group * numOfGroups;

				System.out.println("Initiating " + num + " Generations" + "\n");

				System.out.println("Value \t Occurrences");

				// Array to store number occurrences
				int numArray[] = new int[17];

				try {

					Thread.sleep(3000);
					for (int i = 0; i < num; i++) {
						int ran = rand.nextInt(16);
						++numArray[ran];
						try {

							Robot robot = new Robot();

							switch (ran) {
							case 0:
								robot.keyPress(KeyEvent.VK_0);
								break;
							case 1:
								robot.keyPress(KeyEvent.VK_1);
								break;
							case 2:
								robot.keyPress(KeyEvent.VK_2);
								break;
							case 3:
								robot.keyPress(KeyEvent.VK_3);
								break;
							case 4:
								robot.keyPress(KeyEvent.VK_4);
								break;
							case 5:
								robot.keyPress(KeyEvent.VK_5);
								break;
							case 6:
								robot.keyPress(KeyEvent.VK_6);
								break;
							case 7:
								robot.keyPress(KeyEvent.VK_7);
								break;
							case 8:
								robot.keyPress(KeyEvent.VK_8);
								break;
							case 9:
								robot.keyPress(KeyEvent.VK_9);
								break;
							case 10:
								robot.keyPress(KeyEvent.VK_A);
								break;
							case 11:
								robot.keyPress(KeyEvent.VK_B);
								break;
							case 12:
								robot.keyPress(KeyEvent.VK_C);
								break;
							case 13:
								robot.keyPress(KeyEvent.VK_D);
								break;
							case 14:
								robot.keyPress(KeyEvent.VK_E);
								break;
							case 15:
								robot.keyPress(KeyEvent.VK_F);
								break;

							}
							int ii = i + 1;

							if (ii % group == 0) {
								robot.keyPress(KeyEvent.VK_SPACE);

							}

							if (ii % enter == 0) {
								robot.keyPress(KeyEvent.VK_ENTER);
								
							}
						} catch (AWTException e) {
							e.printStackTrace();
						}
					}
					int sum = 0;
					for (int i = 0; i < numArray.length; i++) {
						sum = sum + numArray[i];
						if (i < 10) {
							System.out.println(i + "\t" + numArray[i]);

						} else if (i >= 10) {

							switch (i) {

							case 10:
								System.out.println("A" + "\t" + numArray[i]);

								break;
							case 11:
								System.out.println("B" + "\t" + numArray[i]);
								break;
							case 12:
								System.out.println("C" + "\t" + numArray[i]);
								break;
							case 13:
								System.out.println("D" + "\t" + numArray[i]);
								break;
							case 14:
								System.out.println("E" + "\t" + numArray[i]);
								break;
							case 15:
								System.out.println("F" + "\t" + numArray[i]);
								System.out.println(sum);
								break;
							}

						}

					}

				} catch (InterruptedException ie) {
				}
				System.out.println("\n" + "Satisfied:D yum...");

			} else {
				System.out.println("\n" + "Not satisfied");
			}

		}

	}
	
}