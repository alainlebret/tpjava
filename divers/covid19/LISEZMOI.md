# TP génome du SARS-CoV-2 (Covid-19)


Voir la page [Wikipedia](https://fr.wikipedia.org/wiki/Code_génétique) pour plus d'information sur le code génétique. 

## Exercice n°1
Proposer une application permettant d'extraire les gènes du Covid-19 et d'indiquer les polypeptides 
(groupements d'acides aminés) qui peuvent en être générés. N'hésitez pas à créer autant de classes que 
nécessaire afin de faciliter la réutilisation.

Comme point de départ, je vous propose les classes suivantes disponibles sur mon 
[dépôt Gitlab](https://gitlab.ecole.ensicaen.fr/alebret/tpjava/-/tree/master/divers/covid19) 
de l'ENSICAEN (*vous pouvez y accédez avec vos identifiants*) : 

- `SarsCov2` : classe permettant de charger le génome du Covid-19 depuis le fichier ressources "SARS-CoV-2.txt" (version chinoise)
- `AminoAcid` : classe permettant de définir un acide aminé.
- `AminoAcids` : classe permettant de charger les informations de chaque acide aminé. 

#### Algorithme d'extraction des gènes et polypeptides
1. Afin de trouver le premier gène, cherchez le codon d'initiation' `ATG`.
2. Cherchez ensuite après `ATG`, la première occurrence de chacun des trois codons d'arrêt `TAG`, `TGA` et `TAA`.
3. Si la longueur de la sous-chaîne entre `ATG` et l'un de ces trois codons d'arrêt est un multiple de trois, alors un candidat pour un gène va du codon de départ jusqu'à la fin du codon d'arrêt.
3. S'il y a plus d'un candidat valide, la plus petite chaîne de ce type est le gène. Le gène comprend les codons d'initiation et d'arrêt.
4. Si aucun codon d'initiation n'a été trouvé, vous avez terminé.
5. Si un codon d'initiation a été trouvé, mais qu'aucun gène n'a été trouvé, alors commencez à rechercher un autre gène à partir de la prochaine occurrence d'un codon d'initiation commençant immédiatement après le codon d'initiation qui n'a pas donné de gène.
6. Si un gène a été trouvé, alors commencez à rechercher le gène suivant immédiatement après celui-ci.

## Exercice n°2
Complétez votre application en ajoutant les fonctionnalités suivantes :
- Chargement d'un autre génome contenu dans un fichier texte (par exemple : la grippe H1N1, le HIV, etc.).
- Calcul de la distance de Hamming afin de comparer le génome du Covid-19 à d'autres génomes. 

#### À propos de la distance de Hamming
Par définition, la distance de Hamming entre deux chaînes de même longueur est le nombre de positions pour lesquelles 
les symboles correspondants sont différents. En d'autres termes, c'est le nombre de substitutions nécessaires 
pour transformer une chaîne en une autre. Cette distance est intéressante pour observer des correspondances entre
différents génomes.

## Exercice n°3
Proposez une interface graphique pour la gestion de votre application.
