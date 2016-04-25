# Proto Sante

Ebauche de site & espace de réflexion

# TODO

Import des librairies
Squelette de l'application
    * Java
    * Html
Page template hello world
Page home
Page video list
Fichiers d'exemples
    * Utilisateurs
    * Vidéos

Intégration Guice
Intégration Thymeleaf

vérifier la disponibilité du nom de domaine, le réserver au besoin
    => domaines en ty ?
accéder aux sources depuis ce poste
chercher comment fonctionne les identifications par faceboox ou google
présenter à Sylvain le modèle "user stories"

# Objectifs

Faire un POC du site proto-sante sur un cas d'utilisation simple:
    - une page d'accueil
    - un écran de connexion
    - une liste de vidéos, chacune accompagnée d'un texte descriptif

# Technologies

* Backend
    * Dropwizard
    * XML Auth
        * email
        * password
    * XML Content
        * title
        * url
        * description
        * tags
* Frontend
    * Thymeleaf
    * Youtube
    * Bootstrap


# Domain model

## Domaine

Proposer périodiquement des contenus sur la santé (vidéos, recettes, ...) à des clients abonnés via l'application web

## Sous domaines

* Abonnement
    * Utilisateur
    * Paiement
    * Administration
* Contenus
    * Vidéos
    * Administration
* Application web
    * Templates
    * Metriques
    * Pages
        * Home
            * Formulaire de login => si le compte n'existe pas, débrancher (lightbox ?) sur l'inscription
        * Visite guidée
            * Vidéos spécifiques / extraits
        * A propos
        * Inscription
            * Utilisation d'un login faceboox / google ?
        * Contenus
            * Dernier contenu
                => Hero page présentant le dernier contenu embedded directement dans la page
            * Vue liste
                => liste de tous les contenus (pagination ?); clic sur un thumbnail ouvre une lightbox avec le contenu
                => moteur de recherche (tags / titre / description)
            * Vue calendrier
                => affichage d'un mois à l'écran; les jours avec des contenus ont le thumbnail; clic sur un thumbnail ouvre une lightbox avec le contenu
        * Profil utilisateur

## Liens entre les pages

* Home -> Inscription, Visite guidé, A propos, Contenus
* Visite guidé -> Inscription, A propos
* Contenus -> Profil utilisateur
* Profil utilisateur -> Contenus

# Modèle de stockage des données

Fichier utilisateur

{
    "users": [
        {
            "firstName": "",
            "lastName": "",
            "age": 20,
            "active": true,
            "email": "",
            "avatar": "url"
        }
    ]
}

Fichier contenus

{
    "videos": [
        {
            "title": "",
            "thumbnail": "url"
            "description": "markdown",
            "tags": [ "", "" ]
            "url": "url",
            "date": ""
        }
    ]
}
