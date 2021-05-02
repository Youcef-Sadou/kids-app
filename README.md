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

![add task ](https://user-images.githubusercontent.com/61503552/116823647-8aa0fc80-ab7d-11eb-86e2-2e982a8b9891.gif)



Si vous souhaitez supprimer une certaine tâche, il vous suffit de vous en tenir à la description de la tâche

![delete task](https://user-images.githubusercontent.com/61503552/116823656-942a6480-ab7d-11eb-813e-e6860c97a2bc.gif)

DataType et base de données

Pour le type de données, j'ai d'abord représenté le tableau de la liste des tâches sous forme de carte de hachage, la clé étant la date de la liste des tâches, et la valeur est un tableau de tâches, mais après quelques problèmes avec le hashmap j'ai décidé de créer la classe TL et T représentant respectivement la liste des tâches et la tâche, cela m'a facilité la manipulation de la structure plutôt qu'une carte de hachage

La base de données Firebase contient une ArrayList TL (liste de tâches) contenant toute la liste de tâches que nous avons insérée, la base de données est mise à jour chaque fois que nous ajoutons une liste de tâches, supprimons une liste de tâches, ajoutons une tâche à une liste de tâches, supprimons une tâche de la liste des tâches

ci-dessous, une image de la structure de la base de données

![Screenshot (97)](https://user-images.githubusercontent.com/61503552/116823669-9bea0900-ab7d-11eb-8b72-ec5cabbe305d.png)














English:
About the application

This application is basically a task manager for kids to help them keep track of the things that they need to do 

Functionality 

When you enter the app for the first time, you will get a message telling you that you have no task lists 
to add a task list, simply click on the the add button below, and it will take you to the task list adder activity, where you will choose a date for your task list and then press 
on the validate button as shown underneath (PS: the validate button won't work unless you select a date)

![add tasklist](https://user-images.githubusercontent.com/61503552/116823585-3bf36280-ab7d-11eb-9042-0ff3c915a2ae.gif)



If you want to delete a certain task list, all you have to do is hold on the task list 


![delete tasklist](https://user-images.githubusercontent.com/61503552/116823616-5cbbb800-ab7d-11eb-8a0a-22aa91392614.gif)


When you enter a tasklist, you will be in the task activity, the first time you will get a message saying that you have no tasks, with the same button as previous tasklist activity you
can add a task, to add a task simply select the hour of the task, the category of the task (School,Home....) and the description then press validate as shown underneath
PS: the validate button won't work unless you select the hour and the description, if you select no category the default category (Other) will be assigned to your task 
diffrent tasklists have different icons

![add task ](https://user-images.githubusercontent.com/61503552/116823647-8aa0fc80-ab7d-11eb-86e2-2e982a8b9891.gif)

If you want to delete a certain task , all you have to do is hold on the description of the task


![delete task](https://user-images.githubusercontent.com/61503552/116823656-942a6480-ab7d-11eb-813e-e6860c97a2bc.gif)


DataType and Database 

For the data type, first i represented the tasklist array as a hash map, with the key being the tasklist date, and the value is a task array , but then after a few troubles with the 
hashmap i decided to create the TL and T class representing the tasklist and task respectively, this made it easier for me to manipulate the structure rather than a hash map


The Firebase database contains a TL (tasklist) ArrayList containing all of the tasklist we inserted , the database gets updated every time we add a tasklist, delete a tasklist, add a task to a tasklist, remove a task from the tasklist

below is a picture of how the database is structured

![Screenshot (97)](https://user-images.githubusercontent.com/61503552/116823669-9bea0900-ab7d-11eb-8b72-ec5cabbe305d.png)






