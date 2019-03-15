
public class Transactions {
	String type;
	String amount;
	
	public Transactions(double deposit, String string) {
		this.type = string;
		this.amount = Double.toString(deposit);
	}
	
}
