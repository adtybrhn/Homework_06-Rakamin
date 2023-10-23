Feature: TC003 - Tambah ke Keranjang
  Login sebagai user
  User ingin menambahkan produk ke dalam keranjang

@TDD    @Positive
Scenario Outline: Berhasil menambahkan produk ke dalam keranjang
  Given Halaman Login SwagLabs
  When Input <username> as username
  And Input <password> as password
  And Klik button login
  Then Berhasil masuk halaman menu inventory
  And Pilih <produk> as produk
  When Tampilan detail produk
  And Klik add to cart
  Then Cek item dalam keranjang
  And Keluar dari Browser


  Examples:
    |username       |password     | produk             |
    |standard_user  |secret_sauce | Sauce Labs Backpack|