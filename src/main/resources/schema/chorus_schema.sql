DROP TABLE public.model;
DROP TABLE public.field;
DROP TABLE public.collector;
DROP TABLE public.entity;
DROP TABLE public.value;
DROP TABLE public.relation;

CREATE TABLE public.model
(
    id SERIAL PRIMARY KEY NOT NULL,                     -- type id
    domain character varying(200)  NOT NULL,
    name character varying(50)  NOT NULL,
    extend character varying(200),                      -- parent type
    label character varying(20),
    description text,
    CONSTRAINT cm_u_key UNIQUE ("domain", name)
);

CREATE TABLE public.field
(
    id SERIAL PRIMARY KEY NOT NULL,                     -- field id
    owner character varying(200) NOT NULL,              -- type domain + type name
    name character varying(50) NOT NULL,                -- field name
    type character varying(200) NOT NULL,               -- this field's type domain + type name
    label character varying(20),
    collector character varying(100),
    relation character varying(20),
    constraints text,                                   -- format, unit, range, unique, optional, visible, configurable, collectible, ....
    description text,
    CONSTRAINT fm_u_key UNIQUE (owner, name)
);

CREATE TABLE public.collector
(
    id SERIAL PRIMARY KEY NOT NULL,                     -- entity id
    name character varying(100) NULL,                   -- method name
    result character varying(200),                      -- method result type = result type domain + result type name
    injects character varying(200)[],                   -- method type = domain + name
    args character varying(50)[],                       -- dynamic argument = field name
    description text,
    CONSTRAINT cl_u_key UNIQUE (name)
);


CREATE TABLE public.entity
(
    id SERIAL PRIMARY KEY NOT NULL,                     -- entity id
    name character varying(50),                         -- entity name, default is ${type name}_${id}
    type character varying(200),                        -- entity's type = domain + name
    creator character varying(50),
    associate integer[],                                -- associate with other entity ids
    tags character varying(20)[],                       -- tags
    grade integer,
    create_time bigint,
    update_time bigint,
    description text,
    CONSTRAINT ie_u_key UNIQUE (type, name)
);

CREATE TABLE public.value
(
    id SERIAL PRIMARY KEY NOT NULL,                     -- entity id
    owner integer,                                      -- entity id
    name character varying(50),
    type character varying(50),                         -- primitive type: integer, long, float, double, boolean, string, list
    value text
);

CREATE TABLE public.relation
(
    id SERIAL PRIMARY KEY NOT NULL,                     -- entity id
    name character varying(20),
    creator character varying(20),
    description text
);

