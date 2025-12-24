create table tg_user (
                         id bigint primary key,
                         tg_user_id bigint not null,
                         first_name text,
                         is_bot boolean default false,
                         last_name text,
                         username text,
                         language_code text
);

create sequence tg_user_seq increment by 2;

create table chat (
                      id bigint primary key,
                      tg_chat_id bigint,
                      type text,
                      title text
);

create sequence chat_seq increment by 2;

create table message (
                         id bigint primary key,
                         tg_message_id bigint,
                         user_id_from bigint,
                         chat_id bigint,
                         message_text text,
                         date_created timestamp default current_timestamp
);
create sequence message_seq increment by 2;
