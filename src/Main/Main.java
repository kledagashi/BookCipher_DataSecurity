public class Main {
    public static void main(String[] args) throws IOException {
        Sender sender = new Sender("I have never been here before");
        Receiver receiver = new Receiver(sender.myEncryptedTextWithCompleteWords,sender.myEncryptedTextWithSingleLetter);
    }
}
