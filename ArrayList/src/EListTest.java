import static org.junit.Assert.*;

import org.junit.Test;

	public class EListTest 
	{
		EList rr = new AList0();
		//EList rr = new AList1();
		//EList rr = new AList2();
		
		//=====================================
		// size, init, toArray
		//=====================================
		@Test
		public void testSize_null() 
		{
			
			int[] ini = null;
			rr.init(ini);
			assertEquals(0, rr.size());
			int[] exp = {};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testSize_0() 
		{
			
			int[] ini = {};
			rr.init(ini);
			assertEquals(0, rr.size());
			int[] exp = {};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testSize_1() 
		{
			
			int[] ini = {10};
			rr.init(ini);
			assertEquals(1, rr.size());
			int[] exp = {10};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testSize_2() 
		{
			
			int[] ini = {10,20};
			rr.init(ini);
			assertEquals(2, rr.size());
			int[] exp = {10,20};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testSize_many() 
		{
			
			int[] ini = {10,20,33,77,11,24,19};
			rr.init(ini);
			assertEquals(7, rr.size());
			int[] exp = {10,20,33,77,11,24,19};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}

		//=====================================
		// clear
		//=====================================


		@Test
		public void testClear() {
			fail("Not yet implemented");
		}

		@Test
		public void testGet() {
			fail("Not yet implemented");
		}

		@Test
		public void testSet() {
			fail("Not yet implemented");
		}

		//=====================================
		// addStart
		//=====================================
		@Test
		public void testAddStart() 
		{
			
			int[] ini = {};
			rr.init(ini);
			rr.addStart(99);
			assertEquals(1, rr.size());
			assertEquals(99, rr.get(0));
			int[] exp = {99};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testAddStart_1() 
		{
			
			int[] ini = {10};
			rr.init(ini);
			rr.addStart(99);
			assertEquals(2, rr.size());
			assertEquals(99, rr.get(0));
			int[] exp = {99,10};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testAddStart_2() 
		{
			
			int[] ini = {10,20};
			rr.init(ini);
			rr.addStart(99);
			assertEquals(3, rr.size());
			assertEquals(99, rr.get(0));
			int[] exp = {99,10,20};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testAddStart_many() 
		{
			
			int[] ini = {10,20,33,77,11,24,19};
			rr.init(ini);
			rr.addStart(99);
			assertEquals(8, rr.size());
			assertEquals(99, rr.get(0));
			int[] exp = {99,10,20,33,77,11,24,19};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}

		@Test
		public void testAddEnd() {
			fail("Not yet implemented");
		}

		@Test
		public void testAddPos() {
			fail("Not yet implemented");
		}
		//=====================================
		// delStart
		//=====================================
		@Test (expected = ListIsEmptyException.class)
		public void testDelStart_0()
		{
			
			int[] ini = {};
			rr.init(ini);
			rr.delStart();
		}
		@Test
		public void testDelStart_1()
		{
			
			int[] ini = {10};
			rr.init(ini);
			rr.delStart();
			assertEquals(0, rr.size());
			int[] exp = {};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);		
		}
		@Test
		public void testDelStar_2()
		{
			
			int[] ini = {10,20};
			rr.init(ini);
			rr.delStart();
			assertEquals(1, rr.size());
			int[] exp = {20};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);		
		}
		@Test
		public void testDelStart_many()
		{
			
			int[] ini = {10,20,33,77,11,24,19};
			rr.init(ini);
			rr.delStart();
			assertEquals(6, rr.size());
			int[] exp = {20,33,77,11,24,19};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);		
		}

		@Test
		public void testDelEnd() {
			fail("Not yet implemented");
		}

		@Test
		public void testDelPos() {
			fail("Not yet implemented");
		}

		@Test
		public void testMin() {
			fail("Not yet implemented");
		}

		@Test
		public void testMax() {
			fail("Not yet implemented");
		}

		@Test
		public void testMinInd() {
			fail("Not yet implemented");
		}

		@Test
		public void testMaxInd() {
			fail("Not yet implemented");
		}

		//=====================================
		// sort
		//=====================================
		@Test
		public void testSort_0() 
		{
			
			int[] ini = {};
			rr.init(ini);
			rr.sort();
			int[] exp = {};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testSort_1() 
		{
			
			int[] ini = {10};
			rr.init(ini);
			rr.sort();
			int[] exp = {10};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testSort_2() 
		{
			
			int[] ini = {77,11};
			rr.init(ini);
			rr.sort();
			int[] exp = {11,77};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testSort_many() 
		{
			
			int[] ini = {10,20,33,77,11,24,19};
			rr.init(ini);
			rr.sort();
			int[] exp = {10,11,19,20,24,33,77};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}

		//=====================================
		// reverse
		//=====================================
		@Test
		public void testReverse_0() 
		{
			
			int[] ini = {};
			rr.init(ini);
			rr.reverse();
			int[] exp = {};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testReverse_1() 
		{
			
			int[] ini = {10};
			rr.init(ini);
			rr.reverse();
			int[] exp = {10};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testReverse_2() 
		{
			
			int[] ini = {10,20};
			rr.init(ini);
			rr.reverse();
			int[] exp = {20,10};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testReverse_many() 
		{
			
			int[] ini = {10,20,33,77,11,24,19};
			rr.init(ini);
			rr.reverse();
			int[] exp = {19,24,11,77,33,20,10};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}

		//=====================================
		// halfReverse
		//=====================================
		@Test
		public void testHalfReverse_0() 
		{
			
			int[] ini = {};
			rr.init(ini);
			rr.halfReverse();
			int[] exp = {};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testHalfReverse_1() 
		{
			
			int[] ini = {10};
			rr.init(ini);
			rr.halfReverse();
			int[] exp = {10};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}
		@Test
		public void testHalfReverse_2() 
		{
			
			int[] ini = {10,20};
			rr.init(ini);
			rr.halfReverse();
			int[] exp = {20,10};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}

		@Test
		public void testHalfReverse_many_even() 
		{
			
			int[] ini = {10,20,33,11,24,19};
			rr.init(ini);
			rr.halfReverse();
			int[] exp = {11,24,19,10,20,33};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}

		@Test
		public void testHalfReverse_many_odd() 
		{
			
			int[] ini = {10,20,33,77,11,24,19};
			rr.init(ini);
			rr.halfReverse();
			int[] exp = {11,24,19,77,10,20,33};
			int[] act = rr.toArray();
			assertArrayEquals(exp, act);
		}

	}
