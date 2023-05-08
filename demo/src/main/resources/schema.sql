
DROP TABLE IF EXISTS users;

CREATE TABLE users (

  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  latitude DECIMAL(9, 6) DEFAULT NULL,
  longitude DECIMAL(9, 6) DEFAULT NULL
);

DROP TABLE IF EXISTS food;
CREATE TABLE food(
  id INT NOT NULL,
  FOOD_NAME VARCHAR(250) NOT NULL,
  FOOD_TYPE VARCHAR(250) NOT NULL,
  EXP DATE NOT NULL,
  WEIGHT INT NOT NULL,
  STATE VARCHAR(250) NOT NULL
);


