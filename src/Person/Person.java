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
}
