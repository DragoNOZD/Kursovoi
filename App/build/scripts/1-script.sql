CREATE USER game_admin WITH
    PASSWORD 'admin';
CREATE SCHEMA game_admin AUTHORIZATION game_admin;
CREATE TYPE vector3 AS (
    x double precision,
    y double precision,
    z double precision);
ALTER TYPE vector3 OWNER TO game_admin;