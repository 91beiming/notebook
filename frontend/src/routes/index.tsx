import { createBrowserRouter } from 'react-router-dom'
import { adminRoutes } from './module/admin'
import { webRoutes } from './module/web'

export const router = createBrowserRouter([...adminRoutes, ...webRoutes])
