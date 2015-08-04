package HW_5;

public class Node
{

	private int data;
	private Node next;

	public int getData() 
	{	
		int temp=data;
		return temp;
	}
	public void setData(int data) 
	{
		this.data = data;
	}
	public Node getNext() 
	{
		return next;
	}
	public void setNext(Node next) 
	{
		this.next = next;
	}
	
}


