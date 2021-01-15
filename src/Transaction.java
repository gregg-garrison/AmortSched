
import java.time.LocalDate;

public class Transaction {
	private Integer loanTransactionId;
	private Integer paymentNum;
	private Double interestPayment;
	private Double principalPayment;
	private Loan loan;
	private Double newBalance;
	private LocalDate paymentDate;

	public Transaction() {}

	public Transaction(Integer paymentNum, Double interestPayment, Double principalPayment, 
			Loan loan, Double newBalance,LocalDate paymentDate) {
		this.paymentNum = paymentNum;
		this.interestPayment = interestPayment;
		this.principalPayment = principalPayment;
		this.loan = loan;
		this.newBalance = newBalance;
		this.paymentDate = paymentDate;
	}

	public Transaction(Integer loanTransactionId, Integer paymentNum, Double interestPayment, Double principalPayment,
			Loan loan, Double newBalance, LocalDate paymentDate) {
		super();
		this.loanTransactionId = loanTransactionId;
		this.paymentNum = paymentNum;
		this.interestPayment = interestPayment;
		this.principalPayment = principalPayment;
		this.loan = loan;
		this.newBalance = newBalance;
		this.paymentDate = paymentDate;
	}

	public Integer getLoanTransactionId() {
		return loanTransactionId;
	}

	public void setLoanTransactionId(Integer loanTransactionId) {
		this.loanTransactionId = loanTransactionId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getNewBalance() {
		return newBalance;
	}

	public void setNewBalance(Double newBalance) {
		this.newBalance = newBalance;
	}

	public Integer getPaymentNum() {
		return paymentNum;
	}

	public void setPaymentNum(Integer paymentNum) {
		this.paymentNum = paymentNum;
	}

	public Double getInterestPayment() {
		return interestPayment;
	}

	public void setInterestPayment(Double interestPayment) {
		this.interestPayment = interestPayment;
	}

	public Double getPrincipalPayment() {
		return principalPayment;
	}

	public void setPrincipalPayment(Double principalPayment) {
		this.principalPayment = principalPayment;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	};
	
	public String toString() {
		String dt = this.getPaymentDate().toString();
		return String.format("%8d %10s %10.2f %10.2f %12.2f\n",this.getPaymentNum(),dt,this.getInterestPayment(),this.getPrincipalPayment(),this.getNewBalance());
	}
}
