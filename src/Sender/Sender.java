
 class Sender extends Person {
    public ArrayList<String> myEncryptedTextWithCompleteWords;
    public ArrayList<String> myEncryptedTextWithSingleLetter;
    private String myPlainText;
    private ArrayList<String> plaintextAsArrayOfWords;
    private ArrayList<Character> plaintextAsArrayOfCharacters;

    public Sender(String myPlainText,String bookUrl) throws IOException {
        super(bookUrl);
        this.myPlainText = myPlainText;
        this.plaintextAsArrayOfWords = this.turnSentenceInArrayOfWords(this.myPlainText);
        this.plaintextAsArrayOfCharacters = this.turnSentenceInArrayOfCharacters(this.plaintextAsArrayOfWords);
        this.myEncryptedTextWithCompleteWords = this.generateEncryptedTextWithCompleteWord(this.plaintextAsArrayOfWords, this.bookAsArrayOfRows);
        this.myEncryptedTextWithSingleLetter = this.generateEncryptedTextWithSingleLetter(this.plaintextAsArrayOfCharacters, this.bookAsArrayOfRows);
        System.out.println("Hello! This is my encrypted text with Complete Words: " + "\n " + this.myEncryptedTextWithCompleteWords);
        System.out.println("Also if you need it here is it with Single Letter" + "\n " + this.myEncryptedTextWithSingleLetter);
    }

