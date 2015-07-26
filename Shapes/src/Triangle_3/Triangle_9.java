package Triangle_3;

public class Triangle_9 {

	public static void main(String[] args)
	{
		for (int i = 3; i < 7; i++) 
		{
			for (int j = 0; j < 7; j++) 
			{
				if (i ==6 || i ==6-j || i == j)
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
