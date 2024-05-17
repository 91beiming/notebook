import { useToken } from '@/hooks/useToken'
import ArticlePage from '@admin/article'
import { IndexPage } from '@admin/index'
import { LoginPage } from '@admin/login'
import { useEffect } from 'react'
import { Outlet, RouteObject, useLocation, useNavigate } from 'react-router'

export const adminRoutes: RouteObject[] = [
	{
		path: '/admin',
		element: (
			<AuthProvider>
				<Layout></Layout>
			</AuthProvider>
		),
		children: [
			{ index: true, element: <IndexPage /> },
			{ path: 'login', element: <LoginPage /> },
			{
				path: 'article',
				element: <ArticlePage />
			}
		]
	}
]

/**
 * admin 布局
 * @returns React.FC
 */
function Layout() {
	document.title = import.meta.env.VITE_ADMIN_TITLE
	return (
		<div className="w-full h-full">
			<Outlet></Outlet>
		</div>
	)
}
/**
 * 认证检测
 * @param param0
 * @returns
 */
function AuthProvider({ children }: { children: React.ReactNode }) {
	const navigate = useNavigate()
	const location = useLocation()
	const { getToken } = useToken()
	useEffect(() => {
		const token = getToken()
		if (!token && !location.pathname.startsWith('/admin/login')) {
            //token为空且不是登录页,跳转到登录页
			//记录当前路径
			const currentPath = location.pathname
			navigate('/admin/login?redirect=' + currentPath)
		} else if (token && location.pathname.startsWith('/admin/login')) {
            //token存在且是登录页,就跳转到管理首页
			navigate('/admin')
		}
	}, [location])
	return <>{children}</>
}
