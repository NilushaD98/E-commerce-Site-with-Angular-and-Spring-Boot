class prmtr_prprts{
    //parameter constructor for clean code
    constructor(private _name: string, private _address: string){

    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    
    public get address(): string {
        return this._address;
    }
    public set address(value: string) {
        this._address = value;
    }

    // nothing but only declare the variables in constructor 
}