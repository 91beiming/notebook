import { ConfigProvider } from 'antd'
import { LoginForm } from './components/LoginForm'
import React from 'react'
const backgroundVideoUrl =
	'https://gw.alipayobjects.com/v/huamei_gcee1x/afts/video/jXRBRK_VAwoAAAAAAAAAAAAAK4eUAQBr'
export const LoginPage: React.FC = () => {
	const loginTitle = import.meta.env.VITE_ADMIN_TITLE
	return (
		<>
			<div className="w-full h-full">
				<div className="h-full w-full">
					<video
						className="h-full w-full absolute left-0 top-0 z-0 object-fill pointer-events-none"
						autoPlay
						loop
						muted
						src={backgroundVideoUrl}
					></video>
					<div className="text-white z-10 w-full h-full absolute left-0 top-0 box-border flex justify-center items-center">
						<div className="bg-black/75 rounded-2xl	w-auto ">
							<div className="flex items-center justify-center pt-2 pb-2 mb-4">
								<img
									src="/favicon.svg"
									className="w-12 h-12 mr-4"
									alt="图标"
								/>
								<h1 className="text-xl select-none text-orange-500">
									{loginTitle}
								</h1>
							</div>
							<ConfigProvider
								theme={{
									components: {
										Form: {
											labelColor: 'white'
										}
									}
								}}
							>
								<LoginForm></LoginForm>
							</ConfigProvider>
						</div>
					</div>
				</div>
			</div>
		</>
	)
}
