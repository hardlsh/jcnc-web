﻿var djt = { $: function (objName) { return document.getElementById(objName); }, isIE: navigator.appVersion.indexOf("MSIE") != -1 ? true : false, addEvent: function (l, i, I) { if (l.attachEvent) { l.attachEvent("on" + i, I) } else { l.addEventListener(i, I, false) } }, delEvent: function (l, i, I) { if (l.detachEvent) { l.detachEvent("on" + i, I) } else { l.removeEventListener(i, I, false) } } };
//滚动图片构造函数
// new  ScrollPicleft('滚动区ID'，'左按钮ID','右按钮ID',滚动区宽度,翻页宽度,移动速度(单位毫秒，越小越快),每次移动像素(单位px，越大越快),自动播放,自动播放间隔时间,'分页ID');
// new  ScrollPicleft('id','leftid','rightid',958,220,2,8,true,3000);
function ScrollPicleft2(scrollContId, arrLeftId, arrRightId, frameWidth, pageWidth, speed, space, autoPlay, autoPlayTime, dotListId) {
    this.scrollContId = scrollContId; this.arrLeftId = arrLeftId; this.arrRightId = arrRightId; this.dotListId = dotListId; this.dotClassName = "dotItem"; this.dotOnClassName = "dotItemOn"; this.dotObjArr = []; this.pageWidth = pageWidth; this.frameWidth = frameWidth; this.speed = speed; this.space = space; this.pageIndex = 0; this.autoPlay = autoPlay; this.autoPlayTime = autoPlayTime; var _autoTimeObj, _scrollTimeObj, _state = "ready"; this.stripDiv = document.createElement("DIV"); this.listDiv01 = document.createElement("DIV"); this.listDiv02 = document.createElement("DIV"); if (!ScrollPicleft.childs) { ScrollPicleft.childs = [] }; this.ID = ScrollPicleft.childs.length; ScrollPicleft.childs.push(this); this.initialize = function () {
        if (!this.scrollContId) { throw new Error("必须指定scrollContId."); return }; this.scrollContDiv = djt.$(this.scrollContId); if (!this.scrollContDiv) { throw new Error("scrollContId不是正确的对象.(scrollContId = \"" + this.scrollContId + "\")"); return }; this.scrollContDiv.style.width = this.frameWidth + "px"; this.scrollContDiv.style.overflow = "hidden"; this.listDiv01.innerHTML = this.listDiv02.innerHTML = this.scrollContDiv.innerHTML; this.scrollContDiv.innerHTML = ""; this.scrollContDiv.appendChild(this.stripDiv); this.stripDiv.appendChild(this.listDiv01); this.stripDiv.appendChild(this.listDiv02); this.stripDiv.style.overflow = "hidden"; this.stripDiv.style.zoom = "1"; this.stripDiv.style.width = "32766px"; var isIE = navigator.userAgent.toUpperCase().indexOf("MSIE") == -1 ? false : true; if (isIE) { this.listDiv01.style.styleFloat = "left"; this.listDiv02.style.styleFloat = "left"; } else { this.listDiv01.style.cssFloat = "left"; this.listDiv02.style.cssFloat = "left"; }
        djt.addEvent(this.scrollContDiv, "mouseover", Function("ScrollPicleft.childs[" + this.ID + "].stop()")); djt.addEvent(this.scrollContDiv, "mouseout", Function("ScrollPicleft.childs[" + this.ID + "].play()")); if (this.arrLeftId) { this.arrLeftObj = djt.$(this.arrLeftId); if (this.arrLeftObj) { djt.addEvent(this.arrLeftObj, "mousedown", Function("ScrollPicleft.childs[" + this.ID + "].rightMouseDown()")); djt.addEvent(this.arrLeftObj, "mouseup", Function("ScrollPicleft.childs[" + this.ID + "].rightEnd()")); djt.addEvent(this.arrLeftObj, "mouseout", Function("ScrollPicleft.childs[" + this.ID + "].rightEnd()")) } }; if (this.arrRightId) { this.arrRightObj = djt.$(this.arrRightId); if (this.arrRightObj) { djt.addEvent(this.arrRightObj, "mousedown", Function("ScrollPicleft.childs[" + this.ID + "].leftMouseDown()")); djt.addEvent(this.arrRightObj, "mouseup", Function("ScrollPicleft.childs[" + this.ID + "].leftEnd()")); djt.addEvent(this.arrRightObj, "mouseout", Function("ScrollPicleft.childs[" + this.ID + "].leftEnd()")) } }; if (this.dotListId) { this.dotListObj = djt.$(this.dotListId); if (this.dotListObj) { var pages = Math.round(this.listDiv01.offsetWidth / this.frameWidth + 0.4), i, tempObj; for (i = 0; i < pages; i++) { tempObj = document.createElement("span"); this.dotListObj.appendChild(tempObj); this.dotObjArr.push(tempObj); if (i == this.pageIndex) { tempObj.className = this.dotClassName } else { tempObj.className = this.dotOnClassName }; tempObj.title = "第" + (i + 1) + "页"; djt.addEvent(tempObj, "click", Function("ScrollPicleft.childs[" + this.ID + "].pageTo(" + i + ")")) } } }; if (this.autoPlay) { this.play() }
    }; this.leftMouseDown = function () { if (_state != "ready") { return }; _state = "floating"; _scrollTimeObj = setInterval("ScrollPicleft.childs[" + this.ID + "].moveLeft()", this.speed) }; this.rightMouseDown = function () { if (_state != "ready") { return }; _state = "floating"; _scrollTimeObj = setInterval("ScrollPicleft.childs[" + this.ID + "].moveRight()", this.speed) }; this.moveLeft = function () { if (this.scrollContDiv.scrollLeft + this.space >= this.listDiv01.scrollWidth) { this.scrollContDiv.scrollLeft = this.scrollContDiv.scrollLeft + this.space - this.listDiv01.scrollWidth } else { this.scrollContDiv.scrollLeft += this.space }; this.accountPageIndex() }; this.moveRight = function () { if (this.scrollContDiv.scrollLeft - this.space <= 0) { this.scrollContDiv.scrollLeft = this.listDiv01.scrollWidth + this.scrollContDiv.scrollLeft - this.space } else { this.scrollContDiv.scrollLeft -= this.space }; this.accountPageIndex() }; this.leftEnd = function () { if (_state != "floating") { return }; _state = "stoping"; clearInterval(_scrollTimeObj); var fill = this.pageWidth - this.scrollContDiv.scrollLeft % this.pageWidth; this.move(fill) }; this.rightEnd = function () { if (_state != "floating") { return }; _state = "stoping"; clearInterval(_scrollTimeObj); var fill = -this.scrollContDiv.scrollLeft % this.pageWidth; this.move(fill) }; this.move = function (num, quick) { var thisMove = num / 5; if (!quick) { if (thisMove > this.space) { thisMove = this.space }; if (thisMove < -this.space) { thisMove = -this.space } }; if (Math.abs(thisMove) < 1 && thisMove != 0) { thisMove = thisMove >= 0 ? 1 : -1 } else { thisMove = Math.round(thisMove) }; var temp = this.scrollContDiv.scrollLeft + thisMove; if (thisMove > 0) { if (this.scrollContDiv.scrollLeft + thisMove >= this.listDiv01.scrollWidth) { this.scrollContDiv.scrollLeft = this.scrollContDiv.scrollLeft + thisMove - this.listDiv01.scrollWidth } else { this.scrollContDiv.scrollLeft += thisMove } } else { if (this.scrollContDiv.scrollLeft - thisMove <= 0) { this.scrollContDiv.scrollLeft = this.listDiv01.scrollWidth + this.scrollContDiv.scrollLeft - thisMove } else { this.scrollContDiv.scrollLeft += thisMove } }; num -= thisMove; if (Math.abs(num) == 0) { _state = "ready"; if (this.autoPlay) { this.play() }; this.accountPageIndex(); return } else { this.accountPageIndex(); setTimeout("ScrollPicleft.childs[" + this.ID + "].move(" + num + "," + quick + ")", this.speed) } }; this.next = function () { if (_state != "ready") { return }; _state = "stoping"; this.move(this.pageWidth, true) }; this.play = function () { if (!this.autoPlay) { return }; clearInterval(_autoTimeObj); _autoTimeObj = setInterval("ScrollPicleft.childs[" + this.ID + "].next()", this.autoPlayTime * 1000) }; this.stop = function () { clearInterval(_autoTimeObj) }; this.pageTo = function (num) { if (_state != "ready") { return }; _state = "stoping"; var fill = num * this.frameWidth - this.scrollContDiv.scrollLeft; this.move(fill, true) }; this.accountPageIndex = function () { this.pageIndex = Math.round(this.scrollContDiv.scrollLeft / this.frameWidth); if (this.pageIndex > Math.round(this.listDiv01.offsetWidth / this.frameWidth + 0.4) - 1) { this.pageIndex = 0 }; var i; for (i = 0; i < this.dotObjArr.length; i++) { if (i == this.pageIndex) { this.dotObjArr[i].className = this.dotClassName } else { this.dotObjArr[i].className = this.dotOnClassName } } }
    this.initialize();
};

