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

Le programme compte le nombre d'accidents de travail sur le mois du fichier pris en entrée.
Il lit d'abord le fichier CSV passé en argument du programme, divise les lignes sur le symbole ';' via une opération map. Ensuite il fitre le dataset créé sur le 32ème champs correspondant aux accidents de travail.
Il fini par compter le nombre de ligne et écrit le résultat dans le un fichier CSV sur le HDFS.

## Mise en place du cluster

* Création des machines virtuelles sur OpenStack
* Création des utilisateurs hadoop sur toutes les machines et répartition des clefs SSH.
* Mise à jour des fichiers host
* Téléchargement des binaires, mise en place des variables d'environement.
* Configuration des modules HDFS, HADOOP et Yarn.
* Définition des workers (RAM disponible et nombre de coeurs)
* On réplique le binaire et la config sur chaque workers
* On lance les commandes de formatage du HDFS sur le master.
* On lance les commandes de démarrage du cluster, on a maintenant accès au interfaces web
* Nous avons en plus défini des targets systemd pour démarrer avec la machine.
* Il est alors possible de soumettre des JAR via l'interface CLI de spark.

## Utilisation

Les commandes pour le lancer sont:

```bash
# Compilation du module
sbt package
# En local
spark-submit --class "SimpleApp" $PATH_TO_JAR/tp1_2.11-1.0.jar $PATH_TO_FILE/A201712_partial.csv --master local[4]
# Sur le cluster
spark-submit --deploy-mode cluster --class "SimpleApp" $PATH_TO_JAR/tp1_2.11-1.0.jar hdfs://spark-1:9000/$PATH_TO_FILE/A201712.csv hdfs://spark-1:9000/$PATH_TO_FILE/outfile
```

## Liens
[Mise en place du cluster Hadoop et HDFS](https://www.linode.com/docs/databases/hadoop/how-to-install-and-set-up-hadoop-cluster/)
[Mise en place de l'ordonnanceur Yarn](https://www.linode.com/docs/databases/hadoop/install-configure-run-spark-on-top-of-hadoop-yarn-cluster/)

