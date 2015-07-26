package Triangle_3;

public class Triangle_7 {
	public static void main(String[] args)
	{
		for (int i = 0; i < 7; i++) 
		{
			for (int j = 3; j < 7; j++) 
			{
				if (j ==6 || i ==6-j || i == j)
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
