package nesumart;

import javax.swing.JOptionPane;
import java.sql.*;
import database.dbConnection;
import javax.swing.table.DefaultTableModel;

public class Product extends javax.swing.JPanel {

    Connection connection;
    ResultSet resultset;
    PreparedStatement preparedstatement;
    DefaultTableModel defaulttablemodel;
    ResultSetMetaData resultsetmetadata;

    dbConnection dbconnection;

    String nama, id, stok, harga;

    public Product() {
        initComponents();

        dbconnection = new dbConnection();
        connection = dbconnection.getConnection();
        
        showTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namaField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        stokField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hargaField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        loadButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        produkTabel = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Product");

        jLabel2.setText("Nama Produk");

        jLabel3.setText("Stok");

        jLabel4.setText("Harga");

        jLabel5.setText("ID Product");

        loadButton.setText("Load");
        loadButton.addActionListener(this::loadButtonActionPerformed);

        insertButton.setText("Insert");
        insertButton.addActionListener(this::insertButtonActionPerformed);

        updateButton.setText("Update");
        updateButton.addActionListener(this::updateButtonActionPerformed);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(this::deleteButtonActionPerformed);

        produkTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(produkTabel);

        jLabel6.setText("Semua data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loadButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(insertButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namaField, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                            .addComponent(stokField, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hargaField, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(insertButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idField)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stokField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hargaField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        id = idField.getText();

        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "please fill id produk field");
            return;
        }

        loadProduct();
        showData();
        showTable();
    }//GEN-LAST:event_loadButtonActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        nama = namaField.getText().trim();
        stok = stokField.getText().trim();
        harga = hargaField.getText().trim();

        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(null, "nama should not be to empty");
            return;
        }
        if (stokField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "stock should not be to empty");
            return;
        }
        if (hargaField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "harga should not be to empty");
            return;
        }

        insertData();
        showTable();
        clear();
    }//GEN-LAST:event_insertButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        id = idField.getText().trim();
        nama = namaField.getText().trim();
        stok = stokField.getText().trim();
        harga = hargaField.getText().trim();

        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "please fill id produk field");
            return;
        }
        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(null, "nama should not be to empty");
            return;
        }
        if (stokField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "stock should not be to empty");
            return;
        }
        if (hargaField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "harga should not be to empty");
            return;
        }

        updateData();
        showTable();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        id = idField.getText();

        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "please fill id produk field");
            return;
        }

        deleteData();
        showTable();
        clear();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clear() {
        namaField.setText("");
        stokField.setText("");
        hargaField.setText("");
        idField.setText("");

        nama = null;
        harga = null;
        stok = null;
        id = null;
    }

    private boolean insertData() {
        String sql = "INSERT INTO `produk` (`nama_produk`, `harga`, `stok`) VALUES (?,?,?);";

        try {
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, nama);
            preparedstatement.setInt(2, Integer.parseInt(harga));
            preparedstatement.setInt(3, Integer.parseInt(stok));

            int insert = preparedstatement.executeUpdate();

            if (insert != 1) return false; 
          
            JOptionPane.showMessageDialog(null, "Success insert data");
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Harga dan stok harus berupa angka!");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    private boolean updateData() {
        String sql = "UPDATE `produk` SET `nama_produk`= ?,`harga`= ?,`stok`= ? WHERE `id_produk` = ?;";

        try {
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, nama);
            preparedstatement.setInt(2, Integer.parseInt(harga));
            preparedstatement.setInt(3, Integer.parseInt(stok));
            preparedstatement.setInt(4, Integer.parseInt(id));

            int update = preparedstatement.executeUpdate();

            if (update != 1) return false;
            
            JOptionPane.showMessageDialog(null, "Success Update data");
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input angka tidak valid!");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    private boolean deleteData() {
        String sql = "DELETE FROM `produk` WHERE `id_produk` = ?;";

        try {
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setInt(1, Integer.parseInt(id));

            int delete = preparedstatement.executeUpdate();

            if (delete != 1) return false;
            
            JOptionPane.showMessageDialog(null, "Success delete data");
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID tidak valid!");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    private void loadProduct() {
        String sql = "SELECT * FROM `produk` WHERE id_produk = ?;";

        try {
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setInt(1, Integer.parseInt(id));

            resultset = preparedstatement.executeQuery();

            if (resultset.next()) {
                nama = resultset.getString("nama_produk");
                stok = String.valueOf(resultset.getInt("stok"));
                harga = String.valueOf(resultset.getInt("harga"));
            } else {
                JOptionPane.showMessageDialog(null, "Id not found");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID tidak valid!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void showData() {
        namaField.setText(nama);
        stokField.setText(String.valueOf(stok));
        hargaField.setText(String.valueOf(harga));
    }
    
     private boolean showTable() {
        String sql = "SELECT `id_produk` AS 'Id', `nama_produk` AS 'Produk', `harga` AS 'Harga', `stok` AS 'Stok' FROM `produk`;";

        try {
            preparedstatement = connection.prepareStatement(sql);

            resultset = preparedstatement.executeQuery();

            // Buat model tabel langsung dari resultset
            defaulttablemodel = createTableModel(resultset);
            produkTabel.setModel(defaulttablemodel);
            produkTabel.setAutoCreateRowSorter(true);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID Pelanggan belum valid!");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }

        return true;
    }

    private DefaultTableModel createTableModel(ResultSet resultset) throws SQLException {
        defaulttablemodel = new DefaultTableModel();
        resultsetmetadata = resultset.getMetaData();
        int columnCount = resultsetmetadata.getColumnCount();

        String[] columnName = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columnName[i] = resultsetmetadata.getColumnLabel(i + 1);
        }
        defaulttablemodel.setColumnIdentifiers(columnName);

        while (resultset.next()) {
            String[] data = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                data[i] = resultset.getString(i + 1);
            }
            defaulttablemodel.addRow(data);
        }

        return defaulttablemodel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField hargaField;
    private javax.swing.JTextField idField;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loadButton;
    private javax.swing.JTextField namaField;
    private javax.swing.JTable produkTabel;
    private javax.swing.JTextField stokField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

}
