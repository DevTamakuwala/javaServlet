Step 1:- Download the tomcat server from here :- https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.100/bin/apache-tomcat-9.0.100.zip

![image](https://github.com/user-attachments/assets/396dc140-2ea9-468a-9642-13f2f96f0f35)

Step 2:- Extract the downloaded zip in a new folder

Step 3:- open intellij and create new "Maven Archetype" project select Archetype as "org.apache.maven.archetypes:maven-archetype-webapp" and click on create.
![image](https://github.com/user-attachments/assets/e80924bf-94dd-4918-ae8d-2b26bf9d0f76)

Step 4:- Go to "plugins" and install "Smart tomcat" plugin and click on apply.
![image](https://github.com/user-attachments/assets/760d663c-5dd7-47fb-8f08-6da1dc0bfd1c)

Step 5:- Go to settings and select "Tomcat server" from left selection window.
![image](https://github.com/user-attachments/assets/b1b9567f-a0d8-4177-84da-e075f6b19fb5)

Step 6:- Select add option and select the location where you have extracted the tomcat server file after selecting hit ok and hit apply and then ok again.
![image](https://github.com/user-attachments/assets/bb39c23e-8e8e-4ac3-b498-e702cc020a82)

Step 7:- Go to Run configuration
![image](https://github.com/user-attachments/assets/d2ac736c-cd5a-4f26-b6e2-6ff7ad232119)

Step 8:- Click on add new and select "Smart tomcat"
![image](https://github.com/user-attachments/assets/74d7b801-a21d-4247-8ab9-831045dabd7c)

Step 9:- Select tomcat server which we created for Tomcat server and select "Use classpath of module" as your project name (if not preselected) and then hit apply.
![image](https://github.com/user-attachments/assets/8978b73f-dc4d-4470-b229-332e512b3765)

Step 10:- Now Run the index.jsp file

Step 11:- You will get the URL in your run section. click on it to go to the live server.
![image](https://github.com/user-attachments/assets/ce9e49fb-f5da-47f1-b593-9095ea67b54e)
