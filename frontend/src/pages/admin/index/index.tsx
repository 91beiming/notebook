import { useAuth } from '@/hooks/useAuth'
import { NavLink } from 'react-router-dom'

export const IndexPage: React.FC = () => {
	const { logout } = useAuth()
	return (
		<div>
			<h1>Index</h1>
			<NavLink to="article">article</NavLink>
			<br />
			<button
				className="bg-orange-200 p-2 rounded-full hover:bg-red-100 hover:text-stone-300	hover:transition-all hover:duration-[2000ms]	"
				onClick={logout}
			>
				退出登录
			</button>
		</div>
	)
}
