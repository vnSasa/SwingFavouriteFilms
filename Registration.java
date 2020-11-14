import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registration {

	public Registration() {
		
		JFrame frame = new JFrame() {};
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim = tool.getScreenSize();
		frame.setBounds(dim.width/2 - 250, dim.height/2 - 150, 500, 300);
		frame.setTitle("Реєстрація");
		JPanel pan = new JPanel();
		frame.add(pan);
		pan.setLayout(new GridBagLayout());
		
		JLabel log = new JLabel("ЛОГІН:");
		pan.add(log, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1,2,3,4), 0,0));
		JTextField name = new JTextField(20);
		pan.add(name, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1,2,3,4), 0,0));
		JLabel pass = new JLabel("ПАРОЛЬ:");
		pan.add(pass, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1,2,3,4), 0,0));
		JTextField passwordKey = new JTextField(20);
		pan.add(passwordKey, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1,2,3,4), 0,0));
		JButton but2 = new JButton("Зареєструватися");
		pan.add(but2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1,2,3,4), 0,0));
		frame.pack();
		
		but2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String n = name.getText();
				System.out.println(n);
				String p = passwordKey.getText();
				System.out.println(p);
				
			
				try{
			        String url = "jdbc:mysql://localhost/favouritefilms?serverTimezone=Europe/Kiev&useSSL=false";
			        String username = "root";
			        String password = "11052013s";
			        
			        
			        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			        
			        	
			        	String login = n;
			        	String passwordK = p;
			        	
			        	

			        try (Connection conn = DriverManager.getConnection(url, username, password)){
			            
			        	String sqlCommand = "insert into users (Login, PasswordKey) values (?, ?)";
			        	
			        	PreparedStatement preparedStatement = conn.prepareStatement(sqlCommand);
			        	
			        	
			        	preparedStatement.setString(1, login);
			        	preparedStatement.setString(2, passwordK);
			        	
			        	int rows = preparedStatement.executeUpdate();
			       	        	
			        	JOptionPane.showMessageDialog(but2, "Реєстрація пройшла успішно!!!");
        				frame.setVisible(false);
			          
			        }
			    }
			    catch(Exception ex){
			        System.out.println("Connection failed...");
			         
			        System.out.println(ex);
			    }
			
			}
			
		});
	}
	
}
