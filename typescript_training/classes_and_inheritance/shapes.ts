export class shape{

    constructor(private _x: number, private _y: number ){

    }
    public get getX(): number {
        return this._x;
    }
    public set setX(value: number) {
        this._x = value;
    }
    
    public get getY(): number {
        return this._y;
    }
    public set setY(value: number) {
        this._y = value;
    }
    getinfo(): string{
        return `x= ${this._x},y= ${this._y}`;
    }

    
}