-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
	id int4 NOT NULL,
	"name" varchar NOT NULL,
	brand varchar NOT NULL,
	description varchar NOT NULL,
	manufacturing_date timestamp NOT NULL,
	quantity int4 DEFAULT 0 NOT NULL,
	price numeric DEFAULT 0 NOT NULL,
	discount bool NOT NULL,
	date_created timestamp DEFAULT now() NOT NULL,
	date_updated timestamp DEFAULT now() NOT NULL,	
	CONSTRAINT product_pk PRIMARY KEY (id)
);