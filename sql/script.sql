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
    titre varchar(40),
    -- typeDefi varchar(20),
    description varchar(1000),
    dateCreation TimeStamp,
    auteur varChar(20)
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

insert into defis (idDefi, titre, dateCreation, auteur, description) values ('D127', 'Le Méchoui', '2021-03-15 17:18:25-07', 'escribis', '- Rendez-vous à l''arrêt Victor-Hugo\n- C''est l''été. Tu as besoin de grand air.\n- Demande à quelqu''un où est la maison de la montagne.\n- Longe le tram pour y aller. Tu demanderas où on peut voir des chamois.\n- Vas pas trop vite ! Les chamoix sont en plein centre ville !\n- Grenoble c''est la ville du béton, mais c''est aussi la capitale des Alpes.\n- Fait attention tu pourrais te faire écraser par des pachidermes !\n- (Q1) Combien d''écureuils (compter uniquement les tout plats) ?\n- (Q2) Combien de chamois ?\n- (Q3) Combien d''éléphants ?');
insert into defis (idDefi, titre, dateCreation, auteur, description) values ('D145', 'Le vert, je le mange !', '2021-04-01 15:03:35-07', 'escribis','- Rendez vous à l''arrêt de bus "Grenoble - hôtel de ville".\n- Passe par "l''orangerie".\n- Ca te donneras de l''énergie mais surtout ne dépasse pas les bornes !\n- Fatiguée ? T''as pas fait des bornes. Tu devrais avoir de l''énergie.\n- Reste sur le parking pour te recharger les piles.\n- Cherche plutôt celui qui pourrait te donner matière à te protéger pendant l''hiver.\n- Il est là. Il te regarde de haut. Il t''observe.\n- Il bêle. "Je suis ceux que je suis. Et le vert, je le mange !"- Combien de boucles sous mon cou ?');
insert into defis (idDefi, titre, dateCreation, auteur, description) values ('D151', 'Ils tournent et rond.', '2021-04-13 12:03:35-07', 'nomoldu', '- Rendez-vous à l''arrêt Victor Hugo\n- Il tourne en rond pour le plaisir des petits. Cherche le.\n- Si il n''y est pas demande à quelqu''un où il est quand il y est :-)\n- Fait toi un selfie avec les 2 moutons en utilisant ton sens de la créativité.\n- Si tu n''y arrives pas demande à quelqu''un qu''il/elle te tire un portrait.\n');
insert into defis (idDefi, titre, dateCreation, auteur, description) values ('D189', 'Et l''écureil alors ?', '2021-03-17 12:03:35-07', 'carobis', '- Rendez-vous à l''arrêt Victor-Hugo\n- C''est l''été. Tu as besoin de grand air.\n- Demande à quelqu''un où est la maison de la montagne.\n- Longe le tram pour y aller. Tu demanderas où on peut voir des chamois.- Vas pas trop vite ! Les chamoix sont en plein centre ville !- Grenoble c''est la ville du béton, mais c''est aussi la capitale des Alpes.- Fait attention tu pourrais te faire écraser par des pachidermes !\n- (Q1) Combien d''écureuils (compter uniquement les tout plats) ?\n- (Q2) Combien de chamois ?\n- (Q3) Combien d''éléphants ?');




-- V1
insert into chamis (login, age, ville, description) values ('escribis', 43, 'Grenoble', '- Bravo à tous pour vos contributions. C''est cool !\n Pour cette année pour ChaGra 2022 on pourrait voir avec la MDA.\n- Au passage vous devriez vous s''inscrire sur le site contribulle.org\n- Pour contribuer à quelque chose d''utile ca se passe là bas.');
insert into chamis (login, age, ville, description) values ('momo', 38, 'Gières',  '- J''aime faire la cuisine mais mes enfants aiment pas ! Juste MacDo :-(\n- ChaGra 2022 pour Wikipedia ou openstreetmap\n- Lundis soir c''est Mapathon https://turbine.coop/evenement/missingmaps-mapathon-enligne/');
insert into chamis (login, age, ville, description) values ('nomoldu', 20, 'Saint Martin d''Hères', '- Merci momo ! C''est cool. Contente d''être une ChaMise !\n- C''est comme ça qu''on dit ?\n- Sinon faudra repasser et ça c''est pour moi :-)\n- Allez voir https://turbine.coop/programmation/ et les mapathons.' );
insert into chamis (login, age, ville, description) values ('python38', 18, 'Echirolles', '- Pas de défi créé pour l''instant mais je vais m''y mettre.\n- Dommage qu''il y ai pas de moutons à grenoble.\n- Ou alors sinon il faut me dire...\n- Je crois que je vais faire un défis Street Art à Echirolles\n- Il y en a un juste à coté de chez moi.\n- Pour ChaGra 2022 ça pourrait aller au secours populaire.\n- Autour de moi y a de besoins. Avec le covid maintenant ça craint !' );
insert into chamis (login, age, ville, description) values ('yes4moldus', 38, 'Gières', '- J''aime faire la cuisine mais mes enfants aiment pas ! Juste MacDo :-(\n- ChaGra 2022 -> https://www.clown-hopital.com/\n- Vous avez vu https://www.handigmatic.org ?' );


insert into visite (id_visite, commentaire, date_de_visite, id_defi,indices,mode,points,score,status,temps,visiteur ) values('V127-1','- Il pleuvait des cordes. Je me suis mis du mauvais coté de l''arrêt.\n- J''ai pris le premier indice.\n- Après évidemment de l''autre coté c''est plus facile.\n- En fait je trouve qu''il est un peu trop facile => j''ai mis 3 étoiles.','10/04/2021 18:00','D127',1,TRUE,null,0,TRUE,8,'nomoldus');
