/*************************************************************************
* 方法说明：可复用的http请求发送函数
* 参数说明：
*　　url：目标URL，为防止页面缓存，最好拼接上Math.random()
*　　content：用POST方式发出请求时想传给服务器的数据，数据以查询字串的方式列出，：name=value&anothername=othervalue。
*　　　　 　　用GET方式：传null
*　　callback：要回调的函数
*************************************************************************/
var xhr = false;
function sendAjaxRequest(url, content, callback) {
  xhr = false;
  //初始化XMLHttpRequest对象
  if (window.XMLHttpRequest) { //Firefox,Chrome,IE8
    xhr = new XMLHttpRequest();
  } else {
    if (window.ActiveXObject) { 
      try {
      	xhr = new ActiveXObject("Msxml2.XMLHTTP"); //IE7
      } catch (e) {
        try {
        	xhr = new ActiveXObject("Microsoft.XMLHTTP"); //IE6之前
        } catch (e) {}
      }
    }
  }
  
  if (!xhr) { // 异常,创建对象实例失败
    // "不能创建XMLHttpRequest对象实例"
    window.alert("\u4e0d\u80fd\u521b\u5efaXMLHttpRequest\u5bf9\u8c61\u5b9e\u4f8b.");
    return false;
  }
  
  //设置回调函数
  xhr.onreadystatechange = callback;

  //创建请求，请求方式post,使用异步
  xhr.open("post", url, true);
  xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); //发送的如果是XML，text/xml
  //开始发起请求
  xhr.send(content);
}

/*************************************************
*　方法说明：回调函数(处理返回信息的函数)模板
*************************************************/
function processResponse() {
  if (xhr.readyState == 4) { // 响应已完成
    if (xhr.status == 200) {// 成功处理
       alert(xhr.responseText); 
    } else { //页面不正常报错："所请求的页面有异常"
       alert("\u6240\u8bf7\u6c42\u7684\u9875\u9762\u6709\u5f02\u5e38\u3002");
    }
  }
}