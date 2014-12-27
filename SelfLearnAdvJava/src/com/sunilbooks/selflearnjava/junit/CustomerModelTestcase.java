package junit;

import org.junit.Test;

import com.sunilbooks.selflearnjava.jdbc.CustomerModel;

public class CustomerModelTestcase {

	@Test
	public void testAdd() throws Exception {
		CustomerModel cm = new CustomerModel();
		cm.setId(13);
		cm.setName("Ravi");
		cm.setCity("Indore");
		cm.add();
		System.out.println("Suucess : Test Add Success");

	}
	
	@Test
	public void testDelete() throws Exception {
		CustomerModel cm = new CustomerModel();
		cm.setId(8);
		System.out.println("Suucess : Test Delete Success");

	}

}
