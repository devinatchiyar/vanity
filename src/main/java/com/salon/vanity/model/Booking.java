package com.salon.vanity.model;

public class Booking {
   private String username;
   private String name;
   private String phoneNumber;
   private String date;
   private String slot;
   private String service;
   
   public void setName(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }
   
   public void setService(String service) {
	      this.service = name;
   }
   public String getService() {
	      return service;
   }
   
   public void setPhoneNumber(String phoneNumber) {
	      this.phoneNumber = phoneNumber;
   }
   public String getPhoneNumber() {
	      return phoneNumber;
   }
   
   public void setDate(String date) {
		  this.date = date;
   }
   public String getDate() {
		  return date;
   }
   
   public void setSlot(String slot) {
      this.slot = slot;
   }
   public String getSlot() {
      return slot;
   }
   
   public void setUserName(String username) {
	  this.username = username;
   }
   public String getUserName() {
	  return username;
   }
	   
   public Booking(String username, String service, String name, String phone, String date, String slot) {
	   super();
	   this.username = username;
	   this.service = service;
	   this.name = name;
	   this.phoneNumber = phone;
	   this.date = date;
	   this.slot = slot;
   }
   
}