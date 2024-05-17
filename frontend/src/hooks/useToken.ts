interface State {
	value: string | null
}
const tokenState: State = {
	value: null
}
export function useToken() {
	function getToken() {
		if (!tokenState.value) {
			tokenState.value = localStorage.getItem('token')
		}
		return tokenState.value
	}
	function setToken(token: string) {
		localStorage.setItem('token', token)
		tokenState.value = token
	}

	function removeToken() {
		localStorage.removeItem('token')
		tokenState.value = null
	}

	return { getToken, setToken, removeToken }
}
