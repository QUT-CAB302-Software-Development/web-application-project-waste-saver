INSERT INTO 
	users (first_name, last_name, password, email, latitude, longitude)
VALUES
    ('John', 'Some', '123', 'Jsom213@gmail.com', -27.478500, 153.028400, 'tle355', 521)
    ('Will', 'Do', '123', 'DoW1000@gmail.com', -27.478300, 153.029000, 'WillD', 978)
    ('Will', 'Howard', '333', 'will222@gmail.com', -27.478800, 153.027900, 'WillH', 545)
    ('Isabella', 'Wilson', '123', 'isabella.wilson@gmail.com', -20.269700, 148.717400, 'IzzyW', 702)
    ('Ethan', 'Lee', '456', 'ethan.lee@yahoo.com', -22.340500, 150.467800, 'EthanL', 349)
    ('Mia', 'Jones', '789', 'mia.jones@hotmail.com', -27.998100, 153.406800, 'MiaJ', 816)
    ('Noah', 'Smith', '234', 'noah.smith@gmail.com', -25.282200, 152.868200, 'NoahS', 413)
    ('Sophia', 'Garcia', '567', 'sophiagarcia@yahoo.com', -16.918600, 145.778100, 'SophiaG', 220)
    ('Aiden', 'Miller', '890', 'aiden.miller@gmail.com', -23.863900, 151.246900, 'AidenM', 67)
    ('Olivia', 'Harris', '123', 'olivia.harris@hotmail.com', -20.852500, 148.702000, 'OliviaH', 834)
    ('Jackson', 'Martin', '456', 'jackson.martin@gmail.com', -23.545000, 148.165000, 'JacksonM', 251)
    ('Ava', 'Brown', '789', 'ava.brown@yahoo.com', -27.594900, 152.796000, 'ava.ilable', 998)
    ('William', 'Davis', '234', 'william.davis@hotmail.com', -26.594200, 151.839300, 'WilliamD', 325)
    ('Emma', 'Wilson', '567', 'emma.wilson@gmail.com', -25.477800, 152.997700, 'EmmaW', 422)
    ('Lucas', 'Taylor', '890', 'lucas.taylor@yahoo.com', -20.748400, 139.490000, 'LucasT', 589)
    ('Sophie', 'Johnson', '123', 'sophie.johnson@gmail.com', -21.152900, 149.152600, 'SophieJ', 976)
    ('Benjamin', 'Anderson', '456', 'benjamin.anderson@hotmail.com', -27.551988, 152.914515, 'BenjA', 713)


INSERT INTO
    reviews (authorID, to_userID, rating, message)
VALUES
    (5, 10, 3, 'Great effort in donating food to the community!')
    (17, 14, 5, 'Absolutely outstanding! Your food donations are making a huge impact.')
    (6, 8, 4, 'Appreciate your consistent support in donating food. Keep up the good work!')
    (3, 12, 2, 'Some improvement needed in the quality of donated food.')
    (11, 4, 1, 'Disappointed with the minimal effort in food donation.')
    (15, 2, 3, 'Satisfactory food donations. Thank you for your contribution.')
    (1, 7, 5, 'Exceptional generosity in donating food. You are making a difference!')
    (9, 16, 4, 'Impressed with the variety and quantity of food donated.')
    (13, 9, 2, 'Expecting better quality food donations in the future.')
    (8, 5, 3, 'Good job in donating food. Your contribution is appreciated.')
    (16, 11, 5, 'Incredible support! Your food donations are truly making an impact.')
    (4, 3, 1, 'Unsatisfied with the limited amount of food donated.')
    (7, 13, 4, 'Thank you for your consistent efforts in donating food. It means a lot.')
    (14, 1, 2, 'Hoping for improved quality in future food donations.')
    (2, 6, 3, 'Fairly good food donations. Keep up the effort!')
    (10, 15, 5, 'Phenomenal commitment in donating food. You are an inspiration!')
    (12, 17, 4, 'Impressed with the thoughtfulness in your food donations.')
    (9, 11, 2, 'Expecting more variety in the donated food.')
    (1, 16, 1, 'Disappointed with the lack of effort in food donation.')
    (14, 8, 3, 'Your food donations have been satisfactory. Thank you!')
    (7, 3, 5, 'Absolutely exceptional! Your food donations are transforming lives.')
    (4, 13, 4, 'Thank you for your continuous support in donating food.')
    (5, 2, 2, 'Hoping for better quality in future food donations.')
    (15, 6, 3, 'Your food donations have been decent. Keep up the effort!')
    (12, 10, 5, 'Your generosity in donating food is commendable. Great job!')
    (17, 4, 1, 'Unsatisfied with the minimal amount of food donated.')
    (16, 7, 4, 'Appreciate your consistent support in donating food. Thank you!')
    (3, 9, 2, 'Expecting better quality food donations in the future.')
    (13, 5, 3, 'Satisfactory food donations. Your contribution is appreciated.')
    (8, 15, 5, 'Remarkable commitment in donating food. You are making a difference!')
    (11, 1, 1, 'Disappointed with the lack of effort in food donation.')

