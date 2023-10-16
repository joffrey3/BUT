
--DROP TABLE commande_ligne ;
--DROP TABLE commande ;
--DROP TABLE client ;
--DROP TABLE produit;

--
-- Table structure for table client
--

	CREATE TABLE client (
	  id NUMBER(10)  NOT NULL ,
	  prenom varchar2(255) NOT NULL,
	  nom varchar2(255) NOT NULL,
	  email varchar2(255) NOT NULL,
	  ville varchar2(255) NOT NULL,
	  PRIMARY KEY (id)
	);


CREATE TABLE commande (
  id NUMBER(2)  NOT NULL ,
  client_id NUMBER(10) ,
  date_achat date NOT NULL,
  reference varchar2(255) NOT NULL,
  PRIMARY KEY (id)
);
ALTER TABLE commande ADD CONSTRAINTS fk_client FOREIGN KEY(client_id) REFERENCES client(id);

CREATE TABLE produit (
nom_produit varchar2(255) NOT NULL,
prix_unitaire NUMBER(10, 3) NOT NULL,
PRIMARY KEY(nom_produit)
);

CREATE TABLE commande_ligne (
  id NUMBER(10)  NOT NULL ,
  commande_id NUMBER(10) NOT NULL,
  nom_produit varchar2(255) NOT NULL,
  quantite NUMBER(10) NOT NULL,
  prix_total NUMBER(10, 3)  NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE commande_ligne ADD CONSTRAINTS fk_commande FOREIGN KEY(commande_id) REFERENCES commande(id);
ALTER TABLE commande_ligne ADD CONSTRAINT fk_produit FOREIGN KEY(nom_produit) REFERENCES produit(nom_produit);


--
-- Dumping data for table client
--

INSERT INTO client (id, prenom, nom, email, ville) VALUES (1, 'Flavie', 'Da costa', 'f.da.costa@example.com', 'Pomoy');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (2, 'Valentin', 'Vespasien', 'valentin@example.com', 'Buvilly');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (3, 'Gustave', 'Collin', 'gust@example.com', 'Marseille');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (4, 'Emilien', 'Camus', 'emilien@example.com', 'Toulouse');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (5, 'Firmin', 'Marais', 'firmin.marais@example.com', 'Lyon');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (6, 'Olivier', 'Riou', 'olive.de.lugagnac@example.com', 'Lugagnac');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (7, 'Lucas', 'Jung', 'lucas.jung@example.com', 'Coulgens');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (8, 'Maurice', 'Huet', 'maurice.villemareuil@example.com', 'Villemareuil');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (9, 'Manon', 'Durand', 'm.durand.s.e@example.com', 'Saint-Etienne');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (10, 'Joachim', 'Leon', 'joachim@example.com', 'Longwy-sur-le-Doubs');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (11, 'Muriel', 'Dupuis', 'muriel@example.com', 'Paris');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (12, 'Christiane', 'Riou', 'chritianelesabrets@example.com', 'Les Abrets');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (13, 'Jacinthe', 'Langlois', 'jacinthe.langlois@example.com', 'Lagney');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (14, 'Amaury', 'Payet', 'amaury@example.com', 'Avermes');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (15, 'Maris', 'Buisson', 'maris@example.com', 'Le Havre');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (16, 'Fabrice', 'Foucher', 'fab.montlouis@example.com', 'Montlouis');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (17, 'Patrick', 'Saunier', 'patrick.saunier@example.com', 'Saligney');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (18, 'Emile', 'Ramos', 'emile@example.com', 'Arzay');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (19, 'Armel', 'Vigneron', 'armel.delain@example.com', 'Delain');
INSERT INTO client (id, prenom, nom, email, ville) VALUES (20, 'Arnaude', 'Vallee', 'armaude.vallee@example.com', 'Hostias');
COMMIT;


INSERT INTO commande (id, client_id, date_achat, reference) VALUES (1, 20, TO_DATE('2019-01-01','YYYY-MM-DD'), '004214');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (2, 3, TO_DATE('2019-01-03','YYYY-MM-DD'), '007120');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (3, 11, TO_DATE('2019-01-04','YYYY-MM-DD'), '002957');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (4, 6, TO_DATE('2019-01-07','YYYY-MM-DD'), '003425');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (5, 17, TO_DATE('2019-01-08','YYYY-MM-DD'), '008255');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (6, 7, TO_DATE('2019-01-09','YYYY-MM-DD'), '000996');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (7, 2, TO_DATE('2019-01-10','YYYY-MM-DD'), '000214');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (8, 7, TO_DATE('2019-01-11','YYYY-MM-DD'), '008084');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (9, 12, TO_DATE('2019-01-11','YYYY-MM-DD'), '009773');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (10, 16, TO_DATE('2019-01-13','YYYY-MM-DD'), '004616');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (11, 4, TO_DATE('2019-01-14','YYYY-MM-DD'), '003757');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (12, 9, TO_DATE('2019-01-15','YYYY-MM-DD'), '004939');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (13, 14, TO_DATE('2019-01-16','YYYY-MM-DD'), '003421');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (14, 6, TO_DATE('2019-01-16','YYYY-MM-DD'), '002286');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (15, 3, TO_DATE('2019-01-17','YYYY-MM-DD'), '001167');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (16, 15, TO_DATE('2019-01-18','YYYY-MM-DD'), '008974');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (17, 9, TO_DATE('2019-01-19','YYYY-MM-DD'), '001369');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (18, 17, TO_DATE('2019-01-20','YYYY-MM-DD'), '009924');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (19, 3, TO_DATE('2019-01-21','YYYY-MM-DD'), '005510');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (20, 17, TO_DATE('2019-01-22','YYYY-MM-DD'), '007778');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (21, 17, TO_DATE('2019-01-23','YYYY-MM-DD'), '002359');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (22, 15, TO_DATE('2019-01-25','YYYY-MM-DD'), '008459');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (23, 4, TO_DATE('2019-01-27','YYYY-MM-DD'), '005217');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (24, 12, TO_DATE('2019-01-29','YYYY-MM-DD'), '000706');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (25, 9, TO_DATE('2019-02-01','YYYY-MM-DD'), '007879');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (26, 8, TO_DATE('2019-02-02','YYYY-MM-DD'), '007277');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (27, 11, TO_DATE('2019-02-02','YYYY-MM-DD'), '002745');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (28, 11, TO_DATE('2019-02-03','YYYY-MM-DD'), '001893');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (29, 20, TO_DATE('2019-02-04','YYYY-MM-DD'), '001230');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (30, 10, TO_DATE('2019-02-05','YYYY-MM-DD'), '000469');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (31, 7, TO_DATE('2019-02-05','YYYY-MM-DD'), '008653');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (32, 3, TO_DATE('2019-02-06','YYYY-MM-DD'), '001858');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (33, 14, TO_DATE('2019-02-07','YYYY-MM-DD'), '003330');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (34, 2, TO_DATE('2019-02-08','YYYY-MM-DD'), '001074');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (35, 5, TO_DATE('2019-02-08','YYYY-MM-DD'), '005379');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (36, 16, TO_DATE('2019-02-09','YYYY-MM-DD'), '003672');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (37, 10, TO_DATE('2019-02-09','YYYY-MM-DD'), '002220');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (38, 19, TO_DATE('2019-02-10','YYYY-MM-DD'), '000086');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (39, 8, TO_DATE('2019-02-11','YYYY-MM-DD'), '003770');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (40, 2, TO_DATE('2019-02-12','YYYY-MM-DD'), '008590');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (41, 2, TO_DATE('2019-02-12','YYYY-MM-DD'), '001639');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (42, 4, TO_DATE('2019-02-13','YYYY-MM-DD'), '002426');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (43, 13, TO_DATE('2019-02-14','YYYY-MM-DD'), '007209');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (44, 13, TO_DATE('2019-02-15','YYYY-MM-DD'), '008768');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (45, 7, TO_DATE('2019-02-16','YYYY-MM-DD'), '002213');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (46, 12, TO_DATE('2019-02-17','YYYY-MM-DD'), '004759');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (47, 19, TO_DATE('2019-02-18','YYYY-MM-DD'), '007155');
INSERT INTO commande (id, client_id, date_achat, reference) VALUES (48, 2, TO_DATE('2019-02-19','YYYY-MM-DD'), '001496');
COMMIT;


INSERT INTO Produit(nom_produit, prix_unitaire)  VALUES ('Produit0', 49.57);
INSERT INTO Produit(nom_produit, prix_unitaire)  VALUES ('Produit1', 10.99);
INSERT INTO Produit(nom_produit, prix_unitaire)  VALUES ('Produit2', 100.10);
INSERT INTO Produit(nom_produit, prix_unitaire)  VALUES ('Produit3', 20);
INSERT INTO Produit(nom_produit, prix_unitaire)  VALUES ('Produit4', 72.98);
INSERT INTO Produit(nom_produit, prix_unitaire)  VALUES ('Produit5', 9);
INSERT INTO Produit(nom_produit, prix_unitaire)  VALUES ('Produit6', 0.99);
INSERT INTO Produit(nom_produit, prix_unitaire)  VALUES ('Produit7', 44.50);
INSERT INTO Produit(nom_produit, prix_unitaire)  VALUES ('Produit8', 112);
INSERT INTO Produit(nom_produit, prix_unitaire)  VALUES ('Produit9', 5);
COMMIT;


INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (1, 1, 'Produit1', 3, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (2, 1, 'Produit9', 1,  0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (3, 1, 'Produit6', 2,  0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (4, 2, 'Produit5', 4,  0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (5, 2, 'Produit7', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (6, 3, 'Produit9', 7,  0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (7, 4, 'Produit3', 8,  0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (8, 4, 'Produit4', 10, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (9, 4, 'Produit7', 4,  0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (10, 4, 'Produit8', 9, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (11, 4, 'Produit9', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (12, 5, 'Produit0', 10, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (13, 5, 'Produit7', 2, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (14, 6, 'Produit1', 9, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (15, 7, 'Produit6', 2, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (16, 7, 'Produit7', 7,  0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (17, 7, 'Produit9', 3, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (18, 8, 'Produit5', 9,  0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (19, 9, 'Produit7', 10, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (20, 10, 'Produit2', 2, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (21, 10, 'Produit0', 5, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (22, 10, 'Produit6', 10,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (23, 10, 'Produit1', 5, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (24, 11, 'Produit4', 5, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (25, 12, 'Produit2', 1, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (26, 12, 'Produit9', 7, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (27, 13, 'Produit3', 2, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (28, 13, 'Produit0', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (29, 14, 'Produit1', 7, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (30, 14, 'Produit0', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (31, 15, 'Produit7', 9, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (32, 15, 'Produit2', 8, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (33, 16, 'Produit2', 4, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (34, 17, 'Produit3', 10,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (35, 17, 'Produit6', 2, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (36, 17, 'Produit4', 5, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (37, 17, 'Produit1', 10,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (38, 18, 'Produit4', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (39, 18, 'Produit1', 8, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (40, 18, 'Produit3', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (41, 18, 'Produit2', 1, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (42, 19, 'Produit5', 8, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (43, 20, 'Produit1', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (44, 20, 'Produit4', 5, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (45, 20, 'Produit3', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (46, 21, 'Produit4', 5, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (47, 21, 'Produit7', 7, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (48, 22, 'Produit9', 3, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (49, 22, 'Produit1', 7, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (50, 22, 'Produit2', 9, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (51, 22, 'Produit6', 7, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (52, 22, 'Produit9', 4, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (53, 23, 'Produit0', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (54, 23, 'Produit8', 9, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (55, 23, 'Produit9', 10,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (56, 24, 'Produit9', 1, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (57, 24, 'Produit8', 4, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (58, 24, 'Produit5', 4, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (59, 25, 'Produit0', 1, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (60, 25, 'Produit6', 10,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (61, 26, 'Produit7', 8, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (62, 27, 'Produit1', 1, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (63, 27, 'Produit4', 7, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (64, 28, 'Produit5', 4, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (65, 28, 'Produit3', 9, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (66, 29, 'Produit9', 2, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (67, 29, 'Produit2', 9, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (68, 29, 'Produit6', 4, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (69, 30, 'Produit0', 8, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (70, 31, 'Produit3', 8, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (71, 31, 'Produit0', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (72, 32, 'Produit3', 7, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (73, 32, 'Produit5', 8, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (74, 32, 'Produit2', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (75, 32, 'Produit1', 5, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (76, 33, 'Produit0', 9, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (77, 33, 'Produit6', 9, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (78, 33, 'Produit3', 7, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (79, 34, 'Produit5', 10,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (80, 35, 'Produit2', 8, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (81, 36, 'Produit3', 10,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (82, 37, 'Produit6', 7, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (83, 37, 'Produit1', 2, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (84, 38, 'Produit1', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (85, 38, 'Produit2', 7, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (86, 39, 'Produit1', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (87, 39, 'Produit7', 9, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (88, 40, 'Produit6', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (89, 40, 'Produit3', 3, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (90, 41, 'Produit8', 5, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (91, 41, 'Produit6', 4, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (92, 42, 'Produit1', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (93, 42, 'Produit5', 8, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (94, 43, 'Produit4', 10,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (95, 43, 'Produit3', 8, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (96, 44, 'Produit4', 10,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (97, 44, 'Produit2', 5, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (98, 44, 'Produit9', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (99, 44, 'Produit0', 3, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (100, 44, 'Produit6', 4,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (101, 45, 'Produit0', 3,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (102, 45, 'Produit6', 2,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (103, 45, 'Produit5', 10,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (104, 45, 'Produit7', 5, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (105, 46, 'Produit4', 3, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (106, 46, 'Produit9', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (107, 46, 'Produit5', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (108, 46, 'Produit3', 8, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (109, 46, 'Produit2', 2, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (110, 47, 'Produit6', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (111, 47, 'Produit8', 6, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (112, 47, 'Produit9', 10,0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (113, 47, 'Produit1', 2, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (114, 47, 'Produit3', 7, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (115, 48, 'Produit4', 9, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (116, 48, 'Produit2', 5, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (117, 48, 'Produit3', 7, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (118, 48, 'Produit5', 9, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (119, 48, 'Produit9', 7, 0);
INSERT INTO commande_ligne (id, commande_id, nom_produit, quantite, prix_total) VALUES (120, 48, 'Produit6', 4, 0);
COMMIT;

