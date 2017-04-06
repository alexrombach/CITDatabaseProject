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
        - For our program to run properly your computer must be able to run on Java 8. 
	- This means that if your machine is running on either windows 10, 8, 7 sp1, vista sp2
	- It must have more than 128 MB of RAM, more than 124 MB for JRE, and more than 2 MB for Java Update.
	- It also must have a processor minimum of a pentium 2 266 MHz processor. 
	- If your machine is running on Mac OS X, you must be running on OS X 10.8.3 or greater. 
	- If your machine is running on Linux, you must have Oracle Linux 5.5 or greater, and 8u25 or above.  
	-Another requirement is that your machine must be able to install and run MySql Workbench.  
	-This means that your CPU must be an Intel Core or Xeon 3GHz or equal AMD CPU. 
	-You must also have more than 4 GB of ram and a display resolution of 1920x1200 or greater.  
	-For Eclipse installation, you computer must have more than 1GB of RAM, more than 1GB of disk space, and a processor that is 1.5 Ghz or faster.  

3) Where did you test your project
	-MySql workbench 6.3 CE
	-MySql server 5.7
	-Java SE Dev Kit 8
	-Our computers are all runnning Windows 10
4) What files are attached/required
	-Readme.txt 
	-mySQL Database insertion code sql file
		-cit345groupproject.sql (located in /OtherProjectFiles folder)
		-This sql file is capible of generating our entire database and all of its data.  
	-CSV files for every table
		-These files (located in /OtherProjectFiles folder) shows all of our data in csv format per table. 
	-If you are compiling the code:
		-Reference rs2xml.jar and mysql-connector-java-5.1.41-bin.jar iside of the projects referenced libraries 
		-eclispse project file 'CITDatabaseProject'
	-If you are runnig our .jar file 
		-Filename.jar

   ___     ___    _____    ___     ___                                        _                                         __     _            
  /   \   / __|  |_   _|  | _ \   / _ \     o O O    _ _    ___    __ _    __| |     o O O  _ __     ___      o O O    / _|   (_)    _ _    
  | - |   \__ \    | |    |   /  | (_) |   o        | '_|  / -_)  / _` |  / _` |    o      | '  \   / -_)    o        |  _|   | |   | ' \   
  |_|_|   |___/   _|_|_   |_|_\   \___/   TS__[O]  _|_|_   \___|  \__,_|  \__,_|   TS__[O] |_|_|_|  \___|   TS__[O]  _|_|_   _|_|_  |_||_|  
_|"""""|_|"""""|_|"""""|_|"""""|_|"""""| {======|_|"""""|_|"""""|_|"""""|_|"""""| {======|_|"""""|_|"""""| {======|_|"""""|_|"""""|_|"""""| 
"`-0-0-'"`-0-0-'"`-0-0-'"`-0-0-'"`-0-0-'./o--000'"`-0-0-'"`-0-0-'"`-0-0-'"`-0-0-'./o--000'"`-0-0-'"`-0-0-'./o--000'"`-0-0-'"`-0-0-'"`-0-0-' 

