DROP USER personal_proj CASCADE;

CREATE USER personal_proj
IDENTIFIED BY password
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to personal_proj;
GRANT resource to personal_proj;
GRANT create session TO personal_proj;
GRANT create table TO personal_proj;
GRANT create view TO personal_proj;

CREATE TABLE Brand
(
    BrandId NUMBER NOT NULL,
    BrandName VARCHAR2(120) NOT NULL,
    CONSTRAINT PK_Brand Primary Key (BrandId)
);

/* Nutrional values are in units of mg */

CREATE TABLE FOOD
(
    FoodID NUMBER NOT NULL,
    FoodName VARCHAR(120) NOT NULL,
    Calories Number,
    TotalFat Number,
    Cholesterol Number,
    Sodium Number,
    TotalCarbs Number,
    Protein Number,
    VitaminA Number,
    VitaminB Number,
    VitaminC Number,
    VitaminD Number,
    Calcium Number,
    Iron Number,
    CONSTRAINT PK_Food Primary Key (FoodID)
);