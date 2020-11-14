import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.jar.Attributes.Name;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class ViewMenu {

	String[] menuG = {"", "Анімація","Екшн","Бойовик","Драма","Мелодрама","Комедія","Жахи","Фантастика","Триллер","Детектив","Пригоди","Історичний","Документальний","Дитячий","Сімейний","Фентезі","Спорт","інший жанр"};
	String[] countryM = {"","США", "Україна", "Росія","Англія","Австралія","Канада","Франція","Німеччина","Іспанія","Італія","Туреччина","Латинська Америка","Швеція","Фінляндія","Польща","Індія","Китай","Японія","інша країна"};
	String[] yearsM = {"","раніше","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990",
			"1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
			"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010",
			"2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
	JTextField nameF, genreF, alterGenreF, cF, yF, films;
	
	
	
	public ViewMenu() {
		
		JFrame frame = new JFrame("FavouriteFilms Меню Перегляду") {};
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim = tool.getScreenSize();
		frame.setBounds(dim.width/2 - 350, dim.height/2 - 150, 700, 300);
		JPanel pan = new JPanel();
		frame.add(pan);
		pan.setLayout(new GridBagLayout());
		Font font = new Font("Verdana", Font.PLAIN, 11);
		
		JMenuBar menuBar = new JMenuBar();	
		JMenu fileMenu = new JMenu("Повернутися");
        fileMenu.setFont(font);
        
        JMenuItem back = new JMenuItem("Назад");
        back.setFont(font);
        fileMenu.add(back);
        
        menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
        
        back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ChoiceMenu();
				frame.setVisible(false);
			}
		});
		
		JButton All = new JButton("Переглянути усю базу");
		pan.add(All, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		
		JButton config = new JButton("Додати фільтри");
		pan.add(config, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		
		frame.pack();
		
		All.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new All();
				frame.setVisible(false);
			}
		});
		
		config.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				JLabel nameFilm = new JLabel("Назва фільму");
				pan.add(nameFilm, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				
				final JTextField nameF = new JTextField(20);
				pan.add(nameF, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				
				JLabel genreFilm = new JLabel("Жанр фільму");
				pan.add(genreFilm, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				final JTextField genreF = new JTextField(20);
				pan.add(genreF, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				
				JLabel alterGenreFilm = new JLabel("Додатковий жанр фільму");
				pan.add(alterGenreFilm, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				final JTextField alterGenreF = new JTextField(20);
				pan.add(alterGenreF, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				
				JLabel countryF = new JLabel("Країна виробник");
				pan.add(countryF, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				final JTextField cF = new JTextField(20);
				pan.add(cF, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				
				JLabel yearsF = new JLabel("Країна виробник");
				pan.add(yearsF, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				final JTextField yF = new JTextField(20);
				pan.add(yF, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				
				JComboBox<String>cB = new JComboBox(menuG);
				pan.add(cB, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				
				JComboBox<String>cB1 = new JComboBox(menuG);
				pan.add(cB1, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				
				JComboBox<String>cB2 = new JComboBox(countryM);
				pan.add(cB2, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				
				JComboBox<String>cB3 = new JComboBox(yearsM);
				pan.add(cB3, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				
				JButton ok = new JButton("Підтвердити");
				pan.add(ok, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, 
						GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
						new Insets(2,2,2,2), 0,0));
				
				frame.revalidate();
				frame.pack();
				
				cB.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						final String textG = (String) cB.getSelectedItem();
						genreF.setText(textG);
					
					}
				});
				
				cB1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						final String textAG = (String) cB1.getSelectedItem();
						alterGenreF.setText(textAG);
						
					}
				});
				
				cB2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						final String textC = (String) cB2.getSelectedItem();
						cF.setText(textC);
					}
				});
				
				cB3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						final String textY = (String) cB3.getSelectedItem();
						yF.setText(textY);
					}
				});
				
				ok.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						frame.setVisible(false);
						
						final String n = nameF.getText();
						final String g = genreF.getText();
						final String ag = alterGenreF.getText();
						final String c = cF.getText();
						final String y = yF.getText();
						
						JFrame frame = new JFrame("FavouriteFilms Menu") {};
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
				               
				               ResultSet resultSet = statement.executeQuery("SELECT * FROM films WHERE NameFilms = '"+n+"' OR Genre = '"+g+"' OR AlternativeGenre = '"+ag+"' OR Country = '"+c+"' OR Years = '"+y+"';");
				              
				               while(resultSet.next()){
				                   
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
						
					}
				});
				
			}
		});
		
		
		
		
	}

}
