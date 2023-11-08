import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * A class to match students together based on similarities in the movies they like
 * @author Madalyn Amero
 * @version 8 November, 2023
 *
 */
public class studentsMatcher {

	/**
	 * Finds the most similar student for each of the student in the keySet
	 * in terms of the common movies they like
	 * @param movies the TreeMap with the key of students names and the values of their
	 * favorite movies
	 * @return a TreeMap with the key of the student with the value of the student with the most
	 * movies in common with that student
	 */
	public TreeMap<String, String> findMatches(TreeMap<String, TreeSet<String>> movies) {
		TreeMap<String, String> match = new TreeMap<>();
		//storing the student names in an ArrayList
		ArrayList<String> students = (ArrayList<String>) movies.keySet();
		int common = 0;
		int max = 0;
		
		//loop to save TreeSet values into temp variable
		for (int i = 0; i < movies.get(i).size(); i++) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.addAll(movies.get(i));
			//current is the student whose match we are searching for
			String current = students.get(i);
			String maxStudent = "";
			
			//loop to compare each student's movie set to the current student
			//and determine the number of movies in common
			for (int j = i+1; j < students.size(); j++) {
				if (temp.get(j).equals(temp.get(i))) {
					common += 1;
				}
				//if the movies in common is greater than the max, max becomes common
				//common is reset to 0 and the student with the most in common is assigned
				if (common >= max) {
					max = common;
					common = 0;
					maxStudent = students.get(max);
				}
			}	
			
			//adds the current student as the key and the student with the 
			//most movies in common as they value
			match.put(current, maxStudent);
		}
		return match;
	}
		
}
