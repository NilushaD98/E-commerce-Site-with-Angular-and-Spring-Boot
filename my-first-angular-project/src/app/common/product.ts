export class Product {
    constructor(
        public productID:number,
        public sku: string,
        public name: string,
        public description: string,
        public unitPrice: number,
        public imageURL: string,
        public active: boolean,
        public unitInStock: number,
        public dateCerated: Date,
        public lastUpdated: Date,

    ){

    }
}
