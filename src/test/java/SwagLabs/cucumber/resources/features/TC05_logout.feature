Feature: TC005 - Logout
User keluar dari halaman web aplikasi

  @TDD    @Positive
  Scenario Outline: Logout Berhasil
    Given Halaman Login SwagLabs
    When Input <username> as username
    And Input <password> as password
    And Klik button login
    Then Berhasil masuk halaman menu inventory
    And Klik menu logout
    Then Keluar dari Browser

    Examples:
      | username | password |
      | standard_user | secret_sauce |


