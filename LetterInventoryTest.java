// Set the first Invetory as "Harman"
// Second Inventory as "Dhillon"


public class LetterInventoryTest {
    public static void main(String[] args) {
        LetterInventory inventory1 = new LetterInventory("Harman"); // Take letter inventory of these words
        LetterInventory inventory2 = new LetterInventory("Dhillon");

        System.out.println("Inventory 1: " + inventory1); // Should show counts for inventory1
        System.out.println("Inventory 2: " + inventory2); // Should show counts for inventory2

        LetterInventory sum = inventory1.add(inventory2);
        int sum1 = inventory1.size()+(inventory2.size());
        System.out.println("Sum: " + sum); // Should show combined counts

        LetterInventory difference = inventory1.subtract(inventory2);
        System.out.println("Difference: " + difference); // Should show difference or null if negative

        System.out.println("Is Inventory 1 empty? " + inventory1.isEmpty()); // Expected: false

        System.out.println("Size of Inventory 1: " + inventory1.size()); // Total count of Inventory 1

        System.out.println("Size of Inventory 2: " + inventory2.size()); // Total count of Inventory 2

        System.out.println("Size of Inventory 1+2: " + sum1 ); // Total count of both Inventorys
        
        System.out.println("Count of letter 'a': " + sum.get('a')); // Used to get count of a specfic letter, in this case 'a'
    
        // To add certain letters to inventory 1 , set in example is "2" letter of "y"
        inventory1.set('y', 2);
        System.out.println("Updated Inventory 1: " + inventory1); // Show updated inventory

        // To add certain letters to inventory 2 , set in example is "2" letter of "y"
        inventory2.set('y', 2);
        System.out.println("Updated Inventory 2: " + inventory2); // Show updated inventory

       
     
        

    
    }
}
