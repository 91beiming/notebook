import { useToken } from '@/hooks/useToken'
import Request from '@/libs/request'
import { LoginParams } from '@/types/LoginType.ts'
import { useLocation, useNavigate } from 'react-router'

/**
 * 通过邮箱登录。
 * @param loginParams 包含登录所需参数的对象，例如邮箱和密码。
 * @returns 返回一个Promise，成功时解决为用户唯一标识符（UUID），失败时拒绝并返回错误对象。
 */
export function loginByEmail(loginParams: LoginParams) {
	// 创建一个新的Promise，通过邮箱登录过程将在其中进行
	return Request.post<LoginParams, string>('/login/email', loginParams)
}

/**
 *  退出登录
 */
export function logout() {
	return Request.get<null, boolean>('/logout', null)
}
