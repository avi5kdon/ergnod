package com.javatpoint.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

@Path("/allWords")
public class GetAllWords {

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
	
	
	@GET
	@Path("/{param}")
	public Response getMean(@PathParam("param") String msg) throws Exception{
		String line= "dfdfdfd";
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/hames";
		String userName= "root";
		Connection con = DriverManager.getConnection(url,userName,userName);
		java.sql.PreparedStatement stmt = con.prepareStatement("Select meaning from definitions where word =?");
		stmt.setString(1, msg);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
		
			line = rs.getString(1);
		}
		
		return Response.status(200).entity(line).build();
	}
	
}
