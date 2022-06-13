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

    public int getdebt() {
        return debt;
    }
    public void charge(Double amount) {
        debt += amount;
    }

    public void paydebt(Double amount) {
        debt -= amount;
    }
    public String toString(){
        return "V"+","+this.getCardNumber() + "," + this.getExpmoth() + "," + this.getExpyear() + "," + this.getCvv() + "," + this.debt;
    }
}
