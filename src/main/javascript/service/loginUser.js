export async function loginUser(username, password) {
  const loginUrl = new URL('http://localhost:8080/login')
  const options = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      username: username,
      password: password,
    }),
  }

  try {
    const response = await fetch(loginUrl, options)
    if (!response.ok) {
      throw new Error(`HTTP error ! Status : ${response.status}`)
    }
    alert('Connexion réussie!')
  } catch (error) {
    alert('La connexion a échoué.')
    throw error
  }
}
