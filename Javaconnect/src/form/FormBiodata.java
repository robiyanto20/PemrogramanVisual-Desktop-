/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

//<editor-fold defaultstate="collapsed" desc="comment">
import config2.KoneksiDB;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
//</editor-fold>
/**
 *
 * @author y
 */
public class FormBiodata extends javax.swing.JFrame {
    
    // menyiapkan object yang diperlukan untuk mengelola database
    private Statement st;
    private ResultSet rs;
    private Connection conn;
    private String nimToUpdate;
    
    /**
     * Creates new form FormBiodata
     */
    private ButtonGroup buttonGroup1;
    
    public FormBiodata() {
    initComponents();
    conn = KoneksiDB.getConnection();
    tampilData();
    buttonGroup1 = new ButtonGroup();
    buttonGroup1.add(rbLaki);
    buttonGroup1.add(rbPerempuan);
    // Call the loadProdiData method to populate the ComboBox
    loadProdiData();
}
    private void loadProdiData() {
    try {
        // Create the statement and execute the query
        Statement stProdi = conn.createStatement();
        String sqlProdi = "SELECT prodi FROM tbl_prodi";
        ResultSet rsProdi = stProdi.executeQuery(sqlProdi);

        // Clear existing items in the ComboBox
        cmbProdi.removeAllItems();

        // Add prodi values to the ComboBox
        while (rsProdi.next()) {
            cmbProdi.addItem(rsProdi.getString("prodi"));
        }

        // Close the statement and result set
        stProdi.close();
        rsProdi.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error fetching prodi data: " + e.getMessage());
    }
}
    
    // membuat method clear form
    private void clearForm() {
        tfNama.setText("");
        tfNIM.setText("");
        tfTTL.setText("");
        buttonGroup1.clearSelection();
        cmbProdi.setSelectedItem("-- Program Studi --");
        tfNomorTelepon.setText("");
        taAlamat.setText("");
        tfNama.requestFocus();
    }
    
    private void hapusData() {
	    int row = tbl_biodata.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus!");
            return;
        }

        // Ambil nilai nim dari data yang dipilih
        String nim = tbl_biodata.getValueAt(row, 2).toString();

        // Buat query SQL
        String sql = "DELETE FROM tbl_biodata WHERE nim=?";

