package trmg.imcs.json.CustomerJson;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethods {
	private int cardNumber;
	private String cardName; 
	private Date dateFrom;
	private String dateType;
	private CARDTYPE cardType;
	
}
