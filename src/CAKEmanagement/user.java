/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CAKEmanagement;

import java.awt.Image;

/**
 *
 * @author ASUS
 */
class user {
    private int Phn_no,Phn_no2;
    private String  Username,Email,Address,Gender;
   
    public user(int phn_no,int phn_no2,String Username,String Email,String Address,String Gender){
        this.Phn_no=phn_no;
        this.Phn_no2=phn_no2;
        this.Username=Username;
        this.Email=Email;
        this.Address=Address;
        this.Gender=Gender;
       
     
        
    }
    public int getphn_no(){
        return Phn_no;
    }
     public int getphn_no2(){
        return Phn_no2;
    }
      public String getUsername(){
        return Username;
    }
       public String getEmail(){
        return Email;
    }
        public String getAddress(){
        return Address;
    }
         public String getGender(){
        return Gender;
    }
  
    
    
}
