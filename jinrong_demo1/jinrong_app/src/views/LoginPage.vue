<template>
    <div id="header" class="header_main re">报名信息
        <a onclick="history.go(-1)" class="back"></a>
    </div>
    <div class="h60"></div>

    <div class="enrol re" style="height: 600px;">
        <img src="../assets/images/sign-in-bg.jpg"
             style="max-width: 750px;width: 100%;">
        <div class="sign-in"  id="registerDiv"  v-if="display ==='registerDiv'">
            <form  method="get" name="form1" id="registerForm" action="">
                <div class="input1" style="margin-bottom: 4px;">
                    <div class="tabCity">确认优惠城市：<span id="tabCity">{{cityName}}</span> <a class="tab"  href="/">[切换城市]</a>
                    </div>
                    <!--手机-->
                   <!-- <span style="color:red; margin-left:100px;" id="spancheck">${check0}</span>
                    <input type="hidden" name="cityId" value="${cityId}">
                    <input type="hidden" name="couponId" value="${couponId}">
                    <input type="hidden" name="page" value="4">-->
                    <div class="input1" style="margin-bottom: 4px;">
                        <span class="col1">手机：</span>
                        <input type="text" name="userRegisterPhone" id="userRegisterPhone"
                        v-model="registerFromData.userPhone" />
                        <span class="text-red">* 必填</span>
                    </div>
                    <div class="input1" style="line-height: 15px;height: 15px">
                        <span class="col1" style="visibility: hidden">隐藏：</span>
                        <span class="text-red" style="font-size: 13px;">注:手机号即用户名</span>
                    </div>
                    <!--密码-->
                    <div class="input1">
                        <span class="col1">密码：</span>
                        <input type="text" id="userRegisterPassWord"  name="userRegisterPassWord"   />
                        <span class="span-must-input text-red">* 必填</span>
                    </div>
                    <!--确认密码-->
                    <div class="input1">
                        <span class="col1" style="line-height: 20px;">确认<br/>密码：</span>
                        <input type="text" id="userRegisterPassWordTwo" name="userRegisterPassWordTwo"
                               v-model="registerFromData.userPassWord"/>
                        <span class="text-red">* 必填</span>
                    </div>
                    <!--姓名-->
                    <div class="input1">
                        <span class="col1">姓名：</span>
                        <input type="text" name="userRegisterName" id="userRegisterName"
                               v-model="registerFromData.userName"/>
                        <span class="text-red">* 必填</span>
                    </div>
                    <!--邮箱-->
                    <!--  <%--<div class="input1">--%>
                         <%--<span class="col1">邮箱：</span>--%>
                         <input type="hidden" name="userEmail" id="userEmail" value="0"/>
                          <%--<span class="text-red"></span>--%>
                     <%--</div>--%> -->
                </div>
            </form>
            <div class="submit-btn" style="width:40%;margin-top:0px; margin-left:37px;">
                <a @click="formSubmit()">立即注册</a>
                <!--  &nbsp;&nbsp;&nbsp;&nbsp;<a style="color:gray;float:right;" onclick="insertUser();">已有账户？</a>-->
                <!-- <a style="color:gray;float:right;" onclick="history.go(-1)">返回</a>-->
            </div>
            <div class="submit-btn"    style="margin-right:10px;margin-top:-39px; width:30%;float:right;">
                <a   @click="goToDiv('loginDiv')">已有账户</a>
            </div>

            <p style="text-align: center; line-height: 32px; font-size: 14px; color:#585858;margin-left:40px;margin-top:13px;"> 查看当前 <a style="text-decoration: underline; color:#585858;" href="selectCityActivitiesById.action?cityId=${cityId}">城市优惠券</a>信息</p>
            <p style="text-align: center;">友情提示：请牢记用户名和密码。</p>

            <!--   <p style="text-align: center; line-height: 32px; font-size: 14px; color:#585858;">注册所属城市：<a style="text-decoration: underline; color:#585858;" href="selectCityByInsertUser.action?cityId=${cityId}">${map1.cityName}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点击查看当前所属 ${map1.cityName}<a style="text-decoration: underline; color:#585858;" href="selectCityActivitiesById.action?cityId=${cityId}">城市优惠券</a> 信息</p> -->

        </div>



        <!-- 登录用  form表单 div区域 -->

        <div class="sign-in"  id="loginDiv"   v-else>
            <form method="get" name="form1" id="loginForm" action="" >
                <!--手机-->

                <!--<span style="color:red; margin-left:100px;" >${check0}</span>
                <input type="hidden" name="cityId" id="cityId"  value="${map0.cityId}">
                <input type="hidden" name="page" value="4">-->
                <div class="input1" style="margin-bottom: 4px;">
                    <span class="col1">手机：</span>                                       <!-- id编号, 检查参数类型，登录或注册类型  -->
                    <input type="text" name="userLoginPhone"   placeholder="请输入手机号"    id="userLoginPhone" v-model="loginFromData.userPhone"  />
                    <span class="text-red">* 必填</span>
                </div>
                <div class="input1" style="line-height: 15px;height: 15px">
                    <span class="col1" style="visibility: hidden">隐藏：</span>
                    <span class="text-red" style="font-size: 13px;">注:手机号即用户名</span>
                </div>
                <!--密码-->
                <div class="input1">
                    <span class="col1">密码：</span>
                    <input type="password" name="userLoginPassWord" id="userLoginPassWord"  v-model="loginFromData.userPassWord"
                           placeholder="请输入登录密码"   />
                    <span class="span-must-input text-red">* 必填</span>
                </div>
            </form>
            <div class="submit-btn"   style="width:40%;margin-top:0px; margin-left:60px;">
                <a @click="formSubmit()">立即登录</a>
            </div>
            <div class="submit-btn"    style="margin-right:6px;margin-top:-39px; width:30%;float:right;">
                <a   @click="goToDiv('registerDiv')">注册</a>
            </div>
        </div>


    </div>
