CREATE SEQUENCE SEQ_COLETAS
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE TBL_COLETAS (
    ID INTEGER DEFAULT SEQ_COLETAS.NEXTVAL NOT NULL,
    ENDERECO VARCHAR2(255) NOT NULL,
    DATA TIMESTAMP NOT NULL,
    URGENTE NUMBER(1) NOT NULL CHECK (URGENTE IN (0, 1))
);
