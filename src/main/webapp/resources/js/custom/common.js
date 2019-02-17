/**
 * Created by hard on 2018/12/11.
 * 自定义通用js文件
 */
var myJson = {
    getText: function (key, json) {
        if (key == undefined || key == null) {
            return '';
        }

        var text = '';
        if (json == '') {
            return text;
        }

        json = JSON.parse(json);
        if (json[key]) {
            text = json[key];
            return text;
        } else {
            return '';
        }
    }
};