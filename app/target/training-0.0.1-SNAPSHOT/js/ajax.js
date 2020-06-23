function answer(num){
        stop = new Date();
        // 経過時間をミリ秒で取得
        var ms = stop.getTime() - start.getTime();
        var s = ms / 1000
        console.log("処理時間: " + ms + "ミリ秒");

        var id = localStorage.getItem("id");
        var qid = localStorage.getItem("qid");
        // alert(name);
        $.ajax({
            url : 'http://localhost:8080/answer',
            method : "POST",
            data : {
                id : 1,
                uid : id,
                qid : qid,
                answer : num,
                time: ms
            }
            
        }).done(function(data) {
            if (data != null) {
                
                alert("しばらくお待ちください")
                window.location.href = 'sp_stanby_wait.html';
            } else {
                alert("もう一度回答してください")
                window.location.href = 'index.html';
            }
    
        }).fail(function(data) {
            window.alert('もう一度入力してください');
            console.log(data);
            window.location.href = 'index.html';
        })
    
}

function checkTime(num){
    // alert(num);
    $.ajax({
        url : 'http://localhost:8080/checkTime',
        method : "POST",
        data : {
            qid :num
        }
    }).done(function(data) {
        if (data != null) {
            for (var ans of data) {
                $('.choices_text_win').append
                    ('<p class="choice_text_win">'+ans.username+'さん\n'+ans.time/1000+'秒</p><div class="frame"><img src="/assets/images/sample/images/images/images/ranking_02_07.png"></div>');
                $('.choice_text_win').append
                ('<div class="frame"><img src="/assets/images/sample/images/images/images/ranking_02_07.png"></div>');
              }
               $('.choice_text_win').append
                $('<h1 id="main"" style="font-size:10px; color:white;"></h1>');
        } else {
            alert("もう一度回答してください")
        }

    }).fail(function(data) {
        window.alert('もう一度入力してください');
        console.log(data);
       
    })

}

function change() {
    $('#form').replaceWith('<p id="clarinet">クラリネット</p>');
  };

function login() {
    var name = document.forms.form.name.value;
    $.ajax({
        url : 'http://localhost:8080/login',
        method : "POST",
        data : {
            name : name
        },
        xhrFields : {
           withCredentials : true
       }
    }).done(function(data) {
        if (data != null) {
            console.log(data.name);
            localStorage.setItem("id",data.id);
            localStorage.setItem("username",data.name);
            window.location.href = 'sp_stanby.html';

        } else {
            alert("名前が間違っていませんか？")
            window.location.href = 'index.html';
        }

    }).fail(function(data) {
        window.alert('もう一度入力してください');
        console.log(data);
        window.location.href = 'index.html';
    })
};

function quiz(){

    var domain = "http://localhost:8080/quiz";

    $(function(){
        $.ajax({
            url : domain,
            type : 'GET',
            xhrFields : {
                withCredentials : true
            }
        },
        ).done(function(data){

            for (quiz of data){
                    $('.problem').append
                    (quiz.problem);
                    $('.a').append
                    ('<p class="a">'+quiz.choice_a+'</p>');
                    $('.b').append
                    ('<p class="b">'+quiz.choice_b+'</p>');
                    $('.c').append
                    ('<p class="c">'+quiz.choice_c+'</p>');
                    $('.d').append
                    ('<p class="d">'+quiz.choice_d+'</p>');
            }

        }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
            alert("ajax通信に失敗しました");
            console.log("XMLHttpRequest : " + XMLHttpRequest.status);
            console.log("textStatus     : " + textStatus);
            console.log("errorThrown    : " + errorThrown.message);
        })
    })
    
}

function launchquiz(){

    var domain = "http://localhost:8080/launchquiz";

    $(function(){
        $.ajax({
            url : domain,
            type : 'GET'
        }
        ).done(function(data){
            localStorage.setItem("qid",data.id);

                    $('.problem').append
                    ('<p　id="'+data.id+'">問題：'+data.problem+'</p>');
                    $('.c_text.a').append
                    ('<p class="a"　>'+data.choice_a+'</p>');
                    $('.a').attr("id",data.id);
                    $('.c_text.b').append
                    ('<p class="b"　id="'+data.id+'">'+data.choice_b+'</p>');
                    $('.c_text.c').append
                    ('<p class="c"　id="'+data.id+'">'+data.choice_c+'</p>');
                    $('.c_text.d').append
                    ('<p class="d"　id="'+data.id+'">'+data.choice_d+'</p>');
            

        }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
            alert("ajax通信に失敗しました");
            console.log("XMLHttpRequest : " + XMLHttpRequest.status);
            console.log("textStatus     : " + textStatus);
            console.log("errorThrown    : " + errorThrown.message);
        })
    })
}

