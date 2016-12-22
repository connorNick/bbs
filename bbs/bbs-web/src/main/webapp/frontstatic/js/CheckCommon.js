// JScript 文件


//获取字符串长度(中文2个字符)�

function getStrLength(str){
	var chineseRegex = new RegExp(/[^\x00-\xff]/g); 
		var strLength = str.replace(chineseRegex,"**").length; 
		return strLength;
}
//////////////////

function checkusername(username){
	return new RegExp(/^[a-zA-Z]([a-zA-Z]|\d|_){4,16}([a-zA-Z]|\d)$/).test(username);
}
function checkpassword(password){
	var len = getStrLength(password);
	
	return len >=6 && len <= 16;
}

function checkPwd(pwd) {
    return new RegExp(/^[a-zA-Z0-9]{6,16}$/).test(pwd);

}
function checkRepeatPassword(repeatPassword){
	
	return repeatPassword == $('#TbPwd').attr("value");
	
}
function checkRepeatPassword2(repeatPassword){
	
	return repeatPassword == $('#Newpassword').attr("value");
	
}
function checkAnswer(answer){
	var len = getStrLength(answer);
	return len >=4 && len <= 30;
}
function checkYear(year){
	return new RegExp(/^(18|19|20)[0-9]{2}$/).test(year);
}

function checkName(name){
	var len = getStrLength(name);
	return len <= 26 ;
	
}

function checkMyQuestion(myQuestion){
	var len = getStrLength(myQuestion);
	return len >=6 && len <= 30;
	
}

function checkFalse(value){
	
	//不能包含特殊字符 
			var forbiddenChars = "｜＋×＆……％￥＃＠！～＝＼｝｛】【|+*&^%$#@!~=\\}{][><"; 
			 var c;
			 var nicknamevalid = true;
			 for(var i = 0 ; i < forbiddenChars.length; ++i){
				c = (forbiddenChars.substring(i,i + 1));
				if(value.indexOf(c) != -1){
					nicknamevalid  = false;
					break;
				}
			 }
			 
			 if(!nicknamevalid)
			 {
			 	return false;
			 }
			 else
			{
			 	return true;
			}
			
			
}

function checkTextareaFalse(value){
	
	//不能包含特殊字符 
			var forbiddenChars = "｜＋×＆……％￥＃＠！～＝＼|+*&^%$#@!~\\><"; 
			 var c;
			 var nicknamevalid = true;
			 for(var i = 0 ; i < forbiddenChars.length; ++i){
				c = (forbiddenChars.substring(i,i + 1));
				if(value.indexOf(c) != -1){
					nicknamevalid  = false;
					break;
				}
			 }
			 
			 if(!nicknamevalid)
			 {
			 	return false;
			 }
			 else
			{
			 	return true;
			}
			
			
}


function checkNickname(value){
	
	//不能包含特殊字符 
			var forbiddenChars = "·｜＋）（×＆……％￥＃＠！～＝＼｝｛】【：；？》《、|+)(*&^%$#@!~=\\}{][:;?></"; 
			 var c;
			 var nicknamevalid = true;
			 for(var i = 0 ; i < forbiddenChars.length; ++i){
				c = (forbiddenChars.substring(i,i + 1));
				if(value.indexOf(c) != -1){
					nicknamevalid  = false;
					break;
				}
			 }
			 
			 if(!nicknamevalid)
			 	return false;
			
			//不能超过长度限制 
			var length  = getStrLength(value);
			if(length > 20 || length < 2)
				return false;
			
			return true;
}


function checkObject(value){
	
	//不能包含特殊字符 
			var forbiddenChars = "-:"; 
			 var c;
			 var nicknamevalid = true;
			 for(var i = 0 ; i < forbiddenChars.length; ++i){
				c = (forbiddenChars.substring(i,i + 1));
				if(value.indexOf(c) != -1){
					nicknamevalid  = false;
					break;
				}
			 }
			 
			 if(!nicknamevalid)
			 {
			 	return false;
			 }
			 else
			{
			 	return true;
			}
			
			
}

function checkMobile(value){
	return new RegExp(/^\d{11}$/).test(value);
}

//判断是否为email
function checkMail(mail){
	
	return new RegExp(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/).test(mail); 
}


function checkQQ(qq){
	
	return new RegExp(/^[0-9]{6,20}$/).test(qq) || checkMail(qq);
}

function checkQuestion(question){
	return question != "";
}

function checkRandomImg(value){
	return getStrLength(value) > 0 ;
	
}

function checkAgree(value){
	return value;
}



/*
    限制输入字符的位数
    str是用户输入字符串，len是要限制的位数
    ----------------------------
*/
function isSmall(str,len){
    if (str.length<len){
        return(true);
    }else{
        return(false);
    }
}

/*判断两个字符串是否一致
---------------------------------
*/
function isSame(str1,str2){
    if (str1==str2){
        return(true);
    }else{
        return(false);
    }
}


/*
判断字符串是否为空开始
---------------------------------
*/
function isNotNull(str){
    if (str.replace(/(^\s*)|(\s*$)/g,"").length<=0){
        return(false);
    }else{
        return(true);
    }
}
/*
判断是不是手机号码
---------------------------------
*/
function isPhone(str){

    reg=new RegExp(/^[0]?13\d{9}$/gi);
    reg2=new RegExp(/^[0]?15\d{9}$/gi);
    if(!reg.test(str)&&!reg2.test(str)){
        return false;
    }
    return true;
}

