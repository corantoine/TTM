# Trouve Ton Match (TTM)

## Description
TTM est une application développée pour l'association Réseau Initiative.
Elle a pour but de faciliter et renforcer le système de rencontres et de parrainage entre futurs parrains et porteurs projets.

## Prérequis
- Git
- Java JDK 17+
- Maven
- PostgreSQL
- HTML 5/ CSS

## Installation 
1. **Clôner le dépôt afin de récupérer le projet**
    ```bash
   git clone https://github.com/corantoine/TTM.git
   
2. **Configurer la base de données PostgreSQL**

- Se connecter à PostgreSQL
- Créer la base de données ttm :
- ``CREATE DATABASE ttm;``

3. **Construire le projet** : 
En utilisant la commande run de l'IDE
- Ouvrir un navigateur et aller sur http://localhost:8080

## Utilisation
A compléter au fil du temps.



# Comment héberger un site web**

## Objectif
Comprendre les différentes manières d’héberger un site web en fonction des besoins (développement, production, scalabilité) et évaluer les avantages et inconvénients de chaque option.

## Plan de la section
1. [Hébergement sur un serveur local avec Apache ou Nginx](#21-hébergement-sur-un-serveur-local-avec-apache-ou-nginx)
2. [Options d'hébergement disponibles](#22-options-dhébergement-disponibles)
   - Hébergement local
   - Hébergement cloud
   - PaaS (Platform as a Service)
   - SaaS (Software as a Service)
3. [Différences entre serveurs mutualisés, dédiés et VPS](#23-différences-entre-serveurs-mutualisés-dédiés-et-vps)
4. [Limites des solutions d’hébergement](#24-limites-des-solutions-dhébergement)
   - Scalabilité
   - Coûts
   - Gestion et Maintenance

---

## **1. Hébergement sur un serveur local avec Apache ou Nginx**

### a. **Apache**
Apache HTTP Server, souvent appelé **Apache**, est l'un des serveurs web les plus utilisés dans le monde. Il est réputé pour sa modularité et sa flexibilité, ce qui en fait un outil puissant pour l’hébergement local et en production.

**Fonctionnement de base :**
- Apache est organisé autour de **modules** qui peuvent être activés ou désactivés pour fournir différentes fonctionnalités. Par exemple, les modules pour la gestion des URL (`mod_rewrite`), la compression (`mod_deflate`), ou encore la sécurité (`mod_ssl`).
- Les fichiers de configuration par défaut d'Apache sont :
  - `httpd.conf` : fichier principal de configuration.
  - `sites-available/` et `sites-enabled/` : pour gérer les différents hôtes virtuels (Virtual Hosts).

**Configuration d’Apache :**
1. **Installer Apache** sur un environnement local (exemple : Ubuntu/Debian) :
   ```bash
   sudo apt update
   sudo apt install apache2
   ```
2. **Vérifier que le serveur est actif** :
   ```bash
   sudo systemctl status apache2
   ```
3. **Configurer un hôte virtuel** :
   Créez un fichier dans `/etc/apache2/sites-available/mon-site.conf` :
   ```bash
   <VirtualHost *:80>
       ServerAdmin webmaster@monsite.com
       DocumentRoot /var/www/html/mon-site
       ServerName monsite.com
   </VirtualHost>
   ```
   Puis, activez-le :
   ```bash
   sudo a2ensite mon-site.conf
   sudo systemctl reload apache2
   ```

### b. **Nginx**
**Nginx** (prononcé "engine-x") est un autre serveur web populaire, souvent utilisé pour sa performance et sa capacité à gérer un grand nombre de connexions simultanées avec une faible consommation de ressources.

**Différences clés avec Apache** :
- Nginx utilise une **architecture événementielle** qui lui permet de traiter des milliers de connexions simultanées avec un seul thread, contrairement à l'architecture basée sur les processus d’Apache.
- Nginx est souvent utilisé comme **reverse proxy** pour distribuer la charge entre différents serveurs backend (par exemple, un serveur d’application Python ou Node.js).

**Installation de Nginx** :
1. **Installer Nginx** :
   ```bash
   sudo apt install nginx
   ```
2. **Vérifier l’installation** en accédant à `http://localhost/`.
3. **Configurer un hôte virtuel** dans `/etc/nginx/sites-available/mon-site` :
   ```bash
   server {
       listen 80;
       server_name monsite.com;
       root /var/www/html/mon-site;
       index index.html index.htm;
   }
   ```
   Puis, activez-le :
   ```bash
   sudo ln -s /etc/nginx/sites-available/mon-site /etc/nginx/sites-enabled/
   sudo systemctl reload nginx
   ```

### c. **Cas pratique : Déployer un site web localement avec Nginx**
1. Créez une page HTML simple dans `/var/www/html/mon-site/index.html` :
   ```html
   <html>
   <head><title>Mon site</title></head>
   <body><h1>Bienvenue sur mon site local</h1></body>
   </html>
   ```
2. Redémarrez Nginx pour prendre en compte la configuration :
   ```bash
   sudo systemctl restart nginx
   ```
3. Accédez au site via `http://localhost` ou en utilisant le nom de domaine configuré dans `/etc/hosts`.

### d. **Avantages et inconvénients de l'hébergement local**
- **Avantages** :
   - Contrôle total sur la configuration du serveur.
   - Bon pour le développement et les tests locaux.
   - Aucune dépendance vis-à-vis d’un tiers.

- **Inconvénients** :
   - **Non adapté à la production** : la machine locale peut ne pas avoir la puissance nécessaire pour gérer de nombreuses connexions simultanées.
   - **Problèmes de sécurité** : il peut être difficile de maintenir les mises à jour de sécurité à jour.

---

## **2. Options d'hébergement disponibles**

