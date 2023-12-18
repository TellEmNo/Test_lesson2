# 7

CREATE SCHEMA `human_friends`;

# 9

DROP TABLE IF EXISTS horses;
CREATE TABLE horses (  
  id SERIAL PRIMARY KEY,
  animal_name VARCHAR(20),
  pet_commands VARCHAR(100),
  birth_date DATE
);
  
INSERT INTO horses
  (animal_name, pet_commands, birth_date)
VALUES
  ("Апполон", "имя, вперед, стой, рысь, шагом, тише", "2006-02-11"), ("Астон", "-", "2022-02-03"),
  ("Шелби", "имя, вперед, стой, шагом, тише", "2012-08-26"), ("Закат", "имя, вперед, стой, рысь, хоп, шагом, тише", "2004-05-29");
  
  SELECT * 
  FROM horses;
  
  
DROP TABLE IF EXISTS donkeys;
CREATE TABLE donkeys (  
  id SERIAL PRIMARY KEY,
  animal_name VARCHAR(20),
  pet_commands VARCHAR(100),
  birth_date DATE
);

INSERT INTO donkeys
  (animal_name, pet_commands, birth_date)
VALUES
  ("Вудди", "вперед, стой, тише", "2005-01-19"), ("Бонбон", "вперед, стой", "1998-02-09"),
  ("Буся", "имя, вперед, стой, шагом, тише", "1991-11-01"), ("Зимушка", "-", "2021-04-05");
  
SELECT * 
FROM donkeys;


DROP TABLE IF EXISTS camels;
CREATE TABLE camels (
  id SERIAL PRIMARY KEY,
  animal_name VARCHAR(20),
  pet_commands VARCHAR(100),
  birth_date DATE
);

INSERT INTO camels
  (animal_name, pet_commands, birth_date)
VALUES
  ("Денеб", "лежать, подъем, иди, стой", "2015-06-14"), ("Герд", "лежать, подъем, иди, стой, тише", "2010-02-14");

SELECT * 
FROM camels;


DROP TABLE IF EXISTS cats;
CREATE TABLE cats (
  id SERIAL PRIMARY KEY,
  animal_name VARCHAR(20),
  pet_commands VARCHAR(100),
  birth_date DATE
);

INSERT INTO cats
  (animal_name, pet_commands, birth_date)
VALUES
  ("Айс", "сидеть, дай лапу, ищи, кружись", "2019-03-12"), ("Юки", "дай лапу, кружись", "2021-06-26"),
  ("Неро", "лежать, кружись, дай лапу", "2021-11-20"), ("Санни", "сидеть, лежать, дай лапу", "2019-05-13");

SELECT * 
FROM cats;


DROP TABLE IF EXISTS dogs;
CREATE TABLE dogs (
  id SERIAL PRIMARY KEY,
  animal_name VARCHAR(20),
  pet_commands VARCHAR(100),
  birth_date DATE
);

INSERT INTO dogs
  (animal_name, pet_commands, birth_date)
VALUES
  ("Лулу", "рядом, дай лапу, фу, стоять", "2017-09-14"), ("Челси", "-", "2023-11-14"),
  ("Тоби", "дай лапу, фу", "2021-07-29"), ("Бадди", "дай лапу, рядом, лежать, апорт, фу", "2015-05-24");

SELECT * 
FROM dogs;


DROP TABLE IF EXISTS hamsters;
CREATE TABLE hamsters (
  id SERIAL PRIMARY KEY,
  animal_name VARCHAR(20),
  pet_commands VARCHAR(100),
  birth_date DATE
);

INSERT INTO hamsters
  (animal_name, pet_commands, birth_date)
VALUES
  ("Дасти", "стоять, прыгай, гулять, поворот", "2022-12-23"), ("Лило", "стоять, гулять, поворот", "2023-04-12");

SELECT * 
FROM hamsters;


# 10

DELETE FROM camels
WHERE id > 0;

SELECT * 
FROM camels;


# 11

DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals (
  id SERIAL PRIMARY KEY,
  animal_name VARCHAR(20),
  kind_of_animal VARCHAR(20),
  age_in_month INT
);

INSERT INTO young_animals (animal_name, kind_of_animal, age_in_month)
  SELECT
	animal_name,
    "horses",
    TIMESTAMPDIFF(MONTH, horses.birth_date, NOW())
  FROM
    horses
  WHERE
    horses.birth_date >= "2020-01-01"
UNION
    SELECT
	animal_name,
    "donkeys",
    TIMESTAMPDIFF(MONTH, donkeys.birth_date, NOW())
  FROM
    donkeys
  WHERE
    donkeys.birth_date >= "2020-01-01"
UNION
    SELECT
	animal_name,
    "cats",
    TIMESTAMPDIFF(MONTH, cats.birth_date, NOW())
  FROM
    cats
  WHERE
    cats.birth_date >= "2020-01-01"
UNION
    SELECT
	animal_name,
    "dogs",
    TIMESTAMPDIFF(MONTH, dogs.birth_date, NOW())
  FROM
    dogs
  WHERE
    dogs.birth_date >= "2020-01-01"
UNION
    SELECT
	animal_name,
    "hamsters",
    TIMESTAMPDIFF(MONTH, hamsters.birth_date, NOW())
  FROM
    hamsters
  WHERE
    hamsters.birth_date >= "2020-01-01"
  ;
  
  
  
SELECT * 
FROM young_animals;


# 12

ALTER TABLE camels ADD belonging VARCHAR(20) DEFAULT "camels";
ALTER TABLE cats ADD belonging VARCHAR(20) DEFAULT "cats";
ALTER TABLE dogs ADD belonging VARCHAR(20) DEFAULT "dogs";
ALTER TABLE donkeys ADD belonging VARCHAR(20) DEFAULT "donkeys";
ALTER TABLE hamsters ADD belonging VARCHAR(20) DEFAULT "hamsters";
ALTER TABLE horses ADD belonging VARCHAR(20) DEFAULT "horses";

SELECT animal_name, pet_commands, birth_date, belonging
  FROM camels
UNION
SELECT animal_name, pet_commands, birth_date, belonging
  FROM cats
UNION
SELECT animal_name, pet_commands, birth_date, belonging
  FROM dogs
UNION
SELECT animal_name, pet_commands, birth_date, belonging
  FROM donkeys
UNION  
SELECT animal_name, pet_commands, birth_date, belonging
  FROM hamsters
UNION
SELECT animal_name, pet_commands, birth_date, belonging
  FROM horses;

