
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};

        int trials = 10;
        int range = 10000;

        Random random = new Random();

        for (int size : sizes) {

            double totalHeight = 0;
            double totalNodesVisited = 0;
            int totalSearches = 0;

            // Repeat the experiment 10 times
            for (int trial = 0; trial < trials; trial++) {

                BinarySearchTree tree = new BinarySearchTree();

                ArrayList<Integer> numbers = new ArrayList<>();

                // Generate random numbers and insert them
                for (int i = 0; i < size; i++) {

                    int number = random.nextInt(range) + 1;

                    numbers.add(number);
                    tree.insert(number);
                }

                // Record the height
                totalHeight += tree.height();

                // Search for every number in the array
                for (int number : numbers) {
                    totalNodesVisited += tree.find(number);
                    totalSearches++;
                }
            }

            // Calculate averages
            double averageHeight = totalHeight / trials;

            double averageNodesVisited =
                    totalNodesVisited / totalSearches;

            // Display results
            System.out.println("Number of values: " + size);
            System.out.println("Average height: " + averageHeight);
            System.out.println("Average nodes visited per find: "
                    + averageNodesVisited);

            System.out.println("-----------------------------");
        }
    }
}
