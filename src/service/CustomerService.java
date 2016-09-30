package service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.Customer;

public class CustomerService {
	
	private Map<String,Customer> customers;
	
	private static final CustomerService instance = new CustomerService();

	private CustomerService(){
		
		customers = new HashMap<String,Customer>();
		
	}
	
	public static CustomerService getInstance(){
		
		return instance;
	}

public void addCustomer(Customer customer){
	customers.put(customer.getId(),customer);
	
}

public Customer findCustomer(String id){
	
	if( id!=null)
		return (customers.get(id.toLowerCase()));
	else
		return null; 
	
}

public Customer login(String id, String password){
	
	// HashMap�� ���Ե� Key , Value�� Set�� ��� iterator�� ���� Set ������ ��� �ش�.  
Set <Entry<String, Customer>>set = customers.entrySet();
Iterator<Entry<String,Customer>> it = set.iterator();
//HashMap�� ���Ե� key, value ���� ȣ�� �Ѵ�. 
while(it.hasNext()){
	Map.Entry<String, Customer> e = (Map.Entry<String, Customer>)it.next();
	if(e.getKey().equals(id) ){
		//id������
		if( e.getValue().getPassword().equals(password)){
			return customers.get(id.toLowerCase());
		}
		//id���� ��� �ٸ���  
		break;
	}
}
	return null;
}


}
