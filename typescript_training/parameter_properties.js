var prmtr_prprts = /** @class */ (function () {
    //parameter constructor for clean code
    function prmtr_prprts(_name, _address) {
        this._name = _name;
        this._address = _address;
    }
    Object.defineProperty(prmtr_prprts.prototype, "name", {
        get: function () {
            return this._name;
        },
        set: function (value) {
            this._name = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(prmtr_prprts.prototype, "address", {
        get: function () {
            return this._address;
        },
        set: function (value) {
            this._address = value;
        },
        enumerable: false,
        configurable: true
    });
    return prmtr_prprts;
}());
