import { createStore } from 'vuex'

import axios from "axios/dist/axios.min.js";
import Qs from 'qs/dist/qs.js'

export default createStore({
  state: {
     apiUrl:"",
  },
  getters:{
  },
  mutations: {
    /*getUnReadPraise(state, userName){
      axios.post("/api/message/unReadPraise",Qs.stringify({'userName':userName}))
        .then(res => {
          state.unReadInfo['unReadPraise'] = res.data.data;
        }).catch(err=>{
          console.error(err);
        })
    },

    getUnReadComment(state, userName){
      axios.post("/api/message/unReadComment",Qs.stringify({'userName':userName}))
          .then(res => {
            state.unReadInfo['unReadComment'] = res.data.data;
          }).catch(err=>{
        console.error(err);
      })
    },*/

  },
  actions: {},
  modules: {}
})
