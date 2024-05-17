import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import path from 'path'

// https://vitejs.dev/config/
export default defineConfig({
	plugins: [react()],
	resolve: {
		alias: {
			'@': path.resolve(__dirname, 'src'),
			'@admin': path.resolve(__dirname, 'src/pages/admin'),
			'@web': path.resolve(__dirname, 'src/pages/web')
		}
	},
	server: {
		proxy: {
			'/api': {
				target: 'http://localhost:8080',
				changeOrigin: true,
				rewrite: (path: string) => path.replace(/^\/api/, '')
			}
		}
	},
	// build: {
	// 	rollupOptions: {
	// 		input: {
	// 			web: path.resolve(__dirname, './index.html')
	// 		}
	// 	}
	// }
})
