import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Person {
    protected ArrayList<ArrayList<String>> bookAsArrayOfRows;
    protected File bookFile;

    public Person(String bookURL) throws IOException {
        this.generateTheFile(bookURL);
        this.bookAsArrayOfRows = this.generateArrayOfRows();
    }

    public void generateTheFile(String bookURL) {
        this.bookFile = new File(bookURL);
    }

    public ArrayList<ArrayList<String>> generateArrayOfRows() throws IOException {
        Scanner scanner = new Scanner(this.bookFile);
        this.bookAsArrayOfRows = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String row = "";
            row += scanner.nextLine().replaceAll("[^A-Za-z0-9\s]", "");
            if (!(row.length() == 0)) {
                ArrayList<String> rows = new ArrayList<>();
                String[] array;
                array = row.split(" ");
                Collections.addAll(rows, array);
                this.bookAsArrayOfRows.add(rows);
            }
        }
        scanner.close();

        return this.bookAsArrayOfRows;
    }
}


class Sender extends Person {
    public ArrayList<String> myEncryptedTextWithCompleteWords;
    public ArrayList<String> myEncryptedTextWithSingleLetter;
    private String myPlainText;
    private ArrayList<String> plaintextAsArrayOfWords;
    private ArrayList<Character> plaintextAsArrayOfCharacters;


    public Sender(String myPlainText, String bookUrl) throws IOException {
        super(bookUrl);
        this.myPlainText = myPlainText;
        this.plaintextAsArrayOfWords = this.turnSentenceInArrayOfWords(this.myPlainText);
        this.plaintextAsArrayOfCharacters = this.turnSentenceInArrayOfCharacters(this.plaintextAsArrayOfWords);
        this.myEncryptedTextWithCompleteWords = this.generateEncryptedTextWithCompleteWord(this.plaintextAsArrayOfWords, this.bookAsArrayOfRows);
        this.myEncryptedTextWithSingleLetter = this.generateEncryptedTextWithSingleLetter(this.plaintextAsArrayOfCharacters, this.bookAsArrayOfRows);
        System.out.println("Hello! This is my encrypted text with Complete Words: " + "\n " + this.myEncryptedTextWithCompleteWords);
        System.out.println("Also here it is encrypted with Characters" + "\n " + this.myEncryptedTextWithSingleLetter);
    }

    public ArrayList<String> turnSentenceInArrayOfWords(String plainText) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] array;
        array = plainText.split(" ");
        Collections.addAll(arrayList, array);
        return arrayList;
    }

    public ArrayList<Character> turnSentenceInArrayOfCharacters(ArrayList<String> plaintextAsArrayOfWords) {
        ArrayList<Character> arrayOfCharacters = new ArrayList<>();
        for (String word : plaintextAsArrayOfWords) {
            for (int i = 0; i < word.length(); i++) {
                arrayOfCharacters.add(word.charAt(i));
            }
        }
        return arrayOfCharacters;
    }


    public ArrayList<String> generateEncryptedTextWithCompleteWord(ArrayList<String> plaintextAsArrayOfWords, ArrayList<ArrayList<String>> bookAsArrayOfRows) throws RuntimeException {
        ArrayList<String> encryptedTextWithCompleteWord = new ArrayList<>();
        try {
            int numberOfWordsThatHaveBeenFound = 0;
            for (int i = 0; i < bookAsArrayOfRows.size(); i++) {
                for (int j = 0; j < bookAsArrayOfRows.get(i).size(); j++) {
                    if (numberOfWordsThatHaveBeenFound < plaintextAsArrayOfWords.size()) {
                        if (bookAsArrayOfRows.get(i).get(j).equalsIgnoreCase(plaintextAsArrayOfWords.get(numberOfWordsThatHaveBeenFound))) {
                            encryptedTextWithCompleteWord.add((i + 1) + "/" + (j + 1));
                            numberOfWordsThatHaveBeenFound++;
                            i = 0;
                            j = 0;
                        }
                    } else if (numberOfWordsThatHaveBeenFound == plaintextAsArrayOfWords.size()) {
                        return encryptedTextWithCompleteWord;
                    }
                }
            }
        } catch (RuntimeException e) {
            System.err.println("There is something wrong with the programme, please try again or check your input");
        }
        if (encryptedTextWithCompleteWord.isEmpty()) {
            throw new RuntimeException("Book doesn't contain one of the words that you have typed, or your word has been typed incorrectly");
        }

        return encryptedTextWithCompleteWord;
    }

    public ArrayList<String> generateEncryptedTextWithSingleLetter(ArrayList<Character> plaintextAsArrayOfCharacters, ArrayList<ArrayList<String>> bookAsArrayOfRows) throws IOException {

        try {
            ArrayList<String> encryptedTextWithSingleLetter = new ArrayList<>();
            int numberOfCharactersThatHaveBeenFound = 0;
            for (int i = 0; i < bookAsArrayOfRows.size(); i++) {
                for (int j = 0; j < bookAsArrayOfRows.get(i).size(); j++) {
                    if (numberOfCharactersThatHaveBeenFound < plaintextAsArrayOfCharacters.size()) {
                        if (bookAsArrayOfRows.get(i).get(j).charAt(0) == Character.toLowerCase(plaintextAsArrayOfCharacters.get(numberOfCharactersThatHaveBeenFound)) || (bookAsArrayOfRows.get(i).get(j).charAt(0) == plaintextAsArrayOfCharacters.get(numberOfCharactersThatHaveBeenFound) || bookAsArrayOfRows.get(i).get(j).charAt(0) == Character.toUpperCase(plaintextAsArrayOfCharacters.get(numberOfCharactersThatHaveBeenFound)))) {
                            encryptedTextWithSingleLetter.add((i + 1) + "/" + (j + 1));
                            numberOfCharactersThatHaveBeenFound++;
                            i = 0;
                            j = 0;
                        }
                    } else if (numberOfCharactersThatHaveBeenFound == plaintextAsArrayOfCharacters.size()) {
                        return encryptedTextWithSingleLetter;
                    }
                }
            }
        } catch (RuntimeException e) {
            System.err.println("There is no word that starts with one of the characters you have typed, or maybe the book contains no such words");
        }
        return myEncryptedTextWithSingleLetter;
    }

}


