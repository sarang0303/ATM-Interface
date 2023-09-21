package atm_interface;

import java.time.LocalDateTime;

public class Transaction {
	
	 public enum TransactionType {
	        WITHDRAW, DEPOSIT, TRANSFER
	    }

	    private TransactionType type;
	    private double amount;
	    private LocalDateTime dateTime;
	    

	    public Transaction(TransactionType type, double amount) {
	        this.setType(type);
	        this.setAmount(amount);
	        this.setDateTime(LocalDateTime.now());
	    }


		public double getAmount() {
			return amount;
		}


		public void setAmount(double amount) {
			this.amount = amount;
		}


		public TransactionType getType() {
			return type;
		}


		public void setType(TransactionType type) {
			this.type = type;
		}


		public LocalDateTime getDateTime() {
			return dateTime;
		}


		public void setDateTime(LocalDateTime dateTime) {
			this.dateTime = dateTime;
		}


		public String getTransactionType() {
			// TODO Auto-generated method stub
			return null;
		}

}