function launchquiz_img(){

    var domain = "http://localhost:8080/launchquiz";

    $(function(){
        $.ajax({
            url : domain,
            type : 'GET'
        }
        ).done(function(data){
            localStorage.setItem("qid",data.id);

                    $('.problem').append
                    ('<p　id="'+data.id+'">問題：'+data.problem+'</p>');
                    $('.a').attr('src', '/assets/images/sample/images/images/images/'+data.id+'-a.png');
                    $('.b').attr('src', '/assets/images/sample/images/images/images/'+data.id+'-b.png');
                    $('.c').attr('src', '/assets/images/sample/images/images/images/'+data.id+'-c.png');
                    $('.d').attr('src', '/assets/images/sample/images/images/images/'+data.id+'-d.png');

                    $('.b').append
                    ('<p class="b"　id="'+data.id+'">'+data.choice_b+'</p>');
                    $('.c').append
                    ('<p class="c"　id="'+data.id+'">'+data.choice_c+'</p>');
                    $('.d').append
                    ('<p class="d"　id="'+data.id+'">'+data.choice_d+'</p>');
            

        }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
            alert("ajax通信に失敗しました");
            console.log("XMLHttpRequest : " + XMLHttpRequest.status);
            console.log("textStatus     : " + textStatus);
            console.log("errorThrown    : " + errorThrown.message);
        })
    })
}


function winner(){
    var domain = "http://localhost:8080/winner";
    $(function(){
        $.ajax({
            url : domain,
            type : 'GET',
            xhrFields : {
            withCredentials : true
        }
        }
        ).done(function(data){
            console.log(data);
            $('.check').append
                ('<tr class="item" style="line-height:30px;"><td>位</td><td>名前</td><td>得点</td><td>時間</td></tr>');
            for(i = 0 ; i < data.length ; i++){
                var num = data.length - i -1;
                var rank = num + 1;
                $('.check').append
                ('<tr class="item"><td>'+rank+'位</td><td>'+data[num].username+'さん</td><td>'+data[num].corrects+'</td><td>'+data[num].times/1000+'秒</td></tr>');
              }
        }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
            alert("ajax通信に失敗しました");
            console.log("XMLHttpRequest : " + XMLHttpRequest.status);
            console.log("textStatus     : " + textStatus);
            console.log("errorThrown    : " + errorThrown.message);
        })
    })
}

function checkquiz(){
    var domain = "http://localhost:8080/checkquiz";
    $(function(){
        $.ajax({
            url : domain,
            type : 'GET'
        }
        ).done(function(data){
            localStorage.setItem("qid",data.id);
            console.log(data);

                    $('.problem').append
                    ('<p　id="'+data.id+'">問題：'+data.problem+'</p>');
                    $('.c_text.a').append
                    ('<p class="a"　id="'+data.id+'">'+data.choice_a+'</p>');
                    $('.c_text.b').append
                    ('<p class="b"　id="'+data.id+'">'+data.choice_b+'</p>');
                    $('.c_text.c').append
                    ('<p class="c"　id="'+data.id+'">'+data.choice_c+'</p>');
                    $('.c_text.d').append
                    ('<p class="d"　id="'+data.id+'">'+data.choice_d+'</p>');

                    $('.a').attr('src', '/assets/images/sample/images/images/images/'+data.id+'-a.png');
                    $('.b').attr('src', '/assets/images/sample/images/images/images/'+data.id+'-b.png');
                    $('.c').attr('src', '/assets/images/sample/images/images/images/'+data.id+'-c.png');
                    $('.d').attr('src', '/assets/images/sample/images/images/images/'+data.id+'-d.png');
                    
        }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
            alert("ajax通信に失敗しました");
            console.log("XMLHttpRequest : " + XMLHttpRequest.status);
            console.log("textStatus     : " + textStatus);
            console.log("errorThrown    : " + errorThrown.message);
        })
    })
    
}

