import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class All extends JFrame {

	public All() {
	
		JFrame frame = new JFrame("FavouriteFilms Переглянути все") {};
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Verdana", Font.PLAIN, 11);
		Font font1 = new Font("Segoe UI semibold", Font.PLAIN, 13);
		Font font2 = new Font("Segoe", Font.PLAIN, 13);
		
		JPanel pan = new JPanel();
		frame.add(pan);
		pan.setLayout(new BorderLayout());
		
		JMenuBar menuBar = new JMenuBar();	
		JMenu fileMenu = new JMenu("Файл");
        fileMenu.setFont(font);
        
        JMenuItem back = new JMenuItem("Назад");
        back.setFont(font);
        fileMenu.add(back);
         
        JMenuItem sort = new JMenuItem("Сортувати за рейтингом додавання");
        sort.setFont(font);
        fileMenu.add(sort);
		
        final JTextArea all = new JTextArea(1200, 300);   
        all.setCaretPosition(0);
        pan.add(all, BorderLayout.CENTER);
        all.setEnabled(false);
		
		final JScrollPane sc = new JScrollPane(all);
		pan.add(sc);
		frame.getContentPane().add(pan);
		
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		frame.setPreferredSize(new Dimension(1220, 300));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewMenu();
				frame.setVisible(false);
			}
		});
		
		
		int i = 10;
		
		
		try{
            String url = "jdbc:mysql://localhost/favouritefilms?serverTimezone=Europe/Kiev&useSSL=false";
            String username = "root";
            String password = "11052013s";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
             
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                 
               Statement statement = conn.createStatement();
               
               ResultSet resultSet = statement.executeQuery("SELECT * FROM films");
              
               while(resultSet.next()){
                  
            	   	  int id = resultSet.getInt(1);
                      String NameFilms = resultSet.getString(2);
	                  String Genre = resultSet.getString(3);
                      String AlternativeGenre = resultSet.getString(4);
                      String Country = resultSet.getString(5);
                      String Years = resultSet.getString(6);
                      String LinkOnline = resultSet.getString(7);
                      String LinkOffline = resultSet.getString(8);
                      String text = " "+NameFilms+" - "+Genre+", "+AlternativeGenre+" ("+Country+", "+Years+" рік), подивитись онлайн - "+LinkOnline+", завантажити - "+LinkOffline;
                      
                      JTextField films = new JTextField(text);
                      films.setEditable(false);
                      pan.add(films);
                      all.add(films);
                      films.setBounds(10, i, 1180, 20);
                                            
                      i+=30;
                      
               }
                   
               
            }
      
        
		}
		
        catch(Exception ex){
            System.out.println("Connection failed...");
             
            System.out.println(ex);
        
	}

		
		sort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			frame.setVisible(false);
				
				JFrame frame = new JFrame("FavouriteFilms Посортований Перегляд") {};
          		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          		
          			Font font = new Font("Verdana", Font.PLAIN, 11);
          		
          		JPanel pan = new JPanel();
          		frame.add(pan);
          		pan.setLayout(new BorderLayout());
          		
          		JMenuBar menuBar = new JMenuBar();	
          		JMenu fileMenu = new JMenu("File");
                fileMenu.setFont(font);
                  
                JMenuItem back = new JMenuItem("Назад");
                back.setFont(font);
                  fileMenu.add(back);
                  
                  final JTextArea all = new JTextArea(1200, 300);   
                  	all.setCaretPosition(0);
                  	all.setEditable(false);
                  	pan.add(all, BorderLayout.CENTER);
          		
                  final JScrollPane sc = new JScrollPane(all);
          			pan.add(sc);
          			frame.getContentPane().add(pan);
          		
          		menuBar.add(fileMenu);
          		frame.setJMenuBar(menuBar);
          		frame.setPreferredSize(new Dimension(1220, 300));
          		frame.pack();
          		frame.setLocationRelativeTo(null);
          		frame.setVisible(true);
          		back.addActionListener(new ActionListener() {
          			
          			@Override
          			public void actionPerformed(ActionEvent e) {
          				new ViewMenu();
          				frame.setVisible(false);
          			}
          		});
				
				
				int i = 10;
				
				
				try{
		            String url = "jdbc:mysql://localhost/favouritefilms?serverTimezone=Europe/Kiev&useSSL=false";
		            String username = "root";
		            String password = "11052013s";
		            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		             
		            try (Connection conn = DriverManager.getConnection(url, username, password)){
		                 
		               Statement statement = conn.createStatement();
		               
		               ResultSet resultSet = statement.executeQuery("SELECT namefilms, count(*) AS rate FROM films GROUP BY namefilms ORDER BY rate DESC");
		              
		               while(resultSet.next()){
		                   
		            	   	 String NameFilms = resultSet.getString(1);
		            	   	 String rate = resultSet.getString(2);
		                     String text = " "+NameFilms+" - Кількість додавань: "+rate;
		                      
		                     JTextField films = new JTextField(text);
		                     films.setEditable(false);
		                     pan.add(films);
		                     all.add(films);
		                     films.setBounds(10, i, 1180, 20);
		                      
		                                            
		                      i+=30;
		                      
		               }
		                   
		               
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
