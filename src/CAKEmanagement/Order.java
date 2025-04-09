/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CAKEmanagement;

/**
 *
 * @author ASUS
 */
class Order {
     private int total,phn_no,phn_no2;
    private String  username,items,time,date,address;
   
    public Order(String username,String items, int total,String time,String date,int phn_no,int phn_no2,String address)
    {
        this.username=username;
        this.items=items;
        this.total=total;
        this.time=time;
        this.date=date;
        this.phn_no=phn_no;
        this.phn_no2=phn_no2;
        this.address=address;
     
                }
    public String getname(){
        return username;
    }
    public String getitems(){
        return items;
    }
    public int gettotal(){
        return total;
    }
    public String gettime(){
        return time;
    }
    
    public String getdate(){
        return date;
    }
    public int getPhn_no(){
        return phn_no;
    }
    public int getPhn_no2(){
        return phn_no2;
    }
    public String getaddress(){
        return address;
    }
    
}
