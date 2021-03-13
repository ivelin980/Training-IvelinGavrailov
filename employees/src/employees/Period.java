package employees;

import java.time.LocalDate;
import java.util.Arrays;

public class Period {
	private LocalDate dateFrom;
	private LocalDate dateTo;
	
	public Period(String dateFrom,String dateTo) {
		setDateFrom(dateFrom);
		setDateTo(dateTo);
	}
	
	private void setDateFrom(String dateFrom) {
		int[] tokens = Arrays.stream(dateFrom.split("-")).mapToInt(Integer::parseInt).toArray();
		int year = tokens[0];
		int month = tokens[1];
		int dayOfMonth = tokens[2];
		this.dateFrom = LocalDate.of(year, month, dayOfMonth);
	}
	
	private void setDateTo(String dateToStr) {
		if("NULL".equals(dateToStr)) {
			this.dateTo = LocalDate.now();
			return;
		}
		int[] tokens = Arrays.stream(dateToStr.split("-")).mapToInt(Integer::parseInt).toArray();
		int year = tokens[0];
		int month = tokens[1];
		int dayOfMonth = tokens[2];
		LocalDate date = LocalDate.of(year, month, dayOfMonth);
		if(this.dateFrom.compareTo(date)>0) {
			throw new IllegalArgumentException("Cannot set date earlier than the beginning date " + dateFrom);
		}
		this.dateTo = date;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s",dateFrom,dateTo);
	}
}
