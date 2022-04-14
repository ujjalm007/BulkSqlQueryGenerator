DROP TABLE IF EXISTS Attachment;  
CREATE TABLE Attachment (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
actual_file_name VARCHAR(1024) NOT NULL, 
random_file_name VARCHAR(1024) NOT NULL,  
file_type VARCHAR(32) NOT NULL  
); 
