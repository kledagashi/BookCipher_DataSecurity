    public ArrayList<String> generateEncryptedTextWithSingleLetter(ArrayList<Character> plaintextAsArrayOfCharacters, ArrayList<ArrayList<String>> bookAsArrayOfRows) {
        ArrayList<String> encryptedTextWithSingleLetter = new ArrayList<>();
        int i = 0;
        for (ArrayList<String> row : bookAsArrayOfRows) {
            for (String wordOfBook : row) {
                if (i < plaintextAsArrayOfCharacters.size()) {
                    if (wordOfBook.charAt(0) == Character.toLowerCase(plaintextAsArrayOfCharacters.get(i)) || wordOfBook.charAt(0) == plaintextAsArrayOfCharacters.get(i)) {
                        encryptedTextWithSingleLetter.add((bookAsArrayOfRows.indexOf(row) + 1) + "/" + (row.indexOf(wordOfBook) + 1));
                        i++;
                    }
                }
                else {
                    return encryptedTextWithSingleLetter;
                }
            }
        }
        return encryptedTextWithSingleLetter;
    }
