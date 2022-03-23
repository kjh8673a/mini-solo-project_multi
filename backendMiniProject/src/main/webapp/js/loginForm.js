function logFormCheck() {
    var id = document.getElementById("userid");
    var pwd = document.getElementById("userpwd");
    var error = document.querySelectorAll('.loginError');
    
    if (id.value == "") {
        error[0].innerHTML = "아이디를 입력하세요.";
        error[0].style.display = "block";
        id.focus();
        return false;
    } else { error[0].style.display = "none"; }
    
    if(pwd.value=="") {
        error[1].innerHTML = "비밀번호를 입력하세요";
        error[1].style.display = "block";
        pwd.focus();
        return false;
    } else { error[1].style.display = "none"; }

    return true;
}