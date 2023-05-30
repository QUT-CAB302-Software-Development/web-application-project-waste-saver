INSERT INTO 
	users (first_name, last_name, password, email, latitude, longitude)
VALUES
  	('John', 'Some', '123', 'Jsom213@gmail.com', -27.4785, 153.0284),
  	('Will', 'Do', '123', 'DoW1000@gmail.com', -27.4783, 153.0290),
  	('Will', 'Howard','333', 'will222@gmail.com', -27.4788, 153.0279);

INSERT INTO
    reviews (authorID, to_userID, rating, message)
VALUES
    (1, 2, 5, 'john to willdo 5 stars')
    (1, 3, 4, 'john to willward 4 stars')
    (2, 1, 3, 'willdo to john 3 stars')
    (2, 3, 2, 'willdo to willward 2 stars')
    (3, 1, 1, 'willward to john 1 stars')
    (3, 2, 5, 'willward to willdo 5 stars')