FROM php:fpm-alpine

RUN mkdir -r /opt/iut
RUN useradd iut

ENV nom_utilisateur="fouche"\
    prenom_utilisateur="joffrey"\
    pourcentage_tache11="20"\
    pourcentage_tache12="50"\
    pourcentage_tache21="100"\

RUN chmod 750 /opt/iut
USER iut 
    
    
HEALTHCHECK --interval=60s --timeout=1s \
	    CMD curl -f https://localhost// || exit 1