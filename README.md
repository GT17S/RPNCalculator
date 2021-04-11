# Projet RPNCalculator :
## Introduction
Le mini projet RPNCalculator est un exercice donnée par le professeur de cours de PGLP Mr Stéphane LOPES, encadré par le chargé de TD Mr Alaa ZREIK.
Ce projet consiste à réaliser une Calculatrice qui marche en mode RPN, et qui sera capable de faire les quatres taches initiales d'une calculatrice
normal(add,sub,mult,div) et qui aura aussi un undo et exit, et tout cela en respectant le pattern Command et les régles imposés par l'enseignant de
cours.
<br>
   <u>**Etudiants:**</u>
<br>    ARAB Koussaila
<br>    GUENANE Toufik
    
## Diagramme de classes pour le projet de RPNCalculator
Dans le diagramme de classes suivant on voit la représentation des classes de projet.
<u>**NB:**</u><br>
La **flèche avec les pointier** refer vers un lien de implémentation d'interface(implements).

![Class Diagram](https://github.com/uvsq-tod/rpncalc-rpn_guenane_rahmani/blob/master/Diagramme%20de%20classe%20pour%20le%20projet.PNG)

## Aspects techniques et choix de conception sur le projet
### Objectif de projet
Comme décrit dans l'introduction l'objectif de projet est de réalisé une Calculatrice qui fonctionne en mode RPN, et ce qui a été realisé pour les
4 opérations de base d'une calculette, et avec çà la commande Undo et Quit.
 
### Le pattern COMMAND
Comme vous pouvez constatez, le pattern Command était l'un des aspects le plus demandé dans ce mini projet et ce dernier a été implimenter avec 
succées, et celà à partir de l'interface Command et les classes de commande qui l'implimentent par la suite comme Quit Class et Undo Class.

### Outils de travail
#### Maven
Le projet est déja au depart basé sur MAVEN, ou on a ajouter les depandances necessaires pour ce projet afin de le réaliser dans la mielleur qualité
et dans la mielleur des délais.
###### JDK 11
Comme le sujet de projet l'impose la vérsion utiliser pour Java et de le JDK 11, et cela à partir de ces quelques lignes ecrites dans le **POM.xml**
de projet MAVEN.
```xml
            <properties>
                <maven.compiler.source>11</maven.compiler.source>
                <maven.compiler.target>11</maven.compiler.target>
            </properties>
```
###### Checkstyle
Comme le sujet de projet le demande on a ajouté une depandance sur le plugin cheskstyle qui verifie bien la syntaxe de code et propose la plus approprié,
et cela à partir de ces quelques lignes ecrites dans le **POM.xml** de projet MAVEN.

Le bout de code ajouté dans le **<Build>** de POM.xml
```xml
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-checkstyle-plugin</artifactId>
                    <version>3.1.2</version>
                    <configuration>
                        <configLocation>checkstyle.xml</configLocation>
                        <encoding>UTF-8</encoding>
                        <consoleOutput>true</consoleOutput>
                        <failsOnError>true</failsOnError>
                        <linkXRef>false</linkXRef>
                    </configuration>
                    <executions>
                        <execution>
                            <id>validate</id>
                            <phase>validate</phase>
                            <goals>
                                <goal>check</goal>
                            </goals>
                        </execution>
                    </executions>
                </plugin>
```
Et l'autre bout de code ajouté dans le **<reporting>** de POM.xml pour faire un rapport sur les differents soucis rencontrés.
```xml
             <plugin>
                 <groupId>org.apache.maven.plugins</groupId>
                 <artifactId>maven-checkstyle-plugin</artifactId>
                 <version>3.1.2</version>
                 <reportSets>
                     <reportSet>
                         <reports>
                             <report>checkstyle</report>
                         </reports>
                     </reportSet>
                 </reportSets>
             </plugin>
```
###### Javadoc
Pas demander, mais on a decider comme meme d'ajouter sa depandance et son plugin dans le POM.xml afin de pouvoir generer un rapport sur le projet
et ces differentes classes.
La depandance de depart.

```xml
             <dependency>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-javadoc-plugin</artifactId>
                        <version>3.2.0</version>
             </dependency>
```
  
Le bout de code ajouté dans le **<Build>** de POM.xml
```xml
                          <plugin>
                                <groupId>org.apache.maven.plugins</groupId>
                                <artifactId>maven-javadoc-plugin</artifactId>
                                <version>3.2.0</version>
                                <configuration>
                                    <show>private</show>
                               </configuration>
                          </plugin>
```
Et l'autre bout de code ajouté dans le **<reporting>** de POM.xml pour faire un rapport sur les classes de projet.

```xml
               <plugin>
                   <groupId>org.apache.maven.plugins</groupId>
                   <artifactId>maven-javadoc-plugin</artifactId>
                   <version>3.2.0</version>
                   <configuration>
                       <stylesheetfile>${basedir}/src/main/javadoc/stylesheet.css</stylesheetfile>
                       <show>public</show>
                   </configuration>
               </plugin>
```
###### Junit4
Intégré de base dans le projet au départ, comme on peut le voir sur le **POM.xml**

```xml
                <dependency>
                    <groupId>junit</groupId>
                    <artifactId>junit</artifactId>
                    <version>4.13.1</version>
                    <scope>test</scope>
                </dependency>
```
### Conception réalisé
Le choix de la conception réalisé se base les quelques éxplications eu par le professeur de TD et celle de principe de Command pattern vu au cours,
ou on peut voir qu'on a fait les classes de commandes à partir de l'interface Command, d'ou on a peu crée crée les classes Undoable,Quit et Undo qui
l'implimentent et par la suite on voit une seule classe pour les opérations au lieu de 4 comme proposé par le professeur de TD, car on a opté pour un
Enum pour faire les opérations arithmitiques, et on a vu que le mielleur choix pour la calculatrice RPN est de travaillé sur des piles ce qui va avec
le principe de RPN ou on prend les operandes et les appliquant sur les differentes opérations qu'on a.<br>
Et par la suite on a continuer à implimenter le reste des questions et les connnectés d'une façon logique au commandes de la calculatrice RPN.



