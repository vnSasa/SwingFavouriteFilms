import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChoiceMenu {

	public ChoiceMenu() {
		JFrame frame = new JFrame() {};
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim = tool.getScreenSize();
		frame.setBounds(dim.width/2 - 250, dim.height/2 - 150, 500, 300);
		frame.setTitle("FavouriteFilms Меню");
		JPanel pan = new JPanel();
		frame.add(pan);
		pan.setLayout(new GridBagLayout());
		Font font = new Font("Segoe UI semibold", Font.PLAIN, 20);
		Font font1 = new Font("Segoe", Font.PLAIN, 13);
		
		JLabel tex = new JLabel("FavouriteFilms вітає вас!!!");
		pan.add(tex, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, 
				GridBagConstraints.CENTER, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		tex.setFont(font);
		
		JLabel tex1 = new JLabel("Тут ви можете переглядати списки фільмів"); 
		pan.add(tex1, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, 
				GridBagConstraints.CENTER, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		tex1.setFont(font1);
		JButton watch = new JButton("Переглядати");
		pan.add(watch, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, 
				GridBagConstraints.CENTER, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		
		JLabel tex2	= new JLabel("Або додавати в базу нові дані про свої улюблені фільми"); 
		pan.add(tex2, new GridBagConstraints(0, 3, 3, 1, 0.0, 0.0, 
				GridBagConstraints.CENTER, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));
		tex2.setFont(font1);
		JButton add = new JButton("Додавати");
		pan.add(add, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, 
				GridBagConstraints.CENTER, GridBagConstraints.PAGE_START,
				new Insets(1,2,3,4), 0,0));
		
		JLabel tex3 = new JLabel("Допоможіть іншим знайти хороше кіно");		 
		pan.add(tex3, new GridBagConstraints(0, 5, 3, 1, 0.0, 0.0, 
				GridBagConstraints.CENTER, GridBagConstraints.PAGE_START,
				new Insets(2,2,2,2), 0,0));	
		tex3.setFont(font1);
		
		frame.pack();
		watch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewMenu view = new ViewMenu();
				frame.setVisible(false);
			}
		});
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddFilms();
				frame.setVisible(false);
			}
		});
		
	}
}
