package HW_3;

public abstract class AList2 implements EList {


	private int[] arr = new int[100];
	private int start=0;
	private int end=arr.length;
	private int middle=arr.length/2;

	@Override
	public int size()
	{
		return end-start;
	}

	@Override
	public void init(int[] ini)
	{
		if(ini == null)
		{
			ini = new int[0];
			start=end=0;
		}
		
		if (ini.length>arr.length) resize((int)(ini.length*1.3));
		start=middle-ini.length/2;
		end=start+ini.length;
		for (int i = start; i < end; i++) 
		{
			arr[i] = ini[i-start];
		}
		
	}

	@Override
	public void clear()
	{
		init(null);
	}

	@Override
	public int[] toArray() 
	{
		int[] tmp = new int[end-start];
		for (int i = start; i < end; i++) 
		{
			tmp[i-start] = arr[i];
		}
		return tmp;
	}

	@Override
	public int get(int pos) 
	{	
		int realPos=start+pos;
		
		if(size() == 0||realPos<start||realPos>end)
			throw new IllegalArgumentException();
		return arr[realPos];
	}

	@Override
	public void set(int pos, int val) 
	{
		int realPos=start+pos;
		
		if(size() == 0||realPos<start||realPos>end)
			throw new IllegalArgumentException();
		arr[realPos] = val;
	}

	@Override
	public void addStart(int val)
	{
		if (start==0) resize();
		start--;
		arr[start]=val;
	}

	@Override
	public void addEnd(int val)
	{	
		if (end==arr.length) resize();
		end++;
		arr[end-1]=val;
	}

	@Override
	public void addPos(int pos, int val)
	{
		if (start+pos>end)
			throw new IllegalArgumentException();
		if (end==arr.length) resize();
		for (int i = end; i > pos+start; i--) 
		{
			arr[i] = arr[i-1];
		}
		arr[pos+start] = val;
		end++;
	}

	@Override
	public int delStart()
	{
		if(size() == 0)
			throw new IllegalArgumentException();

		int ret = arr[0];
		arr[start]=0;
		start++;
		return ret;
	}

	@Override
	public int delEnd()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		end--;
		int ret = arr[end];
		arr[end]=0;
		return ret;
	}

	@Override
	public int delPos(int pos)
	{
		int realPos=pos+start;
		if(size() == 0||realPos<start||pos>end)
			throw new IllegalArgumentException();
		int ret = arr[realPos];

		for(int i=realPos;i<end;i++)
		{
			arr[i]=arr[i+1];
		}
		end--;
		return ret;
	}

	@Override
	public int min()
	{
		if(size()==0) 
			throw new IllegalArgumentException();
		int min = arr[start];
		for (int i=start; i < end; i++)
		{
			if (arr[i] < min)
			{
				min = arr[i];
			}
		}
		return min;
	}

	@Override
	public int max()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		int max = arr[start];
		for (int i = start; i < end; i++)
		{
			if (arr[i] > max)
			{
				max = arr[i];
			}
		}
		return max;
	}

	@Override
	public int minInd()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		int min = start;
		for (int i=start; i < end ; i++)
		{
			if (arr[min] > arr[i])
			{
				min = i;
			}
			
		}
		return min-start;
	}

	@Override
	public int maxInd()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		int max = 0;
		for (int i=start; i < end; i++)
		{
			if (arr[max] < arr[i])
			{
				max = i;
			}
		}
		return max-start;
	}

	@Override
	public void sort()
	{
		for(int i = end-1 ; i > 0 ; i--)
		{
			for(int j = start ; j < i ; j++)
			{
				if( arr[j] > arr[j+1] )
				{
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}

	@Override
	public void reverse()
	{
		int first=start;
		int last=end-1;
		while(last>first)
		{
			int tmp = arr[first];
			arr[first] = arr[last];
			arr[last] = tmp;
			first++;
			last--;
		}
	}

	@Override
	public void halfReverse()
	{	
		int d = (size()%2==0)?0:1;
		int first=start;
		int last=(start+end)/2+d;
		while(last<end)
		{
			int tmp=arr[first];
			arr[first]=arr[last];
			arr[last]=tmp;
			first++;
			last++;
		}
	}
	
	private void resize()
	{		
		int newSize=arr.length+arr.length/3;
		middle=newSize/2;
		int[] tmp=new int[newSize];
		int j=(tmp.length-arr.length)/2;
		
		for(int i=start; i<end;i++, j++)
		{
			tmp[j]=arr[i];
		}
		start=(tmp.length-arr.length)/2;
		end=j;
		arr=tmp;
	}
	
	private void resize(int newSize)
	{
		int[] tmp=new int[newSize];
		for(int i=0; i<arr.length;i++)
		{
			tmp[i]=arr[i];
		}
		arr=tmp;
		middle=arr.length/2;
	}

	public void printArray()
	{
		if(arr==null) throw new IllegalArgumentException();
		for(int i=0;i<arr.length;i++)
		{
			System.out.print("["+arr[i]+"] ");
		}
		System.out.println();
	}
}