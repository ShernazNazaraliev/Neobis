create database AutoShop;

\c AutoShop;

create table Cars(
    CarID int unsigned primary key auto_increment,
    CarName varchar(40) not null,
    Color varchar(20) not null,
    EngineVolume DOUBLE not null,
    Prise DOUBLE not null
);


create table Customers(
    CustomersId int unsigned primary key auto_increment,
    CustomersName varchar(40) not null,
    CustomersAddress varchar(40) not null,
    CustomersEmail varchar(20) not null,
    PhoneNamber varchar(15) not null,
    unique(CustomersEmail, PhoneNamber)
);


create table Orders(
    OrdersID int unsigned primary key auto_increment,
    CarID int unsigned,
    CustomersId int unsigned,
    DateOrder DATE,
    foreign key (CustomersId) references Customers (CustomersId),
    foreign key (CarID) references Cars(CarID)
);


