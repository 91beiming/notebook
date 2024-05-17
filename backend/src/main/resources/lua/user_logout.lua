local userKey = KEYS[1]
local listKey = KEYS[2]

--删除该凭证用户信息缓存
redis.call("DEL", userKey)
--删除list中该凭证
redis.call("LREM", listKey, 0, userKey)
return true