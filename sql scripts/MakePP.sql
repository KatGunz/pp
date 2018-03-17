DROP SCHEMA IF EXISTS `Personal_Project_Food`;
CREATE SCHEMA `Personal_Project_Food`;
USE `Personal_Project_Food`;


CREATE TABLE Brand
(
    BrandId INT NOT NULL AUTO_INCREMENT,
    BrandName VARCHAR(120) NOT NULL,
    CONSTRAINT PK_Brand Primary Key (BrandId),
    CONSTRAINT uniqueBrandName UNIQUE (BrandName)
);

/* Nutrional values are in units of mg */

CREATE TABLE FOOD
(
    FoodID INT NOT NULL AUTO_INCREMENT,
    FoodName VARCHAR(120) NOT NULL,
    Calories INT,
    TotalFat INT,
    Cholesterol INT,
    Sodium INT,
    TotalCarbs INT,
    Protein INT,
    VitaminA INT,
    VitaminB INT,
    VitaminC INT,
    VitaminD INT,
    Calcium INT,
    Iron INT,
    CONSTRAINT PK_Food Primary Key (FoodID),
    CONSTRAINT uniqueFoodName UNIQUE (FoodName)
);

CREATE TABLE UnhealthyToHealthy
(
    UnhealthyFoodID INT NOT NULL,
    HealthyFoodID INT NOT NULL,
    Constraint PK_UnhealthyToHealthy Primary Key
    (
        UnhealthyFoodID,
        HealthyFoodID
    ),
    FOREIGN KEY (UnhealthyFoodID) REFERENCES Food(FoodID) ON DELETE CASCADE,
    FOREIGN KEY (HealthyFoodID) REFERENCES Food(FoodID) ON DELETE CASCADE
);
CREATE TABLE FoodToBrand
(
    FoodID INT NOT NULL,
    BrandID INT NOT NULL,
    Constraint PK_FoodToBrand Primary Key
    (
        FoodID,
        BrandID
    ),
    FOREIGN KEY (FoodID) REFERENCES Food(FoodID) ON DELETE CASCADE,
    FOREIGN KEY (BrandID) REFERENCES Brand(BrandID) ON DELETE CASCADE
);



