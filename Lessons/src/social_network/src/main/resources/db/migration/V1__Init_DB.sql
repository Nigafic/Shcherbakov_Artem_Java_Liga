 create sequence hibernate_sequence start 1 increment 1;

 create table friendship
        (
        id int8 not null,
        recipient_id int8,
        sender_id int8,
        primary key (id)
        );

 create table message
        (
        id int8 not null,
        message_text varchar(2048),
        recipient_id int8,
        sender_id int8,
        primary key (id)
        );

 create table web_user
        (
        id int8 not null,
        age int4 not null,
        country varchar(255),
        email varchar(255),
        first_name varchar(255),
        gender varchar(255),
        interests varchar(255),
        last_name varchar(255),
        password varchar(255),
        primary key (id)
        );

 alter table if exists friendship
        add constraint friendship_recipient_fk
        foreign key (recipient_id) references web_user;

 alter table if exists friendship
        add constraint friendship_sender_fk
        foreign key (sender_id) references web_user;

 alter table if exists message
        add constraint message_recipient_id
        foreign key (recipient_id) references web_user;

 alter table if exists message
        add constraint message_sender_id
        foreign key (sender_id) references web_user;





