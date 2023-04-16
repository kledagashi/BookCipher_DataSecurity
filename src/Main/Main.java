public class Main {
    public static void main(String[] args) throws IOException {
        String bookURL = "C:\\Users\\Admin\\IdeaProjects\\DataSec_Project02\\out\\production\\DataSec_Project02\\Crime and Punishment.txt";
        Sender sender = new Sender("I have never been here before", bookURL);
        Receiver receiver = new Receiver(sender.myEncryptedTextWithCompleteWords, sender.myEncryptedTextWithSingleLetter, bookURL);
    }
}
