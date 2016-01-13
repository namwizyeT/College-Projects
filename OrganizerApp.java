package groupProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Program: CalendarApp Project: Group Project Package:
 * 
 * @author Taizya
 * @since Jul 27, 2015
 * 
 */
@SuppressWarnings("serial")
public class OrganizerApp extends JFrame {

	/**
	 * main panel
	 */
	private JPanel contentPane;
	/**
	 * panel for contacts
	 */
	private JPanel displayContacts;
	/**
	 * panel for toDoList in a file
	 */
	private JPanel displayToDO;
	/**
	 * control Panel for toDoList
	 */
	private JPanel toDoControlPanel;
	/**
	 * panel for entering toDoList items
	 */
	private JPanel toDoArea;
	/**
	 * panel for contacts
	 */
	private JPanel contactsControlPanel;

	/**
	 * menu bar
	 */
	private JMenuBar menuBar;
	/**
	 * calendar menu item
	 */
	private JMenuItem calendar;
	/**
	 * todoList menu item
	 */
	private JMenuItem todoList;
	/**
	 * contacts menu item
	 */
	private JMenuItem contactsList;
	/**
	 * exit menu item
	 */
	private JMenuItem exit;

	/**
	 * button to add contacts
	 */
	private JRadioButton rdbtnContacts1;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * array with contacts
	 */
	ArrayList<Contacts> contactList = new ArrayList<Contacts>();
	/**
	 * main page label
	 */
	private JLabel welcome;
	/**
	 * button to change color of the interface
	 */
	private JButton changeColorBtn;
	/**
	 * label to create a border on the page
	 */
	private JLabel lblNewLabel_1;
	/**
	 * label which shows the current date and time
	 */
	private JLabel dateNow;
	/**
	 * label to create a border on the page
	 */
	private JLabel placeHolder2;

