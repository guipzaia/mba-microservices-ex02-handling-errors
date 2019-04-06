
# Exercício 1 microserviços


## Inicializar projeto

```sh
mvn sprint-boot:run
```

## Pedidos

#### Listar

```sh
curl -X GET \
  http://localhost:8080/orders \
  -H 'content-type: application/json'
```

#### Inserir

```sh
curl -X POST \
  http://localhost:8080/orders \
  -H 'content-type: application/json' \
  -d '{
    "email": "adrianolaselva@gmail.com",
    "fullName": "Adriano M. La Selva",
    "shippingAddress": "Rua fernão dias, 1011",
    "quantity": 2,
    "price": 20.00,
    "paymentMethod": "CREDIT_CARD",
    "status": "PAYMENT_WAITING",
    "date": "11/05/2018",
    "payment": {
        "brand": "MASTERCARD",
        "transactionType": "CREDIT",
        "cardNumber": "5277 2155 0199 7257",
        "expDate": "03/20",
        "cvv": 493,
        "price": 20.00,
        "uuidAcquirerTransaction": null
    },
    "items": [{
    	"description": "Mouse se fio microsoft",
    	"price": 10.00
    },{
    	"description": "fone se fio microsoft",
    	"price": 10.00
    }]
}'
```

#### Carregar

```sh
curl -X GET \
  http://localhost:8080/orders/6fd6a1d7-277a-a149-b7bc-e9e6ecdf02f9 \
  -H 'content-type: application/json'
```

#### Alterar

```sh
curl -X PUT \
  http://localhost:8080/orders/6fd6a1d7-277a-a149-b7bc-e9e6ecdf02f9 \
  -H 'content-type: application/json' \
  -d '{
    "email": "adrianolaselva@gmail.com",
    "fullName": "Adriano M. La Selva",
    "shippingAddress": "Rua fernão dias, 1011",
    "quantity": 2,
    "price": 20.00,
    "paymentMethod": "CREDIT_CARD",
    "status": "PAYMENT_CONFIRMED",
    "date": "11/05/2018",
    "payment": {
        "brand": "MASTERCARD",
        "transactionType": "CREDIT",
        "cardNumber": "5277 2155 0199 7257",
        "expDate": "03/20",
        "cvv": 493,
        "price": 20.00,
        "uuidAcquirerTransaction": 4dfb9044-ceb1-74e0-7861-a5320674b729
    },
    "items": [{
    	"description": "Mouse se fio microsoft",
    	"price": 10.00
    },{
    	"description": "fone se fio microsoft",
    	"price": 10.00
    }]
}'
```

#### Remover

```sh
curl -X DELETE \
  http://localhost:8080/orders/6fd6a1d7-277a-a149-b7bc-e9e6ecdf02f9
```

