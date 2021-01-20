
import java.time.LocalDate;

public class Transaction {
	private Integer loanTransactionId;
	private Integer paymentNum;
	private Double interestPayment;
	private Double principalPayment;
	private Loan loan;
	private Double newBalance;
	private LocalDate paymentDate;
	private Double pmi;
	private Double appraisal;
	private Double ltv;
	public Transaction() {}

	public Transaction(Integer paymentNum, Double interestPayment, Double principalPayment, 
			Loan loan, Double newBalance,LocalDate paymentDate, Double pmi, Double appraisal, Double ltv) {
		this.paymentNum = paymentNum;
		this.interestPayment = interestPayment;
		this.principalPayment = principalPayment;
		this.loan = loan;
		this.newBalance = newBalance;
		this.paymentDate = paymentDate;
		this.pmi = pmi;
		this.appraisal = appraisal;
		this.ltv = ltv;
	}

	public Transaction(Integer loanTransactionId, Integer paymentNum, Double interestPayment, Double principalPayment,
			Loan loan, Double newBalance, LocalDate paymentDate, Double pmi) {
		super();
		this.loanTransactionId = loanTransactionId;
		this.paymentNum = paymentNum;
		this.interestPayment = interestPayment;
		this.principalPayment = principalPayment;
		this.loan = loan;
		this.newBalance = newBalance;
		this.paymentDate = paymentDate;
		this.pmi = pmi;
	}

	
	
	public Double getLtv() {
		return ltv;
	}

	public void setLtv(Double ltv) {
		this.ltv = ltv;
	}

	public Double getAppraisal() {
		return appraisal;
	}

	public void setAppraisal(Double appraisal) {
		this.appraisal = appraisal;
	}

	public Double getPmi() {
		return pmi;
	}

	public void setPmi(Double pmi) {
		this.pmi = pmi;
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
		return String.format("%-8d %10s %10.2f %10.2f %10.2f %12.2f %12.2f %10.2f\n",this.getPaymentNum(),dt,this.getInterestPayment(),this.getPrincipalPayment(),this.getPmi(),this.getNewBalance(),this.getAppraisal(),this.getLtv());
	}
}
