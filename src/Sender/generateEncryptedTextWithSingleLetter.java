    public ArrayList<String> generateEncryptedTextWithSingleLetter(ArrayList<Character> plaintextAsArrayOfCharacters, ArrayList<ArrayList<String>> bookAsArrayOfRows) throws IOException {
        ArrayList<String> encryptedTextWithSingleLetter = new ArrayList<>();
        try {
            int numberOfCharactersThatHaveBeenFound = 0;
            for (int i = 0; i < bookAsArrayOfRows.size(); i++) {
                for (int j = 0; j < bookAsArrayOfRows.get(i).size(); j++) {
                    if (numberOfCharactersThatHaveBeenFound < plaintextAsArrayOfCharacters.size()) {
                        if (bookAsArrayOfRows.get(i).get(j).charAt(0) == Character.toLowerCase(plaintextAsArrayOfCharacters.get(numberOfCharactersThatHaveBeenFound)) || (bookAsArrayOfRows.get(i).get(j).charAt(0) == plaintextAsArrayOfCharacters.get(numberOfCharactersThatHaveBeenFound) || bookAsArrayOfRows.get(i).get(j).charAt(0) == Character.toUpperCase(plaintextAsArrayOfCharacters.get(numberOfCharactersThatHaveBeenFound)))) {
                            encryptedTextWithSingleLetter.add((i + 1) + "/" + (j + 1));
                            numberOfCharactersThatHaveBeenFound++;
                            i = 0;
                            j = 0;
                        }
                    }
                    else if (numberOfCharactersThatHaveBeenFound == plaintextAsArrayOfCharacters.size()) {
                        return encryptedTextWithSingleLetter;
                    }
                }
            }
        } catch (RuntimeException e) {
            System.err.println("There is no word that starts with one of the characters you have typed, or maybe the book contains no such words");
        }
        return myEncryptedTextWithSingleLetter;
    }
