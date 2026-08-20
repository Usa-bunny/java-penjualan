package nesumart;

import javax.swing.JOptionPane;
import java.sql.*;
import database.dbConnection;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.swing.JTable;

public class Kasir extends javax.swing.JPanel {

    Connection connection;
    ResultSet resultset;
    PreparedStatement preparedstatement;
    DefaultTableModel defaulttablemodel;
    ResultSetMetaData resultsetmetadata;

    dbConnection dbconnection;

    String id_pelanggan, nama_pelanggan, alamat_pelanggan, id_produk, jumlah_produk, nama_produk, harga_produk, stok_produk, subtotal_produk, id_penjualan, total_bayar;
    String tanggal = LocalDate.now().toString();

    public Kasir() {
        initComponents();

        dbconnection = new dbConnection();
        connection = dbconnection.getConnection();

        fillPelangganCombobox();
        fillProdukCombobox();

        showTable();
        getTotal();

        tanggalLabel.setText(tanggal);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailPenjualanTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        pelangganCombobox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tanggalLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        simpanButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        productCombobox = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jumlahField = new javax.swing.JTextField();

        jLabel2.setText("Pelanggan");

        detailPenjualanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(detailPenjualanTable);

        jLabel7.setText("Total Bayar");

        totalLabel.setText("RP. O");

        pelangganCombobox.addActionListener(this::pelangganComboboxActionPerformed);

        jLabel3.setText("Tanggal");

        tanggalLabel.setText("0/0/0");

        addButton.setText("Add");
        addButton.addActionListener(this::addButtonActionPerformed);

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(this::simpanButtonActionPerformed);

        jLabel5.setText("Pilih Produck");

        productCombobox.addActionListener(this::productComboboxActionPerformed);

        jLabel6.setText("Jumlah");

        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistem Kasir");

        jLabel4.setFont(new java.awt.Font("JetBrains Mono", 0, 18)); // NOI18N
        jLabel4.setText("Daftar Belanja");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pelangganCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productCombobox, 0, 372, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jumlahField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tanggalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pelangganCombobox, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(tanggalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productCombobox, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jumlahField))
                .addGap(18, 18, 18)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        jumlah_produk = jumlahField.getText().trim();

        if (jumlah_produk.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jumlah produk tidak boleh kosong!");
            return;
        }