</template>

<script>
    import axios from 'axios/dist/axios.min.js';
    import configData from '../../public/config.json';
    import qs from 'qs/dist/qs.js';
    /*一般的Vue轻量级插件 在vue组件中 外联 按需引入即可*/
    import  $cookies from 'vue-cookies';
    //const Base64=require('js-base64').Base64;
    import jm from "../assets/js/aes/jiami.js";
    import "../assets/js/inputCheck/jquery.validate.min.js";
  import  "../assets/js/inputCheck/messages_zh.js";
    export default {
        name: "LoginPage",
        data(){
            return{
                isDisable:false,
                display:this.$route.query.display,
                cityName:this.$route.query.cityName,
                registerFromData:{
                    userPhone:'',
                    userPassWord:'',
                    userName:'',
                    cityId:this.$route.query.cityId,
                },
                loginFromData:{
                    /* userPhone:$cookies.get("userPhone")==null?'':Base64.decode($cookies.get("userPhone")),
                    userPassWord:$cookies.get("userPassWord")==null?'':Base64.decode($cookies.get("userPassWord")),*/
                    userPhone:$cookies.get("userPhone")==null?'':jm.jiemi($cookies.get("userPhone")),
                    userPassWord:$cookies.get("userPassWord")==null?'':jm.jiemi($cookies.get("userPassWord")),
                    cityId:this.$route.query.cityId,

                }
            }
        },mounted() {
            const _this=this;

            $(function () {
                _this.validFrom(_this.display);
            })

        },methods:{
            layMsg:function(msg,icoInt){
                layui.use(['laypage','layer','laydate'],function () {
                    layer.msg(msg, {icon: icoInt,time:2000, shade:0.4});
                });
            },
            goToDiv:function(display){
                this.display=display;

                const _this=this;
                $(function () {
                    _this.validFrom(_this.display);
                })
            },
            formSubmit:function() {
                const _this = this;
                if (this.validFrom(this.display).form()) {
                    let formUrl = this.display === "loginDiv" ? "checkOrLoginUserMain" : "registerUserOne";
                    let formData = this.display === "loginDiv" ? this.loginFromData
                        : this.registerFromData;
                      if(_this.isDisable){
                       _this.layMsg("当前操作过于频繁！请待会再操作",5);
                   }else{
                    axios.post(configData.url+ formUrl, qs.stringify(formData)).then(function (response) {
                        let data = response.data;
                        if (data.code === 200) {
                            if (_this.display === 'loginDiv') {
                                if (data.data.msg) {
                                    _this.isDisable = !_this.isDisable;
                                   /* _this.loginFromData.userName=data.data.userName;
                                    _this.loginFromData.userId=data.data.userId;*/
                                    _this.layMsg("登录成功！", 6);
                                    /* 前端数据 对登录信息的cookie缓存
                                    * */
                                    /*$cookies.set("userPhone",Base64.encode(_this.loginFromData.userPhone),'7d');
                                    $cookies.set("userPassWord",Base64.encode(_this.loginFromData.userPassWord),'7d');*/
                                    $cookies.set("userPhone",jm.jiami(_this.loginFromData.userPhone),'7d');
                                    $cookies.set("userPassWord",jm.jiami(_this.loginFromData.userPassWord),'7d');
                                    /*使用Vue本身自带的 sessionStarage关键字
                                    处理数据的存储问题
                                    setItem*/
                                    sessionStorage.setItem("userData",jm.jiami(JSON.stringify(data.data)));
                                    _this.$router.push('#/indexPage?cityId='+_this.loginFromData.cityId);
                                    setTimeout(() => {
                                        _this.isDisable = !_this.isDisable;
                                    }, 5000);
                                } else {
                                    _this.layMsg("抱歉，登录失败,请检查账户密码后重新登录", 5);
                                }
                            } else {
                                if (data.data) {
                                    _this.isDisable = !_this.isDisable;
                                    _this.layMsg("注册成功！", 6);
                                    _this.registerFromData.userPhone='';
                                    sessionStorage.setItem("userData",jm.jiami(JSON.stringify(_this.registerFromData)));
                                    _this.$router.push('#/indexPage?cityId='+_this.registerFromData.cityId);
                                    setTimeout(() => {
                                        _this.isDisable = !_this.isDisable;
                                    }, 5000);
                                } else {
                                    _this.layMsg("抱歉，账户注册失败,请检查录入数据后重新注册", 5);
                                }
                            }

                        } else {
                            _this.layMsg(data.message, 5);
                        }
                        /*执行 axios的错误回调函数 失败回调函数中存在err形式参数
                      * 然后返回的异步json  为err.response.data*/
                    }).catch(function (err) {
                        _this.layMsg(err.response.data.message, 5);
                    });
                }
            }else {
                    this.layMsg('抱歉，填写表单数据不完整', 5);
                }
            },
            validFrom:function (display) {
                /*自定义 验证规范  定义正则演示*/
                const _this=this;
               /* $.validator.addMethod("checkUserLoginPhone", function (value, element) {
                     let tel = /^[0-9]{12}$/;
                       return this.optional(element) || (tel.test(value));

                    return this.optional(element) || (_this.checkUserMain(value));
                }, "此用户名手机号不存在");

                $.validator.addMethod("checkUserRegisterPhone", function (value, element) {

                    return this.optional(element) || (!_this.checkUserMain(value));
                }, "此用户名手机号已存在");*/

                if(display==="loginDiv"){
                return $("#loginForm").validate({
                    /*花样触发验证*/
                    onfocusin: function (element) {
                        $(element).valid();
                    },
                    onfocusout: function (element) {
                        $(element).valid();
                    },
                    onclick: function (element) {
                        $(element).valid();
                    },
                    onkeyup: function (element) {
                        $(element).valid();
                    },
                    rules: {
                        userLoginPhone: {
                            /*表示为必填项*/
                            required: true,
                            /*表示为最小长度 需要达到*/
                            minlength: 11,
                            /*自定义 验证规则 remote为axjx检测 异步交互方式*/
                            remote: {
                                type: "post",
                                url: configData.url+"checkOrLoginUserMain",
                                data: {
                                    userPhone: function() {
                                        return $("#userLoginPhone").val();
                                    }
                                },
                                dataType: "json",
                                dataFilter: function(data, type) {
                                    const jsondata=JSON.parse(data);
                                  if(jsondata.code===200){
                                      if (jsondata.data.msg)
                                          return true;
                                      else
                                          /*只有remote 自定义检查异步回调为false时
                                          * 才出现messages 输入框异常提示信息*/
                                          return false;
                                  }else{
                                      _this.layMsg(jsondata.message,6);
                                      return false;
                                  }
                                  }

                            }
                        },
                        userLoginPassWord: {
                            required: true,
                            minlength: 6,
                        }
                    },  /*提示信息管理*/
                    messages: {
                        userLoginPhone: {
                            required: "请输入登录用户名",
                            minlength: "手机号长度不能小于 11 位",
                            remote: "登录用户名不存在",
                        },
                        userLoginPassWord: {
                            required: "请输入登录密码",
                            minlength: "密码长度不能小于 6 位",
                        },
                        //提交表单后，（第一个）未通过验证的表单获得焦点
                        focusInvalid: true,
                        //当未通过验证的元素获得焦点时，移除错误提示
                        focusCleanup: true,
                    },

                });
            }else{

                    return $("#registerForm").validate({
                        /*花样触发验证*/
                        onfocusin: function (element) {
                            $(element).valid();
                        },
                        onfocusout: function (element) {
                            $(element).valid();
                        },
                        onclick: function (element) {
                            $(element).valid();
                        },
                        onkeyup: function (element) {
                            $(element).valid();
                        },
                        rules: {
                            userRegisterPhone: {
                                /*表示为必填项*/
                                required: true,
                                /*表示为最小长度 需要达到*/
                                minlength: 11,
                                /*自定义 验证规则*/
                              /*  checkUserRegisterPhone: true,*/
                                remote: {
                                    type: "post",
                                    url: configData.url+"checkOrLoginUserMain",
                                    data: {
                                        userPhone: function() {
                                            return $("#userRegisterPhone").val();
                                        }
                                    },
                                    dataType: "json",
                                    /*异步交互 成功返回 回调函数*/
                                    dataFilter: function(data, type) {
                                        const jsondata=JSON.parse(data);
                                        if(jsondata.code===200){
                                            if (!jsondata.data.msg)
                                                return true;
                                            else
                                                /*只有remote 自定义检查异步回调为false时
                                                * 才出现messages 输入框异常提示信息*/
                                                return false;
                                        }else{
                                            _this.layMsg(jsondata.message,6);
                                            return false;
                                        }
                                    }

                                }

                            },
                            userRegisterPassWord: {
                                required: true,
                                minlength: 6,
                            },
                            userRegisterPassWordTwo: {
                                required: true,
                                minlength: 6,
                                equalTo: "#userRegisterPassWord"
                            },
                            userRegisterName:{
                                required: true,
                                rangelength:[2,4],
                            }
                        },  /*提示信息管理*/
                        messages: {
                            userRegisterPhone: {
                                required: "请输入注册用户名",
                                minlength: "手机号长度不能小于 11 位",
                                remote:"注册用户名已存在",
                            },
                            userRegisterPassWord: {
                                required: "请输入注册密码",
                                minlength: "密码长度不能小于 6 位",
                            },
                            userRegisterPassWordTwo: {
                                required: "请输入注册确认密码",
                                minlength: "确认密码长度不能小于 6 位",
                                equalTo: "两次密码输入不一致",
                            },
                            userRegisterName:{
                                required: "请输入注册用户姓名",
                                rangelength:"用户姓名在2-4位之间"
                            },
                            //提交表单后，（第一个）未通过验证的表单获得焦点
                            focusInvalid: true,
                            //当未通过验证的元素获得焦点时，移除错误提示
                            focusCleanup: true,
                        },

                    });

                }
            }

        }
    }
</script>
<style scoped src="layui-src/dist/css/layui.css"></style>
<style scoped src="../assets/css/style7.css"></style>
<style scoped>
    .sign-in {  height: 68%;}
</style>