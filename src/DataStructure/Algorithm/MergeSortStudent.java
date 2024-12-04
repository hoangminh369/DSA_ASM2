package DataStructure.Algorithm;

import Assignment.Student;
import java.util.List;

public class MergeSortStudent {

    // Merge Sort method
    public static void mergeSort(List<Student> students, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Sort the left half
            mergeSort(students, left, middle);

            // Sort the right half
            mergeSort(students, middle + 1, right);

            // Merge the two halves
            merge(students, left, middle, right);
        }
    }

    // Merge method to combine the sorted halves
    public static void merge(List<Student> students, int left, int middle, int right) {
        // Find sizes of two sublists to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary lists for the left and right parts
        List<Student> leftList = students.subList(left, left + n1);
        List<Student> rightList = students.subList(middle + 1, middle + 1 + n2);

        // Merge the temporary sublists
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i).getMark() >= rightList.get(j).getMark()) {
                students.set(k, leftList.get(i));
                i++;
            } else {
                students.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftList[]
        while (i < n1) {
            students.set(k, leftList.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of rightList[]
        while (j < n2) {
            students.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
}
