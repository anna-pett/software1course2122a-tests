package il.ac.tau.cs.sw1.ex5;


import java.io.IOException;
import java.util.Arrays;

/**
 * 
 * this is not an exhaustive tester and it does not pretend to cover all corner cases.
 * proceed with caution
 * 
 * updates/corrections/additions are welcome
 *
 */

public class BigramModelTester {
	public static final String ALL_YOU_NEED_FILENAME = "resources/hw5/all_you_need.txt";
	public static final String EMMA_FILENAME = "resources/hw5/emma.txt";
	public static final String ALL_YOU_NEED_MODEL_DIR = "resources/hw5/all_you_need_model";
	
	private static final String LEGAL_WORDS_TEST_FILENAME = "resources/hw5/legal_words_test.txt";
	private static final String WALRUS_FILENAME = "resources/hw5/walrus.txt";
	private static final String WALRUS_MODEL_DIR = "resources/hw5/walrus_model";
	private static final String CORNER_CASE0_FILENAME = "resources/hw5/corner_case0.txt";
	private static final String CORNER_CASE1_FILENAME = "resources/hw5/corner_case1.txt";
	private static final String CORNER_CASE2_FILENAME = "resources/hw5/corner_case2.txt";
	private static final String CORNER_CASE3_FILENAME = "resources/hw5/corner_case3.txt";
	private static final String CORNER_CASE4_FILENAME = "resources/hw5/corner_case4.txt";