        try {
            int jumlah = Integer.parseInt(jumlah_produk);
            int harga = Integer.parseInt(harga_produk);
            int stok = Integer.parseInt(stok_produk);

            if (jumlah <= 0) {
                JOptionPane.showMessageDialog(this, "Jumlah produk harus lebih dari 0!");
                return;
            }
            if (jumlah > stok) {
                JOptionPane.showMessageDialog(this, "Stok tidak cukup! Stok tersisa: " + stok);
                return;
            }

            subtotal_produk = String.valueOf(harga * jumlah);
            stok_produk = String.valueOf(stok - jumlah);

            if (createPenjualan()) {
                if (createDetailPenjualan()) {
                    if (updateStok()) {
                        fillProdukCombobox();
                        showTable();
                        getTotal();
                        clear();
                    }
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Jumlah produk harus berupa angka!");
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void pelangganComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelangganComboboxActionPerformed
        String selected = (String) pelangganCombobox.getSelectedItem();
        if (selected != null && !selected.isEmpty()) {
            String[] parts = selected.split(" - ");

            id_pelanggan = parts[0];
            nama_pelanggan = parts[1];
            alamat_pelanggan = parts[2];
        }
    }//GEN-LAST:event_pelangganComboboxActionPerformed

    private void productComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productComboboxActionPerformed
        String selected = (String) productCombobox.getSelectedItem();
        if (selected != null && !selected.isEmpty()) {
            String[] parts = selected.split(" - ");

            id_produk = parts[0];
            nama_produk = parts[1];
            harga_produk = parts[2];
            stok_produk = parts[3];
        }
    }//GEN-LAST:event_productComboboxActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        MessageFormat header = new MessageFormat("Data Penjualan");
        
        MessageFormat footer = new MessageFormat("Data Detail Penjualan | Page {0, number, integer}");
        try {
            detailPenjualanTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException e) {
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void fillPelangganCombobox() {
        String sql = "SELECT * FROM pelanggan";

        try {
            preparedstatement = connection.prepareStatement(sql);
            resultset = preparedstatement.executeQuery();

            pelangganCombobox.removeAllItems();

            while (resultset.next()) {
                String id = resultset.getString("id_pelanggan");
                String nama = resultset.getString("nama");
                String alamat = resultset.getString("alamat");
                pelangganCombobox.addItem(id + " - " + nama + " - " + alamat);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void fillProdukCombobox() {
        String sql = "SELECT * FROM produk";

        try {
            preparedstatement = connection.prepareStatement(sql);
            resultset = preparedstatement.executeQuery();

            productCombobox.removeAllItems();

            while (resultset.next()) {
                String id = resultset.getString("id_produk");
                String nama = resultset.getString("nama_produk");
                String harga = resultset.getString("harga");
                String stok = resultset.getString("stok");
                productCombobox.addItem(id + " - " + nama + " - " + harga + " - " + stok);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private boolean updateStok() {
        String sql = "UPDATE `produk` SET `stok`= ? WHERE `id_produk` = ?;";

        try {
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setInt(1, Integer.parseInt(stok_produk));
            preparedstatement.setInt(2, Integer.parseInt(id_produk));

            int update = preparedstatement.executeUpdate();

            if (update != 1) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input angka tidak valid!");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    private boolean createPenjualan() {
        String sql = "INSERT INTO `penjualan` (`tanggal`, `id_pelanggan`) VALUES (?, ?)";

        try {
            preparedstatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedstatement.setString(1, tanggal);
            preparedstatement.setInt(2, Integer.parseInt(id_pelanggan));

            int insert = preparedstatement.executeUpdate();

            if (insert != 1) {
                return false;
            }

            resultset = preparedstatement.getGeneratedKeys();
            if (resultset.next()) {
                id_penjualan = String.valueOf(resultset.getInt(1));
            } else {
                return false;
            }

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    private boolean createDetailPenjualan() {
        String sql = "INSERT INTO `detail_penjualan` (`id_penjualan`, `id_produk`, `jumlah`, `subtotal`) VALUES (?, ?, ?, ?);";

        try {
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setInt(1, Integer.parseInt(id_penjualan));
            preparedstatement.setInt(2, Integer.parseInt(id_produk));
            preparedstatement.setInt(3, Integer.parseInt(jumlah_produk));
            preparedstatement.setInt(4, Integer.parseInt(subtotal_produk));

            int insert = preparedstatement.executeUpdate();

            if (insert != 1) {
                return false;
            }

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    private boolean showTable() {
        String sql = "SELECT pl.nama AS 'Pelanggan', pr.nama_produk AS 'Nama Produk', pr.harga AS 'Harga', dp.jumlah AS 'Jumlah', dp.subtotal AS 'Subtotal' "
                + "FROM detail_penjualan dp "
                + "INNER JOIN produk pr ON dp.id_produk = pr.id_produk "
                + "INNER JOIN penjualan pj ON dp.id_penjualan = pj.id_penjualan "
                + "INNER JOIN pelanggan pl ON pj.id_pelanggan = pl.id_pelanggan;";

        try {
            preparedstatement = connection.prepareStatement(sql);

            resultset = preparedstatement.executeQuery();

            // Buat model tabel langsung dari resultset
            defaulttablemodel = createTableModel(resultset);
            detailPenjualanTable.setModel(defaulttablemodel);
            detailPenjualanTable.setAutoCreateRowSorter(true);

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

    private void getTotal() {
        String sql = "SELECT SUM(dp.subtotal) AS total "
                + "FROM detail_penjualan dp ";

        try {
            preparedstatement = connection.prepareStatement(sql);

            resultset = preparedstatement.executeQuery();

            if (resultset.next()) {
                int total = resultset.getInt("total");
                total_bayar = String.valueOf(total);
                totalLabel.setText("Rp " + total);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID Pelanggan belum valid!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void clear() {
        pelangganCombobox.setSelectedIndex(0);
        productCombobox.setSelectedIndex(0);
        jumlahField.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable detailPenjualanTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jumlahField;
    private javax.swing.JComboBox<String> pelangganCombobox;
    private javax.swing.JComboBox<String> productCombobox;
    private javax.swing.JButton simpanButton;
    private javax.swing.JLabel tanggalLabel;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables

}
