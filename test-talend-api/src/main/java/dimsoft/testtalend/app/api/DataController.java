package dimsoft.testtalend.app.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.http.HttpStatus;

import dimsoft.testtalend.app.beans.TestStagiaire1;
import dimsoft.testtalend.app.beans.TestStagiaire2;
import dimsoft.testtalend.app.dao.TestStagiaire1Dao;
import dimsoft.testtalend.app.dao.TestStagiaire2Dao;
import dimsoft.testtalend.app.util.ErrorObject;
import dimsoft.testtalend.app.util.Util;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/data")
@Api(value = "/data")
@Produces(MediaType.APPLICATION_JSON)
public class DataController {
	private TestStagiaire1Dao testStagiaire1Dao;
	private TestStagiaire2Dao testStagiaire2Dao;

	public DataController(TestStagiaire1Dao testStagiaire1Dao, TestStagiaire2Dao testStagiaire2Dao) {
		this.testStagiaire1Dao = testStagiaire1Dao;
		this.testStagiaire2Dao = testStagiaire2Dao;
	}

	@GET
	@Path("/getteststagiaire1data")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Proprieté invalide") })
	@UnitOfWork
	public Response getTestStagiaire1Data(@Context HttpHeaders httpHeaders) {
		if(Util.isRequestValid(httpHeaders)){
			List<TestStagiaire1> dataList = testStagiaire1Dao.getTestStagiaire1Data();
			return Response.status(HttpStatus.OK_200).entity(dataList).build();
		}else{
			ErrorObject errorObject = new ErrorObject(403, "You are not allowed to access this service");
			return Response.status(HttpStatus.FORBIDDEN_403).entity(errorObject).build();
		}
	}
	
	@GET
	@Path("/getteststagiaire2data")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Proprieté invalide") })
	@UnitOfWork
	public Response getTestStagiaire2Data(@Context HttpHeaders httpHeaders) {
		if(Util.isRequestValid(httpHeaders)){
			List<TestStagiaire2> dataList = testStagiaire2Dao.getTestStagiaire2Data();
			return Response.status(HttpStatus.OK_200).entity(dataList).build();
		}else{
			ErrorObject errorObject = new ErrorObject(403, "You are not allowed to access this service");
			return Response.status(HttpStatus.FORBIDDEN_403).entity(errorObject).build();
		}
	}

}