	public static void main(String[] args) throws IOException{
		BigramModel sG = new BigramModel();
		
		String[] voc0 = sG.buildVocabularyIndex(LEGAL_WORDS_TEST_FILENAME);
		if (voc0.length != 8){
			System.out.println("Error 0.1");
//			System.out.println(Arrays.toString(voc0));
		}
		if (!Arrays.equals(voc0, new String[]{"word", "1words", "12w2", "12w", "w1", "w$", "6,k",
												BigramModel.SOME_NUM})){
			System.out.println("Error 0.2");
		}
		
		
		
		String[] voc = sG.buildVocabularyIndex(ALL_YOU_NEED_FILENAME);
		if (voc.length != 5){
			System.out.println("Error 1.1");
		}
		if (!Arrays.equals(voc, new String[]{"love", "all", "you", "need", "is"})){
			System.out.println("Error 1.2");
		}
		
		int[][] counts = sG.buildCountsArray(ALL_YOU_NEED_FILENAME, voc);
		if (counts[0][0] != 3){ //count of "love love"
			System.out.println("Error 2.1");
		}
		
		if (counts[1][2] != 3){ //count of "all you"
			System.out.println("Error 2.2");
		}
		
		sG.initModel(ALL_YOU_NEED_FILENAME);
		sG.saveModel(ALL_YOU_NEED_MODEL_DIR);
		sG.loadModel(ALL_YOU_NEED_MODEL_DIR);
		
		if (!Arrays.equals(sG.mVocabulary, new String[]{"love", "all", "you", "need", "is"})){
			System.out.println("Error 4.1");
		}
		
		if (sG.getWordIndex("love") != 0){
			System.out.println("Error 5.1");
		}
		
		if (sG.getWordIndex("you") != 2){
			System.out.println("Error 5.2");
		}
		
		if (sG.mBigramCounts[0][0] != 3){ //count of "love love"
			System.out.println("Error 6.1");
		}
		
		if (sG.mBigramCounts[1][2] != 3){ //count of "all you"
			System.out.println("Error 6.2");
		}
		
		if (sG.getBigramCount("is", "love") != 2){
			System.out.println("Error 6.3");
		}
		
		if (sG.getBigramCount("strawberry", "fields") != 0){
			System.out.println("Error 6.4");
		}
		if (!sG.getMostFrequentProceeding("is").equals("love")){
			System.out.println("Error 7.1");
		}
		
		if (!sG.isLegalSentence("love is all")){
			System.out.println("Error 8.1");
		}
		
		if (sG.isLegalSentence("love is is")){
			System.out.println("Error 8.2");
		}
		
		if (sG.isLegalSentence("love the beatles")){
			System.out.println("Error 8.3");
		}
		
		if (!sG.isLegalSentence("love all you")){
			System.out.println("Error 8.4");
		}
		
		if (!sG.isLegalSentence("")){
			System.out.println("Error 8.5");
		}
		
		if (!sG.isLegalSentence("all")){
			System.out.println("Error 8.6");
		}
		
		if (sG.isLegalSentence("garden")){
			System.out.println("Error 8.7");
		}
		
		if (BigramModel.calcCosineSim(new int[] {1,2,0,4, 2}, new int[] {5, 0, 3, 1, 1}) != 11./30){
			System.out.println("Error 9.1");
		}
		if (BigramModel.calcCosineSim(new int[] {0,0,0,0,0}, new int[] {0,0,0,0,0}) != -1){
			System.out.println("Error 9.2");
		}
		if (BigramModel.calcCosineSim(new int[] {1,0,0,0,0}, new int[] {0,0,0,0,0}) != -1){
			System.out.println("Error 9.3");
		}
		if (BigramModel.calcCosineSim(new int[] {0,0,0,0,0}, new int[] {1,0,0,0,0}) != -1){
			System.out.println("Error 9.4");
		}
		if (BigramModel.calcCosineSim(new int[] {-1,0,0,0,0}, new int[] {1,0,0,0,0}) != -1){
			System.out.println("Error 9.5");
		}
		if (BigramModel.calcCosineSim(new int[] {-1,0,0,0,0}, new int[] {2,0,0,0,0}) != -1){
			System.out.println("Error 9.6");
		}
		if (BigramModel.calcCosineSim(new int[] {1,0,0,0,0}, new int[] {0,1,0,0,0}) != 0){
			System.out.println("Error 9.7");
		}
//		if (sG.getWordCount("is") != 3){
//			System.out.println("Error 11.1");
//		}
//		if (sG.getWordCount("walrus") != 0){
//			System.out.println("Error 11.2");
//		}
		
		
		sG.initModel(EMMA_FILENAME);
	
	
		if (!sG.getClosestWord("good").equals("great")){
			System.out.println("Error 10.1");
		}
		
		if (!sG.getClosestWord("emma").equals("she")){
			System.out.println("Error 10.2");
		}
		
		if (!sG.isLegalSentence("she had played with very much pleasure in time"
									+ " and professed that she knew the oddest creature")){
			System.out.println("Error 10.3");
		}
		
		
		
		sG.initModel(WALRUS_FILENAME);
		sG.saveModel(WALRUS_MODEL_DIR);
		sG.loadModel(WALRUS_MODEL_DIR);
		if (sG.getWordIndex("garden") != BigramModel.ELEMENT_NOT_FOUND){
			System.out.println("Error walrus.0");
		}
		if (sG.getWordIndex("i am") != BigramModel.ELEMENT_NOT_FOUND){
			System.out.println("Error walrus.1");
		}
		if (sG.getWordIndex("me and") != BigramModel.ELEMENT_NOT_FOUND){
			System.out.println("Error walrus.2");
		}
		if (sG.getWordIndex("together") != 10){
			System.out.println("Error walrus.3");
		}
		if (sG.getWordIndex("they") != 13){
			System.out.println("Error walrus.4");
		}
		if (sG.getWordIndex("fly") != 20){
			System.out.println("Error walrus.5");
		}
		if (sG.getWordIndex("i'm") != 21){
			System.out.println("Error walrus.6");
		}
		if (sG.mBigramCounts[0][1] != 3){ //count of "I am"
			System.out.println("Error walrus.7");
		}
		if (sG.mBigramCounts[13][20] != 1){ //count of "they fly"
			System.out.println("Error walrus.8");
		}
		if (sG.getBigramCount("i", "am") != 3){ //count of "i am"
			System.out.println("Error walrus.9");
		}
		if (sG.getBigramCount("they", "fly") != 1){ //count of "they fly"
			System.out.println("Error walrus.10");
		}
		if (sG.getBigramCount("waiting ", "egg") != 0){ //count of "waiting egg"
			System.out.println("Error walrus.11");
		}
		if (sG.getBigramCount("walrus", "goo") != 0){ //count of "walrus goo"
			System.out.println("Error walrus.12");
		}
		if (sG.getBigramCount("am", "am") != 0){ //count of "am am"
			System.out.println("Error walrus.13");
		}
		if (sG.getBigramCount("english", "garden") != 0){ //count of "english garden"
			System.out.println("Error walrus.14");
		}
		if (sG.getBigramCount("english", "face") != 0){ //count of "english face"
			System.out.println("Error walrus.15");
		}
		if (sG.getBigramCount("pigs", "lie") != 0){ //count of "pigs lie"
			System.out.println("Error walrus.16");
		}
		if (!sG.getMostFrequentProceeding("am").equals("the")){
			System.out.println("Error walrus.17");
		}
		if (sG.getMostFrequentProceeding("boy") != null){
			System.out.println("Error walrus.18");
		}
		if (!sG.isLegalSentence("for the walrus")){
			System.out.println("Error walrus.19");
		}
		if (!sG.isLegalSentence("waiting for the walrus")){
			System.out.println("Error walrus.20");
		}
		if (sG.isLegalSentence("waiting for the walrus goo")){
			System.out.println("Error walrus.21");
		}
		if (sG.isLegalSentence("pigs they fly")){
			System.out.println("Error walrus.22");
		}
		if (sG.isLegalSentence("tuesday man")){
			System.out.println("Error walrus.23");
		}
		
		
		sG.initModel(CORNER_CASE0_FILENAME);		// " word "
		if (!Arrays.equals(sG.mVocabulary, new String[]{"word"})){
			System.out.println("Error corner_case_0.1");
		}
		if (!sG.getClosestWord("word").equals("word")){
			System.out.println("Error corner_case_0.2");
		}
		
		
		sG.initModel(CORNER_CASE1_FILENAME);		// "word"
		if (!sG.getClosestWord("word").equals("word")){
			System.out.println("Error corner_case_1.1");
		}
		
		
		sG.initModel(CORNER_CASE2_FILENAME);		// "word\nword1"
		if (!sG.getClosestWord("word").equals("word1")){
			System.out.println("Error corner_case_2.1");
		}
		if (!sG.getClosestWord("word1").equals("word")){
			System.out.println("Error corner_case_2.2");
		}
		
		
		sG.initModel(CORNER_CASE3_FILENAME);		// "word word1\nword2"
		if (!sG.getClosestWord("word").equals("word1")){
			System.out.println("Error corner_case_3.1");
		}
		if (!sG.getClosestWord("word1").equals("word")){
			System.out.println("Error corner_case_3.2");
		}
		if (!sG.getClosestWord("word2").equals("word")){
			System.out.println("Error corner_case_3.3");
		}
		
		String[] voc1 = sG.buildVocabularyIndex(CORNER_CASE3_FILENAME);
		if (voc1.length != 3){
			System.out.println("Error corner_case_3.4");
		}
		if (sG.mVocabulary.length != 3){
			System.out.println("Error corner_case_3.5");
		}
		if (!Arrays.equals(sG.mVocabulary, new String[]{"word", "word1", "word2"})){
			System.out.println("Error corner_case_3.6");
		}
		
		int[][] counts1 = sG.buildCountsArray(CORNER_CASE3_FILENAME, voc1);
		if (!Arrays.equals(counts1[0], new int[]{0,1,0})){
			System.out.println("Error corner_case_3.7");
		}
		if (!Arrays.equals(counts1[1], new int[]{0,0,0})){
			System.out.println("Error corner_case_3.8");
		}
		if (!Arrays.equals(counts1[2], new int[]{0,0,0})){
			System.out.println("Error corner_case_3.9");
		}
		if (!Arrays.equals(sG.mBigramCounts[0], new int[]{0,1,0})){
			System.out.println("Error corner_case_3.10");
		}
		if (!Arrays.equals(sG.mBigramCounts[1], new int[]{0,0,0})){
			System.out.println("Error corner_case_3.11");
		}
		if (!Arrays.equals(sG.mBigramCounts[2], new int[]{0,0,0})){
			System.out.println("Error corner_case_3.12");
		}
		if (sG.getBigramCount("word", "word") != 0){
			System.out.println("Error corner_case_3.13");
		}
		if (sG.getBigramCount("word", "word1") != 1){
			System.out.println("Error corner_case_3.14");
		}
		if (sG.getBigramCount("word1", "word2") != 0){
			System.out.println("Error corner_case_3.15");
		}
		if (sG.getWordIndex("word2") != 2){
			System.out.println("Error corner_case_3.16");
		}
		
		if (!sG.getMostFrequentProceeding("word").equals("word1")){
			System.out.println("Error corner_case_3.17");
		}
		if (sG.getMostFrequentProceeding("word1") != null){
			System.out.println("Error corner_case_3.18");
		}
		if (sG.getMostFrequentProceeding("word2") != null){
			System.out.println("Error corner_case_3.19");
		}
		
		if (!sG.isLegalSentence("word word1")){
			System.out.println("Error corner_case_3.20");
		}
		if (sG.isLegalSentence("word word1 word2")){
			System.out.println("Error corner_case_3.21");
		}
		if (sG.isLegalSentence("word1 word2")){
			System.out.println("Error corner_case_3.21");
		}
		if (sG.isLegalSentence("word1 word")){
			System.out.println("Error corner_case_3.22");
		}
		if (sG.isLegalSentence(" ")){
			System.out.println("Error corner_case_3.23");
		}
		if (sG.isLegalSentence("  ")){
			System.out.println("Error corner_case_3.24");
		}
		if (sG.isLegalSentence("   ")){
			System.out.println("Error corner_case_3.25");
		}
		if (sG.isLegalSentence(" word")){
			System.out.println("Error corner_case_3.26");
		}
		if (sG.isLegalSentence("word ")){
			System.out.println("Error corner_case_3.27");
		}
		if (sG.isLegalSentence(" word ")){
			System.out.println("Error corner_case_3.28");
		}
		if (sG.isLegalSentence(" word word1")){
			System.out.println("Error corner_case_3.29");
		}
		if (sG.isLegalSentence("word word1 ")){
			System.out.println("Error corner_case_3.30");
		}
		if (sG.isLegalSentence(" word word1 ")){
			System.out.println("Error corner_case_3.31");
		}
		
		
		sG.initModel(CORNER_CASE4_FILENAME);		// "word word1 word word2"
		if (!Arrays.equals(sG.mVocabulary, new String[]{"word", "word1", "word2"})){
			System.out.println("Error corner_case_4.1");
		}
		if (!Arrays.equals(sG.mBigramCounts[0], new int[]{0,1,1})){
			System.out.println("Error corner_case_4.2");
		}
		if (!Arrays.equals(sG.mBigramCounts[1], new int[]{1,0,0})){
			System.out.println("Error corner_case_4.3");
		}
		if (!Arrays.equals(sG.mBigramCounts[2], new int[]{0,0,0})){
			System.out.println("Error corner_case_4.4");
		}
		
		if (!sG.getMostFrequentProceeding("word").equals("word1")){
			System.out.println("Error corner_case_4.5");
		}

		
		
		// *** check @post for buildVocabularyIndex();
		
		sG.initModel(CORNER_CASE3_FILENAME);
		String[] mVocabularyRef = sG.mVocabulary;
		int[][] mBigramCountsRef = sG.mBigramCounts;
		String[] mVocabulary = Arrays.copyOf(sG.mVocabulary, sG.mVocabulary.length);
		int[][] mBigramCounts = Arrays.copyOf(sG.mBigramCounts, sG.mBigramCounts.length);
		
		String[] voc2 = sG.buildVocabularyIndex(CORNER_CASE3_FILENAME);
		if (mVocabularyRef != sG.mVocabulary){
			System.out.println("Error 1 @post for buildVocabularyIndex()");
		}
		if (mBigramCountsRef != sG.mBigramCounts){
			System.out.println("Error 2 @post for buildVocabularyIndex()");
		}
		if (!Arrays.equals(mVocabulary,sG.mVocabulary)){
			System.out.println("Error 3 @post for buildVocabularyIndex()");
		}
		for (int i = 0; i < sG.mBigramCounts.length; i++) {
			if (!Arrays.equals(mBigramCounts[i], sG.mBigramCounts[i]))
				System.out.println("Error 4 @post for buildVocabularyIndex()");
		}
		
		
		// *** check @post for buildCountsArray();
		
		sG.initModel(CORNER_CASE3_FILENAME);
		mVocabularyRef = sG.mVocabulary;
		mBigramCountsRef = sG.mBigramCounts;
		mVocabulary = Arrays.copyOf(sG.mVocabulary, sG.mVocabulary.length);
		mBigramCounts = Arrays.copyOf(sG.mBigramCounts, sG.mBigramCounts.length);
		
		int[][] counts2 = sG.buildCountsArray(CORNER_CASE3_FILENAME, voc);
		if (mVocabularyRef != sG.mVocabulary){
			System.out.println("Error 1 @post for buildCountsArray()");
		}
		if (mBigramCountsRef != sG.mBigramCounts){
			System.out.println("Error 2 @post for buildCountsArray()");
		}
		if (!Arrays.equals(mVocabulary,sG.mVocabulary)){
			System.out.println("Error 3 @post for buildCountsArray()");
		}
		for (int i = 0; i < sG.mBigramCounts.length; i++) {
			if (!Arrays.equals(mBigramCounts[i], sG.mBigramCounts[i]))
				System.out.println("Error 4 @post for buildCountsArray()");
		}
		
		
		// *** check that mVocabulary, mBigramCounts reference new arrays after initModel();
		
		sG.initModel(CORNER_CASE2_FILENAME);
		mVocabularyRef = sG.mVocabulary;
		mBigramCountsRef = sG.mBigramCounts;
		sG.loadModel(WALRUS_MODEL_DIR);
		if (mVocabularyRef == sG.mVocabulary){
			System.out.println("Error mVocabularyRef doesn't change after loadModel()");
		}
		if (mBigramCountsRef == sG.mBigramCounts){
			System.out.println("Error mBigramCountsRef doesn't change after loadModel()");
		}
		
		System.out.println("done!");
		
	}
}
