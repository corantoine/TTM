// TODO: Créer une fonction asynchrone pour gérer la connexion de l'utilisateur
export async function loginUser(username, password) {
  // TODO: Définir l'URL de l'API pour la connexion des utilisateurs
  const loginUrl = new URL('http://localhost:8080/login')
  // TODO: Créer un objet contenant les options de la requête
  const options = {
    // TODO: Spécifier la méthode HTTP (POST)
    method: 'POST',
    // TODO: Définir les en-têtes de la requête
    headers: {
      'Content-Type': 'application/json',
    },
    // TODO: Convertir les données de l'utilisateur en JSON et les inclure dans le corps de la requête
    body: JSON.stringify({
      //TODO denominations back/front pour faire la correspondance des données
      username: username,
      password: password,
    }),
  }

  // TODO: Utiliser try...catch pour gérer les erreurs lors de l'envoi de la requête
  try {
    // TODO: Envoyer la requête avec fetch et attendre la réponse
    const response = await fetch(loginUrl, options)
    // TODO: Vérifier si la réponse est correcte (statut HTTP)
    if (!response.ok) {
      throw new Error(`HTTP error ! Status : ${response.status}`)
    }
    // TODO: Afficher un message de succès si la connexion est réussie
    alert('Connexion réussie!')
  } catch (error) {
    // TODO: Afficher un message d'erreur en cas d'échec de la connexion
    alert('La connexion a échoué.')
    throw error
  }
}
