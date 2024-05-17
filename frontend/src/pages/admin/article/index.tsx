import { useAuth } from '@/hooks/useAuth'
import { NavLink } from 'react-router-dom'

const ArticlePage: React.FC = () => {
	const { logout } = useAuth()

	return (
		<div>
			<h1>Article</h1>
			<h1>
				<NavLink to="/admin">index</NavLink>
			</h1>
			<button onClick={logout}>退出登录</button>
		</div>
	)
}
export default ArticlePage
