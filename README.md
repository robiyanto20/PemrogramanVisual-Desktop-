# PemrogramanVisual-Desktop-

# Proyek Pemrograman Visual Desktop CRUD menggunakan NetBeans

Proyek ini adalah implementasi dasar CRUD (Create, Read, Update, Delete) menggunakan NetBeans untuk aplikasi desktop dengan koneksi database.

## Prasyarat

Sebelum memulai proyek, pastikan Anda memiliki perangkat lunak berikut terpasang:

- [NetBeans IDE](https://netbeans.apache.org/)
- Database server (contoh: MySQL, PostgreSQL, dll.)
- JDBC Driver untuk database yang digunakan

## Konfigurasi Database

1. Buatlah sebuah database untuk proyek ini.
2. Impor skema tabel yang diperlukan ke dalam database. (File skema mungkin tersedia dalam direktori `database` atau sejenisnya).

## Konfigurasi Koneksi Database

1. Buka proyek NetBeans.
2. Buka file `src/config/DatabaseConfig.java`.
3. Sesuaikan informasi koneksi database seperti URL, nama pengguna, dan kata sandi.


```java
public class DatabaseConfig {
    public static final String URL = "jdbc:mysql://localhost:3306/nama_database";
    public static final String USERNAME = "nama_pengguna";
    public static final String PASSWORD = "kata_sandi";
}

|-- src
|   |-- config
|       |-- DatabaseConfig.java
|   |-- dao
|       |-- YourEntityDAO.java
|   |-- model
|       |-- YourEntity.java
|   |-- view
|       |-- MainForm.java
|   |-- Main.java
|-- database
|   |-- your_entity_schema.sql
|-- README.md
