local userKey = KEYS[1]
local expiredTime = ARGV[1]

local userStr = redis.call("GET", userKey)
if (userStr == false)
then
    return ''
else
    redis.call("EXPIRE", userKey, expiredTime)
    return userStr
end