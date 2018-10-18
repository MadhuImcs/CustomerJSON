package trmg.imcs.json.CustomerJson.parser;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import trmg.imcs.json.CustomerJson.Address;
import trmg.imcs.json.CustomerJson.CARDTYPE;
import trmg.imcs.json.CustomerJson.Customer;
import trmg.imcs.json.CustomerJson.PaymentMethods;


 
 
public class JacksonObjectMapperExample {
 
	private static String FILE_PATH = "C:\\Users\\User\\Videos\\IMCS Training\\CustomerJson\\src\\main\\java\\resources\\customer.json";
	
    public static void main(String[] args) throws IOException {
    //serialize();
	deserialize();
    }
    

	@SuppressWarnings("deprecation")
	private static void serialize() throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //convert Object to json string
        Customer customer = new Customer();
        customer.setCustomerId(101);
        customer.setCustomerName("Madhu");
        customer.setAnualSalary(10000.0f);
        customer.setDataOfBirth(new Date(2019,20,19));
        List<Address> laddress = new ArrayList<>();
        laddress.add(new Address("love dr","irving","texas",20101));
        laddress.add(new Address("royal ln","dallas","texas",62627));
        List<PaymentMethods> payments = new ArrayList<>();
        payments.add(new PaymentMethods(20101, "MADHU", new Date(2019,20,19), "EXP", CARDTYPE.DEBITCARD));
        payments.add(new PaymentMethods(28328, "KIRAN", new Date(2019,20,19), "EXP", CARDTYPE.CREDITCARD));
        
        customer.setAddress(laddress);
        customer.setPaymentMethods(payments);
        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
         
        //writing to console, can write to any output stream such as file
        objectMapper.writeValue(System.out, customer);
        objectMapper.writeValue(new PrintWriter("C:\\\\Users\\\\User\\\\Videos\\\\IMCS Training\\\\CustomerJson\\\\src\\\\main\\\\java\\\\resources\\\\customer.json"), customer);
	}

	public static void deserialize() throws IOException {
         
        //read json file data to String
        byte[] jsonData = Files.readAllBytes(Paths.get(FILE_PATH));
         
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
         
        //convert json string to object
        Customer customer = objectMapper.readValue(jsonData, Customer.class);
         
        System.out.println("Customer Object\n"+customer);
    }

	
    


	
 
}