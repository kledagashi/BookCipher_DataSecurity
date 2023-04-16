package Reciever;

class Reciever extends Person {
    public String plainTextIfCompleteWord;
    public String plainTextIfSingleLetter;

    public Receiver(ArrayList<String> encryptedTextWithCompleteWord, ArrayList<String> encryptedTextWithSingleLetter) 
    throws IOException {
    super();
    this.plainTextIfCompleteWord = this.generatePlainTextIfCompleteWord(this.createArrayOutOfKey(encryptedTextWithCompleteWord), this.bookAsArrayOfRows);
    this.plainTextIfSingleLetter = this.generatePlaintextIfSingleLetter(this.createArrayOutOfKey(encryptedTextWithSingleLetter), this.bookAsArrayOfRows);
    System.out.println("\n"+"Hello Sender! I was able to crack your code and this is what i found out: " + "\n" + this.plainTextIfCompleteWord);
    System.out.println(this.plainTextIfSingleLetter);

     
    }
}
