package lab7;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * The movieNight class
 * 
 * @author prata
 *
 */

public class movieNight {
    public static boolean rankMovies(TreeMap<String, TreeSet<String>> studentsMovies, List<String> studentsToCheck) {
        if (studentsToCheck == null || studentsToCheck.isEmpty()) {
            return false;
        }

        TreeSet<String> commonMovies = new TreeSet<>();

        String firstStudent = studentsToCheck.get(0);
        TreeSet<String> firstStudentMovies = studentsMovies.get(firstStudent);
        if (firstStudentMovies != null) {
            commonMovies.addAll(firstStudentMovies);
        }

        for (int i = 1; i < studentsToCheck.size(); i++) {
            String student = studentsToCheck.get(i);
            TreeSet<String> studentMovies = studentsMovies.get(student);
            if (studentMovies != null) {
                commonMovies.retainAll(studentMovies);
            }

            if (commonMovies.isEmpty()) {
                return false;
            }
        }

        return !commonMovies.isEmpty();
    }
}