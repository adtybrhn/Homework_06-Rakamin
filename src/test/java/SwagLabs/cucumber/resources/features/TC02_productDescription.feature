Feature: TC002 - Deskripsi Produk
  Login sebagai user
  User mengklik suatu produk
  Tampil halaman deskripsi produk

  @TDD    @Positive
  Scenario Outline: Menampilkan deskripsi atau detail produk
    Given Halaman Login SwagLabs
    When Input <username> as username
    And Input <password> as password
    And Klik button login
    Then Berhasil masuk halaman menu inventory
    And Pilih <produk> as produk
    Then Tampilan detail produk
    And Keluar dari Browser

    Examples:
      |username       |password     | produk             |
      |standard_user  |secret_sauce | Sauce Labs Backpack|