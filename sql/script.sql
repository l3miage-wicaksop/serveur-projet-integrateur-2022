CREATE TABLE IF NOT EXISTS chamis (
    login varchar(20) NOT NULL,
    age INTEGER
);

-- CREATE TABLE IF NOT EXISTS visite (
--     idVisite varchar(10) NOT NULL,
--     dateVisite Date,
--     modeVisite varchar(10),
--     status boolean,
--     temps Integer,
--     commentaire varchar(50)
-- )


CREATE TABLE IF NOT EXISTS defis (
    idDefi varchar(10) NOT NULL,
    titre varchar(20),
    -- typeDefi varchar(20),
    description varchar(100),
    dateCreation TimeStamp
    -- dateModification Date, 
    -- prologue varchar(30),
    -- epilogue varchar(30),
    -- motsCles varChar(30)
);

insert into chamis (login, age) values ('carobis', 21 );
insert into chamis (login, age) values ('escribis', 43 );
insert into chamis (login, age) values ('momo', 38 );
insert into chamis (login, age) values ('nomoldu', 20 );
insert into chamis (login, age) values ('python38', 18 );
insert into chamis (login, age) values ('yes4moldus', 38 );





-- V1

insert into chamis (login, age, ville, description) values ('carobis', 21, 'Grenoble','- J''aime la cuisine mais je ne sais pas la faire :-(\n- J''aimerais bien cette année que ChaGra 2022 aille pour Greenpease Grenoble.\n- Je suis bénévole là bas et on a besoin d''une aide financière.- Votez Greenpease.');
insert into chamis (login, age, ville, description) values ('escribis', 43, 'Grenoble', '- Bravo à tous pour vos contributions. C''est cool !\n Pour cette année pour ChaGra 2022 on pourrait voir avec la MDA.\n- Au passage vous devriez vous s''inscrire sur le site contribulle.org\n- Pour contribuer à quelque chose d''utile ca se passe là bas.');
insert into chamis (login, age, ville, description) values ('momo', 38, 'Gières',  '- J''aime faire la cuisine mais mes enfants aiment pas ! Juste MacDo :-(\n- ChaGra 2022 pour Wikipedia ou openstreetmap\n- Lundis soir c''est Mapathon https://turbine.coop/evenement/missingmaps-mapathon-enligne/');
insert into chamis (login, age, ville, description) values ('nomoldu', 20, 'Saint Martin d''Hères', '- Merci momo ! C''est cool. Contente d''être une ChaMise !\n- C''est comme ça qu''on dit ?\n- Sinon faudra repasser et ça c''est pour moi :-)\n- Allez voir https://turbine.coop/programmation/ et les mapathons.' );
insert into chamis (login, age, ville, description) values ('python38', 18, 'Echirolles', '- Pas de défi créé pour l''instant mais je vais m''y mettre.\n- Dommage qu''il y ai pas de moutons à grenoble.\n- Ou alors sinon il faut me dire...\n- Je crois que je vais faire un défis Street Art à Echirolles\n- Il y en a un juste à coté de chez moi.\n- Pour ChaGra 2022 ça pourrait aller au secours populaire.\n- Autour de moi y a de besoins. Avec le covid maintenant ça craint !' );
insert into chamis (login, age, ville, description) values ('yes4moldus', 38, 'Gières', '- J''aime faire la cuisine mais mes enfants aiment pas ! Juste MacDo :-(\n- ChaGra 2022 -> https://www.clown-hopital.com/\n- Vous avez vu https://www.handigmatic.org ?' );


insert into visite (id_visite, commentaire, date_de_visite, id_defi,indices,mode,points,score,status,temps,visiteur ) values('V127-1','- Il pleuvait des cordes. Je me suis mis du mauvais coté de l''arrêt.\n- J''ai pris le premier indice.\n- Après évidemment de l''autre coté c''est plus facile.\n- En fait je trouve qu''il est un peu trop facile => j''ai mis 3 étoiles.','10/04/2021 18:00','D127',1,TRUE,null,0,TRUE,8,'nomoldus');