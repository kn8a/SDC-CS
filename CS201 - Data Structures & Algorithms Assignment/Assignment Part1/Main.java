/* ******** Array Sorting ********
    
    CS201 - Data Structures & Algorithms: Assignment

    Part 1: Sorting Arrays
    Develop a program that asks the user to enter a capital for a U.S. state. 
    Upon receiving the user input, the program reports whether the user input is correct. 
    For this application, the 50 states and their capitals are stored in a two-dimensional 
    array in order by state name. Display the current contents of the array then 
    use a bubble sort to sort the content by capital. 
    Next, prompt the user to enter answers for all the state capitals and then 
    display the total correct count. The user's answer is not case-sensitive.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Array containing the states and capitals
        String[][] statesAndCapitals = {
          {"Alabama","Montgomery"},
    			{"Alaska","Juneau"},
    			{"Arizona","Phoenix"},
    			{"Arkansas","Little Rock"},
    			{"California","Sacramento"},
    			{"Colorado","Denver"},
    			{"Connecticut","Hartford"},
    			{"Delaware","Dover"},
    			{"Florida","Tallahassee"},
    			{"Georgia","Atlanta"},
    			{"Hawaii","Honolulu"},
    			{"Idaho","Boise"},
    			{"Illinois","Springfield"},
    			{"Indiana","Indianapolis"},
    			{"Iowa","Des Moines"},
    			{"Kansas","Topeka"},
    			{"Kentucky","Frankfort"},
    			{"Louisiana","Baton Rouge"},
    			{"Maine","Augusta"},
    			{"Maryland","Annapolis"},
    			{"Massachusetts","Boston"},
    			{"Michigan","Lansing"},
    			{"Minnesota","St. Paul"},
    			{"Mississippi","Jackson"},
    			{"Missouri","Jefferson City"},
    			{"Montana","Helena"},
    			{"Nebraska","Lincoln"},
    			{"Nevada","Carson City"},
    			{"New Hampshire","Concord"},
    			{"New Jersey","Trenton"},
    			{"New Mexico","Santa Fe"},
    			{"New York","Albany"},
    			{"North Carolina","Raleigh"},
    			{"North Dakota","Bismarck"},
    			{"Ohio","Columbus"},
    			{"Oklahoma","Oklahoma City"},
    			{"Oregon","Salem"},
    			{"Pennsylvania","Harrisburg"},
    			{"Rhode Island","Providence"},
    			{"South Carolina","Columbia"},
    			{"South Dakota","Pierre"},
    			{"Tennessee","Nashville"},
    			{"Texas","Austin"},
    			{"Utah","Salt Lake City"},
    			{"Vermont","Montpelier"},
    			{"Virginia","Richmond"},
    			{"Washington","Olympia"},
    			{"West Virginia","Charleston"},
    			{"Wisconsin","Madison"},
    			{"Wyoming","Cheyenne"}
        };

        // Display the current contents of the array
        System.out.println("Current contents of the array:");
        displayArray(statesAndCapitals);

        // Sort the array by capital using bubble sort
        bubbleSort(statesAndCapitals);

        // Display the sorted array
        System.out.println("\nArray after sorting by capital:");
        displayArray(statesAndCapitals);

        // Prompt the user to enter answers for state capitals
        Scanner scanner = new Scanner(System.in);
        int correctCount = 0;
        for (int i = 0; i < statesAndCapitals.length; i++) {
            String state = statesAndCapitals[i][0];
            String capital = statesAndCapitals[i][1];

            System.out.print("Enter the capital of " + state + ": ");
            String userCapital = scanner.nextLine();

            // Check if the user's answer is correct (case-insensitive)
            if (userCapital.equalsIgnoreCase(capital)) {
                correctCount++;
            }
        }

        // Display the total correct count
        System.out.println("\nTotal correct count: " + correctCount);

        // Close the scanner
        scanner.close();
    }

    // Method to display the contents of the array
    private static void displayArray(String[][] array) {
        for (String[] row : array) {
            System.out.println(row[0] + " - " + row[1]);
        }
    }

    // Method to sort the array using bubble sort based on capital
    private static void bubbleSort(String[][] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j][1].compareToIgnoreCase(array[j + 1][1]) > 0) {
                    // Swap elements
                    String[] temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}