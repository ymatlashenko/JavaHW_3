
public class AList0 {

		private static int[] ar = {};
		private int[] tmp;
		
		public void init(int[] ini)
		{
			ar = new int[ini.length];
			for (int i = 0; i < ini.length; i++) 
			{
				ar[i] = ini[i];
			}
		}
		
		public void addEnd(int val)
		{
			int[] tmp = new int[ar.length+1];
			for (int i = 0; i < ar.length; i++) 
			{
				tmp[i] = ar[i];
			}
			tmp[ar.length] = val;
			ar = tmp;
		}
		
		public int min()
		{
			if (ar.length == 0)
				throw new IllegalArgumentException();
			
			int min = ar[0];
			//for (int i : ar)
			for(int i=0; i < ar.length; i++)
			{
				if (ar[i] < min)
				{
					min = ar[i];
				}
			}
			return min;
		}
		public void addStart(int val)

		{
			int[] tmp = new int[ar.length+1];
			for (int i = 0; i < ar.length; i++) 
			{
				tmp[i+1] = ar[i];
			}
			tmp[0] = val;
			ar = tmp;
		}
		public void addPos(int pos, int val)

		{
			int[] tmp = new int[ar.length+1];
			for (int i = 0; i < pos;  i++) 
		
				tmp[i] = ar[i];
		
			tmp[pos] = val;
			for(int i= pos + 1; i < tmp.length; i++)
			tmp[i]= ar[i - 1];
			ar = tmp;
		}
		public void delEnd(int val)

		{
			int[] tmp = new int[ar.length-1];
			for (int i = 0; i < ar.length-1; i++) 
			{
				tmp[i] = ar[i];
			}
			tmp[0] = val;
			ar = tmp;
		}
		public void delStart(int val)

		{
			int[] tmp = new int[ar.length-1];
			for (int i = 0; i < ar.length-1; i++) 
			{
				tmp[i] = ar[i+1];
			}
			ar = tmp;
		}
		public void delPos(int pos, int val)

		{
			int[] tmp = new int[ar.length-1];
			for (int i = 0; i < pos;  i++) 
		
				tmp[i] = ar[i];			
			for(int i= pos; i < tmp.length; i++)
			tmp[i]= ar[i+1];
			ar = tmp;
		}
		public void sort (int j)

		{

		}
		public void print() 
		{
			for (int i = 0; i < ar.length; i++) 
			{
				System.out.print(ar[i] + " ");
			}
			System.out.println();
		}

		
		
	
}