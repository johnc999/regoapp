CREATE TABLE public.insurer
(
    insurer_id bigint NOT NULL,
    name character varying(15) COLLATE pg_catalog."default",
    code character varying(15) COLLATE pg_catalog."default",
    CONSTRAINT insurer_pkey PRIMARY KEY (insurer_id)
)

TABLESPACE pg_default;

ALTER TABLE public.insurer
    OWNER to postgres;

CREATE TABLE public.vehicle
(
    vehicle_id bigint NOT NULL,
    type character varying(15) COLLATE pg_catalog."default",
    make character varying(15) COLLATE pg_catalog."default",
    model character varying(15) COLLATE pg_catalog."default",
    colour character varying(15) COLLATE pg_catalog."default",
    CONSTRAINT vehicle_pkey PRIMARY KEY (vehicle_id)
)

TABLESPACE pg_default;

ALTER TABLE public.vehicle
    OWNER to postgres;

CREATE TABLE public.registration
(
    number_plate character varying(8) COLLATE pg_catalog."default",
    insurer_id bigint,
    vehicle_id bigint,
    CONSTRAINT registrations_pkey PRIMARY KEY (number_plate),
    CONSTRAINT fk94k6wldms4igwawu6t796slqy FOREIGN KEY (vehicle_id)
        REFERENCES public.vehicle (vehicle_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkici20gilo6rf5k0vpbptn3vbu FOREIGN KEY (insurer_id)
        REFERENCES public.insurer (insurer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.registration
    OWNER to postgres;

CREATE SEQUENCE public.hibernate_insurer_sequence
    INCREMENT 1
    START 6
    MINVALUE 6
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE SEQUENCE public.hibernate_vehicle_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;	

ALTER SEQUENCE public.hibernate_insurer_sequence
    OWNER TO postgres;

ALTER SEQUENCE public.hibernate_vehicle_sequence
    OWNER TO postgres;

INSERT INTO insurer (insurer_id, name, code) VALUES (1, 'AAMI', '11');
INSERT INTO insurer (insurer_id, name, code) VALUES (2, 'Allianz', '22');
INSERT INTO insurer (insurer_id, name, code) VALUES (3, 'NRMA', '33');
INSERT INTO insurer (insurer_id, name, code) VALUES (4, 'RACQ', '44');
INSERT INTO insurer (insurer_id, name, code) VALUES (5, 'Suncorp', '55');




