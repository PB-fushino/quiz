var app =new Vue({
    el:'#app',
    data:{
        message:'hello!'
    }
})

var abcd = new Vue({
    el:"#abcd",  //vueのインスタンスが紐づくDOM要素ののセレクタ
    data:{      //ここで定義した値がv-model="hoge"や{{hoge}}の初期値に反映される
      url:"http://127.0.0.1/",//v-model="url"の初期値
      param:"{}",             //v-model="param"の初期値
      result:"...."           //v-model="result"の初期値
    },
    methods:{//v-on:click="hoge"などのイベントに紐づく関数定義
      post: function(){ //v-on:click="post"時の処理
        //Axiosを使ったAJAX
        //リクエスト時のオプションの定義
        config = {
          headers:{
            'X-Requested-With': 'XMLHttpRequest',
            'Content-Type':'application / x-www-form-urlencoded'
          },
          withCredentials:true,
        }
        //vueでバインドされた値はmethodの中ではthisで取得できる
        param = JSON.parse(this.param)

        //Ajaxリクエスト
        /*
          Axiosはプロミスベースのモジュールなので
　　　　　　　.thenや.catchを使う。
　　　　　　　.then((res => {}))の内側ではスコープが違うので
　　　　　　　Vueでバインドされた値をthisでは取れない
        */
        axios.post(this.url,param,config)
        .then(function(res){
          //vueにバインドされている値を書き換えると表示に反映される
          abcd.result = res.data
          console.log(res)
        })
        .catch(function(res){
          //vueにバインドされている値を書き換えると表示に反映される
          abcd.result = res.data
          console.log(res)
        })
      }
    }
  })