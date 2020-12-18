package Fidentity_pages;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.testng.Assert;
import org.testng.annotations.Test;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

@Test
public class Notification_Test  extends DataBase_connection{
	
	
	String sms_gatepass_notification="Dear Sridevi, Sridevi Maddipati from zenwork has generated a visitor pass for a meeting on 03 Oct 2019, 6:00 PM .";
	String sms_delete_gatepass="Hi Sridevi, Your scheduled meeting on 03 Oct 2019 with Sridevi Maddipati from zenwork has been cancelled.";
	String sms_resend_gatepass="Dear Sridevi, Sridevi Maddipati from zenwork has generated a visitor pass for a meeting on 03 Oct 2019 . Your code is #1200. You can view your gatepass details here http://bit.ly/2o6W6eQ .";
	String sms_add_participant="Dear Helcy, Congrats! Participation for &#039;Test2&#039; on &#039;26 Sep 2019, 4:00 PM&#039; is confirmed. Your check-in ID: &#039;1000003&#039; . Invitation can be viewed at http://bit.ly/2mQvsWy";
	@Test(enabled=false)
public void gate_pass_notification() throws SQLException, ClassNotFoundException {
			
		 try {
			    HttpResponse<JsonNode> response = Unirest.post("https://test-s175.fidentity.com/api/generate_gatepass.php")
			            .header("Authorization", "767125f261bf035e7d34d80aed311068")
		 .field("country_code", "91")
		 .field("contact", "1254678912")
		 .field("visitor_name", "Sridevi")
		 .field("email_id", "sridevi@zenwork.com")
		 .field("gender", "female")
		 .field("checkin_type", "Visitor")
		 .field("id_card_type", "")
		 .field("designation", "")
		 .field("coming_from", "QA")
		 .field("pass_date", " 2019-10-03")
		 .field("pass_date_submit", " 2019-10-03")
		 .field("pass_time", "18:00")
		 .field("passType", "general").asJson();
			    System.out.println("statusCode = " + response.getStatus());
			    System.out.println("body = " + response.getBody());
			 
			} catch (UnirestException e) {
			    e.printStackTrace();
			}
		
	//String sms_notification="Dear Sridevi, Sridevi Maddipati from zenwork has generated a visitor pass for a meeting on 03 Oct 2019, 4:00 PM .";
	
			
			/* -----Notification need to develop
			 "Dear Sridevi,\r\n" + 
			"You have been invited to a meeting with @employee_name at @company_name \r\n" + 
			"This meeting is set for @date_and_time\r\n" + 
			"PLease use the access code #____ to login at the door. \r\n" + 
			"When signing in at the business you will be asked to sign a NDA. Here is a copy of the NDA if you would like to review prior to your visit. \r\n" + 
			"@image_link";  ------*/
	
		 DataBase_connection db=new DataBase_connection();
		 db.dbconnection();
		ResultSet rs=stmt.executeQuery("select message from test_checkon_central.sms_notification_tracker"
				+ " where source_type='gate_pass' and phone_number='1254678912'");
		
		 while (rs.next()){
				String code=rs.getString(1);
			System.out.println(code);
			
			/*if(code==sms_notification) {
				System.out.print("correct gatepass recieved by vivistor");
			}else {System.out.print("wrong sms recieved by visitor");}*/
			
			Assert.assertEquals(true,code.contains(sms_gatepass_notification));
			System.out.println("recieved correct genearte gatepass sms");
		 }
	
	}
	@Test(enabled=false)
	public void Cancel_gatepass() throws ClassNotFoundException, SQLException {
		
		
			try {
			    HttpResponse<JsonNode> response = Unirest.post("https://test-s175.fidentity.com/api/delete_gate_pass.php")
			            .header("Authorization", "767125f261bf035e7d34d80aed311068")
		 .field("phone", "1254678944")
		 .field("gate_pass", "8669")
		.asJson();
			    System.out.println("statusCode = " + response.getStatus());
			    System.out.println("body = " + response.getBody());
			 
			} catch (UnirestException e) {
			    e.printStackTrace();
			}	
			
			 DataBase_connection db=new DataBase_connection();
			 db.dbconnection();
			ResultSet rs=stmt.executeQuery("select message from test_checkon_central.sms_notification_tracker"
					+ " where source_type='delete_gate_pass' and phone_number='1254678944'");
			
			 while (rs.next()){
					String code=rs.getString(1);
				System.out.println(code);
				
				
				Assert.assertEquals(true,code.contains(sms_delete_gatepass));
				System.out.println("recieved correct delete gatepass sms");
			 }
		
		}	
	@Test(enabled=false)
	public void Resend_gatepass() throws ClassNotFoundException, SQLException {
		try {
		    HttpResponse<JsonNode> response = Unirest.post("https://test-s175.fidentity.com/api/send_gate_pass_sms.php")
		            .header("Authorization", "767125f261bf035e7d34d80aed311068")
	 .field("pass_token", "1c5ff7fdcf731b243b92a7c77cbb903d")
	 //this token from db table test_vms_gatepass
	
	.asJson();
		    System.out.println("statusCode = " + response.getStatus());
		    System.out.println("body = " + response.getBody());
		 
		} catch (UnirestException e) {
		    e.printStackTrace();
		}	
		 DataBase_connection db=new DataBase_connection();
		 db.dbconnection();
		 
		ResultSet rs=stmt.executeQuery("select message from test_checkon_central.sms_notification_tracker"
				+ " where source_type='resend_gate_pass' and phone_number='1254678945'");
		
		 while (rs.next()){
				String code=rs.getString(1);
			System.out.println(code);
			
			
			Assert.assertEquals(true,code.contains(sms_resend_gatepass));
			System.out.println("recieved correct resend gatepass sms");
		 }
		
	}
	@Test(enabled=false)
	public void Add_participant() throws ClassNotFoundException, SQLException {
		
		try {
		    HttpResponse<JsonNode> response = Unirest.post("https://test-s175.fidentity.com/api/delete_gate_pass.php")
		            .header("Authorization", "767125f261bf035e7d34d80aed311068")
	 .field("first_name", "Helcy")
	 .field("middle_name", "")
	 .field("last_name", "")
	 .field("country_code", "91")
	 .field("phone_number", "5236456325")
	 .field("email", "sridevi@zenwork.com")
	 .field("event_token", "389ce429f44b8139e5dd9819c7e1decf")
	 .field("event_id", "EVT5d97089621587")
	.asJson();
		    System.out.println("statusCode = " + response.getStatus());
		    System.out.println("body = " + response.getBody());
		 
		} catch (UnirestException e) {
		    e.printStackTrace();
		}	
		 DataBase_connection db=new DataBase_connection();
		 db.dbconnection();
		 
		ResultSet rs=stmt.executeQuery("select message from test_checkon_central.sms_notification_tracker"
				+ " where source_type='Adding Participant' and phone_number='5236456325'");
		
		 while (rs.next()){
				String code=rs.getString(1);
			System.out.println(code);
			
			//	Assert.assertEquals(true,code.contains(sms_add_participant));
			System.out.println("recieved correct add participant sms");
		 }
		
	 
	}
	@Test(enabled=false)
	public void backlogitems() {
		
	}
		
}

		
	


