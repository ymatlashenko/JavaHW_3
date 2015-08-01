package HW_3;
public abstract class AList0 implements EList
{
	private int[] arr = {};
	
	@Override
	public int size()
	{
		return arr.length;
	}
	
	@Override
	public void init(int[] ini)
	{
		if(ini == null)
		{
			ini = new int[0];
		}
		arr = new int[ini.length];
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
		int[] tmp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) 
		{
			tmp[i] = arr[i];
		}
		return tmp;
	}

	@Override
	public int get(int pos) 
	{
		return arr[pos];
	}

	@Override
	public void set(int pos, int val) 
	{
		arr[pos] = val;
	}
	

	@Override
	public void addStart(int val)
	{
		int[] tmp = new int[arr.length+1];
		tmp[0] = val;
		for (int i = 0; i < arr.length; i++) 
		{
			tmp[i+1] = arr[i];
		}
		arr = tmp;
	}
	
	@Override
	public void addEnd(int val)
	{
		int[] tmp = new int[arr.length+1];
		for (int i = 0; i < arr.length; i++) 
		{
			tmp[i] = arr[i];
		}
		tmp[arr.length] = val;
		arr = tmp;
	}
	
	@Override
	public void addPos(int pos, int val)
	{
		int[] tmp = new int[arr.length+1];
		for (int i = 0; i < pos; i++) 
		{
			tmp[i] = arr[i];
		}
		for (int i = pos; i < arr.length; i++) 
		{
			tmp[i+1] = arr[i];
		}
		tmp[pos] = val;
		arr = tmp;
	}
	
	@Override
	public int delStart()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		
		int ret = arr[0];
		int[] tmp = new int[arr.length-1];
		for (int i = 1; i < arr.length; i++) 
		{
			tmp[i-1] = arr[i];
		}
		arr = tmp;
		return ret;
	}
	
	@Override
	public int delEnd()
	{
		if(size() == 0)
			throw new ListIsEmptyException();
		
		int ret = arr[arr.length-1];
		int[] tmp = new int[arr.length-1];
		for (int i = 0; i < arr.length-1; i++) 
		{
			tmp[i] = arr[i];
		}
		arr = tmp;
		return ret;
	}
	
	@Override
	public int delPos(int pos)
	{
		int ret = arr[pos];
		int[] tmp = new int[arr.length-1];
		
		for (int i = 0; i < pos; i++) 
		{
			tmp[i] = arr[i];
		}
		for (int i = pos+1; i < arr.length; i++) 
		{
			tmp[i-1] = arr[i];
		}
		arr = tmp;
		return ret;
	}
	
	@Override
	public int min()
	{
		int min = arr[0];
		for (int i=0; i < arr.length; i++)
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
		int max = arr[0];
		for (int i = 0; i < arr.length; i++)
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
		int min = 0;
		for (int i=0; i < arr.length; i++)
		{
			if (arr[min] > arr[i])
			{
				min = i;
			}
		}
		return min;
	}
	
	@Override
	public int maxInd()
	{
		int max = 0;
		for (int i=0; i < arr.length; i++)
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
	    for(int i = arr.length-1 ; i > 0 ; i--)
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
		for (int i=0; i < arr.length/2; i++)
		{
			int tmp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = tmp;
		}
	}
	
	@Override
	public void halfReverse()
	{	
		int d = (arr.length%2==0)?0:1;
		for (int i=0; i < (arr.length)/2; i++)
		{
			int tmp = arr[i];
			arr[i] = arr[(arr.length)/2+d+i];
			arr[(arr.length)/2+d+i] = tmp;
		}
	}
}
