/*!
 *@作者：  赵玉
 *@邮箱：  sailiy@126.com
 *@公司：  彩虹世纪文化传媒有限公司
 *@项目：  jquery.barrager.js
 */
(function ($) {
    function Barrager($canvas) {
        this.canvas = $canvas.get(0);
        this.ctx = this.canvas.getContext("2d");
        this.msgs = new Array(300);
        this.width = $canvas.width();
        this.height = $canvas.height();
        this.font = "30px 黑体";
        this.canvas.width = this.width;
        this.canvas.height = this.height;
        this.ctx.font = this.font;
        this.colorArr = ["Olive", "OliveDrab", "Orange", "OrangeRed", "Orchid", "PaleGoldenRod", "PaleGreen", "PaleTurquoise", "PaleVioletRed", "PapayaWhip", "PeachPuff", "Peru", "Pink", "Plum", "PowderBlue", "Purple", "Red", "RosyBrown", "RoyalBlue", "SaddleBrown", "Salmon", "SandyBrown", "SeaGreen", "SeaShell", "Sienna", "Silver", "SkyBlue"];
        this.interval = "";
        this.intervalTimeout = 10;

        this.draw = function () {
            if (this.interval) {
                return;
            }

            var _this = this;
            this.interval = setInterval(function () {
                _this.ctx.clearRect(0, 0, _this.width, _this.height);
                //_this.ctx.save();
                for (var i = 0; i < _this.msgs.length; i++) {
                    if (_this.msgs[i]) {
                        if (!_this.msgs[i].X) {
                            /**
                             * X：x坐标
                             * Y：y坐标
                             * S：左偏移
                             * C：颜色
                             */
                            _this.msgs[i].X = _this.width;
                            _this.msgs[i].Y = parseInt(Math.random() * _this.height);
                            _this.msgs[i].S = parseInt(Math.random() * 4 + 4);
                            _this.msgs[i].C = _this.colorArr[Math.floor(Math.random() * _this.colorArr.length)];
                        } else {
                            if (_this.msgs[i].X < -200) {
                                _this.msgs[i] = null;
                            } else {
                                _this.msgs[i].X = parseInt(_this.msgs[i].X - _this.msgs[i].S);
                                _this.ctx.fillStyle = _this.msgs[i].C;
                                _this.ctx.fillText(_this.msgs[i].msg, _this.msgs[i].X, _this.msgs[i].Y);
                                //_this.ctx.restore();
                            }
                        }
                    }
                }
            }, _this.intervalTimeout);
        };

        /**
         * 增加弹幕数据
         *
         * @param datas
         */
        this.putMsg = function (datas) {
            for (var j = 0; j < datas.length; j++) {
                for (var i = 0; i < this.msgs.length; i++) {
                    if (!this.msgs[i]) {
                        this.msgs[i] = datas[j];
                        break;
                    }
                }
            }
            this.draw();
        };

        /**
         * 清空
         */
        this.clear = function () {
            clearInterval(this.interval);
            this.interval = "";
            this.ctx.clearRect(0, 0, this.width, this.height);
            this.ctx.save();
            for (var i = 0; i < this.msgs.length; i++) {
                this.msgs[i] = null;
            }
        };
    }

    $.fn.barrager = function (param) {
        if (typeof (param) == "string") {
            try {
                var api = $(this).data('barrager_api');
                api[param].apply(api);
            } catch (e) {
            }
        } else if (typeof param == 'object' || !param) {
            $this = $(this);
            if ($this.data('barrager_api') != null && $this.data('barrager_api') != '') {
                var api = $this.data('barrager_api');
                api.putMsg(param);
            } else {
                var api = new Barrager($this);
                $this.data('barrager_api', api);
                api.putMsg(param);
            }
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.barrager');
        }
        return this;
    }
})(jQuery);