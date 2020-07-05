package dimsoft.testtalend.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import dimsoft.testtalend.app.beans.TestStagiaire1;
import io.dropwizard.hibernate.AbstractDAO;

public class TestStagiaire1Dao extends AbstractDAO<TestStagiaire1> {

	public TestStagiaire1Dao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<TestStagiaire1> getTestStagiaire1Data() {
		List<TestStagiaire1> listOfData = this.list(this.query("SELECT s FROM TestStagiaire1 s"));
		return listOfData;
	}
	
}
