import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueLazyLoad from 'vue3-lazyload'


// createApp(App).use(router).use(VueLazyload, {
//     preLoad: 1.3,
//     error: require('./assets/img/error.png'),
//     loading: require('./assets/img/loading.gif'),
//     attempt: 1
// }).mount('#app')

/*
createApp(App).use(router,VueLazyLoad,{
    preLoad: 1.3,
      error: require('./assets/img/error.png'),
      loading: require('./assets/img/loading.gif'),
      attempt: 1
}).mount('#app')*/
const app = createApp(App)
app.use(router)
app.use(VueLazyLoad, {
    preLoad: 1.3,
    error: require('./assets/img/error.png'),
    loading: require('./assets/img/loading.gif'),
    attempt: 1
})
app.use(store)
app.mount('#app')