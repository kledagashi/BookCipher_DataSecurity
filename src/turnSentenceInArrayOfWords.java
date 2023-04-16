public ArrayList<String> turnSentenceInArrayOfWords(String plainText) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] array;
        array = plainText.split(" ");
        Collections.addAll(arrayList, array);
        return arrayList;
        }

