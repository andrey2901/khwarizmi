# khwarizmi
This is khwarizmi web application that provides the service for the checking of input formulas in files.
For deployment it was used a Glassfish4 web server and a MySql database as a storage of users and their passwords.
Usage:
1. Configure the realm authentication on Glassfish web server using the next configs from realm/config.txt:
	>Name:                          jdbc-realm
	>Class Name:                    com.sun.enterprise.security.auth.realm.jdbc.JDBCRealm
	>JAAS Context:                  jdbcRealm
	JNDI:                          jdbc/securityDatasource
	User Table:                    jdbcrealm.users
	User Name Column:              username
	Password Column:               password
	Group Table:                   jdbcrealm.groups
	Group Table User Name Column:  username
	Group Name Column:             groupname
	Password Encryption Algorithm: AES
	Charset:                       UTF-8
