# Backend paczkomatów *Input*

---
## Instalacja:
1. Baza danych:
    ```mariadb
    CREATE USER 'inputbackend'@'localhost' IDENTIFIED BY 'YourStrongPasswordHere';
    GRANT ALL PRIVILEGES ON `inputbackend`.* TO 'inputbackend'@'localhost';
    FLUSH PRIVILEGES;
    ```
2. Uruchomienie spring:
    ```shell
    git clone https://github.com/Wisniowa2024TC/InputBackend
    cd inputbackend
    ./gradlew bootRun
    ```