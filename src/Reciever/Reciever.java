package Reciever;

class Reciever extends Person {
    public String plainTextIfCompleteWord;
    public String plainTextIfSingleLetter;

    public Receiver(ArrayList<String> encryptedTextWithCompleteWord, ArrayList<String> encryptedTextWithSingleLetter,String bookUrl) 
     throws IOException {
    super(bookUrl);
    this.plainTextIfCompleteWord = this.generatePlainTextIfCompleteWord(this.createArrayOutOfKey(encryptedTextWithCompleteWord), this.bookAsArrayOfRows);
    this.plainTextIfSingleLetter = this.generatePlaintextIfSingleLetter(this.createArrayOutOfKey(encryptedTextWithSingleLetter), this.bookAsArrayOfRows);
    System.out.println("\n"+"Hello Sender! I was able to crack your code and this is what i found out: " + "\n" + this.plainTextIfCompleteWord);
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
