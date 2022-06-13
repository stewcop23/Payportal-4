public class Card {
    private String cardNumber;
    private int expmoth,expyear,cvv;


    public Card() {
        cardNumber = "";
        for (int i = 0; i < 16; i++) {
            cardNumber += (int) (Math.random() * 10);
        }
        expmoth = (int) (Math.random() * 12 + 1);
        expyear = (int) (Math.random() * 10 + 2023);
        cvv = (int) (Math.random() * 999 + 1);

    }
    public Card(String cardNumber, int expmoth, int expyear, int cvv) {
        this.cardNumber = cardNumber;
        this.expmoth = expmoth;
        this.expyear = expyear;
        this.cvv = cvv;
    }

    
    /** 
     * @return String
     */
    public String getCardNumber() {
        return this.cardNumber;
    }


    
    /** 
     * @return int
     */
    public int getExpmoth() {
        return this.expmoth;
    }
    
    /** 
     * Returns all of the information about the card, sepertated by commas, arrenged int the order of: number, expmoth, expyear, cvv
     * @return String
     */
    public String toString(){
        return this.cardNumber + "," + this.expmoth + "," + this.expyear + "," + this.cvv;
    }


    
    /** 
     * @return int
     */
    public int getExpyear() {
        return this.expyear;
    }
    
    /** 
     * @return int
     */
    public int getCvv() {
        return this.cvv;
    }



}
