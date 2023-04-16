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
