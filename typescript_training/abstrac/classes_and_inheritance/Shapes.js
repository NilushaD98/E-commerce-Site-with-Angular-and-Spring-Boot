"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.shape = void 0;
var shape = /** @class */ (function () {
    function shape(_x, _y) {
        this._x = _x;
        this._y = _y;
    }
    Object.defineProperty(shape.prototype, "getX", {
        get: function () {
            return this._x;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(shape.prototype, "setX", {
        set: function (value) {
            this._x = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(shape.prototype, "getY", {
        get: function () {
            return this._y;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(shape.prototype, "setY", {
        set: function (value) {
            this._y = value;
        },
        enumerable: false,
        configurable: true
    });
    shape.prototype.getinfo = function () {
        return "x= ".concat(this._x, ",y= ").concat(this._y);
    };
    return shape;
}());
exports.shape = shape;
