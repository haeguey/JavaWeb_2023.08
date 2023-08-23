
/* Drop Triggers */

DROP TRIGGER TRI_blog_blogId;



/* Drop Tables */

DROP TABLE blog CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_blog_blogId;




/* Create Sequences */

CREATE SEQUENCE SEQ_blog_blogId INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE blog
(
	blogId number NOT NULL,
	penName varchar2(20) NOT NULL,
	title varchar2(128) NOT NULL,
	content varchar2(4000),
	modTime timestamp DEFAULT CURRENT_TIMESTAMP,
	viewCount number DEFAULT 0 NOT NULL,
	isDeleted number DEFAULT 0,
	PRIMARY KEY (blogId)
);



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_blog_blogId BEFORE INSERT ON blog
FOR EACH ROW
BEGIN
	SELECT SEQ_blog_blogId.nextval
	INTO :new.blogId
	FROM dual;
END;

/




