// Harman Dhillon CS145 
// Lab 3 
// 10-15-2024
// This program will be used to count letter in a certain 
// inventory that is given. It will add or subtract letters 
// from two different inventories. 
// Will be able to update and add letters of our choice after 
// the input. Will also be able to pick a certain letter and 
// receive count of total times it is used. Will provide 
// a total number of characters and sum of both inventories


//Uses LetterInventoryTest for input of Inventories.


import java.util.Arrays;

public class LetterInventory {
    public static final int LETTER_COUNT = 26; // Number of letters in the alphabet
    private int[] letterCount; // Array to store counts of each letter
    private int size; // Total size of the inventory

    // Constructor that initializes the letter inventory from the input string found in other file
    public LetterInventory(String data) {
        letterCount = new int[LETTER_COUNT];
        size = 0;

        for (int i = 0; i < data.length(); i++) {
            char ch = Character.toLowerCase(data.charAt(i));
            if (ch >= 'a' && ch <= 'z') {
                letterCount[ch - 'a']++;
                size++;
            }
        }
    }

    // Returns the count of a specific letters in inventory
    public int get(char letter) {
        char ch = Character.toLowerCase(letter);
        if (ch < 'a' || ch > 'z') {
            throw new IllegalArgumentException("Invalid character: " + letter);
        }
        return letterCount[ch - 'a'];
    }

    // Sets the count for a specific letter
    public void set(char letter, int value) {
        char ch = Character.toLowerCase(letter);
        if (ch < 'a' || ch > 'z' || value < 0) {
            throw new IllegalArgumentException("Invalid input: letter=" + letter + ", value=" + value);
        }
        size += value - letterCount[ch - 'a'];
        letterCount[ch - 'a'] = value;
    }

    // Returns the total number of letters in the inventory
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Returns a string representation of the inventory
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < LETTER_COUNT; i++) {
            for (int j = 0; j < letterCount[i]; j++) {
                result.append((char) (i + 'a'));
            }
        }
        result.append("]");
        return result.toString();
    }

    // Adds another LetterInventory to this one and returns a new LetterInventory
    public LetterInventory add(LetterInventory other) {
        LetterInventory newInventory = new LetterInventory("");
        for (int i = 0; i < LETTER_COUNT; i++) {
            newInventory.letterCount[i] = this.letterCount[i] + other.letterCount[i];
        }
        newInventory.size = this.size + other.size;
        return newInventory;
    }

    // Subtracts another LetterInventory from this one and returns a new LetterInventory
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory newInventory = new LetterInventory("");
        for (int i = 0; i < LETTER_COUNT; i++) {
            newInventory.letterCount[i] = this.letterCount[i] - other.letterCount[i];
            if (newInventory.letterCount[i] < 0) {
                return null; // If any count is negative, return null
            }
        }
        newInventory.size = this.size - other.size;
        return newInventory;
    }
}
