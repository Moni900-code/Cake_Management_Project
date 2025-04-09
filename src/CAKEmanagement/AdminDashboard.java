/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CAKEmanagement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ASUS
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
     com.mysql.jdbc.Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    public AdminDashboard() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

        show_user();
        show_cake();
        Category_show();
        Order_show();
        updateCombo();
        setTime();
        confirmOrder_show();

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
                  time12.setText(time.split(" ")[0]+" "+time.split(" ")[1]);
                  date12.setText(df.format(date));
              }
            }
        }).start();
    }
     
     private void updateCombo(){
        
       
        try{  
           Class.forName("com.mysql.jdbc.Driver");
          conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/registration","root","");
          String sql="SELECT distinct* FROM `cakepack`";
          pst = (PreparedStatement) conn.prepareStatement(sql);
          rs = pst.executeQuery();
          while(rs.next()){
              e.addItem(rs.getString("Category_name"));
              
          }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
   }
     
     
     
  ///Search jTable:::::
     
     public void searchO(String str){
            DefaultTableModel model1=(DefaultTableModel)searchT.getModel();
            TableRowSorter<DefaultTableModel>trs=new  TableRowSorter<>(model1);
            searchT.setRowSorter(trs);
            trs.setRowFilter(RowFilter.regexFilter(str));
    }
     
    ///user show table;//////////// 
    public ArrayList<user> userlist() {
        ArrayList<user> userlist = new ArrayList<>();
        java.sql.Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/registration", "root", "");
            String query1 = "SELECT * FROM `user`";

            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            user User;
            while (rs.next()) {
                User = new user(rs.getInt("Phn_no"), rs.getInt("Phn_no2"), rs.getString("Username"), rs.getString("Email"), rs.getString("Address"), rs.getString("Gender"));
                userlist.add(User);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return userlist;
    }

    public void show_user() {
        ArrayList<user> list = userlist();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getUsername();
            row[1] = list.get(i).getEmail();
            row[2] = list.get(i).getAddress();
            row[3] = list.get(i).getphn_no();
            row[4] = list.get(i).getphn_no2();
            row[5] = list.get(i).getGender();
            model.addRow(row);

        }
    }

    ///cakedetails show table:::::::::::;
    
   public ArrayList<cake> cakelist(){
        ArrayList<cake>cakelist=new ArrayList<>();
        java.sql.Connection con =null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3307/registration","root","");
           String query2="SELECT * FROM `cakedetails`";
           Statement st = (Statement) con.createStatement();
           ResultSet rs=st.executeQuery(query2);
           cake Cake;
           while(rs.next())
                {
                    Cake =new cake(rs.getString("name"),rs.getInt("price"),rs.getString("Product_code"),rs.getBytes("image"),rs.getString("Item_Contain"),rs.getString("category"));
                    cakelist.add(Cake);        
                }
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
        return cakelist;
    }
        public void show_cake(){
        ArrayList<cake>list=cakelist();
        DefaultTableModel model1=(DefaultTableModel)caketable.getModel();
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getname();
        row[1]=list.get(i).getprice();
        row[2]=list.get(i).getproductcode();
        row[3]=list.get(i).getitem();
        row[4]=list.get(i).getcategory();
        row[5]=list.get(i).getimage();
        model1.addRow(row);
        }
        }
        public void search(String str){
            DefaultTableModel model2=(DefaultTableModel)caketable.getModel();
            TableRowSorter<DefaultTableModel>trs=new  TableRowSorter<>(model2);
            caketable.setRowSorter(trs);
            trs.setRowFilter(RowFilter.regexFilter(str));
        }

    public void connect(){
        try{
             conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/registration","root","");
        }catch(SQLException ex){
            Logger.getLogger(DashboardUser.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    ///Order table show
     private void Order_show() {
           int c;
           java.sql.Connection con1 = null;
           try {
               try {
                   Class.forName("com.mysql.jdbc.Driver");
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
               }
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/registration", "root", "");
           PreparedStatement insert = (PreparedStatement) con1.prepareStatement("SELECT * FROM `order_table`");
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
           
//            } catch (ClassNotFoundException ex) {
//                java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }catch (SQLException ex) {
                java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
   
     ///category show table;;;;;;;;;;
     
       private void Category_show() {
           int c;
           java.sql.Connection con1 = null;
           try {
               try {
                   Class.forName("com.mysql.jdbc.Driver");
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
               }
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/registration", "root", "");
           PreparedStatement insert = (PreparedStatement) con1.prepareStatement("SELECT * FROM `cakepack` ");
           ResultSet Rs = insert.executeQuery();
            ResultSetMetaData Rss = (ResultSetMetaData) Rs.getMetaData();
            c = Rss.getColumnCount();
            DefaultTableModel Df = (DefaultTableModel) cateTable.getModel();
            Df.setRowCount(0);
            while (Rs.next()) {
                Vector v2 = new Vector();
          
                for (int ii = 1; ii <= c; ii++) {
                    v2.add(Rs.getString("Category_Id"));
                    v2.add(Rs.getString("Category_name"));     
                }
              
                Df.addRow(v2);
            }
          
            }catch (SQLException ex) {
                java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
       
      //confirm order show;
       
        private void confirmOrder_show() {
           int c;
           java.sql.Connection con1 = null;
           try {
               try {
                   Class.forName("com.mysql.jdbc.Driver");
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
               }
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/registration", "root", "");
           PreparedStatement insert = (PreparedStatement) con1.prepareStatement("SELECT * FROM `confirmorder`");
           ResultSet Rs = insert.executeQuery();
            ResultSetMetaData Rss = (ResultSetMetaData) Rs.getMetaData();
            c = Rss.getColumnCount();
            DefaultTableModel Df = (DefaultTableModel) searchT.getModel();
            Df.setRowCount(0);
            while (Rs.next()) {
                Vector v2 = new Vector();
          
                for (int ii = 1; ii <= c; ii++) {
                    v2.add(Rs.getString("username"));
                    v2.add(Rs.getString("items"));
                    v2.add(Rs.getString("Address"));
                    v2.add(Rs.getString("Phn_no"));
                    v2.add(Rs.getString("Phn_no2"));
                    v2.add(Rs.getString("TotalPrice"));
                    v2.add(Rs.getString("time"));
                    v2.add(Rs.getString("date"));
                    v2.add(Rs.getString("code"));
                      
                }
              
                Df.addRow(v2);
            }
            }catch (SQLException ex) {
                java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        time12 = new javax.swing.JLabel();
        date12 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        SearchOrder = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        searchT = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        DeliveredOrder = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        CakeCategory = new javax.swing.JPanel();
        p = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        categoryinsert = new javax.swing.JButton();
        cateupdate = new javax.swing.JButton();
        catedelete = new javax.swing.JButton();
        cateclear = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        q = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        cateTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        CakePackages = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        b = new javax.swing.JTextField();
        c = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        imm = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cakeinsert = new javax.swing.JButton();
        cakeupdate = new javax.swing.JButton();
        cakedelete = new javax.swing.JButton();
        cakeclear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        caketable = new javax.swing.JTable();
        f = new javax.swing.JTextField();
        e = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        CustomerDetails = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        CakeOrder = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        OrderT = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        code12 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        confirmorder = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        title = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(204, 0, 0));

        jLabel6.setFont(new java.awt.Font("STLiti", 3, 50)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Welcome to  Admin Portal");

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, 60));

        jButton6.setBackground(new java.awt.Color(153, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Home");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 160, 50));

        jButton7.setBackground(new java.awt.Color(153, 0, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Cake Packages");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 170, 50));

        jButton8.setBackground(new java.awt.Color(153, 0, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Cake Categories");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 170, 50));

        jButton9.setBackground(new java.awt.Color(153, 0, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Cake Order");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 170, 50));

        jButton10.setBackground(new java.awt.Color(153, 0, 0));
        jButton10.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Search Order");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 70, 170, 50));

        jButton11.setBackground(new java.awt.Color(153, 0, 0));
        jButton11.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Customer Details");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton11MouseExited(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 170, 50));

        jPanel15.setBackground(new java.awt.Color(153, 0, 0));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        time12.setBackground(new java.awt.Color(102, 102, 0));
        time12.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        time12.setForeground(new java.awt.Color(255, 255, 255));
        time12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel15.add(time12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 255, 117));

        date12.setBackground(new java.awt.Color(102, 102, 0));
        date12.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        date12.setForeground(new java.awt.Color(255, 255, 255));
        date12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel15.add(date12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 255, 59));

        jLabel24.setBackground(new java.awt.Color(102, 51, 0));
        jLabel24.setForeground(new java.awt.Color(0, 102, 0));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lr-0953.jpg"))); // NOI18N
        jPanel15.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 870));

        jPanel2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1280, 1230));

        SearchOrder.setBackground(new java.awt.Color(153, 0, 0));
        SearchOrder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Wide Latin", 1, 34)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Search Order");
        SearchOrder.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 412, 62));

        searchT.setBackground(new java.awt.Color(102, 51, 0));
        searchT.setForeground(new java.awt.Color(255, 255, 255));
        searchT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Items", "Address", "Phn_no", "Phn_no2", "Total_Price", "Time", "Date", "Code"
            }
        ));
        searchT.setRowHeight(30);
        searchT.setRowMargin(5);
        searchT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(searchT);
        if (searchT.getColumnModel().getColumnCount() > 0) {
            searchT.getColumnModel().getColumn(1).setMinWidth(20);
            searchT.getColumnModel().getColumn(1).setMaxWidth(80);
        }

        SearchOrder.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 1180, 510));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Search");
        SearchOrder.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 93, 81, -1));

        search.setBackground(new java.awt.Color(102, 51, 0));
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search.....");
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        SearchOrder.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 97, 585, -1));

        DeliveredOrder.setBackground(new java.awt.Color(153, 51, 0));
        DeliveredOrder.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        DeliveredOrder.setForeground(new java.awt.Color(255, 255, 255));
        DeliveredOrder.setText("Deliverd");
        DeliveredOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeliveredOrderActionPerformed(evt);
            }
        });
        SearchOrder.add(DeliveredOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 170, -1));

        jLabel3.setBackground(new java.awt.Color(102, 51, 0));
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lr-0953.jpg"))); // NOI18N
        SearchOrder.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 870));

        jPanel2.add(SearchOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 142, 1280, 1220));

        CakeCategory.setBackground(new java.awt.Color(153, 0, 0));
        CakeCategory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p.setBackground(new java.awt.Color(102, 51, 0));
        p.setForeground(new java.awt.Color(255, 255, 255));
        p.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CakeCategory.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 92, 238, -1));

        jLabel16.setFont(new java.awt.Font("Wide Latin", 3, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Cake Category");
        CakeCategory.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 26, 577, 48));

        categoryinsert.setText("Insert");
        categoryinsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryinsertActionPerformed(evt);
            }
        });
        CakeCategory.add(categoryinsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));

        cateupdate.setText("Update");
        cateupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cateupdateActionPerformed(evt);
            }
        });
        CakeCategory.add(cateupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, -1, -1));

        catedelete.setText("Delete");
        catedelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catedeleteActionPerformed(evt);
            }
        });
        CakeCategory.add(catedelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, -1, -1));

        cateclear.setText("Clear");
        cateclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cateclearActionPerformed(evt);
            }
        });
        CakeCategory.add(cateclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Category_Id");
        CakeCategory.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 92, 88, -1));

        q.setBackground(new java.awt.Color(102, 51, 0));
        q.setForeground(new java.awt.Color(255, 255, 255));
        q.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CakeCategory.add(q, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 126, 238, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Category_name");
        CakeCategory.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 126, -1, -1));

        cateTable.setBackground(new java.awt.Color(102, 51, 0));
        cateTable.setForeground(new java.awt.Color(255, 255, 255));
        cateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category_Id", "Category_Name"
            }
        ));
        cateTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cateTable.setRowMargin(5);
        cateTable.setSelectionBackground(new java.awt.Color(255, 102, 102));
        cateTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cateTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(cateTable);

        CakeCategory.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 201, 869, 635));

        jLabel8.setBackground(new java.awt.Color(102, 51, 0));
        jLabel8.setForeground(new java.awt.Color(0, 102, 0));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lr-0953.jpg"))); // NOI18N
        CakeCategory.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 880));

        jPanel2.add(CakeCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 153, 1290, 1210));

        CakePackages.setBackground(new java.awt.Color(153, 0, 0));
        CakePackages.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Stencil Std", 2, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cake Packages");
        CakePackages.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 24, 363, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cake Name");
        CakePackages.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 266, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Price");
        CakePackages.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 294, 88, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Item Contain");
        CakePackages.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 354, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Category");
        CakePackages.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 386, 88, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Product_Code");
        CakePackages.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 328, 96, -1));

        a.setBackground(new java.awt.Color(102, 51, 0));
        a.setForeground(new java.awt.Color(255, 255, 255));
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        CakePackages.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 266, 188, -1));

        b.setBackground(new java.awt.Color(102, 51, 0));
        b.setForeground(new java.awt.Color(255, 255, 255));
        CakePackages.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 294, 188, -1));

        c.setBackground(new java.awt.Color(102, 51, 0));
        c.setForeground(new java.awt.Color(255, 255, 255));
        CakePackages.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 322, 188, -1));

        d.setBackground(new java.awt.Color(102, 51, 0));
        d.setForeground(new java.awt.Color(255, 255, 255));
        CakePackages.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 188, -1));

        imm.setBackground(new java.awt.Color(102, 51, 0));
        imm.setForeground(new java.awt.Color(255, 255, 255));
        imm.setOpaque(true);
        CakePackages.add(imm, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 122, 200, 126));

        jButton2.setText("Browse Image");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        CakePackages.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 225, -1, -1));

        cakeinsert.setText("Insert");
        cakeinsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cakeinsertActionPerformed(evt);
            }
        });
        CakePackages.add(cakeinsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 451, -1, -1));

        cakeupdate.setText("Update");
        cakeupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cakeupdateActionPerformed(evt);
            }
        });
        CakePackages.add(cakeupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 451, -1, -1));

        cakedelete.setText("Delete");
        cakedelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cakedeleteActionPerformed(evt);
            }
        });
        CakePackages.add(cakedelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 451, -1, -1));

        cakeclear.setText("Clear");
        cakeclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cakeclearActionPerformed(evt);
            }
        });
        CakePackages.add(cakeclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 451, -1, -1));

        caketable.setBackground(new java.awt.Color(102, 51, 0));
        caketable.setForeground(new java.awt.Color(255, 255, 255));
        caketable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cake Name", "Price", "Product_Code", "Item Contain", "Category", "Image"
            }
        ));
        caketable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caketableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(caketable);
        if (caketable.getColumnModel().getColumnCount() > 0) {
            caketable.getColumnModel().getColumn(2).setHeaderValue("Product_Code");
            caketable.getColumnModel().getColumn(3).setHeaderValue("Item Contain");
            caketable.getColumnModel().getColumn(4).setHeaderValue("Category");
            caketable.getColumnModel().getColumn(5).setHeaderValue("Image");
        }

        CakePackages.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 74, 850, 800));

        f.setBackground(new java.awt.Color(102, 51, 0));
        f.setForeground(new java.awt.Color(255, 255, 255));
        CakePackages.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 191, 144, -1));

        e.setBackground(new java.awt.Color(102, 51, 0));
        e.setForeground(new java.awt.Color(255, 255, 255));
        CakePackages.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 384, 188, 31));

        jLabel21.setBackground(new java.awt.Color(102, 51, 0));
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lr-0953.jpg"))); // NOI18N
        CakePackages.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 880));

        jPanel2.add(CakePackages, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1300, 1220));

        CustomerDetails.setBackground(new java.awt.Color(153, 0, 0));
        CustomerDetails.setForeground(new java.awt.Color(255, 204, 204));
        CustomerDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(102, 51, 0));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Email", "Address", "Phn_no", "Phn_no(optional)", "Gender"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        CustomerDetails.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 79, 1194, 541));

        jLabel1.setBackground(new java.awt.Color(153, 190, 62));
        jLabel1.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer Details");
        CustomerDetails.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 6, 285, 39));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        CustomerDetails.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 52, -1, -1));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Home Page");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        CustomerDetails.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 32, -1, 14));

        jLabel22.setBackground(new java.awt.Color(102, 51, 0));
        jLabel22.setForeground(new java.awt.Color(0, 102, 0));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lr-0953.jpg"))); // NOI18N
        CustomerDetails.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 870));

        jPanel2.add(CustomerDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, 1230));

        CakeOrder.setBackground(new java.awt.Color(153, 0, 0));
        CakeOrder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OrderT.setBackground(new java.awt.Color(102, 51, 0));
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
        jScrollPane4.setViewportView(OrderT);

        CakeOrder.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 73, 880, 590));

        jLabel4.setFont(new java.awt.Font("Wide Latin", 1, 34)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cake Order");
        CakeOrder.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 0, 363, 67));

        code12.setBackground(new java.awt.Color(102, 51, 0));
        code12.setForeground(new java.awt.Color(255, 255, 255));
        CakeOrder.add(code12, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 310, 240, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Order Code");
        CakeOrder.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 290, 112, -1));

        confirmorder.setBackground(new java.awt.Color(102, 102, 255));
        confirmorder.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        confirmorder.setForeground(new java.awt.Color(255, 255, 255));
        confirmorder.setText("Confirm Order");
        confirmorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmorderActionPerformed(evt);
            }
        });
        CakeOrder.add(confirmorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 470, 153, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Items");
        CakeOrder.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 130, 60, 30));

        jTextArea2.setBackground(new java.awt.Color(102, 51, 0));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        CakeOrder.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 160, 240, 120));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Title");
        CakeOrder.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 340, 112, -1));

        title.setBackground(new java.awt.Color(102, 51, 0));
        title.setColumns(20);
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setRows(5);
        jScrollPane7.setViewportView(title);

        CakeOrder.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 360, 240, -1));

        jLabel23.setBackground(new java.awt.Color(102, 51, 0));
        jLabel23.setForeground(new java.awt.Color(0, 102, 0));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lr-0953.jpg"))); // NOI18N
        CakeOrder.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 870));

        jPanel2.add(CakeOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 137, 1300, 1230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SIGNINCUSTOM pi = new SIGNINCUSTOM();
        pi.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        // TODO add your handling code here:
        Color clr = new Color(153, 0, 0);
        jButton6.setBackground(clr);
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        Color clr = new Color(51, 0, 0);
        jButton6.setBackground(clr);
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
        Color clr = new Color(51, 0, 0);
        jButton7.setBackground(clr);
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        // TODO add your handling code here:
        Color clr = new Color(153, 0, 0);
        jButton7.setBackground(clr);
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        // TODO add your handling code here:
        Color clr = new Color(51, 0, 0);
        jButton8.setBackground(clr);
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        // TODO add your handling code here:
        Color clr = new Color(153, 0, 0);
        jButton8.setBackground(clr);
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        // TODO add your handling code here:
        Color clr = new Color(51, 0, 0);
        jButton9.setBackground(clr);
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        // TODO add your handling code here:
        Color clr = new Color(153, 0, 0);
        jButton9.setBackground(clr);
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        // TODO add your handling code here:
        Color clr = new Color(51, 0, 0);
        jButton10.setBackground(clr);
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        // TODO add your handling code here:
        Color clr = new Color(153, 0, 0);
        jButton10.setBackground(clr);
    }//GEN-LAST:event_jButton10MouseExited

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here: 
        SearchOrder.setVisible(false);
        CustomerDetails.setVisible(false);
        CakePackages.setVisible(false);
        CakeCategory.setVisible(false);
        CakeOrder.setVisible(false);
        jPanel15.setVisible(true);
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        SearchOrder.setVisible(false);
        CustomerDetails.setVisible(false);
        CakePackages.setVisible(true);
        CakeCategory.setVisible(false);
        CakeOrder.setVisible(false);
        jPanel15.setVisible(false);
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
        SearchOrder.setVisible(false);

        CustomerDetails.setVisible(false);
        CakePackages.setVisible(false);
        CakeCategory.setVisible(true);
        CakeOrder.setVisible(false);
        jPanel15.setVisible(false);
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
        SearchOrder.setVisible(false);

        CustomerDetails.setVisible(false);
        CakePackages.setVisible(false);
        CakeCategory.setVisible(false);
        CakeOrder.setVisible(true);
        jPanel15.setVisible(false);
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
        SearchOrder.setVisible(true);

        CustomerDetails.setVisible(false);
        CakePackages.setVisible(false);
        CakeCategory.setVisible(false);
        CakeOrder.setVisible(false);
        jPanel15.setVisible(false);
    }//GEN-LAST:event_jButton10MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
