--TP5

--Dans terminal :

--/opt/Studio/TOS_ESB-linux-gtk-x86_64

--Exercice 1

--a)    
SELECT * FROM DEPARTEMENT;

/*
Product	new york 	Jackson
Human Resource	dallas	solene
*/

SELECT * FROM EMPLOYEE;
/*
Billy	Stewart	billystewart31889@slingacademy.com	745-157-5520	male	Product	Tester	4	8000
Terry	Parker	terryparker32794@slingacademy.com	255.599.0102	male	Product	Mobile Developer	13	13500
Robert	Hogan	roberthogan33285@slingacademy.com	1138662041	male	Human Resource	HR Manager	5	9500
Dawn	Pham	dawnpham34617@slingacademy.com	(106)836-9118x102	female	Product	Web Developer	14	14000
Karen	Duke	karenduke35417@slingacademy.com	622.245.2756	female	Product	DevOps Engineer	6	10000
Julian	Thompson	julianthompson36557@slingacademy.com	392.181.9671x23227	male	Product	Project Manager	9	13500
David	Perry	davidperry37212@slingacademy.com	+1-921-685-9612x0086	male	Product	Machine Learning Engineer	11	13500
Samuel	Smith	samuelsmith38630@slingacademy.com	(110)771-1347x58805	male	Product	Machine Learning Engineer	3	9500
Eric	Randolph	ericrandolph39871@slingacademy.com	001-048-278-1814x8904	male	Product	DevOps Engineer	1	8500
Vanessa	Keller	vanessakeller40877@slingacademy.com	903-521-4220x53915	female	Human Resource	HR Manager	6	9000
Gail	Salas	gailsalas41287@slingacademy.com	088.890.2450x1927	female	Product	Mobile Developer	4	7000
Alexander	Archer	alexanderarcher42883@slingacademy.com	001-335-037-7267x43704	male	Product	Machine Learning Engineer	2	9000
Claire	Wagner	clairewagner43632@slingacademy.com	001-038-830-2184x508	female	Product	Designer	12	14000
Cynthia	Howard	cynthiahoward44250@slingacademy.com	(940)475-4836	female	Product	Project Manager	6	11000
Brett	Friedman	brettfriedman45278@slingacademy.com	+1-548-885-3476x195	male	Human Resource	HR Manager	15	13500
Shaun	Harris	shaunharris46949@slingacademy.com	(279)621-2475	male	Product	Web Developer	6	8000
Jason	Morris	jasonmorris47690@slingacademy.com	001-588-064-2677x4053	male	Product	Designer	13	13500
Jesse	Mcdaniel	jessemcdaniel48658@slingacademy.com	600-434-1206x901	male	Product	Tester	12	13000
Jeffrey	Torres	jeffreytorres49247@slingacademy.com	547-005-1763x2506	male	Human Resource	HR Manager	5	7500
Bradley	Garcia	bradleygarcia50717@slingacademy.com	(267)794-5965	male	Product	Machine Learning Engineer	8	12000
Brooke	Walker	brookewalker51550@slingacademy.com	954.740.2159	female	Product	Mobile Developer	6	9000
Jennifer	Boyd	jenniferboyd52833@slingacademy.com	001-199-903-4307x52539	female	Product	Mobile Developer	15	13500
Daniel	Cooper	danielcooper53864@slingacademy.com	001-075-516-4089x887	male	Product	Tester	10	11000
Kevin	Robinson	kevinrobinson54477@slingacademy.com	989.611.2546	male	Product	Designer	9	12500
Tiffany	Novak	tiffanynovak55904@slingacademy.com	528-213-5280x73418	female	Product	Machine Learning Engineer	13	11500
Sophia	Coleman	sophiacoleman56149@slingacademy.com	101.121.4803x8420	female	Product	Web Developer	12	11000
Jodi	Harris	jodiharris57674@slingacademy.com	001-466-805-0485	female	Product	DevOps Engineer	5	11500
Melissa	Calhoun	melissacalhoun58456@slingacademy.com	001-931-707-3027	female	Product	DevOps Engineer	1	9500
Aaron	Tran	aarontran59100@slingacademy.com	+1-121-704-1976x1624	male	Product	Web Developer	6	9000
John	Aguirre	johnaguirre60609@slingacademy.com	+1-159-954-5997x959	male	Product	Mobile Developer	5	8500
David	Morrison	davidmorrison61323@slingacademy.com	001-256-780-2930x98623	male	Human Resource	HR Manager	5	7500
Amanda	Thomas	amandathomas62534@slingacademy.com	001-629-462-1944	female	Product	DevOps Engineer	14	14000
Samuel	Spencer	samuelspencer63121@slingacademy.com	(025)089-0360	male	Product	Web Developer	5	8500
Jessica	Ho	jessicaho64167@slingacademy.com	251-289-1532	female	Product	Mobile Developer	6	9000
Justin	Rhodes	justinrhodes65742@slingacademy.com	001-482-958-2236x124	male	Human Resource	HR Manager	14	14000
Kim	Hobbs	kimhobbs66159@slingacademy.com	114.830.3568x128	female	Product	Mobile Developer	10	11000
Allison	Matthews	allisonmatthews67968@slingacademy.com	(394)302-9258	female	Product	Tester	7	10500
James	Phillips	jamesphillips68644@slingacademy.com	(733)967-0336	male	Human Resource	HR Manager	15	12500
Philip	Thomas	philipthomas69550@slingacademy.com	592-756-5695x9778	male	Product	Machine Learning Engineer	13	14500
David	Walker	davidwalker70948@slingacademy.com	+1-173-846-6935x7118	male	Product	Tester	14	13000
Donald	Lopez	donaldlopez71596@slingacademy.com	597.328.1460	male	Product	Tester	5	9500
Hannah	House	hannahhouse72251@slingacademy.com	1541376919	female	Product	Mobile Developer	1	7500
Stephen	Diaz	stephendiaz73743@slingacademy.com	110.987.1187x01990	male	Product	Web Developer	14	13000
Barbara	Burns	barbaraburns74775@slingacademy.com	001-724-808-4339x05491	female	Product	Designer	5	10500
Jessica	Cortez	jessicacortez75618@slingacademy.com	768.794.6062	female	Product	Machine Learning Engineer	8	11000
Daniel	Hernandez	danielhernandez76877@slingacademy.com	+1-653-006-3659	male	Product	Mobile Developer	4	9000
Eugene	Diaz	eugenediaz77404@slingacademy.com	625.556.6039x715	male	Product	DevOps Engineer	12	13000
Nicole	Aguilar	nicoleaguilar173533@slingacademy.com	(114)183-5226x2535	female	Product	Web Developer	9	11500
Michael	Lee	michaellee174890@slingacademy.com	262-107-4732	male	Product	Web Developer	2	7000
Brett	Cochran	brettcochran175230@slingacademy.com	+1-248-824-7621	male	Product	Mobile Developer	14	13000
Manuel	Carpenter	manuelcarpenter176804@slingacademy.com	9008123667	male	Product	Web Developer	1	5500
John	Wilson	johnwilson177384@slingacademy.com	+1-671-886-0776x042	male	Product	DevOps Engineer	4	9000
Martin	Crawford	martincrawford178676@slingacademy.com	001-938-266-9979x463	male	Product	Web Developer	7	9500
Daniel	Peterson	danielpeterson179429@slingacademy.com	240.063.9329x8093	male	Product	Mobile Developer	10	10000
Emily	Lambert	emilylambert180288@slingacademy.com	710-838-5229	female	Product	Web Developer	10	12000
Marcia	Huerta	marciahuerta181481@slingacademy.com	001-611-947-0019x85361	female	Product	Mobile Developer	11	11500
Jason	Ortiz	jasonortiz182684@slingacademy.com	+1-614-334-4322x00332	male	Product	Web Developer	1	7500
Lacey	Thomas	laceythomas183301@slingacademy.com	001-214-721-0561x945	female	Product	Web Developer	4	7000
Sarah	Freeman	sarahfreeman184184@slingacademy.com	786.837.6975x132	female	Product	Mobile Developer	3	8500
Michael	Galvan	michaelgalvan185193@slingacademy.com	+1-122-284-2113	male	Product	Web Developer	11	10500
Melissa	Warner	melissawarner186807@slingacademy.com	790-287-4075	female	Product	Mobile Developer	7	10500
Larry	Thompson	larrythompson187441@slingacademy.com	001-227-811-0040x004	male	Product	Mobile Developer	13	13500
Earl	Nelson	earlnelson78381@slingacademy.com	001-666-637-1061	male	Product	Web Developer	4	7000
Elizabeth	Jackson	elizabethjackson79993@slingacademy.com	129-182-2223x8234	female	Product	Machine Learning Engineer	4	10000
John	Martinez	johnmartinez80422@slingacademy.com	001-116-711-6587	male	Product	Web Developer	9	9500
Tricia	Shaw	triciashaw81242@slingacademy.com	0250878834	female	Product	Web Developer	10	10000
Michael	Davila	michaeldavila82245@slingacademy.com	9179864827	male	Product	Web Developer	1	5500
Heidi	Hill	heidihill83731@slingacademy.com	+1-480-021-8701x17016	female	Product	DevOps Engineer	9	12500
Yvonne	Bass	yvonnebass84561@slingacademy.com	+1-872-139-6739x9455	female	Product	Mobile Developer	12	12000
James	Jones	jamesjones85233@slingacademy.com	001-039-712-8015	male	Product	Tester	15	13500
Brady	Washington	bradywashington86983@slingacademy.com	(720)496-1780x5033	male	Product	DevOps Engineer	7	10500
Michael	Rivera	michaelrivera87445@slingacademy.com	243-399-1129	male	Product	Web Developer	15	13500
Angela	Morales	angelamorales88984@slingacademy.com	(340)684-6223x44918	female	Product	Machine Learning Engineer	15	15500
Larry	Moore	larrymoore89350@slingacademy.com	320.169.9790x514	male	Product	Machine Learning Engineer	4	10000
William	Oliver	williamoliver90297@slingacademy.com	629-088-9248x536	male	Product	Machine Learning Engineer	4	10000
Clayton	Smith	claytonsmith91135@slingacademy.com	8318062400	male	Product	Mobile Developer	6	10000
Thomas	Randall	thomasrandall92365@slingacademy.com	001-483-384-8547x78248	male	Product	Mobile Developer	14	14000
Amy	Vaughn	amyvaughn93806@slingacademy.com	542.795.3600x28212	female	Product	Designer	8	11000
Larry	Chapman	larrychapman94987@slingacademy.com	001-539-747-0649	male	Product	Machine Learning Engineer	2	8000
Eugene	Mcintyre	eugenemcintyre95732@slingacademy.com	481-160-8125	male	Product	Designer	9	9500
Patricia	Suarez	patriciasuarez96157@slingacademy.com	(674)788-1168x659	female	Product	Machine Learning Engineer	12	12000
Michael	Vasquez	michaelvasquez97570@slingacademy.com	490-884-4764	male	Product	Web Developer	3	6500
Stephanie	Hodges	stephaniehodges98474@slingacademy.com	001-651-909-2654x62888	female	Product	Web Developer	14	13000
Ashley	Watkins	ashleywatkins99733@slingacademy.com	2648820032	female	Product	Machine Learning Engineer	1	8500
Yolanda	Ellis	yolandaellis100435@slingacademy.com	+1-485-616-5391x8807	female	Product	Tester	14	14000
Margaret	Maxwell	margaretmaxwell101973@slingacademy.com	137-430-7223	female	Product	DevOps Engineer	6	10000
Jill	Farmer	jillfarmer102650@slingacademy.com	0571661198	female	Product	Designer	3	8500
Robert	Park	robertpark103408@slingacademy.com	498-878-6219	male	Product	Mobile Developer	8	10000
Jeffrey	Park	jeffreypark104773@slingacademy.com	874-348-4705	male	Product	Machine Learning Engineer	8	10000
Lacey	Bender	laceybender105454@slingacademy.com	001-243-891-5674x423	female	Product	Mobile Developer	11	12500
Amanda	Silva	amandasilva106678@slingacademy.com	3782883279	female	Product	Mobile Developer	7	8500
John	Escobar	johnescobar107702@slingacademy.com	661.598.4267x044	male	Product	DevOps Engineer	9	12500
Scott	Woods	scottwoods108925@slingacademy.com	(084)639-6565x41150	male	Product	Machine Learning Engineer	13	11500
Beth	Solis	bethsolis109189@slingacademy.com	+1-654-849-0805x279	female	Product	Designer	15	14500
Natasha	Johnson	natashajohnson110884@slingacademy.com	+1-538-767-6692x1656	female	Product	DevOps Engineer	1	9500
Nathan	Oconnor	nathanoconnor111555@slingacademy.com	189.488.8815x56036	male	Product	Tester	1	5500
Felicia	Fox	feliciafox112543@slingacademy.com	001-231-826-1761x9193	female	Product	DevOps Engineer	2	8000
Paul	Davis	pauldavis113585@slingacademy.com	+1-352-114-7038x011	male	Product	Mobile Developer	14	14000
Hannah	Kirk	hannahkirk114686@slingacademy.com	(622)794-0249x585	female	Product	Tester	12	12000
Ashley	Carrillo	ashleycarrillo115254@slingacademy.com	001-097-500-5888	female	Product	Mobile Developer	10	10000
Anna	White	annawhite116266@slingacademy.com	+1-197-659-8290x36913	female	Product	Web Developer	14	14000
Kimberly	Miles	kimberlymiles117171@slingacademy.com	+1-810-231-0550	female	Product	Mobile Developer	11	11500
Gabriel	Shannon	gabrielshannon118302@slingacademy.com	001-435-888-3180x25244	male	Product	Tester	15	14500
Charles	Chan	charleschan119853@slingacademy.com	077-570-4283	male	Product	Tester	5	9500
Steven	Hill	stevenhill120389@slingacademy.com	(765)304-0263x230	male	Product	Designer	6	11000
Brian	Kelly	briankelly121627@slingacademy.com	+1-029-019-2206x665	male	Product	Designer	5	9500
Thomas	Lopez	thomaslopez122447@slingacademy.com	573-472-7131	male	Product	DevOps Engineer	3	8500
Lisa	Edwards	lisaedwards123575@slingacademy.com	536.588.4331	female	Product	DevOps Engineer	15	14500
Sarah	Young	sarahyoung124710@slingacademy.com	001-105-720-6802x583	female	Product	Designer	1	5500
Rebecca	Crawford	rebeccacrawford125255@slingacademy.com	(450)663-6253x153	female	Product	Tester	9	10500
Kevin	Sullivan	kevinsullivan126732@slingacademy.com	161.488.4614x1551	male	Product	Designer	12	15000
Amanda	Carey	amandacarey127761@slingacademy.com	4267904671	female	Product	Tester	12	11000
Rachel	Sawyer	rachelsawyer128897@slingacademy.com	(485)441-3528	female	Product	DevOps Engineer	13	14500
Garrett	Nguyen	garrettnguyen129742@slingacademy.com	+1-370-218-5389x8154	male	Product	Mobile Developer	4	8000
Chelsea	Zuniga	chelseazuniga130347@slingacademy.com	911.596.7824x40746	female	Product	Mobile Developer	14	14000
James	Johnson	jamesjohnson131587@slingacademy.com	358.400.3210	male	Product	DevOps Engineer	9	13500
James	Ruiz	jamesruiz132283@slingacademy.com	001-015-657-5863x0258	male	Product	Mobile Developer	3	8500
Brandi	Evans	brandievans133981@slingacademy.com	(388)123-2730x36223	female	Product	Mobile Developer	8	11000
Jennifer	Obrien	jenniferobrien134396@slingacademy.com	001-576-701-2547	female	Product	Web Developer	13	13500
Whitney	Espinoza	whitneyespinoza135463@slingacademy.com	(395)465-0024x542	female	Product	Mobile Developer	5	7500
Brandon	Rosario	brandonrosario136262@slingacademy.com	5804460236	male	Product	Tester	14	13000
Jason	Rhodes	jasonrhodes137652@slingacademy.com	+1-182-210-6837x27845	male	Product	DevOps Engineer	7	11500
Jesse	Michael	jessemichael138774@slingacademy.com	(372)150-9511	male	Product	Web Developer	9	10500
James	Knight	jamesknight139805@slingacademy.com	325.002.8388x1091	male	Product	DevOps Engineer	7	12500
Michelle	Ramirez	michelleramirez140860@slingacademy.com	923.789.8867x807	female	Product	Machine Learning Engineer	10	12000
Peter	Mercado	petermercado141743@slingacademy.com	890-585-7726x64628	male	Product	DevOps Engineer	4	9000
Jason	George	jasongeorge142280@slingacademy.com	001-431-125-6069	male	Product	Mobile Developer	3	6500
Katherine	Arroyo	katherinearroyo143289@slingacademy.com	6849186207	female	Product	Machine Learning Engineer	8	12000
Ashley	Mccann	ashleymccann144205@slingacademy.com	001-197-825-7624x4162	female	Product	Mobile Developer	12	13000
Katherine	Robinson	katherinerobinson145289@slingacademy.com	(200)221-4696	female	Product	Machine Learning Engineer	5	9500
Michael	Clark	michaelclark146499@slingacademy.com	(726)898-3126x779	male	Product	DevOps Engineer	5	10500
Julia	Howe	juliahowe147906@slingacademy.com	270-885-8330x203	female	Product	Mobile Developer	8	11000
Karen	Roy	karenroy148650@slingacademy.com	001-579-003-5317x80657	female	Product	Mobile Developer	1	7500
Nicole	Nguyen	nicolenguyen149314@slingacademy.com	(601)907-3624x42015	female	Product	Tester	7	8500
Chelsea	Lewis	chelsealewis150296@slingacademy.com	406-096-8891x1387	female	Product	Web Developer	12	13000
Austin	Bell	austinbell151200@slingacademy.com	819-364-7742x938	male	Product	Web Developer	13	11500
Paul	Allen	paulallen152129@slingacademy.com	2104766565	male	Product	Mobile Developer	14	12000
Felicia	Oliver	feliciaoliver153838@slingacademy.com	001-307-413-8100	female	Product	Tester	7	10500
Diana	Bowers	dianabowers154941@slingacademy.com	(472)461-2314	female	Product	DevOps Engineer	10	14000
Cody	Peters	codypeters155175@slingacademy.com	+1-538-563-4682x108	male	Product	Tester	7	8500
Bethany	Gonzalez	bethanygonzalez156478@slingacademy.com	001-671-656-9205	female	Product	DevOps Engineer	9	13500
Shane	Benson	shanebenson157228@slingacademy.com	001-433-182-3042x4134	male	Product	Web Developer	8	10000
Jacqueline	Brooks	jacquelinebrooks158705@slingacademy.com	803-716-9920	female	Product	DevOps Engineer	5	9500
Vanessa	Turner	vanessaturner159112@slingacademy.com	611.777.0181	female	Product	Web Developer	2	8000
Lisa	Logan	lisalogan160514@slingacademy.com	631.001.6670x895	female	Product	Mobile Developer	3	7500
Jessica	Jones	jessicajones161720@slingacademy.com	001-510-870-8941x9602	female	Product	Mobile Developer	3	8500
Sarah	Li	sarahli162806@slingacademy.com	001-609-806-7966x06117	female	Product	Mobile Developer	4	7000
Brenda	Roberson	brendaroberson163933@slingacademy.com	001-589-932-4079	female	Product	Web Developer	7	9500
Brett	Hernandez	bretthernandez164285@slingacademy.com	502-552-5808	male	Product	DevOps Engineer	8	12000
Wanda	Forbes	wandaforbes165726@slingacademy.com	666-855-7253x02322	female	Product	DevOps Engineer	8	13000
Elizabeth	Cortez	elizabethcortez166121@slingacademy.com	675.301.0657x798	female	Product	Web Developer	11	12500
Sean	Smith	seansmith167370@slingacademy.com	(485)519-9948x286	male	Product	Web Developer	13	12500
Shawn	Oliver	shawnoliver168229@slingacademy.com	(104)702-6330	male	Product	Web Developer	1	5500
Eric	Moses	ericmoses169919@slingacademy.com	+1-443-662-4948x52464	male	Product	DevOps Engineer	3	9500
Jeanette	Ruiz	jeanetteruiz170586@slingacademy.com	001-589-861-6693x6009	female	Product	Web Developer	4	7000
John	Barber	johnbarber171149@slingacademy.com	600.551.1953x989	male	Product	Mobile Developer	9	11500
Caleb	Mcpherson	calebmcpherson172782@slingacademy.com	+1-373-821-4858x946	male	Product	Web Developer	7	9500
Jose	Lopez	joselopez0194@slingacademy.com	+1-971-533-4552x1542	male	Product	Web Developer	2	6000
Diane	Carter	dianecarter1345@slingacademy.com	881.633.0107	female	Human Resource	HR Manager	13	11500
Sherry	Foster	sherryfoster2572@slingacademy.com	001-966-861-0065x493	female	Product	Tester	8	11000
Brenda	Fisher	brendafisher3114@slingacademy.com	001-574-564-4648	female	Product	Project Manager	14	17000
Sharon	Hunter	sharonhunter4898@slingacademy.com	5838355842	female	Product	Machine Learning Engineer	7	10500
Kimberly	Jacobs	kimberlyjacobs5924@slingacademy.com	053-913-2609	female	Product	Tester	6	9000
Brianna	Marshall	briannamarshall6448@slingacademy.com	701-932-8553	female	Product	Mobile Developer	3	7500
Karen	Tate	karentate7771@slingacademy.com	001-889-992-5260x62725	female	Product	Web Developer	5	7500
Jillian	Byrd	jillianbyrd8138@slingacademy.com	077-635-0084x1647	female	Product	Web Developer	14	13000
Michael	Sharp	michaelsharp9813@slingacademy.com	(848)212-0230	male	Product	Project Manager	12	16000
Chad	Mckee	chadmckee10225@slingacademy.com	001-085-315-6112x464	male	Product	Mobile Developer	9	9500
Robert	Simpson	robertsimpson11340@slingacademy.com	496-469-5331x659	male	Product	Mobile Developer	1	6500
George	Mckenzie	georgemckenzie12490@slingacademy.com	(843)416-2489	male	Product	Designer	15	15500
Kelly	Smith	kellysmith13393@slingacademy.com	+1-380-230-4166	female	Human Resource	HR Manager	12	11000
David	Crawford	davidcrawford14904@slingacademy.com	(848)716-0019x0240	male	Product	Machine Learning Engineer	7	11500
Carrie	Benson	carriebenson15369@slingacademy.com	+1-368-801-2914x8616	female	Product	DevOps Engineer	10	13000
Nicole	Smith	nicolesmith16537@slingacademy.com	289.372.5080x2156	female	Product	Machine Learning Engineer	8	12000
Nicole	Jimenez	nicolejimenez17569@slingacademy.com	001-535-827-3787x317	female	Product	Machine Learning Engineer	13	11500
Sheila	Boyle	sheilaboyle18433@slingacademy.com	3027626274	female	Product	DevOps Engineer	9	13500
Brianna	Moss	briannamoss19877@slingacademy.com	+1-529-287-4857x163	female	Product	Designer	9	10500
Taylor	Garner	taylorgarner20845@slingacademy.com	931-244-1612x38767	female	Product	DevOps Engineer	2	8000
Michael	Padilla	michaelpadilla21474@slingacademy.com	(787)446-1738	male	Product	Designer	14	12000
Yvette	Walker	yvettewalker22675@slingacademy.com	154-489-0248	female	Product	Mobile Developer	3	8500
Justin	Pena	justinpena23576@slingacademy.com	+1-099-174-5458x294	male	Product	Machine Learning Engineer	7	10500
Vanessa	Reynolds	vanessareynolds24161@slingacademy.com	+1-357-911-9617x44729	female	Product	Mobile Developer	7	10500
Rebecca	Suarez	rebeccasuarez25205@slingacademy.com	+1-121-053-2698x314	female	Product	Web Developer	7	8500
Thomas	Ellis	thomasellis26289@slingacademy.com	029.476.5817x88014	male	Human Resource	HR Manager	2	8000
Samantha	Porter	samanthaporter27174@slingacademy.com	+1-508-187-4826	female	Product	Mobile Developer	10	10000
Danielle	Reyes	daniellereyes28875@slingacademy.com	(725)355-0896x3876	female	Product	Web Developer	15	13500
Brian	Kirby	briankirby29151@slingacademy.com	458.110.0220x9710	male	Product	Project Manager	14	16000
Tammy	Walker	tammywalker30764@slingacademy.com	+1-810-034-9706x602	female	Product	Mobile Developer	14	14000
Janice	Miller	janicemiller188354@slingacademy.com	(124)599-3895x76772	female	Product	DevOps Engineer	4	11000
Jasmine	Steele	jasminesteele189528@slingacademy.com	839-171-3582x4182	female	Product	DevOps Engineer	8	11000
Joseph	Beck	josephbeck190391@slingacademy.com	+1-621-014-2831x0646	male	Product	Mobile Developer	5	7500
Tracy	Cohen	tracycohen191613@slingacademy.com	(304)813-7854x1708	female	Product	DevOps Engineer	15	16500
Bryan	Reilly	bryanreilly192644@slingacademy.com	607.511.9983x28152	male	Product	Mobile Developer	3	8500
Zachary	Smith	zacharysmith193685@slingacademy.com	(407)091-5393x213	male	Product	DevOps Engineer	1	9500
Jon	Leblanc	jonleblanc194743@slingacademy.com	401-896-0371x40763	male	Product	Web Developer	8	9000
Christina	Garza	christinagarza195368@slingacademy.com	273-987-3115	female	Product	Web Developer	12	11000
Jason	Jarvis	jasonjarvis196518@slingacademy.com	063-012-6389x05736	male	Product	Web Developer	10	10000
Jesse	Smith	jessesmith197985@slingacademy.com	+1-701-460-3317x90916	male	Product	DevOps Engineer	2	9000
Melissa	Richardson	melissarichardson198853@slingacademy.com	001-296-935-6456x91442	female	Product	Mobile Developer	7	8500
Michele	Stewart	michelestewart199290@slingacademy.com	944.042.1529	female	Product	Mobile Developer	13	12500
Jill	Gilbert	jillgilbert200959@slingacademy.com	970-269-2119x437	female	Product	DevOps Engineer	14	14000
Kevin	Valentine	kevinvalentine201334@slingacademy.com	+1-399-375-1890x40884	male	Product	Web Developer	9	9500
Thomas	Hurst	thomashurst202903@slingacademy.com	2176055492	male	Product	Mobile Developer	3	7500
Janet	Stephens	janetstephens203291@slingacademy.com	696-753-3875	female	Product	Web Developer	10	11000
Megan	Hoover	meganhoover204258@slingacademy.com	(791)222-1972x3424	female	Product	Web Developer	8	10000
Susan	Jones	susanjones205164@slingacademy.com	905.333.2209x0122	female	Product	Web Developer	11	10500
Breanna	Love	breannalove206450@slingacademy.com	(251)970-0774x9187	female	Product	Web Developer	11	12500
Elijah	Mcguire	elijahmcguire207554@slingacademy.com	430.390.1485x7262	male	Product	Mobile Developer	2	7000
Philip	Bell	philipbell208998@slingacademy.com	930-636-6697x67326	male	Product	Web Developer	6	8000
Kevin	Logan	kevinlogan209795@slingacademy.com	001-449-766-2057	male	Product	Web Developer	11	11500
Erin	Watson	erinwatson210121@slingacademy.com	001-099-534-3868x24842	female	Product	Mobile Developer	15	12500
Austin	Miller	austinmiller211536@slingacademy.com	(902)165-6805	male	Product	Web Developer	2	8000
Sonya	Anderson	sonyaanderson212407@slingacademy.com	730-398-8945	female	Product	Mobile Developer	9	9500
Francisco	Montgomery	franciscomontgomery213734@slingacademy.com	(412)713-8016x79949	male	Product	Mobile Developer	1	5500
Michelle	Olson	michelleolson214829@slingacademy.com	+1-352-025-4146x308	female	Product	Web Developer	7	8500
Brenda	Leonard	brendaleonard215769@slingacademy.com	(451)560-3184x350	female	Product	Web Developer	5	9500
Ross	Scott	rossscott216231@slingacademy.com	420.609.2090	male	Product	Mobile Developer	4	7000
Terry	Jackson	terryjackson217103@slingacademy.com	(217)802-5632x0440	male	Product	Web Developer	7	10500
John	Palmer	johnpalmer218467@slingacademy.com	(206)349-1934x449	male	Product	Web Developer	4	7000
Brenda	Tapia	brendatapia219700@slingacademy.com	989-757-9111	female	Product	Web Developer	3	6500
Donald	Gordon	donaldgordon220435@slingacademy.com	004.508.2105	male	Product	Mobile Developer	12	13000
Danielle	Long	daniellelong221167@slingacademy.com	095.663.3357	female	Product	Mobile Developer	12	11000
Michael	Pratt	michaelpratt222722@slingacademy.com	001-149-139-6964	male	Product	Mobile Developer	14	12000
Jeffrey	West	jeffreywest223814@slingacademy.com	140.721.9576x9819	male	Product	Mobile Developer	2	7000
Danielle	Jennings	daniellejennings224357@slingacademy.com	313.810.6293x369	female	Product	Mobile Developer	12	11000
Alex	Perry	alexperry225459@slingacademy.com	311-298-4100	male	Product	Web Developer	1	5500
John	Marsh	johnmarsh226221@slingacademy.com	001-710-599-6824x74838	male	Product	Web Developer	12	13000
Richard	Holder	richardholder227402@slingacademy.com	+1-977-600-1087x6268	male	Product	Mobile Developer	1	7500
Ryan	Ponce	ryanponce228238@slingacademy.com	5497597305	male	Product	Mobile Developer	13	12500
Dorothy	Riley	dorothyriley229310@slingacademy.com	+1-976-524-6785	female	Product	Mobile Developer	1	7500
Yvette	Scott	yvettescott230489@slingacademy.com	543-674-1419x7292	female	Product	Mobile Developer	11	11500
Kenneth	Nelson	kennethnelson231147@slingacademy.com	947.820.6507x32405	male	Product	Web Developer	15	14500
Edgar	Lane	edgarlane232749@slingacademy.com	5537213761	male	Product	Web Developer	7	10500
Jeremy	Cox	jeremycox233376@slingacademy.com	+1-155-126-0581x524	male	Product	Web Developer	13	13500
Robert	Hernandez	roberthernandez234672@slingacademy.com	767-860-5296	male	Product	Mobile Developer	7	10500
Brian	Gilbert	briangilbert235994@slingacademy.com	+1-414-913-8588x9103	male	Product	Web Developer	9	10500
Sherri	Shaw	sherrishaw236714@slingacademy.com	919-763-5353	female	Product	Mobile Developer	6	10000
Sarah	Davis	sarahdavis237584@slingacademy.com	(778)856-1719x931	female	Product	Web Developer	1	5500
Kristin	Bradley	kristinbradley238778@slingacademy.com	(402)457-2111	female	Product	Web Developer	2	6000
Brooke	Drake	brookedrake239487@slingacademy.com	659-857-8858	female	Product	Mobile Developer	9	11500
Kristina	Clark	kristinaclark240837@slingacademy.com	094.521.1972x38513	female	Product	Mobile Developer	14	13000
Scott	Owens	scottowens241396@slingacademy.com	487.884.3426x95702	male	Product	Mobile Developer	9	9500
Robert	Nelson	robertnelson242936@slingacademy.com	+1-319-257-8912x87517	male	Product	Web Developer	13	12500
Erin	Green	eringreen243342@slingacademy.com	765-014-8238x735	female	Product	Mobile Developer	6	8000
Paul	Page	paulpage244406@slingacademy.com	001-548-349-5980x11429	male	Product	Mobile Developer	15	12500
Jamie	Ball	jamieball245269@slingacademy.com	001-521-608-0441	female	Product	Mobile Developer	8	9000
Sonya	Williams	sonyawilliams246273@slingacademy.com	001-534-324-6100x2516	female	Product	Mobile Developer	8	9000
Leslie	Burton	leslieburton247848@slingacademy.com	279-096-0603	female	Product	Mobile Developer	4	8000
Daniel	Joseph	danieljoseph248248@slingacademy.com	101-113-1630x442	male	Product	Web Developer	1	6500
John	Grimes	johngrimes249952@slingacademy.com	671-825-5709	male	Product	Mobile Developer	4	7000
Melissa	Davis	melissadavis250431@slingacademy.com	771.340.7743x808	female	Product	Web Developer	9	10500
Sierra	Hoover	sierrahoover251989@slingacademy.com	001-012-427-6550	female	Product	Mobile Developer	6	9000
Damon	Sanders	damonsanders252842@slingacademy.com	0176247153	male	Product	Mobile Developer	3	8500
Adam	Pratt	adampratt253430@slingacademy.com	829.922.4683	male	Product	Web Developer	15	14500
Jesse	Gonzalez	jessegonzalez254466@slingacademy.com	853.691.9747	male	Product	Mobile Developer	5	9500
Debra	Cruz	debracruz255561@slingacademy.com	481.706.7985x840	female	Product	Mobile Developer	3	6500
Gregory	Smith	gregorysmith256659@slingacademy.com	+1-044-346-7655x68675	male	Product	Mobile Developer	11	11500
Patrick	Cook	patrickcook257408@slingacademy.com	975-551-0070	male	Product	Mobile Developer	12	11000
Robert	Weber	robertweber258431@slingacademy.com	018.297.6175x4163	male	Product	Mobile Developer	10	10000
Christopher	Thompson	christopherthompson259741@slingacademy.com	(850)197-6611	male	Product	Web Developer	3	6500
Maureen	Campbell	maureencampbell260141@slingacademy.com	168-469-7587	female	Product	Web Developer	1	7500
Alex	Brown	alexbrown261126@slingacademy.com	259.588.0503x6257	male	Product	Mobile Developer	10	10000
Breanna	Allen	breannaallen262640@slingacademy.com	+1-160-924-8899x786	female	Product	Web Developer	8	9000
Michael	Pearson	michaelpearson263103@slingacademy.com	8006107617	male	Product	Mobile Developer	9	10500
Cheryl	Lewis	cheryllewis264673@slingacademy.com	(806)267-8045	female	Product	Web Developer	8	11000
Michael	Brown	michaelbrown265799@slingacademy.com	596-551-1329	male	Product	Mobile Developer	13	12500
Linda	Haynes	lindahaynes266810@slingacademy.com	331-850-1266x1106	female	Product	Mobile Developer	10	12000
Jonathan	Palmer	jonathanpalmer267693@slingacademy.com	(616)797-1560x17533	male	Product	Mobile Developer	13	13500
Tammy	Ball	tammyball268344@slingacademy.com	8439547062	female	Product	Web Developer	7	8500
Sarah	Reed	sarahreed269446@slingacademy.com	001-177-232-8430x261	female	Product	Web Developer	2	7000
Emily	Page	emilypage270576@slingacademy.com	+1-859-269-6655	female	Product	Mobile Developer	4	9000
Tristan	Price	tristanprice271704@slingacademy.com	001-369-038-1224	male	Product	Mobile Developer	3	7500
Patrick	Skinner	patrickskinner272521@slingacademy.com	+1-655-446-8826x40636	male	Product	Web Developer	15	13500
Nicole	Castro	nicolecastro273650@slingacademy.com	(185)855-4760x61049	female	Product	Web Developer	9	10500
Patrick	Hughes	patrickhughes274295@slingacademy.com	+1-124-853-7387x3710	male	Product	Web Developer	11	11500
Phillip	Herrera	phillipherrera275191@slingacademy.com	400-991-8270x7992	male	Product	Web Developer	5	9500
Gary	Houston	garyhouston276956@slingacademy.com	(487)936-5416x279	male	Product	Mobile Developer	10	10000
Olivia	Johnson	oliviajohnson277656@slingacademy.com	+1-219-520-1055x479	female	Product	Web Developer	4	8000
April	Houston	aprilhouston278529@slingacademy.com	001-825-098-6223x1127	female	Product	Web Developer	13	13500
Adriana	Martinez	adrianamartinez279348@slingacademy.com	910.407.8536x8933	female	Product	Web Developer	11	12500
Victoria	Peters	victoriapeters280664@slingacademy.com	599.847.1624x20379	female	Product	Web Developer	12	13000
Michael	Henderson	michaelhenderson281830@slingacademy.com	373-405-5460x036	male	Product	Web Developer	10	10000
Charles	West	charleswest282833@slingacademy.com	524-024-2894x074	male	Product	Web Developer	15	14500
Rebecca	Jackson	rebeccajackson283153@slingacademy.com	(112)301-1517	female	Product	Web Developer	2	8000
Alec	Maldonado	alecmaldonado284511@slingacademy.com	+1-484-025-5906	male	Product	Web Developer	12	11000
Michael	Edwards	michaeledwards285682@slingacademy.com	4055420736	male	Product	Web Developer	12	12000
John	Hall	johnhall286116@slingacademy.com	067.730.7206x26078	male	Product	Web Developer	13	11500
Kristin	Perry	kristinperry287743@slingacademy.com	275.822.1785x29297	female	Product	Web Developer	13	11500
Kevin	Norton	kevinnorton288890@slingacademy.com	911.635.9394x29045	male	Product	Web Developer	6	10000
Nancy	Soto	nancysoto289573@slingacademy.com	001-774-441-0174x8586	female	Product	Web Developer	10	11000
Michael	Howard	michaelhoward290834@slingacademy.com	6585788235	male	Product	Web Developer	11	10500
Johnny	Green	johnnygreen291978@slingacademy.com	001-923-032-1044x57810	male	Product	Web Developer	1	6500
Lauren	Thompson	laurenthompson292130@slingacademy.com	+1-691-327-2406x73013	female	Product	Web Developer	7	9500
Andrea	Wilson	andreawilson293374@slingacademy.com	628-559-3098x06279	female	Product	Web Developer	7	10500
Stephanie	Vaughn	stephanievaughn294228@slingacademy.com	901.710.4683x57441	female	Product	Web Developer	12	11000
Michael	Tyler	michaeltyler295140@slingacademy.com	785-352-2310	male	Product	Web Developer	14	12000
Richard	Lin	richardlin296948@slingacademy.com	471-829-6568	male	Product	Web Developer	13	13500
Jennifer	Williams	jenniferwilliams297731@slingacademy.com	282.970.3806x592	female	Product	Web Developer	15	14500
Shane	Hubbard	shanehubbard298449@slingacademy.com	421-623-0945x9287	male	Product	Web Developer	2	7000
Shawna	Choi	shawnachoi299997@slingacademy.com	(533)756-8696x245	female	Product	Web Developer	1	7500
Marie	Gross	mariegross300180@slingacademy.com	(634)561-4487x82457	female	Product	Web Developer	4	9000
Wesley	Leon	wesleyleon301409@slingacademy.com	780.596.2863x992	male	Product	Web Developer	7	8500
Stephanie	Peterson	stephaniepeterson302370@slingacademy.com	001-509-989-9496x2175	female	Product	Web Developer	4	7000
Kristin	Webster	kristinwebster303777@slingacademy.com	001-990-293-4626	female	Product	Web Developer	4	7000
Courtney	Stanley	courtneystanley304370@slingacademy.com	625.311.0983x89652	female	Product	Web Developer	11	12500
Tracy	Crawford	tracycrawford305774@slingacademy.com	(477)112-0518	female	Product	Web Developer	4	9000
Danielle	Sparks	daniellesparks306193@slingacademy.com	(670)805-6201x50813	female	Product	Web Developer	6	9000
Cheryl	Rose	cherylrose307548@slingacademy.com	+1-058-620-9983x70605	female	Product	Web Developer	3	7500
Kristina	Mann	kristinamann308826@slingacademy.com	718-998-3978	female	Product	Web Developer	3	8500
Vanessa	Carter	vanessacarter309551@slingacademy.com	(620)811-3763	female	Product	Web Developer	4	9000
Anthony	Colon	anthonycolon310182@slingacademy.com	001-388-080-7123x3000	male	Product	Web Developer	6	10000
Aaron	Holland	aaronholland311364@slingacademy.com	001-527-705-3200x648	male	Product	Web Developer	1	6500
Angela	Anderson	angelaanderson312306@slingacademy.com	(202)724-9857	female	Product	Web Developer	3	8500
Kelsey	Moss	kelseymoss313608@slingacademy.com	206-016-2029	female	Product	Web Developer	9	11500
Maureen	Phillips	maureenphillips314700@slingacademy.com	+1-837-401-4253x976	female	Product	Web Developer	15	13500
Michael	Hooper	michaelhooper315714@slingacademy.com	401.041.6802	male	Product	Web Developer	8	9000
Stephanie	Lewis	stephanielewis316903@slingacademy.com	+1-584-489-5663x896	female	Product	Web Developer	15	13500
Kevin	Rodriguez	kevinrodriguez317301@slingacademy.com	001-511-226-4416x83410	male	Product	Web Developer	3	6500
Adam	Bell	adambell318709@slingacademy.com	+1-426-702-6363x565	male	Product	Web Developer	11	10500
Courtney	Mcdaniel	courtneymcdaniel319582@slingacademy.com	(871)098-2647x80448	female	Product	Web Developer	12	12000
*/