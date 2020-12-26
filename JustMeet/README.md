📋 JustMeet è il progetto realizzato per l'esame di Ingegneria del Software dell'Università di Camerino.

Componenti gruppo:

Sviluppato in:

-Bootstrap (jsp)
-Spring Boot (java)

Descrizione

Il progetto si basa sullo sviluppo di un'applicazione Web che che permetta l’incontro tra persone al fine di svolgere attività cooperative e di squadra.

L’obiettivo del sistema è dunque favorire la creazione di gruppi, amicizie, ed in generale relazioni sociali, tanto ricercate soprattutto dagli studenti appena arrivati in una nuova città o Università.

Gli utenti possono utilizzare la piattaforma per inserire eventi e per richiedere la partecipazione di altri utenti. L'utente autenticato avrà la possibilità di cercare eventi in base alla categoria ed al periodo di manifestazione desiderato, una volta incuriositi potranno decidere di aderire con un click, se dovesse ripensarci, ha la possibilità di farlo nella sessione apposita.

L'utente organizzatore potrà visualizzare i propri eventi, decidere di modificare le caratteristiche dei suddetti, o direttamente di eliminarli.

Prima iterazione (19/11 - 17/12):

-Ideazione --> Analisi dei requisiti, definizione degli attori e relativi casi d'uso (diagrammi), individuazione del core business. -Progettazione --> Sequence diagrams del 10% dei casi d'uso.

Seconda iterazione (17/12 - 9/1):

-Progettazione --> Progettazione degli elementi di rischio, Class diagram della suddetta, rivisitazione di alcuni casi d'uso e sequence diagrams di altri (30%). -Implementazione --> Architettura ed elementi di rischio

Terza iterazione (9/1 - 15/2):

-Progettazione --> Ampliamento Class Diagram, rivisitazione dei sequence diagram dei casi d'uso di rischio -Implementazione --> Ultimazione core business

Quarta iterazione (15/2 - 22/2):

-Implementazione --> Ultimazione casi d'uso non prioritari -Progettazione --> Ultimazione class diagram

Quinta iterazione (22/2 - 7/03)

-Progettazione --> Aggiunta di due casi d'uso secondari + progettazione, aggiornamento class diagram rispetto alle nuove funzionalità ed ai test effettuati -Implementaizione --> Aggiunta di due casi d'uso secondari, miglioramento efficienza associazione N-M (Utenti-Eventi), TEST

Casi d'uso implementati a fine quinta iterazione

Per l'utente non autenticato:

-Autenticazione

Per l'utente autenticato:

-Creazione Evento -Ricerca di eventi esistenti -Visualizzare dettagli Evento -Adesione ad evento -Ritiro adesione ad evento -Controlla adesione eventi -Logout

Per l'organizzatore:

-Aprire lista propri eventi -Visualizzare dettagli eventi -Modificare dati evento -Eliminare Evento
