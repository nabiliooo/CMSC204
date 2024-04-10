/**
 * 
 * @author Nabil El-Hage
 * @assignment 5
 * 
 */
public class MorseCodeConverter {
	protected static MorseCodeTree tree = new MorseCodeTree();
	
	/**
	 * Converts MorseCode to English
	 * 
	 * @param input
	 * @return translation
	 */
	public static String convertToEnglish(String input){
		String result = "";
		String[] words = input.split(" / ");
		
		for (String word : words) {
			String[] letters = word.split(" ");
			for (String letter : letters){
				result += MorseCodeConverter.tree.fetch(letter);
			}
			result += " ";
		}
		return result.trim();
	}

	/**
	 * Converts MorseCode to English using a provided file
	 * 
	 * @param file import
	 * @return translation
	 */
	public static String convertToEnglish(java.io.File file) throws java.io.FileNotFoundException{
		if (file == null) {
			throw new java.io.FileNotFoundException("File provided was null"); 
		}
		
		java.util.ArrayList<String> lines = new java.util.ArrayList<String>();
		java.util.Scanner scanner = new java.util.Scanner(file);
		String result = "";

		while (scanner.hasNext()){
			lines.add(scanner.nextLine());
		}
		
		for (int i = 0; i < lines.size(); i++){
			result += MorseCodeConverter.convertToEnglish(lines.get(i));
		}

		scanner.close();
		return result.trim();
	}

	/**
	 * Prints MorseCodeTree
	 * @return String tree
	 */
	public static String printTree(){
		if (tree == null){
			return ""; 
		}
		java.util.ArrayList<String> list = tree.toArrayList();
		String result = "";

		for (String letter : list){
			result += letter + " ";
		}
		
		return result.trim();
	}
}