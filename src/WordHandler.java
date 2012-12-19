import java.util.*;
import java.io.File;

/**
 * contains all the logic behind the 
 * program
 * 
 * @author steven
 *
 */
public class WordHandler{
	private String word;
	private static final String DEFAULT_DICTIONARY_LOCATION = "dictionary.txt";
	private static Set<String> dictionary = new HashSet<String>();

	/**
	 * builds the word handler with the letters 
	 * inputed in the control panel
	 * @param letters
	 */
	public WordHandler(String letters){
		this.word = letters;
		dictionary = buildDictionary();
	}

	/**
	 * returns the list of words that 
	 * matches the characters
	 * @return
	 */
	public List<String> wordList(){
		List<String> answer = new LinkedList<String>();
		for(String s: makeList()){
			if(dictionary.contains(s)){
				answer.add(s);
			}
		}
		return answer;
	}

	/**
	 * recursive method that builds all possible anagrams of 
	 * the given letter string 
	 * this could be visualized as a decision tree
	 * @return
	 */
	private Set<String> makeList(){
		int leng = word.length();
		Set<String> answer = new HashSet<String>();
		for(int i=0; i<leng; i++){
			makeList("", word, answer);
			word = word.substring(word.length()-1,word.length()) + word.substring(0,word.length()-1);
		}
		return answer;
	}

	
	private Set<String> makeList(String slice, String word, Set<String> set){
		if (word.length()==0) {
			if(dictionary.contains(slice)){
				set.add(slice);
			}
			return Collections.singleton(slice); //null collection
		}
		for (int i=0;i<word.length();i++){
			if(dictionary.contains(slice)){
				set.add(slice);
			}
			makeList(slice + word.charAt(i), word.substring(0,i)+word.substring(i+1, word.length()),set);
		}
		return set;
	}
	
	/** 
	 * builds the dictionary 
	 * @return
	 */

	private Set<String> buildDictionary(){
		try{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(new File(DEFAULT_DICTIONARY_LOCATION ));
			while (scan.hasNext()){
				dictionary.add(scan.nextLine());
			}
		}
		catch(Exception e){
			throw new RuntimeException("Could not find dictionary at " + DEFAULT_DICTIONARY_LOCATION  + ".");
		}
		return dictionary;
	}
}