        try {
            // Siapkan prepared statement
            PreparedStatement ps = conn.prepareStatement(sql);

            // Isi nilai parameter
            ps.setString(1, nim);

            // Eksekusi statement
            int hasil = ps.executeUpdate();

            // Tampilkan pesan sukses
            if (hasil > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan");
            }
            tampilData();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void tampilData() {
        DefaultTableModel kolomtabel = new DefaultTableModel();
        kolomtabel.addColumn("No.");
        kolomtabel.addColumn("Nama");
        kolomtabel.addColumn("NIM");
        kolomtabel.addColumn("TTL");
        kolomtabel.addColumn("Jenis Kelamin");
        kolomtabel.addColumn("Prodi");
        kolomtabel.addColumn("No. Telepon");
        kolomtabel.addColumn("Alamat");
        try {
            int nomor = 1;
            // buat objek statement untuk mengeksekusi query mysql.
            st = conn.createStatement();
            // buat query ke database
            String sql = "Select * FROM tbl_biodata";
            // eksekusi query dan simpan hasilnya di objek ResultSet
            rs = st.executeQuery(sql);
            // tampilkan hasil query menggunakan perulangan while
            while (rs.next()) {
                kolomtabel.addRow(new Object[]{
                    ("" + nomor++),
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getString("ttl"),
                    rs.getString("jekel"),
                    rs.getString("prodi"),
                    rs.getString("notelp"),
                    rs.getString("alamat"),});
                tbl_biodata.setModel(kolomtabel);
                tbl_biodata.enable(true);
                tfNama.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data. \n" + e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        tfNIM = new javax.swing.JTextField();
        tfTTL = new javax.swing.JTextField();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        cmbProdi = new javax.swing.JComboBox<>();
        tfNomorTelepon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAlamat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_biodata = new javax.swing.JTable();
        btnSubmit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnTambahJurusan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Biodata Mahasisiwa");

        jLabel2.setText("Nama Mahasiswa/i");

        jLabel3.setText("NIM");

        jLabel4.setText("Tempat tanggal lahir");

        jLabel5.setText("Jenis Kelamin");

        jLabel6.setText("Prodi");

        jLabel7.setText("No Telepon");

        jLabel8.setText("Alamat");

        tfNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaActionPerformed(evt);
            }
        });

        rbLaki.setText("Laki-laki");

        rbPerempuan.setText("Perempuan");

        cmbProdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProdiActionPerformed(evt);
            }
        });

        tfNomorTelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomorTeleponActionPerformed(evt);
            }
        });

        taAlamat.setColumns(20);
        taAlamat.setRows(5);
        jScrollPane1.setViewportView(taAlamat);

        tbl_biodata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_biodata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_biodataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_biodata);

        btnSubmit.setText("Tambah");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnUpdate.setText("Ubah");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnTambahJurusan.setText("Tambah Prodi");
        btnTambahJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahJurusanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbLaki)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbPerempuan))
                            .addComponent(cmbProdi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfTTL)
                            .addComponent(tfNIM)
                            .addComponent(tfNama)
                            .addComponent(tfNomorTelepon)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnSubmit)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnTambahJurusan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)
                        .addGap(252, 252, 252))))
            .addGroup(layout.createSequentialGroup()
                .addGap(418, 418, 418)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rbLaki)
                            .addComponent(rbPerempuan))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfNomorTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnExit)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnSubmit)
                    .addComponent(btnTambahJurusan))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        tfNama.setText("");
        tfNIM.setText("");
        tfTTL.setText("");
        buttonGroup1.clearSelection();
        cmbProdi.setSelectedItem("-- Program Studi --");
        tfNomorTelepon.setText("");
        taAlamat.setText("");
        tfNama.requestFocus();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        //membuat validasi form kosong
        if (tfNama.getText().equals("")
                || tfNIM.getText().equals("")
                || tfTTL.getText().equals("")
                || tfNomorTelepon.getText().equals("")
                || taAlamat.getText().equals("")
                || buttonGroup1.isSelected(null)
                || cmbProdi.getSelectedItem().equals("-- Program Studi --")) {
            JOptionPane.showMessageDialog(this, "Field harap di isi !",
                    "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
        String cekDB = "SELECT * FROM tbl_biodata WHERE nim = '" + tfNIM.getText() + "' ";
        rs = st.executeQuery(cekDB);
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "NIM sudah tersedia !");
        } else {
            st = conn.createStatement();
            String jekel;
            if (rbLaki.isSelected()) {
                jekel = "Laki - Laki";
            } else {
                jekel = "Perempuan";
            }
            // Get the selected prodi value
            String selectedProdi = cmbProdi.getSelectedItem().toString();

            // Execute the query with the selected prodi value
            String sql = "INSERT INTO tbl_biodata VALUES ('"
                    + tfNama.getText()
                    + "', '" + tfNIM.getText()
                    + "', '" + tfTTL.getText()
                    + "', '" + jekel
                    + "', '" + selectedProdi
                    + "', '" + tfNomorTelepon.getText()
                    + "', '" + taAlamat.getText()
                    + "') ";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            tampilData();
            clearForm();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        hapusData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbl_biodataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_biodataMouseClicked
        // TODO add your handling code here:
        int row = tbl_biodata.getSelectedRow();
        tfNama.setText(tbl_biodata.getValueAt(row, 1).toString());
        tfNIM.setText(tbl_biodata.getValueAt(row, 2).toString());
        tfTTL.setText(tbl_biodata.getValueAt(row, 3).toString());
        cmbProdi.setSelectedItem(tbl_biodata.getValueAt(row, 5).toString());
        tfNomorTelepon.setText(tbl_biodata.getValueAt(row, 6).toString());
        taAlamat.setText(tbl_biodata.getValueAt(row, 7).toString());
        // Set nilai NIM yang akan diubah
        nimToUpdate = tbl_biodata.getValueAt(row, 2).toString();
    }//GEN-LAST:event_tbl_biodataMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
         int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (nimToUpdate == null || nimToUpdate.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah!");
        return;
    }

    try {
        String jekel;
        if (rbLaki.isSelected()) {
            jekel = "Laki - Laki";
        } else {
            jekel = "Perempuan";
        }

        // Buat query untuk update data
        String sql = "UPDATE tbl_biodata SET nama=?, ttl=?, jekel=?, prodi=?, notelp=?, alamat=? WHERE nim=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tfNama.getText());
        ps.setString(2, tfTTL.getText());
        ps.setString(3, jekel);
        ps.setString(4, cmbProdi.getSelectedItem().toString());
        ps.setString(5, tfNomorTelepon.getText());
        ps.setString(6, taAlamat.getText());
        ps.setString(7, nimToUpdate);

        // Eksekusi query update
        int hasil = ps.executeUpdate();

        // Tampilkan pesan sukses
        if (hasil > 0) {
            JOptionPane.showMessageDialog(this, "Data berhasil diubah");
            tampilData();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Data tidak ditemukan");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cmbProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProdiActionPerformed

    private void tfNomorTeleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomorTeleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomorTeleponActionPerformed

    private void btnTambahJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahJurusanActionPerformed
        // TODO add your handling code here:
        FormProdi formJurusan = new FormProdi();
        formJurusan.setVisible(true);
    }//GEN-LAST:event_btnTambahJurusanActionPerformed

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
            java.util.logging.Logger.getLogger(FormBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBiodata().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnTambahJurusan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbProdi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTextArea taAlamat;
    private javax.swing.JTable tbl_biodata;
    private javax.swing.JTextField tfNIM;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNomorTelepon;
    private javax.swing.JTextField tfTTL;
    // End of variables declaration//GEN-END:variables


}
