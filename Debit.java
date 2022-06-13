public class Debit extends Card {
    private int ballance = 0;

    public Debit() {
        super();
    }
    public Debit(String cardNumber, int expmoth, int expyear, int cvv, int ballance) {
        super(cardNumber, expmoth, expyear, cvv);
        this.ballance = ballance;
    }

    
    /** 
     * Returns all of the information about the card, sepertated by commas, arrenged int the order of: type, number, expmoth, expyear, cvv
     * @return String
     */
    public String toString() {
        return "D"+","+this.getCardNumber() + "," + this.getExpmoth() + "," + this.getExpyear() + "," + this.getCvv() + "," + this.ballance;
    }

    
    /** 
     * checks if the card has enough money to pay the amount
     * @param amount
     * @return boolean
     */
    public boolean checkBallance(int amount) {
        return ballance >= amount;
    }

    
    /** 
     * removes the amount from the ballance
     * @param amount
     */
    public void transaction(int amount) {
        if (checkBallance(amount)) {
            ballance -= amount;
        }
    }
    
    /** 
     * @return int
     */
    public int getBallance() {
        return ballance;
    }
    
    /** 
     * deposits money into the ballance
     * @param amount
     */
    public void deposit(Double amount) {
        ballance += amount.intValue();
    }
}
