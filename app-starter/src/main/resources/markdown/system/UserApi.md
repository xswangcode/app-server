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