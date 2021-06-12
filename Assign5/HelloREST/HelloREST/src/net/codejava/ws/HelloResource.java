package net.codejava.ws;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.Uri;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 
@Path("/bonjour")

public class HelloResource {
 
	@GET
    @Path("/phone")
    @Produces(MediaType.APPLICATION_JSON)
    public java.util.List<Map<String, String>> getlist() {
    	
    	java.util.List<Map<String,String>> mymap1 = new ArrayList<Map<String, String>>();
    	
    	try{  
    		java.util.List<Map<String,String>> mymap = new ArrayList<Map<String, String>>();  
    		Map<String,String> obj1 = new HashMap<String,String>();
    	 
    		Class.forName("com.mysql.jdbc.Driver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/phone","root","");  
    		
    		Statement stmt=con.createStatement();  
    		ResultSet rs=stmt.executeQuery("select * from phonespecs;");  
    		
    		while(rs.next())
    		{
    		  Map<String,String>obj=new HashMap<String,String>();
    		 
      	      obj.put("name", rs.getString(1));
      	      obj.put("manufacturer", rs.getString(2));
      	      obj.put("price", String.valueOf(rs.getInt(3)));
      	      obj.put("ram", rs.getString(4));
      	      obj.put("processor", rs.getString(5));
      	      
      	      mymap.add(obj);
      	      System.out.println("obj "+obj);
      	   
    		}
      	      
      	    con.close(); 
      	    return mymap;
    		
    		}
    	
    	catch(Exception e){ 
    		System.out.println(e);

    		}
   	 return mymap1;
    }
}