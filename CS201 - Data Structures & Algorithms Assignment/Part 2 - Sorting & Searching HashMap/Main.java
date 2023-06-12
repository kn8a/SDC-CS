/* ******** Array Sorting ********
    
    CS201 - Data Structures & Algorithms: Assignment

    Part 2: Sorting & Searching HashMap
    Now revise the code to store the pairs of each state and its capital in a Map 
    using the HashMap function. Display the content of the Map, 
    then use the TreeMap class to sort the map while using a binary 
    search tree for storage. Next, your program should prompt the user 
    to enter a state and it should then display the capital for the state.

    My additions: 
    - User's entry is not case sensitive
    - Prompt the user to enter a state until "exit" is entered
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a TreeMap to store the lowercase state names and their capital pairs
        TreeMap<String, String> stateCapitalMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        // Array containing the states and capitals
        String[][] statesAndCapitals = {
            // State and capital pairs
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

        // Add the lowercase state-capital pairs to the TreeMap
        for (String[] pair : statesAndCapitals) {
            // Extract the state and capital from the pair
            String state = pair[0];
            String capital = pair[1];

            // Add the state-capital pair to the TreeMap
            stateCapitalMap.put(state, capital);
        }

        // Display the sorted Map
        System.out.println("\nSorted Map:");
        displayMap(stateCapitalMap);

        // Prompt the user to enter a state until "exit" is entered
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter a state (type 'exit' to exit): ");
            String userInput = scanner.nextLine().trim();

            // Check if the user wants to exit
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            // Standardize the user's input for case-insensitive search
            String standardizedInput = capitalizeFirstLetter(userInput);

            // Check if the state exists in the Map
            if (stateCapitalMap.containsKey(standardizedInput)) {
                // Retrieve the capital for the given state
                String capital = stateCapitalMap.get(standardizedInput);

                // Display the capital of the state
                System.out.println("Capital of " + standardizedInput + ": " + capital);
            } else {
                System.out.println("Capital not found for " + userInput);
            }
        }

        // Close the scanner
        scanner.close();
    }

    // Method to capitalize the first letter of each word in a string
private static String capitalizeFirstLetter(String str) {
    if (str == null || str.isEmpty()) {
        return str;
    }
    // Split the string into words
    String[] words = str.split(" ");
    StringBuilder result = new StringBuilder();
    for (String word : words) {
        // Capitalize the first letter of each word
        result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
    }
    // Remove the trailing space
    return result.toString().trim();
}

    // Method to display the content of the Map
    private static void displayMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            // Retrieve the state and capital from the Map entry
            String state = entry.getKey();
            String capital = entry.getValue();

            // Display the state-capital pair
            System.out.println(state + " - " + capital);
        }
    }
}