### a. **Hébergement local**
- **Description** : Comme présenté ci-dessus, l'hébergement local consiste à exécuter le serveur directement sur la machine utilisée pour le développement. Cela permet de tester les modifications rapidement sans devoir dépendre d’un service externe.

- **Limites** :
   - Non accessible depuis l’extérieur sans configuration de redirection de port ou d’utilisation d’outils comme Ngrok.
   - Non scalable pour les besoins de production.

### b. **Hébergement cloud**
- **Exemples** : AWS (Amazon Web Services), Google Cloud, Microsoft Azure.
  
- **Description** : Les plateformes cloud offrent des services flexibles et scalables pour héberger des sites web et des applications. Elles proposent des services complémentaires comme les bases de données, les CDN (Content Delivery Network), et les solutions de stockage.

- **Avantages** :
   - **Scalabilité** : Les ressources peuvent être augmentées ou réduites selon la demande.
   - **Haute disponibilité** : La redondance des systèmes permet d’assurer que votre site reste disponible même en cas de panne d’un serveur.

- **Inconvénients** :
   - **Coût** : Les services cloud peuvent rapidement devenir coûteux, surtout si l'on ne gère pas bien les ressources.
   - **Complexité** : Les services cloud peuvent être compliqués à configurer pour les nouveaux utilisateurs.

### c. **PaaS (Platform as a Service)**
- **Exemples** : Heroku, Google App Engine, Netlify.

- **Description** : Les plateformes PaaS fournissent un environnement complet pour le développement, l'exécution et la gestion des applications. Les utilisateurs n'ont pas besoin de se soucier des serveurs ou de l'infrastructure, tout est géré automatiquement.

- **Avantages** :
   - **Simplicité** : Aucun besoin de gérer des serveurs, des bases de données ou des réseaux.
   - **Gain de temps** : Les déploiements sont rapides, souvent en un clic.
   - **Scalabilité** : Les ressources augmentent automatiquement en fonction du trafic.

- **Inconvénients** :
   - **Moins de contrôle** : Vous n'avez pas un contrôle total sur l'infrastructure.
   - **Coût** : Les tarifs peuvent augmenter rapidement si vous dépassez les quotas gratuits.

### d. **SaaS (Software as a Service)**
- **Exemples** : WordPress.com, Wix, Squarespace.

- **Description** : Les plateformes SaaS permettent de créer et d’héberger des sites web sans avoir à gérer les aspects techniques. Tout est géré par le fournisseur de services, y compris les mises à jour et la sécurité.

- **Avantages** :
   - **Simplicité** : Idéal pour les utilisateurs qui ne veulent pas se soucier des détails techniques.
   - **Maintenance** : Le fournisseur se charge de toutes les mises à jour, de la sécurité et de la maintenance.

- **Inconvénients** :
   - **Personnalisation limitée** : Les utilisateurs sont souvent limités dans les options de personnalisation et de configuration.
   - **Dépendance** : Vous êtes dépendant du fournisseur pour les fonctionnalités et la disponibilité du service.

---

## **3. Différences entre serveurs mutualisés, dédiés et VPS**

### a. **Serveurs mutualisés**
- **Description** : Plusieurs sites web partagent les ressources d'un même serveur physique. Chaque site dispose d'une portion de la mémoire, de la bande passante et du stockage.
  
- **Avantages** :
   - **Coût réduit** : Les serveurs mutualisés sont souvent l'option la moins coûteuse.
   - **Gestion simplifiée** : La maintenance du serveur est assurée par le fournisseur.

- **Inconvénients** :
   - **Performance réduite** : Les performances peuvent être affectées si un autre site sur le même serveur consomme beaucoup de ressources.
   - **Moins de contrôle** : Les utilisateurs n'ont pas un accès complet au serveur pour ajuster les configurations.

### b. **Serveurs dédiés**
- **Description** : Un serveur entier est dédié à un seul client. Cela offre plus de puissance et de contrôle sur les ressources du serveur.

- **Avantages** :
   - **Performance** : Vous avez accès à toutes les ressources du serveur.
   - **Contrôle total** : Les utilisateurs ont un accès root et peuvent configurer le serveur selon leurs besoins.

- **Inconvénients** :
   - **Coût élevé** : Les serveurs dédiés sont plus coûteux à louer et à maintenir.
   - **Complexité** : La gestion d’un serveur dédié nécessite des compétences en administration système.

### c. **Serveur privé virtuel (VPS)**
- **Description** : Un VPS est une machine virtuelle qui émule un serveur physique. Il partage le matériel avec d'autres VPS, mais chaque instance fonctionne de manière indépendante.

- **Avantages** :
   - **Coût intermédiaire** : Moins coûteux qu'un serveur dédié, mais avec des ressources dédiées.
   - **Personnalisation** : Un VPS permet de configurer le système d'exploitation et les applications selon vos besoins.

- **Inconvénients** :
   - **Limites de ressources** : Vous partagez toujours le serveur avec d'autres utilisateurs, ce qui peut entraîner des limitations en termes de performance.

---

## **4. Limites des solutions d’hébergement**

### a. **Scalabilité**
- Les solutions d’hébergement comme les serveurs mutualisés ou locaux ont des limites de scalabilité. Si votre trafic augmente soudainement, ces solutions peuvent devenir insuffisantes.

### b. **Coûts**
- Les solutions cloud ou dédiées peuvent devenir coûteuses, surtout si vous n’anticipez pas bien les besoins en ressources. Il est important de bien comprendre la tarification de chaque service.

### c. **Gestion et Maintenance**
- Les solutions comme les serveurs dédiés et VPS nécessitent une gestion active. Vous devrez installer des mises à jour, gérer les failles de sécurité, et assurer le bon fonctionnement des services.