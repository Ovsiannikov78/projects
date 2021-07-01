DROP TABLE IF EXISTS `task`;

CREATE TABLE IF NOT EXISTS `task`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR (150),
    `description` VARCHAR (1000),
    `due_date` VARCHAR (255),
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