function ScrollPicleft(scrollContId, arrLeftId, arrRightId,pageWidth,frameWidth) {
    this.scrollContId = scrollContId;
    this.arrLeftId = arrLeftId;
    this.arrRightId = arrRightId;
    this.dotListId = 1;
    this.dotClassName = "dotItem";
    this.dotOnClassName = "dotItemOn";
    this.dotObjArr = [];
    this.pageWidth = pageWidth;
    this.frameWidth = frameWidth;
    this.speed = 10;
    this.space = 10;
    this.pageIndex = 0;
    this.autoPlay = true;
    this.autoPlayTime = 3;
    var _autoTimeObj, _scrollTimeObj, _state = "ready";
    this.stripDiv = document.createElement("DIV");
    this.listDiv01 = document.createElement("DIV");
    this.listDiv02 = document.createElement("DIV");
    if (!ScrollPicleft.childs) {
        ScrollPicleft.childs = []
    };
    this.ID = ScrollPicleft.childs.length;
    ScrollPicleft.childs.push(this);
    this.initialize = function () {
        if (!this.scrollContId) {
            throw new Error("必须指定scrollContId.");
            return
        };
        this.scrollContDiv = djt.$(this.scrollContId);
        if (!this.scrollContDiv) {
            throw new Error("scrollContId不是正确的对象.(scrollContId = \"" + this.scrollContId + "\")");
            return
        };
        this.scrollContDiv.style.width = this.frameWidth + "px";
        this.scrollContDiv.style.overflow = "hidden";
        this.listDiv01.innerHTML = this.listDiv02.innerHTML = this.scrollContDiv.innerHTML;
        this.scrollContDiv.innerHTML = "";
        this.scrollContDiv.appendChild(this.stripDiv);
        this.stripDiv.appendChild(this.listDiv01);
        this.stripDiv.appendChild(this.listDiv02);
        this.stripDiv.style.overflow = "hidden";
        this.stripDiv.style.zoom = "1";
        this.stripDiv.style.width = "32766px";
        var isIE = navigator.userAgent.toUpperCase().indexOf("MSIE") == -1 ? false : true;
        if (isIE) {
            this.listDiv01.style.styleFloat = "left";
            this.listDiv02.style.styleFloat = "left";
        } else {
            this.listDiv01.style.cssFloat = "left";
            this.listDiv02.style.cssFloat = "left";
        }
        djt.addEvent(this.scrollContDiv, "mouseover", Function("ScrollPicleft.childs[" + this.ID + "].stop()"));
        djt.addEvent(this.scrollContDiv, "mouseout", Function("ScrollPicleft.childs[" + this.ID + "].play()"));
        if (this.arrLeftId) {
            this.arrLeftObj = djt.$(this.arrLeftId);
            if (this.arrLeftObj) {
                djt.addEvent(this.arrLeftObj, "mousedown", Function("ScrollPicleft.childs[" + this.ID + "].rightMouseDown()"));
                djt.addEvent(this.arrLeftObj, "mouseup", Function("ScrollPicleft.childs[" + this.ID + "].rightEnd()"));
                djt.addEvent(this.arrLeftObj, "mouseout", Function("ScrollPicleft.childs[" + this.ID + "].rightEnd()"))
            }
        };
        if (this.arrRightId) {
            this.arrRightObj = djt.$(this.arrRightId);
            if (this.arrRightObj) {
                djt.addEvent(this.arrRightObj, "mousedown", Function("ScrollPicleft.childs[" + this.ID + "].leftMouseDown()"));
                djt.addEvent(this.arrRightObj, "mouseup", Function("ScrollPicleft.childs[" + this.ID + "].leftEnd()"));
                djt.addEvent(this.arrRightObj, "mouseout", Function("ScrollPicleft.childs[" + this.ID + "].leftEnd()"))
            }
        };
        if (this.dotListId) {
            this.dotListObj = djt.$(this.dotListId);
            if (this.dotListObj) {
                var pages = Math.round(this.listDiv01.offsetWidth / this.frameWidth + 0.4),
					i, tempObj;
                for (i = 0; i < pages; i++) {
                    tempObj = document.createElement("span");
                    this.dotListObj.appendChild(tempObj);
                    this.dotObjArr.push(tempObj);
                    if (i == this.pageIndex) {
                        tempObj.className = this.dotClassName
                    } else {
                        tempObj.className = this.dotOnClassName
                    };
                    tempObj.title = "第" + (i + 1) + "页";
                    djt.addEvent(tempObj, "click", Function("ScrollPicleft.childs[" + this.ID + "].pageTo(" + i + ")"))
                }
            }
        };
        if (this.autoPlay) {
            this.play()
        }
    };
    this.leftMouseDown = function () {
        if (_state != "ready") {
            return
        };
        _state = "floating";
        _scrollTimeObj = setInterval("ScrollPicleft.childs[" + this.ID + "].moveLeft()", this.speed)
    };
    this.rightMouseDown = function () {
        if (_state != "ready") {
            return
        };
        _state = "floating";
        _scrollTimeObj = setInterval("ScrollPicleft.childs[" + this.ID + "].moveRight()", this.speed)
    };
    this.moveLeft = function () {
        if (this.scrollContDiv.scrollLeft + this.space >= this.listDiv01.scrollWidth) {
            this.scrollContDiv.scrollLeft = this.scrollContDiv.scrollLeft + this.space - this.listDiv01.scrollWidth
        } else {
            this.scrollContDiv.scrollLeft += this.space
        };
        this.accountPageIndex()
    };
    this.moveRight = function () {
        if (this.scrollContDiv.scrollLeft - this.space <= 0) {
            this.scrollContDiv.scrollLeft = this.listDiv01.scrollWidth + this.scrollContDiv.scrollLeft - this.space
        } else {
            this.scrollContDiv.scrollLeft -= this.space
        };
        this.accountPageIndex()
    };
    this.leftEnd = function () {
        if (_state != "floating") {
            return
        };
        _state = "stoping";
        clearInterval(_scrollTimeObj);
        var fill = this.pageWidth - this.scrollContDiv.scrollLeft % this.pageWidth;
        this.move(fill)
    };
    this.rightEnd = function () {
        if (_state != "floating") {
            return
        };
        _state = "stoping";
        clearInterval(_scrollTimeObj);
        var fill = -this.scrollContDiv.scrollLeft % this.pageWidth;
        this.move(fill)
    };
    this.move = function (num, quick) {
        var thisMove = num / 5;
        if (!quick) {
            if (thisMove > this.space) {
                thisMove = this.space
            };
            if (thisMove < -this.space) {
                thisMove = -this.space
            }
        };
        if (Math.abs(thisMove) < 1 && thisMove != 0) {
            thisMove = thisMove >= 0 ? 1 : -1
        } else {
            thisMove = Math.round(thisMove)
        };
        var temp = this.scrollContDiv.scrollLeft + thisMove;
        if (thisMove > 0) {
            if (this.scrollContDiv.scrollLeft + thisMove >= this.listDiv01.scrollWidth) {
                this.scrollContDiv.scrollLeft = this.scrollContDiv.scrollLeft + thisMove - this.listDiv01.scrollWidth
            } else {
                this.scrollContDiv.scrollLeft += thisMove
            }
        } else {
            if (this.scrollContDiv.scrollLeft - thisMove <= 0) {
                this.scrollContDiv.scrollLeft = this.listDiv01.scrollWidth + this.scrollContDiv.scrollLeft - thisMove
            } else {
                this.scrollContDiv.scrollLeft += thisMove
            }
        };
        num -= thisMove;
        if (Math.abs(num) == 0) {
            _state = "ready";
            if (this.autoPlay) {
                this.play()
            };
            this.accountPageIndex();
            return
        } else {
            this.accountPageIndex();
            setTimeout("ScrollPicleft.childs[" + this.ID + "].move(" + num + "," + quick + ")", this.speed)
        }
    };
    this.next = function () {
        if (_state != "ready") {
            return
        };
        _state = "stoping";
        this.move(this.pageWidth, true)
    };
    this.play = function () {
        if (!this.autoPlay) {
            return
        };
        clearInterval(_autoTimeObj);
        _autoTimeObj = setInterval("ScrollPicleft.childs[" + this.ID + "].next()", this.autoPlayTime * 1000)
    };
    this.stop = function () {
        clearInterval(_autoTimeObj)
    };
    this.pageTo = function (num) {
        if (_state != "ready") {
            return
        };
        _state = "stoping";
        var fill = num * this.frameWidth - this.scrollContDiv.scrollLeft;
        this.move(fill, true)
    };
    this.accountPageIndex = function () {
        this.pageIndex = Math.round(this.scrollContDiv.scrollLeft / this.frameWidth);
        if (this.pageIndex > Math.round(this.listDiv01.offsetWidth / this.frameWidth + 0.4) - 1) {
            this.pageIndex = 0
        };
        var i;
        for (i = 0; i < this.dotObjArr.length; i++) {
            if (i == this.pageIndex) {
                this.dotObjArr[i].className = this.dotClassName
            } else {
                this.dotObjArr[i].className = this.dotOnClassName
            }
        }
    }
    this.initialize();
};
