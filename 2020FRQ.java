public class 2020FRQ {
    //1a
    public static int hailstoneLength (int n) {
        int count = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            count++;
        }
        return count;
    }
    //1b
    public static boolean isLongSeq(int n) {
        return hailstoneLength(n) > n;
    }
    //1c
    public static double propLong(int n) {
        double count = 0;
        for (int i = 1; i <= n; i++) {
            if (isLongSeq(i)) 
                count = count + 1;
        }
        return count / (double) n;
    }
    //2
    public class GameSpinner {
        private int sections = 0;
        private int run = 0;
        private int lastSpin = -1;
        public GameSpinner (int n) {
            sections = n;
        }
        public int currentRun() {
            return run;
        }
        public int spin() {
            int spin = (int) (Math.random() * sections + 1);
            if (spin == lastSpin) {
                run++;
            } else {
                run = 1;
                lastSpin = spin;
            }
            return spin;
        }
    }
    //3a
    public void addReview (ProductReview prodReview) {
        reviewList.add(prodReview);
        boolean isNameIn = false;
        for (String s : productList) {
            if (s.equals(prodReview.getName()))
                isNameIn = true;
        }
        if (!isNameIn)
            productList.add(prodReview.getName());
    }
    //3b
    public int getNumGoodReviews(String prodName) {
        int count = 0;
        for (ProductReview p : productList) {
            if (p.getName().equals(prodName)) {
                if (p.getReview().indexOf("best") != -1) 
                    count++;
            }
        }
        return count;
    }
    //4a
    public class Theater {
        private Seat[][] theaterSeats;
        public Theater (int seatsPerRow, int tier1Rows, int tier2Rows) {
            theaterSeats = new int[tier1Rows + tier2Rows][seatsPerRow];
            for (int i = 0; i < tier1Rows; i++) {
                for (int j = 0; j < seatsPerRow; j++) {
                    theaterSeats[i][j] = new Seat(true, 1);
                }
            }
            for (int i = tier1Rows; i < tier1Rows + tier2Rows; i++) {
                for (int j = 0; j < seatsPerRow; j++) {
                    theaterSeats[i][j] = new Seat(true, 2);
                }
            }
        }
        //4b
        public boolean reassignSeat (int fromRow, int fromCol, int toRow, int toCol) {
            if (theaterSeats[fromRow][fromCol].getTier() <= theaterSeats[toRow][toCol].getTier() && theaterSeats[toRow][toCol].isAvailable()) {
                theaterSeats[fromRow][fromCol].setAvailability(true);
                theaterSeats[toRow][toCol].setAvailability(false);
                return true;
            }               
            return false; 
        }
    }
}
