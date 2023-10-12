public class Problem3 {

    public static void main(String[] args) {

        // Problem 3: Object Basics
        // In the following code the soliloquy is analyzed character by character to determine the vowels,
        // spaces and letters used. Fill in the code that computes the number of spaces, vowels, and consonants.

        String text = "To be or not to be, that is the question;"
        +"Whether `tis nobler in the mind to suffer"
        +" the slings and arrows of outrageous fortune,"
        +" or to take arms against a sea of troubles,"
        +" and by opposing end them?";
        int spaces = 0, vowels = 0, letters = 0;
        //YOUR CODE HERE
        char[] data = text.toCharArray();
        // to find all: 
        for(int i = 0; i < data.length; i++) {
            if(Character.isWhitespace(data[i])) 
                spaces++;
            if(Character.toUpperCase(data[i]) == 'A' 
            || Character.toUpperCase(data[i]) == 'E' 
            || Character.toUpperCase(data[i]) == 'I'
            || Character.toUpperCase(data[i]) == 'O'
            || Character.toUpperCase(data[i]) == 'U')
                vowels++;
            if(Character.isAlphabetic(text.charAt(i))) 
                letters++;
        }
        System.out.println("The text contained vowels: " + vowels + "\nconsonants: " + (letters - vowels) + "\nspaces: " + spaces);
    }

}
