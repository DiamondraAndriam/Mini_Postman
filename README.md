# Navigateur
    Client web permettant d'obtenir le code html d'une page
    
## A propos
    Il permet d'obtenir selon différentes méthodes de requêtte HTTP une page sous le format html.

- Socket:
    La méthode utilisée constitue à configurer de l'objet Socket à travers le host et le port de l'url fourni par l'utilisateur. Ce sont deux paramètre nécessaire à sa création.
    * Sortie: Elle envoie une requête suivant le protocole HTTP.
    * Entrée: Le serveur envoie une réponse.

- Affichage:
    Utilisation de la librairie javax.swing, code d'affichage généré à l'aide de netbean.

* Remarque:
    La méthode GET et POST sont les plus accessible pour un site web.
    La méthode PUT et DELETE modifie des valeurs du serveurs donc fournissent des status code 405.
    Pour envoyer les query parameters pour la requête, le socket les envoie en header pour la méthode get et en body avec la méthode post.

## Excecution
    Fichier main.Main.class (sous windows)

## Utilisation
    
- Page mini-Postman:
    Page d'accueil pour entrer l'url d'une page dont on veut voir la réponse envoyé.

- Page de réponses:
    On affiche le header et le body de la réponse
    Le preview permet de voir l'état du site en html (sans css et javascript) à l'aide d'EditorPane
    Il affiche également les erreurs

## Exception

- Certains site font une redirection
    Le premier code envoyé est donc une redirection de l'url qui affiche un status code 301 ou 302.
    Il se peut alors que en inputstream du socket, on reçoit 2 réponses en même temps ou n'affiche que l'erreur.

(c) ANDRIAMAMPIANDRA Diamondra Fitiavana ETU001748