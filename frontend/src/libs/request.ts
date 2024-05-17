import { useToken } from '@/hooks/useToken'
import { ResponseWrapper } from '@/types/ResponseType'
import { message } from 'antd'
import axios, { AxiosInstance, AxiosResponse } from 'axios'

const instance: AxiosInstance = axios.create({
	baseURL: import.meta.env.VITE_REQUEST_BASE_API
})

//请求拦截器
instance.interceptors.request.use(async (config) => {
	const { getToken } = useToken()
	const token = getToken()
	if (token) {
		config.headers.Authorization = token
	}
	return config
})

//响应拦截器
instance.interceptors.response.use(
	(
		response: AxiosResponse<ResponseWrapper<any>, any>
	):
		| AxiosResponse<ResponseWrapper<any>, any>
		| Promise<AxiosResponse<ResponseWrapper<any>, any>> => {
		const { removeToken } = useToken()
		if (response.status === 200) {
			if (response.data.code === 200) {
				return response
			} else if (response.data.code === 401) {
				removeToken()
				location.href = '/admin/login'
				return Promise.reject(response.data.message)
			} else {
				message.warning(response.data.message)
				return Promise.reject(response.data.message)
			}
		} else {
			message.error(response.statusText)
			return Promise.reject(response.statusText)
		}
	},
	(error) => {
		message.warning(
			(error.response && error.response.statusText) || error.message
		)
		return Promise.reject(error)
	}
)

function get<P, R>(url: string, params: P | null): Promise<R> {
	return instance
		.get(url, { params })
		.then((resp: AxiosResponse<ResponseWrapper<R>, any>) => {
			return resp.data.data
		})
}

function post<P, R>(url: string, data: P): Promise<R> {
	return instance
		.post(url, data)
		.then((resp: AxiosResponse<ResponseWrapper<R>, any>) => {
			return resp.data.data
		})
}

export default { get, post }
