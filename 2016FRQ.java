public class 2016FRQ {
    //1a
    public class RandomStringChooser {
        private ArrayList<String> list = new ArrayList<String>();
        public RandomStringChooser (String[] arr) {
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
        }

        public String getNext() {
            int rand = (int) (Math.random() * list.size());
            if (list.size() > 0) 
                return list.remove(rand);
            return "NONE";
        }
    }
    //1b
    public class RandomLetterChooser extends RandomStringChooser {
        public RandomLetterChooser (String str) {
            super(getSingleLetters(str));
        }
    }
    //2a
    public class LogMessage {
        private String machineId;
        private String description;
        public LogMessage(String message) {
            int colonIndex = message.indexOf(":");
            machineId = message.substring(0, colonIndex);
            description = message.substring(colonIndex + 1, message.length());
        }
        //2b
        public boolean containsWord (String keyword) {
            int index = description.indexOf(keyword);
            if (index == -1) 
                return false;
            if (index != 0) {
                if (!description.substring(index-1, index).equals(" "))
                    return false;
            }
            if (index != description.length() - 1 - keyword.length()) {
                if (!description.substring(index + keyword.length(), index + keyword.length() + 1).equals(" "))
                    return false;
            }
            return true;
        }
    }
}