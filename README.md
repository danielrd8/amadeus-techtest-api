# amadeus-techtest-api
 Amadeus technical test backend api

- Run scripts on a PostgreSQL database in the following order.
  
  /amadeus-techtest-api/bd-scripts

    1. create_inventory_db.sql
    2. create_product_table.sql
    3. create_product_seq.sql
    4. insert_product_data.sql
 
- Run the Spring Boot project.

- Swagger URL: http://localhost:8092/swagger-ui/index.html

  ![image](https://github.com/danielrd8/amadeus-techtest-api/assets/53479385/9cc9a5b1-3759-428a-a102-6cb01d9b939e)

- The CRUD Product Rest API test class is on the following path:
  
  /amadeus-techtest-api/src/test/java/com/amadeus/techtest/controller/ProductControllerTests.java

  
