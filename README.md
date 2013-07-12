amos-project-audi
=================

#Install Notes for Running the Project in Test Environment:
=================

### change into the directory where the folder for THIS project will be created
cd your-desired-folder  [ENTER]

### Clone the project into your hard drive
git clone https://github.com/alexander-informatik/amos-project-audi.git [ENTER]

### change into the newly created folder and directly into the subdirectory Root
cd amos-project-audi/Root  [ENTER]

### start the spring-roo tool which was shipped with the git clone command
../swtools/springroo  [ENTER]

### type into the roo shell this command to setup a database which runs only in memory and looses all data once it is shutdown:
jpa setup --provider HIBERNATE --database H2_IN_MEMORY [ENTER]

### quit spring-roo
exit [ENTER]

### test if it is working with maven
mvn tomcat:run [ENTER]

### start a web browser and enter
http://localhost/proj1




#Install Notes for an application server:
=================

### change into the directory where the folder for THIS project will be created
cd your-desired-folder  [ENTER]

### Clone the project into your hard drive
git clone https://github.com/alexander-informatik/amos-project-audi.git [ENTER]

### change in the newly created folder and directly into the subdirectory Root
cd amos-project-audi/Root  [ENTER]

### start the spring-roo tool which was shipped with the git clone command
../swtools/springroo  [ENTER]

### type into the roo shell this command to setup your database AND press SPACE and than TAB, not ENTER
jpa setup --provider HIBERNATE --database [SPACE] [TAB]

### you get following output:
### DATABASE_DOT_COM        DB2_400                 DB2_EXPRESS_C           
### DERBY_CLIENT            DERBY_EMBEDDED          FIREBIRD                
### GOOGLE_APP_ENGINE       H2_IN_MEMORY            HYPERSONIC_IN_MEMORY    
### HYPERSONIC_PERSISTENT   MSSQL                   MYSQL                   
### ORACLE                  POSTGRES                SYBASE 

### type the database type you want to use
### e.g. to setup a database which runs only in memory and looses all data once it is shutdown:

### and press ENTER now!
jpa setup --provider HIBERNATE --database MYSQL [ENTER]

### quit spring-roo
exit [ENTER]

### open the configuration file and enter your database connection url and your database credentials
vim src/main/resources/META-INF/spring/database.properties [ENTER]

### compile the project into a WAR file
mvn package [ENTER]

### copy the WAR file to your Application Server
### e.g. for Tomcat in Ubuntu
cp target/*.war /var/lib/tomcat7/webapps/ [ENTER]

### start a web browser and go to
http://url-for-your-application-server/proj1

