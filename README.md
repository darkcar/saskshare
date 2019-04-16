# saskshare

##1 Add dependencies 
	1. BeanUtils (commons-beanutils-1.9.3.jar)
	
	2. Commons-collections-3.2.2.jar
	
	3. Commons-logging-1.2.jar
	
	4. jstl-1.2.jar
	
	5. taglibs-standard-impl-1.2.5.jar
	
	6. mysql-connector-java-8.0.15.jar
	
	7. commons-codec-1.12.jar
	
	8. commons-fileupload-1.4.jar
	
	9. commons-io-2.6.jar
	
##2 Create packages
	ca.saskshare.dao
	
	ca.saskshare.dao.impl
	
	ca.saskshare.service
	
	ca.saskshare.service.impl
	
	ca.saskshare.web.controller
	
	ca.saskshare.web.UI
	
	ca.saskshare.utils
	
	junit.test
	
##3 Create db tables 

	```SQL
		Create table IF NOT EXISTS User(
		uuid VARCHAR(255) NOT NULL, 
		id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
		username VARCHAR(255), 
		realname VARCHAR(255),
		password VARCHAR(255) NOT NULL,
		lastAccess DATETIME, 
		registerDate DATETIME,
		isActive TINYINT);

		CREATE TABLE IF NOT EXISTS Role(
			uuid VARCHAR(255) NOT NULL,
			roleId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
			name VARCHAR(255) NOT NULL,
			description TEXT
		);

		CREATE TABLE IF NOT EXISTS UserRole(
			userId BIGINT NOT NULL,
			roleId BIGINT NOT NULL
		);

		CREATE TABLE IF NOT EXISTS Product (
			uuid VARCHAR(255) NOT NULL,
			productId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
			title VARCHAR(255) NOT NULL,
			abstract VARCHAR(255),
			description TEXT NOT NULL,
			fromDate DATETIME, 
			endDate DATETIME, 
			note VARCHAR(255), 
			ownerId BIGINT,
			urlTitle VARCHAR(255) NOT NULL
		);


		CREATE TABLE IF NOT EXISTS Gallery(
			uuid VARCHAR(255) NOT NULL,
			itemId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
			path VARCHAR(255),
			productId BIGINT NOT NULL
		);


		CREATE TABLE IF NOT EXISTS Schedule(
			uuid VARCHAR(255) NOT NULL,
			scheduleId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
			productId BIGINT NOT NULL,
			userId BIGINT NOT NULL,
			fromDate DATETIME NOT NULL,
			endDate DATETIME NOT NULL,
			note VARCHAR(255)
		);
		
		
		Create Table IF NOT EXISTS Contact(
			uuid VARCHAR(255) NOT NULL,
			id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
			productId BIGINT NOT NULL,
			email VARCHAR(255),
			phoneNumber VARCHAR(255),
			address VARCHAR(255) NOT NULL
		);
		
	```
	