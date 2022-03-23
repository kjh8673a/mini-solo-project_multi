$(function(){
    $("#regFrm").submit(function(){
        return registerCheck();
    });
});

function registerCheck() {
    var error = document.querySelectorAll('.regError');
    
    // 아이디
    var reg = /^[a-z0-9]{5,20}$/;
    if($("#userid").val()=="") {
        error[0].innerHTML = "아이디를 입력하세요.";
        error[0].style.display = "block";
        $("#userid").focus();
        return false;
    } else if(!reg.test($("#userid").val())) {
        error[0].innerHTML = "5~20자의 영문 소문자, 숫자만 사용 가능합니다.";
        error[0].style.display = "block";
        $("#userid").focus();
        return false;
    } else if($("#userid").val()=="admin") {
		error[0].innerHTML = "사용할 수 없는 아이디입니다.";
        error[0].style.display = "block";
        $("#userid").focus();
        return false;
	} else { error[0].style.display = "none"; }

    // 비밀번호
    reg = /^[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,16}$/;
    if($("#userpwd").val()=="") {
        error[1].innerHTML = "비밀번호를 입력하세요";
        error[1].style.display = "block";
        $("#userpwd").focus();
        return false;
    } else if(!reg.test($("#userpwd").val())) {
        error[1].innerHTML = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        error[1].style.display = "block";
        $("#userpwd").focus();
        return false;
    } else { error[1].style.display = "none"; }
    
    if($("#userpwd").val() != $("#userpwd2").val()) {
        error[2].innerHTML = "비밀번호가 일치하지 않습니다.";
        error[2].style.display = "block";
        $("#userpwd2").focus();
        return false;
     } else { error[2].style.display = "none"; }

    // 이름
    reg = /^[가-힣a-zA-Z]{1,40}$/;
    if($("#username").val()=="") {
        error[3].innerHTML = "이름을 입력하세요.";
        error[3].style.display = "block";
        $("#username").focus();
        return false;
    } else if(!reg.test($("#username").val())) {
        error[3].innerHTML = "한글과 영문 대 소문자를 사용하세요.";
        error[3].style.display = "block";
        $("#username").focus();
        return false;
    } else { error[3].style.display = "none"; }

    // 생년월일
    reg = /^[0-9]{4}$/;
    if(!reg.test($("#birthdate1").val())) {
        error[4].innerHTML = "태어난 년도 4자리를 정확하게 입력하세요.";
        error[4].style.display = "block";
        $("#birthdate1").focus();
        return false;
    } else if($("#birthdate2").val()=="none") {
        error[4].innerHTML = "태어난 월을 선택하세요.";
        error[4].style.display = "block";
        $("#birthdate2").focus();
        return false;
    } else { error[3].style.display = "none"; }

    reg = /^[0-9]{1,2}$/;
    if(!reg.test($("#birthdate3").val())) {
        error[4].innerHTML = "태어난 일(날짜) 2자리를 정확하게 입력하세요.";
        error[3].style.display = "block";
        $("#birthdate3").focus();
        return false;
    } else { error[4].style.display = "none"; }

    if($("#birthdate3").val() > 31) {
        error[4].innerHTML = "생년월일을 다시 확인해주세요.";
        error[4].style.display = "block";
        $("#birthdate3").focus();
        return false;
    } else if(($("#birthdate2").val()==4 || $("#birthdate2").val()==6 || $("#birthdate2").val()==9 || $("#birthdate2").val()==11) && $("#birthdate3").val()==31) {
        error[4].innerHTML = "생년월일을 다시 확인해주세요.";
        error[4].style.display = "block";
        $("#birthdate3").focus();
        return false;
    } else if ($("#birthdate2").val()==2) {
        var lunarchk = ($("#birthdate1").val()%4==0 && ($("#birthdate1").val()%100!=0 || $("#birthdate1").val()%400==0));
        if($("#birthdate3").val()>29 || ($("#birthdate3").val()==29 && !lunarchk)) {
            error[4].innerHTML = "생년월일을 다시 확인해주세요.";
            error[4].style.display = "block";
            $("#birthdate3").focus();
            return false;
        }
    } else { error[4].style.display = "none"; }

    // 성별
    if($("#gender").val()=="none") {
        error[5].innerHTML = "성별을 선택하세요.";
        error[5].style.display = "block";
        $("#gender").focus();
        return false;
    } else { error[5].style.display = "none"; }

    // MBTI
    if($("#mbti").val()=="none") {
        error[6].innerHTML = "MBTI를 선택하세요.";
        error[6].style.display = "block";
        $("#mbti").focus();
        return false;
    } else { error[6].style.display = "none"; }

    return true;
}