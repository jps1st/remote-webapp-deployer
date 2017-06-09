# remote-webapp-deployer
Client and server pair for deploying war files into tomcat's webapps folder.

Allow incoming connections from 6880 port:

	iptables -A INPUT -p tcp --dport 6880 -j ACCEPT

Server 

	java -jar deployer.jar server <appname>
	Ex.
	java -jar deployer.jar server ROOT

Remote Client

	java -jar SmilesDeployer.jar client <server-address> <path-to-war-file> 
	Ex.
	java -jar SmilesDeployer.jar client smiles88.com /home/usr/path/to/application.war
