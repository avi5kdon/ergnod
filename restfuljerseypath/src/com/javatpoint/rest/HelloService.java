package com.javatpoint.rest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
@Path("/getWord")
public class HelloService{
 	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/hames";
		String userName= "root";
		Connection con = DriverManager.getConnection(url,userName,userName);
		java.sql.PreparedStatement stmt = con.prepareStatement("Select meaning from definitions where word = ?");
		stmt.setString(1, msg);
		ResultSet rs = stmt.executeQuery();
		String def = "This Word Is not Available";
		while(rs.next()){
			def = rs.getString(1);
		}
		
		if(def.equals("This Word Is not Available")){
			
		}
		return Response.status(200).entity(def).build();  

	}
 	
 	
	@GET
	@Path("/add/{param1}/{param2}")
	public Response addWord(@PathParam("param1") String msg,@PathParam("param2") String mdsg) throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/hames";
		String userName= "root";
		Connection con = DriverManager.getConnection(url,userName,userName);
		java.sql.PreparedStatement stmt = con.prepareStatement("insert into definitions(Word,Meaning,Hindi) values(?,?,'')");
		stmt.setString(1, msg);
		stmt.setString(2, mdsg);
		int num = stmt.executeUpdate();
		
		if(num != 0){
			return Response.status(200).entity("Word Successfully Inserted").build(); 
		}
		return Response.status(200).entity("Error Occured").build();  

	}
 	
 	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllWords() throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/hames";
		String userName= "root";
		Connection con = DriverManager.getConnection(url,userName,userName);
		java.sql.PreparedStatement stmt = con.prepareStatement("Select word,meaning from definitions");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			map.put(rs.getString(1), rs.getString(2));
			
		}
		JSONObject json = new JSONObject(map);
		String jsonString = json.toJSONString();
		return Response.status(200).entity(jsonString).build();
	}
	
}