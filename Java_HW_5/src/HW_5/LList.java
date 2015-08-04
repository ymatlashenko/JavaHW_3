package HW_5;



public class LList implements EList
{
	Node root=new Node();
	@Override
	public int size()
	{
		int count=0;
		if(root.getNext()==null) count=0;

		else
		{
			Node node=new Node();
			node.setNext(root.getNext());
		
			do
			{
				node=node.getNext();
				count++;
			}while(node.getNext()!=null);
		}
		return count;
	}

	@Override
	public void init(int[] ini)
	{	
		if(ini==null||ini.length==0)
		{
			root.setNext(null);
		}

		else
		{
			root.setNext(new Node());

			Node next=root.getNext();
			next.setData(ini[0]);
			for(int i=1;i<ini.length;i++)
			{
				Node tempNext=next;
				next=new Node();
				next.setData(ini[i]);
				tempNext.setNext(next);
			}
		}
	}

	public void clear()
	{
		root.setNext(null);;
	}

	@Override
	public int[] toArray() 
	{
		Node node=new Node();
		node.setNext(root.getNext());
		int[] tmp = new int[size()];
		for (int i = 0; i < tmp.length; i++) 
		{
			node=node.getNext();
			//System.out.println("data="+node.getData());
			tmp[i] = node.getData();
		}
		return tmp;
	}

	@Override
	public int get(int pos) 
	{
		if(size() == 0||pos<0||pos>size())
			throw new ListIsEmptyException();
		int i=-1;
		Node node=new Node();
		node.setNext(root.getNext());
		do
		{
			i++;
			node=node.getNext();
		}while(i!=pos);

		return node.getData();
	}

	@Override
	public void set(int pos, int val) 
	{
		if(size() == 0||pos<0||pos>size())
			throw new ListIsEmptyException();
		int i=-1;
		Node node=new Node();
		node.setNext(root.getNext());
		do
		{
			i++;
			node=node.getNext();
		}while(i<pos);
		node.setData(val);
	}

	@Override
	public void addStart(int val)
	{
		Node node=new Node();
		if (root.getNext()==null) 
			root.setNext(node); 
		else
		{
			node.setNext(root.getNext());
			root.setNext(node);
		}
		node.setData(val);
	}

	@Override
	public void addEnd(int val)
	{
		Node node=new Node();
		Node newNode=new Node();
		if (root.getNext()==null)
		{
			root.setNext(node);
			node.setData(val);
		}
		else
		{
			node.setNext(root.getNext());
			int i=-1;
			do
			{
				i++;
				node=node.getNext();
			}while(i<size()-1);
			newNode.setNext(node.getNext());
			node.setNext(newNode);
			newNode.setData(val);
		}
	}

	@Override
	public void addPos(int pos, int val)
	{
		if(pos<0||pos>size())
			throw new ListIsEmptyException();
		Node node=new Node();
		Node newNode=new Node();
		if (root.getNext()==null)
		{
			root.setNext(node);
			node.setData(val);
		}
		else
		{
			node.setNext(root.getNext());
			int i=-1;
			do
			{
				i++;
				node=node.getNext();
			}while(i<pos-1);
			newNode.setNext(node.getNext());
			node.setNext(newNode);
			newNode.setData(val);
		}
	}

	@Override
	public int delStart()
	{		
		if(size() == 0)
			throw new ListIsEmptyException();

		int ret = root.getNext().getData();
		root.setNext(root.getNext().getNext());
		return ret;
	}

	@Override
	public int delEnd()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		int ret=0;
		if(size()==1) 
		{
			ret=root.getNext().getData();	
			root.setNext(null);
		}
		else
		{
			Node node=new Node();
			node.setNext(root.getNext());
			int i=-1;
			do
			{
				i++;
				node=node.getNext();
			}while(i<size()-2);
			ret = node.getNext().getData();
			node.setNext(null);
		}
		return ret;
	}

	@Override
	public int delPos(int pos)
	{
		if(size()==0||pos<0||pos>size())
			throw new ListIsEmptyException();
		int ret=0;
		Node node=new Node();
		node.setNext(root.getNext());
		if(size()==1) 
		{
			ret=root.getNext().getData();	
			root.setNext(null);
		}
		else
		{
			int i=-1;
			do
			{
				i++;
				node=node.getNext();
			}while(i<pos-1);
			ret=node.getNext().getData();
			if(size()==2) 
			{
				root.setNext(node.getNext());
			}
			else
			{
				node.setNext(node.getNext().getNext());	
			}

		}
		return ret;
	}

	@Override
	public int min()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		int min = root.getNext().getData();
		Node node=new Node();
		node.setNext(root.getNext());
		do
		{
			node=node.getNext();
			if (node.getData()<min) min=node.getData();
		}while(node.getNext()!=null);
		return min;
	}

	@Override
	public int max()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		int max = root.getNext().getData();
		Node node=new Node();
		node.setNext(root.getNext());
		do
		{
			node=node.getNext();
			if (node.getData()>max) max=node.getData();
		}while(node.getNext()!=null);
		return max;
	}

	@Override
	public int minInd()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		Node node=new Node();
		node.setNext(root.getNext());
		int min = root.getNext().getData();
		int minInd=0;
		int i=-1;
		do
		{
			i++;
			node=node.getNext();
			if (node.getData()<min)
			{
				minInd=i;
				min=node.getData();
			}
		}while(node.getNext()!=null);
		return minInd;
	}

	@Override
	public int maxInd()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		Node node=new Node();
		node.setNext(root.getNext());
		int max = root.getNext().getData();
		int maxInd=0;
		int i=-1;
		do
		{
			i++;
			node=node.getNext();
			if (node.getData()>max)
			{
				maxInd=i;
				max=node.getData();
			}
		}while(node.getNext()!=null);
		return maxInd;
	}

	@Override
	public void sort()
	{
		Node nodeA=new Node();
		Node nodeB=new Node();

		nodeA.setNext(root.getNext());

		for(int i=0;i<size()-1;i++)
		{
			nodeA=nodeA.getNext();	
			nodeB=nodeA.getNext();
			for(int j=i+1;j<size();j++)
			{
				if (nodeA.getData()>nodeB.getData())
				{
					int temp=nodeA.getData();
					nodeA.setData(nodeB.getData());
					nodeB.setData(temp);
				}
				nodeB=nodeB.getNext();
			}
		}
	}

	@Override
	public void reverse()
	{
		Node nodeA=new Node();
		Node nodeB=new Node();

		nodeA.setNext(root.getNext());
		int temp=0;
		for(int i=0;i<size()/2;i++)
		{
			nodeA=nodeA.getNext();	
			nodeB=nodeA.getNext();
			for(int j=i;j<(size()-i-2);j++)
			{
				nodeB=nodeB.getNext();
			}
			temp=nodeA.getData();
			nodeA.setData(nodeB.getData());
			nodeB.setData(temp);
		}
	}

	@Override
	public void halfReverse()
	{	
		int d = (size()%2==0)?0:1;
		Node nodeA=new Node();
		Node nodeB=new Node();

		nodeA.setNext(root.getNext());
		int temp=0;
		for(int i=0;i<size()/2;i++)
		{
			nodeA=nodeA.getNext();	
			nodeB=root.getNext();
			size();
			for(int j=0; j<size()/2+d+i;j++)
			{
				nodeB=nodeB.getNext();
			}
			temp=nodeA.getData();
			nodeA.setData(nodeB.getData());
			nodeB.setData(temp);	
		}
	}

	@Override
	public void addStart(int[] val) {
		// TODO Auto-generated method stub
		
	}

}
