# EKart
Customer API's:

Search and list for products based on:


product name: 
curl --location -g --request GET 'http://localhost:8080/customer-api/productName/{product}'


Please add actual productname instead of {product} eg.Dell, Lenovo, Oneplus



product type
curl --location --request GET 'http://localhost:8080/customer-api/productType?type=Mobile'

eg.type=Mobile, Laptop, etc


product category
curl --location --request GET 'http://localhost:8080/customer-api/productCategories'


product price range (includingmix and max):
curl --location --request GET 'http://localhost:8080/customer-api/productInPriceRange?min=40000&max=115000'



Seller API's:


Add one or many products:

curl --location --request POST 'http://localhost:8080/seller-api/sellers/addProducts' \
--header 'Content-Type: application/json' \
--data-raw '{
  "productId": 123,
  "name": "name",
  "category": "category",
  "model": "model",
  "price": 123,
  "quantity": 1,
  "type": "type",
  "sellerEmail": "sellerEmail"
}'


can view product list added by them

curl --location --request GET 'http://localhost:8080/seller-api/ProductsBySeller?seller=rahul@gmail.com'


can update products (only added by them)


curl --location --request PUT 'http://localhost:8080/seller-api/products' \
--header 'Content-Type: application/json' \
--data-raw '{
  "productId": 1003,
  "name": "Apple",
  "category": "Electronics-Laptop",
  "model": "Macbook Pro",
  "price": 70000,
  "quantity": 6,
  "type": "Laptop",
  "sellerEmail": "rakesh@gmail.com"
}'


can delete products (only added by them)

curl --location --request DELETE 'http://localhost:8080/seller-api//sellers/removeProducts' \
--header 'Content-Type: application/json' \
--data-raw '{
  "productId": 1003,
  "name": "Apple",
  "category": "Electronics-Laptop",
  "model": "Macbook Pro",
  "price": 70000,
  "quantity": 6,
  "type": "Laptop",
  "sellerEmail": "rakesh@gmail.com"
}'


also has features and functionlities of a “Customer”

product name: 

curl --location -g --request GET 'http://localhost:8080/seller-api/productName/{product}'


Please add actual productname instead of {product} eg.Dell, Lenovo, Oneplus


product type

curl --location --request GET 'http://localhost:8080/seller-api/productType?type=Mobile'


eg.type=Mobile, Laptop, etc



product category

curl --location --request GET 'http://localhost:8080/seller-api/productCategories'



product price range (includingmix and max):

curl --location --request GET 'http://localhost:8080/seller-api/productInPriceRange?min=40000&max=115000'
