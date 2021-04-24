<template>
    <div id="header" class="header_main">个人中心<a onclick="history.go(-1)" class="back"></a></div>
    <div class="h60"></div>

    <div class="adbox">
        <img class="re fl" src="../assets/images/person-bg.jpg" width="100%"
             style="max-width: 750px;width: 700px;">
        <div class="adbox-img">
            <img class="tx" :src="imgName"   style="width: 160px;height: 200px;" alt="">
            <span>{{userData.userName}}</span>
            <br> <br>
           <!-- <span style="font-size:18px;">${check0}</span>-->
        </div>
    </div>

    <div class="home_fast">
        <ul class="zm">
            <li>
                <a href="javascript:void(0)">

                    <span class="icon b3">
                        <form id="userForm" method="post"
                              enctype="multipart/form-data">
                    <input type="file" id="userImg" name="userImg" @change="userImgUpload()">
                    </form>
                    </span><span>我的活动</span>
                </a>
            </li>
            <li>
                <a href="selectCollectionCouponById.action?userId=${map.userId}&cityId=${map.cityId}">
                    <span class="icon b6"></span><span>我的收藏</span>
                </a>
            </li>
            <li>
                <!--   <a href="selectNewBusinessByUserId.action?userId=${map.userId}">-->
                <a href="selectAllShoppingMainByUserId.action?userId=${map.userId}&cityId=${map.cityId}">
                    <span class="icon b8"></span><span>消费记录</span>
                </a>
            </li>
            <li>
                <a href="selectUserAllMainById.action?userId=${map.userId}&cityId=${map.cityId}">
                    <span class="icon b1"></span><span>我的资料 </span>
                </a>
            </li>
            <li>
                <a href="ask.jsp?userId=${map.userId}">
                    <span class="icon b7"></span><span>客服中心</span>
                </a>
            </li>
            <li>
                <a onclick="out0();">
                    <span class="icon b9" ></span><span>退出登录</span>
                </a>
            </li>
        </ul>
    </div>
</template>

<script>
    import axios from 'axios/dist/axios.min.js';
    import configData from '../../public/config.json';
    export default {
        name: "UserMainPage",
        data(){
            return{
                userData:JSON.parse(this.$route.query.userData),
                imgName:require('../assets/images/tx.png'),
            }
        },mounted() {
            const  _this=this;

        },methods:{
            userImgUpload:function () {
           // alert($("#userImg").val());
                const _this=this;
            if($("#userImg").val()!=''&&
                $("#userImg").val()!=null&&$("#userImg").val()!=undefined){
            var userForm=new FormData(document.getElementById("userForm"));
           axios.post(configData.url+'userImgUpload',userForm).then(function(response){
            var data=response.data;
           // alert(data.data.imgName);
               _this.imgName=configData.url+'upload/'+data.data.imgName;
               /*记得imgName 数据信息 存储mysql数据库 UUID生成文件名
               * 给tb_user的 USER_IMG数据字段 update更新记录一下*/
               $("#userImg").val('');
           })
            }else{
                alert('未选择文件！');
            }
            }
        }
    }
</script>

<style scoped src="../assets/css/style.css">

</style>