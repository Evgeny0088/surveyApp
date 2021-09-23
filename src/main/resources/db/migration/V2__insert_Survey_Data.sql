
/* insert into survey table*/

insert into surveys(id,sname,description) values (1,'Survey1','Covid sequrity survey for employees');
insert into surveys(id,sname,description) values (2,'Survey2','World wide cities');

/* insert into questions table for survey1*/

insert into questions(id,text,question_type,answer_options,right_answers,survey_id)
    values (1,'What is the most important measure to keep safety?','TEXT','','Wear the mask, keep distance',1);

insert into questions(id,text,question_type,answer_options,right_answers,survey_id)
    values (2,'What is a american vaccine from the list?','SINGLE','pfaizer::moderna::sputnik::astrazeneca','pfaizer',1);

insert into questions(id,text,question_type,answer_options,right_answers,survey_id)
    values (3,'Select something','MULTY','var1::var2::var3::all of them','var2::var2',1);

/* insert into questions table for survey2*/

insert into questions(id,text,question_type,answer_options,right_answers,survey_id)
    values (4,'Capital of Argentina?','TEXT','','Buenos Aires',2);

insert into questions(id,text,question_type,answer_options,right_answers,survey_id)
    values (5,'Most habitant city in the India','SINGLE','Delfi::Mumbai::Bangalor::Hyderabad','Mumbai',2);

insert into questions(id,text,question_type,answer_options,right_answers,survey_id)
    values (6,'Select something?','MULTY','var1::var2::var3::all of them','var1::var2::var3',2);

/* insert into questions table for survey2*/

