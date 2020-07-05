package dimsoft.testtalend.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import dimsoft.testtalend.app.beans.TestStagiaire2;
import io.dropwizard.hibernate.AbstractDAO;

public class TestStagiaire2Dao extends AbstractDAO<TestStagiaire2> {

	public TestStagiaire2Dao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public List<TestStagiaire2> getTestStagiaire2Data() {
		@SuppressWarnings("unchecked")
		List<TestStagiaire2> listOfData = this.list(namedQuery("TestStagiaire2.findAll"));
		return listOfData;
	}
	
}