//        int i=jTable1.getSelectedRow();
//        TableModel model =jTable1.getModel();
//        name.setText(model.getValueAt(i,0).toString());
//        email.setText(model.getValueAt(i,1).toString());
//        add.setText(model.getValueAt(i,2).toString());
//        phn1.setText(model.getValueAt(i,3).toString());
//        phn2.setText(model.getValueAt(i,4).toString());
//        String sex=model.getValueAt(i,5).toString();
//        if(sex.equals("Male"))
//        {
//            male.setSelected(true);
//        }
//        else
//        {
//            female.setSelected(true);
//        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        AdminDashboard a = new AdminDashboard();
        a.setVisible(true);
        dispose();

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
        SearchOrder.setVisible(false);

        CustomerDetails.setVisible(true);
        CakePackages.setVisible(false);
        CakeCategory.setVisible(false);
        CakeOrder.setVisible(false);
        jPanel15.setVisible(false);
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered
        // TODO add your handling code here:
        Color clr = new Color(51, 0, 0);
        jButton11.setBackground(clr);
    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseExited
        // TODO add your handling code here:
        Color clr = new Color(153, 0, 0);
        jButton11.setBackground(clr);
    }//GEN-LAST:event_jButton11MouseExited

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File s = chooser.getSelectedFile();
        imm.setIcon(new ImageIcon(s.toString()));
        file = s.getAbsolutePath();
        f.setText(file);
        try {
            File images = new File(file);
            FileInputStream fis = new FileInputStream(images);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            image = bos.toByteArray();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void cakeinsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cakeinsertActionPerformed
        // TODO add your handling code here:
        String name = a.getText();
        String price = b.getText();
        String productcode = c.getText();
        String item = d.getText();
        String category =(String) e.getSelectedItem();

        java.sql.PreparedStatement ps;
        String query = "INSERT INTO `cakedetails`(`name`, `price`, `Product_code`, `image`, `Item_Contain`, `Category`) VALUES (?,?,?,?,?,?)";
        try {

            ps = Myconnection.mycon().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, productcode);
            ps.setBytes(4, image);
            ps.setString(5, item);
            ps.setString(6, category);
            ps.executeUpdate();

            //ps.close();
            DefaultTableModel model1 = (DefaultTableModel) caketable.getModel();
            model1.setRowCount(0);
            show_cake();
            JOptionPane.showMessageDialog(null, "insert Successful");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_cakeinsertActionPerformed

    private void cakeupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cakeupdateActionPerformed
        //Update code ;
        java.sql.PreparedStatement ps;               
        String v3 = c.getText();
        int p = JOptionPane.showConfirmDialog(null, "Are you sure want to Upadate?", "Upadte Record", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            try {
                String v1 = a.getText();
                String v2 = b.getText();

                String v4 = d.getText();
                String v5 = (String) e.getSelectedItem();
                String v6 = f.getText();
                String sql = "UPDATE `cakedetails` SET `name`='"+v1+"',`price`='"+v2+"',`Product_code`='"+v3+"',`image`='"+v6+"',`Item_Contain`='"+v4+"',`Category`='"+v5+"'";
                ps = Myconnection.mycon().prepareStatement(sql);
                ps.execute();
                 DefaultTableModel model1 = (DefaultTableModel) caketable.getModel();
                 model1.setRowCount(0);
               show_cake();
               
                JOptionPane.showMessageDialog(null, "Updated successfully");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            try {
                File images = new File(file);
                FileInputStream fis = new FileInputStream(images);
                byte[] image = new byte[(int) file.length()];
                fis.read(image);
                String sql = "UPDATE `cakedetails` SET `image`=? WHERE `Product_code`='"+v3+"'";
                ps = Myconnection.mycon().prepareStatement(sql);
                ps.setBytes(1, image);
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

//       java.sql.Connection con ;
//     try{
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/registration","root","");
//            int row=jTable2.getSelectedRow();
//            String value =(jTable2.getModel().getValueAt(row,0).toString());
//            String query3="UPDATE `cakedetails` SET price=?,size=?,image=?,Item_Contain=?,Category=? WHERE Name="+jTable2.getModel().getValueAt(row,0).toString();
//            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query3);
//            //java.sql.PreparedStatement ps;
//             ps.setString(0,jTextField1.getText());
//             ps.setString(1,jTextField2.getText());
//             ps.setString(2,jTextField3.getText());
//             ps.setString(3,jTextField4.getText());
//             ps.setString(4,jTextField7.getText()); 
//            // ps.setBytes(5,image);
//             ps.executeUpdate();
//             DefaultTableModel model1=(DefaultTableModel)jTable2.getModel();
//             model1.setRowCount(0);
//             show_cake() ;
//             JOptionPane.showMessageDialog(null,"Updated Successful");
//        
//       
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }

    }//GEN-LAST:event_cakeupdateActionPerformed

    private void cakedeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cakedeleteActionPerformed
        // Delete code
        java.sql.PreparedStatement ps;
        String sql = "DELETE FROM `cakedetails` WHERE name=?";
        try {
            ps = Myconnection.mycon().prepareStatement(sql);
            ps.setString(1, a.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Are you sure want to delete?.");
             DefaultTableModel model1 = (DefaultTableModel) caketable.getModel();
            model1.setRowCount(0);
            show_cake();
            
        } catch (HeadlessException | SQLException e) {

        }
        //show_cake();

//        java.sql.PreparedStatement ps;
//        String sql = "DELETE FROM menu WHERE date=?";
//        try {
//            Class.forName("com.mysql.jdbc.Driver"); //Register the mysql driver
//           Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/dining_management","root","");
//            ps = con1.prepareStatement("DELETE FROM menu WHERE date=?");
//            ps.setString(1, ((JTextField)a.getDateEditor().getUiComponent()).getText());
//            ps.execute();
//           // JOptionPane.showMessageDialog(null, "Are you sure want to delete?.");
//            DefaultTableModel model1 = (DefaultTableModel) table8.getModel();
//            model1.setRowCount(0);
//            table_show8();
//        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
//
//        }
    }//GEN-LAST:event_cakedeleteActionPerformed

     
    private void cakeclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cakeclearActionPerformed
        // TODO add your handling code here:
        a.setText(null);
        b.setText(null);
        c.setText(null);
        d.setText(null);
        e.setSelectedItem(null);
        f.setText(null);
        //a.setVisible(false);
    }//GEN-LAST:event_cakeclearActionPerformed

    private void caketableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caketableMouseClicked
        // TODO add your handling code here:
        int i = caketable.getSelectedRow();
        TableModel model11 = caketable.getModel();
        a.setText(model11.getValueAt(i, 0).toString());
        b.setText(model11.getValueAt(i, 1).toString());
        c.setText(model11.getValueAt(i, 2).toString());
        d.setText(model11.getValueAt(i, 3).toString());
        e.setSelectedItem(model11.getValueAt(i, 4));
        f.setText(model11.getValueAt(i, 5).toString());
        //JLabel imageJ1=(JLabel)model11.getValueAt(i, 5);
         byte[] img=(cakelist().get(i).getimage());
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(imm.getWidth(),imm.getHeight(),Image.SCALE_SMOOTH));
        imm.setIcon(imageIcon);
        
   //  kkkk   

    }//GEN-LAST:event_caketableMouseClicked

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aActionPerformed

    private void categoryinsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryinsertActionPerformed
        // TODO add your handling code here:
        String Category_Id = p.getText();
        String Category_name = q.getText();

        java.sql.PreparedStatement ps;
        String query2 = "INSERT INTO `cakepack`(`Category_Id`,`Category_name`) VALUES (?,?)";
        try {

            ps = Myconnection.mycon().prepareStatement(query2);
            ps.setString(1, Category_Id);
            ps.setString(2, Category_name);

            ps.executeUpdate();
            
            //ps.close();
            DefaultTableModel model2 = (DefaultTableModel) cateTable.getModel();
            model2.setRowCount(0);
            Category_show();
            
            JOptionPane.showMessageDialog(null, "Add Successful");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_categoryinsertActionPerformed

    private void cateupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cateupdateActionPerformed
        // TODO add your handling code here:
        
          java.sql.PreparedStatement ps;               
         
        int r = JOptionPane.showConfirmDialog(null, "Are you sure want to Upadate?", "Upadte Record", JOptionPane.YES_NO_OPTION);
        if (r == 0) {
            try {
                String v1 =p.getText();
                String v2 = q.getText();
                String sql = "UPDATE `cakepack` SET `Category_Id`='"+v1+"',`Category_name`='"+v2+"'";
                ps = Myconnection.mycon().prepareStatement(sql);
                ps.execute();
                 DefaultTableModel model1 = (DefaultTableModel) cateTable.getModel();
                 model1.setRowCount(0);
                 Category_show();
               
                JOptionPane.showMessageDialog(null, "Updated successfully");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
        }

        
    }//GEN-LAST:event_cateupdateActionPerformed

    private void catedeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catedeleteActionPerformed
        // TODO add your handling code here:
        
          java.sql.PreparedStatement ps;
        String sql = "DELETE FROM `cakepack` WHERE Category_name=?";
        try {
            ps = Myconnection.mycon().prepareStatement(sql);
            ps.setString(1, p.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Are you sure want to delete?.");
            DefaultTableModel model1 = (DefaultTableModel) cateTable.getModel();
            model1.setRowCount(0);
            Category_show();
            JOptionPane.showMessageDialog(null, "Deletion Successful");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_catedeleteActionPerformed

    private void cateclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cateclearActionPerformed
        // TODO add your handling code here:
        p.setText(null);
        q.setText(null);
        
    }//GEN-LAST:event_cateclearActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void confirmorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmorderActionPerformed
        // TODO add your handling code here:
        int i = OrderT.getSelectedRow();
        TableModel model11 = OrderT.getModel();
        
        String name = model11.getValueAt(i, 0).toString();
        String item = model11.getValueAt(i, 1).toString();
        String address = model11.getValueAt(i, 7).toString();
        String phn = model11.getValueAt(i, 5).toString();
        String phn2 =model11.getValueAt(i, 6).toString();
        String price =model11.getValueAt(i, 2).toString();
        String code =code12.getText();
        String time =time12.getText();
        String date =date12.getText();
        String Title=title.getText();
          

        java.sql.PreparedStatement ps;
        String query = "INSERT INTO `confirmorder`(`username`, `items`, `Address`, `Phn_no`, `Phn_no2`, `TotalPrice`, `time`, `date`, `code`,`Title`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {

            ps = Myconnection.mycon().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, item);
            ps.setString(3, address);
            ps.setString(4, phn);
             ps.setString(5, phn2);
            ps.setString(6, price);
            ps.setString(9, code);
            ps.setString(7, time);
            ps.setString(8, date);
            ps.setString(10, Title);
            ps.executeUpdate();
            confirmOrder_show();
            JOptionPane.showMessageDialog(null, "Order Confirm........");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_confirmorderActionPerformed

    private void OrderTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTMouseClicked
        // TODO add your handling code here:
          int i = OrderT.getSelectedRow();
        TableModel model11 = OrderT.getModel();
        jTextArea2.setText(model11.getValueAt(i, 1).toString());
        
        
        
    }//GEN-LAST:event_OrderTMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchActionPerformed

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        // TODO add your handling code here:
//        String searchS=search.getText();
//       searchO(searchS);
    }//GEN-LAST:event_searchMouseClicked

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
 String searchS=search.getText();
       searchO(searchS);        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyReleased

    private void cateTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cateTableMouseClicked
        // TODO add your handling code here:
         int i = cateTable.getSelectedRow();
        TableModel model11 = cateTable.getModel();
        p.setText(model11.getValueAt(i, 0).toString());
        q.setText(model11.getValueAt(i, 1).toString());
        
        
    }//GEN-LAST:event_cateTableMouseClicked

    private void DeliveredOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeliveredOrderActionPerformed
        // TODO add your handling code here:
        
          java.sql.PreparedStatement ps;
        String sql = "DELETE FROM `confirmorder` WHERE `code`=?";
        try {
            ps = Myconnection.mycon().prepareStatement(sql);
            ps.setString(1, search.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Are you sure want to delete?.");
            DefaultTableModel model1 = (DefaultTableModel) searchT.getModel();
            model1.setRowCount(0);
            confirmOrder_show();
            JOptionPane.showMessageDialog(null, "Deletion Successful");
        }  catch (HeadlessException | SQLException e) {

        }
    }//GEN-LAST:event_DeliveredOrderActionPerformed

    private void searchTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTMouseClicked
        // TODO add your handling code here:
         int i = searchT.getSelectedRow();
        TableModel model11 = searchT.getModel();
    }//GEN-LAST:event_searchTMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CakeCategory;
    private javax.swing.JPanel CakeOrder;
    private javax.swing.JPanel CakePackages;
    private javax.swing.JPanel CustomerDetails;
    private javax.swing.JButton DeliveredOrder;
    private javax.swing.JTable OrderT;
    private javax.swing.JPanel SearchOrder;
    private javax.swing.JTextField a;
    private javax.swing.JTextField b;
    private javax.swing.JTextField c;
    private javax.swing.JButton cakeclear;
    private javax.swing.JButton cakedelete;
    private javax.swing.JButton cakeinsert;
    private javax.swing.JTable caketable;
    private javax.swing.JButton cakeupdate;
    private javax.swing.JTable cateTable;
    private javax.swing.JButton cateclear;
    private javax.swing.JButton catedelete;
    private javax.swing.JButton categoryinsert;
    private javax.swing.JButton cateupdate;
    private javax.swing.JTextField code12;
    private javax.swing.JButton confirmorder;
    private javax.swing.JTextField d;
    private javax.swing.JLabel date12;
    private javax.swing.JComboBox<String> e;
    private javax.swing.JTextField f;
    private javax.swing.JLabel imm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField p;
    private javax.swing.JTextField q;
    private javax.swing.JTextField search;
    private javax.swing.JTable searchT;
    private javax.swing.JLabel time12;
    private javax.swing.JTextArea title;
    // End of variables declaration//GEN-END:variables
byte[] image = null;
    String file = null;
}
