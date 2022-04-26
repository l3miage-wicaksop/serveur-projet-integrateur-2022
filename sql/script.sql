CREATE TABLE IF NOT EXISTS chamis (
    userId varchar(20) NOT NULL,
    login varchar(20),
    age INTEGER,
    description varchar(50)
)

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
)


insert into chamis (login, age) values ('carobis', 21 );
insert into chamis (login, age) values ('escribis', 43 );
insert into chamis (login, age) values ('momo', 38 );
insert into chamis (login, age) values ('nomoldu', 20 );
insert into chamis (login, age) values ('python38', 18 );
insert into chamis (login, age) values ('yes4moldus', 38 );


insert into defis (idDefi, titre, description, dateCreation) values ('D666', 'Premier defi', 'wow le premier!', '2022-04-26 19:10:25-07')