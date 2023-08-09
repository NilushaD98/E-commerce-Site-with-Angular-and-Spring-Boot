
import { shape } from "./Shapes";

export class Circle extends shape{

    constructor(theX: number, theY: number, private _radius: number){

        super(theX,theY);
    }
    public get radius(): number{
        return this._radius;
    }
    public set radius(value: number){
        this._radius = value
    }

    getInfo(): string {
        return super.getinfo() + `radius = ${this._radius}`;
    }
}