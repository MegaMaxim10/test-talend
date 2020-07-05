package dimsoft.testtalend.app;

//import java.lang.reflect.InvocationTargetException;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
//import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import dimsoft.testtalend.app.api.DataController;
import dimsoft.testtalend.app.beans.TestStagiaire1;
import dimsoft.testtalend.app.beans.TestStagiaire2;
import dimsoft.testtalend.app.dao.TestStagiaire1Dao;
import dimsoft.testtalend.app.dao.TestStagiaire2Dao;
import dimsoft.testtalend.app.util.Util;
import io.dropwizard.Application;
//import io.dropwizard.cli.CheckCommand;
//import io.dropwizard.cli.Cli;
//import io.dropwizard.cli.ServerCommand;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
//import io.dropwizard.util.JarLocation;
//import io.dropwizard.views.ViewBundle;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;

public class TestTalendAPIApplication extends Application<TestTalendAPIConfiguration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestTalendAPIApplication.class);
	
	public static void main(final String[] args) throws Exception {
		new TestTalendAPIApplication().run(args);
	}
	
	private final HibernateBundle<TestTalendAPIConfiguration> hibernate = new HibernateBundle<TestTalendAPIConfiguration>(
				TestStagiaire1.class, TestStagiaire2.class){
		@Override
		public DataSourceFactory getDataSourceFactory(TestTalendAPIConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
		
		@Override
		protected Hibernate5Module createHibernate5Module() {
			Hibernate5Module module = super.createHibernate5Module();
			module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
			module.disable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
			return module;
		}
							
		/* @Override
		protected void configure(Configuration configuration) {
			super.configure(configuration);
			configuration.setProperty("hibernate.hbm2ddl.auto", "create");
		}*/        
	};

    @Override
    public String getName() {
        return "YopSongServer";
    }

    @Override
    public void initialize(final Bootstrap<TestTalendAPIConfiguration> bootstrap) {
    	bootstrap.addBundle(hibernate);
    	//bootstrap.addBundle(new ViewBundle<SendItServerConfiguration>());
    	//bootstrap.getObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX"));
     	//bootstrap.getObjectMapper().setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
    }

    @Override
    public void run(TestTalendAPIConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
    	LOGGER.info("Registering REST resources");
    	// init Swagger resources
    	initSwagger(configuration, environment);
    	// Enable CORS headers
	    final FilterRegistration.Dynamic cors =
	        environment.servlets().addFilter("CORS", CrossOriginFilter.class);

	    // Configure CORS parameters
	    cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
	    cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin," + Util.CLIENT_ID_KEY + "," + Util.TOKEN_KEY);
	    cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
	    //cors.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");

	    // Add URL mapping
	    cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
	    
	    final TestStagiaire1Dao testStagiaire1Dao = new TestStagiaire1Dao(hibernate.getSessionFactory());
	    final TestStagiaire2Dao testStagiaire2Dao = new TestStagiaire2Dao(hibernate.getSessionFactory());
	    
	    environment.jersey().register(MultiPartFeature.class); // pour les uploads
    	environment.jersey().register(new DataController(testStagiaire1Dao, testStagiaire2Dao));
    }

    private void initSwagger(TestTalendAPIConfiguration configuration, Environment environment) {
		environment.jersey().register(new ApiListingResource());
		environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

		BeanConfig config = new BeanConfig();
		config.setTitle("TestTalend API App");
		config.setVersion("0.0.1");
		config.setSchemes(new String[]{"http"});
        //config.setHost("localhost:8002");
        config.setBasePath("/api");
		config.setResourcePackage("dimsoft.testtalend.app.api");
		config.setScan(true);
	}
}
