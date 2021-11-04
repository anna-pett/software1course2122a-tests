
import static org.junit.Assert.*;

import org.junit.Test;


public class StringUtilsTest {

	@Test
	public void testFindSortedSequence() {
		
//		assuming correct input
		
		assertEquals("", StringUtils.findSortedSequence(""));
		assertEquals("", StringUtils.findSortedSequence("   "));
		
//		findSortedSequence ("to be or not to be") -> "not to"
		assertEquals("not to", StringUtils.findSortedSequence("to be or not to be"));
		
//		findSortedSequence ("my mind is an empty zoo") -> "an empty zoo"
		assertEquals("an empty zoo", StringUtils.findSortedSequence("my mind is an empty zoo"));
		
//		findSortedSequence ("") -> ""
		assertEquals("", StringUtils.findSortedSequence(""));
		
//		findSortedSequence ("andy bought candy") -> "andy bought candy"
		assertEquals("andy bought candy", StringUtils.findSortedSequence("andy bought candy"));
		
//		findSortedSequence ("life is not not not fair") -> "is not not not"
		assertEquals("is not not not", StringUtils.findSortedSequence("life is not not not fair"));
		
//		findSortedSequence ("art act") -> "act"
		assertEquals("act", StringUtils.findSortedSequence("art act"));


		assertEquals("a b", StringUtils.findSortedSequence("   c d a b   "));
		assertEquals("c d e", StringUtils.findSortedSequence("   c d e a b   "));
		assertEquals("", StringUtils.findSortedSequence(""));
		assertEquals("", StringUtils.findSortedSequence("      "));
		assertEquals("z", StringUtils.findSortedSequence("   z   "));
		assertEquals("a", StringUtils.findSortedSequence("   z a   "));
		assertEquals("a b b c", StringUtils.findSortedSequence("   z a b b c a   "));
		assertEquals("b c", StringUtils.findSortedSequence("   z a bd b c a   "));
		assertEquals("a b bd c", StringUtils.findSortedSequence("   z a b bd c a   "));
	}

	@Test
	public void testIsEditDistanceOne() {
		
//		assuming correct input
		
//		assertEquals(false, StringUtils.isEditDistanceOne(null, ""));
//		assertEquals(false, StringUtils.isEditDistanceOne("", null));
//		assertEquals(false, StringUtils.isEditDistanceOne(null, null));
		assertEquals(true, StringUtils.isEditDistanceOne("", ""));
		
//		isEditDistanceOne ("dog","god") -> false
		assertEquals(false, StringUtils.isEditDistanceOne("dog","god"));
		
//		isEditDistanceOne ("x","x") -> true
		assertEquals(true, StringUtils.isEditDistanceOne("x", "x"));
		
//		isEditDistanceOne ("main","man") -> true
		assertEquals(true, StringUtils.isEditDistanceOne("main","man"));
		
//		isEditDistanceOne ("ab","cab") -> true
		assertEquals(true, StringUtils.isEditDistanceOne("ab","cab"));
		
//		isEditDistanceOne ("car","cat") -> true
		assertEquals(true, StringUtils.isEditDistanceOne("car","cat"));
		
//		isEditDistanceOne ("ct","cat") -> true
		assertEquals(true, StringUtils.isEditDistanceOne("ct","cat"));
		
//		isEditDistanceOne ("cult","cat") -> true
		assertEquals(false, StringUtils.isEditDistanceOne("cult","cat"));
		
		
		assertEquals(true, StringUtils.isEditDistanceOne("ab","abb"));
		assertEquals(false, StringUtils.isEditDistanceOne("ab","abbb"));
		assertEquals(true, StringUtils.isEditDistanceOne("abb","ab"));
		assertEquals(false, StringUtils.isEditDistanceOne("abbb","ab"));
		
		assertEquals(false, StringUtils.isEditDistanceOne("cat","tac"));
	}

}
