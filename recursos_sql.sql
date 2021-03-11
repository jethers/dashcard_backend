create database db_dashcard;

use db_dashcard;

create table tbl_usuario(
   id_usuario    integer not null auto_increment primary key,
   nome_usuario  varchar(80) not null,
   email_usuario varchar(80) unique not null,
   racf_usuario  varchar(7)  unique not null,
   senha         varchar(20) not null,
   ramal         varchar(10),
   link_foto     varchar(255)   
);

create table mtb310_ag_financeiro(
   id_agente integer not null auto_increment,  
   nome_agente varchar(100),
   volume_transacional float,
   constraint pk_agente primary key (id_agente)
);

create table mtb310_transaction(
    id_transacao integer not null auto_increment,
    data_hora datetime,
    dispositivo integer,
    valor_solic float,
    valor_aut  float,
    status integer,
    ag_financeiro integer not null,
    constraint pk_trans primary key (id_transacao),
    constraint fk_agente foreign key (ag_financeiro) references mtb310_ag_financeiro(id_agente)
);

insert into mtb310_ag_financeiro values 
    (null, 'MAGALU Financeira', 1231),
    (null, 'SANTANDER Cartoes', 81212),
    (null, 'ITAU/Uniclass Cards', 9912),
    (null, 'SUBMARINO Cartoes',63421),
    (null, 'HIPERCARD',98273),
    (null, 'ITAU Virtual',12129),
    (null, 'PICPAY Cartoes',812),
    (null, 'SAMS CLUB Mastercard',965),
    (null, 'EXTRA Cartoes VISA',112909),
    (null, 'CARREFOUR Credito Master',191218);
    

select * from mtb310_ag_financeiro;
select * from tbl_usuario;

insert into tbl_usuario values 
  (null, 'Professor Isidro', 'isidro@isidro.com', 'isidro',
         '1234', '2198', 'https://avatars.githubusercontent.com/u/6184696?s=460&v=4');

insert into tbl_usuario values
  (null, 'MegaMan', 'mega@man.com', 'megaman', '1234', '9876',
         'https://pbs.twimg.com/profile_images/1029816770897408000/aUljTnyv.jpg');