function checkMobiles(str)
{
 var reg0=new RegExp(/^13\d{5,9}$/);   //130--139。至少7位
 var reg1=new RegExp(/^153\d{4,8}$/);  //联通153。至少7位
 var reg2=new RegExp(/^159\d{4,8}$/);  //移动159。至少7位
 var my=false;
 if (reg0.test(str))my=true;
 if (reg1.test(str))my=true;
 if (reg2.test(str))my=true;
 return my;
}

/*
判断用户名是否不包含汉字
（用户名不能为汉字，也不准带有特殊字符）
注：
正则表达式.test() 方法用于检测一个字符串是否匹配某个模式
---------------------------------
*/
function notChinese(str){
var reg=new RegExp(/[^A-Za-z0-9_]/g)
    if (reg.test(str)){
        return (false);
    }else{
        return(true);    
    }
}


/*
判断是否为日期
----------------------------------
*/
function isDate (theStr) {
    var the1st = theStr.indexOf('-');
    var the2nd = theStr.lastIndexOf('-');
    
    if (the1st == the2nd) { 
        return(false); 
    }
    else {
        var y = theStr.substring(0,the1st);
        var m = theStr.substring(the1st+1,the2nd);
        var d = theStr.substring(the2nd+1,theStr.length);
        var maxDays = 31;
        
        if (isNum(m)==false || isNum(d)==false || isNum(y)==false) {
            return(false); }
        else if (y.length < 4) { return(false); }
        else if ((m<1) || (m>12)) { return(false); }
        else if (m==4 || m==6 || m==9 || m==11) maxDays = 30;
        else if (m==2) {
            if (y % 4 > 0) maxDays = 28;
            else if (y % 100 == 0 && y % 400 > 0) maxDays = 28;
               else maxDays = 29;
        }
        if ((d<1) || (d>maxDays)) { return(false); }
        else { return(true); }
    }
}
/*
判断是否为数字
---------------------------------------
*/
function isNum(num){
    var i,j,strTemp;
    strTemp="0123456789";
    if ( num.length== 0){
        return false;
    }
    for (i=0;i<num.length;i++){
        j=strTemp.indexOf(num.charAt(i));    
        if (j==-1){//说明有字符不是数字
            return false;
        }
    }
    
    return true;//说明是数字
} 

function isNum2(num){
    var i,j,strTemp;
    strTemp="0123456789-";
    if ( num.length== 0){
        return false;
    }
    for (i=0;i<num.length;i++){
        j=strTemp.indexOf(num.charAt(i));    
        if (j==-1){//说明有字符不是数字
            return false;
        }
    }
    
    return true;//说明是数字
} 
//判断浮点类型
function CheckFloat(num){
    var i,j,strTemp;
    strTemp="0123456789-.";
    if ( num.length== 0){
        return false;
    }
    for (i=0;i<num.length;i++){
        j=strTemp.indexOf(num.charAt(i));    
        if (j==-1){//说明有字符不是数字
            return false;
        }
    }
    
    return true;//说明是数字
} 


/*
判断是否为固定的位数

-------------------------
*/
function isAtn(str,n){
    if (str.length!=n){
        return(false);
    }
    else{
        return(true);
    }
}

/*
判断是否为电话号码开始（已经完成）
--------------------------
*/
function isTel(telstr)
{
   var reg1= new RegExp(/(\(\d{3}\)|\d{3}-)?\d{8}/g);//八位电话号码
   var reg2= new RegExp(/(\(\d{3}\)|\d{3}-)?\d{7}/g);//七位电话号码
   if (telstr!="") {
           if (reg1.test(telstr)||reg2.test(telstr)){
               return true;
           }
           else{
               return false;
        }
   }else{return false;}
}
/*
判断是否为邮政编码
---------------------------
*/
function isPostCode(tmppwd)
{
    var patrn=new RegExp(/^\d{6}$/);
    if (!patrn.exec(tmppwd))
    {
        return false;
    }
    else
    {
        return true;
    }
}

/*
中文汉字输入判断
---------------------------
*/
function isChinese(str){
     //如果值为空，不通过校验   
     if   (str   ==   "")   
          return   false;   
     var   pattern   =   new RegExp(/^([\u4E00-\u9FA5]|[\uFE30-\uFFA0])*$/gi);   
     if   (pattern.test(str))   
          return   true;   
      else   
          return   false;   
}
/*判断用户名是不是包含大小写字母数字和_*/
function isUID(str){
        var jgpattern =new RegExp(/^[A-Za-z0-9_]+$/);
        var huzhaocard = str;
        if(!jgpattern.test(huzhaocard))
        {
            return false;
        } 
        else
        {
            return true;
        }
}
//判断是不是网址
function isHttp(str)
{
    var pattern=new RegExp(/^(http:\/\/)?[a-zA-Z0-9-]+(\.[a-zA-z0-9-]+)+\/?$/gi);
    if(pattern.test(str))
    {
        
        return true;
    }
    else
    {
        return false;
    }
}