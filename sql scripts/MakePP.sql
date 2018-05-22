DROP SCHEMA IF EXISTS `Personal_Project_Food`;
CREATE SCHEMA `Personal_Project_Food`;
USE `Personal_Project_Food`;


CREATE TABLE brand
(
    Brand_Id INT NOT NULL AUTO_INCREMENT,
    Brand_Name VARCHAR(120) NOT NULL,
    CONSTRAINT PK_Brand Primary Key (Brand_Id),
    CONSTRAINT uniqueBrandName UNIQUE (Brand_Name)
);

/* Nutrional values are in units of mg */

CREATE TABLE food
(
    Food_Id INT NOT NULL AUTO_INCREMENT,
    Food_Name VARCHAR(120) NOT NULL,
    Calories INT,
    Total_Fat INT,
    Cholesterol INT,
    Sodium INT,
    Total_Carbs INT,
    Protein INT,
    Vitamin_A INT,
    Vitamin_B INT,
    Vitamin_C INT,
    Vitamin_D INT,
    Calcium INT,
    Iron INT,
    CONSTRAINT PK_Food Primary Key (Food_Id),
    CONSTRAINT uniqueFoodName UNIQUE (Food_Name)
);

CREATE TABLE unhealthytohealthy
(
    Unhealthy_Food_Id INT NOT NULL,
    Healthy_Food_Id INT NOT NULL,
    Constraint PK_UnhealthyToHealthy Primary Key
    (
        Unhealthy_Food_Id,
        Healthy_Food_Id
    ),
    FOREIGN KEY (Unhealthy_Food_Id) REFERENCES food(Food_Id) ON DELETE CASCADE,
    FOREIGN KEY (Healthy_Food_Id) REFERENCES food(Food_Id) ON DELETE CASCADE
);
CREATE TABLE foodtobrand
(
    Food_Id INT NOT NULL,
    Brand_Id INT NOT NULL,
    Constraint PK_FoodToBrand Primary Key
    (
        Food_Id,
        Brand_Id
    ),
    FOREIGN KEY (Food_Id) REFERENCES food(Food_Id) ON DELETE CASCADE,
    FOREIGN KEY (Brand_Id) REFERENCES brand(Brand_Id) ON DELETE CASCADE
);

