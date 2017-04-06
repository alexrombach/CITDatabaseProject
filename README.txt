--------------------------------------------------------------------------------------|
README-README-README-README-README-README-README-README-README-README-README-README-  |
--------------------------------------------------------------------------------      |
-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦---¦¦¦¦¦¦¦¦¦¦¦¦¦¦-------|
-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦---¦¦¦¦¦¦¦¦¦¦¦¦¦¦-------|
-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦---¦¦¦¦¦¦¦¦¦¦¦¦¦¦-------|
-¦¦¦¦¦¦--¦¦¦¦¦¦-¦¦¦¦¦¦-------------¦¦¦¦¦¦-----¦¦¦¦¦¦----¦¦¦¦¦¦---¦¦¦¦¦¦--¦¦¦¦¦¦-------|
-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-----¦¦¦¦¦¦-----¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦---¦¦¦¦¦¦--¦¦¦¦¦¦-------|
-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-----¦¦¦¦¦¦-----¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦---¦¦¦¦¦¦--¦¦¦¦¦¦-------|
-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-----¦¦¦¦¦¦-----¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦---¦¦¦¦¦¦--¦¦¦¦¦¦-------|
-¦¦¦¦¦¦--¦¦¦¦¦¦---------¦¦¦¦¦¦-----¦¦¦¦¦¦-----¦¦¦¦¦¦--¦¦¦¦¦¦-----¦¦¦¦¦¦--¦¦¦¦¦¦-------|
-¦¦¦¦¦¦--¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-----¦¦¦¦¦¦-----¦¦¦¦¦¦--¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-------|
-¦¦¦¦¦¦--¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-----¦¦¦¦¦¦-----¦¦¦¦¦¦--¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-------|
-¦¦¦¦¦¦--¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-----¦¦¦¦¦¦-----¦¦¦¦¦¦--¦¦¦¦¦¦¦¦¦¦-¦¦¦¦¦¦¦¦¦¦¦¦¦¦-------|
--------------------------------------------------------------------------------      |
README-README-README-README-README-README-README-README-README-README-README-README-  |
										      |
@authors: Steven Nguyen, Nick Woodle, Alex Rombach	                              |
                                                                                      |
https://github.com/alexrombach/CITDatabaseProject                                     |
(The entire project and all its commits)                                              |
			  							      |
--------------------------------------------------------------------------------------|

1) How to run the code
	-Setup the local database
		-Must install latest mysql workbench and all of its components
		-If you wish to run our jar file:
			- Must create an instance inside of mysql workbench with the username: root, password: Password123
			- Must create a local database inside of MySqlWorkbench named:  cit345groupproject
		-If you wish to compile our code: 
			- Must import sql file located in 'OtherProjectFiles' into database: cit345groupproject
			- Must edit our file: sqlconnection.java inside of the src file to include your own username and passoword for the your local database
		- Must import sql file located in 'OtherProjectFiles' into database: cit345groupproject	
	- Run our program
		-If you decieded to create a new loacl instance in mysql workbench with our specified username/password - you can just run the jar file located in this same directory!
		-If you decieded to compile our code youll need to do a bit more.
			- Install the latest version of Eclipse (we're using neon)
			- Inport our project named 'CITDatabaseProject'
			- Verify that both  rs2xml.jar and mysql-connector-java-5.1.41-bin.jar are iside of the projectsreferenced libraries 
			- help -> install new software: 
				-Install all general purpose tools for swing, swt, and window builder
			- Run the project.  
				

2) System requirements
	- Must have a macheine running windows 10 
	- Must have the latest JAVA jdk/jre installed 
	- Must have a macheine capible of runnig java applications

3) Where did you test your project
	-Our computers are all runnning Windows 10
4) What files are attached/required
	-Readme.txt 
	-mySQL Database insertion code sql file
		-cit345groupproject.sql (located in /OtherProjectFiles folder)
		-This sql file is capible of generating our entire database and all of its data.  
	-CSV files for every table
		-These files (located in /OtherProjectFiles folder) show all of our data in csv format per table. 
	-If you are compiling the code:
		-Reference rs2xml.jar and mysql-connector-java-5.1.41-bin.jar iside of the projects referenced libraries 
		-eclispse project file 'CITDatabaseProject'
	-If you are runnig our .java file 
		-Filename.java


