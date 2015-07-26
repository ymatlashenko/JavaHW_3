package Triangle_3;

public class Triangle_8 {
	public static void main(String[] args)
	{
		for (int i = 0; i < 4; i++) 
		{
			for (int j = 0; j < 7; j++) 
			{
				if (i ==0 || i ==6-j || i == j)
				{
					System.out.print("*");	
				}
				else 
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
