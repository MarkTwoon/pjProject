import { createRouter, createWebHashHistory } from 'vue-router'
//import Home from '../views/Home.vue'


const routes = [
  {
    path: '/',
    redirect: '/cityStartPage'
  },
  {
    path: '/cityStartPage',
    name: 'cityStartPage',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import( '../views/cityStartPage.vue')
},{
  path:'/indexPage',
  name:'indexPage',
    component: () => import( '../views/indexPage.vue')
  },
  { path:'/:pathMatch(.*)',
    redirect: '/404',
  },
  {
    path:'/404',
    name:'404',
    component: () => import( '../views/404.vue')
  },{
    path:'/loginPage',
    name:'LoginPage',
    component: () => import( '../views/LoginPage.vue')
  },{
  path:'/userMainPage',
    name:'UserMainPage',
    component: () => import( '../views/UserMainPage.vue')
  },{
  path:'/test',
    name:'testPage',
    component: () => import( '../views/testPage.vue')
  }
]
/*const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/!* webpackChunkName: "about" *!/ '../views/About.vue')
  }
]*/

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
