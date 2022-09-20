
# Consultar tablas
SHOW TABLES;

# Descripción de una tabla
DESCRIBE country;

# Obtener cantidad de registros de la tabla
SELECT COUNT(*) quantity_country FROM country;

SELECT COUNT(*) cities FROM city; 

SELECT COUNT(*) languages FROM countrylanguage;

SELECT * FROM country;

SELECT * FROM country WHERE Code = "COL";

SELECT * FROM countryLanguage;


# INNER JOIN
SELECT co.`Code`, co.`Name` country, co.Continent, co.GovernmentForm, ci.Name city, cl.`Language` FROM country co 
INNER JOIN city ci  ON ci.CountryCode = co.`Code`
INNER JOIN countrylanguage cl ON cl.CountryCode = co.`Code`
WHERE co.`Code` = "COL" OR co.`Code` = "CAN" 
ORDER BY city ASC;


