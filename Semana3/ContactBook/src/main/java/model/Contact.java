package model; 

public class Contact{
  
  private String name; 
  private String email; 
  private String phone; 
  
  public Contact(String name, String email, String phone){

    //if(name == null || name.isEmpty()){

    //}
    this.name = name; 
    this.email = email; 
    this.phone = phone; 
  }
  
  public String getName(){
    return this.name; 
  }
  
  public String getEmail(){
    return this.email;
  }
  public String getPhone(){
    return this.phone;
  }
  

}
