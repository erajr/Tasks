public class Problem4 {

    public static void main(String[] args) {

        // Problem 4: Object Basics
        // Write a program that sets up a String variable with the soliloquy in the previous question,
        // extracts the words from the text and sorts them into alphabetical order. You may define
        // 'words' however you wish (within reason), but provide your definition with your solution. You
        // can use the sorting method of your choice.

        String text = "To be or not to be, that is the question;"
        +"Whether `tis nobler in the mind to suffer"
        +" the slings and arrows of outrageous fortune,"
        +" or to take arms against a sea of troubles,"
        +" and by opposing end them?";

        // Split String text into array of String[]
        String[] words = text.split(" |;");
        for(int i = 0; i < words.length; i++) {
            System.out.println("words: " + words[i]);
        }

        // Sort words[] array via bubble sort:
        String tmp = "";

        for(int i = 0; i < words.length - 1; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if(words[i].compareTo(words[j]) > 0) {
                    tmp = words[i];
                    words[i] = words[j];
                    words[j] = tmp;
                }
            }
        }

        // Sorted words[] array
        for(int i = 0; i < words.length; i++) {
            System.out.println("Words: " + words[i]);
        }

    }
    
}
