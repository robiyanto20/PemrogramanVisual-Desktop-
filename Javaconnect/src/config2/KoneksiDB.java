/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config2;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author y
 */
public class KoneksiDB {
    
    private static Connection conn;

    public static Connection getConnection() {
        try {
//untuk menentukan driver DB
            Class.forName("com.mysql.cj.jdbc.Driver");
//untuk membuat koneksi dari DB ke driver
            String url = "jdbc:mysql://localhost:3306/pv_biodata";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
//pesan jika koneksi berhasil
//            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch (Exception e) {
//pesan jika koneksi gagal
//            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
        return conn;
    }
}
