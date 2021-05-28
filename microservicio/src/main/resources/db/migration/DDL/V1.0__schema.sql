create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table consignacion (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 apellido varchar(100) not null,
 telefono varchar(100) not null,
 direccion varchar(100) not null,
 identificacion varchar(100) not null ,
 cantidadConsignada DECIMAL(19 , 4 ) NOT NULL,
 primary key (id),
);
