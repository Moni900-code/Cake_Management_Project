/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CAKEmanagement;

/**
 *
 * @author ASUS
 */
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class UDB extends javax.swing.JFrame {

    /**
     * Creates new form UDB
     */
    
    
    com.mysql.jdbc.Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String name;
    String price;
    String Product_code;
    private double total=0.0;
    private double tax=0.0;
    private int x=0;
    public UDB() {
        initComponents();
        String a="<HTML><u>LogOut</u></HTML>";
        jLabel79.setText(a);
        updateCombo();
        MyOrder_show();
        OrderUpdate_Show();
        init();
        
        
    }
    public UDB(String msg) {
        initComponents();
        jLabel20.setText(msg);
    }
    private void MyOrder_show() {
           int c;
           java.sql.Connection con1 = null;
           try {
               try {
                   Class.forName("com.mysql.jdbc.Driver");
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               String i="Dola";//a.toString();
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/registration", "root", "");
           PreparedStatement insert = (PreparedStatement) con1.prepareStatement("SELECT * FROM `order_table` WHERE `username`='"+i+"'" );
           ResultSet Rs = insert.executeQuery();
            ResultSetMetaData Rss = (ResultSetMetaData) Rs.getMetaData();
            c = Rss.getColumnCount();
            DefaultTableModel Df = (DefaultTableModel) OrderT.getModel();
            Df.setRowCount(0);
            while (Rs.next()) {
                Vector v2 = new Vector();
          
                for (int ii = 1; ii <= c; ii++) {
                    v2.add(Rs.getString("username"));
                    v2.add(Rs.getString("items"));
                    v2.add(Rs.getString("total"));
                    v2.add(Rs.getString("time"));
                    v2.add(Rs.getString("date"));
                    v2.add(Rs.getString("phn_no"));
                    v2.add(Rs.getString("phn_no2"));
                    v2.add(Rs.getString("Address"));
                      
                } 
              
                Df.addRow(v2);
            }
           
            }catch (SQLException ex) {
                java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
     private void OrderUpdate_Show(){
         
         int c;
           java.sql.Connection con1 = null;
           try {
               try {
                   Class.forName("com.mysql.jdbc.Driver");
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
               }
                String i="Dola";//a.toString();
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/registration", "root", "");
           PreparedStatement insert = (PreparedStatement) con1.prepareStatement("SELECT *FROM `confirmorder`  WHERE `username`='"+i+"'");
           ResultSet Rs = insert.executeQuery();
            ResultSetMetaData Rss = (ResultSetMetaData) Rs.getMetaData();
            c = Rss.getColumnCount();
            DefaultTableModel Df = (DefaultTableModel) OrderU.getModel();
            Df.setRowCount(0);
            while (Rs.next()) {
                Vector v2 = new Vector();
          
                for (int ii = 1; ii <= c; ii++) {
                   
                    v2.add(Rs.getString("code"));
                    v2.add(Rs.getString("Title"));
                      
                }
              
                Df.addRow(v2);
            }
           
            }catch (SQLException ex) {
                java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
     }
   
    public void init(){
         setTime();
    }
    public void reset(){
        total=0.0;
        x=0;
        tax=0.0;
        jSpinner73.setValue(0);
        jSpinner1.setValue(0);
        jSpinner2.setValue(0);
        jSpinner3.setValue(0);
        jSpinner4.setValue(0);
        jSpinner5.setValue(0);
        jSpinner20.setValue(0);
        jSpinner18.setValue(0);
        jSpinner24.setValue(0);
        jSpinner16.setValue(0);
        jSpinner9.setValue(0);
        jSpinner10.setValue(0);
        jSpinner29.setValue(0);
        jSpinner38.setValue(0);
        jSpinner39.setValue(0);
        jSpinner40.setValue(0);
        jSpinner27.setValue(0);
        jSpinner15.setValue(0);
        jSpinner20.setValue(0);
        jSpinner14.setValue(0);
        jSpinner6.setValue(0);
        jSpinner48.setValue(0);
        jSpinner22.setValue(0);
        jSpinner23.setValue(0);
        jSpinner28.setValue(0);
        jSpinner25.setValue(0);
        jSpinner49.setValue(0);
        
        
        jTextField1.setText(" 0.0 ");
        jTextField2.setText(" 0.0 ");
        jTextField3.setText(" 0.0 ");

        
    }
    
   

    private void updateCombo(){
        
       
        try{  
            Class.forName("com.mysql.jdbc.Driver");
          conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/registration","root","");
          String sql="SELECT distinct* FROM `cakepack`";
          pst = (PreparedStatement) conn.prepareStatement(sql);
          rs = pst.executeQuery();
          while(rs.next()){
              jComboBox1.addItem(rs.getString("Category_name"));
              
          }
          name=jComboBox1.getSelectedItem().toString();
          price=jComboBox1.getSelectedItem().toString();
          Product_code=jComboBox1.getSelectedItem().toString();
              
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
   }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Home4 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        OrderU = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        OrderT = new javax.swing.JTable();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        Home3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Total = new javax.swing.JButton();
        Order = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        a = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        b = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        a1 = new javax.swing.JTextField();
        a2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        a3 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        Home1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        Home2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        b5 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jLabel310 = new javax.swing.JLabel();
        jLabel311 = new javax.swing.JLabel();
        jLabel312 = new javax.swing.JLabel();
        jLabel313 = new javax.swing.JLabel();
        jLabel314 = new javax.swing.JLabel();
        jLabel315 = new javax.swing.JLabel();
        jLabel316 = new javax.swing.JLabel();
        jCheckBox45 = new javax.swing.JCheckBox();
        jSpinner10 = new javax.swing.JSpinner();
        jPanel38 = new javax.swing.JPanel();
        jLabel247 = new javax.swing.JLabel();
        jLabel248 = new javax.swing.JLabel();
        jLabel249 = new javax.swing.JLabel();
        jLabel250 = new javax.swing.JLabel();
        jLabel251 = new javax.swing.JLabel();
        jLabel252 = new javax.swing.JLabel();
        jLabel253 = new javax.swing.JLabel();
        jCheckBox36 = new javax.swing.JCheckBox();
        jSpinner29 = new javax.swing.JSpinner();
        jPanel39 = new javax.swing.JPanel();
        jLabel254 = new javax.swing.JLabel();
        jLabel255 = new javax.swing.JLabel();
        jLabel256 = new javax.swing.JLabel();
        jLabel257 = new javax.swing.JLabel();
        jLabel258 = new javax.swing.JLabel();
        jLabel259 = new javax.swing.JLabel();
        jLabel260 = new javax.swing.JLabel();
        jCheckBox37 = new javax.swing.JCheckBox();
        jSpinner38 = new javax.swing.JSpinner();
        jPanel41 = new javax.swing.JPanel();
        jLabel268 = new javax.swing.JLabel();
        jLabel269 = new javax.swing.JLabel();
        jLabel270 = new javax.swing.JLabel();
        jLabel271 = new javax.swing.JLabel();
        jLabel272 = new javax.swing.JLabel();
        jLabel273 = new javax.swing.JLabel();
        jLabel274 = new javax.swing.JLabel();
        jCheckBox39 = new javax.swing.JCheckBox();
        jSpinner39 = new javax.swing.JSpinner();
        jPanel42 = new javax.swing.JPanel();
        jLabel275 = new javax.swing.JLabel();
        jLabel276 = new javax.swing.JLabel();
        jLabel277 = new javax.swing.JLabel();
        jLabel278 = new javax.swing.JLabel();
        jLabel279 = new javax.swing.JLabel();
        jLabel280 = new javax.swing.JLabel();
        jLabel281 = new javax.swing.JLabel();
        jCheckBox40 = new javax.swing.JCheckBox();
        jSpinner40 = new javax.swing.JSpinner();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jSpinner27 = new javax.swing.JSpinner();
        jPanel15 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jSpinner15 = new javax.swing.JSpinner();
        jCheckBox10 = new javax.swing.JCheckBox();
        jPanel17 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jSpinner20 = new javax.swing.JSpinner();
        jCheckBox16 = new javax.swing.JCheckBox();
        jPanel44 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jSpinner14 = new javax.swing.JSpinner();
        jPanel43 = new javax.swing.JPanel();
        jLabel282 = new javax.swing.JLabel();
        jLabel283 = new javax.swing.JLabel();
        jLabel284 = new javax.swing.JLabel();
        jLabel285 = new javax.swing.JLabel();
        jLabel286 = new javax.swing.JLabel();
        jLabel287 = new javax.swing.JLabel();
        jLabel288 = new javax.swing.JLabel();
        jCheckBox41 = new javax.swing.JCheckBox();
        jSpinner6 = new javax.swing.JSpinner();
        jLabel88 = new javax.swing.JLabel();
        a5 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jCheckBox17 = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jCheckBox6 = new javax.swing.JCheckBox();
        jPanel22 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jCheckBox21 = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jSpinner26 = new javax.swing.JSpinner();
        jPanel10 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jSpinner18 = new javax.swing.JSpinner();
        jCheckBox8 = new javax.swing.JCheckBox();
        jPanel40 = new javax.swing.JPanel();
        jLabel261 = new javax.swing.JLabel();
        jLabel262 = new javax.swing.JLabel();
        jLabel263 = new javax.swing.JLabel();
        jLabel264 = new javax.swing.JLabel();
        jLabel265 = new javax.swing.JLabel();
        jLabel266 = new javax.swing.JLabel();
        jLabel267 = new javax.swing.JLabel();
        jCheckBox38 = new javax.swing.JCheckBox();
        jSpinner3 = new javax.swing.JSpinner();
        jPanel26 = new javax.swing.JPanel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jSpinner24 = new javax.swing.JSpinner();
        jCheckBox24 = new javax.swing.JCheckBox();
        jLabel168 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jSpinner16 = new javax.swing.JSpinner();
        jCheckBox15 = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jSpinner9 = new javax.swing.JSpinner();
        jCheckBox7 = new javax.swing.JCheckBox();
        jLabel89 = new javax.swing.JLabel();
        p5 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jLabel317 = new javax.swing.JLabel();
        jLabel318 = new javax.swing.JLabel();
        jLabel319 = new javax.swing.JLabel();
        jLabel320 = new javax.swing.JLabel();
        jLabel321 = new javax.swing.JLabel();
        jLabel322 = new javax.swing.JLabel();
        jLabel323 = new javax.swing.JLabel();
        jCheckBox46 = new javax.swing.JCheckBox();
        jSpinner44 = new javax.swing.JSpinner();
        jPanel45 = new javax.swing.JPanel();
        jLabel289 = new javax.swing.JLabel();
        jLabel290 = new javax.swing.JLabel();
        jLabel291 = new javax.swing.JLabel();
        jLabel292 = new javax.swing.JLabel();
        jLabel293 = new javax.swing.JLabel();
        jLabel294 = new javax.swing.JLabel();
        jLabel295 = new javax.swing.JLabel();
        jCheckBox42 = new javax.swing.JCheckBox();
        jSpinner41 = new javax.swing.JSpinner();
        jPanel46 = new javax.swing.JPanel();
        jLabel296 = new javax.swing.JLabel();
        jLabel297 = new javax.swing.JLabel();
        jLabel298 = new javax.swing.JLabel();
        jLabel299 = new javax.swing.JLabel();
        jLabel300 = new javax.swing.JLabel();
        jLabel301 = new javax.swing.JLabel();
        jLabel302 = new javax.swing.JLabel();
        jCheckBox43 = new javax.swing.JCheckBox();
        jSpinner42 = new javax.swing.JSpinner();
        jPanel52 = new javax.swing.JPanel();
        jLabel303 = new javax.swing.JLabel();
        jLabel304 = new javax.swing.JLabel();
        jLabel305 = new javax.swing.JLabel();
        jLabel306 = new javax.swing.JLabel();
        jLabel307 = new javax.swing.JLabel();
        jLabel308 = new javax.swing.JLabel();
        jLabel309 = new javax.swing.JLabel();
        jCheckBox44 = new javax.swing.JCheckBox();
        jSpinner43 = new javax.swing.JSpinner();
        jPanel53 = new javax.swing.JPanel();
        jLabel345 = new javax.swing.JLabel();
        jLabel346 = new javax.swing.JLabel();
        jLabel347 = new javax.swing.JLabel();
        jLabel348 = new javax.swing.JLabel();
        jLabel349 = new javax.swing.JLabel();
        jLabel350 = new javax.swing.JLabel();
        jLabel351 = new javax.swing.JLabel();
        jCheckBox50 = new javax.swing.JCheckBox();
        jSpinner48 = new javax.swing.JSpinner();
        jPanel54 = new javax.swing.JPanel();
        jLabel352 = new javax.swing.JLabel();
        jLabel353 = new javax.swing.JLabel();
        jLabel354 = new javax.swing.JLabel();
        jLabel355 = new javax.swing.JLabel();
        jLabel356 = new javax.swing.JLabel();
        jLabel357 = new javax.swing.JLabel();
        jLabel358 = new javax.swing.JLabel();
        jCheckBox51 = new javax.swing.JCheckBox();
        jSpinner22 = new javax.swing.JSpinner();
        jPanel55 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jSpinner23 = new javax.swing.JSpinner();
        jPanel19 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jSpinner28 = new javax.swing.JSpinner();
        jPanel21 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jSpinner25 = new javax.swing.JSpinner();
        jCheckBox14 = new javax.swing.JCheckBox();
        jPanel56 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jSpinner49 = new javax.swing.JSpinner();
        jCheckBox18 = new javax.swing.JCheckBox();
        jLabel90 = new javax.swing.JLabel();
        q3 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel324 = new javax.swing.JLabel();
        jLabel325 = new javax.swing.JLabel();
        jLabel326 = new javax.swing.JLabel();
        jLabel327 = new javax.swing.JLabel();
        jLabel328 = new javax.swing.JLabel();
        jLabel329 = new javax.swing.JLabel();
        jLabel330 = new javax.swing.JLabel();
        jCheckBox47 = new javax.swing.JCheckBox();
        jSpinner45 = new javax.swing.JSpinner();
        jPanel57 = new javax.swing.JPanel();
        jLabel359 = new javax.swing.JLabel();
        jLabel360 = new javax.swing.JLabel();
        jLabel361 = new javax.swing.JLabel();
        jLabel362 = new javax.swing.JLabel();
        jLabel363 = new javax.swing.JLabel();
        jLabel364 = new javax.swing.JLabel();
        jLabel365 = new javax.swing.JLabel();
        jCheckBox52 = new javax.swing.JCheckBox();
        jSpinner50 = new javax.swing.JSpinner();
        jPanel58 = new javax.swing.JPanel();
        jLabel366 = new javax.swing.JLabel();
        jLabel367 = new javax.swing.JLabel();
        jLabel368 = new javax.swing.JLabel();
        jLabel369 = new javax.swing.JLabel();
        jLabel370 = new javax.swing.JLabel();
        jLabel371 = new javax.swing.JLabel();
        jLabel372 = new javax.swing.JLabel();
        jCheckBox53 = new javax.swing.JCheckBox();
        jSpinner51 = new javax.swing.JSpinner();
        jPanel59 = new javax.swing.JPanel();
        jLabel373 = new javax.swing.JLabel();
        jLabel374 = new javax.swing.JLabel();
        jLabel375 = new javax.swing.JLabel();
        jLabel376 = new javax.swing.JLabel();
        jLabel377 = new javax.swing.JLabel();
        jLabel378 = new javax.swing.JLabel();
        jLabel379 = new javax.swing.JLabel();
        jCheckBox54 = new javax.swing.JCheckBox();
        jSpinner52 = new javax.swing.JSpinner();
        jPanel60 = new javax.swing.JPanel();
        jLabel380 = new javax.swing.JLabel();
        jLabel381 = new javax.swing.JLabel();
        jLabel382 = new javax.swing.JLabel();
        jLabel383 = new javax.swing.JLabel();
        jLabel384 = new javax.swing.JLabel();
        jLabel385 = new javax.swing.JLabel();
        jLabel386 = new javax.swing.JLabel();
        jCheckBox55 = new javax.swing.JCheckBox();
        jSpinner53 = new javax.swing.JSpinner();
        jPanel61 = new javax.swing.JPanel();
        jLabel387 = new javax.swing.JLabel();
        jLabel388 = new javax.swing.JLabel();
        jLabel389 = new javax.swing.JLabel();
        jLabel390 = new javax.swing.JLabel();
        jLabel391 = new javax.swing.JLabel();
        jLabel392 = new javax.swing.JLabel();
        jLabel393 = new javax.swing.JLabel();
        jCheckBox56 = new javax.swing.JCheckBox();
        jSpinner54 = new javax.swing.JSpinner();
        jPanel62 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jCheckBox19 = new javax.swing.JCheckBox();
        jSpinner55 = new javax.swing.JSpinner();
        jPanel63 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jCheckBox20 = new javax.swing.JCheckBox();
        jSpinner56 = new javax.swing.JSpinner();
        jPanel64 = new javax.swing.JPanel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jSpinner57 = new javax.swing.JSpinner();
        jCheckBox22 = new javax.swing.JCheckBox();
        jPanel65 = new javax.swing.JPanel();
        jLabel162 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jSpinner58 = new javax.swing.JSpinner();
        jCheckBox23 = new javax.swing.JCheckBox();
        jLabel91 = new javax.swing.JLabel();
        r3 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jLabel331 = new javax.swing.JLabel();
        jLabel332 = new javax.swing.JLabel();
        jLabel333 = new javax.swing.JLabel();
        jLabel334 = new javax.swing.JLabel();
        jLabel335 = new javax.swing.JLabel();
        jLabel336 = new javax.swing.JLabel();
        jLabel337 = new javax.swing.JLabel();
        jCheckBox48 = new javax.swing.JCheckBox();
        jSpinner46 = new javax.swing.JSpinner();
        jPanel72 = new javax.swing.JPanel();
        jLabel441 = new javax.swing.JLabel();
        jLabel442 = new javax.swing.JLabel();
        jLabel443 = new javax.swing.JLabel();
        jLabel444 = new javax.swing.JLabel();
        jLabel445 = new javax.swing.JLabel();
        jLabel446 = new javax.swing.JLabel();
        jSpinner66 = new javax.swing.JSpinner();
        jCheckBox65 = new javax.swing.JCheckBox();
        jLabel447 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jLabel448 = new javax.swing.JLabel();
        jLabel449 = new javax.swing.JLabel();
        jLabel450 = new javax.swing.JLabel();
        jLabel451 = new javax.swing.JLabel();
        jLabel452 = new javax.swing.JLabel();
        jLabel453 = new javax.swing.JLabel();
        jLabel454 = new javax.swing.JLabel();
        jSpinner67 = new javax.swing.JSpinner();
        jCheckBox66 = new javax.swing.JCheckBox();
        jPanel74 = new javax.swing.JPanel();
        jLabel455 = new javax.swing.JLabel();
        jLabel456 = new javax.swing.JLabel();
        jLabel457 = new javax.swing.JLabel();
        jLabel458 = new javax.swing.JLabel();
        jLabel459 = new javax.swing.JLabel();
        jLabel460 = new javax.swing.JLabel();
        jLabel461 = new javax.swing.JLabel();
        jCheckBox68 = new javax.swing.JCheckBox();
        jSpinner68 = new javax.swing.JSpinner();
        jPanel75 = new javax.swing.JPanel();
        jLabel462 = new javax.swing.JLabel();
        jLabel463 = new javax.swing.JLabel();
        jLabel464 = new javax.swing.JLabel();
        jLabel465 = new javax.swing.JLabel();
        jLabel466 = new javax.swing.JLabel();
        jLabel467 = new javax.swing.JLabel();
        jLabel468 = new javax.swing.JLabel();
        jSpinner69 = new javax.swing.JSpinner();
        jCheckBox69 = new javax.swing.JCheckBox();
        jPanel76 = new javax.swing.JPanel();
        jLabel469 = new javax.swing.JLabel();
        jLabel470 = new javax.swing.JLabel();
        jLabel471 = new javax.swing.JLabel();
        jLabel472 = new javax.swing.JLabel();
        jLabel473 = new javax.swing.JLabel();
        jLabel474 = new javax.swing.JLabel();
        jLabel475 = new javax.swing.JLabel();
        jSpinner70 = new javax.swing.JSpinner();
        jCheckBox70 = new javax.swing.JCheckBox();
        jPanel77 = new javax.swing.JPanel();
        jLabel476 = new javax.swing.JLabel();
        jLabel477 = new javax.swing.JLabel();
        jLabel478 = new javax.swing.JLabel();
        jLabel479 = new javax.swing.JLabel();
        jLabel480 = new javax.swing.JLabel();
        jLabel481 = new javax.swing.JLabel();
        jLabel482 = new javax.swing.JLabel();
        jCheckBox72 = new javax.swing.JCheckBox();
        jSpinner71 = new javax.swing.JSpinner();
        jPanel78 = new javax.swing.JPanel();
        jLabel483 = new javax.swing.JLabel();
        jLabel484 = new javax.swing.JLabel();
        jLabel485 = new javax.swing.JLabel();
        jLabel486 = new javax.swing.JLabel();
        jLabel487 = new javax.swing.JLabel();
        jLabel488 = new javax.swing.JLabel();
        jLabel489 = new javax.swing.JLabel();
        jSpinner72 = new javax.swing.JSpinner();
        jCheckBox73 = new javax.swing.JCheckBox();
        jLabel92 = new javax.swing.JLabel();
        s3 = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();
        jLabel511 = new javax.swing.JLabel();
        jLabel512 = new javax.swing.JLabel();
        jLabel513 = new javax.swing.JLabel();
        jLabel514 = new javax.swing.JLabel();
        jLabel515 = new javax.swing.JLabel();
        jLabel516 = new javax.swing.JLabel();
        jLabel517 = new javax.swing.JLabel();
        jCheckBox75 = new javax.swing.JCheckBox();
        jSpinner76 = new javax.swing.JSpinner();
        jPanel90 = new javax.swing.JPanel();
        jLabel567 = new javax.swing.JLabel();
        jLabel568 = new javax.swing.JLabel();
        jLabel569 = new javax.swing.JLabel();
        jLabel570 = new javax.swing.JLabel();
        jLabel571 = new javax.swing.JLabel();
        jLabel572 = new javax.swing.JLabel();
        jLabel573 = new javax.swing.JLabel();
        jCheckBox83 = new javax.swing.JCheckBox();
        jSpinner84 = new javax.swing.JSpinner();
        jPanel91 = new javax.swing.JPanel();
        jLabel574 = new javax.swing.JLabel();
        jLabel575 = new javax.swing.JLabel();
        jLabel576 = new javax.swing.JLabel();
        jLabel577 = new javax.swing.JLabel();
        jLabel578 = new javax.swing.JLabel();
        jLabel579 = new javax.swing.JLabel();
        jLabel580 = new javax.swing.JLabel();
        jCheckBox84 = new javax.swing.JCheckBox();
        jSpinner85 = new javax.swing.JSpinner();
        jPanel92 = new javax.swing.JPanel();
        jLabel581 = new javax.swing.JLabel();
        jLabel582 = new javax.swing.JLabel();
        jLabel583 = new javax.swing.JLabel();
        jLabel584 = new javax.swing.JLabel();
        jLabel585 = new javax.swing.JLabel();
        jLabel586 = new javax.swing.JLabel();
        jLabel587 = new javax.swing.JLabel();
        jCheckBox85 = new javax.swing.JCheckBox();
        jSpinner86 = new javax.swing.JSpinner();
        jPanel93 = new javax.swing.JPanel();
        jLabel588 = new javax.swing.JLabel();
        jLabel589 = new javax.swing.JLabel();
        jLabel590 = new javax.swing.JLabel();
        jLabel591 = new javax.swing.JLabel();
        jLabel592 = new javax.swing.JLabel();
        jLabel593 = new javax.swing.JLabel();
        jLabel594 = new javax.swing.JLabel();
        jSpinner87 = new javax.swing.JSpinner();
        jCheckBox86 = new javax.swing.JCheckBox();
        jPanel94 = new javax.swing.JPanel();
        jLabel595 = new javax.swing.JLabel();
        jLabel596 = new javax.swing.JLabel();
        jLabel597 = new javax.swing.JLabel();
        jLabel598 = new javax.swing.JLabel();
        jLabel599 = new javax.swing.JLabel();
        jLabel600 = new javax.swing.JLabel();
        jLabel601 = new javax.swing.JLabel();
        jSpinner88 = new javax.swing.JSpinner();
        jCheckBox87 = new javax.swing.JCheckBox();
        jPanel95 = new javax.swing.JPanel();
        jLabel602 = new javax.swing.JLabel();
        jLabel603 = new javax.swing.JLabel();
        jLabel604 = new javax.swing.JLabel();
        jLabel605 = new javax.swing.JLabel();
        jLabel606 = new javax.swing.JLabel();
        jLabel607 = new javax.swing.JLabel();
        jLabel608 = new javax.swing.JLabel();
        jCheckBox88 = new javax.swing.JCheckBox();
        jSpinner89 = new javax.swing.JSpinner();
        jPanel96 = new javax.swing.JPanel();
        jLabel609 = new javax.swing.JLabel();
        jLabel610 = new javax.swing.JLabel();
        jLabel611 = new javax.swing.JLabel();
        jLabel612 = new javax.swing.JLabel();
        jLabel613 = new javax.swing.JLabel();
        jLabel614 = new javax.swing.JLabel();
        jLabel615 = new javax.swing.JLabel();
        jCheckBox89 = new javax.swing.JCheckBox();
        jSpinner90 = new javax.swing.JSpinner();
        jPanel97 = new javax.swing.JPanel();
        jLabel616 = new javax.swing.JLabel();
        jLabel617 = new javax.swing.JLabel();
        jLabel618 = new javax.swing.JLabel();
        jLabel619 = new javax.swing.JLabel();
        jLabel620 = new javax.swing.JLabel();
        jLabel621 = new javax.swing.JLabel();
        jLabel622 = new javax.swing.JLabel();
        jCheckBox90 = new javax.swing.JCheckBox();
        jSpinner91 = new javax.swing.JSpinner();
        jPanel98 = new javax.swing.JPanel();
        jLabel623 = new javax.swing.JLabel();
        jLabel624 = new javax.swing.JLabel();
        jLabel625 = new javax.swing.JLabel();
        jLabel626 = new javax.swing.JLabel();
        jLabel627 = new javax.swing.JLabel();
        jLabel628 = new javax.swing.JLabel();
        jLabel629 = new javax.swing.JLabel();
        jCheckBox91 = new javax.swing.JCheckBox();
        jSpinner92 = new javax.swing.JSpinner();
        jLabel176 = new javax.swing.JLabel();
        t3 = new javax.swing.JPanel();
        jPanel81 = new javax.swing.JPanel();
        jLabel504 = new javax.swing.JLabel();
        jLabel505 = new javax.swing.JLabel();
        jLabel506 = new javax.swing.JLabel();
        jLabel507 = new javax.swing.JLabel();
        jLabel508 = new javax.swing.JLabel();
        jLabel509 = new javax.swing.JLabel();
        jLabel510 = new javax.swing.JLabel();
        jCheckBox74 = new javax.swing.JCheckBox();
        jSpinner75 = new javax.swing.JSpinner();
        jPanel83 = new javax.swing.JPanel();
        jLabel518 = new javax.swing.JLabel();
        jLabel519 = new javax.swing.JLabel();
        jLabel520 = new javax.swing.JLabel();
        jLabel521 = new javax.swing.JLabel();
        jLabel522 = new javax.swing.JLabel();
        jLabel523 = new javax.swing.JLabel();
        jLabel524 = new javax.swing.JLabel();
        jCheckBox76 = new javax.swing.JCheckBox();
        jSpinner77 = new javax.swing.JSpinner();
        jPanel84 = new javax.swing.JPanel();
        jLabel525 = new javax.swing.JLabel();
        jLabel526 = new javax.swing.JLabel();
        jLabel527 = new javax.swing.JLabel();
        jLabel528 = new javax.swing.JLabel();
        jLabel529 = new javax.swing.JLabel();
        jLabel530 = new javax.swing.JLabel();
        jLabel531 = new javax.swing.JLabel();
        jCheckBox77 = new javax.swing.JCheckBox();
        jSpinner78 = new javax.swing.JSpinner();
        jPanel86 = new javax.swing.JPanel();
        jLabel539 = new javax.swing.JLabel();
        jLabel540 = new javax.swing.JLabel();
        jLabel541 = new javax.swing.JLabel();
        jLabel542 = new javax.swing.JLabel();
        jLabel543 = new javax.swing.JLabel();
        jLabel544 = new javax.swing.JLabel();
        jLabel545 = new javax.swing.JLabel();
        jSpinner80 = new javax.swing.JSpinner();
        jCheckBox79 = new javax.swing.JCheckBox();
        jPanel87 = new javax.swing.JPanel();
        jLabel546 = new javax.swing.JLabel();
        jLabel547 = new javax.swing.JLabel();
        jLabel548 = new javax.swing.JLabel();
        jLabel549 = new javax.swing.JLabel();
        jLabel550 = new javax.swing.JLabel();
        jLabel551 = new javax.swing.JLabel();
        jLabel552 = new javax.swing.JLabel();
        jSpinner81 = new javax.swing.JSpinner();
        jCheckBox80 = new javax.swing.JCheckBox();
        jPanel88 = new javax.swing.JPanel();
        jLabel553 = new javax.swing.JLabel();
        jLabel554 = new javax.swing.JLabel();
        jLabel555 = new javax.swing.JLabel();
        jLabel556 = new javax.swing.JLabel();
        jLabel557 = new javax.swing.JLabel();
        jLabel558 = new javax.swing.JLabel();
        jLabel559 = new javax.swing.JLabel();
        jCheckBox81 = new javax.swing.JCheckBox();
        jSpinner82 = new javax.swing.JSpinner();
        jPanel89 = new javax.swing.JPanel();
        jLabel560 = new javax.swing.JLabel();
        jLabel561 = new javax.swing.JLabel();
        jLabel562 = new javax.swing.JLabel();
        jLabel563 = new javax.swing.JLabel();
        jLabel564 = new javax.swing.JLabel();
        jLabel565 = new javax.swing.JLabel();
        jLabel566 = new javax.swing.JLabel();
        jCheckBox82 = new javax.swing.JCheckBox();
        jSpinner83 = new javax.swing.JSpinner();
        jPanel85 = new javax.swing.JPanel();
        jLabel532 = new javax.swing.JLabel();
        jLabel533 = new javax.swing.JLabel();
        jLabel534 = new javax.swing.JLabel();
        jLabel535 = new javax.swing.JLabel();
        jLabel536 = new javax.swing.JLabel();
        jLabel537 = new javax.swing.JLabel();
        jLabel538 = new javax.swing.JLabel();
        jCheckBox78 = new javax.swing.JCheckBox();
        jSpinner79 = new javax.swing.JSpinner();
        jPanel80 = new javax.swing.JPanel();
        jLabel497 = new javax.swing.JLabel();
        jLabel498 = new javax.swing.JLabel();
        jLabel499 = new javax.swing.JLabel();
        jLabel500 = new javax.swing.JLabel();
        jLabel501 = new javax.swing.JLabel();
        jLabel502 = new javax.swing.JLabel();
        jLabel503 = new javax.swing.JLabel();
        jCheckBox71 = new javax.swing.JCheckBox();
        jSpinner74 = new javax.swing.JSpinner();
        jPanel79 = new javax.swing.JPanel();
        jLabel490 = new javax.swing.JLabel();
        jLabel491 = new javax.swing.JLabel();
        jLabel492 = new javax.swing.JLabel();
        jLabel493 = new javax.swing.JLabel();
        jLabel494 = new javax.swing.JLabel();
        jLabel495 = new javax.swing.JLabel();
        jLabel496 = new javax.swing.JLabel();
        jCheckBox67 = new javax.swing.JCheckBox();
        jSpinner73 = new javax.swing.JSpinner();
        jLabel177 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Home4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OrderU.setBackground(new java.awt.Color(51, 51, 51));
        OrderU.setForeground(new java.awt.Color(255, 255, 255));
        OrderU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OTP_Code", "Message"
            }
        ));
        OrderU.setRowHeight(70);
        OrderU.setRowMargin(2);
        jScrollPane4.setViewportView(OrderU);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 150, 482, 562));

        OrderT.setBackground(new java.awt.Color(51, 51, 51));
        OrderT.setForeground(new java.awt.Color(255, 255, 255));
        OrderT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Items", "Total", "Time", "Date", "Phn_no", "Phn_no2", "Address"
            }
        ));
        OrderT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OrderT.setRowHeight(70);
        OrderT.setRowMargin(2);
        OrderT.setSelectionBackground(new java.awt.Color(204, 204, 255));
        OrderT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderTMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(OrderT);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 152, 871, 562));

        jLabel83.setFont(new java.awt.Font("Trebuchet MS", 3, 50)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("MY Order");
        jPanel2.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 6, 468, 48));

        jLabel84.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("My Order Details");
        jPanel2.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 80, 318, 54));

        jLabel85.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("My Order Updates");
        jPanel2.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(1086, 88, 318, 54));

        jLabel86.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\d.jpg")); // NOI18N
        jPanel2.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1630, 1130));

        Home4.setViewportView(jPanel2);

        Home3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 390, 480));

        Total.setBackground(new java.awt.Color(0, 0, 0));
        Total.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Total.setForeground(new java.awt.Color(204, 204, 255));
        Total.setText("Total");
        Total.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });
        jPanel1.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 620, 150, -1));

        Order.setBackground(new java.awt.Color(0, 0, 0));
        Order.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Order.setForeground(new java.awt.Color(204, 204, 255));
        Order.setText("Order");
        Order.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderActionPerformed(evt);
            }
        });
        jPanel1.add(Order, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 620, 150, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 255));
        jLabel14.setText("Total");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 130, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 255));
        jLabel17.setText("Date");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 130, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 255));
        jLabel18.setText("Username");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 110, 30));

        jTextField1.setBackground(new java.awt.Color(51, 51, 51));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0.0");
        jTextField1.setMargin(new java.awt.Insets(0, 0, 2, 0));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 240, -1));

        jTextField2.setBackground(new java.awt.Color(51, 51, 51));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("0.0");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 240, -1));

        jTextField3.setBackground(new java.awt.Color(51, 51, 51));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("0.0");
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 240, -1));

        jTextArea2.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 240, 120));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 255));
        jLabel19.setText("Tax");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 130, -1));

        jTextField4.setBackground(new java.awt.Color(51, 51, 51));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText(".............., Day/Month/Year");
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 240, -1));

        a.setBackground(new java.awt.Color(51, 51, 51));
        a.setForeground(new java.awt.Color(255, 255, 255));
        a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        jPanel1.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 240, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 255));
        jLabel21.setText("Time");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 130, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 255));
        jLabel22.setText("SubTotal");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 130, -1));

        b.setBackground(new java.awt.Color(51, 51, 51));
        b.setForeground(new java.awt.Color(255, 255, 255));
        b.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        b.setText("_______ , ______ , ______");
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActionPerformed(evt);
            }
        });
        jPanel1.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 240, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 255));
        jLabel23.setText("Address");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 80, 30));

        a1.setBackground(new java.awt.Color(51, 51, 51));
        a1.setForeground(new java.awt.Color(255, 255, 255));
        a1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a1ActionPerformed(evt);
            }
        });
        jPanel1.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, 240, -1));

        a2.setBackground(new java.awt.Color(51, 51, 51));
        a2.setForeground(new java.awt.Color(255, 255, 255));
        a2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a2ActionPerformed(evt);
            }
        });
        jPanel1.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 530, 240, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 204, 255));
        jLabel28.setText("Phn_no2");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 90, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 204, 255));
        jLabel29.setText("Items");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 60, 30));

        a3.setBackground(new java.awt.Color(51, 51, 51));
        a3.setForeground(new java.awt.Color(255, 255, 255));
        a3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a3ActionPerformed(evt);
            }
        });
        jPanel1.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 240, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 204, 255));
        jLabel30.setText("Phn_no");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 80, 30));

        jLabel80.setFont(new java.awt.Font("STLiti", 1, 48)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(204, 204, 255));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("My Cart");
        jPanel1.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 260, -1));

        jLabel82.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\cake-slice.png")); // NOI18N
        jPanel1.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, -1, -1));

        jLabel87.setBackground(new java.awt.Color(51, 51, 51));
        jLabel87.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\e.jpg")); // NOI18N
        jPanel1.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 920));

        Home3.setViewportView(jPanel1);

        Home1.setBackground(new java.awt.Color(255, 204, 204));
        Home1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setFont(new java.awt.Font("SutonnyOMJ", 1, 18)); // NOI18N
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        Home1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 231, 41));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select Category");
        Home1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 140, 25));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Home1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 240, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Home1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 240, 30));

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Reset");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Home1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 120, -1));

        jLabel20.setFont(new java.awt.Font("Tekton Pro Cond", 3, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        Home1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 115, 23));

        jLabel79.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 0));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("LogOut");
        jLabel79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel79MouseClicked(evt);
            }
        });
        Home1.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, -1));

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profile.png"))); // NOI18N
        Home1.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 43));

        jLabel180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/istockphoto-183417204-612x612.jpg"))); // NOI18N
        Home1.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 580));

        jLabel181.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        jLabel181.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Home1.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 720, 190, 40));

        jLabel179.setFont(new java.awt.Font("Viner Hand ITC", 3, 24)); // NOI18N
        jLabel179.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel179.setText("Cookie Encounter");
        Home1.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 680, 230, 50));

        jLabel182.setFont(new java.awt.Font("Viner Hand ITC", 3, 24)); // NOI18N
        jLabel182.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel182.setText("WelCome to Our ");
        Home1.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 210, 50));

        Home2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b5.setBackground(new java.awt.Color(255, 204, 204));
        b5.setForeground(new java.awt.Color(255, 255, 255));
        b5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel47.setBackground(new java.awt.Color(255, 153, 153));
        jPanel47.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel310.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel310.setText("Name");

        jLabel311.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel311.setText("Price");

        jLabel312.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel312.setText("Quality");

        jLabel313.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel313.setText("Purchase");

        jLabel314.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel314.setText("Chocolate Cheesecake wit");

        jLabel315.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-38-66370-1.jpg")); // NOI18N

        jLabel316.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel316.setText("500");

        jCheckBox45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox45ActionPerformed(evt);
            }
        });

        jSpinner10.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel311, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel312, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel313, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox45, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel316, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jLabel310, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel314)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel315)
                .addGap(14, 14, 14))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel315, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel310)
                    .addComponent(jLabel314))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel311)
                    .addComponent(jLabel316))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel312)
                    .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel313)
                    .addComponent(jCheckBox45))
                .addGap(16, 16, 16))
        );

        b5.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 649, -1, 300));

        jPanel38.setBackground(new java.awt.Color(255, 153, 153));
        jPanel38.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel247.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel247.setText("Name");

        jLabel248.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel248.setText("Price");

        jLabel249.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel249.setText("Quality");

        jLabel250.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel250.setText("Purchase");

        jLabel251.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel251.setText("Passionfruit slice Cake");

        jLabel252.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-44-66380-1.jpg")); // NOI18N

        jLabel253.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel253.setText("320");

        jCheckBox36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox36ActionPerformed(evt);
            }
        });

        jSpinner29.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel247, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel248, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel249, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel250, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox36, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel253, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel251)
                                .addContainerGap())))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel252, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel252, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel247)
                    .addComponent(jLabel251))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel248)
                    .addComponent(jLabel253))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel249)
                    .addComponent(jSpinner29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel250)
                    .addComponent(jCheckBox36))
                .addGap(16, 16, 16))
        );

        b5.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        jPanel39.setBackground(new java.awt.Color(255, 153, 153));
        jPanel39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel254.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel254.setText("Name");

        jLabel255.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel255.setText("Price");

        jLabel256.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel256.setText("Quality");

        jLabel257.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel257.setText("Purchase");

        jLabel258.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel258.setText("Banana caramel Cake");

        jLabel259.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-43-66379-1.jpg")); // NOI18N

        jLabel260.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel260.setText("320");

        jCheckBox37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox37ActionPerformed(evt);
            }
        });

        jSpinner38.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel254, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel255, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel256, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel257, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox37, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel260, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel258))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel259, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel259, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel254)
                    .addComponent(jLabel258))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel255)
                    .addComponent(jLabel260))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel256)
                    .addComponent(jSpinner38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel257)
                    .addComponent(jCheckBox37))
                .addGap(16, 16, 16))
        );

        b5.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jPanel41.setBackground(new java.awt.Color(255, 153, 153));
        jPanel41.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel268.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel268.setText("Name");

        jLabel269.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel269.setText("Price");

        jLabel270.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel270.setText("Quality");

        jLabel271.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel271.setText("Purchase");

        jLabel272.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel272.setText("Raspberry Cake");

        jLabel273.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-42-66377-1.jpg")); // NOI18N

        jLabel274.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel274.setText("320");

        jCheckBox39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox39ActionPerformed(evt);
            }
        });

        jSpinner39.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel268, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel269, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel270, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel271, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox39, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel274, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel272, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel273)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel273, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel268)
                    .addComponent(jLabel272))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel269)
                    .addComponent(jLabel274))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel270)
                    .addComponent(jSpinner39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel271)
                    .addComponent(jCheckBox39))
                .addGap(16, 16, 16))
        );

        b5.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jPanel42.setBackground(new java.awt.Color(255, 153, 153));
        jPanel42.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel275.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel275.setText("Name");

        jLabel276.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel276.setText("Price");

        jLabel277.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel277.setText("Quality");

        jLabel278.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel278.setText("Purchase");

        jLabel279.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel279.setText("Rock Cakes");

        jLabel280.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-41-66374-1.jpg")); // NOI18N

        jLabel281.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel281.setText("320");

        jCheckBox40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox40ActionPerformed(evt);
            }
        });

        jSpinner40.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel275, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel276, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel277, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel278, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox40, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel281, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel279, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel280)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel280, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel275)
                    .addComponent(jLabel279))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel276)
                    .addComponent(jLabel281))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel277)
                    .addComponent(jSpinner40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel278)
                    .addComponent(jCheckBox40))
                .addGap(16, 16, 16))
        );

        b5.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 230, 310));

        jPanel12.setBackground(new java.awt.Color(255, 153, 153));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel9.setText("Name");

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel10.setText("Price");

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel11.setText("Quality");

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel12.setText("Purchase");

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel15.setText("Apple_Strawberry crumble");

        jLabel61.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-32-66360-1.jpg")); // NOI18N

        jLabel62.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel62.setText("420");

        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jSpinner27.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jSpinner27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jCheckBox5))
                .addGap(16, 16, 16))
        );

        b5.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 950, -1, -1));

        jPanel15.setBackground(new java.awt.Color(255, 153, 153));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel65.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel65.setText("Name");

        jLabel66.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel66.setText("Price");

        jLabel67.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel67.setText("Quality");

        jLabel68.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel68.setText("Purchase");

        jLabel69.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel69.setText("Updown Cake");

        jLabel70.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\updowncake.jpg")); // NOI18N

        jLabel71.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel71.setText("330");

        jSpinner15.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel70)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 159, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jSpinner15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68)
                    .addComponent(jCheckBox10))
                .addGap(16, 16, 16))
        );

        b5.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 300));

        jPanel17.setBackground(new java.awt.Color(255, 153, 153));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel107.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel107.setText("Name");

        jLabel108.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel108.setText("Price");

        jLabel109.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel109.setText("Quality");

        jLabel110.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel110.setText("Purchase");

        jLabel111.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel111.setText("Almond Cake");

        jLabel112.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-49-66387-1.jpg")); // NOI18N

        jLabel113.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel113.setText("450");

        jSpinner20.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel112, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107)
                    .addComponent(jLabel111))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel108)
                    .addComponent(jLabel113))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel109)
                    .addComponent(jSpinner20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel110)
                    .addComponent(jCheckBox16))
                .addGap(16, 16, 16))
        );

        b5.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        jPanel44.setBackground(new java.awt.Color(255, 153, 153));
        jPanel44.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel16.setText("Name");

        jLabel34.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel34.setText("Price");

        jLabel35.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel35.setText("Quality");

        jLabel36.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel36.setText("Purchase");

        jLabel58.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel58.setText("Caramel mud Cake");

        jLabel59.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-37-66369-1.jpg")); // NOI18N

        jLabel60.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel60.setText("520");

        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jSpinner14.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jSpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jCheckBox3))
                .addGap(16, 16, 16))
        );

        b5.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        jPanel43.setBackground(new java.awt.Color(255, 153, 153));
        jPanel43.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel282.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel282.setText("Name");

        jLabel283.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel283.setText("Price");

        jLabel284.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel284.setText("Quality");

        jLabel285.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel285.setText("Purchase");

        jLabel286.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel286.setText("Chocolate Cheesecake wit");

        jLabel287.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-38-66370-1.jpg")); // NOI18N

        jLabel288.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel288.setText("500");

        jCheckBox41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox41ActionPerformed(evt);
            }
        });

        jSpinner6.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel283, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel284, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel285, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox41, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel288, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel282, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel286)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel287)
                .addGap(14, 14, 14))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel287, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel282)
                    .addComponent(jLabel286))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel283)
                    .addComponent(jLabel288))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel284)
                    .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel285)
                    .addComponent(jCheckBox41))
                .addGap(16, 16, 16))
        );

        b5.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 650, 240, 300));

        jLabel88.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\1.jpg")); // NOI18N
        jLabel88.setText("jLabel88");
        b5.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 1940));

        jPanel6.add(b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1061, 1941));

        a5.setBackground(new java.awt.Color(255, 204, 204));
        a5.setForeground(new java.awt.Color(255, 255, 255));
        a5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(255, 153, 153));
        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel114.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel114.setText("Name");

        jLabel115.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel115.setText("Price");

        jLabel116.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel116.setText("Quality");

        jLabel117.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel117.setText("Purchase");

        jLabel118.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel118.setText("Genoise_wih_Cream_Cake");

        jLabel119.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\genoise-with-cream-berries-and-lemon-cream-royalty-free-image-1578348743.jpg")); // NOI18N

        jLabel120.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel120.setText("32.0");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel118))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel119))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(90, 90, 90))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(jLabel118))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(jLabel120))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel117)
                    .addComponent(jCheckBox17))
                .addGap(16, 16, 16))
        );

        a5.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 300));

        jPanel7.setBackground(new java.awt.Color(255, 153, 153));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel24.setText("Name");

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel25.setText("Price");

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel26.setText("Quality");

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel27.setText("Purchase");

        jLabel31.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel31.setText("Chocolate matcha swirl");

        jLabel32.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\chocolate-matcha-swirl-pound-cake-1574437002.jpg")); // NOI18N

        jLabel33.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel33.setText("23.0");

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jCheckBox4))
                .addGap(16, 16, 16))
        );

        a5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, 300));

        jPanel8.setBackground(new java.awt.Color(255, 153, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel37.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel37.setText("Name");

        jLabel38.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel38.setText("Price");

        jLabel39.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel39.setText("Quantity");

        jLabel40.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel40.setText("Purchase");

        jLabel41.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel41.setText("Yellow_butter_Cake");

        jLabel42.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\3-layer-yellow-butter-cake-1574436790.jpg")); // NOI18N

        jLabel43.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel43.setText("36.0");

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jCheckBox6))
                .addGap(16, 16, 16))
        );

        a5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, 280));

        jPanel22.setBackground(new java.awt.Color(255, 153, 153));
        jPanel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel142.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel142.setText("Name");

        jLabel143.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel143.setText("Price");

        jLabel144.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel144.setText("Quantity");

        jLabel145.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel145.setText("Purchase");

        jLabel146.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel146.setText("Chocolate mousse Cake");

        jLabel147.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-30-66357-1.jpg")); // NOI18N

        jLabel148.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel148.setText("45.0");

        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox21, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel147))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel142)
                    .addComponent(jLabel146))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel143)
                    .addComponent(jLabel148))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel144)
                    .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel145)
                    .addComponent(jCheckBox21))
                .addGap(16, 16, 16))
        );

        a5.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 230, 280));

        jPanel11.setBackground(new java.awt.Color(255, 153, 153));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel128.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel128.setText("Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel2.setText("Price");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel3.setText("Quantity");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel4.setText("Purchase");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel5.setText("Chocolate Cheesecake wit");

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-35-66367-1.jpg")); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel8.setText("49.0");

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jSpinner26.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel128)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jCheckBox1))
                .addGap(16, 16, 16))
        );

        a5.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 230, 290));

        jPanel10.setBackground(new java.awt.Color(255, 153, 153));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel51.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel51.setText("Name");

        jLabel52.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel52.setText("Price");

        jLabel53.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel53.setText("Quantity");

        jLabel54.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel54.setText("Purchase");

        jLabel55.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel55.setText("Cheese Cake");

        jLabel56.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\cheese-cake-1577124381.jpg")); // NOI18N

        jLabel57.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel57.setText("22.0");

        jSpinner18.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jSpinner18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel56)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jSpinner18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox8)
                    .addComponent(jLabel54))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        a5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 660, 230, 290));

        jPanel40.setBackground(new java.awt.Color(255, 153, 153));
        jPanel40.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel261.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel261.setText("Name");

        jLabel262.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel262.setText("Price");

        jLabel263.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel263.setText("Quality");

        jLabel264.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel264.setText("Purchase");

        jLabel265.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel265.setText("Chocolate Cheesecake wit");

        jLabel266.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-38-66370-1.jpg")); // NOI18N

        jLabel267.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel267.setText("50.0");

        jCheckBox38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox38ActionPerformed(evt);
            }
        });

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel262, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel263, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel264, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox38, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel267, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jLabel261, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel265))
                    .addComponent(jLabel266))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel266, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel261)
                    .addComponent(jLabel265))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel262)
                    .addComponent(jLabel267))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel263)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel264)
                    .addComponent(jCheckBox38))
                .addGap(16, 16, 16))
        );

        a5.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, 300));

        jPanel26.setBackground(new java.awt.Color(255, 153, 153));
        jPanel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel163.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel163.setText("Name");

        jLabel164.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel164.setText("Price");

        jLabel165.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel165.setText("Quantity");

        jLabel166.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel166.setText("Purchase");

        jLabel167.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel167.setText("Devils_food_Cake");

        jLabel169.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel169.setText("30.0");

        jSpinner24.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox24ActionPerformed(evt);
            }
        });

        jLabel168.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel168.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\devils-food-cake-1577124539.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel164, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox24, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel169, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel167, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                .addGap(27, 27, 27))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel163)
                    .addComponent(jLabel167))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel164)
                    .addComponent(jLabel169))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel165)
                    .addComponent(jSpinner24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel166)
                    .addComponent(jCheckBox24))
                .addGap(16, 16, 16))
        );

        a5.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 980, 230, 300));

        jPanel16.setBackground(new java.awt.Color(255, 153, 153));
        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel100.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel100.setText("Name");

        jLabel101.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel101.setText("Price");

        jLabel102.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel102.setText("Quantity");

        jLabel103.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel103.setText("Purchase");

        jLabel104.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel104.setText("Coconut_angel_Cake");

        jLabel105.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\coconut-angel-cake-1578333326.jpg")); // NOI18N

        jLabel106.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel106.setText("38.0");

        jSpinner16.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel105)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel104))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(jLabel104))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101)
                    .addComponent(jLabel106))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(jSpinner16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel103)
                    .addComponent(jCheckBox15))
                .addGap(16, 16, 16))
        );

        a5.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 230, 280));

        jPanel9.setBackground(new java.awt.Color(255, 153, 153));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel44.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel44.setText("Name");

        jLabel45.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel45.setText("Price");

        jLabel46.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel46.setText("Quantity");

        jLabel47.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel47.setText("Purchase");

        jLabel48.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel48.setText("Carrot Cake");

        jLabel49.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\carrot-cake-1574437118.jpg")); // NOI18N

        jLabel50.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel50.setText("40.0");

        jSpinner9.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel49))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jCheckBox7))
                .addGap(16, 16, 16))
        );

        a5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 660, 230, 290));

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1.jpg"))); // NOI18N
        a5.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 1280, 1560));

        jPanel6.add(a5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1061, 1953));

        p5.setBackground(new java.awt.Color(255, 204, 204));
        p5.setForeground(new java.awt.Color(255, 255, 255));
        p5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel48.setBackground(new java.awt.Color(255, 153, 153));
        jPanel48.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel317.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel317.setText("Name");

        jLabel318.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel318.setText("Price");

        jLabel319.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel319.setText("Quality");

        jLabel320.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel320.setText("Purchase");

        jLabel321.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel321.setText("Blueberry friands");

        jLabel322.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-40-66372-1.jpg")); // NOI18N

        jLabel323.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel323.setText("320");

        jCheckBox46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox46ActionPerformed(evt);
            }
        });

        jSpinner44.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel322)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel317, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel318, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel319, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel320, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox46, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel323, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel321))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel322, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel317)
                    .addComponent(jLabel321, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel318)
                    .addComponent(jLabel323))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel319)
                    .addComponent(jSpinner44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel320)
                    .addComponent(jCheckBox46))
                .addGap(16, 16, 16))
        );

        p5.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 670, -1, -1));

        jPanel45.setBackground(new java.awt.Color(255, 153, 153));
        jPanel45.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel289.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel289.setText("Name");

        jLabel290.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel290.setText("Price");

        jLabel291.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel291.setText("Quality");

        jLabel292.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel292.setText("Purchase");

        jLabel293.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel293.setText("Passionfruit slice Cake");

        jLabel294.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-44-66380-1.jpg")); // NOI18N

        jLabel295.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel295.setText("320");

        jCheckBox42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox42ActionPerformed(evt);
            }
        });

        jSpinner41.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel290, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel291, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel292, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox42, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel295, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(jLabel289, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel293)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel294, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel294, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel289)
                    .addComponent(jLabel293))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel290)
                    .addComponent(jLabel295))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel291)
                    .addComponent(jSpinner41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel292)
                    .addComponent(jCheckBox42))
                .addGap(16, 16, 16))
        );

        p5.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 240, -1));

        jPanel46.setBackground(new java.awt.Color(255, 153, 153));
        jPanel46.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel296.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel296.setText("Name");

        jLabel297.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel297.setText("Price");

        jLabel298.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel298.setText("Quality");

        jLabel299.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel299.setText("Purchase");

        jLabel300.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel300.setText("Banana caramel Cake");

        jLabel301.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-43-66379-1.jpg")); // NOI18N

        jLabel302.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel302.setText("320");

        jCheckBox43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox43ActionPerformed(evt);
            }
        });

        jSpinner42.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel296, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel297, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel298, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel299, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox43, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel302, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel300))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel301, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel301, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel296)
                    .addComponent(jLabel300))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel297)
                    .addComponent(jLabel302))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel298)
                    .addComponent(jSpinner42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel299)
                    .addComponent(jCheckBox43))
                .addGap(16, 16, 16))
        );

        p5.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        jPanel52.setBackground(new java.awt.Color(255, 153, 153));
        jPanel52.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel303.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel303.setText("Name");

        jLabel304.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel304.setText("Price");

        jLabel305.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel305.setText("Quality");

        jLabel306.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel306.setText("Purchase");

        jLabel307.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel307.setText("Raspberry Cake");

        jLabel308.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-42-66377-1.jpg")); // NOI18N

        jLabel309.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel309.setText("320");

        jCheckBox44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox44ActionPerformed(evt);
            }
        });

        jSpinner43.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel303, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel304, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel305, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel306, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox44, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel309, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel307, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel308)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel308, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel303)
                    .addComponent(jLabel307))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel304)
                    .addComponent(jLabel309))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel305)
                    .addComponent(jSpinner43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel306)
                    .addComponent(jCheckBox44))
                .addGap(16, 16, 16))
        );

        p5.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, -1, -1));

        jPanel53.setBackground(new java.awt.Color(255, 153, 153));
        jPanel53.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel345.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel345.setText("Name");

        jLabel346.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel346.setText("Price");

        jLabel347.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel347.setText("Quality");

        jLabel348.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel348.setText("Purchase");

        jLabel349.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel349.setText("Rock Cakes");

        jLabel350.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-41-66374-1.jpg")); // NOI18N

        jLabel351.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel351.setText("320");

        jCheckBox50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox50ActionPerformed(evt);
            }
        });

        jSpinner48.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel345, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel346, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel347, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel348, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox50, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel351, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel349, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel350)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel350, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel345)
                    .addComponent(jLabel349))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel346)
                    .addComponent(jLabel351))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel347)
                    .addComponent(jSpinner48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel348)
                    .addComponent(jCheckBox50))
                .addGap(16, 16, 16))
        );

        p5.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, 300));

        jPanel54.setBackground(new java.awt.Color(255, 153, 153));
        jPanel54.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel352.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel352.setText("Name");

        jLabel353.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel353.setText("Price");

        jLabel354.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel354.setText("Quality");

        jLabel355.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel355.setText("Purchase");

        jLabel356.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel356.setText("Chocolate Cheesecake wit");

        jLabel357.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-38-66370-1.jpg")); // NOI18N

        jLabel358.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel358.setText("500");

        jCheckBox51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox51ActionPerformed(evt);
            }
        });

        jSpinner22.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel353, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel354, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel355, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox51, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel358, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addComponent(jLabel352, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel356)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel357)
                .addGap(14, 14, 14))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel357, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel352)
                    .addComponent(jLabel356))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel353)
                    .addComponent(jLabel358))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel354)
                    .addComponent(jSpinner22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel355)
                    .addComponent(jCheckBox51))
                .addGap(16, 16, 16))
        );

        p5.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, 300));

        jPanel55.setBackground(new java.awt.Color(255, 153, 153));
        jPanel55.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel63.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel63.setText("Name");

        jLabel64.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel64.setText("Price");

        jLabel72.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel72.setText("Quality");

        jLabel73.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel73.setText("Purchase");

        jLabel74.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel74.setText("Caramel mud Cake");

        jLabel75.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-37-66369-1.jpg")); // NOI18N

        jLabel76.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel76.setText("520");

        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        jSpinner23.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jLabel74))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(jLabel76))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72)
                    .addComponent(jSpinner23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73)
                    .addComponent(jCheckBox9))
                .addGap(16, 16, 16))
        );

        p5.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 240, -1));

        jPanel19.setBackground(new java.awt.Color(255, 153, 153));
        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel77.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel77.setText("Name");

        jLabel78.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel78.setText("Price");

        jLabel93.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel93.setText("Quality");

        jLabel94.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel94.setText("Purchase");

        jLabel95.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel95.setText("Apple_Strawberry crumble");

        jLabel96.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-32-66360-1.jpg")); // NOI18N

        jLabel97.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel97.setText("420");

        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });

        jSpinner28.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel96)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jLabel95))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(jLabel97))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(jSpinner28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel94)
                    .addComponent(jCheckBox11))
                .addGap(16, 16, 16))
        );

        p5.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 980, -1, -1));

        jPanel21.setBackground(new java.awt.Color(255, 153, 153));
        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel98.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel98.setText("Name");

        jLabel99.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel99.setText("Price");

        jLabel121.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel121.setText("Quality");

        jLabel122.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel122.setText("Purchase");

        jLabel123.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel123.setText("Updown Cake");

        jLabel124.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\updowncake.jpg")); // NOI18N

        jLabel125.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel125.setText("330");

        jSpinner25.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel124)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 159, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(jLabel123))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel99)
                    .addComponent(jLabel125))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel121)
                    .addComponent(jSpinner25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel122)
                    .addComponent(jCheckBox14))
                .addGap(16, 16, 16))
        );

        p5.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 300));

        jPanel56.setBackground(new java.awt.Color(255, 153, 153));
        jPanel56.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel126.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel126.setText("Name");

        jLabel127.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel127.setText("Price");

        jLabel129.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel129.setText("Quality");

        jLabel130.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel130.setText("Purchase");

        jLabel131.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel131.setText("Almond Cake");

        jLabel132.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-49-66387-1.jpg")); // NOI18N

        jLabel133.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel133.setText("450");

        jSpinner49.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel132, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel131, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel126)
                    .addComponent(jLabel131))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel127)
                    .addComponent(jLabel133))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel129)
                    .addComponent(jSpinner49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel130)
                    .addComponent(jCheckBox18))
                .addGap(16, 16, 16))
        );

        p5.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 670, -1, 310));

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1.jpg"))); // NOI18N
        p5.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 1840));

        jPanel6.add(p5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1061, 1946));

        q3.setBackground(new java.awt.Color(255, 204, 204));
        q3.setForeground(new java.awt.Color(255, 255, 255));
        q3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel49.setBackground(new java.awt.Color(255, 153, 153));
        jPanel49.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel324.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel324.setText("Name");

        jLabel325.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel325.setText("Price");

        jLabel326.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel326.setText("Quality");

        jLabel327.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel327.setText("Purchase");

        jLabel328.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel328.setText("Rock Cakes");

        jLabel329.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-41-66374-1.jpg")); // NOI18N

        jLabel330.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel330.setText("320");

        jCheckBox47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox47ActionPerformed(evt);
            }
        });

        jSpinner45.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel324, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel325, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel326, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel327, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox47, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel330, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel328, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel329)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel329, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel324)
                    .addComponent(jLabel328))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel325)
                    .addComponent(jLabel330))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel326)
                    .addComponent(jSpinner45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel327)
                    .addComponent(jCheckBox47))
                .addGap(16, 16, 16))
        );

        q3.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jPanel57.setBackground(new java.awt.Color(255, 153, 153));
        jPanel57.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel359.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel359.setText("Name");

        jLabel360.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel360.setText("Price");

        jLabel361.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel361.setText("Quality");

        jLabel362.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel362.setText("Purchase");

        jLabel363.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel363.setText("Passionfruit slice Cake");

        jLabel364.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-44-66380-1.jpg")); // NOI18N

        jLabel365.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel365.setText("320");

        jCheckBox52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox52ActionPerformed(evt);
            }
        });

        jSpinner50.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel359, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel360, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel361, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel362, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox52, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel365, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jLabel363)
                        .addContainerGap())))
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel364, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel364, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel359)
                    .addComponent(jLabel363))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel360)
                    .addComponent(jLabel365))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel361)
                    .addComponent(jSpinner50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel362)
                    .addComponent(jCheckBox52))
                .addGap(16, 16, 16))
        );

        q3.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, -1, -1));

        jPanel58.setBackground(new java.awt.Color(255, 153, 153));
        jPanel58.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel366.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel366.setText("Name");

        jLabel367.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel367.setText("Price");

        jLabel368.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel368.setText("Quality");

        jLabel369.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel369.setText("Purchase");

        jLabel370.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel370.setText("Banana caramel Cake");

        jLabel371.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-43-66379-1.jpg")); // NOI18N

        jLabel372.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel372.setText("320");

        jCheckBox53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox53ActionPerformed(evt);
            }
        });

        jSpinner51.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel366, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel367, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel368, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel369, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox53, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel372, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel370))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel58Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel371, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel371, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel366)
                    .addComponent(jLabel370))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel367)
                    .addComponent(jLabel372))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel368)
                    .addComponent(jSpinner51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel369)
                    .addComponent(jCheckBox53))
                .addGap(16, 16, 16))
        );

        q3.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jPanel59.setBackground(new java.awt.Color(255, 153, 153));
        jPanel59.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel373.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel373.setText("Name");

        jLabel374.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel374.setText("Price");

        jLabel375.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel375.setText("Quality");

        jLabel376.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel376.setText("Purchase");

        jLabel377.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel377.setText("Raspberry Cake");

        jLabel378.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-42-66377-1.jpg")); // NOI18N

        jLabel379.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel379.setText("320");

        jCheckBox54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox54ActionPerformed(evt);
            }
        });

        jSpinner52.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel373, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel374, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel375, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel376, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox54, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel379, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel377, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel378)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel378, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel373)
                    .addComponent(jLabel377))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel374)
                    .addComponent(jLabel379))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel375)
                    .addComponent(jSpinner52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel376)
                    .addComponent(jCheckBox54))
                .addGap(16, 16, 16))
        );

        q3.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        jPanel60.setBackground(new java.awt.Color(255, 153, 153));
        jPanel60.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel380.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel380.setText("Name");

        jLabel381.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel381.setText("Price");

        jLabel382.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel382.setText("Quality");

        jLabel383.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel383.setText("Purchase");

        jLabel384.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel384.setText("Rock Cakes");

        jLabel385.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-41-66374-1.jpg")); // NOI18N

        jLabel386.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel386.setText("320");

        jCheckBox55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox55ActionPerformed(evt);
            }
        });

        jSpinner53.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel380, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel381, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel382, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel383, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox55, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel386, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel384, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel385)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel385, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel380)
                    .addComponent(jLabel384))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel381)
                    .addComponent(jLabel386))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel382)
                    .addComponent(jSpinner53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel383)
                    .addComponent(jCheckBox55))
                .addGap(16, 16, 16))
        );

        q3.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, -1));

        jPanel61.setBackground(new java.awt.Color(255, 153, 153));
        jPanel61.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel387.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel387.setText("Name");

        jLabel388.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel388.setText("Price");

        jLabel389.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel389.setText("Quality");

        jLabel390.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel390.setText("Purchase");

        jLabel391.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel391.setText("Chocolate Cheesecake wit");

        jLabel392.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-38-66370-1.jpg")); // NOI18N

        jLabel393.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel393.setText("500");

        jCheckBox56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox56ActionPerformed(evt);
            }
        });

        jSpinner54.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel392)
                    .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel61Layout.createSequentialGroup()
                            .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel388, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel389, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel390, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)
                            .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox56, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel393, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinner54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel61Layout.createSequentialGroup()
                            .addComponent(jLabel387, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(jLabel391))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel392, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel387)
                    .addComponent(jLabel391))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel388)
                    .addComponent(jLabel393))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel389)
                    .addComponent(jSpinner54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel390)
                    .addComponent(jCheckBox56))
                .addGap(16, 16, 16))
        );

        q3.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 250, -1));

        jPanel62.setBackground(new java.awt.Color(255, 153, 153));
        jPanel62.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel134.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel134.setText("Name");

        jLabel135.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel135.setText("Price");

        jLabel136.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel136.setText("Quality");

        jLabel137.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel137.setText("Purchase");

        jLabel138.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel138.setText("Caramel mud Cake");

        jLabel139.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-37-66369-1.jpg")); // NOI18N

        jLabel140.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel140.setText("520");

        jCheckBox19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox19ActionPerformed(evt);
            }
        });

        jSpinner55.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel62Layout.createSequentialGroup()
                        .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel138))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jLabel139, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134)
                    .addComponent(jLabel138))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel135)
                    .addComponent(jLabel140))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel136)
                    .addComponent(jSpinner55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel137)
                    .addComponent(jCheckBox19))
                .addGap(16, 16, 16))
        );

        q3.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 650, -1, -1));

        jPanel63.setBackground(new java.awt.Color(255, 153, 153));
        jPanel63.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel141.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel141.setText("Name");

        jLabel149.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel149.setText("Price");

        jLabel150.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel150.setText("Quality");

        jLabel151.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel151.setText("Purchase");

        jLabel152.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel152.setText("Apple_Strawberry crumble");

        jLabel153.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-32-66360-1.jpg")); // NOI18N

        jLabel154.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel154.setText("420");

        jCheckBox20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox20ActionPerformed(evt);
            }
        });

        jSpinner56.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox20, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel152, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel153, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel153)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel141)
                    .addComponent(jLabel152))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149)
                    .addComponent(jLabel154))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel150)
                    .addComponent(jSpinner56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel151)
                    .addComponent(jCheckBox20))
                .addGap(16, 16, 16))
        );

        q3.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 650, 240, 300));

        jPanel64.setBackground(new java.awt.Color(255, 153, 153));
        jPanel64.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel155.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel155.setText("Name");

        jLabel156.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel156.setText("Price");

        jLabel157.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel157.setText("Quality");

        jLabel158.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel158.setText("Purchase");

        jLabel159.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel159.setText("Updown Cake");

        jLabel160.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\updowncake.jpg")); // NOI18N

        jLabel161.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel161.setText("330");

        jSpinner57.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel156, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel158, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel159, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel160)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel155)
                    .addComponent(jLabel159))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel156)
                    .addComponent(jLabel161))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel157)
                    .addComponent(jSpinner57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel158)
                    .addComponent(jCheckBox22))
                .addGap(16, 16, 16))
        );

        q3.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 980, 250, 260));

        jPanel65.setBackground(new java.awt.Color(255, 153, 153));
        jPanel65.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel162.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel162.setText("Name");

        jLabel170.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel170.setText("Price");

        jLabel171.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel171.setText("Quality");

        jLabel172.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel172.setText("Purchase");

        jLabel173.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel173.setText("Almond Cake");

        jLabel174.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-49-66387-1.jpg")); // NOI18N

        jLabel175.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel175.setText("450");

        jSpinner58.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel174, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addGroup(jPanel65Layout.createSequentialGroup()
                        .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel162, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel170, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel175, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel173, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel162)
                    .addComponent(jLabel173))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel170)
                    .addComponent(jLabel175))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel171)
                    .addComponent(jSpinner58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel172)
                    .addComponent(jCheckBox23))
                .addGap(16, 16, 16))
        );

        q3.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1.jpg"))); // NOI18N
        q3.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 1840));

        jPanel6.add(q3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 1055, 1946));

        r3.setBackground(new java.awt.Color(255, 204, 204));
        r3.setForeground(new java.awt.Color(255, 255, 255));
        r3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel50.setBackground(new java.awt.Color(255, 153, 153));
        jPanel50.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel331.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel331.setText("Name");

        jLabel332.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel332.setText("Price");

        jLabel333.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel333.setText("Quality");

        jLabel334.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel334.setText("Purchase");

        jLabel335.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel335.setText("Raspberry Cake");

        jLabel336.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-42-66377-1.jpg")); // NOI18N

        jLabel337.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel337.setText("320");

        jCheckBox48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox48ActionPerformed(evt);
            }
        });

        jSpinner46.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel331, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel332, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel333, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel334, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox48, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel337, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel335, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel336)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel336, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel331)
                    .addComponent(jLabel335))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel332)
                    .addComponent(jLabel337))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel333)
                    .addComponent(jSpinner46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel334)
                    .addComponent(jCheckBox48))
                .addGap(16, 16, 16))
        );

        r3.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 310));

        jPanel72.setBackground(new java.awt.Color(255, 153, 153));
        jPanel72.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel441.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel441.setText("Name");

        jLabel442.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel442.setText("Price");

        jLabel443.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel443.setText("Quality");

        jLabel444.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel444.setText("Purchase");

        jLabel445.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel445.setText("Devils_food_Cake");

        jLabel446.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel446.setText("300");

        jSpinner66.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox65ActionPerformed(evt);
            }
        });

        jLabel447.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel447.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\devils-food-cake-1577124539.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel441, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel442, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel443, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel444, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox65, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel446, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel445, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                .addGap(27, 27, 27))
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel447, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel447, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel441)
                    .addComponent(jLabel445))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel442)
                    .addComponent(jLabel446))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel443)
                    .addComponent(jSpinner66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel444)
                    .addComponent(jCheckBox65))
                .addGap(16, 16, 16))
        );

        r3.add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 630, 240, 280));

        jPanel73.setBackground(new java.awt.Color(255, 153, 153));
        jPanel73.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel448.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel448.setText("Name");

        jLabel449.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel449.setText("Price");

        jLabel450.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel450.setText("Quality");

        jLabel451.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel451.setText("Purchase");

        jLabel452.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel452.setText("Carrot Cake");

        jLabel453.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\carrot-cake-1574437118.jpg")); // NOI18N

        jLabel454.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel454.setText("400");

        jSpinner67.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox66ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel448, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel449, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel450, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel451, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox66, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel454, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel452, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel453))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel453, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel448)
                    .addComponent(jLabel452))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel449)
                    .addComponent(jLabel454))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel450)
                    .addComponent(jSpinner67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel451)
                    .addComponent(jCheckBox66))
                .addGap(16, 16, 16))
        );

        r3.add(jPanel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 230, -1));

        jPanel74.setBackground(new java.awt.Color(255, 153, 153));
        jPanel74.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel455.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel455.setText("Name");

        jLabel456.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel456.setText("Price");

        jLabel457.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel457.setText("Quality");

        jLabel458.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel458.setText("Purchase");

        jLabel459.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel459.setText("Chocolate Cheesecake wit");

        jLabel460.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-35-66367-1.jpg")); // NOI18N

        jLabel461.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel461.setText("490");

        jCheckBox68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox68ActionPerformed(evt);
            }
        });

        jSpinner68.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel456, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel457, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel458, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox68, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel461, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addComponent(jLabel455, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel459, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel460)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel460, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel455)
                    .addComponent(jLabel459))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel456)
                    .addComponent(jLabel461))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel457)
                    .addComponent(jSpinner68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel458)
                    .addComponent(jCheckBox68))
                .addGap(16, 16, 16))
        );

        r3.add(jPanel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 230, 280));

        jPanel75.setBackground(new java.awt.Color(255, 153, 153));
        jPanel75.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel462.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel462.setText("Name");

        jLabel463.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel463.setText("Price");

        jLabel464.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel464.setText("Quality");

        jLabel465.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel465.setText("Purchase");

        jLabel466.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel466.setText("Yellow_butter_Cake");

        jLabel467.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\3-layer-yellow-butter-cake-1574436790.jpg")); // NOI18N

        jLabel468.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel468.setText("360");

        jSpinner69.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox69ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel467, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel75Layout.createSequentialGroup()
                        .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel462, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel463, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel464, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel465, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox69, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel468, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel466))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel467, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel462)
                    .addComponent(jLabel466))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel463)
                    .addComponent(jLabel468))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel464)
                    .addComponent(jSpinner69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel465)
                    .addComponent(jCheckBox69))
                .addGap(16, 16, 16))
        );

        r3.add(jPanel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, 280));

        jPanel76.setBackground(new java.awt.Color(255, 153, 153));
        jPanel76.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel469.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel469.setText("Name");

        jLabel470.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel470.setText("Price");

        jLabel471.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel471.setText("Quality");

        jLabel472.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel472.setText("Purchase");

        jLabel473.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel473.setText("Chocolate mousse Cake");

        jLabel474.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-30-66357-1.jpg")); // NOI18N

        jLabel475.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel475.setText("450");

        jSpinner70.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox70ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel76Layout.createSequentialGroup()
                        .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel470, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel471, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel472, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox70, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel475, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel76Layout.createSequentialGroup()
                        .addComponent(jLabel469, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel473, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel474))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addComponent(jLabel474, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel469)
                    .addComponent(jLabel473))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel470)
                    .addComponent(jLabel475))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel471)
                    .addComponent(jSpinner70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel472)
                    .addComponent(jCheckBox70))
                .addGap(16, 16, 16))
        );

        r3.add(jPanel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 230, 280));

        jPanel77.setBackground(new java.awt.Color(255, 153, 153));
        jPanel77.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel476.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel476.setText("Name");

        jLabel477.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel477.setText("Price");

        jLabel478.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel478.setText("Quality");

        jLabel479.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel479.setText("Purchase");

        jLabel480.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel480.setText("Chocolate Cheesecake wit");

        jLabel481.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-38-66370-1.jpg")); // NOI18N

        jLabel482.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel482.setText("500");

        jCheckBox72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox72ActionPerformed(evt);
            }
        });

        jSpinner71.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel477, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel478, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel479, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox72, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel482, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addComponent(jLabel476, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel480))
                    .addComponent(jLabel481))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel481, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel476)
                    .addComponent(jLabel480))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel477)
                    .addComponent(jLabel482))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel478)
                    .addComponent(jSpinner71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel479)
                    .addComponent(jCheckBox72))
                .addGap(16, 16, 16))
        );

        r3.add(jPanel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, -1, 310));

        jPanel78.setBackground(new java.awt.Color(255, 153, 153));
        jPanel78.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel483.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel483.setText("Name");

        jLabel484.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel484.setText("Price");

        jLabel485.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel485.setText("Quality");

        jLabel486.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel486.setText("Purchase");

        jLabel487.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel487.setText("Chocolate matcha swirl");

        jLabel488.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\chocolate-matcha-swirl-pound-cake-1574437002.jpg")); // NOI18N

        jLabel489.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel489.setText("234");

        jSpinner72.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox73ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel78Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel78Layout.createSequentialGroup()
                                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel484, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel485, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel486, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox73, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel489, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 33, Short.MAX_VALUE))
                            .addGroup(jPanel78Layout.createSequentialGroup()
                                .addComponent(jLabel483, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel487, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel78Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel488)))
                .addContainerGap())
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel488, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel483)
                    .addComponent(jLabel487))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel484)
                    .addComponent(jLabel489))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel485)
                    .addComponent(jSpinner72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel486)
                    .addComponent(jCheckBox73))
                .addGap(16, 16, 16))
        );

        r3.add(jPanel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, 310));

        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1.jpg"))); // NOI18N
        r3.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 1840));

        jPanel6.add(r3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1055, 2180));

        s3.setBackground(new java.awt.Color(255, 204, 204));
        s3.setForeground(new java.awt.Color(255, 255, 255));
        s3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel82.setBackground(new java.awt.Color(255, 153, 153));
        jPanel82.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel511.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel511.setText("Name");

        jLabel512.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel512.setText("Price");

        jLabel513.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel513.setText("Quality");

        jLabel514.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel514.setText("Purchase");

        jLabel515.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel515.setText("Rock Cakes");

        jLabel516.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-41-66374-1.jpg")); // NOI18N

        jLabel517.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel517.setText("320");

        jCheckBox75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox75ActionPerformed(evt);
            }
        });

        jSpinner76.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel82Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel511, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel512, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel513, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel514, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox75, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel517, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel515, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel82Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel516)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel516, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel511)
                    .addComponent(jLabel515))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel512)
                    .addComponent(jLabel517))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel513)
                    .addComponent(jSpinner76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel514)
                    .addComponent(jCheckBox75))
                .addGap(16, 16, 16))
        );

        s3.add(jPanel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, 300));

        jPanel90.setBackground(new java.awt.Color(255, 153, 153));
        jPanel90.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel567.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel567.setText("Name");

        jLabel568.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel568.setText("Price");

        jLabel569.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel569.setText("Quality");

        jLabel570.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel570.setText("Purchase");

        jLabel571.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel571.setText("Passionfruit slice Cake");

        jLabel572.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-44-66380-1.jpg")); // NOI18N

        jLabel573.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel573.setText("320");

        jCheckBox83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox83ActionPerformed(evt);
            }
        });

        jSpinner84.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel90Layout = new javax.swing.GroupLayout(jPanel90);
        jPanel90.setLayout(jPanel90Layout);
        jPanel90Layout.setHorizontalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel567, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel568, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel569, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel570, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel90Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox83, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel573, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel90Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jLabel571)
                        .addContainerGap())))
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel572, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel90Layout.setVerticalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel572, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel567)
                    .addComponent(jLabel571))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel568)
                    .addComponent(jLabel573))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel569)
                    .addComponent(jSpinner84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel570)
                    .addComponent(jCheckBox83))
                .addGap(16, 16, 16))
        );

        s3.add(jPanel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 240, -1));

        jPanel91.setBackground(new java.awt.Color(255, 153, 153));
        jPanel91.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel574.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel574.setText("Name");

        jLabel575.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel575.setText("Price");

        jLabel576.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel576.setText("Quality");

        jLabel577.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel577.setText("Purchase");

        jLabel578.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel578.setText("Banana caramel Cake");

        jLabel579.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-43-66379-1.jpg")); // NOI18N

        jLabel580.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel580.setText("320");

        jCheckBox84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox84ActionPerformed(evt);
            }
        });

        jSpinner85.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel91Layout = new javax.swing.GroupLayout(jPanel91);
        jPanel91.setLayout(jPanel91Layout);
        jPanel91Layout.setHorizontalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel574, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel575, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel576, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel577, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox84, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel580, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel578))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel91Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel579, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel91Layout.setVerticalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel579, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel574)
                    .addComponent(jLabel578))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel575)
                    .addComponent(jLabel580))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel576)
                    .addComponent(jSpinner85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel577)
                    .addComponent(jCheckBox84))
                .addGap(16, 16, 16))
        );

        s3.add(jPanel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, 300));

        jPanel92.setBackground(new java.awt.Color(255, 153, 153));
        jPanel92.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel581.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel581.setText("Name");

        jLabel582.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel582.setText("Price");

        jLabel583.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel583.setText("Quality");

        jLabel584.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel584.setText("Purchase");

        jLabel585.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel585.setText("Raspberry Cake");

        jLabel586.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-42-66377-1.jpg")); // NOI18N

        jLabel587.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel587.setText("320");

        jCheckBox85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox85ActionPerformed(evt);
            }
        });

        jSpinner86.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel92Layout = new javax.swing.GroupLayout(jPanel92);
        jPanel92.setLayout(jPanel92Layout);
        jPanel92Layout.setHorizontalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addGroup(jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel92Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel581, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel582, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel583, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel584, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox85, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel587, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel585, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel92Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel586)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel92Layout.setVerticalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel586, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel581)
                    .addComponent(jLabel585))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel582)
                    .addComponent(jLabel587))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel583)
                    .addComponent(jSpinner86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel584)
                    .addComponent(jCheckBox85))
                .addGap(16, 16, 16))
        );

        s3.add(jPanel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        jPanel93.setBackground(new java.awt.Color(255, 153, 153));
        jPanel93.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel588.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel588.setText("Name");

        jLabel589.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel589.setText("Price");

        jLabel590.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel590.setText("Quality");

        jLabel591.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel591.setText("Purchase");

        jLabel592.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel592.setText("Almond Cake");

        jLabel593.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-49-66387-1.jpg")); // NOI18N

        jLabel594.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel594.setText("450");

        jSpinner87.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox86ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel93Layout = new javax.swing.GroupLayout(jPanel93);
        jPanel93.setLayout(jPanel93Layout);
        jPanel93Layout.setHorizontalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel93Layout.createSequentialGroup()
                        .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel588, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel589, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel590, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel591, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel594, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel592, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addComponent(jLabel593, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel93Layout.setVerticalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel593, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel588)
                    .addComponent(jLabel592))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel589)
                    .addComponent(jLabel594))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel590)
                    .addComponent(jSpinner87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel591)
                    .addComponent(jCheckBox86))
                .addGap(16, 16, 16))
        );

        s3.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 300));

        jPanel94.setBackground(new java.awt.Color(255, 153, 153));
        jPanel94.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel595.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel595.setText("Name");

        jLabel596.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel596.setText("Price");

        jLabel597.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel597.setText("Quality");

        jLabel598.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel598.setText("Purchase");

        jLabel599.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel599.setText("Updown Cake");

        jLabel600.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\updowncake.jpg")); // NOI18N

        jLabel601.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel601.setText("330");

        jSpinner88.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox87ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel94Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel595, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel596, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel597, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel598, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel601, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel599, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel94Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel600)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel600, javax.swing.GroupLayout.PREFERRED_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel595)
                    .addComponent(jLabel599))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel596)
                    .addComponent(jLabel601))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel597)
                    .addComponent(jSpinner88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel598)
                    .addComponent(jCheckBox87))
                .addGap(16, 16, 16))
        );

        s3.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 980, 240, 260));

        jPanel95.setBackground(new java.awt.Color(255, 153, 153));
        jPanel95.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel602.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel602.setText("Name");

        jLabel603.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel603.setText("Price");

        jLabel604.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel604.setText("Quality");

        jLabel605.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel605.setText("Purchase");

        jLabel606.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel606.setText("Apple_Strawberry crumble");

        jLabel607.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-32-66360-1.jpg")); // NOI18N

        jLabel608.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel608.setText("420");

        jCheckBox88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox88ActionPerformed(evt);
            }
        });

        jSpinner89.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel603, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel604, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel605, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox88, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel608, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addComponent(jLabel602, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel606, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel607, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel607)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel602)
                    .addComponent(jLabel606))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel603)
                    .addComponent(jLabel608))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel604)
                    .addComponent(jSpinner89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel605)
                    .addComponent(jCheckBox88))
                .addGap(16, 16, 16))
        );

        s3.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 650, 240, 300));

        jPanel96.setBackground(new java.awt.Color(255, 153, 153));
        jPanel96.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel609.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel609.setText("Name");

        jLabel610.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel610.setText("Price");

        jLabel611.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel611.setText("Quality");

        jLabel612.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel612.setText("Purchase");

        jLabel613.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel613.setText("Caramel mud Cake");

        jLabel614.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-37-66369-1.jpg")); // NOI18N

        jLabel615.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel615.setText("520");

        jCheckBox89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox89ActionPerformed(evt);
            }
        });

        jSpinner90.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel96Layout.createSequentialGroup()
                        .addGroup(jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel609, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel610, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel611, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel612, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox89, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel615, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel613))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jLabel614, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel614, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel609)
                    .addComponent(jLabel613))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel610)
                    .addComponent(jLabel615))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel611)
                    .addComponent(jSpinner90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel612)
                    .addComponent(jCheckBox89))
                .addGap(16, 16, 16))
        );

        s3.add(jPanel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 650, -1, -1));

        jPanel97.setBackground(new java.awt.Color(255, 153, 153));
        jPanel97.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel616.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel616.setText("Name");

        jLabel617.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel617.setText("Price");

        jLabel618.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel618.setText("Quality");

        jLabel619.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel619.setText("Purchase");

        jLabel620.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel620.setText("Chocolate Cheesecake wit");

        jLabel621.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-38-66370-1.jpg")); // NOI18N

        jLabel622.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel622.setText("500");

        jCheckBox90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox90ActionPerformed(evt);
            }
        });

        jSpinner91.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel621)
                    .addGroup(jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel97Layout.createSequentialGroup()
                            .addGroup(jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel617, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel618, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel619, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)
                            .addGroup(jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox90, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel622, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinner91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel97Layout.createSequentialGroup()
                            .addComponent(jLabel616, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(jLabel620))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel621, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel616)
                    .addComponent(jLabel620))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel617)
                    .addComponent(jLabel622))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel618)
                    .addComponent(jSpinner91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel619)
                    .addComponent(jCheckBox90))
                .addGap(16, 16, 16))
        );

        s3.add(jPanel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 240, -1));

        jPanel98.setBackground(new java.awt.Color(255, 153, 153));
        jPanel98.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel623.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel623.setText("Name");

        jLabel624.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel624.setText("Price");

        jLabel625.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel625.setText("Quality");

        jLabel626.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel626.setText("Purchase");

        jLabel627.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel627.setText("Rock Cakes");

        jLabel628.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-41-66374-1.jpg")); // NOI18N

        jLabel629.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel629.setText("320");

        jCheckBox91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox91ActionPerformed(evt);
            }
        });

        jSpinner92.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel98Layout = new javax.swing.GroupLayout(jPanel98);
        jPanel98.setLayout(jPanel98Layout);
        jPanel98Layout.setHorizontalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addGroup(jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel98Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel623, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel624, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel625, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel626, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox91, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel629, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel627, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel98Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel628)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel98Layout.setVerticalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel628, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel623)
                    .addComponent(jLabel627))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel624)
                    .addComponent(jLabel629))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel625)
                    .addComponent(jSpinner92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel626)
                    .addComponent(jCheckBox91))
                .addGap(16, 16, 16))
        );

        s3.add(jPanel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, -1));

        jLabel176.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1.jpg"))); // NOI18N
        s3.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 1840));

        jPanel6.add(s3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1061, 1968));

        t3.setBackground(new java.awt.Color(255, 204, 204));
        t3.setForeground(new java.awt.Color(255, 255, 255));
        t3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel81.setBackground(new java.awt.Color(255, 153, 153));
        jPanel81.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel504.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel504.setText("Name");

        jLabel505.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel505.setText("Price");

        jLabel506.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel506.setText("Quality");

        jLabel507.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel507.setText("Purchase");

        jLabel508.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel508.setText("Passionfruit slice Cake");

        jLabel509.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-44-66380-1.jpg")); // NOI18N

        jLabel510.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel510.setText("320");

        jCheckBox74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox74ActionPerformed(evt);
            }
        });

        jSpinner75.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel81Layout.createSequentialGroup()
                        .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel504, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel505, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel506, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel507, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel81Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox74, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel510, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel81Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel508)
                                .addContainerGap())))
                    .addGroup(jPanel81Layout.createSequentialGroup()
                        .addComponent(jLabel509, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel509, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel504)
                    .addComponent(jLabel508))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel505)
                    .addComponent(jLabel510))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel506)
                    .addComponent(jSpinner75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel507)
                    .addComponent(jCheckBox74))
                .addGap(16, 16, 16))
        );

        t3.add(jPanel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        jPanel83.setBackground(new java.awt.Color(255, 153, 153));
        jPanel83.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel518.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel518.setText("Name");

        jLabel519.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel519.setText("Price");

        jLabel520.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel520.setText("Quality");

        jLabel521.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel521.setText("Purchase");

        jLabel522.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel522.setText("Raspberry Cake");

        jLabel523.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-42-66377-1.jpg")); // NOI18N

        jLabel524.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel524.setText("320");

        jCheckBox76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox76ActionPerformed(evt);
            }
        });

        jSpinner77.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel83Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel518, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel519, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel520, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel521, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox76, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel524, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel522, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel83Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel523)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel83Layout.setVerticalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel523, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel518)
                    .addComponent(jLabel522))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel519)
                    .addComponent(jLabel524))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel520)
                    .addComponent(jSpinner77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel521)
                    .addComponent(jCheckBox76))
                .addGap(16, 16, 16))
        );

        t3.add(jPanel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jPanel84.setBackground(new java.awt.Color(255, 153, 153));
        jPanel84.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel525.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel525.setText("Name");

        jLabel526.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel526.setText("Price");

        jLabel527.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel527.setText("Quality");

        jLabel528.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel528.setText("Purchase");

        jLabel529.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel529.setText("Rock Cakes");

        jLabel530.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-41-66374-1.jpg")); // NOI18N

        jLabel531.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel531.setText("320");

        jCheckBox77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox77ActionPerformed(evt);
            }
        });

        jSpinner78.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel525, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel526, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel527, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel528, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox77, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel531, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel529, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel530)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel530, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel525)
                    .addComponent(jLabel529))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel526)
                    .addComponent(jLabel531))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel527)
                    .addComponent(jSpinner78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel528)
                    .addComponent(jCheckBox77))
                .addGap(16, 16, 16))
        );

        t3.add(jPanel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 230, 310));

        jPanel86.setBackground(new java.awt.Color(255, 153, 153));
        jPanel86.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel539.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel539.setText("Name");

        jLabel540.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel540.setText("Price");

        jLabel541.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel541.setText("Quality");

        jLabel542.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel542.setText("Purchase");

        jLabel543.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel543.setText("Updown Cake");

        jLabel544.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\updowncake.jpg")); // NOI18N

        jLabel545.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel545.setText("330");

        jSpinner80.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox79ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel86Layout = new javax.swing.GroupLayout(jPanel86);
        jPanel86.setLayout(jPanel86Layout);
        jPanel86Layout.setHorizontalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel86Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel539, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel540, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel541, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel542, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel545, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel543, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel86Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel544)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel86Layout.setVerticalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel544, javax.swing.GroupLayout.PREFERRED_SIZE, 159, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel539)
                    .addComponent(jLabel543))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel540)
                    .addComponent(jLabel545))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel541)
                    .addComponent(jSpinner80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel542)
                    .addComponent(jCheckBox79, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        t3.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 650, -1, 300));

        jPanel87.setBackground(new java.awt.Color(255, 153, 153));
        jPanel87.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel546.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel546.setText("Name");

        jLabel547.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel547.setText("Price");

        jLabel548.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel548.setText("Quality");

        jLabel549.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel549.setText("Purchase");

        jLabel550.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel550.setText("Almond Cake");

        jLabel551.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-49-66387-1.jpg")); // NOI18N

        jLabel552.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel552.setText("450");

        jSpinner81.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jCheckBox80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox80ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel87Layout = new javax.swing.GroupLayout(jPanel87);
        jPanel87.setLayout(jPanel87Layout);
        jPanel87Layout.setHorizontalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel551, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addGroup(jPanel87Layout.createSequentialGroup()
                        .addGroup(jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel546, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel547, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel548, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel549, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel552, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel550, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel551, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel546)
                    .addComponent(jLabel550))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel547)
                    .addComponent(jLabel552))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel548)
                    .addComponent(jSpinner81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel549)
                    .addComponent(jCheckBox80))
                .addGap(16, 16, 16))
        );

        t3.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        jPanel88.setBackground(new java.awt.Color(255, 153, 153));
        jPanel88.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel553.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel553.setText("Name");

        jLabel554.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel554.setText("Price");

        jLabel555.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel555.setText("Quality");

        jLabel556.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel556.setText("Purchase");

        jLabel557.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel557.setText("Caramel mud Cake");

        jLabel558.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-37-66369-1.jpg")); // NOI18N

        jLabel559.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel559.setText("520");

        jCheckBox81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox81ActionPerformed(evt);
            }
        });

        jSpinner82.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel88Layout = new javax.swing.GroupLayout(jPanel88);
        jPanel88.setLayout(jPanel88Layout);
        jPanel88Layout.setHorizontalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel88Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel88Layout.createSequentialGroup()
                        .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel553, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel554, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel555, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel556, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox81, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel559, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel557))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jLabel558, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel88Layout.setVerticalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel88Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel558, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel553)
                    .addComponent(jLabel557))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel554)
                    .addComponent(jLabel559))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel555)
                    .addComponent(jSpinner82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel556)
                    .addComponent(jCheckBox81))
                .addGap(16, 16, 16))
        );

        t3.add(jPanel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        jPanel89.setBackground(new java.awt.Color(255, 153, 153));
        jPanel89.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel560.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel560.setText("Name");

        jLabel561.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel561.setText("Price");

        jLabel562.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel562.setText("Quality");

        jLabel563.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel563.setText("Purchase");

        jLabel564.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel564.setText("Chocolate Cheesecake wit");

        jLabel565.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-38-66370-1.jpg")); // NOI18N

        jLabel566.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel566.setText("500");

        jCheckBox82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox82ActionPerformed(evt);
            }
        });

        jSpinner83.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel89Layout = new javax.swing.GroupLayout(jPanel89);
        jPanel89.setLayout(jPanel89Layout);
        jPanel89Layout.setHorizontalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel89Layout.createSequentialGroup()
                        .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel561, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel562, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel563, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox82, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel566, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel89Layout.createSequentialGroup()
                        .addComponent(jLabel560, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel564)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel89Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel565)
                .addGap(14, 14, 14))
        );
        jPanel89Layout.setVerticalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel565, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel560)
                    .addComponent(jLabel564))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel561)
                    .addComponent(jLabel566))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel562)
                    .addComponent(jSpinner83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel563)
                    .addComponent(jCheckBox82))
                .addGap(16, 16, 16))
        );

        t3.add(jPanel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 650, 240, 300));

        jPanel85.setBackground(new java.awt.Color(255, 153, 153));
        jPanel85.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel532.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel532.setText("Name");

        jLabel533.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel533.setText("Price");

        jLabel534.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel534.setText("Quality");

        jLabel535.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel535.setText("Purchase");

        jLabel536.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel536.setText("Apple_Strawberry crumble");

        jLabel537.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-32-66360-1.jpg")); // NOI18N

        jLabel538.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel538.setText("420");

        jCheckBox78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox78ActionPerformed(evt);
            }
        });

        jSpinner79.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel85Layout = new javax.swing.GroupLayout(jPanel85);
        jPanel85.setLayout(jPanel85Layout);
        jPanel85Layout.setHorizontalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel85Layout.createSequentialGroup()
                        .addGroup(jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel533, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel534, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel535, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox78, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel538, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel85Layout.createSequentialGroup()
                        .addComponent(jLabel532, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel536, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel85Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel537, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel85Layout.setVerticalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel537)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel532)
                    .addComponent(jLabel536))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel533)
                    .addComponent(jLabel538))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel534)
                    .addComponent(jSpinner79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel535)
                    .addComponent(jCheckBox78))
                .addGap(16, 16, 16))
        );

        t3.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 960, 250, -1));

        jPanel80.setBackground(new java.awt.Color(255, 153, 153));
        jPanel80.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel497.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel497.setText("Name");

        jLabel498.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel498.setText("Price");

        jLabel499.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel499.setText("Quality");

        jLabel500.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel500.setText("Purchase");

        jLabel501.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel501.setText("Passionfruit slice Cake");

        jLabel502.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-44-66380-1.jpg")); // NOI18N

        jLabel503.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel503.setText("320");

        jCheckBox71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox71ActionPerformed(evt);
            }
        });

        jSpinner74.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel497, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel498, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel499, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel500, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel80Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox71, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel503, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel80Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel501)
                        .addContainerGap())))
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel502, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel502, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel497)
                    .addComponent(jLabel501))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel498)
                    .addComponent(jLabel503))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel499)
                    .addComponent(jSpinner74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel500)
                    .addComponent(jCheckBox71))
                .addGap(16, 16, 16))
        );

        t3.add(jPanel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 230, 300));

        jPanel79.setBackground(new java.awt.Color(255, 153, 153));
        jPanel79.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));

        jLabel490.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel490.setText("Name");

        jLabel491.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel491.setText("Price");

        jLabel492.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel492.setText("Quality");

        jLabel493.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel493.setText("Purchase");

        jLabel494.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel494.setText("Banana caramel Cake");

        jLabel495.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\cakes\\top-50-cakes-image-43-66379-1.jpg")); // NOI18N

        jLabel496.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel496.setText("320");

        jCheckBox67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox67ActionPerformed(evt);
            }
        });

        jSpinner73.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel79Layout.createSequentialGroup()
                        .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel493, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel490, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel491, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel492, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox67, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel496, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel494)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel79Layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jLabel495, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel495, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel490)
                    .addComponent(jLabel494))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel491)
                    .addComponent(jLabel496))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel492)
                    .addComponent(jSpinner73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel493)
                    .addComponent(jCheckBox67))
                .addGap(16, 16, 16))
        );

        t3.add(jPanel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 16, 240, 300));

        jLabel177.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1.jpg"))); // NOI18N
        t3.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 1840));

        jPanel6.add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1061, 1678));

        jLabel178.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1.jpg"))); // NOI18N
        jPanel6.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 1840));

        Home2.setViewportView(jPanel6);

        jMenu3.setText("Home");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu2.setText("MyCart");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu1.setText("MyOrder");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Home1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Home2, javax.swing.GroupLayout.PREFERRED_SIZE, 1276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Home4, javax.swing.GroupLayout.DEFAULT_SIZE, 1640, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(285, 285, 285)
                    .addComponent(Home3, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1976, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Home4, javax.swing.GroupLayout.PREFERRED_SIZE, 1963, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Home2, javax.swing.GroupLayout.PREFERRED_SIZE, 2180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Home1, javax.swing.GroupLayout.PREFERRED_SIZE, 1413, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Home3, javax.swing.GroupLayout.PREFERRED_SIZE, 1730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 469, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
          int qty=Integer.parseInt(jSpinner14.getValue().toString());
        if(!qtyiszero(qty) && jCheckBox3.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel58.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel58.getText()+"\t\t\t"+price+"\n");
                
        }else{
             jCheckBox3.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner23.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox9.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel74.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel74.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox9.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox19ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner55.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox20.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel138.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel138.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox20.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox19ActionPerformed

    private void jCheckBox89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox89ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner90.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox89.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel613.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel613.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox89.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox89ActionPerformed

    private void jCheckBox81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox81ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner82.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox81.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel557.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel557.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox81.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox81ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        Object i=jComboBox1.getSelectedItem();
        DefaultComboBoxModel model2=(DefaultComboBoxModel)jComboBox1.getModel();

        if(i==(model2.getElementAt(0)))
        {

            a5.setVisible(true);
            b5.setVisible(false);
            p5.setVisible(false);
            q3.setVisible(false);
            r3.setVisible(false);
            s3.setVisible(false);
            t3.setVisible(false);

           

        }
        else if(i==(model2.getElementAt(1))){
            a5.setVisible(false);
            b5.setVisible(true);
            p5.setVisible(false);
            q3.setVisible(false);
            r3.setVisible(false);
            s3.setVisible(false);
            t3.setVisible(false);

        }
        else if(i==(model2.getElementAt(2))){
            a5.setVisible(false);
            b5.setVisible(false);
            p5.setVisible(true);
            q3.setVisible(false);
            r3.setVisible(false);
            s3.setVisible(false);
            t3.setVisible(false);

        }
        else if(i==(model2.getElementAt(3))){
            a5.setVisible(false);
            b5.setVisible(false);
            p5.setVisible(false);
            q3.setVisible(true);
            r3.setVisible(false);
            s3.setVisible(false);
            t3.setVisible(false);
        }
        else if(i==(model2.getElementAt(4))){
            a5.setVisible(false);
            b5.setVisible(false);
            p5.setVisible(false);
            q3.setVisible(false);
            r3.setVisible(true);
            s3.setVisible(false);
            t3.setVisible(false);

        }
        else if(i==(model2.getElementAt(5))){
            a5.setVisible(false);
            b5.setVisible(false);
            p5.setVisible(false);
            q3.setVisible(false);
            r3.setVisible(false);
            s3.setVisible(true);
            t3.setVisible(false);

        }
        else if(i==(model2.getElementAt(6))){
            a5.setVisible(false);
            b5.setVisible(false);
            p5.setVisible(false);
            q3.setVisible(false);
            r3.setVisible(false);
            s3.setVisible(false);
            t3.setVisible(true);

        }
    }//GEN-LAST:event_jComboBox1ActionPerformed
    //jPanel1.setVisible(false);
    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        Home1.setVisible(true);
        Home2.setVisible(true);
        Home3.setVisible(false);
        Home4.setVisible(false);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        Home1.setVisible(false);

        Home2.setVisible(false);
        Home3.setVisible(true);
        Home4.setVisible(false);
    }//GEN-LAST:event_jMenu2MouseClicked
    public void cakeshop(){
        jTextArea1.setText("*****************************************COOCKIES ENCOUNTER*******************************\n"
        +"TIME: "+jLabel7.getText()+" DATE: "+jLabel13.getText()+"\n"+"*****************************************************************************************************"
                +"\n"+"Item Name:\t\t\t\t"+"Price(tk)\n");
    }
     public boolean qtyiszero(int qty){
        if(qty==0){
            JOptionPane.showMessageDialog(null, "Please increase the item quantity");
            return true; 
        }
        return false;
    }
    private void jCheckBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox17ActionPerformed
        // TODO add your handling code here:
        //qtyiszero();
        int qty=Integer.parseInt(jSpinner1.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox17.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel118.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel118.getText()+"\t\t\t"+price+"\n");
                
        }else{
            jCheckBox17.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox17ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        int qty=Integer.parseInt(jSpinner2.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox4.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*23.0;
                total+=price;
                gettax(total);
                jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel31.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel31.getText()+"\t\t\t"+price+"\n");
              
        }else{
            jCheckBox4.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox38ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner3.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox38.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*50.0;
                total+=price;
                gettax(total);
                 jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel265.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel265.getText()+"\t\t\t"+price+"\n");
             
        }else{
            jCheckBox38.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox38ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner4.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox6.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*36.0;
                total+=price;
                gettax(total);
                    jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel41.getText()+"("+qty+")"+"\n");
               dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel41.getText()+"\t\t\t"+price+"\n");
           
        }else{
            jCheckBox6.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox21ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner5.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox21.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*45.0;
                total+=price;
                gettax(total);
              jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel146.getText()+"("+qty+")"+"\n");
                 dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel146.getText()+"\t\t\t"+price+"\n");
               
        }else{
            jCheckBox21.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox21ActionPerformed

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner16.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox15.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*38.0;
                total+=price;
                gettax(total);
                jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel104.getText()+"("+qty+")"+"\n");
               dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel104.getText()+"\t\t\t"+price+"\n");
               
               
        }else{
            jCheckBox15.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox15ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner26.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox1.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*39.0;
                total+=price;
                gettax(total);
                jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel5.getText()+"("+qty+")"+"\n");
               dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel5.getText()+"\t\t\t"+price+"\n");
               
        }else{
            jCheckBox1.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // TODO add your handling code here:
        
          int qty=Integer.parseInt(jSpinner18.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox8.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*22.0;
                total+=price;
                gettax(total);
                 jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel55.getText()+"("+qty+")"+"\n");
               dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel55.getText()+"\t\t\t"+price+"\n");
              
        }else{
            jCheckBox8.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
           int qty=Integer.parseInt(jSpinner9.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox7.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*40.0;
                total+=price;
                gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel48.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel48.getText()+"\t\t\t"+price+"\n");
               
        }else{
            jCheckBox7.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox24ActionPerformed
        // TODO add your handling code here:
            int qty=Integer.parseInt(jSpinner24.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox24.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*30.0;
                total+=price;
                gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel67.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel67.getText()+"\t\t\t"+price+"\n");
                
        }else{
            jCheckBox24.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox24ActionPerformed

    public void dudate(){
        jTextField1.setText(String.valueOf(tax));
        jTextField2.setText(String.valueOf(total));
        jTextField3.setText(String.valueOf(total+tax));
        b.setText(String.valueOf( jLabel7.getText()));
        jTextField4.setText(String.valueOf(jLabel13.getText()));
        a.setText(jLabel20.getText());
       
    }
    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
       
        if(total==0.0){
            JOptionPane.showMessageDialog(null, "You haven't selected any item");
            
        }else{
            jTextArea1.setText(jTextArea1.getText()
                    +"\n\n\n"
                    +"********************************************************************\n"
            +"Tax:  \t\t\t"+tax+"\n"
            +"Sub Total: \t\t\t"+total+"\n"
                    +"Total: \t\t\t"+(total+tax)+"\n\n");
            
        }
    }//GEN-LAST:event_TotalActionPerformed

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aActionPerformed

    private void OrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderActionPerformed
        // TODO add your handling code here:
        
         String Total = jTextField3.getText();
         String Name = a.getText();
         String Items = jTextArea2.getText();
         String Time = b.getText();
         String Date = jTextField4.getText();
         String Phn_no = a3.getText();
         String Phn_no2 = a1.getText();
         String Address = a2.getText();
         
         java.sql.PreparedStatement ps;
         String query="INSERT INTO `order_table`(`username`, `items`, `total`, `time`, `date`, `phn_no`, `phn_no2`, `Address`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            
             ps = Myconnection.mycon().prepareStatement(query);            
             ps=Myconnection.mycon().prepareStatement(query);
             ps.setString(1,Name);
             ps.setString(2,Items);
             ps.setString(3,Total);
             ps.setString(4,Time);
             ps.setString(5,Date);
             ps.setString(6,Phn_no);
             ps.setString(7,Phn_no2);
             ps.setString(8, Address);
             ps.executeUpdate();
             JOptionPane.showMessageDialog(null,"Thanks for Ordering Cakes......."
                     + "Please wait for conformation........");
             MyOrder_show();
