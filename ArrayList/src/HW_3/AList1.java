package HW_3;
public  class AList1 implements EList 
{

	private int[] arr = new int[10];
	private int index=0;
	@Override
	public int size()
	{
		return index;
	}
	// ==============================================
	// init
	// ==============================================
	@Override
	public void init(int[] ini)
	{
		if(ini == null)
		{
			ini = new int[0];
			index=0;
		}
		index=ini.length;
		if (index>arr.length) resize((int)(index*1.3));
		for (int i = 0; i < ini.length; i++) 
		{
			arr[i] = ini[i];
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
		int[] tmp = new int[index];
		for (int i = 0; i < index; i++) 
		{
			tmp[i] = arr[i];
		}
		return tmp;
	}

	@Override
	public int get(int pos) 
	{
		if(size() == 0||pos<0||pos>index-1)
			throw new ListIsEmptyException();
		return arr[pos];
	}

	@Override
	public void set(int pos, int val) 
	{
		if(size() == 0||pos<0||pos>index-1)
			throw new ListIsEmptyException();
		arr[pos] = val;
	}

	@Override
	public void addStart(int val)
	{
		if (index>arr.length-1) resize(val);
		for (int i = index; i > 0; i--) 
		{
			arr[i] = arr[i-1];
		}
		arr[0]=val;
		index++;
	}

	@Override
	public void addEnd(int val)
	{	
		if (index>arr.length) resize(val);
		arr[index] = val;
		index++;
	}

	@Override
	public void addPos(int pos, int val)
	{
		if (pos>index)
			throw new ListIsEmptyException();
		if (index>arr.length-1) resize(val);
		for (int i = index; i > pos; i--) 
		{
			arr[i] = arr[i-1];
		}
		arr[pos] = val;
		index++;
	}

	@Override
	public int delStart()
	{
		if(size() == 0)
			throw new ListIsEmptyException();

		int ret = arr[0];
		for (int i = 0; i < index; i++) 
		{
			arr[i] = arr[i+1];
		}
		index--;
		return ret;
	}

	@Override
	public int delEnd()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		index--;
		int ret = arr[index];
		arr[index]=0;
		return ret;
	}

	@Override
	public int delPos(int pos)
	{
		if(size() == 0||pos<0||pos>index-1)
			throw new ListIsEmptyException();
		int ret = arr[pos];

		for(int i=pos;i<index;i++)
		{
			arr[i]=arr[i+1];
		}
		index--;
		return ret;
	}

	@Override
	public int min()
	{
		if(index==0) 
			throw new ListIsEmptyException();
		int min = arr[0];
		for (int i=0; i < index; i++)
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
			throw new ListIsEmptyException();
		int max = arr[0];
		for (int i = 0; i < index; i++)
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
			throw new ListIsEmptyException();
		int min = 0;
		for (int i=0; i < index ; i++)
		{
			System.out.println("index="+index+", i="+i);
			System.out.println("arr[i]="+arr[i]+", arr[min]="+arr[min]);
			if (arr[min] > arr[i])
			{
				min = i;
			}
			
		}
		System.out.println("min="+min);
		return min;
	}

	@Override
	public int maxInd()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		int max = 0;
		for (int i=0; i < index; i++)
		{
			if (arr[max] < arr[i])
			{
				max = i;
			}
		}
		return max;
	}

	@Override
	public void sort()
	{
		for(int i = index-1 ; i > 0 ; i--)
		{
			for(int j = 0 ; j < i ; j++)
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
		for (int i=0; i < index/2; i++)
		{
			int tmp = arr[i];
			arr[i] = arr[index-1-i];
			arr[index-1-i] = tmp;
		}
	}

	@Override
	public void halfReverse()
	{	
		int d = (index%2==0)?0:1;
		for (int i=0; i < (index)/2; i++)
		{
			int tmp = arr[i];
			arr[i] = arr[index/2+d+i];
			arr[index/2+d+i] = tmp;
		}
	}
	
	
	
	private void resize(int newSize)
	{
		int[] tmp=new int[newSize];
		for(int i=0; i<arr.length;i++)
		{
			tmp[i]=arr[i];
		}
		arr=tmp;
	}

	}