import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class AsciiCanvas extends JTextArea implements Serializable{
    private JTextArea textArea; 
	private Node head; 
	private Node current;

	public AsciiCanvas(){ 
	    textArea = new JTextArea(10, 20);
		head = new Node(); 
		current = head;
	}//default contstructor
	
	public void anim(){ // Animation function
		if (current.getInfo() != null) {
			textArea.append(current.getInfo()); 
			nextFrame();
		}
	}
	
	public void nextFrame(){
		current.setInfo(textArea.getText());
		if (current.getNext() == null){ 
			Node newNode = new Node(current, null,"");
			current = newNode;
		} else {
			current = current.getNext(); 
			textArea.append(current.getInfo());
		}
	}
		
	public void prevFrame(){
		if (current.getPrev() != null){ //to make sure there's still a previous frame
			current.setInfo(textArea.getText());
			current = current.getPrev(); 
			textArea.append(current.getInfo()); 
		} else { // if there's no previous node
			textArea.append("");
		}
	}//end previous frame function
		
	
	//serialization always messes with me, let's make sure I do it write this time
	public void save(){ // save function to serialize
		try { // attempt to cleanly serialize out
			FileOutputStream fileOut = new FileOutputStream("Anime.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut); 
			out.writeObject(head); 
			out.close();
			fileOut.close(); 
		}catch(IOException i) {
			i.printStackTrace();
		}
	}
		
	public void load(){ // load function
		try {
			FileInputStream fileIn = new FileInputStream("Anime.ser"); 
			ObjectInputStream in = new ObjectInputStream(fileIn); 
			Node current = (Node)in.readObject(); 
			Node head = current;
			in.close(); 
			fileIn.close();
		}catch(IOException i) {
			i.printStackTrace();
		}catch(ClassNotFoundException c) { 
			c.printStackTrace(); 
		}
		textArea.append(head.getInfo());
	}
}