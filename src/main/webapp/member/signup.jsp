<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        *{box-sizing: border-box;}

        .container {
            width: 500px;
            height: 800px;
            margin: auto;
            border:1px solid black;
        }

        .title {
            height: 10%;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 40px;
            font-weight: bolder;
        }

        .body {
            height: 80%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .contents {
            height: 95%;
            width: 95%;
        }

        .contents>div {
            display: flex;
            justify-content: space-evenly;
            align-items: center;
        }

        .id-pw-form {
            height: 30%;
        }

        .name-phone-email-form {
            height: 30%;
        }

        .post-form {
            height: 35%;
        }

        .notice {
            height: 5%;
        }

        fieldset {
            width: 95%;
            height: 90%;
            border: 1px solid black;
        }

        legend {
            font-size: 18px;
            font-weight: bold;
        }

        fieldset>div {
            width: 100%;
            height: 33.3%;
            display: flex;
            align-items: center;
            position: relative;
            font-size: 12px;
        }

        input {
            width: 70%;
            height: 80%;
            margin-left: 10px;
        }

        span {
            height: 100%; 
            width: 80%;
            display: flex;
            align-items: center;
            font-size: 15px;
            position: absolute;
            right: 0px;
        }

        #id-check {
            margin: 10px;
            width: 15%;
            height: 60%;
            font-size: 10px;
        }

        #password-show {
            width: auto;
            height: auto;
            margin-left: 30px;
        }

        #pw-check-result {
            width: 40%;
            font-size: 10px;
        }

        #email-end {
            width: 30%;
            height: 60%;
            font-size: 15px;
        }

        #post-select {
            margin-left: 15px;
            height: 45%;
        }

        .footer {
            height: 10%;
        }

        .buttons {
            height: 100%;
            width: 70%;
            margin: auto;
            display: flex;
            justify-content: space-evenly;
            align-items: center;
        }

        .buttons>button {
            height: 40%;
            width: 25%;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
    <div class="container">
        <div class="title">회원 가입</div>
        <div class="body">
            <div class="contents">
                <div class="id-pw-form">
                    <fieldset>
                        <legend>아이디, 비밀번호</legend>
                        <div class="id-form">
                            * 아이디:
                            <span>
                                <input type="text" id="id" placeholder="아이디를 입력하십시오." style="width: 75%;">
                                <button id="id-check">아이디 확인</button>
                            </span>
                        </div>
                        <div class="password-form">
                            * 비밀번호:
                            <span style="font-size: 10px">
                                <input type="password" id="password" class="password" placeholder="비밀번호를 입력하십시오." style="width: 60%">
                                <input type="checkbox" id="password-show">비밀번호 표시
                            </span>
                        </div>
                        <div class="password-check-form">
                            * 비밀번호 체크:
                            <span>
                                <input type="password" id="password-check" class="password" placeholder="비밀번호를 다시 입력하십시오." style="width: 55%;">
                                <span  id="pw-check-result"></span>
                            </span>
                        </div>
                    </fieldset>
                </div>
                <div class="name-phone-email-form">
                    <fieldset>
                        <legend>이름, 전화번호, 이메일</legend>
                        <div class="name-form">
                            이름:
                            <span>
                                <input type="text" id="name" placeholder="이름을 입력하십시오.">
                            </span>
                        </div>
                        <div class="phone-form">
                            전화번호:
                            <span>
                                <input type="text" id="phone" placeholder="전화번호를 입력하십시오.">
                            </span>
                        </div>
                        <div class="email-form">
                            이메일:
                            <span>
                                <input type="text" id="email" placeholder="이메일을 입력하십시오." style="width: 30%; margin-right: 15px">
                                @
                                <select id="email-end" style="margin-left: 15px">
                                    <option value="1">naver.com</option>
                                    <option value="2">google.com</option>
                                    <option value="3">daum.com</option>
                                </select>
                            </span>
                        </div>
                    </fieldset>
                </div>
                <div class="post-form">
                    <fieldset>
                        <legend>주소</legend>
                        <div class="postcode-form">
                            우편번호:
                            <span>
                                <input type="text" id="postcode" placeholder="우편번호를 입력하십시오." style="width: 60%" disabled>
                                <button id="post-select">우편 번호 찾기</button>
                            </span>
                        </div>
                        <div class="address1-form">
                            도로명 주소: 
                            <span>
                                <input type="text" id="address1" placeholder="도로명 주소" disabled>
                            </span>
                        </div>
                        <div class="address2-from">
                            상세 주소:
                            <span>
                                <input type="text" id="address2" placeholder="상세 주소" disabled>
                            </span>
                        </div>
                    </fieldset>
                </div>
                <div class="notice">
                    <div style="width: 95%;">
                        *는 필수 입력 항목입니다!
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="buttons">
                <button id="sign-up">회원 가입</button>
                <button id="back">돌아가기</button>
            </div>
        </div>
    </div>
</body>
</html>
<script>
    window.onload = function() {
        $('#id').val(localStorage.getItem('id'));
        localStorage.removeItem('id');
        
        $('#password').val(localStorage.getItem('password'));
        localStorage.removeItem('paassword');
        
        $('#name').val(localStorage.getItem('name'));
        localStorage.removeItem('name');
        
        $('#phone').val(localStorage.getItem('phone'));
        localStorage.removeItem('phone');
        
        $('#email').val(localStorage.getItem('email'));
        localStorage.removeItem('email');
        
        $('#email-end').val(localStorage.getItem('email-end')).prop("selected", true);
        localStorage.removeItem('email');
        
        $('#postcode').val(localStorage.getItem('postcode'));
        localStorage.removeItem('postcode');
        
        $('#address1').val(localStorage.getItem('address1'));
        localStorage.removeItem('address1');
    }

    $('#password-show').on('change', function() {        
        const type = ($(this).is(':checked')) ? 'text' : 'password';

        $('#password').attr('type', type);
        $('#password-check').attr('type', type);
    });

    $('#password-check').keyup(function() {
        const resultMessage = (isPasswordDuplicated()) ? '비밀번호가 일치합니다' : '비밀번호가 일치하지 않습니다';

        $('#pw-check-result').html(resultMessage);
    });

    $('#password').keyup(function() {
        if ($('#password-check').val() != '') {
            const resultMessage = (isPasswordDuplicated()) ? '비밀번호가 일치합니다' : '비밀번호가 일치하지 않습니다';

            $('#pw-check-result').html(resultMessage);
        }
    });

    function isPasswordDuplicated() {
        return $('#password').val() == $('#password-check').val();
    }

    $('#post-select').on('click', function() {
        new daum.Postcode({
            oncomplete: function(data) {
                $('#postcode').val(data.zonecode);
                $('#address1').val(data.roadAddress);

                $('#address2').attr('disabled', false);
            }
        }).open();
    });

    $('#back').on('click', function() {
        if(confirm('회원 가입을 취소하시겠습니까? 적어놓은 정보는 저장됩니다.')) {
            localStorage.setItem('id', $('#id').val());
            localStorage.setItem('password', $('#password').val());
            localStorage.setItem('name', $('#name').val());
            localStorage.setItem('phone', $('#phone').val());
            localStorage.setItem('email', $('#email').val());
            localStorage.setItem('email-end', $('#email-end option:selected').val());
            localStorage.setItem('postcode', $('#postcode').val());
            localStorage.setItem('address1', $('#address1').val());
            localStorage.setItem('address2', $('#address2').val());
            
            location.href = '/';
        }
    })

    $('#sign-up').on('click', function() {
        $.ajax({
            url: '/create.member',
            type: 'GET',
            data: {
                id: $('#id').val(),
                password: $('#password').val(),
                name: $('#name').val(),
                phone: $('#phone').val(),
                email: $('#email').val() + '@' + $('#email-end option:selected').text(),
                postcode: $('#postcode').val(),
                address1: $('#address1').val(),
                addreses2: $('#address2').val()
            }
        }).done(function(data) {
            alert('회원 가입이 완료되었습니다.');
            location.href = '/';
        }).fail(function(data) {
            alert(data.message);
        });
    });
</script>