import { IndexPage } from '@/pages/web/index'
import { Outlet, RouteObject } from 'react-router'

export const webRoutes: RouteObject[] = [
	{
		path: '/',
		element: <Layout />,
		children: [{ index: true, element: <IndexPage /> }]
	}
]

function Layout() {
	document.title = import.meta.env.VITE_TITLE
	return (
		<div className="w-full h-full">
			<Outlet></Outlet>
		</div>
	)
}
