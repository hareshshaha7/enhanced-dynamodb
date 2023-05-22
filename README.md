# enhanced-dynamodb
Building a Reactive CRUD application using Spring WebFlux and Enhanced DynamoDB Sdk with AWS DynamoDB in Java.


`/customer/save` endpoint takes customer object input and saves in DB.

`/customer/get/{customerId}` endpoint fetch a customer item from Db based on the supplied customerId.

`/customer/updateOrCreate` endpoint updates the customer with the supplied input if the customer is not present in the table it created a new one item.

`/customer/delete/{customerId}` endpoint deletes the customer item in db based on the supplied customerId.

`/customer/update` endpoint checks whether supplied customer is present in db if so then it is updated else it will throw error.

`/customer/query/{customerId}` our customer object has a nested Address object and this endpoint will fetch the address of the customer based on the customerId.

finally

`/customer/all` endpoint retrieves all the record present in the customerDb.