INSERT INTO
    food (food_name, food_type, expiry, weight, state)
VALUES
    ('Chicken Curry', 'Animal Product', '20230530', 500, 'Unused')
    ('Vegetable Stir-Fry', 'Vegetable', '20230610', 700, 'Unused')
    ('Cheese Pizza', 'Dairy', '20230525', 800, 'Used')
    ('Spaghetti Bolognese', 'Carb', '20230605', 600, 'Unused')
    ('Beef Tacos', 'Animal Product', '20230528', 400, 'Unused')
    ('Greek Salad', 'Vegetable', '20230531', 300, 'Unused')
    ('Fish and Chips', 'Animal Product', '20230529', 750, 'Unused')
    ('Macaroni and Cheese', 'Dairy', '20230602', 550, 'Unused')
    ('Veggie Burger', 'Vegetable', '20230601', 400, 'Unused')
    ('Ice Cream Sundae', 'Dairy', '20230607', 200, 'Unused')
    ('Pasta Primavera', 'Carb', '20230526', 450, 'Used')
    ('Egg Fried Rice', 'Animal Product', '20230604', 650, 'Unused')
    ('Caesar Salad', 'Vegetable', '20230527', 300, 'Unused')
    ('Creamy Mushroom Soup', 'Dairy', '20230603', 350, 'Unused')
    ('Hawaiian Pizza', 'Carb', '20230524', 900, 'Unused')
    ('Fruit Salad', 'Miscellaneous', '20230609', 350, 'Unused')
    ('Pork Chops', 'Animal Product', '20230523', 600, 'Expired')
    ('Grilled Asparagus', 'Vegetable', '20230522', 200, 'Used')
    ('Mango Lassi', 'Dairy', '20230530', 400, 'Unused')
    ('Garlic Bread', 'Carb', '20230606', 250, 'Unused')
    ('Berry Smoothie', 'Miscellaneous', '20230528', 350, 'Unused')
    ('Steak with Mashed Potatoes', 'Animal Product', '20230525', 850, 'Unused')
    ('Caprese Salad', 'Vegetable', '20230607', 400, 'Unused')
    ('Chocolate Milkshake', 'Dairy', '20230526', 300, 'Used')
    ('Margherita Pizza', 'Carb', '20230602', 700, 'Unused')
    ('Grilled Chicken Breast', 'Animal Product', '20230715', 350, 'Unused')
    ('Roasted Vegetables', 'Vegetable', '20230720', 400, 'Unused')
    ('Yogurt Parfait', 'Dairy', '20230710', 200, 'Unused')
    ('Pasta Carbonara', 'Carb', '20230725', 450, 'Unused')
    ('Beef Stew', 'Animal Product', '20230718', 600, 'Used')
    ('Mediterranean Salad', 'Vegetable', '20230712', 300, 'Unused')
    ('Cheese Omelette', 'Dairy', '20230722', 250, 'Unused')
    ('Baked Potatoes', 'Carb', '20230714', 400, 'Unused')
    ('Ratatouille', 'Vegetable', '20230724', 350, 'Unused')
    ('Ice Cream Cone', 'Dairy', '20230708', 150, 'Unused')
    ('Chicken Alfredo', 'Animal Product', '20230719', 500, 'Unused')
    ('Cauliflower Soup', 'Vegetable', '20230711', 300, 'Used')
    ('Cheeseburger', 'Animal Product', '20230716', 400, 'Unused')
    ('Fruit Tart', 'Miscellaneous', '20230726', 250, 'Unused')
    ('Beef Lasagna', 'Animal Product', '20230717', 550, 'Unused')
    ('Vegetable Curry', 'Vegetable', '20230723', 400, 'Expired')
    ('Vanilla Pudding', 'Dairy', '20230709', 200, 'Used')
    ('Mushroom Risotto', 'Carb', '20230713', 450, 'Unused')
    ('Greek Gyro', 'Animal Product', '20230721', 350, 'Unused')
    ('Spinach Salad', 'Vegetable', '20230727', 300, 'Unused')
    ('Milkshake', 'Dairy', '20230707', 250, 'Unused')
    ('Spaghetti Aglio e Olio', 'Carb', '20230728', 400, 'Unused')
    ('Vegetable Soup', 'Vegetable', '20230729', 350, 'Unused')
    ('Cheddar Cheese Sandwich', 'Dairy', '20230706', 300, 'Used')
    ('Pepperoni Pizza', 'Carb', '20230730', 500, 'Unused')
    ('Chicken', 'Animal Product', '20230525', 500, 'Unused')
    ('Broccoli', 'Vegetable', '20230527', 200, 'Unused')
    ('Milk', 'Dairy', '20230523', 1000, 'Used')
    ('Rice', 'Carb', '20230601', 500, 'Unused')
    ('Apple', 'Miscellaneous', '20230530', 150, 'Unused')
    ('Salmon', 'Animal Product', '20230526', 300, 'Expired')
    ('Lettuce', 'Vegetable', '20230524', 250, 'Unused')
    ('Yogurt', 'Dairy', '20230528', 200, 'Unused')
    ('Bread', 'Carb', '20230602', 400, 'Unused')
    ('Banana', 'Miscellaneous', '20230531', 120, 'Unused')
    ('Beef', 'Animal Product', '20230526', 450, 'Unused')
    ('Spinach', 'Vegetable', '20230528', 150, 'Unused')
    ('Cheese', 'Dairy', '20230525', 300, 'Used')
    ('Pasta', 'Carb', '20230603', 350, 'Unused')
    ('Orange', 'Miscellaneous', '20230529', 180, 'Unused')
    ('Pork', 'Animal Product', '20230526', 550, 'Unused')
    ('Cauliflower', 'Vegetable', '20230526', 220, 'Expired')
    ('Butter', 'Dairy', '20230523', 250, 'Unused')
    ('Potato', 'Carb', '20230604', 200, 'Unused')
    ('Pear', 'Miscellaneous', '20230531', 140, 'Unused')
    ('Eggs', 'Animal Product', '20230525', 400, 'Used')
    ('Tomato', 'Vegetable', '20230527', 180, 'Unused')
    ('Ice Cream', 'Dairy', '20230523', 500, 'Unused')
    ('Breadsticks', 'Carb', '20230605', 300, 'Unused')
    ('Kiwi', 'Miscellaneous', '20230530', 90, 'Unused')
    ('Steak', 'Animal Product', '20230610', 600, 'Unused')
    ('Cabbage', 'Vegetable', '20230612', 300, 'Unused')
    ('Yogurt', 'Dairy', '20230608', 500, 'Used')
    ('Pasta', 'Carb', '20230615', 400, 'Unused')
    ('Grapes', 'Miscellaneous', '20230614', 250, 'Unused')
    ('Chicken', 'Animal Product', '20230611', 550, 'Expired')
    ('Cauliflower', 'Vegetable', '20230609', 400, 'Unused')
    ('Milk', 'Dairy', '20230608', 1000, 'Unused')
    ('Rice', 'Carb', '20230616', 600, 'Unused')
    ('Avocado', 'Miscellaneous', '20230613', 200, 'Unused')
    ('Salmon', 'Animal Product', '20230611', 350, 'Unused')
    ('Broccoli', 'Vegetable', '20230613', 300, 'Unused')
    ('Cheese', 'Dairy', '20230610', 400, 'Used')
    ('Bread', 'Carb', '20230617', 450, 'Unused')
    ('Watermelon', 'Miscellaneous', '20230614', 800, 'Unused')
    ('Pork', 'Animal Product', '20230611', 700, 'Unused')
    ('Lettuce', 'Vegetable', '20230611', 200, 'Expired')
    ('Butter', 'Dairy', '20230608', 200, 'Unused')
    ('Potato', 'Carb', '20230618', 300, 'Unused')
    ('Strawberries', 'Miscellaneous', '20230615', 150, 'Unused')
    ('Eggs', 'Animal Product', '20230609', 450, 'Used')
    ('Carrots', 'Vegetable', '20230612', 250, 'Unused')
    ('Ice Cream', 'Dairy', '20230608', 700, 'Unused')
    ('Breadsticks', 'Carb', '20230619', 350, 'Unused')
    ('Pineapple', 'Miscellaneous', '20230614', 400, 'Unused')

