package lab7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Implementing the movieNight class.
 * 
 * @author Vivek
 *
 */

public class movieNightMain {
    public static void main(String[] args) {
        TreeMap<String, TreeSet<String>> studentsMovies = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Movies.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String studentName = data[0];
                TreeSet<String> favoriteMovies = new TreeSet<>(Arrays.asList(data).subList(1, data.length));
                studentsMovies.put(studentName, favoriteMovies);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean canWatchTogether = movieNight.rankMovies(studentsMovies, studentsToCheck);
        if (canWatchTogether) {
            System.out.println("The students can watch a common movie together.");
        } else {
            System.out.println("The students cannot find a common movie to watch together.");
        }
    }
}