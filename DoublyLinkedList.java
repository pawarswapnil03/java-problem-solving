import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoublyLinkedList {

	// Link list Node Class
	static class Node {
	 
	    String data;
	    Node prev;
	    Node next;
	 	    
	    Node(String data)
	    {
	        this.data = data;
	        this.prev = null;
	        this.next = null;
	    }
	};
	
	static class pair
	{
	    Node first, second;
	    public pair(Node first, Node second) 
	    {
	        this.first = first;
	        this.second = second;
	    }   
	}
	 
	// Function to print linked list
	static void print(Node head)
	{
	    Node temp = head;
	 
	    // Iterate until node is NOT null
	    while (temp != null) {
	        System.out.print(temp.data+ " ");
	        temp = temp.next;
	    }
	    System.out.println();
	}
	
	static Node head;
	static Node tail;
	
	// Function to push a node in DLL
	static void push( String item)
	{
	 
	    // Doubly linkedlist is empty
	    if (tail == null) {	 
	        Node temp = new Node(item);
	        tail = temp;
	        head = temp;
	    }
	 
	    // Doubly linkedlist is not empty
	    else {
	        Node temp = new Node(item);
	        tail.next = temp;
	        temp.prev = tail;
	        tail = temp;
	    }
	}
	 
	// Function to find the nodes which have to be moved
	static pair find(int x, int y)
	{
	    Node N1 = null;
	    Node N2 = null;
	    Node temp = head;
	    int count = 1;
	    
	    // Traversing the list
	    while (temp != null) {
	        if (count == x)
	            N1 = temp;
	        else if (count == y)
	            N2 = temp;
	        temp = temp.next;
	        count++;
	    }
	    return new pair(N1, N2);
	}
	 
	// Function to move the nodes	
	static void moveObject( int x, int y)
	{
	 
	    // Edge Cases
	    if (head == null || head.next == null
	        || x == y)
	        return;
	 
	    // Finding the Nodes
	    pair p = find( x, y);
	 
	    Node Node1 = p.first;
	    Node Node2 = p.second;
	 
	    if (Node1 == head)
	        head = Node1.next;
		if (Node2 == tail)
	        tail = Node2.prev;
	 
	    // Moving Nodes
	    Node temp;
	    if (Node1.prev != null && Node2.prev != null) {
	    	Node1.prev.next = Node1.next;
	    	Node1.next = Node2.next;
		    Node2.next = Node1;
	    }else if(Node2.prev == null) {	    	
	    	Node1.prev.next = Node1.next;
	    	temp = head;
	    	Node1.next = temp;
	    	head = Node1;	    	
	    }else {
	    	temp = Node2.next;
	    	Node2.next = Node1;
	    	Node1.next = temp;
	    }
	    
	}
	 
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		try {
			head = null;
		    tail = null;
		 
		    push("DOG");
		    push("CAT");
		    push("MOUSE");
		    push("HORSE");
		    push("BIRD");
		 
		    System.out.print("Before Movement: ");
		    print(head);
		    
		    BufferedReader bfn = new BufferedReader(
		            new InputStreamReader(System.in));
		    
		    System.out.println("Entered existing position : ");
		    int existingPosition = Integer.parseInt(bfn.readLine());	    
		    
		    System.out.println("Entered new position : ");
		    int newPosition = Integer.parseInt(bfn.readLine());
		    	    

		    moveObject( existingPosition, newPosition);
		    System.out.print("After Movement: ");
		    print(head);
		} catch (Exception e) {
			System.out.println("Invalid Entries");
		}
	 	    
	}

}
