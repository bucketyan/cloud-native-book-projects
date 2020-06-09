/*create sequence hibernate_sequence;*/

create table "carts"
(
    "id"                 bigint       not null,
    "create_time"       timestamp    not null,
    "update_time" timestamp,
    "status"             varchar(255) not null,
    "customer_id"        bigint
);
alter table "carts"
    add constraint "cart_pk" primary key ("id");

insert into "carts"
values (9, current_timestamp, current_timestamp, 'NEW', 7),
       (12, current_timestamp, current_timestamp, 'NEW', 8);

create table "categories"
(
    "id"                 bigint       not null,
    "create_time"       timestamp    not null,
    "update_time" timestamp,
    "description"        varchar(255) not null,
    "name"               varchar(255) not null
);
alter table "categories"
    add constraint "categories_pk" primary key ("id");

insert into "categories"
values (1, current_timestamp, current_timestamp, 'Phones & Smartphones categories', 'Phone');
create table "customers"
(
    "id"                 bigint    not null,
    "create_time"       timestamp not null,
    "update_time" timestamp,
    "email"              varchar(255),
    "enabled"            boolean   not null,
    "name"         varchar(255),
    "telephone"          varchar(255)
);
alter table "customers"
    add constraint "customer_pk" primary key ("id");

insert into "customers"
values (7, current_timestamp, current_timestamp, 'test1@mail.hello', TRUE, 'fuck1', '010203040506'),
       (8, current_timestamp, current_timestamp, 'test2@mail.hello', TRUE, 'fuck2', '060504030201');
create table "order_items"
(
    "id"                 bigint    not null,
    "create_time"       timestamp not null,
    "update_time" timestamp,
    "quantity"           bigint    not null,
    "order_id"           bigint,
    "product_id"         bigint
);
alter table "order_items"
    add constraint "order_item_pk" primary key ("id");

insert into "order_items"
values (11, current_timestamp, current_timestamp, 1, 10, 2),
       (14, current_timestamp, current_timestamp, 1, 13, 3);
create table "orders"
(
    "id"                 bigint         not null,
    "create_time"       timestamp      not null,
    "update_time" timestamp,
    "address"          varchar(255),
    "city"               varchar(255),
    "country"            varchar(2),
    "postcode"           varchar(10),
    "shipped"            timestamp,
    "status"             varchar(255)   not null,
    "total_price"        decimal(10, 2) not null,
    "cart_id"            bigint,
    "payment_id"         bigint
);
alter table "orders"
    add constraint "orders_pk" primary key ("id");

insert into "orders"
values (10, current_timestamp, current_timestamp, '测试地址1', '武汉', '中国', '123456', NULL, 'CREATION',
        999.00, 9, NULL),
       (13, current_timestamp, current_timestamp, '测试地址2', '北京', '中国', '123456', NULL, 'CREATION',
        759.00, 12, NULL);
create table "payments"
(
    "id"                 bigint       not null,
    "create_time"       timestamp    not null,
    "update_time" timestamp,
    "payment_id"  varchar(255),
    "status"             varchar(255) not null,
    "order_id"           bigint
);
alter table "payments"
    add constraint "payment_pk" primary key ("id");

create table "products"
(
    "id"                 bigint         not null,
    "create_time"       timestamp      not null,
    "update_time" timestamp,
    "description"        varchar(255)   not null,
    "name"               varchar(255)   not null,
    "price"              decimal(10, 2) not null,
    "sales_counter"      integer,
    "status"             varchar(255)   not null,
    "category_id"        bigint
);
alter table "products"
    add constraint "product_pk" primary key ("id");

insert into "products"
values (2, current_timestamp, current_timestamp, 'iPhone 11 Pro', 'iPhone 11 Pro', 999.00, 0,
        'AVAILABLE', 1),
       (3, current_timestamp, current_timestamp, 'iPhone XS', 'iPhone XS', 759.00, 0,
        'AVAILABLE', 1);
create table "products_reviews"
(
    "product_id" bigint not null,
    "reviews_id" bigint not null
);
alter table "products_reviews"
    add constraint "products_reviews_pk" primary key ("product_id", "reviews_id");

insert into "products_reviews"
values (2, 4),
       (2, 5),
       (3, 6);
create table "reviews"
(
    "id"                 bigint       not null,
    "create_time"       timestamp    not null,
    "update_time" timestamp,
    "description"        varchar(255) not null,
    "rating"             bigint       not null,
    "title"              varchar(255) not null
);
alter table "reviews"
    add constraint "review_pk" primary key ("id");

insert into "reviews"
values (4, current_timestamp, current_timestamp, '测试评论1', 4,
        'Good but not perfect'),
       (5, current_timestamp, current_timestamp, '测试评论2', 5, 'Excellent'),
       (6, current_timestamp, current_timestamp, '测试评论3', 3, 'Good but very expensive');
alter table "products_reviews"
    add constraint "products_reviews_uk" unique ("reviews_id");
alter table "payments"
    add constraint "payment_uk" unique ("order_id");
alter table "orders"
    add constraint "orders_uk" unique ("payment_id");
alter table "products_reviews"
    add constraint "products_reviews_fk1" foreign key ("reviews_id") references "reviews" ("id");
alter table "carts"
    add constraint "cart_fk" foreign key ("customer_id") references "customers" ("id");
alter table "order_items"
    add constraint "order_item_fk1" foreign key ("product_id") references "products" ("id");
alter table "payments"
    add constraint "payments_fk" foreign key ("order_id") references "orders" ("id");
alter table "orders"
    add constraint "orders_fk1" foreign key ("payment_id") references "payments" ("id");
alter table "order_items"
    add constraint "order_item_fk2" foreign key ("order_id") references "orders" ("id");
alter table "products"
    add constraint "product_fk" foreign key ("category_id") references "categories" ("id");
alter table "orders"
    add constraint "orders_fk2" foreign key ("cart_id") references "carts" ("id");
alter table "products_reviews"
    add constraint "products_reviews_fk2" foreign key ("product_id") references "products" ("id");

/*SELECT pg_catalog.setval('hibernate_sequence', 14, true);*/