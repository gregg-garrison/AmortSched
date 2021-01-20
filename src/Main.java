import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) throws IOException, ParseException{
		
		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String dateStr = "03/22/2018";
		Date startDate = sdf.parse(dateStr);
		Date today = new Date();
		LocalDate localStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		Loan loan1 = new Loan(1,200000.0,0.05,360,today, 200000.0);
		Double principleInterestPayment = monthlyPayment(loan1.getInitialValue(),loan1.getRate()/12,loan1.getTerm());
		Double pmi = getPmi(loan1);		
		loan1.setPmi(pmi);
		loan1.setPayment(principleInterestPayment);
		Integer months = countNumOfMonths(localStartDate);
		List<Transaction> amort = getAmortSchedule(loan1);
		Transaction trans = getCurrentStatement(amort,months);
		Double currentBalance = trans.getNewBalance();
		loan1.setBalance(currentBalance);
		
		System.out.printf("%-8s %10s %10s %10s %10s %12s %12s %10s\n","Pmt#", "Pmt Date","Int Pmt", "Prin Pmt", "PMI", "Balance","AppraisalValue","LTV");
		loan1.setSchedule(amort);
		amort.forEach(System.out::print);
		
//		for(Transaction t:amort) {
//			if(t.getPaymentNum()%12 == 0) {
//				System.out.println("pmtNum: "+t.getPaymentNum());
//			}
//		}
		
	}
	
	//*****HELPER FUNCTIONS BELOW*******
	
	
	public static Double appraisalIncrease(Loan loan) {
		double appraisal = loan.getAppraisal();
		List<Transaction> amort = loan.getSchedule();
		for(Transaction t:amort) {
			if(t.getPaymentNum() % 12 == 0) {
				appraisal = appraisal * 1.03;
				loan.setAppraisal(appraisal);
			}
		}
		return appraisal;
	}
	
	public static Double getPmi(Loan loan) {
		Double initialValue = loan.getInitialValue();
		Double annualPmiPremium = .006;
		Double monthly = annualPmiPremium/12;
		Double pmi;
		if(pmiCheck(loan.getInitialValue(),loan.getAppraisal())) {
			pmi = initialValue * monthly;
		}else {
			pmi = 0.0;
		}
		return pmi;
	}
	
	
	public static Boolean pmiCheck(Double balance, Double appraisal) {
		return (balance/appraisal) >= .8 ? true : false;
	}
	
	public static Transaction getCurrentStatement(List<Transaction> amort,Integer pmtNum) {
		Transaction trans = new Transaction();
		for(Transaction t:amort) {
			if(t.getPaymentNum() == pmtNum) {
				trans = t;
			}
		}
		return trans;
	}
	
	public static Integer countNumOfMonths(LocalDate startDate) {
		Date now = new Date();
		LocalDate current = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Long monthsLong = ChronoUnit.MONTHS.between(startDate.withDayOfMonth(1),current.withDayOfMonth(1));
		Integer months = monthsLong.intValue();
		return months;
	}
	
	public static List<Transaction> getAmortSchedule(Loan loan){
		List<Transaction> list = new ArrayList<>();
		Transaction trans = new Transaction();
		double appraisalValue = loan.getAppraisal();
		double principal = loan.getInitialValue();
		double apr = loan.getRate();
		int term = loan.getTerm();
		int paymentNum;
		double payment = loan.getPayment();
		double interestPayment, principalPayment, newBalance;
		double ppmi = loan.getPmi();
		Date startDate = loan.getStartDate();
		LocalDate date = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int dayMonth = date.getDayOfMonth();
		double pmi;
		for(int i=1;i<=term;i++) {
			paymentNum = i;
			if(paymentNum % 12==0) {
				appraisalValue = appraisalValue * 1.03;
				loan.setAppraisal(appraisalValue);
			}
			LocalDate pmtDate = next(date,dayMonth);
			double ltv = principal/appraisalValue;
			if(ltv >= 0.8) {
				pmi = ppmi;
			}else {
				pmi = 0.0;
			}
			interestPayment = principal * (apr/12);
			principalPayment = payment - interestPayment;
			newBalance = principal - principalPayment;
			principal = newBalance;
			trans = new Transaction(paymentNum,interestPayment,principalPayment,loan,newBalance,pmtDate,pmi,appraisalValue,ltv);
			list.add(trans);
			
			loan.setBalance(newBalance);
			date = pmtDate;
		}
		return list;
	}
	
	public static LocalDate next(LocalDate current, int selectedDayOfMonth) {
		LocalDate next = current.plusMonths(1);
		return next.withDayOfMonth(Math.min(selectedDayOfMonth, next.lengthOfMonth()));
	}
	
	static double monthlyPayment(double loanAmount, double monthlyInterestRate, int term) {
		return loanAmount * monthlyInterestRate /
				(1 - 1 / Math.pow(1 + monthlyInterestRate, term));
	}
}
