import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class StartProgram {
    
	String Login = " ";
	String PasswordKey = " ";
	String login = " ";
	String passwordKey = " ";
	
    public StartProgram()
    {
    	JFrame.setDefaultLookAndFeelDecorated(true);
    	JFrame frame = new JFrame("FavouriteFilms Старт") {} ;
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim = tool.getScreenSize();
		frame.setBounds(dim.width/2 - 250, dim.height/2 - 200, 500, 400);
		
		Font font = new Font("Segoe UI semibold", Font.PLAIN, 20);
		Font font1 = new Font("Segoe", Font.PLAIN, 13);
		
		
		JPanel pan = new JPanel();
		frame.add(pan);
		
		pan.setLayout(new GridBagLayout());
		
		JLabel lab1 = new JLabel("ВІТАЄМО ВАС У FavouriteFilms!!!");
		pan.add(lab1, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, 
				GridBagConstraints.CENTER, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		lab1.setFont(font);
		JLabel lab2 = new JLabel("Для продовження роботи потрібно авторизуватися");
		pan.add(lab2, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2,2,2,2), 0,0));
		lab2.setFont(font1);
		JLabel lab3 = new JLabel("*************************************************************");
		pan.add(lab3, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2,2,2,2), 0,0));
		
		JLabel log = new JLabel("ЛОГІН:");
		pan.add(log, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2,2,2,2), 0,0));
		JTextField name = new JTextField(20);
		pan.add(name, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2,2,2,2), 0,0));
		JLabel pass = new JLabel("ПАРОЛЬ:");
		pan.add(pass, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2,2,2,2), 0,0));
		JTextField passwordK = new JTextField(20);
		pan.add(passwordK, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2,2,2,2), 0,0));
		
		JButton but3 = new JButton("Увійти");
		pan.add(but3, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2,2,2,2), 0,0));
		JButton but4 = new JButton("Зареєструватися");
		pan.add(but4, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2,2,2,2), 0,0));
		
		frame.pack();
		
but3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String n = name.getText();
				String p  = passwordK.getText();
				
				
				try{
		            String url = "jdbc:mysql://localhost/favouritefilms?serverTimezone=Europe/Kiev&useSSL=false";
		            String username = "root";
		            String password = "11052013s";
		            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		                      
		                try (Connection conn = DriverManager.getConnection(url, username, password)){
		                	
		               	 Statement statement = conn.createStatement();
		                        
		             	String login = n;
		               	String passwordKey = p; 
		               			                    
		               	ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE EXISTS (SELECT * FROM users WHERE login = '" + login + "' AND passwordKey = '" + passwordKey + "')");
		                        
		                        while(resultSet.next()){
		                             
		                     	   int id = resultSet.getInt(1);
		                            Login = resultSet.getString(2);
		                            PasswordKey = resultSet.getString(3);
		                            
		                           
		                        }
		                        boolean result1 = Login.equalsIgnoreCase(login);
		                        boolean result2 = PasswordKey.equalsIgnoreCase(passwordKey);
		                        
		                        if (result1 == true || result2 == true) {
		                        	
		                        JOptionPane.showMessageDialog(but3, "Авторизація пройшла успішно!!!");
		        				frame.setVisible(false);
		        				
		        				new ChoiceMenu();
		                        } else {
		                        	JOptionPane.showMessageDialog(but3, "Невірний логін або пароль!!! Спробуйте ще!!!");
		                        }
		                        }
		                     }
		               
		                
		         		
		                 catch(Exception ex){
		                     System.out.println("Connection failed...");
		                      
		                     System.out.println(ex);
		                 }
				
				
			}
		});

			but4.addActionListener(new ActionListener() {
	
					@Override
						public void actionPerformed(ActionEvent e) {
						Registration reg = new Registration();
		
					}
			});
}
    public static void main(String[] args) {
		new StartProgram();
    }
}
