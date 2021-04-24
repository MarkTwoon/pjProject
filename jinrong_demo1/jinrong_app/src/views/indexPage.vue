
<template>
    <div class="topbar"   id="topbar">

        <a class="fl" style="text-decoration: underline;margin-right: 16px;color: #666;" href="#/cityStartPage" id="cityName">{{data1.cityName}}</a>
        <span> <i class="red" id="readMan">{{data1.readMan}}</i>人查看</span>
        <span> <i class="red"  id="shareMan">{{data1.shareMan}}</i>人分享</span>
        <span> <i class="red"  id="joinUser">{{data1.joinUser}}</i>人报名</span>
        <a class="fl"  v-if="userData == null "
           style="text-decoration: underline;margin-right: 16px; color: #666;" id="f1" @click="goToLogin('loginDiv')">会员登录<!--退出--></a>
        <a class="fl"  v-else
           style="text-decoration: underline;margin-right: 16px; color: #666;" id="f2" @click="goToLogin('');">个人中心<!--退出--></a>

    </div>
    <div class="b">

        <span id="lb" style="top:100px;left:100px;position:fixed;z-index:999;float: left;"></span>
        <img id="couponImg0"  :src="couponImg" alt="" style="width:100%;">
    </div>

    <!--参与报名-->
    <div class="toSign re">
        <div class="roast"  >

            <marquee  id="marquee1" direction="up" scrolldelay="600" height="40px" style="text-align:center;">
                <!--<c:forEach items="${list001}" var="list1" varStatus="status">
                    <i class="red">${list1.userName}</i>于 ${list1.shareTime} 成功砍至底价 <br>
                    <span>&nbsp;</span><br>
                </c:forEach>-->

                <template v-for="user in winUsers" v-if="typeof winUsers=='object'" >
                <i class="red">{{user.userName}}</i>于 {{user.shareTime}} 成功砍至底价 <br>
                <span>&nbsp;</span><br>
                </template>
                <i class="red" v-show="typeof winUsers=='string'">{{winUsers}}</i>
            </marquee>
        </div>

        <form action="">
            <div class="input2">
                <span class="col1">城市：</span>
                <input type="text"  id="cityName0" :value="data2.cityName" readonly="readonly"/>
            </div>
            <div class="input2">
                <span class="col2">价格：</span>
                <input type="text" id="cityPrice1" :value="data2.couponOldPrice" readonly="readonly"/>
            </div>
            <div class="input2">
                <span class="col1">姓名：</span>
                <input type="text" id="userName0"  :value="userName" readonly="readonly" />
            </div>
            <div class="input2">
                <span class="col2">底价：</span>
                <input type="text" id="cityPrice0" :value="data2.couponLowPrice" readonly="readonly"/>
            </div>
        </form>
        <img src="../assets/images/toSign-bg.png" alt="" width="750" style="width:100%; float: left;">
        <div class="btn" v-if="userData == null">
            <img src="../assets/images/btn.png" alt="" width="200" style="width:100%; float: left;" @click="goToLogin('registerDiv')">
        </div>
        <div class="btn" v-else>
            <img src="../assets/images/btn_pay.png" alt="" width="200" style="width:100%; float: left;" @click="goToPay()">
        </div>
    </div>



    <!--本期活动商家列表-->
    <div class="wrap-activity re" style="padding-bottom: 60px">
        <div class="money">
            <img src="../assets/images/money.png" alt="" width="50">
        </div>
        <div class="re">
            <img style="margin-bottom: 0px;  padding-bottom: 0px;" class="topimg re" src="../assets/images/activity-bg.png" alt="" width="750">
        </div>

        <ul class="ProCt zm" id="businessTypeEach">
           <!-- <c:forEach items="${list0}" var="list1" varStatus="status">

                <li>
                    <a href="selectAllActivitiesById.action?cityId=${map007.cityId}&businessTypeId=${list1.businessTypeId}&check0=${check0}&loginState=0">
                        <i><img src="../assets/images/icon${status.index + 1}.png" width="62" height="62" alt=""></i>
                        <span>${list1.businessTypeMain}</span>
                    </a>
                </li>
            </c:forEach>-->
            <li v-for="(businessType,index) in businessTypeList" v-if="typeof businessTypeList=='object'">
                <a href="javascript:void(0)" @click="couponGoodsData(businessType.businessTypeId)" >
                    <i><img :src="require('../assets/images/icon'+(index+1)+'.jpg')" width="62" height="62" alt=""></i>
                    <span>{{businessType.businessTypeMain}}</span>
                </a>

            </li>
            <li v-show="typeof businessTypeList=='string'">
                <h2 style="color: red">{{businessTypeList}}</h2>
            </li>
        </ul>

        <ul class="wrap-activity-card zm" id="businessActivities">


           <!-- <c:forEach items="${list}" var="list1" varStatus="status">
                <li class="zm on re" style="z-index: 1;">
                    <div class="fl imgbox" onclick="selectBusinessById('${list1.businessId}','${list1.activitiesId}');">
                        <div class="line"></div>
                        <img src="/ssm/upload/${list1.activitiesImg}" alt="" style="width:100%;">
                    </div>
                    <div class="fl use-on"  >
                        <span onclick="go3();"  style="margin:0 auto;width:40px;line-height:40px;">${list1.activitiesPrefeRential}</span>
                    </div>
                </li>
            </c:forEach>-->
            <li class="zm on re" style="z-index: 1;"
                v-for="(good,index) in goodsList"
            v-show="typeof goodsList=='object'">
                <div class="fl imgbox" onclick="selectBusinessById('${list1.businessId}','${list1.activitiesId}');">
                    <div class="line"></div>
                    <!--<img
                            :src="require('../assets/upload/'+good.activitiesImg)" alt="" style="width:100%;">-->
                    <img
                        v-lazy="{src:require('../assets/upload/'+good.activitiesImg)}"
                        alt="" style="width:100%;" :key="'img'+index">
                </div>
                <div class="fl use-on"  >
                    <span onclick="go3();"  style="margin:0 auto;width:40px;line-height:40px;">{{good.activitiesPrefeRential}}</span>
                </div>
            </li>

            <li v-show="typeof goodsList=='string'"><h2 style="color: red">{{goodsList}}</h2></li>
        </ul>
        <div id="moreTo"></div>
        <a   style="z-index: 1;" @click="lazyLoadingOut()">
            <div class="moreTo"  >
                <span id="zuhao" > 下滑出现更多商家信息</span>
            </div>
            <img id="absolute0"    style="position: absolute; left: 50%; bottom: 65px; margin: 0 0 0 -14px;z-index:1;"  src="../assets/images/go-b.png" alt="" width="28">
        </a>
        <div class="money-btm" id="moreOnclick">
            <!--  <img src="../assets/images/money-btm.png" alt="" onclick="listMore0();" width="750" style=" width: 100%; float: left; position: relative; z-index: 99;"> -->
        </div>

        <div class="money-btm">
            <img src="../assets/images/money-btm.png" alt="" width="750" style=" width: 100%; float: left; position: relative; z-index: -1;">
        </div>
    </div>



    <!--活动规则-->
    <div class="rule">
        <img src="../assets/images/rule-bg.png" alt="" width="750"       style="width:100%; float: left;">
        <div class="rule-font">
            1. 活动参与流程：<br/>
            <img src="../assets/images/f1.png" alt="" width="750" style="width:100%;"><br/>
            2. 到店使用流程：<br/>
            <img src="../assets/images/f2.png" alt="" width="750" style="width:100%;"><br/>
            3. 报名成功转发至朋友圈或微信群， 邀请朋友帮忙减价；<br/>
            4. 减至底价后，支付100元即可开始享受活动福利；<br/>
            5. 消费者购卡后，如有新入驻的商家，本网会自行将商家优惠活动同步至所有便宜卡，<br/>
            持卡人无需重新购买，即可享用所有优惠活动；<br/>
            6. 点击商家图片即可查看商家详情；<br/>
            7. 商家在存续期间有效；<br/>
            8. 本期活动有效期至2018年11月11日；<br/>
            9. 平台内任何商家优惠活动不套现；<br/>
            10. 消费前请仔细阅读商家的消费须知；<br/>
            11. 支付成功后费用不予退还；<br/>
            12. 如遇系统繁忙或其它网络故障请点击网址 <a style="color: #de4243"> http://www.pypy.net.cn/ 用浏览器</a>打开登陆；<br/>
            13. 本活动最终解释权归武汉便宜汇信息科技发展有限公司所有。<br/>
        </div>
    </div>




    <div class="cR" style="background: #de4243; position: relative; margin-top: -10px; text-align: center;">
        <img src="../assets/images/z6.png" alt="" width="644" style="width:90%; margin:26px auto 14px;">
        <a href="selectBusinessCommitmentList.action">
            <div class="moreTo" style="color: #fff;  width: 66%; margin: 0 auto 40px; border: 2px solid #fef5e6; font-size: 16px; text-align: center;">
                商家承诺书 点击查看
                <img src="../assets/images/go-b.png" alt="" width="40" style="width: 34px;
    position: absolute;
    left: 50%;
    margin-left: -17px;
    bottom: 8px;">
            </div>
        </a>
    </div>

    <div class="cR-btm" >
        <img src="../assets/images/btm-bg.png" alt="" width="750" style="width:100%; float: left;">
    </div>

    <div id="tong" style="display: none;" @click="userPay()">
        <img src="../assets/images/b9.jpg"  style="width: 100%;height: 100%;">
    </div>
