import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import ProductSearch from '@/components/ProductSearch'
import ProductUpdate from '@/components/ProductUpdate'
import ProductCreate from '@/components/ProductCreate'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(Router)
Vue.use(ElementUI);

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/productsearch',
      name: 'ProductSearch',
      component: ProductSearch
    },
    {
      path: '/productupdate',
      name: 'ProductUpdate',
      component: ProductUpdate
    },
    {
      path: '/productcreate',
      name: 'ProductCreate',
      component: ProductCreate
    }
  ]
})
