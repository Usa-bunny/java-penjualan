# java-penjualan

```bash
mysql -u root -p
CREATE DATABASE db_penjualan;
USE db_penjualan;
CREATE TABLE pelanggan (id_pelanggan INT PRIMARY KEY AUTO_INCREMENT, nama VARCHAR(100), alamat TEXT); 
CREATE TABLE produk (id_produk INT PRIMARY KEY AUTO_INCREMENT, nama_produk VARCHAR(100), harga INT, stok INT); 
CREATE TABLE penjualan (id_penjualan INT PRIMARY KEY AUTO_INCREMENT, tanggal DATE, id_pelanggan INT, FOREIGN KEY (id_pelanggan) REFERENCES pelanggan(id_pelanggan)); 
CREATE TABLE detail_penjualan (id_detail INT PRIMARY KEY AUTO_INCREMENT, id_penjualan INT, id_produk INT, jumlah INT, subtotal INT, FOREIGN KEY (id_penjualan) REFERENCES penjualan(id_penjualan), FOREIGN KEY (id_produk) REFERENCES produk(id_produk)); 
```
