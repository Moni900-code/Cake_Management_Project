/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CAKEmanagement;

/** 
 *
 * @author ASUS
 */
class cake {
    private int price;
    private String  name,Item_Contain,category,productcode;
    private byte[] image;
   
    public cake(String name, int price, String productcode, byte[] image, String item, String category)
    {
        this.name=name;
        this.price=price;
        this.productcode=productcode;
        this.image=image;
        this.Item_Contain=item;
        this.category=category;
     
                }
    public String getname(){
        return name;
    }
    public int getprice(){
        return price;
    }
    public String getproductcode(){
        return productcode;
    }
    
    public byte[] getimage(){
        return image;
    }
    public String getitem(){
        return Item_Contain;
    }
    public String getcategory(){
        return category;
    }
  
}
