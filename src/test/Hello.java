package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/hello")
public class Hello {

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHello() {
		String resource = "<? xml version='1.0' ?>" + "<hello> Hi Joshua, this is Hello from XML</hello>";
		return resource;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJASON() {
		String resource = null;
		return resource;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHTML(@QueryParam("name") String name, @QueryParam("cardNo") String cardNo, @QueryParam("amount") int amount) {
		System.out.println("Name is " + name);
		System.out.println("Amount is " + amount);
		String response;
		
		if (amount > 1000) {
			System.out.println("Amount is greater than 1 thousand");
			response = "Credit card is not approved";
		} else {
			System.out.println("Amount is less than 1 thousand");
			response = "Credit card is approved";
		}
		return "<html>" + "<body><h1>" + "Credit card is authorized to " + name + " Card No. is " + cardNo + " Amount is " + amount + " " + response + "</h1></body>" + "</html>";
	}
}
