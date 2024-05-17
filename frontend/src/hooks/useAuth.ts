import { loginByEmail } from '@/apis/login'
import { LoginParams } from '@/types/LoginType'
import { useLocation, useNavigate } from 'react-router'
import { logout as logoutApi } from '@/apis/login'
import { useToken } from './useToken'
export function useAuth() {
	const navigate = useNavigate()
	const location = useLocation()
	const { setToken, removeToken } = useToken()

	function login(values: LoginParams) {
		loginByEmail(values)
			.then((token) => {
				setToken(token)
			})
			.then(() => {
				const parms = location.search
				//解析redirect参数,并跳转到之前的页面
				if (parms.includes('redirect')) {
					navigate(parms.split('=')[1])
				} else {
					navigate('/admin')
				}
			})
	}

	function logout() {
		logoutApi()
			.then((result: boolean) => {
				if (result) {
					removeToken()
					navigate('/admin/login')
				}
			})
			.catch((err) => {
				console.log(err)
			})
	}
	return { login, logout }
}
