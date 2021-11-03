
import static org.junit.Assert.*;

import org.junit.Test;


public class ArrayUtilsTest {

	@Test
	public void testShiftArrayCyclic() {

//		shiftArrayCyclic([1, 2, 3, 4, 5],-1, 'R') -> [2,3,4,5,1]
		int[] arr = {1, 2, 3, 4, 5};
		int[] result = ArrayUtils.shiftArrayCyclic(arr, -1, 'R');
		assertTrue(result == arr);	// returned array points to the same memory address as arr
		assertArrayEquals(new int[]{2, 3, 4, 5, 1}, result);
		
		
//		shiftArrayCyclic([1, 2, 3, 4, 5], 1, 'R') -> [5,1,2,3,4]
		arr = new int[]{1, 2, 3, 4, 5};
		result = ArrayUtils.shiftArrayCyclic(arr, 1, 'R');
		assertTrue(result == arr);	// returned array points to the same memory address as arr
		assertArrayEquals(new int[]{5, 1, 2, 3, 4}, result);
		
//		shiftArrayCyclic([1, 2, 3, 4, 5], 1, 'r') -> [1,2,3,4,5]
		arr = new int[]{1, 2, 3, 4, 5};
		result = ArrayUtils.shiftArrayCyclic(arr, 1, 'r');
		assertTrue(result == arr);	// returned array points to the same memory address as arr
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result);
		
//		shiftArrayCyclic([1, 2, 3, 4, 5], -2, 'g') -> [1,2,3,4,5]
		arr = new int[]{1, 2, 3, 4, 5};
		result = ArrayUtils.shiftArrayCyclic(arr, -2, 'g');
		assertTrue(result == arr);	// returned array points to the same memory address as arr
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result);
		
//		shiftArrayCyclic([1, 2, 3, 4, 5],3, 'L') -> [4,5,1,2,3]
		arr = new int[]{1, 2, 3, 4, 5};
		result = ArrayUtils.shiftArrayCyclic(arr, 3, 'L');
		assertTrue(result == arr);	// returned array points to the same memory address as arr
		assertArrayEquals(new int[]{4, 5, 1, 2, 3}, result);
		
//		shiftArrayCyclic([1, 2, 3, 4, 5],-3, 'L') -> [3,4,5,1,2]
		arr = new int[]{1, 2, 3, 4, 5};
		result = ArrayUtils.shiftArrayCyclic(arr, -3, 'L');
		assertTrue(result == arr);	// returned array points to the same memory address as arr
		assertArrayEquals(new int[]{3, 4, 5, 1, 2}, result);
		
//		shiftArrayCyclic([0, 8, 9, 5, 6],6, 'L') -> [8, 9, 5, 6,0]
		arr = new int[]{0, 8, 9, 5, 6};
		result = ArrayUtils.shiftArrayCyclic(arr, 6, 'L');
		assertTrue(result == arr);	// returned array points to the same memory address as arr
		assertArrayEquals(new int[]{8, 9, 5, 6, 0}, result);
		
//		shiftArrayCyclic([],3, 'R') -> []
		arr = new int[]{};
		result = ArrayUtils.shiftArrayCyclic(arr, 3, 'R');
		assertTrue(result == arr);	// returned array points to the same memory address as arr
		assertArrayEquals(new int[]{}, result);
		
//		shiftArrayCyclic([1],3, 'R') -> [1]
		arr = new int[]{1};
		result = ArrayUtils.shiftArrayCyclic(arr, 3, 'R');
		assertTrue(result == arr);	// returned array points to the same memory address as arr
		assertArrayEquals(new int[]{1}, result);
		
	}

	@Test
	public void testFindShortestPath() {
		
//		findShortestPath([[0,0,0],[0,0,0],[0,0,0]],0,1) -> -1
		int[][] adjMatrix = new int[][]{{0,0,0}, {0,0,0}, {0,0,0}};
		assertEquals(-1, ArrayUtils.findShortestPath(adjMatrix, 0, 1));
		
//		findShortestPath([[0,0,0],[0,0,0],[0,0,0]],1,1) -> 0
		adjMatrix = new int[][]{{0,0,0}, {0,0,0}, {0,0,0}};
		assertEquals(0, ArrayUtils.findShortestPath(adjMatrix, 1, 1));
		
//		findShortestPath([[0,1,0,0],[0,0,1,0],[0,0,0,1],[1,0,0,0]],0,2) -> 2
		adjMatrix = new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}};
		assertEquals(2, ArrayUtils.findShortestPath(adjMatrix, 0, 2));
		
//		findShortestPath([[0,1,0,1],[0,0,0,1],[0,0,0,0],[0,0,1,0]],0,2) -> 2
		adjMatrix = new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}};
		assertEquals(2, ArrayUtils.findShortestPath(adjMatrix, 0, 2));
		
//		findShortestPath([[0,1,0,0], [0,0,0,1], [0,0,0,0], [1,0,0,0]],0,2) -> 2
		adjMatrix = new int[][]{{0,1,0,0}, {0,0,0,1}, {0,0,0,0}, {1,0,1,0}};
		assertEquals(3, ArrayUtils.findShortestPath(adjMatrix, 0, 2));
		

		adjMatrix = new int[][]{{1,0,0}, {0,1,0}, {0,0,1}};
		assertEquals(0, ArrayUtils.findShortestPath(adjMatrix, 1, 1));
		
		
		adjMatrix = new int[][]{{0,0,1}, {1,0,0}, {0,1,1}};
		assertEquals(2, ArrayUtils.findShortestPath(adjMatrix, 2, 0));
		
		
		adjMatrix = new int[][]{{0,1,0,1,0,0,0,0},
								{0,0,1,0,0,0,0,0},
								{0,0,0,0,0,0,0,0},
								{0,0,0,0,1,0,0,1},
								{0,0,0,0,0,1,1,1},
								{0,0,0,0,0,0,1,0},
								{0,0,0,0,0,0,0,1},
								{0,0,0,0,0,0,0,0}};
		assertEquals(2, ArrayUtils.findShortestPath(adjMatrix, 0, 7));
		

		adjMatrix = new int[][]{{0,1,0,1,0,0,0,0},
								{0,0,1,0,0,0,0,0},
								{0,0,0,0,0,0,0,0},
								{0,0,0,0,1,0,0,1},
								{0,0,0,0,0,1,1,1},
								{0,0,0,0,0,0,1,0},
								{0,0,0,0,0,0,0,1},
								{0,0,0,0,0,0,0,0}};
		assertEquals(-1, ArrayUtils.findShortestPath(adjMatrix, 2, 4));
		

		adjMatrix = new int[][]{{0,1,0,1,0,0,0,0},
								{0,0,1,0,0,0,0,0},
								{0,0,0,0,0,0,0,0},
								{0,0,0,0,1,0,0,1},
								{0,0,0,0,0,1,1,1},
								{0,0,0,0,0,0,1,0},
								{0,0,0,0,0,0,0,1},
								{0,0,0,0,0,0,0,0}};
		assertEquals(1, ArrayUtils.findShortestPath(adjMatrix, 4, 7));
		

		adjMatrix = new int[][]{{0,0,0,1,0,0,0,0},
								{1,0,1,0,0,0,0,0},
								{0,0,0,0,0,0,0,0},
								{0,0,0,0,1,0,0,0},
								{0,0,0,0,0,1,0,0},
								{0,0,0,0,0,0,1,0},
								{0,0,0,0,1,0,0,1},
								{0,0,0,1,1,0,0,0}};
		assertEquals(4, ArrayUtils.findShortestPath(adjMatrix, 3, 7));
		
	}

}

