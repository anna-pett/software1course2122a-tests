
public class StringUtilsTestNoJunit {
	
public static void testFindSortedSequence() {
		
		System.out.println("".equals(StringUtils.findSortedSequence("")));
		System.out.println("".equals(StringUtils.findSortedSequence("   ")));
		
//		findSortedSequence (“to be or not to be”) -> "not to"
		System.out.println("not to".equals(StringUtils.findSortedSequence("to be or not to be")));
		
//		findSortedSequence ("my mind is an empty zoo”) -> "an empty zoo"
		System.out.println("an empty zoo".equals(StringUtils.findSortedSequence("my mind is an empty zoo")));
		
//		findSortedSequence ("") -> ""
		System.out.println("".equals(StringUtils.findSortedSequence("")));
		
//		findSortedSequence ("andy bought candy") -> "andy bought candy"
		System.out.println("andy bought candy".equals(StringUtils.findSortedSequence("andy bought candy")));
		
//		findSortedSequence ("life is not not not fair") -> "is not not not"
		System.out.println("is not not not".equals(StringUtils.findSortedSequence("life is not not not fair")));
		
//		findSortedSequence ("art act") -> "act"
		System.out.println("act".equals(StringUtils.findSortedSequence("art act")));
	}


	public static void testIsEditDistanceOne() {
		
		System.out.println(false == StringUtils.isEditDistanceOne(null, ""));
		System.out.println(false == StringUtils.isEditDistanceOne("", null));
		System.out.println(false == StringUtils.isEditDistanceOne(null, null));
		System.out.println(true == StringUtils.isEditDistanceOne("", ""));
		
//		isEditDistanceOne ("dog","god") -> false
		System.out.println(false == StringUtils.isEditDistanceOne("dog","god"));
		
//		isEditDistanceOne ("x","x") -> true
		System.out.println(true == StringUtils.isEditDistanceOne("x", "x"));
		
//		isEditDistanceOne ("main","man") -> true
		System.out.println(true == StringUtils.isEditDistanceOne("main","man"));
		
//		isEditDistanceOne ("ab","cab") -> true
		System.out.println(true == StringUtils.isEditDistanceOne("ab","cab"));
		
//		isEditDistanceOne ("car","cat") -> true
		System.out.println(true == StringUtils.isEditDistanceOne("car","cat"));
		
//		isEditDistanceOne ("ct","cat") -> true
		System.out.println(true == StringUtils.isEditDistanceOne("ct","cat"));
		
//		isEditDistanceOne ("cult","cat") -> true
		System.out.println(false == StringUtils.isEditDistanceOne("cult","cat"));
		
		
		System.out.println(true == StringUtils.isEditDistanceOne("ab","abb"));
		System.out.println(false == StringUtils.isEditDistanceOne("ab","abbb"));
		System.out.println(true == StringUtils.isEditDistanceOne("abb","ab"));
		System.out.println(false == StringUtils.isEditDistanceOne("abbb","ab"));
		
		System.out.println(false == StringUtils.isEditDistanceOne("cat","tac"));
	}

	public static void main(String[] args) {
		testFindSortedSequence();
		testIsEditDistanceOne();

	}

}