function checkquiz_gray(){
    var domain = "http://localhost:8080/checkquiz";
    $(function(){
        $.ajax({
            url : domain,
            type : 'GET'
        }
        ).done(function(data){
            localStorage.setItem("qid",data.id);
            console.log(data);

                    $('.problem').append
                    ('<p　id="'+data.id+'">問題：'+data.problem+'</p>');
                    $('.c_text.a').append
                    ('<p class="a"　id="'+data.id+'">'+data.choice_a+'</p>');
                    $('.c_text.b').append
                    ('<p class="b"　id="'+data.id+'">'+data.choice_b+'</p>');
                    $('.c_text.c').append
                    ('<p class="c"　id="'+data.id+'">'+data.choice_c+'</p>');
                    $('.c_text.d').append
                    ('<p class="d"　id="'+data.id+'">'+data.choice_d+'</p>');

                    switch(data.answer){
                        case 0:
                                $('.gray_out.0').remove();
                                break;
                        case 1:
                                $('.gray_out.1').remove();
                                break;
                        case 2:
                                $('.gray_out.2').remove();
                                break;
                        case 3:
                                $('.gray_out.3').remove();
                                break;
                    }
        }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
            alert("ajax通信に失敗しました");
            console.log("XMLHttpRequest : " + XMLHttpRequest.status);
            console.log("textStatus     : " + textStatus);
            console.log("errorThrown    : " + errorThrown.message);
        })
    })
    
}

function quizAll(){

    var domain = "http://localhost:8080/quiz";

    $(function(){
        $.ajax({
            url : domain,
            type : 'GET',
            xhrFields : {
            withCredentials : true
        }
        }
        ).done(function(data){

            for (i=0;i<data.length;i++){
                    $('.problems').append
                    ('<p class="problem" style="height:30px;font-size:10px;background-color:red;">問題'+data[i].id+'：'+data[i].problem+'</p><div class"choices" id="'+data[i].id+'"></div>');
                    $('.problems').append
                    ('<button  class="choice-a" style="height:30px;font-size:10px;" id="'+data[i].id+'" onclick="change_status(1,'+data[i].id+')">待機</p>');
                    $('.problems').append
                    ('<button  class="choice-b" style="height:30px;font-size:10px;" id="'+data[i].id+'" onclick="change_status(2,'+data[i].id+')">出題</p>');
                    $('.problems').append
                    ('<button  class="choice-c" style="height:30px;font-size:10px;" id="'+data[i].id+'" onclick="change_status(3,'+data[i].id+')">回答チェック</p>');
                    $('.problems').append
                    ('<button  class="choice-d" style="height:30px;font-size:10px;" id="'+data[i].id+'" onclick="change_status(4,'+data[i].id+')">解答発表</p>');
                    $('.problems').append
                    ('<button  class="choice-d" style="height:30px;font-size:10px;" id="'+data[i].id+'" onclick="change_status(5,'+data[i].id+')">優勝者発表</p>');
            }
        }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
            alert("ajax通信に失敗しました");
            console.log("XMLHttpRequest : " + XMLHttpRequest.status);
            console.log("textStatus     : " + textStatus);
            console.log("errorThrown    : " + errorThrown.message);
        })
    })
    
}

function wait() {
    $.ajax({
        url : 'http://localhost:8080/wait',
        method : "POST",
        data : {
            name : "fushino",
        },
            xhrFields : {
            withCredentials : true
        }
    }).done(function(data) {
        if (data != null) {
            // alert("待機");
            console.log(data);
            // localStorage.setItem("id",data.user_id);
            // localStorage.setItem("username",username);
            window.location.href = 'quiz.html';
        } else {
            alert("Miss!")
            window.location.href = 'index.html';
        }

    }).fail(function(data) {
        window.alert('ログイン失敗');
        console.log("NG");
        console.log(data);
        window.location.href = 'index.html';
    })
};

