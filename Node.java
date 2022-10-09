//Node for linked list
import java.io.*;

public class Node implements Serializable{
	private Node previous; 
	private Node next; 
	private String info; 
		
	public Node(){
		previous = null;
		next = null; 
		info = ""; 
	}
		
	public Node(Node p, Node n, String in){ 
		previous = p; 
		next = n;
		info = in;
	}
		
	public Node getPrev(){
		return previous;
	}
		
	public void setPrev(Node p){ 
		previous = p;
	}
		
	public Node getNext(){ 
		return next;
	}
		
	public void setNext(Node n){ 
		next = n;
	}
		
	public void setInfo(String i){
		info = i;
	}
		
	public String getInfo(){
		return info;
	}
}