	/**
	 * Calls methods that create the application
	 */
	public OrganizerApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(198, 146, 222));
		setContentPane(contentPane);

		createMenu();
		createDateTime();
		createPlanner();
		createContactsControlPanel();
		createTodoListControlPanel();
		createtodoListArea();
	}

	/**
	 * Method reads from contacts and todoList files and displays them in panels
	 */
	private void createPlanner() {

		displayContacts = new JPanel();
		displayContacts.setBackground(welcome.getBackground());
		try {
			Scanner readContacts = new Scanner(new File("Contacts.txt"));
			while (readContacts.hasNextLine()) {
				JLabel area1 = new JLabel(readContacts.nextLine());
				displayContacts.add(area1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		displayToDO = new JPanel();
		displayToDO.setBackground(welcome.getForeground());
		try {
			Scanner readList = new Scanner(new File("Items.txt"));
			while (readList.hasNextLine()) {

				JLabel area2 = new JLabel(readList.nextLine());
				displayToDO.add(area2);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method creates the main page
	 */
	private void createDateTime() {

		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel top = new JPanel();
		top.setBackground(new Color(198, 146, 222));
		welcome = new JLabel("Welcome to Your Organizer!",
				SwingConstants.CENTER);
		welcome.setForeground(Color.MAGENTA);
		welcome.setFont(new Font("Bradley Hand ITC Regular", Font.ITALIC, 60));
		top.add(welcome);

		JPanel east = new JPanel();
		east.setBackground(Color.MAGENTA);
		lblNewLabel_1 = new JLabel("                    ");
		east.add(lblNewLabel_1);

		JPanel center = new JPanel();
		center.setBackground(new Color(77, 8, 115));
		Date date = new Date();
		dateNow = new JLabel(date.toString(), SwingConstants.CENTER);
		dateNow.setVerticalAlignment(SwingConstants.CENTER);
		dateNow.setForeground(Color.LIGHT_GRAY);
		dateNow.setFont(new Font("Century Gothic", Font.PLAIN, 70));
		center.add(dateNow);

		JPanel west = new JPanel();
		west.setBackground(Color.MAGENTA);
		placeHolder2 = new JLabel("                    ");
		west.add(placeHolder2);

		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(198, 146, 222));
		changeColorBtn = new JButton("Click Me!");
		changeColorBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (welcome.getForeground().equals(Color.MAGENTA)) {
					welcome.setForeground(Color.BLUE);
					west.setBackground(Color.BLUE);
					east.setBackground(Color.BLUE);
				} else {
					welcome.setForeground(Color.MAGENTA);
					west.setBackground(Color.MAGENTA);
					east.setBackground(Color.MAGENTA);
				}
			}
		});
		bottom.add(changeColorBtn);

		getContentPane().add(west, BorderLayout.WEST);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(center, BorderLayout.CENTER);
		getContentPane().add(top, BorderLayout.NORTH);
		getContentPane().add(bottom, BorderLayout.SOUTH);
	}

	/**
	 * Method creates control panel to add contacts
	 */
	private void createContactsControlPanel() {

		contactsControlPanel = new JPanel();
		contactsControlPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		contactsControlPanel.setLayout(new GridLayout(12, 1, 0, 0));
		contactsControlPanel.setBackground(welcome.getBackground());

		rdbtnContacts1 = new JRadioButton("Add Contacts");
		buttonGroup_1.add(rdbtnContacts1);
		contactsControlPanel.add(rdbtnContacts1);
		rdbtnContacts1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				contactsControlPanel
						.setBackground(SystemColor.controlHighlight);
				contactsControlPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
				contactsControlPanel.setLayout(new GridLayout(7, 1, 0, 0));
				contactsControlPanel.setPreferredSize(new Dimension(150, 150));

				JTextField fnameField = new JTextField("First Name");
				contactsControlPanel.add(fnameField);
				JTextField lnameField = new JTextField("Last Name");
				contactsControlPanel.add(lnameField);
				JTextField phoneField = new JTextField("Phone Number");
				contactsControlPanel.add(phoneField);
				JTextField relField = new JTextField("Relationship");
				contactsControlPanel.add(relField);
				JButton completeEntry = new JButton("Complete");
				contactsControlPanel.add(completeEntry);
				completeEntry.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {

						Contacts c = new Contacts(fnameField.getText(),
								lnameField.getText(), phoneField.getText(),
								relField.getText());
						contactList.add(c);

						int result = JOptionPane.showConfirmDialog(null,
								"Favorites?", "Add to favorites?",
								JOptionPane.YES_NO_OPTION);

						if (result == JOptionPane.YES_OPTION) {

							FavoriteContacts favs = new FavoriteContacts();
							favs.addElements(c);
							try {
								PrintWriter pw = new PrintWriter(
										"FavContacts.txt");

								pw.println("Favorite Contacts: ");
								pw.println(favs.getFavs());
								pw.flush();
								pw.close();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
							JOptionPane.showConfirmDialog(null,
									"Sucess! Your favorites have been added",
									"Success!", JOptionPane.PLAIN_MESSAGE);
						} else {
							try {
								PrintWriter pw2 = new PrintWriter(
										"Contacts.txt");
								pw2.println("Contacts: ");
								pw2.println(c);
								pw2.flush();
								pw2.close();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
						}
					}

				});
			}

		});

	}

	/**
	 * Method creates an area for todoList to be created by the user
	 */
	private void createtodoListArea() {

		toDoArea = new JPanel();
		toDoArea.setBackground(welcome.getBackground());
		toDoArea.setLayout(new GridLayout(5, 1, 10, 10));

	}

	/**
	 * Method creates a control panel for todo list
	 */
	private void createTodoListControlPanel() {

		toDoControlPanel = new JPanel();
		toDoControlPanel.setBackground(welcome.getForeground());
		JTextField userMonth = new JTextField("Enter Month");
		JButton userMonthBtn = new JButton("OK!");
		toDoControlPanel.add(userMonth);
		toDoControlPanel.add(userMonthBtn);
		userMonthBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JLabel userMonthLbl = new JLabel(userMonth.getText());
				toDoArea.add(userMonthLbl);

				JTextField item1 = new JTextField("Item 1");
				toDoArea.add(item1);
				JTextField item2 = new JTextField("Item 2");
				toDoArea.add(item2);
				JTextField item3 = new JTextField("Item 3");
				toDoArea.add(item3);
				JTextField item4 = new JTextField("Item 4");
				toDoArea.add(item4);
				JTextField item5 = new JTextField("Item 5");
				toDoArea.add(item5);
				JButton addItem = new JButton("DONE");
				addItem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						try {
							PrintWriter pw3 = new PrintWriter(new File(
									"Items.txt"));
							pw3.println("Items for Month of: "
									+ userMonth.getText());
							pw3.println("1. " + item1.getText());
							pw3.println("2. " + item2.getText());
							pw3.println("3. " + item3.getText());
							pw3.println("4. " + item4.getText());
							pw3.println("5. " + item5.getText());
							pw3.flush();
							pw3.close();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					}

				});
				toDoArea.add(addItem);
				revalidate();
				repaint();

			}

		});

	}

	/**
	 * Method creates menu
	 */
	private void createMenu() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		contactsList = new JMenuItem("CONTACTS");
		contactsList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(contactsControlPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		menuBar.add(contactsList);

		todoList = new JMenuItem("TODO LIST");
		todoList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(toDoControlPanel, BorderLayout.WEST);
				contentPane.add(toDoArea, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		menuBar.add(todoList);

		calendar = new JMenuItem("PLANNER");
		calendar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(displayContacts, BorderLayout.WEST);
				contentPane.add(displayToDO, BorderLayout.EAST);
				revalidate();
				repaint();
			}
		});
		menuBar.add(calendar);
		exit = new JMenuItem("EXIT");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menuBar.add(exit);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					OrganizerApp frame = new OrganizerApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
