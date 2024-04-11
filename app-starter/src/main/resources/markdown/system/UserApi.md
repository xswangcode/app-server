# 用户接口补充文档

## POST /user/login

`AfterScript`

``` AfterScript
var code=ke.response.data.code;
if(code==200){
    //获取token
    var token=ke.response.data.message;
    ke.global.setHeader("X-Auth-Token",token); 
}
```

POST /user/jwttest 自动刷新token

`AfterScript`

``` AfterScript
let token =  ke.response.headers['x-auth-token']
if(token){
ke.global.setHeader("X-Auth-Token",token);
}
```