package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CheckoutRecordEntry implements Serializable {
	private static final long serialVersionUID = 8309080721495266420L;
	private LocalDate checoutdate;
	private LocalDate duedate;
	
	public CheckoutRecordEntry(String checkoutmaxvalue) {
		Date input = new Date();
		//LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		this.checoutdate = LocalDate.now();
		this.duedate = checoutdate.plusDays(Integer.parseInt(checkoutmaxvalue));
	}
	
	public LocalDate getChecoutdate() {
		return checoutdate;
	}
	public LocalDate getDuedate() {
		return duedate;
	}
	
}
