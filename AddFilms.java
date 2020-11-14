import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddFilms {

	String[] menuG = {"", "Анімація","Екшн","Бойовик","Драма","Мелодрама","Комедія","Жахи","Фантастика","Триллер","Детектив","Пригоди","Історичний","Документальний","Дитячий","Сімейний","Фентезі","Спорт","інший жанр"};
	String[] countryM = {"","США", "Україна", "Росія","Англія","Австралія","Канада","Франція","Німеччина","Іспанія","Італія","Туреччина","Латинська Америка","Швеція","Фінляндія","Польща","Індія","Китай","Японія","інша країна"};
	String[] yearsM = {"","раніше","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990",
			"1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
			"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010",
			"2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
	JComboBox cb, cb1, cb2, cb3;
	
	public AddFilms() {
		
		JFrame frame = new JFrame() {};
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim = tool.getScreenSize();
		frame.setBounds(dim.width/2 - 250, dim.height/2 - 150, 500, 300);
		frame.setTitle("FavouriteFilms Меню Додавання");
		JPanel pan = new JPanel();
		frame.add(pan);
		pan.setLayout(new GridBagLayout());
		
		JLabel nameFilm = new JLabel("Назва фільму");
		pan.add(nameFilm, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		JTextField namef = new JTextField(20);
		pan.add(namef, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		
		JLabel genreFilm = new JLabel("Жанр фільму");
		pan.add(genreFilm, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		JTextField genref = new JTextField(20);
		pan.add(genref, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		JComboBox<String>cB = new JComboBox(menuG);
		pan.add(cB, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		
		JLabel alternativeGenreFilm = new JLabel("Додатковий жанр фільму");
		pan.add(alternativeGenreFilm, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		JTextField alterGenref = new JTextField(20);
		pan.add(alterGenref, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		JComboBox<String>cB1 = new JComboBox(menuG);
		pan.add(cB1, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		
		JLabel countryFilm = new JLabel("Країна виробник");
		pan.add(countryFilm, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		JTextField countryf = new JTextField(20);
		pan.add(countryf, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		JComboBox<String>cB2 = new JComboBox(countryM);
		pan.add(cB2, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		
		JLabel yearsFilm = new JLabel("Рік випуску");
		pan.add(yearsFilm, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		JTextField yearsf = new JTextField(20);
		pan.add(yearsf, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		JComboBox<String>cB3 = new JComboBox(yearsM);
		pan.add(cB3, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		
		JLabel linkOnlineFilm = new JLabel("Посилання на перегляд");
		pan.add(linkOnlineFilm, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		JTextField linkOnlinef = new JTextField(20);
		pan.add(linkOnlinef, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		
		JLabel linkOfflineFilm = new JLabel("Посилання на завантаження");
		pan.add(linkOfflineFilm, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		JTextField linkOfflinef = new JTextField(20);
		pan.add(linkOfflinef, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		
		cB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				final String textG = (String) cB.getSelectedItem();
				genref.setText(textG);
			
			}
		});
		
		cB1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				final String textAG = (String) cB1.getSelectedItem();
				alterGenref.setText(textAG);
				
			}
		});
		
		cB2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				final String textC = (String) cB2.getSelectedItem();
				countryf.setText(textC);
			}
		});
		
		cB3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				final String textY = (String) cB3.getSelectedItem();
				yearsf.setText(textY);
			}
		});
		
		JButton ok = new JButton("Додати");
		pan.add(ok, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
			        String url = "jdbc:mysql://localhost/favouritefilms?serverTimezone=Europe/Kiev&useSSL=false";
			        String username = "root";
			        String password = "11052013s";
			        Scanner scan = new Scanner(System.in);
			        
			        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			        
			        String n = namef.getText();
			        String g = genref.getText();
			        String ag= alterGenref.getText();
			        String c = countryf.getText();
			        String y = yearsf.getText();
			        String lo= linkOnlinef.getText();
			        String loff= linkOfflinef.getText();
			        
			        	String name = n;
			        	
			        	String genre = g;
			        	
			        	String alternativeGenre = ag;
			        	
			        	String country = c;

			        	String years = y;
			        	
			        	String linkOnline = lo;
			        	
			        	String linkOffline = loff;
			        	
			        	
			        	
			        try (Connection conn = DriverManager.getConnection(url, username, password)){
			            
			        	String sqlCommand = "insert into films (NameFilms, Genre, AlternativeGenre, Country, Years, LinkOnline, LinkOffline) values (?, ?, ?, ?, ?, ?, ?)";
			        	
			        	PreparedStatement preparedStatement = conn.prepareStatement(sqlCommand);
			        	
			        	preparedStatement.setString(1, name);
			        	preparedStatement.setString(2, genre);
			        	preparedStatement.setString(3, alternativeGenre);
			        	preparedStatement.setString(4, country);
			        	preparedStatement.setString(5, years);
			        	preparedStatement.setString(6, linkOnline);
			        	preparedStatement.setString(7, linkOffline);
			        	
			        	int rows = preparedStatement.executeUpdate();
			        	
			        	JOptionPane.showMessageDialog(ok, "Дані записано!!!");
			        	new ChoiceMenu();
        				frame.setVisible(false);
			        	
			           System.out.printf("%d rows added", rows);
			           
			        }
			    }
			    catch(Exception ex){
			        System.out.println("Connection failed...");
			         
			        System.out.println(ex);
			    }
				
			}
		});
		
		JButton exit = new JButton("Завершити");
		pan.add(exit, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, 
				GridBagConstraints.WEST, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ChoiceMenu();
				frame.setVisible(false);
				
			}
		});
		
		frame.pack();
	}
}
