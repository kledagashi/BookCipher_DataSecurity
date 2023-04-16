public ArrayList<String> generateEncryptedTextWithCompleteWord(ArrayList<String> plaintextAsArrayOfWords, ArrayList<ArrayList<String>> bookAsArrayOfRows) {
        ArrayList<String> encryptedTextWithCompleteWord = new ArrayList<>();
        int i = 0;
        for (ArrayList<String> row : bookAsArrayOfRows) {
            for (String wordOfBook : row) {
                if (i < plaintextAsArrayOfWords.size()) {
                    if (wordOfBook.equalsIgnoreCase(plaintextAsArrayOfWords.get(i))) {
                        encryptedTextWithCompleteWord.add((bookAsArrayOfRows.indexOf(row) + 1) + "/" + (row.indexOf(wordOfBook) + 1));
                        i++;
                    }
                }
                else {
                    return encryptedTextWithCompleteWord;
                }
            }
        }
        return encryptedTextWithCompleteWord;
    }
