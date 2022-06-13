public class Visa extends Card {
    private int debt;

    public Visa(){
        super();
        debt = 0;
    }
    public Visa(String cardNumber, int expmoth, int expyear, int cvv, int debt) {
        super(cardNumber, expmoth, expyear, cvv);
        this.debt = debt;
    }

    
    /** 
     * @return int
     */
    public int getdebt() {
        return debt;
    }
    
    /** 
     * @param amount
     */
    public void charge(Double amount) {
        debt += amount;
    }

    
    /** 
     * @param amount
     */
    public void paydebt(Double amount) {
        debt -= amount;
    }
    
    /** 
     * returns all of the information about the card, sepertated by commas, arrenged int the order of: type, number, expmoth, expyear, cvv
     * @return String
     */
    public String toString(){
        return "V"+","+this.getCardNumber() + "," + this.getExpmoth() + "," + this.getExpyear() + "," + this.getCvv() + "," + this.debt;
    }
}
