drop table if exists agent;

create table agent
(
    id       bigint identity primary key,
    codename nvarchar(20),
    realname nvarchar(50),
    licensetokill bit,
    vehicle  nvarchar(30),
    weapon   nvarchar(30),
    phrase   nvarchar(50),
    mission  nvarchar(30)
);