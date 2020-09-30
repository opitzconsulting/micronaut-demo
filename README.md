**Micronaut Microframework Demo**
This small demo shows off several features of the Micronaut framework. 
Details can be found in the blog entry...

**Starting the application using docker-compose**
The application has been provided in a dockerized manner. 
So, to get everything up and running simple change to the docker directory using `cd docker`
and call `docker-compose up`
You can now access the simple frontend at http://localhost:7080
The backend is served on http://localhost:7000 The database is available at 
localhost:5432 with da default user name and password postgres/kineKine41!
If you start the docker-compose file using docker-compose up -d you can stop the Backend 
using docker-compose stop backend.