</template>

<script>

    import  cpImg from  '../assets/upload/288d9986-aae3-4aff-83b0-d0d9b921ab6a.jpg';
    import axios from 'axios/dist/axios.min.js';
    import qs from 'qs/dist/qs.js';
    import jm from "../assets/js/aes/jiami.js";
    //const jm=require('../assets/js/aes/jiami.js');
    import configData from '../../public/config.json';
    export default {
        name: "indexPage",
        data(){
            return{
                cityId:this.$route.query.cityId,
                // couponImg:this.$route.query.couponImg==undefined? cpImg:require("../assets/images/"+this.$route.query.couponImg+""),
                couponImg:cpImg,
                data1:'',
                data2:'',
                userName:'',
                winUsers:'',
                markId:1,
                /*商家类型 与商品数据 对象*/
                businessTypeList:'',
                goodsList:'',
                userData:JSON.parse(jm.jiemi(sessionStorage.getItem("userData"))),
            }
        },
        mounted() {
            const _this=this;
            axios.post(configData.url+'indexPageMainData',qs.stringify({
                'cityId':_this.cityId,
                'userId':_this.userData===null?'':_this.userData.userId})).then(function (response) {
            const data=response.data;
            if(data.code===200){
                _this.data1=data.data.indexData1;
                _this.data2=data.data.indexData2;

                _this.userName=_this.userData==null?'暂未登录':_this.userData.userName;
                _this.couponImg=require('../assets/upload/'+_this.data2.couponImg);
                if(_this.userData!=null&&_this.data2.couponOldPrice<=_this.data2.couponLowPrice){
                    layui.use(['laypage','layer','laydate'],function () {
                    layer.open({
                        type: 1,
                        title: false,
                        closeBtn: 0,
                        offset: ['200px', '14px'],
                        area: ['350px', '800px'],
                        skin: 'layui-layer-nobg', //没有背景色
                        shade:0.3,
                        shadeClose: true,
                        content: $('#tong')
                    });
                    })
                }

            }else{
               layui.use(['laypage','layer','laydate'],function () {
                   layer.msg(data.message,{icon: 6,time:2000, shade:0.4}
                   ,function(){
                           _this.$router.push('/');
               });
               })

            }
            });

        setTimeout(_this.getWinUsers,500);
            setTimeout(_this.couponGoodsData(''),610);
        },methods:{
            userPay:function(){
                console.log('我是支付 -触发函数体');
            },
            goToPay:function () {
        if(this.userData!=null&&this.data2.couponOldPrice<=this.data2.couponLowPrice){
            layui.use(['laypage','layer','laydate'],function () {
                layer.open({
                    type: 1,
                    title: false,
                    closeBtn: 0,
                    offset: ['200px', '14px'],
                    area: ['350px', '800px'],
                    skin: 'layui-layer-nobg', //没有背景色
                    shade:0.3,
                    shadeClose: true,
                    content: $('#tong')
                });
            })
        }else{
            layui.use(['laypage','layer','laydate'],function () {
                layer.msg('还未到达领奖门槛，再接再厉哟！', {icon: 7,time:2000, shade:0.4});
            });
        }
            },
            couponGoodsData:function(businessTypeId){
                /*一个异步交互过程  返回2个list查询结果集 回调中注意区分
                * DOM中  也需要2个v-for DOM迭代*/
                const _this=this;
                /*先清除原有for迭代的DOM元素 再进行axios回调的新数据替换*/
                this.goodsList='';
              axios.post(configData.url+'businessTypeAndGoodsData',qs.stringify({'cityId':this.cityId,'businessTypeId':businessTypeId,'markId':this.markId})).then(function(response){
                    if(_this.markId===1){
                        /*商家类型数据 在前端也只会赋值一次 迭代一次*/
                        _this.businessTypeList=response.data.data.businessTypeList;
                        _this.markId++;
                    }
                     _this.goodsList=response.data.data.goodsList;

              });

            },
            getWinUsers:function () {
                const  _this=this;
                 axios.post(configData.url+'winUserData',qs.stringify({'cityId':this.cityId})).then(function (response) {
                    const  data=response.data;

                    if(data.code==200){

                    _this.winUsers=data.data;
                  /*  alert(typeof _this.winUsers);*/
                       setTimeout(_this.getWinUsers,parseInt(1000*60*2.2));
                    }else{
                        _this.winUsers=data.message;
                    }
                })
            },
            lazyLoadingOut:function () {
                layui.use(['laypage','layer','laydate'],function () {
                    layer.msg('活动优惠券已经到达展示尾页', {icon: 6});
                });

            },
            goToLogin:function(divType){
                let routerPage='';
                if(divType.indexOf('Div')>-1){
                    routerPage='#/loginPage?' +
                        'cityId='+this.cityId+'&display='+divType
                        +'&cityName='+this.data2.cityName;
                }else{
                   /*指向个人中心 vue组件*/
                    routerPage='#/userMainPage?' +
                        'cityId='+this.cityId
                        +'&cityName='+this.data2.cityName
                        +'&userData='+JSON.stringify(this.userData);
                }
                this.$router.push(routerPage);
            }
        },computed:{
           /* couponImg:function(){
                return  this.$route.query.couponImg==undefined?'../assets/images/couponImg.jpg':this.$route.query.couponImg;
            }*/
        }
    }
