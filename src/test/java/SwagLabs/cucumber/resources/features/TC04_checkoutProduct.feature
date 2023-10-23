Feature: TC004 - Checkout Produk
  Login sebagai user
  User menambahkan produk ke dalam keranjang
  User melakukan checkout pada barang yang sudah dipilih

  @TDD    @Positive
  Scenario Outline: Berhasil menambahkan produk ke dalam keranjang
    Given Halaman Login SwagLabs
    When Input <username> as username
    And Input <password> as password
    And Klik button login
    Then Berhasil masuk halaman menu inventory

    When Pilih <produk> as produk
    Then Tampilan detail produk
    And Klik add to cart
    Then Cek item dalam keranjang
    And Klik button checkout

    And Input <firstname> as firstname
    And Input <lastname> as lastname
    And Input <zip> as zip
    And Klik button continue
    Then Verifikasi Pesanan

    And Klik button finish
    And Keluar dari Browser


    Examples:
      |username       |password     | produk              |   firstname     | lastname    | zip     |
      |standard_user  |secret_sauce | Sauce Labs Backpack |   John          | Doe         | 999-999 |