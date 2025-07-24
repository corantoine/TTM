export async function loginUser(username, password, role) {
  const loginUrl = new URL('http://localhost:8080/login')
  const options = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      Accept: 'application/json',
    },
    body: JSON.stringify({
      username: username,
      password: password,
      role: role,
    }),
  }

  try {
    const response = await fetch(loginUrl, options)
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`)
    }
    const data = await response.json()
    console.log('REPONSE API ==>', data);
    
    if (data && data.accessToken) {
      // localStorage.setItem('accessToken', data.accessToken)
      alert('Connexion réussie!')
      return data
    } else {
      throw new Error('Invalid login response')
    }
  } catch (error) {
    alert('La connexion a échoué.')
    console.error('Login error:', error)
    throw error
  }
}
