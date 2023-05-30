--------------------------------------------------------
--  ������ ������ - ȭ����-5��-30-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BULLETIN
--------------------------------------------------------

  CREATE TABLE "C##WEBDB"."BULLETIN" 
   (	"NO" NUMBER, 
	"TITLE" VARCHAR2(500 BYTE), 
	"CONTENT" VARCHAR2(4000 BYTE), 
	"HIT" NUMBER, 
	"REG_DATE" DATE DEFAULT sysdate, 
	"USER_NO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into C##WEBDB.BULLETIN
SET DEFINE OFF;
Insert into C##WEBDB.BULLETIN (NO,TITLE,CONTENT,HIT,REG_DATE,USER_NO) values (4,'dsafasdfasdf','asdfasdfasdf',2,to_date('23/05/29','RR/MM/DD'),1);
Insert into C##WEBDB.BULLETIN (NO,TITLE,CONTENT,HIT,REG_DATE,USER_NO) values (5,'�׽�Ʈ�׽�Ʈ�׽�Ʈ�׽�Ʈ�׽�Ʈ�׽�Ʈ','�׽�Ʈ�׽�Ʈ�׽�Ʈ�׽�Ʈ�׽�Ʈ�׽�Ʈ�׽�Ʈ',14,to_date('23/05/29','RR/MM/DD'),1);
Insert into C##WEBDB.BULLETIN (NO,TITLE,CONTENT,HIT,REG_DATE,USER_NO) values (7,'JSTL <C:WHEN TEST=','.equals -> eq ��ü
${ ���� ���� ��밡��22222',20,to_date('23/05/29','RR/MM/DD'),2);
Insert into C##WEBDB.BULLETIN (NO,TITLE,CONTENT,HIT,REG_DATE,USER_NO) values (8,'�׽�Ʈ����~~','11111������������������������������',6,to_date('23/05/29','RR/MM/DD'),3);
Insert into C##WEBDB.BULLETIN (NO,TITLE,CONTENT,HIT,REG_DATE,USER_NO) values (9,'�׽�Ʈ���̿���~','�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ��',5,to_date('23/05/29','RR/MM/DD'),4);
Insert into C##WEBDB.BULLETIN (NO,TITLE,CONTENT,HIT,REG_DATE,USER_NO) values (10,'�׽�Ʈ���̿���~2','�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�Ʈ�׽��׽�',5,to_date('23/05/29','RR/MM/DD'),4);
--------------------------------------------------------
--  DDL for Index SYS_C007441
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WEBDB"."SYS_C007441" ON "C##WEBDB"."BULLETIN" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table BULLETIN
--------------------------------------------------------

  ALTER TABLE "C##WEBDB"."BULLETIN" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "C##WEBDB"."BULLETIN" MODIFY ("USER_NO" NOT NULL ENABLE);
  ALTER TABLE "C##WEBDB"."BULLETIN" ADD PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