//        } catch (SQLException ex) {
//            Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
//        }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }//GEN-LAST:event_OrderActionPerformed

    private void bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bActionPerformed

    private void a1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a1ActionPerformed

    private void a2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a2ActionPerformed

    private void a3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a3ActionPerformed

    private void jLabel79MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseClicked
        // TODO add your handling code here:
         SIGNINCUSTOM p=new SIGNINCUSTOM();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel79MouseClicked

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        Home1.setVisible(false);
        Home2.setVisible(false);
        Home3.setVisible(false);
        Home4.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void OrderTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTMouseClicked
        // TODO add your handling code here:
//        int i = OrderT.getSelectedRow();
//        TableModel model11 = OrderT.getModel();
//        jTextArea2.setText(model11.getValueAt(i, 1).toString());

    }//GEN-LAST:event_OrderTMouseClicked

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner15.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox10.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel69.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel69.getText()+"\t\t\t"+price+"\n");
                
        }else{
            jCheckBox10.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jCheckBox37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox37ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner38.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox37.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel258.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel258.getText()+"\t\t\t"+price+"\n");
                
        }else{
            jCheckBox37.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox37ActionPerformed

    private void jCheckBox36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox36ActionPerformed
     int qty=Integer.parseInt(jSpinner29.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox36.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel251.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel251.getText()+"\t\t\t"+price+"\n");
                
        }else{
            jCheckBox36.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox36ActionPerformed

    private void jCheckBox39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox39ActionPerformed
       int qty=Integer.parseInt(jSpinner39.getValue().toString());
        if(!qtyiszero(qty) &&jCheckBox39.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel272.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel272.getText()+"\t\t\t"+price+"\n");
                
        }else{
            jCheckBox39.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox39ActionPerformed

    private void jCheckBox40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox40ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner40.getValue().toString());
        if(!qtyiszero(qty) && jCheckBox40.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel279.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel279.getText()+"\t\t\t"+price+"\n");
                
        }else{
             jCheckBox40.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox40ActionPerformed

    private void jCheckBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox16ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner20.getValue().toString());
        if(!qtyiszero(qty) && jCheckBox16.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel111.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel111.getText()+"\t\t\t"+price+"\n");
                
        }else{
             jCheckBox16.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox16ActionPerformed

    private void jCheckBox41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox41ActionPerformed
        // TODO add your handling code here:
           int qty=Integer.parseInt(jSpinner6.getValue().toString());
        if(!qtyiszero(qty) && jCheckBox41.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel286.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel286.getText()+"\t\t\t"+price+"\n");
                
        }else{
             jCheckBox41.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox41ActionPerformed

    private void jCheckBox45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox45ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner10.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox45.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel314.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel314.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox45.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox45ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner27.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox5.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel15.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel15.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox5.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner25.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox14.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel123.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel123.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox14.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void jCheckBox50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox50ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner48.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox50.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel349.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel349.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox50.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox50ActionPerformed

    private void jCheckBox51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox51ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner22.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox51.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel356.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel356.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox51.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox51ActionPerformed

    private void jCheckBox42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox42ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner41.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox42.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel293.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel293.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox42.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox42ActionPerformed

    private void jCheckBox43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox43ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner42.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox43.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel300.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel300.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox43.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox43ActionPerformed

    private void jCheckBox44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox44ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner43.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox44.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel307.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel307.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox44.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox44ActionPerformed

    private void jCheckBox46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox46ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner44.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox46.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel321.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel321.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox46.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox46ActionPerformed

    private void jCheckBox18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox18ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner49.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox18.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel131.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel131.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox18.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox18ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner28.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox11.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel95.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel95.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox11.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void jCheckBox22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox22ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner57.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox22.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel59.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel59.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox22.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox22ActionPerformed

    private void jCheckBox20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox20ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner56.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox20.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel152.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel152.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox20.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox20ActionPerformed

    private void jCheckBox56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox56ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner54.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox56.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel391.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel391.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox56.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox56ActionPerformed

    private void jCheckBox55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox55ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner53.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox55.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel384.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel384.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox55.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox55ActionPerformed

    private void jCheckBox54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox54ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner52.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox54.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel377.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel377.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox54.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox54ActionPerformed

    private void jCheckBox52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox52ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner50.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox52.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel363.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel363.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox52.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox52ActionPerformed

    private void jCheckBox53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox53ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner51.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox53.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel370.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel370.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox53.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox53ActionPerformed

    private void jCheckBox47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox47ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner45.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox47.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel328.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel328.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox47.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox47ActionPerformed

    private void jCheckBox23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox23ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner58.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox23.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel173.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel173.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox23.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox23ActionPerformed

    private void jCheckBox48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox48ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner46.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox48.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel315.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel315.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox48.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox48ActionPerformed

    private void jCheckBox73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox73ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner72.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox73.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel487.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel487.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox73.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox73ActionPerformed

    private void jCheckBox72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox72ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner71.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox72.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel480.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel480.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox72.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox72ActionPerformed

    private void jCheckBox69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox69ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner69.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox69.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel446.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel446.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox69.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox69ActionPerformed

    private void jCheckBox70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox70ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner70.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox70.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel473.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel473.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox70.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox70ActionPerformed

    private void jCheckBox66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox66ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner67.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox66.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel452.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel452.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox66.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox66ActionPerformed

    private void jCheckBox68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox68ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner68.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox68.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel459.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel459.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox68.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox68ActionPerformed

    private void jCheckBox65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox65ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner66.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox65.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel445.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel445.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox65.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox65ActionPerformed

    private void jCheckBox86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox86ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner87.getValue().toString());
        if(!qtyiszero(qty) &&  jCheckBox86.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel592.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel592.getText()+"\t\t\t"+price+"\n");
                
        }else{
              jCheckBox86.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox86ActionPerformed

    private void jCheckBox75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox75ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner76.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox75.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel515.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel515.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox75.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox75ActionPerformed

    private void jCheckBox84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox84ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner85.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox84.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel578.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel578.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox84.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox84ActionPerformed

    private void jCheckBox83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox83ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner84.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox83.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel571.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel571.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox83.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox83ActionPerformed

    private void jCheckBox85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox85ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner86.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox85.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel585.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel585.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox85.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox85ActionPerformed

    private void jCheckBox91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox91ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner92.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox91.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel627.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel627.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox91.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox91ActionPerformed

    private void jCheckBox90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox90ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner91.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox90.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel620.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel620.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox90.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox90ActionPerformed

    private void jCheckBox88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox88ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner89.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox88.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel606.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel606.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox88.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox88ActionPerformed

    private void jCheckBox87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox87ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner88.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox87.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel599.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel599.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox87.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox87ActionPerformed

    private void jCheckBox78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox78ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner79.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox78.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel536.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel536.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox78.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox78ActionPerformed

    private void jCheckBox79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox79ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner80.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox79.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel543.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel543.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox79.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox79ActionPerformed

    private void jCheckBox82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox82ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner83.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox82.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel564.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel564.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox82.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox82ActionPerformed

    private void jCheckBox80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox80ActionPerformed
        // TODO add your handling code here:
         int qty=Integer.parseInt(jSpinner81.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox80.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel550.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel550.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox80.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox80ActionPerformed

    private void jCheckBox77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox77ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner78.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox77.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel529.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel529.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox77.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox77ActionPerformed

    private void jCheckBox76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox76ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner77.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox76.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel522.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel522.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox76.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox76ActionPerformed

    private void jCheckBox74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox74ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner75.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox74.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel508.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel508.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox74.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox74ActionPerformed

    private void jCheckBox71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox71ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner74.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox71.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel501.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel501.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox74.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox71ActionPerformed

    private void jCheckBox67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox67ActionPerformed
        // TODO add your handling code here:
          int qty=Integer.parseInt(jSpinner73.getValue().toString());
        if(!qtyiszero(qty) &&   jCheckBox67.isSelected()){
               x++;
               if(x==1){
                   cakeshop();
               }
               double price=qty*32.0;
               total+=price;
               gettax(total);
               jTextArea2.setText(jTextArea2.getText()+x+". "+jLabel494.getText()+"("+qty+")"+"\n");
                dudate();
               jTextArea1.setText(jTextArea1.getText()+x+". "+jLabel494.getText()+"\t\t\t"+price+"\n");
                
        }else{
               jCheckBox80.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox67ActionPerformed

    public void gettax(double t)
    {
        if(t<10.0 && t<=20.0){
            tax=0.5;
        }else if(t>20.0 && t<=40.0){
            tax=1.0;
        }else if(t>20.0 && t<=40.0){
            tax=1.0;
        }else if(t>30.0 && t<=60.0){
            tax=2.0;
        }else if(t>40.0 && t<=80.0){
            tax=3.0;
        }else if(t>60.0 && t<=100.0){
            tax=4.0;
        }else if(t>100.0 && t<=1150.0){
            tax=8.0;
        }else if(t>150.0 && t<=200.0){
            tax=10.0;
        }else if(t>200.0){
            tax=15.0;
        }
        }
    
    public void setTime(){
        new Thread(new Runnable() {
            @Override
            public void run() {
              while(true){
                  try{
                      Thread.sleep(1000);
                      
                  }catch(InterruptedException e){
                      Logger.getLogger(UDB.class.getName()).log(Level.SEVERE,null,e);
                      
                  }
                  Date date =new Date();
                  SimpleDateFormat tf=new SimpleDateFormat("h:mm:ss aa");
                  SimpleDateFormat df =new SimpleDateFormat("EEEE, dd-MM-yyyy");
                  String time=tf.format(date);
                  jLabel7.setText(time.split(" ")[0]+" "+time.split(" ")[1]);
                  jLabel13.setText(df.format(date));
              }
            }
        }).start();
    }
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UDB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Home1;
    private javax.swing.JScrollPane Home2;
    private javax.swing.JScrollPane Home3;
    private javax.swing.JScrollPane Home4;
    private javax.swing.JButton Order;
    private javax.swing.JTable OrderT;
    private javax.swing.JTable OrderU;
    private javax.swing.JButton Total;
    private javax.swing.JTextField a;
    public javax.swing.JTextField a1;
    public javax.swing.JTextField a2;
    public javax.swing.JTextField a3;
    private javax.swing.JPanel a5;
    private javax.swing.JTextField b;
    private javax.swing.JPanel b5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox36;
    private javax.swing.JCheckBox jCheckBox37;
    private javax.swing.JCheckBox jCheckBox38;
    private javax.swing.JCheckBox jCheckBox39;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox40;
    private javax.swing.JCheckBox jCheckBox41;
    private javax.swing.JCheckBox jCheckBox42;
    private javax.swing.JCheckBox jCheckBox43;
    private javax.swing.JCheckBox jCheckBox44;
    private javax.swing.JCheckBox jCheckBox45;
    private javax.swing.JCheckBox jCheckBox46;
    private javax.swing.JCheckBox jCheckBox47;
    private javax.swing.JCheckBox jCheckBox48;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox50;
    private javax.swing.JCheckBox jCheckBox51;
    private javax.swing.JCheckBox jCheckBox52;
    private javax.swing.JCheckBox jCheckBox53;
    private javax.swing.JCheckBox jCheckBox54;
    private javax.swing.JCheckBox jCheckBox55;
    private javax.swing.JCheckBox jCheckBox56;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox65;
    private javax.swing.JCheckBox jCheckBox66;
    private javax.swing.JCheckBox jCheckBox67;
    private javax.swing.JCheckBox jCheckBox68;
    private javax.swing.JCheckBox jCheckBox69;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox70;
    private javax.swing.JCheckBox jCheckBox71;
    private javax.swing.JCheckBox jCheckBox72;
    private javax.swing.JCheckBox jCheckBox73;
    private javax.swing.JCheckBox jCheckBox74;
    private javax.swing.JCheckBox jCheckBox75;
    private javax.swing.JCheckBox jCheckBox76;
    private javax.swing.JCheckBox jCheckBox77;
    private javax.swing.JCheckBox jCheckBox78;
    private javax.swing.JCheckBox jCheckBox79;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox80;
    private javax.swing.JCheckBox jCheckBox81;
    private javax.swing.JCheckBox jCheckBox82;
    private javax.swing.JCheckBox jCheckBox83;
    private javax.swing.JCheckBox jCheckBox84;
    private javax.swing.JCheckBox jCheckBox85;
    private javax.swing.JCheckBox jCheckBox86;
    private javax.swing.JCheckBox jCheckBox87;
    private javax.swing.JCheckBox jCheckBox88;
    private javax.swing.JCheckBox jCheckBox89;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JCheckBox jCheckBox90;
    private javax.swing.JCheckBox jCheckBox91;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    public javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel252;
    private javax.swing.JLabel jLabel253;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JLabel jLabel255;
    private javax.swing.JLabel jLabel256;
    private javax.swing.JLabel jLabel257;
    private javax.swing.JLabel jLabel258;
    private javax.swing.JLabel jLabel259;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel260;
    private javax.swing.JLabel jLabel261;
    private javax.swing.JLabel jLabel262;
    private javax.swing.JLabel jLabel263;
    private javax.swing.JLabel jLabel264;
    private javax.swing.JLabel jLabel265;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel267;
    private javax.swing.JLabel jLabel268;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel274;
    private javax.swing.JLabel jLabel275;
    private javax.swing.JLabel jLabel276;
    private javax.swing.JLabel jLabel277;
    private javax.swing.JLabel jLabel278;
    private javax.swing.JLabel jLabel279;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel280;
    private javax.swing.JLabel jLabel281;
    private javax.swing.JLabel jLabel282;
    private javax.swing.JLabel jLabel283;
    private javax.swing.JLabel jLabel284;
    private javax.swing.JLabel jLabel285;
    private javax.swing.JLabel jLabel286;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel288;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel290;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel292;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel295;
    private javax.swing.JLabel jLabel296;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel298;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel300;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel302;
    private javax.swing.JLabel jLabel303;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JLabel jLabel306;
    private javax.swing.JLabel jLabel307;
    private javax.swing.JLabel jLabel308;
    private javax.swing.JLabel jLabel309;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel310;
    private javax.swing.JLabel jLabel311;
    private javax.swing.JLabel jLabel312;
    private javax.swing.JLabel jLabel313;
    private javax.swing.JLabel jLabel314;
    private javax.swing.JLabel jLabel315;
    private javax.swing.JLabel jLabel316;
    private javax.swing.JLabel jLabel317;
    private javax.swing.JLabel jLabel318;
    private javax.swing.JLabel jLabel319;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel320;
    private javax.swing.JLabel jLabel321;
    private javax.swing.JLabel jLabel322;
    private javax.swing.JLabel jLabel323;
    private javax.swing.JLabel jLabel324;
    private javax.swing.JLabel jLabel325;
    private javax.swing.JLabel jLabel326;
    private javax.swing.JLabel jLabel327;
    private javax.swing.JLabel jLabel328;
    private javax.swing.JLabel jLabel329;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel330;
    private javax.swing.JLabel jLabel331;
    private javax.swing.JLabel jLabel332;
    private javax.swing.JLabel jLabel333;
    private javax.swing.JLabel jLabel334;
    private javax.swing.JLabel jLabel335;
    private javax.swing.JLabel jLabel336;
    private javax.swing.JLabel jLabel337;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel345;
    private javax.swing.JLabel jLabel346;
    private javax.swing.JLabel jLabel347;
    private javax.swing.JLabel jLabel348;
    private javax.swing.JLabel jLabel349;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel350;
    private javax.swing.JLabel jLabel351;
    private javax.swing.JLabel jLabel352;
    private javax.swing.JLabel jLabel353;
    private javax.swing.JLabel jLabel354;
    private javax.swing.JLabel jLabel355;
    private javax.swing.JLabel jLabel356;
    private javax.swing.JLabel jLabel357;
    private javax.swing.JLabel jLabel358;
    private javax.swing.JLabel jLabel359;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel360;
    private javax.swing.JLabel jLabel361;
    private javax.swing.JLabel jLabel362;
    private javax.swing.JLabel jLabel363;
    private javax.swing.JLabel jLabel364;
    private javax.swing.JLabel jLabel365;
    private javax.swing.JLabel jLabel366;
    private javax.swing.JLabel jLabel367;
    private javax.swing.JLabel jLabel368;
    private javax.swing.JLabel jLabel369;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel370;
    private javax.swing.JLabel jLabel371;
    private javax.swing.JLabel jLabel372;
    private javax.swing.JLabel jLabel373;
    private javax.swing.JLabel jLabel374;
    private javax.swing.JLabel jLabel375;
    private javax.swing.JLabel jLabel376;
    private javax.swing.JLabel jLabel377;
    private javax.swing.JLabel jLabel378;
    private javax.swing.JLabel jLabel379;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel380;
    private javax.swing.JLabel jLabel381;
    private javax.swing.JLabel jLabel382;
    private javax.swing.JLabel jLabel383;
    private javax.swing.JLabel jLabel384;
    private javax.swing.JLabel jLabel385;
    private javax.swing.JLabel jLabel386;
    private javax.swing.JLabel jLabel387;
    private javax.swing.JLabel jLabel388;
    private javax.swing.JLabel jLabel389;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel390;
    private javax.swing.JLabel jLabel391;
    private javax.swing.JLabel jLabel392;
    private javax.swing.JLabel jLabel393;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel441;
    private javax.swing.JLabel jLabel442;
    private javax.swing.JLabel jLabel443;
    private javax.swing.JLabel jLabel444;
    private javax.swing.JLabel jLabel445;
    private javax.swing.JLabel jLabel446;
    private javax.swing.JLabel jLabel447;
    private javax.swing.JLabel jLabel448;
    private javax.swing.JLabel jLabel449;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel450;
    private javax.swing.JLabel jLabel451;
    private javax.swing.JLabel jLabel452;
    private javax.swing.JLabel jLabel453;
    private javax.swing.JLabel jLabel454;
    private javax.swing.JLabel jLabel455;
    private javax.swing.JLabel jLabel456;
    private javax.swing.JLabel jLabel457;
    private javax.swing.JLabel jLabel458;
    private javax.swing.JLabel jLabel459;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel460;
    private javax.swing.JLabel jLabel461;
    private javax.swing.JLabel jLabel462;
    private javax.swing.JLabel jLabel463;
    private javax.swing.JLabel jLabel464;
    private javax.swing.JLabel jLabel465;
    private javax.swing.JLabel jLabel466;
    private javax.swing.JLabel jLabel467;
    private javax.swing.JLabel jLabel468;
    private javax.swing.JLabel jLabel469;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel470;
    private javax.swing.JLabel jLabel471;
    private javax.swing.JLabel jLabel472;
    private javax.swing.JLabel jLabel473;
    private javax.swing.JLabel jLabel474;
    private javax.swing.JLabel jLabel475;
    private javax.swing.JLabel jLabel476;
    private javax.swing.JLabel jLabel477;
    private javax.swing.JLabel jLabel478;
    private javax.swing.JLabel jLabel479;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel480;
    private javax.swing.JLabel jLabel481;
    private javax.swing.JLabel jLabel482;
    private javax.swing.JLabel jLabel483;
    private javax.swing.JLabel jLabel484;
    private javax.swing.JLabel jLabel485;
    private javax.swing.JLabel jLabel486;
    private javax.swing.JLabel jLabel487;
    private javax.swing.JLabel jLabel488;
    private javax.swing.JLabel jLabel489;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel490;
    private javax.swing.JLabel jLabel491;
    private javax.swing.JLabel jLabel492;
    private javax.swing.JLabel jLabel493;
    private javax.swing.JLabel jLabel494;
    private javax.swing.JLabel jLabel495;
    private javax.swing.JLabel jLabel496;
    private javax.swing.JLabel jLabel497;
    private javax.swing.JLabel jLabel498;
    private javax.swing.JLabel jLabel499;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel500;
    private javax.swing.JLabel jLabel501;
    private javax.swing.JLabel jLabel502;
    private javax.swing.JLabel jLabel503;
    private javax.swing.JLabel jLabel504;
    private javax.swing.JLabel jLabel505;
    private javax.swing.JLabel jLabel506;
    private javax.swing.JLabel jLabel507;
    private javax.swing.JLabel jLabel508;
    private javax.swing.JLabel jLabel509;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel510;
    private javax.swing.JLabel jLabel511;
    private javax.swing.JLabel jLabel512;
    private javax.swing.JLabel jLabel513;
    private javax.swing.JLabel jLabel514;
    private javax.swing.JLabel jLabel515;
    private javax.swing.JLabel jLabel516;
    private javax.swing.JLabel jLabel517;
    private javax.swing.JLabel jLabel518;
    private javax.swing.JLabel jLabel519;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel520;
    private javax.swing.JLabel jLabel521;
    private javax.swing.JLabel jLabel522;
    private javax.swing.JLabel jLabel523;
    private javax.swing.JLabel jLabel524;
    private javax.swing.JLabel jLabel525;
    private javax.swing.JLabel jLabel526;
    private javax.swing.JLabel jLabel527;
    private javax.swing.JLabel jLabel528;
    private javax.swing.JLabel jLabel529;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel530;
    private javax.swing.JLabel jLabel531;
    private javax.swing.JLabel jLabel532;
    private javax.swing.JLabel jLabel533;
    private javax.swing.JLabel jLabel534;
    private javax.swing.JLabel jLabel535;
    private javax.swing.JLabel jLabel536;
    private javax.swing.JLabel jLabel537;
    private javax.swing.JLabel jLabel538;
    private javax.swing.JLabel jLabel539;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel540;
    private javax.swing.JLabel jLabel541;
    private javax.swing.JLabel jLabel542;
    private javax.swing.JLabel jLabel543;
    private javax.swing.JLabel jLabel544;
    private javax.swing.JLabel jLabel545;
    private javax.swing.JLabel jLabel546;
    private javax.swing.JLabel jLabel547;
    private javax.swing.JLabel jLabel548;
    private javax.swing.JLabel jLabel549;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel550;
    private javax.swing.JLabel jLabel551;
    private javax.swing.JLabel jLabel552;
    private javax.swing.JLabel jLabel553;
    private javax.swing.JLabel jLabel554;
    private javax.swing.JLabel jLabel555;
    private javax.swing.JLabel jLabel556;
    private javax.swing.JLabel jLabel557;
    private javax.swing.JLabel jLabel558;
    private javax.swing.JLabel jLabel559;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel560;
    private javax.swing.JLabel jLabel561;
    private javax.swing.JLabel jLabel562;
    private javax.swing.JLabel jLabel563;
    private javax.swing.JLabel jLabel564;
    private javax.swing.JLabel jLabel565;
    private javax.swing.JLabel jLabel566;
    private javax.swing.JLabel jLabel567;
    private javax.swing.JLabel jLabel568;
    private javax.swing.JLabel jLabel569;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel570;
    private javax.swing.JLabel jLabel571;
    private javax.swing.JLabel jLabel572;
    private javax.swing.JLabel jLabel573;
    private javax.swing.JLabel jLabel574;
    private javax.swing.JLabel jLabel575;
    private javax.swing.JLabel jLabel576;
    private javax.swing.JLabel jLabel577;
    private javax.swing.JLabel jLabel578;
    private javax.swing.JLabel jLabel579;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel580;
    private javax.swing.JLabel jLabel581;
    private javax.swing.JLabel jLabel582;
    private javax.swing.JLabel jLabel583;
    private javax.swing.JLabel jLabel584;
    private javax.swing.JLabel jLabel585;
    private javax.swing.JLabel jLabel586;
    private javax.swing.JLabel jLabel587;
    private javax.swing.JLabel jLabel588;
    private javax.swing.JLabel jLabel589;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel590;
    private javax.swing.JLabel jLabel591;
    private javax.swing.JLabel jLabel592;
    private javax.swing.JLabel jLabel593;
    private javax.swing.JLabel jLabel594;
    private javax.swing.JLabel jLabel595;
    private javax.swing.JLabel jLabel596;
    private javax.swing.JLabel jLabel597;
    private javax.swing.JLabel jLabel598;
    private javax.swing.JLabel jLabel599;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel600;
    private javax.swing.JLabel jLabel601;
    private javax.swing.JLabel jLabel602;
    private javax.swing.JLabel jLabel603;
    private javax.swing.JLabel jLabel604;
    private javax.swing.JLabel jLabel605;
    private javax.swing.JLabel jLabel606;
    private javax.swing.JLabel jLabel607;
    private javax.swing.JLabel jLabel608;
    private javax.swing.JLabel jLabel609;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel610;
    private javax.swing.JLabel jLabel611;
    private javax.swing.JLabel jLabel612;
    private javax.swing.JLabel jLabel613;
    private javax.swing.JLabel jLabel614;
    private javax.swing.JLabel jLabel615;
    private javax.swing.JLabel jLabel616;
    private javax.swing.JLabel jLabel617;
    private javax.swing.JLabel jLabel618;
    private javax.swing.JLabel jLabel619;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel620;
    private javax.swing.JLabel jLabel621;
    private javax.swing.JLabel jLabel622;
    private javax.swing.JLabel jLabel623;
    private javax.swing.JLabel jLabel624;
    private javax.swing.JLabel jLabel625;
    private javax.swing.JLabel jLabel626;
    private javax.swing.JLabel jLabel627;
    private javax.swing.JLabel jLabel628;
    private javax.swing.JLabel jLabel629;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner14;
    private javax.swing.JSpinner jSpinner15;
    private javax.swing.JSpinner jSpinner16;
    private javax.swing.JSpinner jSpinner18;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner20;
    private javax.swing.JSpinner jSpinner22;
    private javax.swing.JSpinner jSpinner23;
    private javax.swing.JSpinner jSpinner24;
    private javax.swing.JSpinner jSpinner25;
    private javax.swing.JSpinner jSpinner26;
    private javax.swing.JSpinner jSpinner27;
    private javax.swing.JSpinner jSpinner28;
    private javax.swing.JSpinner jSpinner29;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner38;
    private javax.swing.JSpinner jSpinner39;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner40;
    private javax.swing.JSpinner jSpinner41;
    private javax.swing.JSpinner jSpinner42;
    private javax.swing.JSpinner jSpinner43;
    private javax.swing.JSpinner jSpinner44;
    private javax.swing.JSpinner jSpinner45;
    private javax.swing.JSpinner jSpinner46;
    private javax.swing.JSpinner jSpinner48;
    private javax.swing.JSpinner jSpinner49;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner50;
    private javax.swing.JSpinner jSpinner51;
    private javax.swing.JSpinner jSpinner52;
    private javax.swing.JSpinner jSpinner53;
    private javax.swing.JSpinner jSpinner54;
    private javax.swing.JSpinner jSpinner55;
    private javax.swing.JSpinner jSpinner56;
    private javax.swing.JSpinner jSpinner57;
    private javax.swing.JSpinner jSpinner58;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner66;
    private javax.swing.JSpinner jSpinner67;
    private javax.swing.JSpinner jSpinner68;
    private javax.swing.JSpinner jSpinner69;
    private javax.swing.JSpinner jSpinner70;
    private javax.swing.JSpinner jSpinner71;
    private javax.swing.JSpinner jSpinner72;
    private javax.swing.JSpinner jSpinner73;
    private javax.swing.JSpinner jSpinner74;
    private javax.swing.JSpinner jSpinner75;
    private javax.swing.JSpinner jSpinner76;
    private javax.swing.JSpinner jSpinner77;
    private javax.swing.JSpinner jSpinner78;
    private javax.swing.JSpinner jSpinner79;
    private javax.swing.JSpinner jSpinner80;
    private javax.swing.JSpinner jSpinner81;
    private javax.swing.JSpinner jSpinner82;
    private javax.swing.JSpinner jSpinner83;
    private javax.swing.JSpinner jSpinner84;
    private javax.swing.JSpinner jSpinner85;
    private javax.swing.JSpinner jSpinner86;
    private javax.swing.JSpinner jSpinner87;
    private javax.swing.JSpinner jSpinner88;
    private javax.swing.JSpinner jSpinner89;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JSpinner jSpinner90;
    private javax.swing.JSpinner jSpinner91;
    private javax.swing.JSpinner jSpinner92;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPanel p5;
    private javax.swing.JPanel q3;
    private javax.swing.JPanel r3;
    private javax.swing.JPanel s3;
    private javax.swing.JPanel t3;
    // End of variables declaration//GEN-END:variables
}
