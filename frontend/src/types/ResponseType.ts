export interface ResponseWrapper<T> {
	code: number
	data: T
	message?: string
	responseId?: string
}
