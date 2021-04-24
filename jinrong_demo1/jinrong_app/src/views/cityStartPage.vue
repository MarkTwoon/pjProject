<template>
    <div id="header" class="header_main">城市选择<a href="javascript:history.back();"  class="back"></a><a class="cd-popup-trigger button2"></a></div>
    <div class="h60"></div>



    <div class="container" >
        <div class="hotcity"  id="hotcity">
            <span>热门城市</span>

            <template  v-for="city in cityList">
            <a data-id='420100'  :href="'#/indexPage?cityId='+city.cityId">{{city.cityName}}</a>
            </template>
            <h2 style="color: red;" v-show="msg!=''">{{msg}}</h2>
        </div>

        <div class="letter">
            <ul  id="ul0">

            </ul>
        </div>
    </div>
</template>

<script>
    import axios from 'axios/dist/axios.min.js';
    import qs from 'qs/dist/qs.js';
    import '../assets/js/zepto.js';
import configData from '../../public/config.json';
    export default {
        name: "cityStartPage",
        data(){
          return{
              cityList:[],
              msg:'',
          }
        },
        mounted() {
            const _this=this;
            axios.post(configData.url+'getCityData',{}).then(function (response) {
                const data=response.data;
                if(data.code==200){
                    _this.cityList=data.data;
                }else{
                    _this.msg=data.message;
                }

            });
        }
    }
</script>
<style scoped src="../assets/css/style.css">

</style>
<style scoped>

</style>