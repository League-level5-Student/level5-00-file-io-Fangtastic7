package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("add task");
	JButton view = new JButton("view task");
	JButton remove = new JButton("remove task");
	JButton save = new JButton("save list");
	JButton load = new JButton("load list");
	ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		new ToDoList().createUI();
	}

	private void createUI() {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.pack();
		start();
	}

	private void start() {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/00_ToDoList.txt"));
		       String line;
		        while ((line = br.readLine()) != null) {
		           list.add(line);
		        }
		        br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) arg0.getSource();
		if (buttonPressed == add) {
			add();
		} else if (buttonPressed == view) {
			showlist();
		} else if (buttonPressed == remove) {
			remove();
		} else if(buttonPressed == save) {
			save();
		} else if(buttonPressed == load) {
			load();
		}

	}

	private void load() {
		// TODO Auto-generated method stub
		String link = JOptionPane.showInputDialog("Give me the link to load information onto one file.");
		try {
			BufferedReader br = new BufferedReader(new FileReader(link));
		       String line;
		        while ((line = br.readLine()) != null) {
		           list.add(line);
		        }
		        br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void save() {
		// TODO Auto-generated method stub
		try {
		FileWriter fw = new FileWriter("src/00_ToDoList.txt", true);
		for(int i=0;i<list.size();i++) {
			fw.write(list.get(i));
			fw.write("\n");
			System.out.println("write");
		}
		fw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	private void remove() {
		// TODO Auto-generated method stub
		try {
			String task = JOptionPane.showInputDialog("Which task do you want to eliminate? Type the number of the task");
			int task1 = Integer.parseInt(task);
			for (int i = 0; i < list.size(); i++) {
				if (task1 - 1 == i) {
					list.remove(i);
				}
			}
		} catch (Exception e) {
			System.out.println("That's not a number in the tasks!");
		}

	}

	private void showlist() {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private void add() {
		// TODO Auto-generated method stub
		String entry = JOptionPane.showInputDialog("Give me a task.");
		list.add(entry);
	}
}
