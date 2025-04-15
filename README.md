# Sistem Ulasan pada E-Commerce - Implementasi dengan Konsep OOP pada Java

## Tujuan Laporan

Laporan ini bertujuan untuk mendokumentasikan dan menjelaskan struktur serta fungsionalitas dari **Sistem Ulasan Produk** dalam platform e-commerce yang dibangun menggunakan konsep **Object-Oriented Programming (OOP)** pada bahasa pemrograman **Java**. Dalam laporan ini, kami akan mengidentifikasi kelas-kelas utama, atribut, metode, serta hubungan antar kelas yang ada dalam sistem ulasan.

## Struktur Sistem Ulasan Produk

Sistem ulasan produk terdiri dari beberapa kelas yang saling berinteraksi untuk memberikan fungsionalitas yang lengkap pada platform e-commerce. Berikut adalah struktur dan deskripsi setiap kelas dalam sistem ini:

### 1. **Pengguna (User)**
   - **Atribut**: Nama, email, password, nomorTelepon
   - **Metode**:
     - `setNama()`, `setEmail()`, `setPassword()`, `setNomorTelepon()`
   - **Deskripsi**: Kelas ini bertindak sebagai dasar untuk pengguna yang dapat mengelola informasi profil mereka. Pengguna bisa menjadi **Moderator**, **Penjual**, atau **Pelanggan** yang memiliki peran masing-masing dalam sistem.

### 2. **Pelanggan (Customer)**
   - **Atribut**: Daftar Ulasan
   - **Metode**:
     - `tulisUlasan()`, `editUlasan()`, `laporkanUlasan()`
   - **Deskripsi**: Pelanggan dapat memberikan ulasan produk, mengedit ulasan mereka, atau melaporkan ulasan yang dianggap tidak valid.

### 3. **Penjual (Seller)**
   - **Atribut**: Daftar Produk, Daftar Ulasan
   - **Metode**:
     - `balasUlasan()`
   - **Deskripsi**: Penjual dapat menanggapi ulasan yang diberikan oleh pelanggan, baik itu berupa kritik maupun pujian terhadap produk yang dijual.

### 4. **Moderator**
   - **Atribut**: Daftar Ulasan yang Dihapus
   - **Metode**:
     - `verifikasiUlasan()`, `hapusUlasan()`
   - **Deskripsi**: Moderator memiliki peran penting dalam memverifikasi keaslian ulasan yang masuk, memastikan bahwa ulasan tersebut tidak melanggar kebijakan platform.

### 5. **Produk (Product)**
   - **Atribut**: Nama Produk, Harga, Deskripsi
   - **Metode**:
     - `tambahProduk()`, `editProduk()`
   - **Deskripsi**: Produk adalah entitas utama dalam sistem ini yang memiliki ulasan. Setiap produk dapat memiliki beberapa ulasan yang terkait dengan kualitas produk dan pengalaman pelanggan.

### 6. **Ulasan (Review)**
   - **Atribut**: Rating, Komentar
   - **Metode**:
     - `validasiRating()`, `verifikasiUlasan()`
   - **Deskripsi**: Kelas ini menyimpan ulasan yang diberikan oleh pelanggan terhadap produk tertentu. Ulasan ini dapat dinilai oleh pelanggan berdasarkan rating dan komentar.

### 7. **UlasanToko (StoreReview)**
   - **Atribut**: Rating dari beberapa aspek (Pengemasan, Pelayanan, Pengiriman, dll)
   - **Metode**:
     - `tulisUlasanToko()`, `laporkanUlasanToko()`
   - **Deskripsi**: Ulasan ini memberikan penilaian secara keseluruhan terhadap toko yang menjual produk, meliputi berbagai aspek seperti pelayanan, pengemasan, dan pengiriman.

### 8. **BalasUlasan (ReplyReview)**
   - **Atribut**: Komentar Balasan
   - **Metode**:
     - `balasUlasan()`
   - **Deskripsi**: Kelas ini memungkinkan penjual untuk membalas ulasan yang diberikan oleh pelanggan, memberikan respons terhadap masukan yang diberikan.

## Fungsionalitas dan Relasi Antar Kelas

1. **Pelanggan** memberikan ulasan pada **Produk**. Ulasan ini kemudian disimpan dalam kelas **Ulasan** yang terkait dengan produk yang diberikan ulasan.
2. **Penjual** dapat memberikan balasan pada **Ulasan** yang diberikan oleh pelanggan, dengan menggunakan kelas **BalasUlasan**.
3. **Moderator** memverifikasi keaslian **Ulasan** dan menghapus ulasan yang tidak valid atau melanggar kebijakan platform.
4. **UlasanToko** memungkinkan pelanggan untuk memberikan penilaian terhadap toko, sementara **Penjual** dapat menanggapi ulasan ini.

## Peran Pengguna dalam Sistem

- **Pelanggan** memiliki peran utama dalam memberikan ulasan dan penilaian terhadap produk dan toko. Mereka juga dapat melaporkan ulasan yang tidak sesuai.
- **Penjual** dapat membalas ulasan yang diberikan oleh pelanggan dan memberikan klarifikasi atau respons terhadap kritik.
- **Moderator** bertanggung jawab untuk memverifikasi ulasan dan menjaga kualitas sistem ulasan dengan menghapus ulasan yang tidak valid.

## Validitas dan Keamanan Ulasan

Untuk menjaga validitas ulasan, sistem ini mengimplementasikan metode **validasiRating()** untuk memastikan bahwa rating yang diberikan oleh pelanggan sesuai dengan kriteria yang telah ditetapkan. Selain itu, **verifikasiUlasan()** memastikan bahwa ulasan yang diberikan tidak mengandung konten yang tidak sesuai atau palsu.

## Class Diagram
![Diagram Class TUBES DPBO jpeg](https://github.com/user-attachments/assets/3202b6d5-4107-4f50-9034-26bba3c2cfa5)

