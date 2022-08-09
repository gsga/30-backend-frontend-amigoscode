DROP DATABASE IF EXISTS `employeemanager`;
CREATE DATABASE IF NOT EXISTS `employeemanager` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
DROP USER IF EXISTS `amigoscode`;
CREATE USER IF NOT EXISTS 'amigoscode' @'%' IDENTIFIED WITH mysql_native_password BY 'codeamigos';
GRANT USAGE ON *.* TO 'amigoscode' @'%';
GRANT ALL PRIVILEGES ON `employeemanager`.* TO 'amigoscode' @'%';
USE `employeemanager`;
DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `id` bigint NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_es_0900_ai_ci DEFAULT NULL,
  `employee_code` varchar(255) COLLATE utf8mb4_es_0900_ai_ci NOT NULL,
  `img_url` varchar(255) COLLATE utf8mb4_es_0900_ai_ci DEFAULT NULL,
  `job_title` varchar(255) COLLATE utf8mb4_es_0900_ai_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_es_0900_ai_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_es_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = MyISAM DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_es_0900_ai_ci;
INSERT INTO `employee` (
    `id`,
    `email`,
    `employee_code`,
    `img_url`,
    `job_title`,
    `name`,
    `phone`
  )
VALUES (
    1,
    'uno@gmail.com',
    'bf36bcb2-d0cf-4ce6-b57d-9143ebec4398',
    NULL,
    'UI/UX',
    'Uno',
    NULL
  ),
  (
    2,
    'dos@gmail.com',
    '33943d26-0dff-48ea-b5bd-fac64073b685',
    NULL,
    'UI/UX',
    'Dos',
    NULL
  ),
  (
    3,
    'tres@gmail.com',
    '52307d41-7329-4e70-bfe6-4620868c2ff6',
    NULL,
    'UI/UX',
    'Tres',
    NULL
  ),
  (
    4,
    'cuatro@gmail.com',
    '38ead69b-0194-432c-b96d-6bdd763ea949',
    NULL,
    'UI/UX',
    'Cuatro',
    NULL
  );