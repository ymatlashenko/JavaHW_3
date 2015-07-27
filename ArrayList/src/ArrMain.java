
public class ArrMain {

	public static void main(String[] args) {
		{
			int[] rr = {10,30,54,77,11,22,99,3};
			AList0 pp = new AList0();
			pp.init( rr );
			int res = pp.min();
			System.out.println(res);
			pp.print();
			pp.addEnd(108);
			pp.print();
			pp.addStart(109);
			pp.print();
			pp.addPos(4, 66);
			pp.print();
			pp.delEnd(109);
			pp.print();
			pp.delStart(109);
			pp.print();
			pp.delPos(4, 77);
			pp.print();
			pp.sort(res);
		}
	
	}

}
