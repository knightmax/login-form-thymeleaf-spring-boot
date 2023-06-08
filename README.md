# Exercice Spring Boot avec pages HTML et authentification

Dans cet exercice, vous allez créer une application Spring Boot qui sera couplée à des pages HTML rendues par le framework front de votre choix (nous préconisons Thymeleaf).
L'application aura les fonctionnalités suivantes :

## Route GET sur `/` ou `/index`
Lorsqu'un utilisateur accède à la racine de l'application (`/`) ou à la page `/index`, il doit être redirigé vers une page affichant le titre de niveau 1 "Hello World" et un lien permettant de se connecter.

## Page de login
Lorsque l'utilisateur clique sur le lien de connexion `/login`, il doit être redirigé vers une page de login avec en titre de niveau 1 "Login Form".

La page de login doit contenir les champs de saisie suivants :
- Champ de saisie pour l'adresse email de l'utilisateur avec l'identifiant `email` et le type `email`.
- Champ de saisie pour le mot de passe de l'utilisateur avec l'identifiant `password` et le type `password`.
- Champ de saisie pour le nom de l'utilisateur avec l'identifiant `name` et le type `text`.

La page de login doit également contenir un bouton "Submit" qui, lorsqu'il est cliqué, doit invoquer une méthode POST pour traiter les données du formulaire.

## Traitement du formulaire POST
Lorsque le formulaire est soumis (via la méthode POST `/login`), l'application doit valider les champs saisis :
- L'adresse email saisie doit être un email valide.
- Le mot de passe saisi doit faire entre 8 et 15 caractères et contenir au moins 2 chiffres.
- Le nom saisi doit faire plus de 2 caractères et ne contenir que des lettres.

Si tous les champs sont correctement saisies, l'application doit afficher un message de confirmation de création de compte.

Le message de confirmation doit inclure l'adresse email saisie par l'utilisateur.

Le mot de passe saisi par l'utilisateur doit être chiffré avant d'être affiché dans le message de confirmation.

## Critères d'acceptance détaillés :

1. L'application doit être développée avec Spring Boot.
2. Les pages HTML doivent être rendues par le framework front de votre choix (de préférence Thymeleaf).
3. L'accès à la racine de l'application (`/`) ou à la page `/index` doit rediriger l'utilisateur vers une page affichant le titre de niveau 1 "Hello World" et un bouton de connexion.
4. Le bouton de connexion doit rediriger l'utilisateur vers une page de login `/login`, avec en titre de niveau 1 "Login Form", contenant les champs de saisie suivants : adresse email, mot de passe et nom.
5. La page de login doit avoir un bouton "Submit" qui, lorsqu'il est cliqué, doit invoquer une méthode POST pour traiter les données du formulaire.
6. Lorsque le formulaire est soumis (via la méthode POST `/login`), l'application doit effectuer les validations suivantes :
   - L'adresse email saisie doit être un email valide. 
   - Le mot de passe saisi doit faire entre 8 et 15 caractères et contenir au moins 2 chiffres.
   - Le nom saisi doit faire plus de 2 caractères et ne contenir que des lettres.
   - Si les validations échouent, l'application doit afficher un message d'erreur approprié à côté de chaque champ de saisie concerné.
   - Si toutes les validations sont réussies, l'application doit afficher un message de confirmation de création de compte.
7. Le message de confirmation doit inclure l'adresse email saisie par l'utilisateur.
8. Le mot de passe saisi par l'utilisateur doit être chiffré avant d'être affiché dans le message de confirmation.
