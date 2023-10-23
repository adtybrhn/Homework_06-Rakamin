Feature: TC001 - Login
  Login sebagai standard_user
  Berhasil login dan masuk beranda menu

  @TDD    @Positive
  Scenario Outline: Login Berhasil
    Given Halaman Login SwagLabs
    When Input <username> as username
    And Input <password> as password
    Then Klik button login
    And Berhasil masuk halaman menu inventory
    Then Keluar dari Browser

    Examples:
      | username | password |
      | standard_user | secret_sauce |

  @TDD    @Negative
  Scenario Outline: Login Gagal
    Given Halaman Login SwagLabs
    When Input <username> as username
    And Input <password> as password
    And Klik button login
    Then Muncul alert pada menu login
    And Keluar dari Browser

    Examples:
      | username | password |
      | standard_user | secret       |

