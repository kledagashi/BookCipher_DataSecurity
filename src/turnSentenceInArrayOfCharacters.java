public ArrayList<Character> turnSentenceInArrayOfCharacters(ArrayList<String> plaintextAsArrayOfWords) {
        ArrayList<Character> arrayOfCharacters = new ArrayList<>();
        for (String word : plaintextAsArrayOfWords) {
        for (int i = 0; i < word.length(); i++) {
        arrayOfCharacters.add(word.charAt(i));
        }
        }
        return arrayOfCharacters;
        }
