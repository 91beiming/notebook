local count = 0
local userKey = KEYS[1]
local listKey = KEYS[2]
local userInfo = ARGV[1]
local expiredTime = tonumber(ARGV[2])
local onlineLimit = tonumber(ARGV[3])
-- 保存用户信息并设置过期时间
redis.call('SETEX', userKey, expiredTime, userInfo)
-- 将本key添加到list中
redis.call('LPUSH', listKey, userKey)

count = redis.call('LLEN', listKey)
while count > onlineLimit
do
    local uuid = redis.call('RPOP', listKey)
    redis.call('DEL', uuid)
    count = redis.call('LLEN', listKey)
end
return userKey