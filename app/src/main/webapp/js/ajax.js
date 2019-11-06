function answer(){
    alert("しばらくお待ちください");
    location.href="stanby.html"
}

function img() {
    alert("kk");
}

function login() {
    var name = document.forms.form.name.value;
    alert(name);
    $.ajax({
        url : 'http://localhost:8080/login',
        method : "POST",
        data : {
            name : name
        }
        // ,
        //     xhrFields : {
        //     withCredentials : true
        // }
    }).done(function(data) {
        if (data != null) {
            alert(data);
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

function quiz(){

    var domain = "http://localhost:8080/quiz";

    $(function(){
        $.ajax({
            url : domain,
            type : 'GET'
        }
        ).done(function(data){
            var data = data[0];
                    $('.problem').append
                    ('<p>問題：'+data.problem+'</p>');
                    $('.button.a').append
                    ('<p class="a">'+data.choice_a+'</p>');
                    $('.button.b').append
                    ('<p class="b">'+data.choice_b+'</p>');
                    $('.button.c').append
                    ('<p class="c">'+data.choice_c+'</p>');
                    $('.button.d').append
                    ('<p class="d">'+data.choice_d+'</p>');

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
        }
        //     xhrFields : {
        //     withCredentials : true
        // }
    }).done(function(data) {
        if (data != null) {
            alert("待機");
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

function check_quiz_status() {
    // if(localStorage.getItem("qid") == null){
    //     var qid=localStorage.getItem("qid");
    // }else{
    //     var qid=1;
    // }
    $.ajax({
        url : 'http://localhost:8080/quiz_status',
        method : "POST",
        data : {
            qid : 1
        },
            xhrFields : {
            withCredentials : true
        }
    }).done(function(data) {
        if (data != null) {
            // alert(data);
            console.log(data);
            // localStorage.setItem("id",data.user_id);
            // localStorage.setItem("username",username);
            if(data === "出題"){
            window.location.href = 'quiz.html';}
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

function change_status(a) {

    // if(localStorage.getItem("qid") == null){
    //     var qid=localStorage.getItem("qid");
    // }else{
    //     var qid=1;
    // }
    
    switch (a) {
        case 1:
            var status ="出題"
            break;
        case 2:
            var status ="待機"
            break;
        case 3:
            var status ="回答チェック"
            break;
        case 4:
            var status ="回答発表"
            break;
    }
    alert(status);


    $.ajax({
        url : 'http://localhost:8080/change_status',
        method : "POST",
        data : {
            qid: 1,
            status: status
        },
            xhrFields : {
            withCredentials : true
        }
    }).done(function(data) {
        if (data != null) {
            // alert(data);
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


