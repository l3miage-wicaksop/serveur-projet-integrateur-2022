[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=7711988&assignment_repo_type=AssignmentRepo)
# l3m-PI-serveur : Partie serveur du Projet Intégrateur L3 MIAGE 2020-2021
A stub which can easily be deployed to Heroku.

This application supports the [Getting Started with Java on Heroku](https://devcenter.heroku.com/articles/getting-started-with-java) article - check it out.

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

## Membres du  Groupe 9
- CRIVOI Dmitrii
- SEVENIER Jonathan
- NASYROV Takir
- SERZHANOV Nurbek
- TCHANA Franck
- WICAKSONO Pradityo Adi

## Diagramme UML
Durant notre developpement, nous avons eu faites 3 diagrammes:

### Diagramme inital (1er semaine)
<img src="/diagramme/diagrammeFinal.jpg"  >

### 2e diagramme (après le revue metier)
<img src="/diagramme/diagrammeAvecHeritage.jpg" >

### 3e diagramme final
<img src="/diagramme/diagrammeFinal.jpg" >


## API de serveur:
- lien du site: http://projet-integrateur-2022.herokuapp.com
- API Chamis: /api/chamis/
- API Defis: /api/defis/
- API Visites: /api/visites/
- API Arrets: /api/arrets/

## Description de classes des données
Voici les classes des données prises de diagramme Dbeaver
<img src="/diagramme/diagramme_de_classe_des_donnees.png" >

## Running Locally

Make sure you have Java and Maven installed.  Also, install the [Heroku CLI](https://cli.heroku.com/).

```sh
$ mvn clean install
$ heroku local:start
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

If you're going to use a database, ensure you have a local `.env` file that reads something like this:

```
JDBC_DATABASE_URL=dbc:postgresql://HOST:PORT/DATABASE?sslmode=require&user=USER&password=PASSWORD
```

## Deploying to Heroku

Configure Heroku Deploying mode to GitHub so that you can automatically deploy on Heroku when pushing on GitHub.

## Documentation

For more information about using Java on Heroku, see these Dev Center articles:

- [Java on Heroku](https://devcenter.heroku.com/categories/java)
