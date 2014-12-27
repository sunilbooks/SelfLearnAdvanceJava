package junit;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.sunilbooks.selflearnjava.jdbc.CustomerModel;

public class CustomerModelTestcase {

	@Ignore
	public void testAdd() throws Exception {

		CustomerModel cm = new CustomerModel();
		cm.setId(13);
		cm.setName("Ravi");
		cm.setCity("Indore");
		cm.add();
		
		CustomerModel newCm = cm.findByPk();

		assertNotNull("Error : Customer Add Fail", cm);
	}

	@Ignore
	public void testUpdate() throws Exception {

		CustomerModel cm = new CustomerModel();
		cm.setId(13);
		cm.setName("Ravi");
		cm.setCity("Bhopal");
		cm.update();

		CustomerModel newCm = cm.findByPk();

		assertEquals("Error : Test Update Fail", cm.getId(), newCm.getId());

		System.out.println("Success : Test Update Success");
	}

	@Ignore
	public void testDelete() throws Exception {
		CustomerModel cm = new CustomerModel();
		cm.setId(8);
		cm.delete();

		System.out.println("Suucess : Test Delete Success");

	}

	@Ignore
	public void testFindByPk() throws Exception {

		CustomerModel cm = new CustomerModel();
		cm.setId(9);
		cm = cm.findByPk();

		assertNotNull("Error : Test Get Id Fail", cm);

		System.out.println(cm.getName());
		System.out.println(cm.getCity());

	}

	@Ignore
	public void testFindByName() throws Exception {

		CustomerModel cm = new CustomerModel();
		cm.setName("Pankaj");
		cm = cm.findByName();

		assertNotNull("Error : Test Get By Name Fail", cm);

		System.out.println("Success : Test Get Success");

		System.out.println(cm.getName());
		System.out.println(cm.getCity());

	}

	@Ignore
	public void testListSearch() throws Exception {
		CustomerModel cm = new CustomerModel();

		List list = cm.search();

		assertTrue("Error : Test Search Fail", list.size() > 0);

		System.out.println("Suucess : Test List Search ");

		Iterator it = list.iterator();
		while (it.hasNext()) {
			CustomerModel NewCm = (CustomerModel) it.next();
			System.out.print(NewCm.getId());
			System.out.print("\t" + NewCm.getName());
			System.out.println("\t" + NewCm.getCity());
		}
	}

	@Ignore
	public void testListSearchByName() throws Exception {
		CustomerModel cm = new CustomerModel();

		cm.setName("Pankaj");
		List list = cm.search(cm);

		assertTrue("Error : Test Search Fail", list.size() > 0);

		System.out.println("Suucess : Test List Search By Name ");

		Iterator it = list.iterator();
		while (it.hasNext()) {
			CustomerModel NewCm = (CustomerModel) it.next();
			System.out.print(NewCm.getId());
			System.out.print("\t" + NewCm.getName());
			System.out.println("\t" + NewCm.getCity());
		}
	}

	@Test
	public void testListSearchByPageSize() throws Exception {
		CustomerModel cm = new CustomerModel();

		List list = cm.search(1, 5);

		assertTrue("Error : Test Search Fail", list.size() > 0);

		System.out.println("Suucess : Test List Search By PageNo, PageSize ");

		Iterator it = list.iterator();
		while (it.hasNext()) {
			CustomerModel NewCm = (CustomerModel) it.next();
			System.out.print(NewCm.getId());
			System.out.print("\t" + NewCm.getName());
			System.out.println("\t" + NewCm.getCity());
		}
	}

}
