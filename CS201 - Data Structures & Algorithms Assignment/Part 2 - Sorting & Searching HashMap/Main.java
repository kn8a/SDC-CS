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
    // Create a HashMap to store the case-insensitive state names and their capital pairs
    HashMap<CaseInsensitiveString, String> stateCapitalMap = new HashMap<>();

    // Array containing the states and capitals
    String[][] statesAndCapitals = {
      // State and capital pairs
      { "Alabama", "Montgomery" },
      { "Alaska", "Juneau" },
      { "Arizona", "Phoenix" },
      { "Arkansas", "Little Rock" },
      { "California", "Sacramento" },
      { "Colorado", "Denver" },
      { "Connecticut", "Hartford" },
      { "Delaware", "Dover" },
      { "Florida", "Tallahassee" },
      { "Georgia", "Atlanta" },
      { "Hawaii", "Honolulu" },
      { "Idaho", "Boise" },
      { "Illinois", "Springfield" },
      { "Indiana", "Indianapolis" },
      { "Iowa", "Des Moines" },
      { "Kansas", "Topeka" },
      { "Kentucky", "Frankfort" },
      { "Louisiana", "Baton Rouge" },
      { "Maine", "Augusta" },
      { "Maryland", "Annapolis" },
      { "Massachusetts", "Boston" },
      { "Michigan", "Lansing" },
      { "Minnesota", "St. Paul" },
      { "Mississippi", "Jackson" },
      { "Missouri", "Jefferson City" },
      { "Montana", "Helena" },
      { "Nebraska", "Lincoln" },
      { "Nevada", "Carson City" },
      { "New Hampshire", "Concord" },
      { "New Jersey", "Trenton" },
      { "New Mexico", "Santa Fe" },
      { "New York", "Albany" },
      { "North Carolina", "Raleigh" },
      { "North Dakota", "Bismarck" },
      { "Ohio", "Columbus" },
      { "Oklahoma", "Oklahoma City" },
      { "Oregon", "Salem" },
      { "Pennsylvania", "Harrisburg" },
      { "Rhode Island", "Providence" },
      { "South Carolina", "Columbia" },
      { "South Dakota", "Pierre" },
      { "Tennessee", "Nashville" },
      { "Texas", "Austin" },
      { "Utah", "Salt Lake City" },
      { "Vermont", "Montpelier" },
      { "Virginia", "Richmond" },
      { "Washington", "Olympia" },
      { "West Virginia", "Charleston" },
      { "Wisconsin", "Madison" },
      { "Wyoming", "Cheyenne" },
    };

    // Add the case-insensitive state-capital pairs to the HashMap
    for (String[] pair : statesAndCapitals) {
      // Extract the state and capital from the pair
      String state = pair[0];
      String capital = pair[1];

      // Create a CaseInsensitiveString object as the key
      CaseInsensitiveString key = new CaseInsensitiveString(state);

      // Add the state-capital pair to the HashMap
      stateCapitalMap.put(key, capital);
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

      // Create a CaseInsensitiveString object from the user's input
      CaseInsensitiveString userKey = new CaseInsensitiveString(userInput);

      // Check if the state exists in the Map
      if (stateCapitalMap.containsKey(userKey)) {
        // Retrieve the capital for the given state
        String capital = stateCapitalMap.get(userKey);

        // Display the capital of the state
        System.out.println("Capital of " + userKey.getValue() + ": " + capital);
      } else {
        System.out.println("Capital not found for " + userInput);
      }
    }

    // Close the scanner
    scanner.close();
  }

  // Method to display the content of the Map
  private static void displayMap(Map<CaseInsensitiveString, String> map) {
    for (Map.Entry<CaseInsensitiveString, String> entry : map.entrySet()) {
      // Retrieve the state and capital from the Map entry
      CaseInsensitiveString state = entry.getKey();
      String capital = entry.getValue();

      // Display the state-capital pair
      System.out.println(state.getValue() + " - " + capital);
    }
  }

  // Custom class to represent a case-insensitive string
  static class CaseInsensitiveString {

    private final String value;

    // Constructor to initialize the value
    public CaseInsensitiveString(String value) {
      this.value = value;
    }

    // Getter method to retrieve the value
    public String getValue() {
      return value;
    }

    // Override the equals() method for case-insensitive comparison
    @Override
    public boolean equals(Object obj) {
      // Check if the references are the same
      if (this == obj) {
        return true;
      }

      // Check if the object is null or of different class
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }

      // Perform case-insensitive comparison
      CaseInsensitiveString other = (CaseInsensitiveString) obj;
      return value.equalsIgnoreCase(other.value);
    }

    // Override the hashCode() method for consistent hashing
    @Override
    public int hashCode() {
      // Convert the value to lowercase and calculate the hash code
      return value.toLowerCase().hashCode();
    }
  }
}
