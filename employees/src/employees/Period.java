package employees;

import java.time.LocalDate;
import java.util.Arrays;

public class Period {
	private LocalDate dateFrom;
	private LocalDate dateTo;

	public Period(String dateFrom, String dateTo) {
		setDateFrom(dateFrom);
		setDateTo(dateTo);
	}

	private void setDateFrom(String dateFrom) {
		this.dateFrom = setDate(dateFrom);
	}

	private void setDateTo(String dateToStr) {
		if ("NULL".equals(dateToStr)) {
			this.dateTo = LocalDate.now();
			return;
		}
		LocalDate date = setDate(dateToStr);
		if (this.dateFrom.compareTo(date) > 0) {
			throw new IllegalArgumentException("Cannot set date earlier than the beginning date " + dateFrom);
		}
		this.dateTo = date;
	}

	private LocalDate setDate(String date) {
		int[] tokens = Arrays.stream(date.split("-")).mapToInt(Integer::parseInt).toArray();
		int year = tokens[0];
		int month = tokens[1];
		int dayOfMonth = tokens[2];
		return LocalDate.of(year, month, dayOfMonth);
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	@Override
	public String toString() {
		return String.format("%s %s", dateFrom, dateTo);
	}
}
