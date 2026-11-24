# Jak wygenerować kod i sprawdzić, czy jest poprawny

---
## Generowanie kodu
Wyślij zapytanie POST na `/api/v1/parcel/requestCode`,
jako zawartość wskaż UUID skrytki w do której odnosi się kod.
```http request
POST http://localhost:6769/api/v1/parcel/requestCode
Content-Type: application/json

"uuid-skrytki"
```
Wynikiem jest kod wygenerowany:
```text
053496
```

## Sprawdzanie kodu
Wyślij zapytanie GET na `/api/v1/parcel/checkCode?code=KOD`,
zastępując `KOD` 6-cyfrowym kodem do sprawdzenia. 
Można dodać opcjonalny argument `parcelMachine`, 
by ograniczyć sprawdzanie kodu do konkretnego paczkomatu:
`/api/v1/parcel/checkCode?code=KOD&parcelMachine=uuid-paczkomatu`.
Wynikiem jest skrytka przypisana do kodu, np.:
```json
{
  "internalCode": "locker3",
  "machineID": "18203bba-0d03-4fe9-8f5c-0db92ff8f61d"
}
```