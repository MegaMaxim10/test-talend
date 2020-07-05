package dimsoft.testtalend.app;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import io.dropwizard.db.DataSourceFactory;

public class TestTalendAPIConfiguration extends Configuration {
	@NotEmpty
	@JsonProperty
	private String defaultName = "testtalendapi";

	public String getDefaultName() {
		return defaultName;
	}

	@NotNull
	private String login;
	
    @NotNull
    private String password;
    
    @JsonProperty
	public String getLogin() {
		return login;
	}

	@JsonProperty
	public String getPassword() {
		return password;
	}
	
	@Valid
	@NotNull
	private DataSourceFactory database = new DataSourceFactory();

	@JsonProperty("database")
	public DataSourceFactory getDataSourceFactory() {
		return database;
	}
	
	public void setDataSourceFactory(DataSourceFactory f) {
		 database = f;
	}
}
