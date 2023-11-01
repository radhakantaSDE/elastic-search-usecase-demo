# elastic-search-usecase-demo
Elastic search functionality demo


### How to start the application:

1. Run ```docker-compose.yaml``` file to start ```elasticsearch``` locally (Make sure docker installed in system)
2. Create an index in ```elasticsearch``` with name ```products``` (```Elasticvue``` is GUI for elasticsearch)
3. Run the spring-boot application locally and play with bellow curls

```code 
CREATE : New Product

curl --location 'http://localhost:8080/api/v1/product' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Lenovo Yoga Laptop",
    "description": "Lenovi 8gb ram, 512gb HDD",
    "price": "30000",
    "category": "Laptop",
    "brand": "Lenovo"
}'
```

```code 
GET : Get all products

curl --location 'http://localhost:8080/api/v1/product/all'
```

```code 
SEARCH : Search products

curl --location 'http://localhost:8080/api/v1/product/search' \
--header 'Content-Type: application/json' \
--data '{
    "columnName": "description",
    "searchText": "8gb"
}'
```