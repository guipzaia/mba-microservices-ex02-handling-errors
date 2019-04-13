
# Exercício 1: Microservices (Order Service)


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
    "email": "gui.p.zaia@gmail.com",
    "fullName": "Guilherme Palmeira Zaia",
    "shippingAddress": "Rua Dona Ana Neri, 581",
    "quantity": 1,
    "price": 50.00,
    "paymentMethod": "CREDIT",
    "status": "PAYMENT_CONFIRMED",
    "date": "20/03/2019",
    "payment": {
        "brand": "VISA",
        "transactionType": "CREDIT",
        "cardNumber": "3901 5361 0584 9477",
        "expDate": "12/23",
        "cvv": 536,
        "price": 50.00,
        "uuidAcquirerTransaction": null
    },
    "items": [{
    	"description": "Turbo Charger Motorola",
    	"price": 35.00
    },{
    	"description": "Earphone Beats",
    	"price": 15.00
    }]
}'
```

#### Carregar

```sh
curl -X GET \
  http://localhost:8080/orders/88ec268b-c178-8fcc-7165-c7ddd0eb25dc \
  -H 'content-type: application/json'
```

#### Alterar

```sh
curl -X PUT \
  http://localhost:8080/orders/88ec268b-c178-8fcc-7165-c7ddd0eb25dc \
  -H 'content-type: application/json' \
  -d '{
    "email": "gui.p.zaia@gmail.com",
    "fullName": "Guilherme Palmeira Zaia",
    "shippingAddress": "Rua Dona Ana Neri, 581",
    "quantity": 1,
    "price": 50.00,
    "paymentMethod": "CREDIT",
    "status": "CANCELED",
    "date": "20/03/2019",
    "payment": {
        "brand": "VISA",
        "transactionType": "CREDIT",
        "cardNumber": "3901 5361 0584 9477",
        "expDate": "12/23",
        "cvv": 536,
        "price": 50.00,
        "uuidAcquirerTransaction": null
    },
    "items": [{
    	"description": "Turbo Charger Motorola",
    	"price": 35.00
    },{
    	"description": "Earphone Beats",
    	"price": 15.00
    }]
}'
```

#### Remover

```sh
curl -X DELETE \
  http://localhost:8080/orders/88ec268b-c178-8fcc-7165-c7ddd0eb25dc
```

