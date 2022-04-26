CREATE TABLE IF NOT EXISTS chamis (
    userId varchar(20) NOT NULL,
    login varchar(20),
    age INTEGER,
    description varchar(50)
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

insert into chamis (userid, login, age) values ('D132','carobis', 21 );
insert into chamis (userid, login, age) values ('D99','escribis', 43 );
insert into chamis (userid, login, age) values ('D22' ,'momo', 38 );
insert into chamis (userid, login, age) values ('D102','nomoldu', 20 );
insert into chamis (userid, login, age) values ('D66', 'python38', 18 );
insert into chamis (userid, login, age) values ('D32', 'yes4moldus', 38 );

insert into defis (idDefi, titre, dateCreation, auteur, description) values ('D127', 'Le Méchoui', '2021-03-15 17:18:25-07', 'escribis', '- Rendez-vous à l''arrêt Victor-Hugo\n- C''est l''été. Tu as besoin de grand air.\n- Demande à quelqu''un où est la maison de la montagne.\n- Longe le tram pour y aller. Tu demanderas où on peut voir des chamois.\n- Vas pas trop vite ! Les chamoix sont en plein centre ville !\n- Grenoble c''est la ville du béton, mais c''est aussi la capitale des Alpes.\n- Fait attention tu pourrais te faire écraser par des pachidermes !\n- (Q1) Combien d''écureuils (compter uniquement les tout plats) ?\n- (Q2) Combien de chamois ?\n- (Q3) Combien d''éléphants ?');
insert into defis (idDefi, titre, dateCreation, auteur, description) values ('D145', 'Le vert, je le mange !', '2021-04-01 15:03:35-07', 'escribis','- Rendez vous à l''arrêt de bus "Grenoble - hôtel de ville".\n- Passe par "l''orangerie".\n- Ca te donneras de l''énergie mais surtout ne dépasse pas les bornes !\n- Fatiguée ? T''as pas fait des bornes. Tu devrais avoir de l''énergie.\n- Reste sur le parking pour te recharger les piles.\n- Cherche plutôt celui qui pourrait te donner matière à te protéger pendant l''hiver.\n- Il est là. Il te regarde de haut. Il t''observe.\n- Il bêle. "Je suis ceux que je suis. Et le vert, je le mange !"- Combien de boucles sous mon cou ?');
insert into defis (idDefi, titre, dateCreation, auteur, description) values ('D151', 'Ils tournent et rond.', '2021-04-13 12:03:35-07', 'nomoldu', '- Rendez-vous à l''arrêt Victor Hugo\n- Il tourne en rond pour le plaisir des petits. Cherche le.\n- Si il n''y est pas demande à quelqu''un où il est quand il y est :-)\n- Fait toi un selfie avec les 2 moutons en utilisant ton sens de la créativité.\n- Si tu n''y arrives pas demande à quelqu''un qu''il/elle te tire un portrait.\n');
insert into defis (idDefi, titre, dateCreation, auteur, description) values ('D189', 'Et l''écureil alors ?', '2021-03-17 12:03:35-07', 'carobis', '- Rendez-vous à l''arrêt Victor-Hugo\n- C''est l''été. Tu as besoin de grand air.\n- Demande à quelqu''un où est la maison de la montagne.\n- Longe le tram pour y aller. Tu demanderas où on peut voir des chamois.- Vas pas trop vite ! Les chamoix sont en plein centre ville !- Grenoble c''est la ville du béton, mais c''est aussi la capitale des Alpes.- Fait attention tu pourrais te faire écraser par des pachidermes !\n- (Q1) Combien d''écureuils (compter uniquement les tout plats) ?\n- (Q2) Combien de chamois ?\n- (Q3) Combien d''éléphants ?');




