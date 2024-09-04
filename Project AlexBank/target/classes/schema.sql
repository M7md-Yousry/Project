CREATE TABLE Content(
    id INTEGER AUTO_INCREMENT,
    fullname VARCHAR(255) NOT NULL,
    address TEXT NOT NULL,
    maritalstatus VARCHAR(20) NOT NULL,
    department VARCHAR(20),
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    githuburl VARCHAR(255),
    primary key (id)
);

INSERT INTO Content(fullname, address, maritalstatus, department, date_created, githuburl)
VALUES ('Mohammed Yousry', 'Ghamra','SINGLE', 'IT',CURRENT_TIMESTAMP(), 'https://github.com/M7md-Yousry');

INSERT INTO Content(fullname, address, maritalstatus, department, date_created, githuburl)
VALUES ('John Doe', '123 Maple Street', 'MARRIED', 'IT', CURRENT_TIMESTAMP(), 'https://github.com/johndoe');

INSERT INTO Content(fullname, address, maritalstatus, department, date_created, githuburl)
VALUES ('Jane Smith', '456 Oak Avenue', 'SINGLE', 'FINANCE', CURRENT_TIMESTAMP(), 'https://github.com/janesmith');

INSERT INTO Content(fullname, address, maritalstatus, department, date_created, githuburl)
VALUES ('Alice Johnson', '789 Pine Road', 'DIVORCED', 'IT', CURRENT_TIMESTAMP(), 'https://github.com/alicejohnson');

INSERT INTO Content(fullname, address, maritalstatus, department, date_created, githuburl)
VALUES ('Bob Brown', '101 Elm Street', 'WIDOW', 'INFOSEC', CURRENT_TIMESTAMP(), 'https://github.com/bobbrown');

INSERT INTO Content(fullname, address, maritalstatus, department, date_created, githuburl)
VALUES ('Emily Davis', '202 Cedar Lane', 'SINGLE', 'BRANCHES', CURRENT_TIMESTAMP(), 'https://github.com/emilydavis');

INSERT INTO Content(fullname, address, maritalstatus, department, date_created, githuburl)
VALUES ('Michael Wilson', '303 Birch Boulevard', 'MARRIED', 'INFOSEC', CURRENT_TIMESTAMP(), 'https://github.com/michaelwilson');

INSERT INTO Content(fullname, address, maritalstatus, department, date_created, githuburl)
VALUES ('Sophia Taylor', '404 Spruce Way', 'SINGLE', 'INFOSEC', CURRENT_TIMESTAMP(), 'https://github.com/sophiataylor');

INSERT INTO Content(fullname, address, maritalstatus, department, date_created, githuburl)
VALUES ('Liam Martin', '505 Fir Court', 'MARRIED', 'FINANCE', CURRENT_TIMESTAMP(), 'https://github.com/liammartin');

INSERT INTO Content(fullname, address, maritalstatus, department, date_created, githuburl)
VALUES ('Olivia Thompson', '606 Poplar Street', 'DIVORCED', 'BRANCHES', CURRENT_TIMESTAMP(), 'https://github.com/oliviathompson');

INSERT INTO Content(fullname, address, maritalstatus, department, date_created, githuburl)
VALUES ('Noah White', '707 Cedar Avenue', 'SINGLE', 'FINANCE', CURRENT_TIMESTAMP(), 'https://github.com/noahwhite');