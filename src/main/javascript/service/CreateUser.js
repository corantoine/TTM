//Creation de la fonction async createUser()
export async function CreateUser( nom, prenom, username, password, confirmPassword, email, plateforme, role) {

    const userURL = new URL("http://localhost:8080/register")

    // Créer un objet contenant les options de requete (requete + reponse)
    const option = {
        //Type de la méthode
        method: 'POST',
        //Contenu envoyé
        headers: {
            "Content-Type": "application/json",
            // "Accept": "application/json",
        },
        body: JSON.stringify({
            //dénominations back/front pour faire la correspondance des données
            nom: nom,
            prenom: prenom,
            username: username,
            password: password,
            confirmPassword, confirmPassword,
            email: email,
            plateformeInitiative: plateforme,
            role: role
        })
    }
    // gestion d'erreur try...catch
    try {
        const reponse = await fetch(userURL, option);
        console.log(reponse);
        if (!reponse.ok) {
            throw new Error(`HTTP error! Status: ${reponse.status}`)
        }
        alert('Utilisateur enregistré avec succès !');
    } catch (error) {
        alert("L'utilisateur n'a pas pu être enregistré.");
        throw error;
    }
};


