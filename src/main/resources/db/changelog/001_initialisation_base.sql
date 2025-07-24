--CREATE DATABASE ttmv2;

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(42) NOT NULL UNIQUE,
    prenom VARCHAR(42),
    nom VARCHAR(42),
    email VARCHAR(100),
    password VARCHAR(255),
    role VARCHAR(42),
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modification_date TIMESTAMP,
    disponibilites TEXT,
    plateforme_initiative TEXT,
    id_parrain INT,
    id_porteur INT,
    first_login BOOLEAN DEFAULT TRUE
);


-- ========================================
-- TABLE : porteurs
-- ========================================
CREATE TABLE IF NOT EXISTS porteurs (
    id SERIAL PRIMARY KEY, -- Identifiant unique du porteur
    entreprise TEXT, -- Nom de l'entreprise du porteur
    date_lancement TEXT, -- Date de lancement du projet ou de l'entreprise
    domaine_activite TEXT, -- Domaine d'activité principal
    description TEXT, -- Description du projet ou de l'activité
    besoins_potentiels TEXT, -- Besoins identifiés ou potentiels du porteur
    lieu_activite TEXT -- Lieu principal d'activité
);

-- ========================================
-- TABLE : parrains
-- ========================================
CREATE TABLE IF NOT EXISTS parrains (
    id SERIAL PRIMARY KEY, -- Identifiant unique du parrain
    entreprise_representee TEXT, -- Nom de l'entreprise représentée par le parrain
    presentation_parcours TEXT, -- Présentation du parcours professionnel
    type_de_reseau TEXT, -- Type de réseau dans lequel le parrain est impliqué
    domaine_expertise TEXT, -- Domaine d'expertise du parrain
    lieux_deplacement TEXT -- Zones géographiques où le parrain peut se déplacer
);


 -- ========================================
 -- TABLE : secteurs
 -- ========================================
 CREATE TABLE IF NOT EXISTS secteurs (
     id SERIAL PRIMARY KEY,
     name TEXT NOT NULL UNIQUE,
     id_number INT UNIQUE NOT NULL,
     actif BOOLEAN DEFAULT TRUE
 );

 -- ========================================
 -- TABLE : types
 -- ========================================
 CREATE TABLE IF NOT EXISTS types (
     id SERIAL PRIMARY KEY,
     name TEXT NOT NULL UNIQUE,
     id_number INT UNIQUE NOT NULL
 );

 -- ========================================
 -- INSERTIONS : secteurs
 -- ========================================
 INSERT INTO secteurs(name, id_number, actif) VALUES
 ('Services administratifs et soutien', 1, true),
 ('Activités spécialisées, techniques et scientifiques', 2, true),
 ('Agriculture, sylviculture et pêche', 3, true),
 ('Arts, spectacles et activités récréatives', 4, true),
 ('Commerce et réparation', 5, true),
 ('Contruction_BTP', 6, true),
 ('Enseignement', 7, true),
 ('Hôtels, cafés et restaurants', 8, true),
 ('Industrie', 9, true),
 ('Information et communication', 10, true),
 ('Eau, assainissement, gestion des déchets et dépollution', 11, true),
 ('Electricité, gaz, vapeur d''air conditionné', 12, true),
 ('Santé humaine et action sociale', 13, true),
 ('Services aux entreprises', 14, true),
 ('Services aux particuliers', 15, true),
 ('Transport', 16, true);

 -- ========================================
 -- INSERTIONS : types
 -- ========================================
 INSERT INTO types(name, id_number) VALUES
 ('Ressources humaines', 1),
 ('Finance et comptabilité', 2),
 ('Juridique', 3),
 ('Informatique', 4),
 ('Commercial et communication', 5);

 -- ========================================
 -- Création compte ADMIN pour le démarrage de l'application
 -- Utilisation du site bcrypt.fr pour hasher le mot de passe.
 -- ========================================
 INSERT INTO users (username, prenom, nom, email, password, role)
 VALUES (
     'admin_test',
     'Admin',
     'test',
     'admin@example.com',
     '$2y$10$4RC4JGjVxtfNpB1wzmgBQOLoHLpz/LOAhBgJBTz4qm2XnnNoUWlVy', -- À remplacer par un mot de passe hashé si possible
     'ADMIN'
 );



 -- ========================================
 -- ROLLBACK
 -- ========================================
 --rollback DROP TABLE IF EXISTS secteurs;
 --rollback DROP TABLE IF EXISTS types;
