CREATE TABLE contact (
    id SERIAL PRIMARY KEY,
    firstName VARCHAR(100),
    lastName VARCHAR(200),
    gender VARCHAR(10),
    pseudo VARCHAR(200),
    email VARCHAR(250),
    birthDate DATE,
    address VARCHAR(250),
    personalPhoneNumber VARCHAR(50),
    professionalPhoneNumber VARCHAR(50),
    linkedinLink VARCHAR(250),
    gitLink VARCHAR(250)
);
INSERT INTO contact (firstName, lastName, gender, pseudo, email, birthDate, address, personalPhoneNumber, professionalPhoneNumber, linkedinLink, gitLink) VALUES
('Valentin', 'Vesperia', 'Male','Val', 'gust@example.com', '2000-01-01', '4 Allée Rue Bidon', '0687546895', '0554879865', 'www.linkedin.com' , 'www.gitlink.com');
