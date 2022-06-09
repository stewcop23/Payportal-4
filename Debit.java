public class Debit extends Card {
    private int ballance = 0;

    public Debit() {
        super();
    }
    public Debit(String cardNumber, int expmoth, int expyear, int cvv, int ballance) {
        super(cardNumber, expmoth, expyear, cvv);
        this.ballance = ballance;
    }

    public String toString() {
        return "D"+","+this.getCardNumber() + "," + this.getExpmoth() + "," + this.getExpyear() + "," + this.getCvv() + "," + this.ballance;
    }

    public boolean checkBallance(int amount) {
        return ballance >= amount;
    }

    public void transaction(int amount) {
        if (checkBallance(amount)) {
            ballance -= amount;
        }
    }
    public int getBallance() {
        return ballance;
    }
}
