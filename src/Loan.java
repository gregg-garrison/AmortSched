import java.util.*;

public class Loan {
	private Integer id;
	private Double initialValue;
	private Double rate;
	private Integer term;
	private Double payment;
	private Date startDate;
	private Date endDate;
	private Double balance;
	private Double appraisal;
	private Double pmi;
	private List<Transaction> schedule;
	
	public Loan() {}

	public Loan(Integer id, Double initialValue, Double rate, Integer term, Date startDate, Double appraisal) {
		this.id = id;
		this.initialValue = initialValue;
		this.rate = rate;
		this.term = term;
		this.startDate = startDate;
		this.appraisal = appraisal;
	}

	public Double getPmi() {
		return pmi;
	}

	public void setPmi(Double pmi) {
		this.pmi = pmi;
	}

	public Double getAppraisal() {
		return appraisal;
	}

	public void setAppraisal(Double appraisal) {
		this.appraisal = appraisal;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(Double initialValue) {
		this.initialValue = initialValue;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Transaction> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Transaction> schedule) {
		this.schedule = schedule;
	};
}
