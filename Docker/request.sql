-- -- 1. Récupération de toutes les informations de tous les contacts

-- SELECT * FROM contact;

-- -- 2. Récupération d’un contact par identifiant

-- SELECT * FROM contact WHERE contact.id = 1;

-- -- 3. Suppression d’un contact en fonction de son identifiant

-- DELETE FROM contact WHERE contact.id = 4;

-- -- 4. Suppression d’un contact en fonction de son nom et de son prénom

-- DELETE FROM contact WHERE contact.first_name = 'example' AND contact.last_name = 'example';

-- -- 5. Ajout d’un nouveau contact

-- INSERT INTO contact (first_name, last_name, gender) VALUES ('meh', 'oh', 'NB');

-- -- 6. Modification de toutes les informations d’un contact

-- UPDATE contact SET first_name = 'oh', last_name = 'meh', gender = 'F' WHERE id=6;