class Receiver extends Person {
    public String plainTextIfCompleteWord;
    public String plainTextIfSingleLetter;

    public Receiver(ArrayList<String> encryptedTextWithCompleteWord, ArrayList<String> encryptedTextWithSingleLetter, String bookUrl) throws IOException {
        super(bookUrl);
        this.plainTextIfCompleteWord = this.generatePlainTextIfCompleteWord(this.createArrayOutOfKey(encryptedTextWithCompleteWord), this.bookAsArrayOfRows);
        this.plainTextIfSingleLetter = this.generatePlaintextIfSingleLetter(this.createArrayOutOfKey(encryptedTextWithSingleLetter), this.bookAsArrayOfRows);
        System.out.println("\n" + "Hello Sender! I was able to crack your code and this is what i found out: " + "\n" + this.plainTextIfCompleteWord);
        System.out.println(this.plainTextIfSingleLetter);
    }

    private ArrayList<ArrayList<Integer>> createArrayOutOfKey(ArrayList<String> encryptedText) {
        ArrayList<ArrayList<Integer>> rowAndPosition = new ArrayList<>();
        String array[];
        for (String key : encryptedText) {
            ArrayList<Integer> tempInt = new ArrayList<>();
            ArrayList<String> tempString = new ArrayList<>();

            array = key.split("/");
            Collections.addAll(tempString, array);

            for (String s : tempString) {
                tempInt.add(Integer.parseInt(s));
            }
            rowAndPosition.add(tempInt);
        }
        return rowAndPosition;
    }

    public String generatePlainTextIfCompleteWord(ArrayList<ArrayList<Integer>> encryptedText, ArrayList<ArrayList<String>> bookAsArrayOfRows) {
        String plainText = "";
        for (ArrayList<Integer> rowNumb : encryptedText) {
            plainText += bookAsArrayOfRows.get(rowNumb.get(0) - 1).get(rowNumb.get(1) - 1) + " ";
        }
        return "If you used Complete Word Encoding then this is the message:  [" + plainText.toUpperCase() + "]";
    }

    public String generatePlaintextIfSingleLetter(ArrayList<ArrayList<Integer>> encryptedText, ArrayList<ArrayList<String>> bookAsArrayOfRows) {
        String plainText = "";
        String wordsThatWereUsed = "";
        for (ArrayList<Integer> rowNumb : encryptedText) {
            plainText += bookAsArrayOfRows.get(rowNumb.get(0) - 1).get(rowNumb.get(1) - 1).charAt(0) + " ";
            wordsThatWereUsed += bookAsArrayOfRows.get(rowNumb.get(0) - 1).get(rowNumb.get(1) - 1) + ", ";
        }
        return "But if you used Single Letter encoding this is the message :  [" + plainText.toUpperCase() + "]" + "\n" + "And the words that were used are: " + "[" + wordsThatWereUsed.toUpperCase() + "]";
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        String bookURL = "C:\\Users\\Admin\\IdeaProjects\\DataSec_Project02\\out\\production\\DataSec_Project02\\Crime and Punishment.txt";
        Sender sender = new Sender("I have never been here before", bookURL);
        Receiver receiver = new Receiver(sender.myEncryptedTextWithCompleteWords, sender.myEncryptedTextWithSingleLetter, bookURL);
    }
}
