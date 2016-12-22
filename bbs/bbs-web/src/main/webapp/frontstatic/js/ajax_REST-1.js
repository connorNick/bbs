// 返回数据
function ajax_json_getV1(ajaxurl, timeoutMS, async, successFn, errorFn, beforeSendFn) {
    $.ajax({
        url: ajaxurl,
        type: 'GET',
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        timeout: timeoutMS,
        async: async,
        beforeSend: function() {
            if (beforeSendFn) beforeSendFn();
        },
        error: function() {
            if (errorFn) errorFn();
        },
        success: function(data) {
            if (successFn) successFn(data);
        }
    });
}

// 返回数据
function ajax_string_getV1(ajaxurl, timeoutMS, async, successFn, errorFn, beforeSendFn) {
    $.ajax({
        url: ajaxurl,
        type: 'GET',
        dataType: String,
        contentType: "application/json; charset=utf-8",
        timeout: timeoutMS,
        async: async,
        beforeSend: function() {
            if (beforeSendFn) beforeSendFn();
        },
        error: function() {
            if (errorFn) errorFn();
        },
        success: function(data) {
            if (successFn) successFn(data);
        }
    });
}

// POST提交数据 更新
function ajax_json_postV1(ajaxurl, jsonText, timeoutMS, async, successFn, errorFn, beforeSendFn) {
    $('#LoadingStatus').show();
    $.ajax({
        url: ajaxurl,
        type: 'POST',
        data: jsonText,
        dataType: 'json',
        timeout: timeoutMS,
        async: async,
        beforeSend: function() {
            if (beforeSendFn) beforeSendFn();
        },
        error: function() {
            if (errorFn) errorFn();
        },
        success: function(data) {
            if (successFn) successFn(data);
        }
    });
}

// POST提交数据 更新
function ajax_string_postV1(ajaxurl, inputText, timeoutMS, async, successFn, errorFn, beforeSendFn) {
    $.ajax({
        url: ajaxurl,
        type: 'POST',
        data: inputText,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        timeout: timeoutMS,
        async: async,
        beforeSend: function() {
            if (beforeSendFn) beforeSendFn();
        },
        error: function() {
            if (errorFn) errorFn();
        },
        success: function(data) {
            if (successFn) successFn(data);
        }
    });
}

// PUT提交数据 添加
function ajax_json_putV1(ajaxurl, jsonText, timeoutMS, async, successFn, errorFn, beforeSendFn) {
    $('#LoadingStatus').show();
    $.ajax({
        url: ajaxurl,
        type: 'PUT',
        data: jsonText,
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        timeout: timeoutMS,
        async: async,
        beforeSend: function() {
            if (beforeSendFn) beforeSendFn();
        },
        error: function() {
            if (errorFn) errorFn();
        },
        success: function(data) {
            if (successFn) successFn(data);
        } 
    });
}

// DELETE提交数据
function ajax_json_deleteV1(ajaxurl, jsonText, timeoutMS, async, successFn, errorFn, beforeSendFn) {
    $('#LoadingStatus').show();
    $.ajax({
        url: ajaxurl,
        type: 'DELETE',
        data: jsonText,
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        timeout: timeoutMS,
        async: async,
        beforeSend: function() {
            if (beforeSendFn) beforeSendFn();
        },
        error: function() {
            if (errorFn) errorFn();
        },
        success: function(data) {
            if (successFn) successFn(data);
        }
    });
}