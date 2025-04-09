/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CAKEmanagement;

/**
 *
 * @author ASUS
 */
class pack {
    private int Category_Id;
    private String  Category_name;
    public pack(int Category_id, String Category_name)
    {
       
        this.Category_Id=Category_id;
        this.Category_name=Category_name;
    }
    public int getCategory_Id(){
        return Category_Id;
    }
    public String getCategory_name(){
        return Category_name;
    }
    
}