function check_quiz_status_pc() {
    $.ajax({
        url : 'http://localhost:8080/quiz_status',
        method : "GET",
        
    }).done(function(data) {
        if (data != null) {
            // 
            console.log(data);
            // localStorage.setItem("id",data.user_id);
            // localStorage.setItem("username",username);
            if(data.is_img == 1){
            window.location.href = 'pc_quiz_img.html';}
            else if(data.is_img == 0){
            window.location.href = 'pc_quiz.html';}



        } else {
            alert("Miss!")
            window.location.href = 'index.html';
        }

    }).fail(function(data) {
        window.alert('ログイン失敗');
        console.log("NG");
        console.log(data);
        window.location.href = 'index.html';
    })
};

function check_quiz_status_sp() {
    $.ajax({
        url : 'http://localhost:8080/quiz_status',
        method : "GET",
        
    }).done(function(data) {
        if (data != null) {
            // 
            console.log(data);
            // localStorage.setItem("id",data.user_id);
            // localStorage.setItem("username",username);
            if(data.id >= 0){
                window.location.href = 'sp_quiz.html';
            }
        } else {
            alert("Miss!")
            window.location.href = 'index.html';
        }

    }).fail(function(data) {
        window.alert('ログイン失敗');
        console.log("NG");
        console.log(data);
        window.location.href = 'index.html';
    })
};

function check_quiz_status_answer_pc() {
    var qid = localStorage.getItem("qid");
    $.ajax({
        url : 'http://localhost:8080/quiz_status_answer',
        method : "POST",
        data : {
            qid : qid
        },
            xhrFields : {
            withCredentials : true
        }
    }).done(function(data) {
        if (data != null) {
            console.log(data);
            // if(data === "出題"){
            // window.location.href = 'quiz.html';}
            if(data === "回答チェック"){
                window.location.href = 'pc_answer_check.html';}
            if(data === "解答発表"){
                window.location.href = 'pc_quiz_check.html';}
        } else {
            alert("Miss!")
            window.location.href = 'index.html';
        }

    }).fail(function(data) {
        // window.alert('ログイン失敗');
        // console.log("NG");
        // console.log(data);
        // window.location.href = 'index.html';
    })
};

function check_quiz_status_answer_pc_img() {
    var qid = localStorage.getItem("qid");
    $.ajax({
        url : 'http://localhost:8080/quiz_status_answer',
        method : "POST",
        data : {
            qid : qid
        },
            xhrFields : {
            withCredentials : true
        }
    }).done(function(data) {
        if (data != null) {
            console.log(data);
            // if(data === "出題"){
            // window.location.href = 'quiz.html';}
            if(data === "回答チェック"){
                window.location.href = 'pc_answer_img.html';}
            if(data === "解答発表"){
                window.location.href = 'pc_quiz_check_img.html';}
        } else {
            alert("Miss!")
            window.location.href = 'index.html';
        }

    }).fail(function(data) {
        // window.alert('ログイン失敗');
        // console.log("NG");
        // console.log(data);
        // window.location.href = 'index.html';
    })
};

function pc_quiz_check() {
    var qid = localStorage.getItem("qid");
    $.ajax({
        url : 'http://localhost:8080/quiz_status_answer',
        method : "POST",
        data : {
            qid : qid
        },
            xhrFields : {
            withCredentials : true
        }
    }).done(function(data) {
        if (data != null) {
            console.log(data);
            // if(data === "出題"){
            // window.location.href = 'quiz.html';}
            
            if(data === "解答発表"){
                window.location.href = 'pc_quiz_check.html';}
        } else {
            alert("Miss!")
            window.location.href = 'index.html';
        }

    }).fail(function(data) {
        // window.alert('ログイン失敗');
        // console.log("NG");
        // console.log(data);
        // window.location.href = 'index.html';
    })
};

function pc_quiz_check_img() {
    var qid = localStorage.getItem("qid");
    $.ajax({
        url : 'http://localhost:8080/quiz_status_answer',
        method : "POST",
        data : {
            qid : qid
        },
            xhrFields : {
            withCredentials : true
        }
    }).done(function(data) {
        if (data != null) {
            console.log(data);
            // if(data === "出題"){
            // window.location.href = 'quiz.html';}
            
            if(data === "解答発表"){
                window.location.href = 'pc_quiz_check_img.html';}
        } else {
            alert("Miss!")
            window.location.href = 'index.html';
        }

    }).fail(function(data) {
        // window.alert('ログイン失敗');
        // console.log("NG");
        // console.log(data);
        // window.location.href = 'index.html';
    })
};


