Ce readme est disponible en deux langues: anglais et français
This readme has two languages : English and French

Français:

À propos de l'application:
Cette application est essentiellement un gestionnaire de tâches pour les enfants pour les aider à suivre les choses qu'ils doivent faire

Functionality 

Lorsque vous entrez dans l'application pour la première fois, vous recevrez un message vous informant que vous n'avez pas de liste de tâches
pour ajouter une liste de tâches, cliquez simplement sur le bouton Ajouter ci-dessous, et cela vous mènera à l'activité de l'additionneur de liste de tâches, 
où vous choisirez une date pour votre liste de tâches, puis appuyez sur le bouton de validation comme indiqué ci-dessous (PS: le bouton de validation ne fonctionnera 
que si vous sélectionnez une date)

![add tasklist](https://user-images.githubusercontent.com/61503552/116823585-3bf36280-ab7d-11eb-9042-0ff3c915a2ae.gif)


Si vous souhaitez supprimer une certaine liste de tâches, tout ce que vous avez à faire est de rester sur la liste de tâches

![delete tasklist](https://user-images.githubusercontent.com/61503552/116823616-5cbbb800-ab7d-11eb-8a0a-22aa91392614.gif)



Lorsque vous entrez dans une liste de tâches, vous serez dans l'activité de tâche, la première fois que vous recevrez un message indiquant que vous n'avez aucune tâche, avec le même bouton que l'activité précédente de la liste de tâches que vous peut ajouter une tâche, pour ajouter une tâche il suffit de sélectionner l'heure de la tâche, la catégorie de la tâche (École, Domicile ....) et la description puis appuyer sur valider comme indiqué ci-dessous

PS: le bouton de validation ne fonctionnera que si vous sélectionnez l'heure et la description, si vous ne sélectionnez aucune catégorie la catégorie par défaut (Autre) sera affectée à votre tâche
différentes listes de tâches ont des icônes différentes

<< insérer l'ajout du gif de tâche ici >>

Si vous souhaitez supprimer une certaine liste de tâches, tout ce que vous avez à faire est de rester sur la liste de tâches  

<< insérer la suppression de la tâche gif >>

DataType et base de données

Pour le type de données, j'ai d'abord représenté le tableau de la liste des tâches sous forme de carte de hachage, la clé étant la date de la liste des tâches, et la valeur est un tableau de tâches, mais après quelques problèmes avec le hashmap j'ai décidé de créer la classe TL et T représentant respectivement la liste des tâches et la tâche, cela m'a facilité la manipulation de la structure plutôt qu'une carte de hachage

La base de données Firebase contient une ArrayList TL (liste de tâches) contenant toute la liste de tâches que nous avons insérée, la base de données est mise à jour chaque fois que nous ajoutons une liste de tâches, supprimons une liste de tâches, ajoutons une tâche à une liste de tâches, supprimons une tâche de la liste des tâches

ci-dessous, une image de la structure de la base de données

<<insérer la capture d'écran de la base de données >>
