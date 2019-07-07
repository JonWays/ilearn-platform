$(document).ready(function () {
    $("#getCode").bind("click", btnCheck);

    /**
     * [btnCheck 按钮倒计时常用于获取手机短信验证码]
     */
    function btnCheck() {
        var time = 59;
        $("#getCode").addClass("getCodeOn");
        $("#getCode").attr("disabled", true);
        var timer = setInterval(function () {
            if (time == 0) {
                clearInterval(timer);
                $("#getCode").attr("disabled", false);
                $("#getCode").val("获取验证码");
                $("#getCode").removeClass("getCodeOn");
            } else {
                $('#getCode').val(time + "秒后可重新获取");
                time--;
            }
        }, 1000);
    }

    document.getElementById('checkboxInput').onclick = function () {
        if (this.checked){
            $("#submitBtn").removeClass("btnDisabled")
        }
        else {
            $("#submitBtn").addClass("btnDisabled")
        }
    };

    $('#phoneNum').bind('input propertychange', function() {
        var str = this.value.toString().replace(/\s+/g, '');
        /*手机号344分布*/
        var len = str.length;
        switch (true) {
            case len > 11:
                str = str.substr(0, 3) + ' ' + str.substr(3, 4) + ' ' + str.substr(7, 4);
                this.value = str;
                break;
            case len > 7:
                str = str.substr(0, 3) + ' ' + str.substr(3, 4) + ' ' + str.substr(7);
                this.value = str;
                break;
            case len > 3:
                str = str.substr(0, 3) + ' ' + str.substr(3);
                this.value = str;
                break;
            default:
                this.value = str;
        }

        var phone = this.value.toString().replace(/\s+/g, '');
        if ("" == phone || null == phone || undefined == phone) {
            removeErrorInfo("#phoneError");
            return
        }
        var myreg = /^[1][0-9]{10}$/;
        if(!myreg.test(phone)) {
            addErrorInfo("请输入有效的手机号码", "phoneError");
        }
        else {
            removeErrorInfo("#phoneError");
        }
    });
});

function showLearnMoreInfo() {
    if ($("#learnMoreInfo").css("display") == "none") {
        $("#learnMoreInfo").css("display", "block");
        $("#triangleSign").css("transform" , "rotate(180deg)");
    }
    else {
        $("#learnMoreInfo").css("display", "none");
        $("#triangleSign").css("transform" , "rotate(0deg)");
    }
}

function onSubmitClick() {
    $("#phoneNum").attr("value");
}

//验证手机号
function validatePhone(phone) {
    if(phone == '') {
        $("#phoneError").html("请先填写手机号");
        $("#phoneError").show();
        return true;
    }
    var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    if(!myreg.test(phone)) {
        $("#phoneError").html("请输入有效的手机号");
        $("#phoneError").show();
        return true;
    }
    return false;
}

function addErrorInfo(errorTxt, errorInfoid) {
    var imgSrc = "../pic/verifycode_valid.png";
    var imgDom = '<img src="' + imgSrc + '"/><span>' + errorTxt + "</span>";
    $("#" + errorInfoid).css("margin-bottom", "-20px");
    $("#" + errorInfoid).html(imgDom)
}

function removeErrorInfo(id) {
    if ($(id)[0]) {
        for (; $(id)[0].hasChildNodes(); ) {
            $(id)[0].removeChild($(id)[0].firstChild);
        }
        $(id).css("margin-bottom", "0px");
    }

    id += "Tip";
    if ($(id)[0]) {
        for (; $(id)[0].hasChildNodes(); ) {
            $(id)[0].removeChild($(id)[0].firstChild);
        }
        $(id).css("margin-bottom", "0px");
    }
}