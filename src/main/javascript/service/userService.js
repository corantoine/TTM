// src/services/userService.js

export async function getUserProfile(token) {
    const profileUrl = new URL('http://localhost:8080/users/myprofil');
  
    const options = {
      method: 'GET',
      headers: {
        'Authorization': `Bearer ${token}`,
        'Accept': 'application/json',
      },
    };
  
    try {
      const response = await fetch(profileUrl, options);
      console.log('Réponse brute profil :', response);
  
      if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
      }
  
      const data = await response.json();
      console.log('Profil utilisateur récupéré :', data);
      return data;
    } catch (error) {
      console.error('Erreur lors de la récupération du profil :', error);
      throw error;
    }
  }
  