class Person {
 protected ArrayList<ArrayList<String>> bookAsArrayOfRows;
 protected String bookURL = "C:\\Users\\Admin\\IdeaProjects\\DataSec_Project02\\out\\production\\DataSec_Project02\\Crime and Punishment.txt";
 protected File bookFile;

 public Person() throws IOException {
   this.generateTheFile();
   this.bookAsArrayOfRows = this.generateArrayOfRows();
 }

 public void generateTheFile() {
   this.bookFile = new File(this.bookURL);
 }
}