function check_quiz_status_wait() {
    var qid = localStorage.getItem("qid");
  $.ajax({
      url : 'http://localhost:8080/quiz_status_answer',
      method : "POST",
      data : {
          qid : qid
      },
          xhrFields : {
          withCredentials : true
      }
  }).done(function(data) {
      if (data != null) {
          console.log(data);
          // if(data === "出題"){
          // window.location.href = 'quiz.html';}
          if(data == "待機"){
              window.location.href = 'pc_stanby.html';
            }
        
      } else {
          alert("Miss!")
          window.location.href = 'index.html';
      }

  }).fail(function(data) {
    //   window.alert('ログイン失敗');
    //   console.log("NG");
    //   console.log(data);
    //   window.location.href = 'index.html';
  })
};

function check_quiz_status_winner() {
    var qid = localStorage.getItem("qid");
  $.ajax({
      url : 'http://localhost:8080/quiz_status_answer',
      method : "POST",
      data : {
          qid : qid
      },
          xhrFields : {
          withCredentials : true
      }
  }).done(function(data) {
      if (data != null) {
          console.log(data);
          // if(data === "出題"){
          // window.location.href = 'quiz.html';}
          
            if(data == "優勝者発表"){
                window.location.href = 'pc_winner.html';
                }

      } else {
          alert("Miss!")
          window.location.href = 'index.html';
      }

  }).fail(function(data) {
    //   window.alert('ログイン失敗');
    //   console.log("NG");
    //   console.log(data);
    //   window.location.href = 'index.html';
  })
};

function checkanswer() {
    var qid = localStorage.getItem("qid");
  $.ajax({
      url : 'http://localhost:8080/checkanswer',
      method : "POST",
      data : {
          qid : qid
      },
          xhrFields : {
          withCredentials : true
      }
  }).done(function(data) {
      if (data != null) {
          console.log(data);
                    $('.number_of_answers_text.a').append
                    ('<p class="a">'+data[0]+'人</p>');
                    $('.number_of_answers_text.b').append
                    ('<p class="b">'+data[1]+'人</p>');
                    $('.number_of_answers_text.c').append
                    ('<p class="c">'+data[2]+'人</p>');
                    $('.number_of_answers_text.d').append
                    ('<p class="d">'+data[3]+'人</p>');

                    $('.number_of_answers.a').append
                    ('<p class="a">'+data[0]+'人</p>');
                    $('.number_of_answers.b').append
                    ('<p class="b">'+data[1]+'人</p>');
                    $('.number_of_answers.c').append
                    ('<p class="c">'+data[2]+'人</p>');
                    $('.number_of_answers.d').append
                    ('<p class="d">'+data[3]+'人</p>');

      } else {
          alert("Miss!")
          window.location.href = 'index.html';
      }

  }).fail(function(data) {
    //   window.alert('ログイン失敗');
    //   console.log("NG");
    //   console.log(data);
    //   window.location.href = 'index.html';
  })
};



function change_status(statusNumber,quizNumber) {

    // if(localStorage.getItem("qid") == null){
    //     var qid=localStorage.getItem("qid");
    // }else{
    //     var qid=1;
    // }
    
    switch (statusNumber) {
        case 1:
            var status ="待機"
            break;
        case 2:
            var status ="出題"
            break;
        case 3:
            var status ="回答チェック"
            break;
        case 4:
            var status ="解答発表"
            break;
        case 5:
            var status ="優勝者発表"
            break;
    }
    //  alert(quizNumber);
     alert(status);
    $.ajax({
        url : 'http://localhost:8080/change_status',
        method : "POST",
        data : {
            qid: quizNumber,
            status: status
        },
            xhrFields : {
            withCredentials : true
        }
    }).done(function(data) {
        if (data != null) {
            // 
            console.log(data);
            // localStorage.setItem("id",data.user_id);
            // localStorage.setItem("username",username);
            // window.location.href = 'quiz.html';
        } else {
            alert("Miss!")
            window.location.href = 'index.html';
        }

    }).fail(function(data) {
        window.alert('ログイン失敗');
        console.log("NG");
        console.log(data);
        window.location.href = 'index.html';
    })
    


}