</script>
<style scoped src="layui-src/dist/css/layui.css"></style>
<style scoped src="../assets/css/style.css"></style>
<style scoped >
    .wrap-activity a {line-height: 32px; }
    .dDown {position: absolute; top: 23%;  width: 100%;font-size: 16px; line-height: 34px;text-align: center;  z-index: 109; margin-left: -20px;}
    .dDow a{color: #888;  }
    .dDown .heart { color: #dcdbdb;font-size: 15px;padding-left: 25px;height: 26px;line-height: 26px;background:url(../assets/images/c-no.png) no-repeat left;
        position: absolute;top: 4%;right: 0%;background-size: 22px;z-index: 101;}
    .dDown>a{width: 38%; font-size: 16px; color: #fff;position: relative; background: #262626;border: 1px solid #fff;
        text-align: center;margin: 0 auto 26px;}
    .dDown ul{width: 38%; margin: -26px auto 0;position: relative;z-index:999;background:#545454;border: 1px solid #5d5d5d;}
    .dDown li{ height:32px; line-height: 32px; font-size: 14px;}
    .dDown li:hover{background: #949292;;}
    @media only screen and (max-width: 620px) {
        .dDown {top: 22%;}
    }
    @media only screen and (max-width: 548px) {
        .dDown {top: 21%;}
    }
    @media only screen and (max-width: 460px) {
        .dDown {top: 19%;}
    }
    @media only screen and (max-width: 380px) {
        .dDown {top: 18%;}
    }
    @media only screen and (max-width: 320px) {
        .dDown {top: 17%;}
    }
    /* 首页icon*/
    .ProCt{margin: 0 10px 14px;;}
    .ProCt li{ width: 25%; float: left; margin: 12px 0px 30px;text-align: center;}
    .ProCt li img{ margin:  0 auto;}
    .ProCt li span{ color:#d0d0d0; line-height: 18px; padding-top:8px; display: block; font-size: 14px;}
</style>
