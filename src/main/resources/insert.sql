insert into AUTHOR(ID, NAME, SURNAME, COUNTRY)
values ('e9d998f0-9448-11ed-a1eb-0242ac120002', 'Govard', 'Lavcraft', 'USA'),
       ('1e8598d8-9449-11ed-a1eb-0242ac120002', 'Joan', 'Rowling', 'Great Britain'),
       ('db68fd82-6bed-4a63-8f5c-55265a16e639', 'Lev', 'Tolstoy', 'Russia');
insert into BOOK(ID, NAME, PUBLISH_DATE, PAGE_COUNT, AUTHOR_ID)
values ('7c00be3e-9449-11ed-a1eb-0242ac120002', 'War and piece', '1867-01-01', 1300, 'db68fd82-6bed-4a63-8f5c-55265a16e639'),
       ('d234f14e-9449-11ed-a1eb-0242ac120002', 'Anna Karenina', '1800-01-01', 764, 'db68fd82-6bed-4a63-8f5c-55265a16e639'),
       ('09fb11da-944a-11ed-a1eb-0242ac120002', 'Call of Ctulhu', '1928-01-01', 384, 'e9d998f0-9448-11ed-a1eb-0242ac120002'),
       ('31369ff8-944a-11ed-a1eb-0242ac120002', 'At the mountains of madness', '1936-02-01', 480, 'e9d998f0-9448-11ed-a1eb-0242ac120002'),
       ('589dc97c-944a-11ed-a1eb-0242ac120002', 'Harry Potter and philosopher stone', '1997-06-26', 432, '1e8598d8-9449-11ed-a1eb-0242ac120002'),
       ('7a13fc8e-944a-11ed-a1eb-0242ac120002', 'Harry Potter and the deathly hallows', '2007-07-21', 704, '1e8598d8-9449-11ed-a1eb-0242ac120002');