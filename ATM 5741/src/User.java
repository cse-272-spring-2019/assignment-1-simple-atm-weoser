
public class User {
	double initialBalance;
	Transactions[] trans = new Transactions[100];
	public int count = 0;
	public User(double initialBalance) {
		this.initialBalance = initialBalance;
	}
	
	void setBalance(double newBalance) {
		initialBalance = newBalance;
	}
	
	void getBalance() {
		trans[count] = new Transactions(initialBalance, "Balance");
		if(count == 5) {
			for(int i=0;i<4;i++){
			trans[i]=trans[i+1];}
			trans[4]=trans[count] = new Transactions(initialBalance, "Balance");
		}
		else
				count++;
	}
	
	void deposit(String deposit2) {
		double deposit = Double.parseDouble(deposit2);
		initialBalance += deposit;
		System.out.println(initialBalance);
		trans[count] = new Transactions(deposit, "Deposited");
		if(count == 5) {
			for(int i=0;i<4;i++){
			trans[i]=trans[i+1];}
			trans[4]=trans[count] = new Transactions(deposit, "Deposited");
		}
		else
		count++;
	}
	
	void withdrawal(String an) {
		double withdrawal = Double.parseDouble(an);
		if (withdrawal > initialBalance)
			Alerts.display("Error", "Insufficient funds.");
		else
		{initialBalance -= withdrawal;
		trans[count] = new Transactions(withdrawal, "Withdrew");
		if(count == 5) {
			for(int i=0;i<4;i++){
			trans[i]=trans[i+1];}
			trans[4]=trans[count] = new Transactions(withdrawal, "Withdrew");
		}
		else
		count++;}
		System.out.println(initialBalance);
	}
	

}

