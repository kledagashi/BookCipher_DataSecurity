    public ArrayList<String> generateEncryptedTextWithCompleteWord(ArrayList<String> plaintextAsArrayOfWords, ArrayList<ArrayList<String>> bookAsArrayOfRows) throws RuntimeException {
        ArrayList<String> encryptedTextWithCompleteWord = new ArrayList<>();
        try {
            int numberOfWordsThatHaveBeenFound = 0;
            for (int i = 0; i < bookAsArrayOfRows.size(); i++) {
                for (int j = 0; j < bookAsArrayOfRows.get(i).size(); j++) {
                    if (numberOfWordsThatHaveBeenFound < plaintextAsArrayOfWords.size()) {
                        if (bookAsArrayOfRows.get(i).get(j).equalsIgnoreCase(plaintextAsArrayOfWords.get(numberOfWordsThatHaveBeenFound))) {
                            encryptedTextWithCompleteWord.add((i + 1) + "/" + (j + 1));
                            numberOfWordsThatHaveBeenFound++;
                            i = 0;
                            j = 0;
                        }
                    } else if (numberOfWordsThatHaveBeenFound == plaintextAsArrayOfWords.size()) {
                        return encryptedTextWithCompleteWord;
                    }
                }
            }
        }
        catch (RuntimeException e){
            System.err.println("There is something wrong with the program, please try again or check your input");
        }
            if (encryptedTextWithCompleteWord.isEmpty()){
                throw new RuntimeException("Book doesn't contain one of the words that you have typed, or your word has been typed incorrectly");
            }

        return encryptedTextWithCompleteWord;
    }
