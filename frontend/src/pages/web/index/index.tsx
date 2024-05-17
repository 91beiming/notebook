import { Button } from 'antd'
import { useNavigate } from 'react-router'

export const IndexPage: React.FC = () => {
	const navigate = useNavigate()
	return (
		<div>
			<Button
				type="primary"
				onClick={() => {
					navigate('/admin')
				}}
			>
				Button
			</Button>
			<h1 className="text-5xl text-lime-600 font-bold pointer-events-none">
				Hello world!
			</h1>
		</div>
	)
}
