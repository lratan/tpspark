# Rapport TP Spark

## Authors
Romain Grossemy

Loïc Stevens

## Démarches

Notre première idée était d'utiliser l'API de Twitter. Nous voulions retrouver les hashtags des différentes campagnes politiques de la course à la présidence française 2017.
Nous voulions corréler cela avec les résultats réels des élections.
Il s'est avéré que l'API de Twitter est assez compliquée à utiliser.
Il y a plusieurs types de comptes, des limites sur le nombre d'appels (ce qui est normal).
 De plus ils n'offraient pas les fonctions de recherche que nous désirions de part l'ancienneté des tweets. In fine, il était impossible de récupérer tous les tweets.

Nous avons alors décider de chercher d'autre jeux de données. Il en existait peu qui regroupaient assez de lignes pour justifier l'utilisation d'un cluster.
 Nous avons donc trouvé les données de la sécurité sociale.

## Données

Le fichier choisi est celui qui regroupe les prestations du mois de décembre 2017. Il compte 30 940 925 lignes et rassemble plusieurs informations sur les prestations (55).
Toutes les valeurs des champs sont notées sous forme d'entiers, un second fichier est fourni pour pouvoir interpréter les valeurs.

A noter que si la taille du fichier n'est pas suffisante, il suffit de prendre un autre mois en plus (Il ne s'agit ici que des prestations de décembre).

## Programme
## Mise en place du cluster
## Utilisation
