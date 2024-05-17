import { Button, Form, FormProps, Input } from 'antd'
import { LoginParams } from '@/types/LoginType.ts'
import { useAuth } from '@/hooks/useAuth'
export const LoginForm = () => {
	const { login } = useAuth()
	const onFinish: FormProps<LoginParams>['onFinish'] = (
		values: LoginParams
	) => {
		login(values)
	}
	return (
		<>
			<Form
				name="basic"
				labelCol={{
					span: 6
				}}
				wrapperCol={{
					span: 18
				}}
				style={{
					minWidth: '20rem',
					marginRight: '1rem'
				}}
				onFinish={onFinish}
				autoComplete="off"
			>
				<Form.Item<LoginParams>
					label="用户名"
					name="key"
					rules={[
						{
							required: true,
							message: '请输入用户名/邮箱'
						}
					]}
				>
					<Input />
				</Form.Item>

				<Form.Item<LoginParams>
					label="密码"
					name="secret"
					rules={[
						{
							required: true,
							message: '请输入密码'
						}
					]}
				>
					<Input.Password />
				</Form.Item>

				<Form.Item
					wrapperCol={{
						span: 24,
						offset: 10
					}}
				>
					<Button type="primary" htmlType="submit">
						登陆
					</Button>
				</Form.Item>
			</Form>
		</>
	)
}
