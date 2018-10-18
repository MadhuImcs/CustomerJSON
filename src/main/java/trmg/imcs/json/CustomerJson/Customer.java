package trmg.imcs.json.CustomerJson;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private String customerName;
	private int customerId;
	private Date dataOfBirth;
	private float anualSalary;
	private List<Address> address;
	private List<PaymentMethods> paymentMethods;
	
}
