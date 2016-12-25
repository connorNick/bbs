
jQuery(document).ready(function($){
    var $form_modal = $('.cd-user-modal'),
        $form_login = $form_modal.find('#cd-login'),
        $form_signup = $form_modal.find('#cd-signup'),
        $form_modal_tab = $('.cd-switcher'),
        $tab_login = $form_modal_tab.children('li').eq(0).children('a'),
        $tab_signup = $form_modal_tab.children('li').eq(1).children('a'),
        $main_nav = $('.register_pan');
    $('#kaptchaImage').click(function() {$(this).attr('src','Kaptcha.jpg?' + Math.floor(Math.random() * 100));});
    $('#kaptchaImage2').click(function() {$(this).attr('src','Kaptcha.jpg?' + Math.floor(Math.random() * 100));});
    //弹出窗口
    $main_nav.on('click', function(event){

        if( $(event.target).is($main_nav) ) {
            // on mobile open the submenu
            $(this).children('ul').toggleClass('is-visible');
        } else {
            // on mobile close submenu
            $main_nav.children('ul').removeClass('is-visible');
            //show modal layer
            $form_modal.addClass('is-visible');
            //show the selected form
            ( $(event.target).is('.cd-signup') ) ? signup_selected() : login_selected();
        }

    });
    $(".searchBtn").on('click',function(event){
        window.location.href="/topic/list?name="+$("#searchName").val();
    });

    //关闭弹出窗口
    $('.cd-user-modal').on('click', function(event){
        if( $(event.target).is($form_modal) || $(event.target).is('.cd-close-form') ) {
            $form_modal.removeClass('is-visible');
        }
    });
    //使用Esc键关闭弹出窗口
    $(document).keyup(function(event){
        if(event.which=='27'){
            $form_modal.removeClass('is-visible');
        }
    });

    //切换表单
    $form_modal_tab.on('click', function(event) {
        event.preventDefault();
        ( $(event.target).is( $tab_login ) ) ? login_selected() : signup_selected();
    });

    function login_selected(){
        $form_login.addClass('is-selected');
        $form_signup.removeClass('is-selected');
        $tab_login.addClass('selected');
        $tab_signup.removeClass('selected');
    }

    function signup_selected(){
        $form_login.removeClass('is-selected');
        $form_signup.addClass('is-selected');
        $tab_login.removeClass('selected');
        $tab_signup.addClass('selected');
    }

    //login
    $('#login').on('click', function(event){
        var username=$("#loginForm").find("input[name='username']").val();
        var password=$("#loginForm").find("input[name='password']").val();
        var captcha=$("#loginForm").find("input[name='captcha']").val();
        jQuery.ajax({
            url:"/dologin",
            type: "POST",
            data: {
                username: username,
                password: password,
                captcha:captcha
            },
            dataType:"json",
            cache: false,
            success : function(data) {
                if (data != 'success') {
                    $("#msg").html(data);
                }else{
                    location.href="/index";
                }
            }
        });
    });

    //register
    $('#registerBtn').on('click', function(event){
        var username=$("#registerForm").find("input[name='username']").val();
        var password=$("#registerForm").find("input[name='password']").val();
        var email=$("#registerForm").find("input[name='email']").val();
        var captcha=$("#registerForm").find("input[name='captcha']").val();
        jQuery.ajax({
            url:"/register",
            type: "POST",
            data: {
                username: username,
                password: password,
                email: email,
                captcha:captcha
            },
            dataType:"json",
            cache: false,
            success : function(data) {
                if (data != 'success') {
                    $("#msg2").html(data);
                }else{
                    location.href="/index";
                }
            }
        });

    });

});


//credits http://css-tricks.com/snippets/jquery/move-cursor-to-end-of-textarea-or-input/
jQuery.fn.putCursorAtEnd = function() {
    return this.each(function() {
        // If this function exists...
        if (this.setSelectionRange) {
            // ... then use it (Doesn't work in IE)
            // Double the length because Opera is inconsistent about whether a carriage return is one character or two. Sigh.
            var len = $(this).val().length * 2;
            this.setSelectionRange(len, len);
        } else {
            // ... otherwise replace the contents with itself
            // (Doesn't work in Google Chrome)
            $(this).val($(this).val());
        }
    });
};